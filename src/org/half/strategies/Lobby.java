package org.half.strategies;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.SceneObject;
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
        System.out.println("Checking for dungeon entrance...");
        return SceneEntities.getNearest(ENTRANCE) != null;
    }

    @Override
    public void run()
    {
        SceneObject entrance = SceneEntities.getNearest(ENTRANCE);

        System.out.println("Found dungeon entrance... Climb.");
        entrance.interact("Climb");
        Time.sleep(Random.nextInt(800, 900));

        // You must be in a party to enter a dungeon.
        while (!Widgets.get(1186).validate())
        {
            Time.sleep(Random.nextInt(800, 900));
        }
        System.out.println("You must be in a party to enter a dungeon.");
        Widgets.get(1186, 8).click(true);
        Time.sleep(Random.nextInt(800, 900));

        // Would you like to start a party? Yes.
        while (!Widgets.get(1188).validate())
        {
            Time.sleep(Random.nextInt(800, 900));
        }
        System.out.println("Would you like to start a party? Yes.");
        Widgets.get(1188, 3).click(true);
        Time.sleep(Random.nextInt(800, 900));

        // Climb again.
        System.out.println("Climb.");
        entrance.interact("Climb");
        Time.sleep(Random.nextInt(800, 900));

        // Select floor.
        while (!Widgets.get(947).validate())
        {
            Time.sleep(Random.nextInt(800, 900));
        }
        System.out.println("Select floor.");

        final int progress = 1; // start on this floor
        WidgetChild floor = Widgets.get(947, 607 + progress);
        while (floor.getCentralPoint().getY() > 210)
        {
            WidgetChild floorSelectBox = Widgets.get(947, 38);
            if (!floorSelectBox.getBoundingRectangle().contains(Mouse.getLocation()))
            {
                Rectangle floorSelectBounds = floorSelectBox.getBoundingRectangle();
                Mouse.move((int) floorSelectBounds.getCenterX(), (int) floorSelectBounds.getCenterY());
            }
            Mouse.scroll(false);
            Time.sleep(Random.nextInt(400, 500));
        }
        Mouse.click(floor.getCentralPoint(), true); // Floor
        Time.sleep(Random.nextInt(800, 900));

        Widgets.get(947, 761).click(true); // Confirm
        Time.sleep(Random.nextInt(800, 900));

        // Select complexity.
        while (!Widgets.get(938).validate())
        {
            Time.sleep(Random.nextInt(800, 900));
        }
        System.out.println("Select floor.");
        Widgets.get(938, 60).click(true); // Complexity 1
        Time.sleep(Random.nextInt(800, 900));
        Widgets.get(938, 37).click(true); // Confirm
        Time.sleep(Random.nextInt(800, 900));
    }
}
