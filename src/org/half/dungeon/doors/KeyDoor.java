package org.half.dungeon.doors;

import org.half.dungeon.rooms.Room;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class KeyDoor extends Door
{
    public static final int OBJECT_DOOR_KEY_ORANGE_TRIANGLE_FROZEN = 50353;
    public static final int OBJECT_DOOR_KEY_ORANGE_DIAMOND_FROZEN = 50354;
    public static final int OBJECT_DOOR_KEY_ORANGE_RECTANGLE_FROZEN = 50355;
    public static final int OBJECT_DOOR_KEY_ORANGE_PENTAGON_FROZEN = 50356;
    public static final int OBJECT_DOOR_KEY_ORANGE_CORNER_FROZEN = 50357;
    public static final int OBJECT_DOOR_KEY_ORANGE_CRESCENT_FROZEN = 50358;
    public static final int OBJECT_DOOR_KEY_ORANGE_WEDGE_FROZEN = 50359;
    public static final int OBJECT_DOOR_KEY_ORANGE_SHIELD_FROZEN = 50360;
    public static final int[] OBJECT_DOOR_KEY_ORANGE_FROZEN = {
            OBJECT_DOOR_KEY_ORANGE_TRIANGLE_FROZEN,
            OBJECT_DOOR_KEY_ORANGE_DIAMOND_FROZEN,
            OBJECT_DOOR_KEY_ORANGE_RECTANGLE_FROZEN,
            OBJECT_DOOR_KEY_ORANGE_PENTAGON_FROZEN,
            OBJECT_DOOR_KEY_ORANGE_CORNER_FROZEN,
            OBJECT_DOOR_KEY_ORANGE_CRESCENT_FROZEN,
            OBJECT_DOOR_KEY_ORANGE_WEDGE_FROZEN,
            OBJECT_DOOR_KEY_ORANGE_SHIELD_FROZEN
    };

    public static final int OBJECT_DOOR_KEY_SILVER_TRIANGLE_FROZEN = 50361;
    public static final int OBJECT_DOOR_KEY_SILVER_DIAMOND_FROZEN = 50362;
    public static final int OBJECT_DOOR_KEY_SILVER_RECTANGLE_FROZEN = 50363;
    public static final int OBJECT_DOOR_KEY_SILVER_PENTAGON_FROZEN = 50364;
    public static final int OBJECT_DOOR_KEY_SILVER_CORNER_FROZEN = 50365;
    public static final int OBJECT_DOOR_KEY_SILVER_CRESCENT_FROZEN = 50366;
    public static final int OBJECT_DOOR_KEY_SILVER_WEDGE_FROZEN = 50367;
    public static final int OBJECT_DOOR_KEY_SILVER_SHIELD_FROZEN = 50368;
    public static final int[] OBJECT_DOOR_KEY_SILVER_FROZEN = {
            OBJECT_DOOR_KEY_SILVER_TRIANGLE_FROZEN,
            OBJECT_DOOR_KEY_SILVER_DIAMOND_FROZEN,
            OBJECT_DOOR_KEY_SILVER_RECTANGLE_FROZEN,
            OBJECT_DOOR_KEY_SILVER_PENTAGON_FROZEN,
            OBJECT_DOOR_KEY_SILVER_CORNER_FROZEN,
            OBJECT_DOOR_KEY_SILVER_CRESCENT_FROZEN,
            OBJECT_DOOR_KEY_SILVER_WEDGE_FROZEN,
            OBJECT_DOOR_KEY_SILVER_SHIELD_FROZEN
    };

    public static final int OBJECT_DOOR_KEY_YELLOW_TRIANGLE_FROZEN = 50369;
    public static final int OBJECT_DOOR_KEY_YELLOW_DIAMOND_FROZEN = 50370;
    public static final int OBJECT_DOOR_KEY_YELLOW_RECTANGLE_FROZEN = 50371;
    public static final int OBJECT_DOOR_KEY_YELLOW_PENTAGON_FROZEN = 50372;
    public static final int OBJECT_DOOR_KEY_YELLOW_CORNER_FROZEN = 50373;
    public static final int OBJECT_DOOR_KEY_YELLOW_CRESCENT_FROZEN = 50374;
    public static final int OBJECT_DOOR_KEY_YELLOW_WEDGE_FROZEN = 50375;
    public static final int OBJECT_DOOR_KEY_YELLOW_SHIELD_FROZEN = 50376;
    public static final int[] OBJECT_DOOR_KEY_YELLOW_FROZEN = {
            OBJECT_DOOR_KEY_YELLOW_TRIANGLE_FROZEN,
            OBJECT_DOOR_KEY_YELLOW_DIAMOND_FROZEN,
            OBJECT_DOOR_KEY_YELLOW_RECTANGLE_FROZEN,
            OBJECT_DOOR_KEY_YELLOW_PENTAGON_FROZEN,
            OBJECT_DOOR_KEY_YELLOW_CORNER_FROZEN,
            OBJECT_DOOR_KEY_YELLOW_CRESCENT_FROZEN,
            OBJECT_DOOR_KEY_YELLOW_WEDGE_FROZEN,
            OBJECT_DOOR_KEY_YELLOW_SHIELD_FROZEN
    };

    public static final int OBJECT_DOOR_KEY_GREEN_TRIANGLE_FROZEN = 50377;
    public static final int OBJECT_DOOR_KEY_GREEN_DIAMOND_FROZEN = 50378;
    public static final int OBJECT_DOOR_KEY_GREEN_RECTANGLE_FROZEN = 50379;
    public static final int OBJECT_DOOR_KEY_GREEN_PENTAGON_FROZEN = 50380;
    public static final int OBJECT_DOOR_KEY_GREEN_CORNER_FROZEN = 50381;
    public static final int OBJECT_DOOR_KEY_GREEN_CRESCENT_FROZEN = 50382;
    public static final int OBJECT_DOOR_KEY_GREEN_WEDGE_FROZEN = 50383;
    public static final int OBJECT_DOOR_KEY_GREEN_SHIELD_FROZEN = 50384;
    public static final int[] OBJECT_DOOR_KEY_GREEN_FROZEN = {
            OBJECT_DOOR_KEY_GREEN_TRIANGLE_FROZEN,
            OBJECT_DOOR_KEY_GREEN_DIAMOND_FROZEN,
            OBJECT_DOOR_KEY_GREEN_RECTANGLE_FROZEN,
            OBJECT_DOOR_KEY_GREEN_PENTAGON_FROZEN,
            OBJECT_DOOR_KEY_GREEN_CORNER_FROZEN,
            OBJECT_DOOR_KEY_GREEN_CRESCENT_FROZEN,
            OBJECT_DOOR_KEY_GREEN_WEDGE_FROZEN,
            OBJECT_DOOR_KEY_GREEN_SHIELD_FROZEN
    };

    public static final int OBJECT_DOOR_KEY_BLUE_TRIANGLE_FROZEN = 50385;
    public static final int OBJECT_DOOR_KEY_BLUE_DIAMOND_FROZEN = 50386;
    public static final int OBJECT_DOOR_KEY_BLUE_RECTANGLE_FROZEN = 50387;
    public static final int OBJECT_DOOR_KEY_BLUE_PENTAGON_FROZEN = 50388;
    public static final int OBJECT_DOOR_KEY_BLUE_CORNER_FROZEN = 50388;
    public static final int OBJECT_DOOR_KEY_BLUE_CRESCENT_FROZEN = 50390;
    public static final int OBJECT_DOOR_KEY_BLUE_WEDGE_FROZEN = 50391;
    public static final int OBJECT_DOOR_KEY_BLUE_SHIELD_FROZEN = 50392;
    public static final int[] OBJECT_DOOR_KEY_BLUE_FROZEN = {
            OBJECT_DOOR_KEY_BLUE_TRIANGLE_FROZEN,
            OBJECT_DOOR_KEY_BLUE_DIAMOND_FROZEN,
            OBJECT_DOOR_KEY_BLUE_RECTANGLE_FROZEN,
            OBJECT_DOOR_KEY_BLUE_PENTAGON_FROZEN,
            OBJECT_DOOR_KEY_BLUE_CORNER_FROZEN,
            OBJECT_DOOR_KEY_BLUE_CRESCENT_FROZEN,
            OBJECT_DOOR_KEY_BLUE_WEDGE_FROZEN,
            OBJECT_DOOR_KEY_BLUE_SHIELD_FROZEN
    };

    public static final int OBJECT_DOOR_KEY_PURPLE_TRIANGLE_FROZEN = 50393;
    public static final int OBJECT_DOOR_KEY_PURPLE_DIAMOND_FROZEN = 50394;
    public static final int OBJECT_DOOR_KEY_PURPLE_RECTANGLE_FROZEN = 50395;
    public static final int OBJECT_DOOR_KEY_PURPLE_PENTAGON_FROZEN = 50396;
    public static final int OBJECT_DOOR_KEY_PURPLE_CORNER_FROZEN = 50397;
    public static final int OBJECT_DOOR_KEY_PURPLE_CRESCENT_FROZEN = 50398;
    public static final int OBJECT_DOOR_KEY_PURPLE_WEDGE_FROZEN = 50399;
    public static final int OBJECT_DOOR_KEY_PURPLE_SHIELD_FROZEN = 50400;
    public static final int[] OBJECT_DOOR_KEY_PURPLE_FROZEN = {
            OBJECT_DOOR_KEY_PURPLE_TRIANGLE_FROZEN,
            OBJECT_DOOR_KEY_PURPLE_DIAMOND_FROZEN,
            OBJECT_DOOR_KEY_PURPLE_RECTANGLE_FROZEN,
            OBJECT_DOOR_KEY_PURPLE_PENTAGON_FROZEN,
            OBJECT_DOOR_KEY_PURPLE_CORNER_FROZEN,
            OBJECT_DOOR_KEY_PURPLE_CRESCENT_FROZEN,
            OBJECT_DOOR_KEY_PURPLE_WEDGE_FROZEN,
            OBJECT_DOOR_KEY_PURPLE_SHIELD_FROZEN
    };

    public static final int OBJECT_DOOR_KEY_CRIMSON_TRIANGLE_FROZEN = 50401;
    public static final int OBJECT_DOOR_KEY_CRIMSON_DIAMOND_FROZEN = 50402;
    public static final int OBJECT_DOOR_KEY_CRIMSON_RECTANGLE_FROZEN = 50403;
    public static final int OBJECT_DOOR_KEY_CRIMSON_PENTAGON_FROZEN = 50404;
    public static final int OBJECT_DOOR_KEY_CRIMSON_CORNER_FROZEN = 50405;
    public static final int OBJECT_DOOR_KEY_CRIMSON_CRESCENT_FROZEN = 50406;
    public static final int OBJECT_DOOR_KEY_CRIMSON_WEDGE_FROZEN = 50407;
    public static final int OBJECT_DOOR_KEY_CRIMSON_SHIELD_FROZEN = 50408;
    public static final int[] OBJECT_DOOR_KEY_CRIMSON_FROZEN = {
            OBJECT_DOOR_KEY_CRIMSON_TRIANGLE_FROZEN,
            OBJECT_DOOR_KEY_CRIMSON_DIAMOND_FROZEN,
            OBJECT_DOOR_KEY_CRIMSON_RECTANGLE_FROZEN,
            OBJECT_DOOR_KEY_CRIMSON_PENTAGON_FROZEN,
            OBJECT_DOOR_KEY_CRIMSON_CORNER_FROZEN,
            OBJECT_DOOR_KEY_CRIMSON_CRESCENT_FROZEN,
            OBJECT_DOOR_KEY_CRIMSON_WEDGE_FROZEN,
            OBJECT_DOOR_KEY_CRIMSON_SHIELD_FROZEN
    };

    public static final int OBJECT_DOOR_KEY_GOLD_TRIANGLE_FROZEN = 50409;
    public static final int OBJECT_DOOR_KEY_GOLD_DIAMOND_FROZEN = 50410;
    public static final int OBJECT_DOOR_KEY_GOLD_RECTANGLE_FROZEN = 50411;
    public static final int OBJECT_DOOR_KEY_GOLD_PENTAGON_FROZEN = 50412;
    public static final int OBJECT_DOOR_KEY_GOLD_CORNER_FROZEN = 50413;
    public static final int OBJECT_DOOR_KEY_GOLD_CRESCENT_FROZEN = 50414;
    public static final int OBJECT_DOOR_KEY_GOLD_WEDGE_FROZEN = 50415;
    public static final int OBJECT_DOOR_KEY_GOLD_SHIELD_FROZEN = 50416;
    public static final int[] OBJECT_DOOR_KEY_GOLD_FROZEN = {
            OBJECT_DOOR_KEY_GOLD_TRIANGLE_FROZEN,
            OBJECT_DOOR_KEY_GOLD_DIAMOND_FROZEN,
            OBJECT_DOOR_KEY_GOLD_RECTANGLE_FROZEN,
            OBJECT_DOOR_KEY_GOLD_PENTAGON_FROZEN,
            OBJECT_DOOR_KEY_GOLD_CORNER_FROZEN,
            OBJECT_DOOR_KEY_GOLD_CRESCENT_FROZEN,
            OBJECT_DOOR_KEY_GOLD_WEDGE_FROZEN,
            OBJECT_DOOR_KEY_GOLD_SHIELD_FROZEN
    };

    public static final int[][] OBJECT_DOOR_KEY = {
            OBJECT_DOOR_KEY_ORANGE_FROZEN,
            OBJECT_DOOR_KEY_SILVER_FROZEN,
            OBJECT_DOOR_KEY_YELLOW_FROZEN,
            OBJECT_DOOR_KEY_GREEN_FROZEN,
            OBJECT_DOOR_KEY_BLUE_FROZEN,
            OBJECT_DOOR_KEY_PURPLE_FROZEN,
            OBJECT_DOOR_KEY_CRIMSON_FROZEN,
            OBJECT_DOOR_KEY_GOLD_FROZEN
    };

    /**
     * Creates a key door object.
     *
     * @param room     The room where this door is.
     * @param position The position of this door in the room. (0 = North, 1 = East, 2 = South, 3 = West)
     * @param object   The scene object associated with this door.
     */
    protected KeyDoor(final Room room, final int position, final SceneObject object)
    {
        super(room, position, object);
    }

    public String toString()
    {
        return getCompassPosition() + " Door: Key";
    }
}
