package org.half.dungeon.rooms;

import org.half.dungeon.doors.Door;

import java.awt.*;

public class PuzzleRoom extends Room
{
    protected PuzzleRoom(final Rectangle bounds, final Point coordinates, final Door[] doors)
    {
        super(bounds, coordinates, doors);
    }

    @Override
    public String toString()
    {
        return "Puzzle " + super.toString();
    }
}
