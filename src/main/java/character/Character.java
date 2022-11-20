package character;

import inventory.*;


public abstract class Character {

    /**
     * An abstract class to be extended by Player and Enemy.
     */

    /**
     * === Methods relating to health ===
     */
    public abstract int getHP();
    public abstract void setHP(int HP);
    public abstract boolean isAlive();

    /**
     * === Methods relating to inventory ===
     */
    public abstract Inventory getInventory();

    /**
     * === Methods relating to position ===
     */
    public abstract int getx();
    public abstract int gety();
    public abstract void setPosition(int x, int y);

    /**
     * === Methods relating to other ===
     */
    public abstract int attack();
}