package entities.temporary_entities;

import entities.inventory.Armor;
import entities.inventory.Weapon;

public interface EquipmentCreator {

    Armor createArmor(int attribute);
    Weapon createWeapon(int attribute);
}
