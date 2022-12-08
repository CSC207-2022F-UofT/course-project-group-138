package entities.dungeon;

import settings.Settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static java.lang.Math.min;
import static java.lang.Math.round;

public class Dungeon {
    static int[] ENEMY_RANGE = {5, 10};
    static int[] MERCHANT_RANGE = {1, 5};
    static int[] CONNECTION_RANGE = {1, 5};
    static double[] DIFFICULTY_RANGE = {0.10, 0.25, 0.50, 1.00};
    private final double difficulty;
    private HashMap<DungeonRoom, List<DungeonRoom>> map;
    private DungeonRoom startingRoom;

    public Dungeon() {
        this.difficulty = DIFFICULTY_RANGE[Settings.getDifficulty()];
    }

    /**
     * Generates a random dungeon map with a random number of rooms within the class variable ranges.
     *
     * @return a HashMap of all DungeonRooms (except starting room and gate room) as keys and all connected DungeonRooms as values.
     */
    public void generateDungeonMap() {
        List<DungeonRoom> rooms = new ArrayList<DungeonRoom>();
        this.startingRoom = new DungeonRoom();
        rooms.add(this.startingRoom);

        Random rand = new Random();
        int numberOfEnemies = rand.nextInt((ENEMY_RANGE[1] - ENEMY_RANGE[0]) + 1) + ENEMY_RANGE[0];
        int numberOfMerchants = rand.nextInt((MERCHANT_RANGE[1] - MERCHANT_RANGE[0]) + 1) + MERCHANT_RANGE[0];
        int minimumNumberOfRooms = numberOfEnemies + numberOfMerchants;
        int numberOfRooms = (int)round((minimumNumberOfRooms * (1.0 + this.difficulty)) * 1.50);
        // no. of NPC rooms + 10-25% difficulty bonus + overall 50% bonus + starting room + gate room
        // minimum possible rooms = 13
        // maximum possible number of rooms = 47

        this.map = new HashMap<DungeonRoom, List<DungeonRoom>>();

        DungeonRoomBuilder roomBuilder = new DungeonRoomBuilder(numberOfEnemies, numberOfMerchants);

        this.insertRooms(numberOfRooms, roomBuilder, rooms);
        this.connectRooms(numberOfRooms, rand, rooms);
        this.connectEndRooms(rand, rooms);
    }

    /**
     * @return the starting room of the dungeon the player spawns in.
     */
    public DungeonRoom getStartingRoom() {
        return startingRoom;
    }

    public List<DungeonRoom> getConnections(DungeonRoom room) {
        return this.map.get(room);
    }

    /**
     * Adds a connection between two DungeonRooms in the List rooms and in the HashMap.
     *
     * @param roomOne the first DungeonRoom.
     * @param roomTwo the second DungeonRoom.
     */
    private void addHallway(DungeonRoom roomOne, DungeonRoom roomTwo, boolean isEndRoom) {
        int maxConnectionSize;
        if (isEndRoom) {maxConnectionSize = 5;} else {maxConnectionSize = 6;}
        if (this.map.get(roomOne).size() < maxConnectionSize && this.map.get(roomTwo).size() < maxConnectionSize) {
            this.map.get(roomOne).add(roomTwo);
            this.map.get(roomTwo).add(roomOne);
        }
    }

    /**
     * Inserts the specified number of rooms into the HashMap and initializes an ArrayList for their values.
     *
     * @param numberOfRooms the number of rooms to be inserted.
     * @param roomBuilder a DungeonRoomBuilder object.
     * @param rooms a List of all DungeonRooms in the Dungeon.
     */
    private void insertRooms(int numberOfRooms, DungeonRoomBuilder roomBuilder, List<DungeonRoom> rooms) {
        for (int i = 0; i < numberOfRooms + 1; i++) {
            DungeonRoom newRoom = roomBuilder.buildNewRoom();
            rooms.add(newRoom);
            map.put(newRoom, new ArrayList<DungeonRoom>());
        }
    }

    /**
     * Randomly connects each DungeonRoom in the HashMap to a random number of other DungeonRooms in the HashMap.
     *
     * @param numberOfRooms the number of rooms in the HashMap.
     * @param rand a Random object.
     * @param rooms a List of all DungeonRooms in this Dungeon.
     */
    private void connectRooms(int numberOfRooms, Random rand, List<DungeonRoom> rooms) {
        for (int i = 1; i < numberOfRooms; i++) {
            int numberOfConnections = rand.nextInt(CONNECTION_RANGE[1] - CONNECTION_RANGE[0]) + CONNECTION_RANGE[0];
            for (int j = 0; j < numberOfConnections; j++) {
                int connectedRoomIndex = rand.nextInt(numberOfRooms - 1) + 1;
                if (connectedRoomIndex == i || this.map.get(rooms.get(i)).contains(rooms.get(connectedRoomIndex))) {
                    do {
                        connectedRoomIndex = rand.nextInt(numberOfRooms - 1) + 1;
                    } while (connectedRoomIndex == i || this.map.get(rooms.get(i)).contains(rooms.get(connectedRoomIndex)));
                }
                this.addHallway(rooms.get(i), rooms.get(connectedRoomIndex), false);
            }
        }
    }

    /**
     * Connects the starting room (first room) and the gate room (last room) to two random different rooms in the Dungeon.
     *
     * @param rand a Random object.
     * @param rooms a List of all DungeonRooms in this Dungeon.
     */
    private void connectEndRooms(Random rand, List<DungeonRoom> rooms) {
        int randomSecondRoomIndex = rand.nextInt(rooms.size());

        DungeonRoom gateRoom = new DungeonRoom();
        int randomSecondLastRoomIndex = rand.nextInt(rooms.size());
        if (randomSecondLastRoomIndex == randomSecondRoomIndex) {
            do {
                randomSecondLastRoomIndex = rand.nextInt(rooms.size());
            } while (randomSecondLastRoomIndex == randomSecondRoomIndex);
        }

        this.map.put(this.startingRoom, new ArrayList<DungeonRoom>());
        this.map.put(gateRoom, new ArrayList<DungeonRoom>());
        this.addHallway(this.startingRoom, rooms.get(randomSecondRoomIndex), true);
        this.addHallway(gateRoom, rooms.get(randomSecondLastRoomIndex), true);
    }
}
