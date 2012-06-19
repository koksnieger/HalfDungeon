package org.half.dungeon.items;

public abstract class Key
{
    private final int _id;
    private final String _name;

    /**
     * Creates a key object from a known id and name.
     */
    public Key(int id, String name)
    {
        _id = id;
        _name = name;
    }

    /**
     * Gets the key id.
     */
    public int getId()
    {
        return _id;
    }

    /**
     * Gets the key name.
     */
    public String getName()
    {
        return _name;
    }
}
