package entities.temporary_entities;

import entities.inventory.Armor;
import entities.inventory.Inventory;
import entities.inventory.Weapon;

public interface CharacterBuilder {
    Armor buildArmor(int attribute);
    Weapon buildWeapon(int attribute);
    Inventory buildInventory(Weapon weapon, Armor armor, int coins);
}
