package org.half.dungeon;

import org.half.dungeon.rooms.HomeRoom;
import org.half.dungeon.rooms.Room;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.wrappers.Tile;

import java.util.ArrayList;

/**
 * Thread safe 'class' to hold some of the dungeon properties.
 */
public enum Dungeon
{
    SINGLETON;

    // Dungeon types:
    public static final int UNKNOWN = 0;
    public static final int FROZEN = 1;
    public static final int ABANDONED = 2;
    public static final int FURNISHED = 3;

    private static final int WIDGET_DUNGEONEERING_HUD = 945;

    private static final ArrayList<Room> _rooms = new ArrayList<Room>(64);
    private static int _type = UNKNOWN;

    /**
     * Gets this dungeon type.
     *
     * @return UNKNOWN if the dungeon is unknown or hasn't started; the type otherwise.
     */
    public static int type()
    {
        return _type;
    }

    /**
     * Sets this dungeon type.
     *
     * @param type The dungeon type.
     */
    public static void setType(int type)
    {
        _type = type;
    }

    /**
     * Checks if we are inside the dungeon using the dungeoneering overlay widget.
     *
     * @return true if we are inside the dungeon; false otherwise.
     */
    public static boolean inside()
    {
        return Widgets.get(WIDGET_DUNGEONEERING_HUD).validate();
    }

    /**
     * Gets the rooms that were found so far.
     *
     * @return The dungeon rooms.
     */
    public static ArrayList<Room> rooms()
    {
        return _rooms;
    }

    /**
     * Gets this dungeon home room.
     *
     * @return The home room of the dungeon.
     */
    public static HomeRoom homeRoom()
    {
        // The first room is the home room.
        return _rooms.size() == 0 ? null : (HomeRoom) _rooms.get(0);
    }

    /**
     * Gets the room that contains the given tile.
     *
     * @param tile The tile which this room contains.
     * @return The room found or null if there isn't a room.
     */
    public static Room getRoomFromTile(final Tile tile)
    {
        for (final Room room : rooms())
        {
            if (room.contains(tile))
            {
                return room;
            }
        }
        return null;
    }
}
