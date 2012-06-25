package org.half.dungeon.strategies;

import org.half.dungeon.Avatar;
import org.half.dungeon.Dungeon;
import org.half.dungeon.rooms.Room;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;

public class RoomBuilder extends Strategy implements Task
{
    @Override
    public boolean validate()
    {
        return Dungeon.inDungeon() && Avatar.findRoom() == null;
    }

    @Override
    public void run()
    {
        Room room = new Room(Avatar.getLocation());
        Dungeon.getRooms().add(room);
    }
}
