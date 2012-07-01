package org.half.dungeon.rooms;

import org.half.dungeon.doors.Door;
import org.powerbot.game.api.wrappers.Tile;

import java.awt.*;

public class HomeRoom extends Room
{
    protected HomeRoom(Tile northwestTile, Tile southeastTile, Point coordinates, Door[] doors)
    {
        super(northwestTile, southeastTile, coordinates, doors);
    }

    @Override
    public String toString()
    {
        return "Home " + super.toString();
    }
}
