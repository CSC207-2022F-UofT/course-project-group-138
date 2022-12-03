package entities.dungeon;

import entities.Entity;

public class DungeonTile extends Entity {
    private boolean clips; // true if and only if it is collidable with player}
    /**
     * === Constructors ===
     *
     * @param x - x location in canvas
     * @param y - y location in canvas
     */
    public DungeonTile(int x, int y) {
        super(x, y);
    }
}
