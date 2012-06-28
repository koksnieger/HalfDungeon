package org.half.dungeon.strategies;

import org.half.dungeon.Avatar;
import org.half.dungeon.Dungeon;
import org.half.dungeon.rooms.Room;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Game;

public class RoomBuilder extends Strategy implements Task
{
    @Override
    public boolean validate()
    {
        Room currentRoom = Avatar.getCurrentRoom();
        return Game.getClientState() != 12 && Dungeon.inDungeon() && (currentRoom == null || !currentRoom.contains(Avatar.getLocation()));
    }

    @Override
    public void run()
    {
        // Check if we already mapped this room
        Room avatarRoom = Avatar.findRoom();
        if (avatarRoom == null)
        {
            // Room isn't mapped, so map it
            avatarRoom = new Room(Avatar.getLocation());
            Dungeon.getRooms().add(avatarRoom);
        }

        // Change avatar current room
        Avatar.setCurrentRoom(avatarRoom);
    }
}
