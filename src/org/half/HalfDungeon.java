package org.half;

import org.half.dungeon.strategies.DungeonStart;
import org.half.dungeon.strategies.Lobby;
import org.half.userinterface.MousePaint;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;

@Manifest(
        name = "HalfDungeon",
        version = 0.1,
        description = "RuneScape F2P Dungeoneering Bot",
        authors = {"koksnieger"},
        website = "http://github.com/koksnieger/HalfDungeon"
)
public final class HalfDungeon extends ActiveScript
{
    @Override
    protected void setup()
    {
        provide(new MousePaint());

        provide(new Lobby());
        //provide(new DungeonStart());
    }
}
