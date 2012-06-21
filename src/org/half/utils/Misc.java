package org.half.utils;

import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.wrappers.Tile;

public class Misc
{
    public static int getCollisionFlagAtTile(Tile tile)
    {
        int gamePlane = Game.getPlane();
        int[][] flags = Walking.getCollisionFlags(gamePlane);
        int x = tile.getX();
        int y = tile.getY();
        int xOff = x - Game.getBaseX() - Walking.getCollisionOffset(gamePlane).getX();
        int yOff = y - Game.getBaseY() - Walking.getCollisionOffset(gamePlane).getY();
        return flags[xOff][yOff];
    }
}
