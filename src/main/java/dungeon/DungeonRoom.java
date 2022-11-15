package dungeon;

import merchant_interactions.Merchant;

import java.util.ArrayList;
import java.util.List;

public class DungeonRoom {
    private List<DungeonRoom> connectedRooms;
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
     * Add a new Merchant to the DungeonRoom.
     *
     * @param newNPC the new Merchant to be added.
     */
    public void addNPC(Merchant newNPC) {
        this.nonPlayerCharacter = newNPC;
    }

    /**
     * Add a new Enemy to the DungeonRoom.
     *
     * @param newNPC the new Enemy to be added.
     */
    public void addNPC(Object newNPC) {
        //TODO: Replace argument class Object with Enemy, when Enemy class is merged onto main.
        this.nonPlayerCharacter = newNPC;
    }

    /**
     * @return an array of all connected DungeonRooms.
     */
    public DungeonRoom[] getConnectedRooms() {
        return this.connectedRooms.toArray(new DungeonRoom[0]);
    }
}
