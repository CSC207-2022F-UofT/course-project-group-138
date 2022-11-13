import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static java.lang.Math.round;

public class Dungeon {
    static int[] ENEMY_RANGE = {5, 10};
    static int[] MERCHANT_RANGE = {1, 5};
    static int[] CONNECTION_RANGE = {1, 5};
    static double[] DIFFICULTY_RANGE = {0.10, 0.25, 0.50, 1.00};
    private List<DungeonRoom> rooms;
    private DungeonRoom startingRoom;

    public Dungeon() {
        this.rooms = new ArrayList<DungeonRoom>();
        this.startingRoom = new DungeonRoom();
        this.addRoom(startingRoom);
    }

    public HashMap<DungeonRoom, List<DungeonRoom>> generateDungeonMap(int difficulty) {
        Random rand = new Random();
        int enemyRange = rand.nextInt((ENEMY_RANGE[1] - ENEMY_RANGE[0]) + 1) + ENEMY_RANGE[0];
        int merchantRange = rand.nextInt((MERCHANT_RANGE[1] - MERCHANT_RANGE[0]) + 1) + MERCHANT_RANGE[0];
        int numberOfRooms = enemyRange + merchantRange + (int)round((enemyRange + merchantRange) * DIFFICULTY_RANGE[difficulty]);

        HashMap<DungeonRoom, List<DungeonRoom>> map = new HashMap<DungeonRoom, List<DungeonRoom>>();

        this.arrangeRooms(map, numberOfRooms);
        this.connectRooms(map, numberOfRooms, rand);

        //TODO: Render Dungeon graph visualization to test map generation.

        return map;
    }

    private void addRoom(DungeonRoom newRoom) {
        this.rooms.add(newRoom);
    }

    private void addHallway(DungeonRoom roomOne, DungeonRoom roomTwo, HashMap<DungeonRoom, List<DungeonRoom>> map) {
        roomOne.addConnectedRoom(roomTwo);
        roomTwo.addConnectedRoom(roomOne);
        map.get(roomOne).add(roomTwo);
        map.get(roomTwo).add(roomOne);
    }

    private void arrangeRooms(HashMap<DungeonRoom, List<DungeonRoom>> map, int numberOfRooms) {
        for (int i = 0; i < numberOfRooms + 1; i++) {
            DungeonRoom newRoom = new DungeonRoom();
            this.addRoom(newRoom);
            map.put(newRoom, new ArrayList<DungeonRoom>());
        }
    }

    private void connectRooms(HashMap<DungeonRoom, List<DungeonRoom>> map, int numberOfRooms, Random rand) {
        for (int i = 1; i < numberOfRooms; i++) {
            int numberOfConnections = rand.nextInt(CONNECTION_RANGE[1] - CONNECTION_RANGE[0]) + CONNECTION_RANGE[0];
            for (int j = 0; j < numberOfConnections; j++) {
                int connectedRoomIndex = rand.nextInt(numberOfRooms - 1) + 1;
                if (connectedRoomIndex == i || map.get(this.rooms.get(i)).contains(this.rooms.get(connectedRoomIndex))) {
                    do {
                        connectedRoomIndex = rand.nextInt(numberOfRooms - 1) + 1;
                    } while (connectedRoomIndex == i || map.get(this.rooms.get(i)).contains(this.rooms.get(connectedRoomIndex)));
                }
                this.addHallway(this.rooms.get(i), this.rooms.get(connectedRoomIndex), map);
            }
        }
    }
}
