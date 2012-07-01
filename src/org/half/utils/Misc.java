package org.half.utils;

import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.widget.WidgetComposite;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.util.internal.Multipliers;
import org.powerbot.game.api.wrappers.RegionOffset;
import org.powerbot.game.api.wrappers.interactive.Player;
import org.powerbot.game.api.wrappers.widget.WidgetChild;
import org.powerbot.game.bot.Context;
import org.powerbot.game.client.Client;

import java.awt.*;

public class Misc
{
    /**
     * Sleeps current thread for a minimum time up to an exponential random value.
     * (this makes things harder to detect than the most common linear random most people use)
     *
     * @param minimumTime The minimum time to sleep.
     * @return The number of actual slept milliseconds.
     */
    public static int sleepExponential(int minimumTime)
    {
        int time = minimumTime - (int) (minimumTime * 0.5 * Math.log(Math.random()));
        Time.sleep(time);
        return time;
    }

    /**
     * Sleeps current thread in random intervals until a condition is met.
     *
     * @param condition Condition that must be met for the sleep to end.
     * @return The number of milliseconds slept.
     */
    public static int sleepUntil(final Condition condition)
    {
        int totalTime = 0;
        do
        {
            totalTime += sleepExponential(100);
        }
        while (!condition.validate());
        return totalTime;
    }

    /**
     * Determines whether one of the elements is in the array.
     *
     * @param array    The array to search into.
     * @param elements The elements to locate in the array.
     * @return True if one of the elements is found or false otherwise.
     */
    public static boolean inArray(final int[] array, final int... elements)
    {
        for (int hay : array)
        {
            for (int needle : elements)
            {
                if (hay == needle)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines whether one of the elements is in the array.
     *
     * @param array    The array to search into.
     * @param elements The elements to locate in the array.
     * @return True if one of the elements is found or false otherwise.
     */
    public static boolean inArray(final int[][] array, final int... elements)
    {
        for (int[] hay : array)
        {
            if (inArray(hay, elements))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the <code>Point</code> of given x and y values in the game's 2D plane. (without boundary checks)
     * (copy paste from RSBot API minus checks)
     *
     * @param x x value based on the game plane.
     * @param y y value based on the game plane.
     * @return <code>Point</code> within map; otherwise <tt>new Point(-1, -1)</tt>.
     */
    public static Point worldToMap(double x, double y)
    {
        final Client client = Context.client();
        final Multipliers multipliers = Context.multipliers();
        final Player local = Players.getLocal();
        x -= Game.getBaseX();
        y -= Game.getBaseY();

        final RegionOffset localTile = local.getRegionOffset();
        final int calculatedX = (int) (x * 4 + 2) - (localTile.getX() << 9) / 0x80;
        final int calculatedY = (int) (y * 4 + 2) - (localTile.getY() << 9) / 0x80;

        final WidgetChild mm2 = WidgetComposite.getMap();
        if (mm2 == null)
        {
            return new Point(-1, -1);
        }

        int angle = 0x3fff & (int) client.getMinimapAngle();
        final boolean setting4 = client.getMinimapSetting() * multipliers.GLOBAL_MINIMAPSETTING == 4;

        if (!setting4)
        {
            angle = 0x3fff & (client.getMinimapOffset() * multipliers.GLOBAL_MINIMAPOFFSET) + (int) client.getMinimapAngle();
        }

        int cs = Calculations.SIN_TABLE[angle];
        int cc = Calculations.COS_TABLE[angle];

        if (!setting4)
        {
            final int fact = 0x100 + (client.getMinimapScale() * multipliers.GLOBAL_MINIMAPSCALE);
            cs = 0x100 * cs / fact;
            cc = 0x100 * cc / fact;
        }

        final int calcCenterX = cc * calculatedX + cs * calculatedY >> 0xf;
        final int calcCenterY = cc * calculatedY - cs * calculatedX >> 0xf;
        final int screen_x = calcCenterX + mm2.getAbsoluteX() + mm2.getWidth() / 2;
        final int screen_y = -calcCenterY + mm2.getAbsoluteY() + mm2.getHeight() / 2;
        return new Point(screen_x, screen_y);
    }
}
