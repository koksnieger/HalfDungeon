package org.half.dungeon.doors;

import org.powerbot.game.api.wrappers.node.SceneObject;

public class PuzzleDoor extends Door
{
    public static final int OBJECT_DOOR_PUZZLE_SLIDING_STATUES_FROZEN = 49375;
    public static final int OBJECT_DOOR_PUZZLE_MONOLITH_FROZEN = 49462;
    public static final int OBJECT_DOOR_PUZZLE_COLOURED_FERRETS_FROZEN = 54360;
    public static final int[] OBJECT_DOOR_PUZZLE = {
            OBJECT_DOOR_PUZZLE_SLIDING_STATUES_FROZEN,
            OBJECT_DOOR_PUZZLE_MONOLITH_FROZEN,
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
