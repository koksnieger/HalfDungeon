package org.half.dungeon.rooms;

import org.half.dungeon.doors.Door;
import org.powerbot.game.api.wrappers.Tile;

import java.awt.*;

public class MercenaryLeaderPuzzleRoom extends PuzzleRoom
{
    protected MercenaryLeaderPuzzleRoom(Tile northwestTile, Tile southeastTile, Point coordinates, Door[] doors)
    {
        super(northwestTile, southeastTile, coordinates, doors);
    }
}
