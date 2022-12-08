package entities.temporary_entities;

import entities.inventory.Armor;
import entities.inventory.Inventory;
import entities.inventory.Weapon;

public class PlayerBuilder implements CharacterBuilder {
    public Armor buildArmor(int attribute) {
        return new Armor(attribute);
    }

    public Weapon buildWeapon(int attribute) {
        return new Weapon(attribute);
    }

    public Inventory buildInventory(Weapon weapon, Armor armor, int coins) {
        return new Inventory(coins, weapon, armor);
    }
}

