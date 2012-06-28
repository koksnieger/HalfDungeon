package org.half.dungeon.rooms;

import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.wrappers.Tile;

public class RoomTile extends Tile
{
    public static final int FLAG_WALL_DUNGEON = 0x200000;
    public static final int FLAG_WALL_NORTHWEST = 0x1;
    public static final int FLAG_WALL_NORTH = 0x2;
    public static final int FLAG_WALL_NORTHEAST = 0x4;
    public static final int FLAG_WALL_EAST = 0x8;
    public static final int FLAG_WALL_SOUTHEAST = 0x10;
    public static final int FLAG_WALL_SOUTH = 0x20;
    public static final int FLAG_WALL_SOUTHWEST = 0x40;
    public static final int FLAG_WALL_WEST = 0x80;
    public static final int FLAG_WALL = FLAG_WALL_NORTHWEST | FLAG_WALL_NORTH | FLAG_WALL_NORTHEAST | FLAG_WALL_EAST | FLAG_WALL_SOUTHEAST | FLAG_WALL_SOUTH | FLAG_WALL_SOUTHWEST | FLAG_WALL_WEST;

    private final static int _plane = 0;

    public RoomTile(int x, int y)
    {
        super(x, y, _plane);
    }

    public boolean hasWallAndIsUnreachable()
    {
        int collisionFlags = getCollisionFlags();
        return (collisionFlags & FLAG_WALL_DUNGEON) != 0 || (((collisionFlags & FLAG_WALL) != 0) && !canReach());
    }

    public int getCollisionFlags()
    {
        Tile mapBase = Game.getMapBase();
        Tile collisionOffset = Walking.getCollisionOffset(_plane);
        int xOff = this.x - mapBase.getX() - collisionOffset.getX();
        int yOff = this.y - mapBase.getY() - collisionOffset.getY();
        return Walking.getCollisionFlags(_plane)[xOff][yOff];
    }
}
