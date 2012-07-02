package org.half.dungeon.strategies;

import org.half.dungeon.Avatar;
import org.half.dungeon.Dungeon;
import org.half.dungeon.doors.Door;
import org.half.dungeon.rooms.Room;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Game;

/**
 * Strategy that monitors room switching.
 * This is where the dungeon gets mapped.
 */
public class RoomMonitor extends Strategy implements Task
{
    @Override
    public boolean validate()
    {
        Room currentRoom = Avatar.currentRoom();
        return Game.getClientState() != 12 && Dungeon.inside() && (currentRoom == null || !currentRoom.contains(Avatar.location()));
    }

    @Override
    public void run()
    {
        // Check if we already mapped this room
        Room avatarRoom = Avatar.findRoom();
        if (avatarRoom == null)
        {
            // Room isn't mapped, so map it
            avatarRoom = Room.createRoomFromTile(Avatar.location());
            Dungeon.rooms().add(avatarRoom);

            // Show some debugging output
            System.out.println("\nNew " + avatarRoom);
            for (Door door : avatarRoom.getDoors())
            {
                if (door != null)
                {
                    System.out.println(door);
                }
            }
        }

        // Change avatar current room
        Avatar.setCurrentRoom(avatarRoom);
    }
}
