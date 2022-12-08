package entities.character;

import entities.inventory.Inventory;

public class Enemy extends Character implements NPC{
    private int id;
    public Enemy(Inventory inventory, int maximumHealth, int x, int y) {
        super(inventory, maximumHealth, x, y);
    }

    @Override
    public void setImageID(int id) {
        this.id = id;
    }

    @Override
    public int getImageID() {
        return id;
    }
}





