package org.half.dungeon.rooms;

import org.half.dungeon.doors.Door;

import java.awt.*;

/**
 * Frozen C6 = 2+2 statues
 *
 * RuneScape Wikia: http://runescape.wikia.com/wiki/Dungeoneering/Puzzles#Ten_statue_weapon
 */
public class MirrorStatueWeaponPuzzleRoom extends PuzzleRoom
{
    protected MirrorStatueWeaponPuzzleRoom(final Rectangle bounds, final Point coordinates, final Door[] doors)
    {
        super(bounds, coordinates, doors);
    }
}
