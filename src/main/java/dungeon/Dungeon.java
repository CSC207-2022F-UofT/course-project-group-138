package dungeon;

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
    private final double difficulty;
    private List<DungeonRoom> rooms;
    private DungeonRoom startingRoom;

    public Dungeon(int difficulty) {
        this.rooms = new ArrayList<DungeonRoom>();
        this.difficulty = DIFFICULTY_RANGE[difficulty];
        this.startingRoom = new DungeonRoom();
        this.addRoom(startingRoom);
    }

    /**
     * Generates a random dungeon map with a random number of rooms within the class variable ranges.
     *
     * @return a HashMap of all DungeonRooms (except starting room and gate room) as keys and all connected DungeonRooms as values.
     */
    public HashMap<DungeonRoom, List<DungeonRoom>> generateDungeonMap() {
        Random rand = new Random();
        int numberOfEnemies = rand.nextInt((ENEMY_RANGE[1] - ENEMY_RANGE[0]) + 1) + ENEMY_RANGE[0];
        int numberOfMerchants = rand.nextInt((MERCHANT_RANGE[1] - MERCHANT_RANGE[0]) + 1) + MERCHANT_RANGE[0];
        int numberOfRooms = numberOfEnemies + numberOfMerchants + (int)round((numberOfEnemies + numberOfMerchants) * this.difficulty);

        HashMap<DungeonRoom, List<DungeonRoom>> map = new HashMap<DungeonRoom, List<DungeonRoom>>();

        DungeonRoomBuilder roomBuilder = new DungeonRoomBuilder(numberOfEnemies, numberOfMerchants);

        this.insertRooms(map, numberOfRooms, roomBuilder);
        this.connectRooms(map, numberOfRooms, rand);
        this.connectEndRooms(map, rand);

        return map;
    }

    /**
     * Adds a new DungeonRoom to the Dungeon List rooms.
     *
     * @param newRoom the new room to be added.
     */
    private void addRoom(DungeonRoom newRoom) {
        this.rooms.add(newRoom);
    }

    /**
     * Adds a connection between two DungeonRooms in the List rooms and in the HashMap.
     *
     * @param roomOne the first DungeonRoom.
     * @param roomTwo the second DungeonRoom.
     * @param map the HashMap of DungeonRooms to all connected DungeonRooms.
     */
    private void addHallway(DungeonRoom roomOne, DungeonRoom roomTwo, HashMap<DungeonRoom, List<DungeonRoom>> map) {
        roomOne.addConnectedRoom(roomTwo);
        roomTwo.addConnectedRoom(roomOne);
        map.get(roomOne).add(roomTwo);
        map.get(roomTwo).add(roomOne);
    }

    /**
     * Inserts the specified number of rooms into the HashMap and initializes an ArrayList for their values.
     *
     * @param map the HashMap to be inserted into.
     * @param numberOfRooms the number of rooms to be inserted.
     */
    private void insertRooms(HashMap<DungeonRoom, List<DungeonRoom>> map, int numberOfRooms, DungeonRoomBuilder roomBuilder) {
        for (int i = 0; i < numberOfRooms + 1; i++) {
            DungeonRoom newRoom = roomBuilder.buildNewRoom();
            this.addRoom(newRoom);
            map.put(newRoom, new ArrayList<DungeonRoom>());
        }
    }

    /**
     * Randomly connects each DungeonRoom in the HashMap to a random number of other DungeonRooms in the HashMap.
     *
     * @param map the HashMap of DungeonRooms to all connected DungeonRooms.
     * @param numberOfRooms the number of rooms in the HashMap.
     * @param rand a Random object.
     */
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

    private void connectEndRooms(HashMap<DungeonRoom, List<DungeonRoom>> map, Random rand) {
        int randomSecondRoomIndex = rand.nextInt(this.rooms.size() + 1) - 1;
        this.addHallway(this.startingRoom, this.rooms.get(randomSecondRoomIndex), map);

        DungeonRoom gateRoom = new DungeonRoom();
        int randomSecondLastRoomIndex = rand.nextInt(this.rooms.size() + 1) - 1;
        if (randomSecondLastRoomIndex == randomSecondRoomIndex) {
            do {
                randomSecondLastRoomIndex = rand.nextInt(this.rooms.size() + 1) - 1;
            } while (randomSecondLastRoomIndex == randomSecondRoomIndex);
        }
        this.addHallway(gateRoom, this.rooms.get(randomSecondLastRoomIndex), map);
    }
}
