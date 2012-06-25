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
        provide(new DungeonStart());

        provide(new RoomBuilder());
    }

    @Override
    public void onRepaint(Graphics graphics)
    {
        Graphics2D g = (Graphics2D) graphics;

        if (Dungeon.inDungeon())
        {
            // draw current room
            Room currentRoom = Avatar.findRoom();
            if (currentRoom != null)
            {
                currentRoom.draw(g);
            }
        }
    }
}
