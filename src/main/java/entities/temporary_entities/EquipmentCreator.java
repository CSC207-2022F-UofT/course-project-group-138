package entities.temporary_entities;

import entities.inventory.Equipment;
import entities.inventory.EquipmentInterface;

public interface EquipmentCreator {

    Equipment createArmor(int attribute, int price);
    Equipment createWeapon(int attribute, int price);
}
