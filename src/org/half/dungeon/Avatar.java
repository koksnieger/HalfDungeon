package org.half.dungeon;

import org.half.dungeon.rooms.Room;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Tile;

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
}
