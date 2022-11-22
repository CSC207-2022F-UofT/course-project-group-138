package dungeon;

import java.util.ArrayList;
import java.util.List;

public class DungeonRoom {
    private List<DungeonRoom> connectedRooms;
    private DungeonRoom previousRoom;
    private Object nonPlayerCharacter;

    public DungeonRoom() {
        this.connectedRooms = new ArrayList<DungeonRoom>();
    }

    /**
     * Add a DungeonRoom to the List of connected DungeonRooms.
     *
     * @param newRoom the new DungeonRoom to be connected.
     */
    public void addConnectedRoom(DungeonRoom newRoom) {
        this.connectedRooms.add(newRoom);
    }

    /**
     * Add a new NPC to the DungeonRoom.
     *
     * @param newNPC the new NPC to be added.
     */
    public void addNPC(Object newNPC) {
        this.nonPlayerCharacter = newNPC;
    }

    /**
     * Sets the previous room that this DungeonRoom was entered from.
     *
     * @param room the previous room.
     */
    public void setPreviousRoom(DungeonRoom room) {
        this.previousRoom = room;           // TODO: Backtracking method in Dungeon.
    }

    /**
     * @return an array of all connected DungeonRooms.
     */
    public DungeonRoom[] getConnectedRooms() {
        return this.connectedRooms.toArray(new DungeonRoom[0]);
    }
}
