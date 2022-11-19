package dungeon;

import java.util.ArrayList;
import java.util.List;

public class DungeonRoom {
    private List<DungeonRoom> connectedRooms;
    private DungeonRoom previousRoom;
    private Object nonPlayerCharacter;
    private String typeOfNPC;

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
     * @param type the type of NPC to be added (i.e. 'M' or 'E').
     */
    public void addNPC(Object newNPC, String type) {
        this.nonPlayerCharacter = newNPC;
        this.typeOfNPC = type;
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
