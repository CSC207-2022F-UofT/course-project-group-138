package entities.dungeon;

import entities.character.Enemy;
import entities.character.Merchant;

public class DungeonRoom {
    private Enemy enemy;
    private Merchant merchant;
    public DungeonRoom previousRoom;

    public DungeonRoom() {
        this.merchant = null;
        this.enemy = null;
        this.previousRoom = null;
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
     * @return whether this DungeonRoom contains an NPC or not.
     */
    public boolean hasEnemy() {
        return this.enemy != null;
    }
    public boolean hasMerchant() {
        return this.merchant != null;
    }

    /**
     * Should always call hasEnemy() or hasMerchant() first to avoid unexpected result
     * @return The NPC in this DungeonRoom.
     * @throws Object404Error if no NPC is found in this DungeonRoom.
     */
    public Enemy getEnemy() {
        return this.enemy;
    }
    public Merchant getMerchant() {
        return this.merchant;
    }


    public static class Object404Error extends Exception {
        public Object404Error(String message) {
            super(message);
        }
    }

    // for implementation of serialization and test file for deserialization

    public boolean hasPreviousRoom() {return this.previousRoom == null; }

    public DungeonRoom retrievePreviousRoom() {
        return previousRoom;
    }
}
