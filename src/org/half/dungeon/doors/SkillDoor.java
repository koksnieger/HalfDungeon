package org.half.dungeon.doors;

import org.half.dungeon.rooms.Room;
import org.half.dungeon.skills.Skill;

public class SkillDoor extends Door
{
    private final Skill _skill;

    /**
     * Creates a skill door object.
     *
     * @param room  The room where this door is.
     * @param skill The skill needed to open this door.
     */
    public SkillDoor(Room room, Skill skill)
    {
        super(room);
        _skill = skill;
    }

    /**
     * Gets this door skill.
     */
    public Skill getSkill()
    {
        return _skill;
    }
}
