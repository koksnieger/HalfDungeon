package org.half.dungeon.skills;

public abstract class Skill
{
    private final int _id;
    private final String _name;

    /**
     * Creates a skill object from a known id and name.
     */
    public Skill(int id, String name)
    {
        _id = id;
        _name = name;
    }

    /**
     * Gets the skill id.
     */
    public int getId()
    {
        return _id;
    }

    /**
     * Gets the skill name.
     */
    public String getName()
    {
        return _name;
    }
}
