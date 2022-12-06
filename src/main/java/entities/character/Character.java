package entities.character;

import entities.Entity;
import entities.inventory.Inventory;


public abstract class Character extends Entity {

    /**
     * An abstract class with some non abstract methods to be extended by Player and Enemy.
     */

    /**
     * Instance Variables
     */
    private final Inventory inv;
    private int HPmax;
    private int HP;
    private boolean facing_right = false;
    /**
     * === Constructors ===
     */
    public Character(Inventory inv, int HPmax, int x, int y) {
        super(x, y);
        this.inv = inv;
        this.HPmax = HPmax + inv.getArmor().getAttribute();
        this.HP = HPmax;
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

    public void setCoins(int coins) {
        this.inv.setCoins(coins);
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
    /**
     * Checks if this character is facing the right side. Otherwise, character is facing left side.
     * Mostly used for player animation, but can also be used for Mechant, enemies, etc.
     * @param facing_right - True if and only if character is facing the right side
     */
    public void setFacing_right(boolean facing_right){
        this.facing_right = facing_right;
    }
    public boolean isFacing_right(){
        return facing_right;
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