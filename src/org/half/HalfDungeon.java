package org.half;

import org.half.dungeon.Avatar;
import org.half.dungeon.Dungeon;
import org.half.dungeon.rooms.Room;
import org.half.dungeon.strategies.DungeonStart;
import org.half.dungeon.strategies.RoomBuilder;
import org.half.dungeon.strategies.Lobby;
import org.half.userinterface.MousePaint;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.bot.event.listener.PaintListener;

import java.awt.*;
import java.util.ArrayList;

@Manifest(
        name = "HalfDungeon",
        version = 0.1,
        description = "RuneScape F2P Dungeoneering Bot",
        authors = {"koksnieger"},
        website = "http://github.com/koksnieger/HalfDungeon"
)
public final class HalfDungeon extends ActiveScript implements PaintListener
{
    @Override
    protected void setup()
    {
        provide(new MousePaint());

        provide(new Lobby());
        provide(new RoomBuilder());

        provide(new DungeonStart());
    }

    @Override
    public void onRepaint(Graphics graphics)
    {
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (Dungeon.inDungeon())
        {
            // draw current room
            Room currentRoom = Avatar.findRoom();
            if (currentRoom != null)
            {
                currentRoom.draw(g);
            }
        }

        // draw overlay map
        ArrayList<Room> rooms = Dungeon.getRooms();

        // find top left coordinates
        Point lowestCoordinates = new Point(0, 0);
        for (Room room : rooms)
        {
            Point roomCoordinates = room.getCoordinates();
            if (roomCoordinates.x < lowestCoordinates.x)
            {
                lowestCoordinates.x = roomCoordinates.x;
            }
            if (roomCoordinates.y < lowestCoordinates.y)
            {
                lowestCoordinates.y = roomCoordinates.y;
            }
        }

        for (Room room : rooms)
        {
            Point roomCoordinates = room.getCoordinates();

            // draw this room
            if (roomCoordinates.x == 0 && roomCoordinates.y == 0)
            {
                g.setColor(new Color(0, 0, 255, 64));
            }
            else if (Avatar.findRoom() == room)
            {
                g.setColor(new Color(0, 128, 0, 128));
            }
            else
            {
                g.setColor(new Color(0, 128, 0, 64));
            }
            g.fillRect(240 + 34 * (roomCoordinates.x - lowestCoordinates.x), 10 + 34 * (roomCoordinates.y - lowestCoordinates.y), 30, 30);

            g.setColor(new Color(0, 0, 0, 192));
            g.drawRect(240 + 34 * (roomCoordinates.x - lowestCoordinates.x), 10 + 34 * (roomCoordinates.y - lowestCoordinates.y), 30, 30);
        }
    }
}
