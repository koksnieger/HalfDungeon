package org.half.dungeon.strategies;

import org.half.utils.Misc;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.wrappers.node.SceneObject;
import org.powerbot.game.api.wrappers.widget.Widget;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import java.awt.*;


public class Lobby extends Strategy implements Task
{
    private static final int ENTRANCE = 48496;

    public Lobby()
    {
        setReset(true);
    }

    @Override
    public boolean validate()
    {
        SceneObject entrance = SceneEntities.getNearest(ENTRANCE);
        return entrance != null && entrance.isOnScreen();
    }

    @Override
    public void run()
    {
        // Select complexity.
        Widget selectComplexityWidget = Widgets.get(938);
        if (selectComplexityWidget.validate())
        {
            System.out.println("Select complexity.");

            selectComplexityWidget.getChild(60).interact("Select"); // Complexity 1
            Misc.randomSleep(400);

            selectComplexityWidget.getChild(37).interact("Confirm"); // Confirm
            Misc.randomSleep(800);
            return;
        }

        // Select floor.
        Widget selectFloorWidget = Widgets.get(947);
        if (selectFloorWidget.validate())
        {
            System.out.println("Select floor.");

            final int progress = 1; // start on this floor
            WidgetChild floorWidget = selectFloorWidget.getChild(607 + progress);
            while (floorWidget.getCentralPoint().getY() > 210)
            {
                WidgetChild floorListWidget = selectFloorWidget.getChild(38);
                if (!floorListWidget.getBoundingRectangle().contains(Mouse.getLocation()))
                {
                    Rectangle floorListBounds = floorListWidget.getBoundingRectangle();
                    Mouse.move((int) floorListBounds.getCenterX(), (int) floorListBounds.getCenterY());
                }
                Mouse.scroll(false);
                Misc.randomSleep(400);
            }
            Mouse.click(floorWidget.getCentralPoint(), true); // Click floor row
            Misc.randomSleep(400);

            selectFloorWidget.getChild(761).interact("Confirm"); // Confirm
            Misc.randomSleep(700);
            return;
        }

        // Would you like to start a party? Yes.
        Widget startPartyWidget = Widgets.get(1188);
        if (startPartyWidget.validate())
        {
            System.out.println("Would you like to start a party? Yes.");
            startPartyWidget.getChild(3).interact("Continue");
            Misc.randomSleep(700);
            return;
        }

        // You must be in a party to enter a dungeon.
        Widget partyRequiredWidget = Widgets.get(1186);
        if (partyRequiredWidget.validate())
        {
            System.out.println("You must be in a party to enter a dungeon.");
            partyRequiredWidget.getChild(8).interact("Continue");
            Misc.randomSleep(700);
            return;
        }

        // Climb.
        System.out.println("Climb.");
        SceneObject entrance = SceneEntities.getNearest(ENTRANCE);
        entrance.interact("Climb");
        Misc.randomSleep(2000);
        return;
    }
}
