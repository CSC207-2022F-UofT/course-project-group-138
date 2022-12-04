package entities.temporary_entities;

import entities.character.Player;
import entities.inventory.Inventory;

public interface CharacterCreator {

    Player createPlayer(Inventory inventory, int HPmax, int x, int y, int kills);
}
