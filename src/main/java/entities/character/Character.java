package entities.character;

import entities.inventory.Inventory;


public abstract class Character {

    /**
     * An abstract class with some non abstract methods to be extended by Player and Enemy.
     */

    /**
     * Instance Variables
     */
    private final Inventory inv;

    private int HPmax;

    private int HP;

    private int x;

    private int y;


    /**
     * === Constructors ===
     */
    public Character(Inventory inv, int HPmax, int x, int y) {
        this.inv = inv;
        this.HPmax = HPmax + inv.getArmor().getAttribute();
        this.HP = HPmax;
        this.x = x;
        this.y = y;
    }


    /**
     * === Getters and Setters ===
     */
    public Inventory getInventory(){
        return inv;
    }

    public int getCoins() {
        return this.inv.getCoins();
    }

    public int getHPmax() {
        return this.HPmax;
    }

    public void changeHPmax(int upgrade) {
        this.HPmax += upgrade;
    }

    public int getHP(){
        return this.HP;
    }

    public void changeHP(int HP){
        this.HP += HP;
    }

    public void setHP() {
        this.HP = this.HPmax;
    }

    public int getx(){
        return this.x;
    }

    public int gety(){
        return this.y;
    }

    public void changex(int x) {
        this.x += x;
    }

    public void changey(int y) {
        this.y += y;
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