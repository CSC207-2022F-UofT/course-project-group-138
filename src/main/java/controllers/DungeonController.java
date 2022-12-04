package controllers;

import entities.dungeon.Dungeon;
import entities.dungeon.DungeonRoom;

import java.util.List;

public class DungeonController {
    private final Dungeon dungeon;
    private DungeonRoom currentRoom;

    public DungeonController() {
        this.dungeon = new Dungeon();
        dungeon.generateDungeonMap();
        currentRoom = dungeon.getStartingRoom();
    }

    /**
     * @return an array of all DungeonRooms connected to the current room the player is in.
     */
    public List<DungeonRoom> getConnections() {
        return this.dungeon.getConnections(this.currentRoom);
    }

    /**
     * @return the current room the player is in.
     */
    public DungeonRoom getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Moves the player from the current room, to the specified connected room.
     *
     * @param newRoom the new room to move into.
     */
    public void goForward(DungeonRoom newRoom) {
        if (this.getConnections().contains(newRoom)) {
            DungeonRoom previousRoom = this.currentRoom;
            this.currentRoom = newRoom;
            this.currentRoom.setPreviousRoom(previousRoom);
        }
    }

    /**
     * Moves the player back to the previous room they entered the current room from.
     */
    public void goBack() throws Exception {
        this.currentRoom = this.currentRoom.getPreviousRoom();
    }
}
