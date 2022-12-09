package entities.temporary_entities;

import entities.character.Player;

public interface CharacterCreator {

    Player createPlayer(int coins, int weaponAttribute, int armorAttribute, int HPmax, int x, int y, int kills);

    Player createPlayer(int coins, int weaponAttribute, int armorAttribute, int HPmax, int x, int y);
}
