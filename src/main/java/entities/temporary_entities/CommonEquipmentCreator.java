package entities.temporary_entities;

import entities.inventory.Armor;
import entities.inventory.EquipmentInterface;
import entities.inventory.Weapon;

public class CommonEquipmentCreator implements EquipmentCreator{
    @Override
    public EquipmentInterface createArmor(int attribute, int price) {
        return new Armor(attribute, price);
    }

    @Override
    public EquipmentInterface createWeapon(int attribute, int price) {
        return new Weapon(attribute, price);
    }
}
