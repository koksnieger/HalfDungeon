package org.half.dungeon;

import org.half.dungeon.rooms.Room;
import org.powerbot.game.api.methods.Widgets;

import java.util.ArrayList;

public enum Dungeon
{
    SINGLETON;

    private static final int WIDGET_DUNGEONEERING_HUD = 945;

    private static final ArrayList<Room> _rooms = new ArrayList<Room>(64);
    private static Room _homeRoom;

    public static Room getHomeRoom()
    {
        return _homeRoom;
    }

    public static void setHomeRoom(Room startingRoom)
    {
        _homeRoom = startingRoom;
    }

    public static boolean getHasStarted()
    {
        return _homeRoom != null;
    }

    public static boolean inDungeon()
    {
        return Widgets.get(WIDGET_DUNGEONEERING_HUD).validate();
    }

    public static ArrayList<Room> getRooms()
    {
        return _rooms;
    }
}
