package temporary_classes;

import inventory.Inventory;

public abstract class Character {
    public abstract int getHP();
    public abstract void setHP(int HP);
    public abstract Inventory getInventory();
    public abstract boolean isAlive();
}