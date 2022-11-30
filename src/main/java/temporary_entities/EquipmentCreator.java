package temporary_entities;

import inventory.Equipment;

public interface EquipmentCreator {

    Equipment createArmor(int attribute, int price);
    Equipment createWeapon(int attribute, int price);
}
