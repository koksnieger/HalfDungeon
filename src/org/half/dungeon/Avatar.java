package org.half.dungeon;

import org.half.dungeon.rooms.Room;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Tile;

/**
 * Thread safe 'class' to hold some of the avatar properties.
 */
public enum Avatar
{
    SINGLETON;

    private static Room _currentRoom;

    public static Room getCurrentRoom()
    {
        return _currentRoom;
    }

    public static void setCurrentRoom(Room room)
    {
        _currentRoom = room;
    }

    public static Tile getLocation()
    {
        return Players.getLocal().getLocation();
    }

    public static Room findRoom()
    {
        Tile avatarLocation = Avatar.getLocation();
        for (Room room : Dungeon.rooms())
        {
            if (room.contains(avatarLocation))
            {
                return room;
            }
        }
        return null;
    }
}
