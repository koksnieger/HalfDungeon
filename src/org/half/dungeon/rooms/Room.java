package org.half.dungeon.rooms;

import org.half.dungeon.Dungeon;
import org.half.dungeon.doors.Door;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Room extends Area
{
    private Door[] _doors;
    private final Point _coordinates = new Point(0, 0);

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
     * @param knownTile Starting tile to flood fill.
     */
    public Room(Tile knownTile)
    {
        plane = knownTile.getPlane();

        final Room homeRoom = Dungeon.getHomeRoom();
        if (homeRoom != null)
        {
            // if we know the home room boundaries, then we can map the whole dungeon
            // (this is a lot faster than flood filling)
            final Rectangle homeRoomBounds = homeRoom.getBounds();
            for (int x = homeRoomBounds.x - 112; x <= homeRoomBounds.x + 112; x += 16)
            {
                for (int y = homeRoomBounds.y - 112; y <= homeRoomBounds.y + 122; y += 16)
                {
                    final Area area = new Area(new RoomTile(x, y), new RoomTile(x + 14, y + 14));
                    if (area.contains(knownTile))
                    {
                        final Rectangle areaBounds = area.getBounds();
                        addTile(areaBounds.x, areaBounds.y);
                        addTile(areaBounds.x + areaBounds.width, areaBounds.y);
                        addTile(areaBounds.x + areaBounds.width, areaBounds.y + areaBounds.height);
                        addTile(areaBounds.x, areaBounds.y + areaBounds.height);

                        _coordinates.setLocation((x - homeRoomBounds.x) / 16, (homeRoomBounds.y - y) / 16);
                        break;
                    }
                }
            }
        }
        else
        {
            // flood fill this room from player location
            final ArrayList<RoomTile> roomTiles = new ArrayList<RoomTile>(196);
            final Stack<RoomTile> tileStack = new Stack<RoomTile>();

            tileStack.push(new RoomTile(knownTile.getX(), knownTile.getY()));
            while (!tileStack.empty())
            {
                final RoomTile tile = tileStack.pop();
                if (!roomTiles.contains(tile) && !tile.hasWallAndIsUnreachable())
                {
                    roomTiles.add(tile);

                    // add neighbour tiles to the checking queue
                    final int x = tile.getX();
                    final int y = tile.getY();

                    tileStack.push(new RoomTile(x, y + 1)); // north
                    tileStack.push(new RoomTile(x + 1, y)); // east
                    tileStack.push(new RoomTile(x, y - 1)); // south
                    tileStack.push(new RoomTile(x - 1, y)); // west
                }
            }

            // sets a square area for this room
            final Point min = new Point(knownTile.getX(), knownTile.getY());
            for (RoomTile tile : roomTiles)
            {
                final int x = tile.getX();
                if (x < min.x)
                {
                    min.x = x;
                }

                final int y = tile.getY();
                if (y < min.y)
                {
                    min.y = y;
                }
            }

            addTile(min.x, min.y);
            addTile(min.x + 14, min.y);
            addTile(min.x + 14, min.y + 14);
            addTile(min.x, min.y + 14);
        }

        System.out.println("New room at " + _coordinates.x + ", " + _coordinates.y + " with " + getTileArray().length + " tiles.");
    }

    public Point getCoordinates()
    {
        return _coordinates;
    }

    public void draw(Graphics2D g)
    {
        Color walkableColor = new Color(255, 255, 255, 70);
        Color nonWalkableColor = new Color(255, 0, 0, 90);

        for (Tile tile : getTileArray())
        {
            g.setColor(tile.canReach() ? walkableColor : nonWalkableColor);

            tile.draw(g);

            Point mp = tile.getMapPoint();
            g.fillRect(mp.x, mp.y, 4, 4);
        }
    }
}
