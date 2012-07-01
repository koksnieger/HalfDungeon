package org.half.dungeon.rooms;

import org.half.dungeon.doors.Door;

import java.awt.*;

public class BossRoom extends Room
{
    protected BossRoom(final Rectangle bounds, final Point coordinates, final Door[] doors)
    {
        super(bounds, coordinates, doors);
    }

    @Override
    public String toString()
    {
        return "Boss " + super.toString();
    }
}
