package org.half.dungeon.rooms;

import org.half.dungeon.Dungeon;
import org.half.dungeon.doors.BossDoor;
import org.half.dungeon.doors.Door;
import org.half.dungeon.doors.PuzzleDoor;
import org.half.utils.Misc;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Room extends Area
{
    private final static BasicStroke GFX_STROKE = new BasicStroke(2.0f);

    private final Door[] _doors;
    private final Point _coordinates;

    protected Room(final Rectangle bounds, final Point coordinates, final Door[] doors)
    {
        super(new RoomTile(bounds.x, bounds.y), new RoomTile(bounds.x + bounds.width, bounds.y + bounds.height));
        _coordinates = coordinates;
        _doors = doors;
    }

    /**
     * Gets this room relative coordinates to home room.
     *
     * @return This room relative coordinates to home room.
     */
    public Point getCoordinates()
    {
        return _coordinates;
    }

    /**
     * Gets this room doors.
     *
     * @return This room doors.
     */
    public Door[] getDoors()
    {
        return _doors;
    }

    /**
     * Draw this room on the game mini map.
     *
     * @param g The graphics surface to draw on.
     */
    public void drawOnMiniMap(Graphics2D g)
    {
        Stroke oldStroke = g.getStroke();

        // draw room on mini map
        Rectangle bounds = getBounds();
        Point northwestMapPoint = Misc.worldToMap(bounds.x - 1, bounds.y - 1);
        Point northeastMapPoint = Misc.worldToMap(bounds.x + bounds.width, bounds.y - 1);
        Point southeastMapPoint = Misc.worldToMap(bounds.x + bounds.width, bounds.y + bounds.height);
        Point southwestMapPoint = Misc.worldToMap(bounds.x - 1, bounds.y + bounds.height);

        Polygon p = new Polygon();
        p.addPoint(northwestMapPoint.x, northwestMapPoint.y);
        p.addPoint(northeastMapPoint.x, northeastMapPoint.y);
        p.addPoint(southeastMapPoint.x, southeastMapPoint.y);
        p.addPoint(southwestMapPoint.x, southwestMapPoint.y);

        g.setColor(new Color(255, 255, 255, 102));
        g.fillPolygon(p);

        g.setColor(new Color(255, 255, 255, 204));
        g.setStroke(GFX_STROKE);
        g.drawPolygon(p);

        g.setStroke(oldStroke);
    }

    @Override
    public String toString()
    {
        return "Room (" + _coordinates.x + ", " + _coordinates.y + ")";
    }

    public static Room createRoomFromTile(Tile knownTile)
    {
        Rectangle bounds = null;
        final Point coordinates = new Point(0, 0);

        // Find this room area.
        final Room homeRoom = Dungeon.homeRoom();
        if (homeRoom != null)
        {
            // if we know the home room boundaries, then we can map the whole dungeon
            // (this is a lot faster than flood filling)
            final Rectangle homeRoomBounds = homeRoom.getBounds();
            for (int x = homeRoomBounds.x - 112; x <= homeRoomBounds.x + 112; x += 16)
            {
                for (int y = homeRoomBounds.y - 112; y <= homeRoomBounds.y + 122; y += 16)
                {
                    Rectangle tempBounds = new Rectangle(x, y, 14, 14);
                    if (tempBounds.contains(knownTile.getX(), knownTile.getY()))
                    {
                        bounds = tempBounds;
                        coordinates.setLocation((x - homeRoomBounds.x) / 16, (homeRoomBounds.y - y) / 16);
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

            bounds = new Rectangle(min.x, min.y, 14, 14);
        }

        // Create the doors in this new area.
        Door[] doors = {
                Door.createFromObject(0, SceneEntities.getAt(bounds.x + 7, bounds.y + 14, SceneEntities.TYPE_INTERACTIVE)), // north
                Door.createFromObject(1, SceneEntities.getAt(bounds.x + 14, bounds.y + 7, SceneEntities.TYPE_INTERACTIVE)), // east
                Door.createFromObject(2, SceneEntities.getAt(bounds.x + 7, bounds.y - 1, SceneEntities.TYPE_INTERACTIVE)),  // south
                Door.createFromObject(3, SceneEntities.getAt(bounds.x - 1, bounds.y + 7, SceneEntities.TYPE_INTERACTIVE))   // west
        };

        // Create the proper room object.
        if (coordinates.x == 0 && coordinates.y == 0)
        {
            return new HomeRoom(bounds, coordinates, doors);
        }

        for (Door door : doors)
        {
            if (door instanceof BossDoor)
            {
                // TODO: add boss detection
                return new BossRoom(bounds, coordinates, doors);
            }
            else if (door instanceof PuzzleDoor)
            {
                // TODO: add puzzle detection
                return new PuzzleRoom(bounds, coordinates, doors);
            }
        }

        return new Room(bounds, coordinates, doors);
    }
}
