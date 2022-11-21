package dungeontest;

import dungeon.Dungeon;
import dungeon.DungeonRoom;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

import static org.junit.Assert.*;

public class TestMapGeneration {
    static int[] ENEMY_RANGE = {5, 10};
    static int[] MERCHANT_RANGE = {1, 5};
    static double[] DIFFICULTY_RANGE = {0.10, 0.25, 0.50, 1.00};

    @Test
    public void testLowDifficulty() {
        Dungeon testDungeon = new Dungeon(0);
        HashMap<DungeonRoom, List<DungeonRoom>> testMap = testDungeon.generateDungeonMap();

        int minRooms = ENEMY_RANGE[0] + MERCHANT_RANGE[0] + (int)Math.round((ENEMY_RANGE[0] + MERCHANT_RANGE[0]) * DIFFICULTY_RANGE[0]);
        int maxRooms = ENEMY_RANGE[1] + MERCHANT_RANGE[1] + (int)Math.round((ENEMY_RANGE[1] + MERCHANT_RANGE[1]) * DIFFICULTY_RANGE[0]);

        assertTrue(String.format("Number of rooms %d is less than than the minimum expected number %d.", testMap.keySet().size(), minRooms), minRooms <= testMap.keySet().size());
        assertTrue(String.format("Number of rooms %d is more than than the maximum expected number %d.", testMap.keySet().size(), maxRooms), testMap.keySet().size() <= maxRooms);
    }

    @Test
    public void testMediumDifficulty() {
        Dungeon testDungeon = new Dungeon(1);
        HashMap<DungeonRoom, List<DungeonRoom>> testMap = testDungeon.generateDungeonMap();

        int minRooms = ENEMY_RANGE[0] + MERCHANT_RANGE[0] + (int)Math.round((ENEMY_RANGE[0] + MERCHANT_RANGE[0]) * DIFFICULTY_RANGE[1]);
        int maxRooms = ENEMY_RANGE[1] + MERCHANT_RANGE[1] + (int)Math.round((ENEMY_RANGE[1] + MERCHANT_RANGE[1]) * DIFFICULTY_RANGE[1]);

        assertTrue(String.format("Number of rooms %d is less than than the minimum expected number %d.", testMap.keySet().size(), minRooms), minRooms <= testMap.keySet().size());
        assertTrue(String.format("Number of rooms %d is more than than the maximum expected number %d.", testMap.keySet().size(), maxRooms), testMap.keySet().size() <= maxRooms);
    }

    @Test
    public void testHighDifficulty() {
        Dungeon testDungeon = new Dungeon(2);
        HashMap<DungeonRoom, List<DungeonRoom>> testMap = testDungeon.generateDungeonMap();

        int minRooms = ENEMY_RANGE[0] + MERCHANT_RANGE[0] + (int)Math.round((ENEMY_RANGE[0] + MERCHANT_RANGE[0]) * DIFFICULTY_RANGE[2]);
        int maxRooms = ENEMY_RANGE[1] + MERCHANT_RANGE[1] + (int)Math.round((ENEMY_RANGE[1] + MERCHANT_RANGE[1]) * DIFFICULTY_RANGE[2]);

        assertTrue(String.format("Number of rooms %d is less than than the minimum expected number %d.", testMap.keySet().size(), minRooms), minRooms <= testMap.keySet().size());
        assertTrue(String.format("Number of rooms %d is more than than the maximum expected number %d.", testMap.keySet().size(), maxRooms), testMap.keySet().size() <= maxRooms);
    }

    @Test
    public void testMaxDifficulty() {
        Dungeon testDungeon = new Dungeon(3);
        HashMap<DungeonRoom, List<DungeonRoom>> testMap = testDungeon.generateDungeonMap();

        int minRooms = ENEMY_RANGE[0] + MERCHANT_RANGE[0] + (int)Math.round((ENEMY_RANGE[0] + MERCHANT_RANGE[0]) * DIFFICULTY_RANGE[3]);
        int maxRooms = ENEMY_RANGE[1] + MERCHANT_RANGE[1] + (int)Math.round((ENEMY_RANGE[1] + MERCHANT_RANGE[1]) * DIFFICULTY_RANGE[3]);

        assertTrue(String.format("Number of rooms %d is less than than the minimum expected number %d.", testMap.keySet().size(), minRooms), minRooms <= testMap.keySet().size());
        assertTrue(String.format("Number of rooms %d is more than than the maximum expected number %d.", testMap.keySet().size(), maxRooms), testMap.keySet().size() <= maxRooms);
    }

    @Test
    public void testGenerationVisualization() {
        Random rand = new Random();
        Dungeon testDungeon = new Dungeon(rand.nextInt(4));
        HashMap<DungeonRoom, List<DungeonRoom>> testMap = testDungeon.generateDungeonMap();

        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new MultiGraph("Dungeon Map Generation Visual Test");

        for (DungeonRoom key : testMap.keySet()) {
            graph.addNode(String.valueOf(System.identityHashCode(key)));
        }
        for (DungeonRoom key : testMap.keySet()) {
            for (DungeonRoom connection : testMap.get(key)) {
                graph.addEdge(String.format("%d %d", System.identityHashCode(key), System.identityHashCode(connection)), String.valueOf(System.identityHashCode(key)), String.valueOf(System.identityHashCode(connection)));
            }
        }

        graph.display();
    }
}
