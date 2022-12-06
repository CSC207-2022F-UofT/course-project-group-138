package entities.temporary_entities;

import entities.inventory.Armor;
import entities.inventory.Weapon;

public class CommonEquipmentCreator implements EquipmentCreator {
    public Armor createArmor(int attribute) {
        return new Armor(attribute);
    }
    public Weapon createWeapon(int attribute) {
        return new Weapon(attribute);
    }
}
