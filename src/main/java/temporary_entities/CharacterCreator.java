package temporary_entities;

import character.Player;
import inventory.Inventory;

public interface CharacterCreator {

    Player createPlayer(Inventory inventory, int HPmax, int x, int y, int kills);
}
