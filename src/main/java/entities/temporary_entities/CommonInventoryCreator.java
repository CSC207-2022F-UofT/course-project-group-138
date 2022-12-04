package entities.temporary_entities;

import entities.inventory.Armor;
import entities.inventory.Equipment;
import entities.inventory.Inventory;
import entities.inventory.Weapon;

public class CommonInventoryCreator implements InventoryCreator{
    @Override
    public Inventory createInventory(Equipment weapon, Equipment armor, int coins) {
        return new Inventory((Weapon) weapon, (Armor) armor, coins);
    }
}
