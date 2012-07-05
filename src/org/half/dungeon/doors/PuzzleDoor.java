package org.half.dungeon.doors;

import org.powerbot.game.api.wrappers.node.SceneObject;

public class PuzzleDoor extends Door
{
    public static final int OBJECT_DOOR_PUZZLE_ICY_PRESSURE_PAD_FROZEN = 49335;
    public static final int OBJECT_DOOR_PUZZLE_SLIDING_STATUES_FROZEN = 49375;
    public static final int OBJECT_DOOR_PUZZLE_FOLLOW_THE_LEADER_FROZEN = 49378;
    public static final int OBJECT_DOOR_PUZZLE_LEVERS_FROZEN = 49387;
    public static final int OBJECT_DOOR_PUZZLE_MONOLITH_FROZEN = 49462;
    public static final int OBJECT_DOOR_PUZZLE_FISHING_FERRET_FROZEN = 49564;
    public static final int OBJECT_DOOR_PUZZLE_MIRROR_STATUE_WEAPON_FROZEN = 49625;
    public static final int OBJECT_DOOR_PUZZLE_FLIP_TILES_FROZEN = 49644;
    public static final int OBJECT_DOOR_PUZZLE_THREE_STATUE_WEAPON_FROZEN = 49650;
    public static final int OBJECT_DOOR_PUZZLE_PONDSKATERS_FROZEN = 53987;
    public static final int OBJECT_DOOR_PUZZLE_SLIDING_TILES_FROZEN = 54317;
    public static final int OBJECT_DOOR_PUZZLE_COLOURED_FERRETS_FROZEN = 54360;
    public static final int[] OBJECT_DOOR_PUZZLE = {
            OBJECT_DOOR_PUZZLE_ICY_PRESSURE_PAD_FROZEN,
            OBJECT_DOOR_PUZZLE_SLIDING_STATUES_FROZEN,
            OBJECT_DOOR_PUZZLE_FOLLOW_THE_LEADER_FROZEN,
            OBJECT_DOOR_PUZZLE_LEVERS_FROZEN,
            OBJECT_DOOR_PUZZLE_MONOLITH_FROZEN,
            OBJECT_DOOR_PUZZLE_FISHING_FERRET_FROZEN,
            OBJECT_DOOR_PUZZLE_MIRROR_STATUE_WEAPON_FROZEN,
            OBJECT_DOOR_PUZZLE_FLIP_TILES_FROZEN,
            OBJECT_DOOR_PUZZLE_THREE_STATUE_WEAPON_FROZEN,
            OBJECT_DOOR_PUZZLE_PONDSKATERS_FROZEN,
            OBJECT_DOOR_PUZZLE_SLIDING_TILES_FROZEN,
            OBJECT_DOOR_PUZZLE_COLOURED_FERRETS_FROZEN
    };

    /**
     * Creates a puzzle door object.
     *
     * @param position The position of this door in the room. (0 = North, 1 = East, 2 = South, 3 = West)
     * @param object   The scene object associated with this door.
     */
    protected PuzzleDoor(final int position, final SceneObject object)
    {
        super(position, object);
    }

    public String toString()
    {
        return getCompassPosition() + " Door: Puzzle";
    }
}
