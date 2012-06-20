package org.half.userinterface;

import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.bot.event.listener.PaintListener;

import java.awt.*;

/**
 * Draw a mouse trail and pointer.
 *
 * Note: The original code is from Deprecated (http://github.com/imDeprecated)
 */
public class MousePaint extends Strategy implements PaintListener
{
    private static final int SIZE = 25;
    private static final double ALPHA_STEP = (255.0 / SIZE);

    private static final Point[] _points = new Point[SIZE];
    private static int _index = 0;

    private static void drawTrail(final Graphics g)
    {
        _points[_index++] = Mouse.getLocation();
        _index %= SIZE;

        double alpha = 0;
        for (int i = _index; i != (_index == 0 ? SIZE - 1 : _index - 1); i = (i + 1) % SIZE)
        {
            if (_points[i] != null && _points[(i + 1) % SIZE] != null)
            {
                g.setColor(new Color(255, 255, 255, (int) alpha));
                g.drawLine(_points[i].x, _points[i].y, _points[(i + 1) % SIZE].x, _points[(i + 1) % SIZE].y);
                alpha += ALPHA_STEP;
            }
        }
    }

    private static void drawPointer(final Graphics g) {
        g.drawOval(Mouse.getX() - 5, Mouse.getY() - 5, 11, 11);
        g.fillOval(Mouse.getX() - 2, Mouse.getY() - 2, 5, 5);
    }

    @Override
    public boolean validate()
    {
        return false;
    }

    @Override
    public void onRepaint(final Graphics g)
    {
        drawTrail(g);
        drawPointer(g);
    }
}
