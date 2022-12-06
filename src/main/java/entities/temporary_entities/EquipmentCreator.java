package entities.temporary_entities;

import entities.inventory.EquipmentInterface;

public interface EquipmentCreator {

    EquipmentInterface createArmor(int attribute, int price);
    EquipmentInterface createWeapon(int attribute, int price);
}
