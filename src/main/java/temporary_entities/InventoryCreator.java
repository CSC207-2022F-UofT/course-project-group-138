package temporary_entities;

import inventory.Equipment;
import inventory.Inventory;

public interface InventoryCreator {
    Inventory createInventory(Equipment weapon, Equipment armor, int coins);
}
