package controllers.gameStates;

import entities.dungeon.DungeonDoor;

public interface Switchable {
    /**
     * For Dependency inversion
     */
    void changeRoom(DungeonDoor.Door doorType);
}
