package org.half.dungeon.strategies;

import org.half.utils.Misc;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Condition;
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
        final Widget selectComplexityWidget = Widgets.get(938);
        if (selectComplexityWidget.validate())
        {
            System.out.println("Select complexity.");

            selectComplexityWidget.getChild(60).interact("Select"); // Complexity 1
            Misc.sleepExponential(400);

            selectComplexityWidget.getChild(37).interact("Confirm"); // Confirm

            // Sleep until 'Select complexity' disappears.
            Misc.sleepUntil(new Condition()
            {
                @Override
                public boolean validate()
                {
                    return !selectComplexityWidget.validate();
                }
            });
            return;
        }

        // Select floor.
        final Widget selectFloorWidget = Widgets.get(947);
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
                Misc.sleepExponential(400);
            }
            Mouse.click(floorWidget.getCentralPoint(), true); // Click floor row
            Misc.sleepExponential(400);

            selectFloorWidget.getChild(761).interact("Confirm"); // Confirm

            // Sleep until 'Select floor' disappears.
            Misc.sleepUntil(new Condition()
            {
                @Override
                public boolean validate()
                {
                    return !selectFloorWidget.validate();
                }
            });
            return;
        }

        // Would you like to start a party?
        final Widget startPartyWidget = Widgets.get(1188);
        if (startPartyWidget.validate())
        {
            System.out.println("Would you like to start a party? Yes.");
            startPartyWidget.getChild(3).interact("Continue");

            // Sleep until 'Would you like to start a party?' disappears.
            Misc.sleepUntil(new Condition()
            {
                @Override
                public boolean validate()
                {
                    return !startPartyWidget.validate();
                }
            });
            return;
        }

        // You must be in a party to enter a dungeon.
        final Widget partyRequiredWidget = Widgets.get(1186);
        if (partyRequiredWidget.validate())
        {
            System.out.println("You must be in a party to enter a dungeon.");
            partyRequiredWidget.getChild(8).interact("Continue");

            // Sleep until 'You must be in a party to enter a dungeon.' disappears.
            Misc.sleepUntil(new Condition()
            {
                @Override
                public boolean validate()
                {
                    return !partyRequiredWidget.validate();
                }
            });
            return;
        }

        // Climb.
        System.out.println("Climb.");
        SceneObject entrance = SceneEntities.getNearest(ENTRANCE);
        entrance.interact("Climb");
        Misc.sleepExponential(2000);
    }
}
