package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DungeonGenerator {
    private final Dungeon dungeon;
    private final HashMap<DungeonRoom, List<DungeonRoom>> map;
    private DungeonRoom currentRoom;
    private List<DungeonRoom> previousRoomStack;

    public DungeonGenerator() {
        this.dungeon = new Dungeon();
        this.map = dungeon.generateDungeonMap();
        currentRoom = dungeon.getStartingRoom();
        previousRoomStack = new ArrayList<DungeonRoom>();
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
            this.push(this.currentRoom);
            this.currentRoom = newRoom;
        }
    }

    /**
     * Moves the player back to the previous room they entered the current room from.
     */
    public void goBack() throws Exception {
        this.currentRoom = pop();
    }

    /**
     * Adds a room that the player is moving out of, to the stack of previous rooms.
     *
     * @param previousRoom the room the player is leaving.
     */
    private void push(DungeonRoom previousRoom) {
        this.previousRoomStack.add(previousRoom);
    }

    /**
     * Removes the most recently exited room from the stack of previous rooms.
     *
     * @return the exited DungeonRoom being removed.
     */
    private DungeonRoom pop() throws Exception {
        if (this.previousRoomStack.size() == 0) {
            throw new Exception("Stack Underflow");
        }
        return this.previousRoomStack.remove(this.previousRoomStack.size() - 1);
    }
}
