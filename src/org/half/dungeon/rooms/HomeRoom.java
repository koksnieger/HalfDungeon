package org.half.dungeon.rooms;

import org.half.dungeon.doors.Door;

import java.awt.*;

public class HomeRoom extends Room
{
    protected HomeRoom(final Rectangle bounds, final Point coordinates, final Door[] doors)
    {
        super(bounds, coordinates, doors);
    }

    @Override
    public String toString()
    {
        return "Home " + super.toString();
    }
}
