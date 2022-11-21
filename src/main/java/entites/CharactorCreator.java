package entites;

import temporary_classes.Player;

public interface CharactorCreator {

    Player create(String playerCoins,
                  String playerWeaponAttack,
                  String playerWeaponPrice,
                  String playerArmorHp,
                  String playerArmorPrice,
                  String player_hp,
                  String playerNumOfEnenmySlayed);
}
