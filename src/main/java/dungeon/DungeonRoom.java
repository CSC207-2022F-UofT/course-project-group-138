package dungeon;

import java.util.ArrayList;
import java.util.List;

public class DungeonRoom {
    private List<DungeonRoom> connectedRooms;
    private Character nonPlayerCharacter;

    public DungeonRoom() {
        this.connectedRooms = new ArrayList<DungeonRoom>();
    }

    public void addConnectedRoom(DungeonRoom newRoom) {
        this.connectedRooms.add(newRoom);
    }

    public void addNPC(Character newNPC) {
        this.nonPlayerCharacter = newNPC;
    }

    public DungeonRoom[] getConnectedRooms() {
        return this.connectedRooms.toArray(new DungeonRoom[0]);
    }
}
