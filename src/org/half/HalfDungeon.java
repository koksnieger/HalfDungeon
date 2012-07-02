package org.half;

import org.half.dungeon.Avatar;
import org.half.dungeon.Dungeon;
import org.half.dungeon.doors.Door;
import org.half.dungeon.rooms.Room;
import org.half.dungeon.strategies.DungeonStart;
import org.half.dungeon.strategies.Lobby;
import org.half.dungeon.strategies.RoomMonitor;
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
        provide(new RoomMonitor());
        provide(new DungeonStart());
    }

    @Override
    public void onRepaint(Graphics graphics)
    {
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (Dungeon.inside())
        {
            // draw current room on mini map
            Room currentRoom = Avatar.getCurrentRoom();
            if (currentRoom != null)
            {
                currentRoom.drawOnMiniMap(g);
            }

            // draw overlay map
            ArrayList<Room> rooms = Dungeon.rooms();

            // find top left coordinates
            Point northwestCoords = new Point(0, 0);
            Point southeastCoords = new Point(0, 0);
            for (Room room : rooms)
            {
                Point roomCoordinates = room.getCoordinates();
                if (roomCoordinates.x < northwestCoords.x)
                {
                    northwestCoords.x = roomCoordinates.x;
                }
                else if (roomCoordinates.x > southeastCoords.x)
                {
                    southeastCoords.x = roomCoordinates.x;
                }

                if (roomCoordinates.y < northwestCoords.y)
                {
                    northwestCoords.y = roomCoordinates.y;
                }
                else if (roomCoordinates.y > southeastCoords.y)
                {
                    southeastCoords.y = roomCoordinates.y;
                }
            }

            int dungeonWidth = (southeastCoords.x - northwestCoords.x) * 32;

            for (Room room : rooms)
            {
                Point roomCoordinates = room.getCoordinates();
                int x = 484 - dungeonWidth + 32 * (roomCoordinates.x - northwestCoords.x);
                int y = 8 + 32 * (roomCoordinates.y - northwestCoords.y);

                // draw this room
                g.setColor(new Color(255, 255, 255, 192));
                g.drawRect(x, y, 27, 27);
                g.drawRect(x + 1, y + 1, 25, 25);

                if (room == Dungeon.homeRoom())
                {
                    g.setColor(new Color(255, 255, 255, 64));
                }
                else if (room == Avatar.getCurrentRoom())
                {
                    g.setColor(new Color(0, 0, 255, 64));
                }
                else
                {
                    g.setColor(new Color(0, 128, 0, 64));
                }
                g.fillRect(x + 2, y + 2, 24, 24);

                // draw doors
                g.setColor(new Color(255, 255, 255, 192));
                Door[] doors = room.getDoors();

                // draw north door
                if (doors[0] != null)
                {
                    g.fillRect(x + 10, y - 2, 8, 4);
                }

                // draw east door
                if (doors[1] != null)
                {
                    g.fillRect(x + 26, y + 10, 4, 8);
                }

                // draw south door
                if (doors[2] != null)
                {
                    g.fillRect(x + 10, y + 26, 8, 4);
                }

                // draw west door
                if (doors[3] != null)
                {
                    g.fillRect(x - 2, y + 10, 4, 8);
                }
            }
        }
    }
}
