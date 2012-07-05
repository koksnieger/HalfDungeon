package org.half.dungeon;

import org.half.dungeon.rooms.Room;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.Player;

/**
 * Thread safe 'class' to hold some of the avatar properties.
 */
public enum Avatar
{
    SINGLETON;

    private static Room _room;
    private static final Player _player = Players.getLocal();

    /**
     * Gets the avatar room.
     *
     * @return The room where the avatar is.
     */
    public static Room room()
    {
        return _room;
    }

    /**
     * Sets the avatar room.
     *
     * @param room The room where the avatar is.
     */
    public static void setRoom(Room room)
    {
        _room = room;
    }

    /**
     * Gets the avatar location.
     *
     * @return The avatar location.
     */
    public static Tile location()
    {
        return _player.getLocation();
    }

    /**
     * Checks if the avatar is moving.
     *
     * @return true if it's moving; false otherwise;
     */
    public static boolean isMoving()
    {
        return _player.isMoving();
    }

    /**
     * Checks if the player is idle.
     *
     * @return true if it's idle; false otherwise;
     */
    public static boolean isIdle()
    {
        return _player.getAnimation() == -1;
    }
}
