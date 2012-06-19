package org.half.dungeon.rooms;

import org.half.dungeon.doors.Door;

public abstract class Room
{
    private final Door[] _doors;

    /**
     * Create a room holding the door references.
     */
    public Room(Door[] doors)
    {
        _doors = doors;
    }

    /**
     * Gets this room doors.
     */
    public Door[] getDoors()
    {
        return _doors;
    }
}
