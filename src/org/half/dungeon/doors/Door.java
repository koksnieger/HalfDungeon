package org.half.dungeon.doors;

import org.half.dungeon.rooms.Room;

public class Door
{
    private final Room _room;
    private Room _destinationRoom;

    /**
     * Creates a door object.
     *
     * @param room The room where this door is.
     */
    public Door(Room room)
    {
        _room = room;
    }

    /**
     * Gets the room where this door is.
     */
    public Room getRoom()
    {
        return _room;
    }

    /**
     * Gets the room that this door leads to.
     */
    public Room getDestinationRoom()
    {
        return _destinationRoom;
    }

    /**
     * Sets the room that this door leads to.
     */
    public void setDestinationRoom(Room destinationRoom)
    {
        _destinationRoom = destinationRoom;
    }
}
