package entities.dungeon;

import entities.character.Enemy;
import entities.character.Merchant;

import java.util.ArrayList;
import java.util.List;

public class DungeonRoom {
    private List<DungeonRoom> connectedRooms;
    private Enemy enemy;
    private Merchant merchant;
    public DungeonRoom previousRoom;

    public DungeonRoom() {
        this.connectedRooms = new ArrayList<DungeonRoom>();
        this.enemy = null;
        this.previousRoom = null;
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
    public void addEnemy(Enemy newNPC) {
        this.enemy = newNPC;
    }
    public void addMerchant(Merchant merchant){
        this.merchant = merchant;
    }

    /**
     * Sets the previous DungeonRoom the Player is entering this DungeonRoom from.
     *
     * @param room the room the Player has just exited.
     */
    public void setPreviousRoom(DungeonRoom room) {
        this.previousRoom = room;
    }

    /**
     * Clears the information regarding the previous DungeonRoom the player entered this room from.
     */
    public void clearPreviousRoom() {
        this.previousRoom = null;
    }

    /**
     * @return The DungeonRoom the player entered this room from.
     * @throws Object404Error if no previous DungeonRoom is attached to this one.
     */
    public DungeonRoom getPreviousRoom() {
        DungeonRoom prevRoom = this.previousRoom;
//            this.clearPreviousRoom();
        return this.previousRoom;
    }

    /**
     * @return an array of all connected DungeonRooms.
     */
    public DungeonRoom[] getConnectedRooms() {
        return this.connectedRooms.toArray(new DungeonRoom[0]);
    }

    /**
     * @return whether this DungeonRoom contains an NPC or not.
     */
    public boolean hasEnemy() {
        return this.enemy != null;
    }
    public boolean hasMerchant() {
        return this.merchant != null;
    }

    /**
     * @return The NPC in this DungeonRoom.
     * @throws Object404Error if no NPC is found in this DungeonRoom.
     */
    public Enemy getEnemy() {
        if (this.enemy == null) {
            try {
                throw new Object404Error("Room does not contain an NPC");
            } catch (Object404Error e) {
                e.printStackTrace();
            }
        }
        return this.enemy;
    }
    public Merchant getMerchant() {
        if (this.merchant == null) {
            try {
                throw new Object404Error("Room does not contain an NPC");
            } catch (Object404Error e) {
                e.printStackTrace();
            }
        }
        return this.merchant;
    }


    public static class Object404Error extends Exception {
        public Object404Error(String message) {
            super(message);
        }
    }
}
