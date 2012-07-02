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

    /**
     * Gets the avatar current room.
     *
     * @return the avatar current room.
     */
    public static Room currentRoom()
    {
        return _currentRoom;
    }

    /**
     * Sets the avatar current room.
     *
     * @param room The room where the avatar is.
     */
    public static void setCurrentRoom(Room room)
    {
        _currentRoom = room;
    }

    /**
     * Gets the avatar location.
     *
     * @return The avatar location.
     */
    public static Tile location()
    {
        return Players.getLocal().getLocation();
    }

    /**
     * Finds the room where the avatar is.
     *
     * @return The room where the avatar is; null otherwise.
     */
    public static Room findRoom()
    {
        Tile avatarLocation = location();
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
