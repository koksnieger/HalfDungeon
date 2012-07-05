package org.half.dungeon.doors;

import org.powerbot.game.api.wrappers.node.SceneObject;

public class NormalDoor extends Door
{
    public static final int OBJECT_DOOR_NORMAL_FROZEN = 50342;
    public static final int OBJECT_DOOR_NORMAL_ABANDONED = 50343;
    public static final int[] OBJECT_DOOR_NORMAL = {
            OBJECT_DOOR_NORMAL_FROZEN,
            OBJECT_DOOR_NORMAL_ABANDONED,
    };

    /**
     * Creates a normal door object.
     *
     * @param position The position of this door in the room. (0 = North, 1 = East, 2 = South, 3 = West)
     * @param object   The scene object associated with this door.
     */
    protected NormalDoor(final int position, final SceneObject object)
    {
        super(position, object);
    }

    /**
     * Checks if this door can be opened.
     *
     * @return true if this door can be opened; false otherwise;
     */
    @Override
    public boolean canBeOpened()
    {
        return true;
    }

    @Override
    public String toString()
    {
        return getCompassPosition() + " Door: Normal";
    }
}
