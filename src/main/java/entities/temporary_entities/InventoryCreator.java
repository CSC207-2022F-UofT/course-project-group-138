package entities.temporary_entities;

import entities.inventory.EquipmentInterface;
import entities.inventory.Inventory;

public interface InventoryCreator {
    Inventory createInventory(EquipmentInterface weapon, EquipmentInterface armor, int coins);
}
