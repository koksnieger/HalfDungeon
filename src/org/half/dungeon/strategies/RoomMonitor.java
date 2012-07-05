package org.half.dungeon.strategies;

import org.half.dungeon.Avatar;
import org.half.dungeon.Dungeon;
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
        return Game.getClientState() != 12 // client can't be loading
                && Dungeon.inside()        // must be inside of the dungeon
                && Avatar.isIdle();        // no need to check for changes while the avatar isn't idle
    }

    @Override
    public void run()
    {
        // Save avatar current room and location.
        final Tile avatarLocation = Avatar.location();
        final Room avatarRoom = Avatar.currentRoom();

        // Check if the avatar already had a room.
        if (avatarRoom == null)
        {
            // Looks like this is the first room, so add it.
            final Room room = Room.createRoomFromTile(avatarLocation);
            Dungeon.rooms().add(room);
            Avatar.setCurrentRoom(room);
            return;
        }

        // Check if the avatar switched rooms.
        if (!avatarRoom.contains(avatarLocation))
        {
            // Update the room where the avatar is.
            Avatar.setCurrentRoom(Dungeon.getRoomFromTile(avatarLocation));
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
        for (final RoomTile tile : neighbourTiles)
        {
            // Check if this tile isn't blocked and there isn't a mapped room containing it.
            if ((tile.getCollisionFlags() & RoomTile.FLAG_DUNGEON_BLOCK) == 0 && Dungeon.getRoomFromTile(tile) == null)
            {
                // This room isn't mapped, so map it.
                final Room room = Room.createRoomFromTile(tile);
                Dungeon.rooms().add(room);
                return;
            }
        }
    }
}
