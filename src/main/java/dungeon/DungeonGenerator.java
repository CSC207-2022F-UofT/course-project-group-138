package dungeon;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DungeonGenerator {
    private final Dungeon dungeon;
    private final HashMap<DungeonRoom, List<DungeonRoom>> map;
    private DungeonRoom currentRoom;
    private Stack<DungeonRoom> previousRoomStack;

    public DungeonGenerator() {
        this.dungeon = new Dungeon();
        this.map = dungeon.generateDungeonMap();
        currentRoom = dungeon.getStartingRoom();
        previousRoomStack = new Stack<DungeonRoom>();
    }

    /**
     * @return an array of all DungeonRooms connected to the current room the player is in.
     */
    public DungeonRoom[] getConnections() {
        return this.map.get(this.currentRoom).toArray(new DungeonRoom[0]);
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
        if (this.map.get(this.currentRoom).contains(newRoom)) {
            this.previousRoomStack.push(this.currentRoom);
            this.currentRoom = newRoom;
        }
    }

    /**
     * Moves the player back to the previous room they entered the current room from.
     */
    public void goBack() throws Exception {
        this.currentRoom = this.previousRoomStack.pop();
    }
}
