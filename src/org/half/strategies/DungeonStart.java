package org.half.strategies;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class DungeonStart extends Strategy implements Task, Condition
{
    public static final int EXIT_LADDER_FROZEN = 51156;
    public static final int EXIT_LADDER_ABANDONED = 50604;
    public static final int EXIT_LADDER_FURNISHED = 51704;
    public static final int[] EXIT_LADDERS = {EXIT_LADDER_ABANDONED, EXIT_LADDER_FROZEN, EXIT_LADDER_FURNISHED};

    private boolean firstRun = true;

    @Override
    public boolean validate()
    {
        return SceneEntities.getNearest(EXIT_LADDERS) != null;
    }

    @Override
    public void run()
    {
        if (firstRun)
        {
            SceneObject exitLadder = SceneEntities.getNearest(EXIT_LADDERS);
            if (exitLadder != null)
            {
                switch (exitLadder.getId())
                {
                    case EXIT_LADDER_FROZEN:
                        System.out.println("Frozen dungeon started.");
                        break;
                    case EXIT_LADDER_ABANDONED:
                        System.out.println("Abandoned dungeon started.");
                        break;
                    case EXIT_LADDER_FURNISHED:
                        System.out.println("Furnished dungeon started.");
                        break;
                }
            }
            firstRun = false;
        }
        else
        {
            // setup dungeon
        }
    }
}
