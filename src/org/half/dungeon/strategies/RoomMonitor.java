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

import java.awt.*;

/**
 * Strategy that actively monitor room changes.
 * It also updates avatar current room.
 * This is where the dungeon gets mapped.
 */
public class RoomMonitor extends Strategy implements Task
{
    @Override
    public boolean validate()
    {
        return Game.getClientState() == 11 // client must be loaded and not busy
                && Dungeon.inside();       // must be inside of the dungeon
    }

    @Override
    public void run()
    {
        // Save avatar current room and location.
        final Tile avatarLocation = Avatar.location();
        final Room avatarRoom = Avatar.room();

        // Check if the avatar already had a room.
        if (avatarRoom == null)
        {
            // Looks like this is the first room, so add it.
            final Room room = Room.createRoomFromTile(avatarLocation);
            Dungeon.rooms().add(room);
            Avatar.setRoom(room);
            return;
        }

        // Check if the avatar switched rooms.
        if (!avatarRoom.contains(avatarLocation))
        {
            // Update the room where the avatar is.
            Avatar.setRoom(Dungeon.getRoomFromTile(avatarLocation));
            return;
        }

        // Find possible neighbour rooms of current one.
        // (for there is no need to enter dead rooms to map them)
        final Rectangle roomBounds = avatarRoom.getBounds();
        final RoomTile[] neighbourTiles = {
                new RoomTile(roomBounds.x + 7, roomBounds.y + 16), // north
                new RoomTile(roomBounds.x + 16, roomBounds.y + 7), // east
                new RoomTile(roomBounds.x + 7, roomBounds.y - 3),  // south
                new RoomTile(roomBounds.x - 3, roomBounds.y + 7)   // west
        };
        for (int i = 0; i < 4; i++)
        {
            RoomTile tile = neighbourTiles[i];

            // Check if this tile isn't blocked and there isn't a mapped room containing it.
            if ((tile.getCollisionFlags() & RoomTile.FLAG_DUNGEON_BLOCK) == 0 && Dungeon.getRoomFromTile(tile) == null)
            {
                // This room isn't mapped, so map it.
                final Room room = Room.createRoomFromTile(tile);
                Dungeon.rooms().add(room);

                // If we can see this room, then the doors between rooms are open.
                final Door avatarRoomDoor = avatarRoom.getDoors()[i];
                final Door symmetricRoomDoor = room.getDoors()[(i + 2) % 4];
                if (avatarRoomDoor != null && symmetricRoomDoor != null)
                {
                    avatarRoomDoor.open();
                    symmetricRoomDoor.open();
                }

                return;
            }
        }
    }
}
