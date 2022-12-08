package controllers.gameStates;

import entities.dungeon.DungeonDoor;

public interface RoomSwitcher {
    /**
     * For Dependency inversion
     */
    void changeRoom(DungeonDoor.Door doorType);
}
