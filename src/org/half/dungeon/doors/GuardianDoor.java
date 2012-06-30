package org.half.dungeon.doors;

import org.half.dungeon.rooms.Room;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class GuardianDoor extends Door
{
    public static final int OBJECT_DOOR_GUARDIAN_FROZEN = 50346;
    public static final int OBJECT_DOOR_GUARDIAN_ABANDONED = 50346;
    public static final int[] OBJECT_DOOR_GUARDIAN = {
            OBJECT_DOOR_GUARDIAN_FROZEN,
            OBJECT_DOOR_GUARDIAN_ABANDONED
    };

    /**
     * Creates a guardian door object.
     *
     * @param room     The room where this door is.
     * @param position The position of this door in the room. (0 = North, 1 = East, 2 = South, 3 = West)
     * @param object   The scene object associated with this door.
     */
    protected GuardianDoor(final Room room, final int position, final SceneObject object)
    {
        super(room, position, object);
    }

    public String toString()
    {
        return getCompassPosition() + " Door: Guardian";
    }
}
