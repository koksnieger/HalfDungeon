package org.half.dungeon.rooms;

import org.half.dungeon.doors.Door;
import org.powerbot.game.api.wrappers.Tile;

import java.awt.*;

public class FollowTheLeaderPuzzleRoom extends PuzzleRoom
{
    protected FollowTheLeaderPuzzleRoom(Tile northwestTile, Tile southeastTile, Point coordinates, Door[] doors)
    {
        super(northwestTile, southeastTile, coordinates, doors);
    }
}
