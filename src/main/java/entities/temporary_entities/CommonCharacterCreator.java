package entities.temporary_entities;

import entities.character.Player;

public class CommonCharacterCreator implements CharacterCreator {

    private InventoryCreator invCreator = new CommonInventoryCreator();


    @Override
    public Player createPlayer(int coins, int weaponAttribute, int armorAttribute, int HPmax, int x, int y, int kills) {
        return new Player(invCreator.createInventory(coins, weaponAttribute, armorAttribute),
                HPmax,
                x,
                y,
                kills);
    }

    public Player createPlayer(int coins, int weaponAttribute, int armorAttribute, int HPmax, int x, int y) {
        return new Player(invCreator.createInventory(coins, weaponAttribute, armorAttribute),
                HPmax,
                x,
                y);
    }
}
