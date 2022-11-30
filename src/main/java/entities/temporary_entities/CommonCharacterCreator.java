package entities.temporary_entities;

import entities.character.Player;
import entities.inventory.Inventory;

public class CommonCharacterCreator implements CharacterCreator {
    @Override
    public Player createPlayer(Inventory inventory, int HPmax, int x, int y, int kills) {
        return new Player(inventory, HPmax, x, y, kills);
    }
}
