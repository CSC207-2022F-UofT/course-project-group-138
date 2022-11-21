package entites;

import inventory.Armor;
import inventory.Inventory;
import inventory.Weapon;
import temporary_classes.Player;

public class PlayerCreator implements CharactorCreator {
    @Override
    public Player create(String playerCoins,
                         String playerWeaponAttack,
                         String playerWeaponPrice,
                         String playerArmorHp,
                         String playerArmorPrice,
                         String player_hp,
                         String playerNumOfEnenmySlayed) {
        Weapon weapon = new Weapon(Integer.parseInt(playerWeaponAttack), Integer.parseInt(playerWeaponPrice));
        Armor armor = new Armor(Integer.parseInt(playerArmorHp), Integer.parseInt(playerArmorPrice));
        Inventory invenotry = new Inventory(weapon, armor, Integer.parseInt(playerCoins));
        return new Player(invenotry, Integer.parseInt(player_hp), Integer.parseInt(playerNumOfEnenmySlayed));
    }
}
