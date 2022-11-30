package temporary_entities;

import inventory.Armor;
import inventory.Equipment;
import inventory.Weapon;

public class CommonEquipmentCreator implements EquipmentCreator{
    @Override
    public Equipment createArmor(int attribute, int price) {
        return new Armor(attribute, price);
    }

    @Override
    public Equipment createWeapon(int attribute, int price) {
        return new Weapon(attribute, price);
    }
}
