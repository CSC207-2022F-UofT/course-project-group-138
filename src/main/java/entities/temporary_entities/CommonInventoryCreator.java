package entities.temporary_entities;

import entities.inventory.Inventory;

public class CommonInventoryCreator implements InventoryCreator {

    private EquipmentCreator equipmentCreator = new CommonEquipmentCreator();

    @Override
    public Inventory createInventory(int coins, int weaponAttribute, int armoAttribute) {
        return new Inventory(coins,
                equipmentCreator.createWeapon(weaponAttribute),
                equipmentCreator.createArmor(armoAttribute));
    }
}
