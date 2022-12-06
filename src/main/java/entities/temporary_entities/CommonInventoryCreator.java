package entities.temporary_entities;

import entities.inventory.*;

public class CommonInventoryCreator implements InventoryCreator{
    @Override
    public Inventory createInventory(Equipment weapon, Equipment armor, int coins) {
        return new Inventory(coins, (Weapon) weapon, (Armor) armor);
    }
}
