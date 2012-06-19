package org.half.dungeon.items;

public enum Key
{
    BLUE_CORNER(0,    "Blue corner"),
    BLUE_CRESCENT(0,  "Blue crescent"),
    BLUE_DIAMOND(0,   "Blue diamond"),
    BLUE_PENTAGON(0,  "Blue pentagon"),
    BLUE_TRIANGLE(0,  "Blue triangle"),
    BLUE_RECTANGLE(0, "Blue rectangle"),
    BLUE_SHIELD(0,    "Blue shield"),
    BLUE_WEDGE(0,     "Blue wedge"),

    CRIMSON_CORNER(0,    "Crimson corner"),
    CRIMSON_CRESCENT(0,  "Crimson crescent"),
    CRIMSON_DIAMOND(0,   "Crimson diamond"),
    CRIMSON_PENTAGON(0,  "Crimson pentagon"),
    CRIMSON_TRIANGLE(0,  "Crimson triangle"),
    CRIMSON_RECTANGLE(0, "Crimson rectangle"),
    CRIMSON_SHIELD(0,    "Crimson shield"),
    CRIMSON_WEDGE(0,     "Crimson wedge"),

    GOLD_CORNER(0,    "Gold corner"),
    GOLD_CRESCENT(0,  "Gold crescent"),
    GOLD_DIAMOND(0,   "Gold diamond"),
    GOLD_PENTAGON(0,  "Gold pentagon"),
    GOLD_TRIANGLE(0,  "Gold triangle"),
    GOLD_RECTANGLE(0, "Gold rectangle"),
    GOLD_SHIELD(0,    "Gold shield"),
    GOLD_WEDGE(0,     "Gold wedge"),

    GREEN_CORNER(0,    "Green corner"),
    GREEN_CRESCENT(0,  "Green crescent"),
    GREEN_DIAMOND(0,   "Green diamond"),
    GREEN_PENTAGON(0,  "Green pentagon"),
    GREEN_TRIANGLE(0,  "Green triangle"),
    GREEN_RECTANGLE(0, "Green rectangle"),
    GREEN_SHIELD(0,    "Green shield"),
    GREEN_WEDGE(0,     "Green wedge"),

    ORANGE_CORNER(0,    "Orange corner"),
    ORANGE_CRESCENT(0,  "Orange crescent"),
    ORANGE_DIAMOND(0,   "Orange diamond"),
    ORANGE_PENTAGON(0,  "Orange pentagon"),
    ORANGE_TRIANGLE(0,  "Orange triangle"),
    ORANGE_RECTANGLE(0, "Orange rectangle"),
    ORANGE_SHIELD(0,    "Orange shield"),
    ORANGE_WEDGE(0,     "Orange wedge"),

    PURPLE_CORNER(0,    "Purple corner"),
    PURPLE_CRESCENT(0,  "Purple crescent"),
    PURPLE_DIAMOND(0,   "Purple diamond"),
    PURPLE_PENTAGON(0,  "Purple pentagon"),
    PURPLE_TRIANGLE(0,  "Purple triangle"),
    PURPLE_RECTANGLE(0, "Purple rectangle"),
    PURPLE_SHIELD(0,    "Purple shield"),
    PURPLE_WEDGE(0,     "Purple wedge"),

    SILVER_CORNER(0,    "Silver corner"),
    SILVER_CRESCENT(0,  "Silver crescent"),
    SILVER_DIAMOND(0,   "Silver diamond"),
    SILVER_PENTAGON(0,  "Silver pentagon"),
    SILVER_TRIANGLE(0,  "Silver triangle"),
    SILVER_RECTANGLE(0, "Silver rectangle"),
    SILVER_SHIELD(0,    "Silver shield"),
    SILVER_WEDGE(0,     "Silver wedge"),

    YELLOW_CORNER(0,    "Yellow corner"),
    YELLOW_CRESCENT(0,  "Yellow crescent"),
    YELLOW_DIAMOND(0,   "Yellow diamond"),
    YELLOW_PENTAGON(0,  "Yellow pentagon"),
    YELLOW_TRIANGLE(0,  "Yellow triangle"),
    YELLOW_RECTANGLE(0, "Yellow rectangle"),
    YELLOW_SHIELD(0,    "Yellow shield"),
    YELLOW_WEDGE(0,     "Yellow wedge");

    private final int _id;
    private final String _name;

    /**
     * Creates a key object from a known id and name.
     */
    private Key(int id, String name)
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