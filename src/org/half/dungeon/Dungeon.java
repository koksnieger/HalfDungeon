package org.half.dungeon;

import org.half.dungeon.rooms.Room;
import org.powerbot.game.api.methods.Widgets;

import java.util.ArrayList;

public enum Dungeon
{
    SINGLETON;

    private static final int WIDGET_DUNGEONEERING_HUD = 945;

    private static final ArrayList<Room> _rooms = new ArrayList<Room>(64);
    private static boolean _hasStarted = false;

    public static boolean getHasStarted()
    {
        return _hasStarted;
    }

    public static void setHasStarted(boolean hasStarted)
    {
        _hasStarted = hasStarted;
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
