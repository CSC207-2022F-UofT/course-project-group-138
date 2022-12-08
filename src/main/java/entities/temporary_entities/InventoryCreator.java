package entities.temporary_entities;

import entities.inventory.Equipment;
import entities.inventory.Inventory;

public interface InventoryCreator {
    Inventory createInventory(Equipment weapon, Equipment armor, int coins);
}
