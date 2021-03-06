package org.half.dungeon.doors;

import org.powerbot.game.api.wrappers.node.SceneObject;

public class SkillDoor extends Door
{
    public static final int OBJECT_DOOR_SKILL_BARRED_CLOSED_FROZEN = 50272;
    public static final int OBJECT_DOOR_SKILL_BARRED_OPEN_FROZEN = 50275;

    public static final int OBJECT_DOOR_SKILL_BROKEN_PULLEY_CLOSED_FROZEN = 50299;
    public static final int OBJECT_DOOR_SKILL_BROKEN_PULLEY_OPEN_FROZEN = 50302;

    public static final int OBJECT_DOOR_SKILL_BROKEN_KEY_CLOSED_FROZEN = 50308;
    public static final int OBJECT_DOOR_SKILL_BROKEN_KEY_OPEN_FROZEN = 50311;

    public static final int OBJECT_DOOR_SKILL_WOODEN_BARRICADE_CLOSED_FROZEN = 50317;
    public static final int OBJECT_DOOR_SKILL_WOODEN_BARRICADE_OPEN_FROZEN = 50320;

    public static final int[] OBJECT_DOOR_SKILL = {
            OBJECT_DOOR_SKILL_BARRED_CLOSED_FROZEN,
            OBJECT_DOOR_SKILL_BARRED_OPEN_FROZEN,
            OBJECT_DOOR_SKILL_BROKEN_PULLEY_CLOSED_FROZEN,
            OBJECT_DOOR_SKILL_BROKEN_PULLEY_OPEN_FROZEN,
            OBJECT_DOOR_SKILL_BROKEN_KEY_CLOSED_FROZEN,
            OBJECT_DOOR_SKILL_BROKEN_KEY_OPEN_FROZEN,
            OBJECT_DOOR_SKILL_WOODEN_BARRICADE_CLOSED_FROZEN,
            OBJECT_DOOR_SKILL_WOODEN_BARRICADE_OPEN_FROZEN
    };

    /**
     * Creates a skill door object.
     *
     * @param position The position of this door in the room. (0 = North, 1 = East, 2 = South, 3 = West)
     * @param object   The scene object associated with this door.
     */
    protected SkillDoor(final int position, final SceneObject object)
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
        // TODO: check if the player has skill to open this door. (for now it can be opened)
        return true;
    }

    @Override
    public String toString()
    {
        return getCompassPosition() + " Door: Skill";
    }
}
