package temporary_entities;

import inventory.Armor;
import inventory.Equipment;
import inventory.Inventory;
import inventory.Weapon;

public class CommonInventoryCreator implements InventoryCreator{
    @Override
    public Inventory createInventory(Equipment weapon, Equipment armor, int coins) {
        return new Inventory((Weapon) weapon, (Armor) armor, coins);
    }
}
