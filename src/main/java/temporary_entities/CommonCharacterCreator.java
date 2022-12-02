package temporary_entities;

import character.Player;
import inventory.Inventory;

public class CommonCharacterCreator implements CharacterCreator {
    @Override
    public Player createPlayer(Inventory inventory, int HPmax, int x, int y, int kills) {
        return new Player(inventory, HPmax, x, y, kills);
    }
}
