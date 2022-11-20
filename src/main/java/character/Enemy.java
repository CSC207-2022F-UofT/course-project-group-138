package character;

import inventory.*;

public class Enemy extends Character{


    /**
     * Instance Variables
     */
    private final Inventory enemyInv;
    private int HP;

    private int x;

    private int y;


    /**
     * === Getters and Setters ===
     */

    public Inventory getInventory(){
        return enemyInv;
    }

    public int getCoins() {
        return this.enemyInv.getCoins();
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


    /**
     * === Constructor ===
     */

    public Enemy(Inventory inventory, int HP){
        this.enemyInv = inventory;
        this.HP = HP + this.enemyInv.getArmor().getAttribute();
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





