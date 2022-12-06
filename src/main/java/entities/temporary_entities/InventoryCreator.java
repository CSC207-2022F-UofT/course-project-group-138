package entities.temporary_entities;

import entities.inventory.Inventory;

public interface InventoryCreator {
    Inventory createInventory(int coins, int weaponAttribute, int armoAttribute);
}
