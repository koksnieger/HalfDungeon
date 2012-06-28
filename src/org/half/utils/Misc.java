package org.half.utils;

import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.util.Time;

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
}
