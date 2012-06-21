package org.half.dungeon.doors;

import org.half.dungeon.items.Key;
import org.half.dungeon.rooms.Room;

public class KeyDoor extends Door
{
    private final Key _key;

    /**
     * Creates a skill door object.
     *
     * @param room The room where this door is.
     * @param key  The key needed to open this door.
     */
    public KeyDoor(Room room, Key key)
    {
        super(room);
        _key = key;
    }

    /**
     * Gets this door skill.
     */
    public Key getKey()
    {
        return _key;
    }
}
