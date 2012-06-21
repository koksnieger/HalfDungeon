package org.half.dungeon.rooms;

import org.half.dungeon.doors.Door;
import org.half.utils.Misc;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Room
{
    private Area _area;
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

        // add these
        _area = new Area(_tiles.toArray(new Tile[_tiles.size()]));

        System.out.println("Room tiles: " + _tiles.size());
        System.out.println("Room area tiles: " + _area.getTileArray().length);
    }

    /**
     * Gets this room doors.
     */
    public Door[] getDoors()
    {
        return _doors;
    }

    public void drawRoom(Graphics g, Color color)
    {
        Color oldColor = g.getColor();
        g.setColor(color);

        Polygon mapArea = new Polygon();
        for (Tile tile : _tiles)
        {
            tile.draw(g);

            Point mp = tile.getMapPoint();
            mapArea.addPoint(mp.x, mp.y);
        }
        for (int i = 0; i < mapArea.xpoints.length; i++)
        {
            g.fillRect(mapArea.xpoints[i], mapArea.ypoints[i], 4, 4);
        }

        g.setColor(oldColor);
    }
}
