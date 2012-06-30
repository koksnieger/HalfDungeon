package org.half.dungeon.doors;

import org.half.dungeon.rooms.Room;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class SkillDoor extends Door
{
    /**
     * Creates a skill door object.
     *
     * @param room     The room where this door is.
     * @param position The position of this door in the room. (0 = North, 1 = East, 2 = South, 3 = West)
     * @param object   The scene object associated with this door.
     */
    protected SkillDoor(final Room room, final int position, final SceneObject object)
    {
        super(room, position, object);
    }

    public String toString()
    {
        return getCompassPosition() + " Door: Skill";
    }
}
