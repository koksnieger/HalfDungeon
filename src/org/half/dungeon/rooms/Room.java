package org.half.dungeon.rooms;

import org.half.dungeon.doors.Door;
import org.half.utils.Misc;
import org.powerbot.game.api.wrappers.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Room
{
    private ArrayList<Tile> _tiles;
    private Door[] _doors;

    /**
     * Create a room holding the door references.
     */
    public Room(Door[] doors)
    {
        _doors = doors;
    }

    /**
     * Creates a room from flood filling a tile.
     *
     * @param roomTile Starting tile to flood fill.
     */
    public Room(Tile roomTile)
    {
        _tiles = new ArrayList<Tile>(196);

        // flood fill this room from player location
        Stack<Tile> tileStack = new Stack<Tile>();
        tileStack.push(roomTile);

        while (!tileStack.empty())
        {
            Tile tile = tileStack.pop();
            if (!_tiles.contains(tile) && (Misc.getCollisionFlagAtTile(tile) & 0x200000) == 0)
            {
                _tiles.add(tile);

                // add neighbour tiles to the checking queue
                int x = tile.getX();
                int y = tile.getY();
                int plane = tile.getPlane();

                tileStack.push(new Tile(x, y + 1, plane)); // north
                tileStack.push(new Tile(x + 1, y, plane)); // east
                tileStack.push(new Tile(x, y - 1, plane)); // south
                tileStack.push(new Tile(x - 1, y, plane)); // west
            }
        }

        System.out.println("New room tiles: " + _tiles.size());
    }

    public ArrayList<Tile> getTiles()
    {
        return _tiles;
    }

    public void draw(Graphics2D g)
    {
        Color walkableColor = new Color(255, 255, 255, 70);
        Color nonWalkableColor = new Color(255, 0, 0, 90);

        for (Tile tile : _tiles)
        {
            g.setColor(tile.canReach() ? walkableColor : nonWalkableColor);

            tile.draw(g);

            Point mp = tile.getMapPoint();
            g.fillRect(mp.x, mp.y, 4, 4);
        }
    }
}
