package org.half.dungeon.doors;

import org.powerbot.game.api.wrappers.node.SceneObject;

public class BossDoor extends Door
{
    public static final int OBJECT_DOOR_BOSS_FROZEN = 50350;
    public static final int OBJECT_DOOR_BOSS_ABANDONED = 50351;
    public static final int[] OBJECT_DOOR_BOSS = {
            OBJECT_DOOR_BOSS_FROZEN,
            OBJECT_DOOR_BOSS_ABANDONED
    };

    /**
     * Creates a boss door object.
     *
     * @param position The position of this door in the room. (0 = North, 1 = East, 2 = South, 3 = West)
     * @param object   The scene object associated with this door.
     */
    protected BossDoor(final int position, final SceneObject object)
    {
        super(position, object);
    }

    public String toString()
    {
        return getCompassPosition() + " Door: Boss";
    }
}
