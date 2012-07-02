package org.half.dungeon.strategies;

import org.half.dungeon.Avatar;
import org.half.dungeon.Dungeon;
import org.half.dungeon.doors.Door;
import org.half.dungeon.rooms.Room;
import org.half.dungeon.rooms.RoomTile;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.wrappers.Tile;

/**
 * Strategy that actively monitor room changes.
 * It also updates avatar current room.
 * This is where the dungeon gets mapped.
 */
public class RoomMonitor extends Strategy implements Task
{
    private static final int FLAG_BLOCKED = 0x1280100;

    @Override
    public boolean validate()
    {
        return Game.getClientState() != 12 // client can't be loading
                && Dungeon.inside()        // must be inside of the dungeon
                && Avatar.isIdle();        // no need to check for changes while the avatar isn't idle
    }

    @Override
    public void run()
    {
        // Loop through all possible tiles that might be in uncharted rooms.
        final Tile mapBase = Game.getMapBase();
        for (int x = mapBase.getX(); x < mapBase.getX() + 104; x += 14)
        {
            for (int y = mapBase.getY(); y < mapBase.getY() + 104; y += 14)
            {
                // Check if this tile is loaded and isn't blocked.
                final RoomTile tile = new RoomTile(x, y);
                if ((tile.getCollisionFlags() & FLAG_BLOCKED) == 0)
                {
                    // Check if we already mapped this room.
                    Room room = Dungeon.getRoomFromTile(tile);
                    if (room == null)
                    {
                        // This room isn't mapped, so map it.
                        room = Room.createRoomFromTile(tile);
                        Dungeon.rooms().add(room);

                        // Show some debugging output.
                        System.out.println("\nNew " + room);
                        for (final Door door : room.getDoors())
                        {
                            if (door != null)
                            {
                                System.out.println(door);
                            }
                        }
                        System.out.println();

                        // If everything is fine, then we can't really find more rooms in the same iteration.
                        return;
                    }
                    else if (Avatar.currentRoom() != room && room.contains(Avatar.location()))
                    {
                        // Change avatar current room if it moved.
                        Avatar.setCurrentRoom(room);

                        // If the avatar switched to a known room, then everything is mapped already.
                        return;
                    }
                }
            }
        }
    }
}
