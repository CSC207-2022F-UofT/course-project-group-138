package character;

import inventory.*;

public class Player extends Character{

    /**
     * Instance Variables
     */
    private final Inventory playerInv;
    private int HP;

    private int x;
    private int y;
    private int kills;

    /**
     * === Getters and Setters ===
     */
    public Inventory getInventory(){
        return playerInv;
    }
    public int getCoins() {
        return this.playerInv.getCoins();
    }
    public int getHP(){
        return this.HP;
    }
    public void setHP(int HP){
        this.HP += HP;
    }
    public int getx(){
        return this.x;
    }
    public int gety(){
        return this.y;
    }
    public void setPosition(int x, int y) {
        this.x += x;
        this.y += y;
    }
    public int getKills(){
        return this.kills;
    }
    public void increaseKills() {
        this.kills += 1;
    }

    /**
     * === Constructor ===
     */
    public Player(Inventory inventory, int HP, int kills){
        this.playerInv = inventory;
        this.HP = HP + this.playerInv.getArmor().getAttribute();
        this.kills = kills;
    }
    public Player(Inventory inventory, int HP) {
        this.playerInv = inventory;
        this.HP = HP + this.playerInv.getArmor().getAttribute();
        this.kills = 0;
    }

    /**
     * === Methods ===
     */
    public int attack() {
        return getInventory().getWeapon().getAttribute();
    }
    public boolean isAlive(){
        return this.HP > 0;
    }

}


