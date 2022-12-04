package entities.temporary_entities;

import entities.inventory.Armor;
import entities.inventory.Equipment;
import entities.inventory.Weapon;

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
