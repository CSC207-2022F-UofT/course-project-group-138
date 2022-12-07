package entities.character;

import entities.Entity;
import entities.inventory.Inventory;

/**
 * An abstract class to be extended by Player and Enemy.
 */
public abstract class Character extends Entity {
    private final Inventory inventory;
    private int maximumHealth;
    private int currentHealth;
    private boolean facing_right = true;

    public Character(Inventory inventory, int maximumHealth, int x, int y) {
        super(x, y);
        this.inventory = inventory;
        this.maximumHealth = maximumHealth;
        this.currentHealth = this.maximumHealth;
    }

    /**
     * Upgrades the maximum health the Character can have (but not the Character's current health).
     *
     * @param upgrade how much more maximum health the Character can posssess.
     */
    public void upgradeMaximumHealth(int upgrade) {
        this.maximumHealth += upgrade;
    }

    /**
     * Recharges the Character's health by the specified amount.
     *
     * @param HP how much more health to grant the Character.
     */
    public void rechargeHealth(int HP) {
        this.currentHealth += HP;
    }

    /**
     * Fully recharges the Character's health to the maximum amount.
     */
    public void rechargeHealthFull() {
        this.currentHealth = this.maximumHealth;
    }

    /**
     * Changes Armor durability to the provided durability, to renew broken Armor.
     *
     * @param newArmorDurability the new durability of the Character's Armor.
     */
    public void renewArmor(int newArmorDurability) {
        this.inventory.getArmor().renewArmor(newArmorDurability);
    }

    /**
     * Upgrades the durability of the Character's Armor by the specified percentage.
     *
     * @param multiplier the percentage to increase the durability by.
     */
    public void upgradeArmor(double multiplier) {
        this.inventory.getArmor().upgradeStrength(multiplier);
    }

    /**
     * Upgrades the durability of the Character's Weapon by the specified percentage.
     *
     * @param multiplier the percentage to increase the durability by.
     */
    public void upgradeWeapon(double multiplier) {
        this.inventory.getWeapon().upgradeStrength(multiplier);
    }

    public void spendCoins(int cost) {
        this.inventory.reduceBalance(cost);
    }

    /**
     * Deals damage to the Character from an incoming attack and distributes it, as applicable, between the Character's Armor and health.
     *
     * @param damage the amount of incoming damage.
     */
    public void damage(int damage) {
        if (!this.inventory.getArmor().isBroken()) {
            int armorDamage = (int) Math.round(damage * (2.0 / 3.0));                // Armor will absorb two-thirds of incoming damage, upto its durability
            if (armorDamage > this.getArmorDurability()) {
                armorDamage = this.getArmorDurability();
            }
            if (this.currentHealth < damage - armorDamage) {
                this.currentHealth = 0;                                             // If incoming damage is greater than health, set health to 0
            } else {
                this.currentHealth -= (damage - armorDamage);
            }
            this.inventory.getArmor().reduceDurability(armorDamage);
        } else {
            if (this.currentHealth < damage) {
                this.currentHealth = 0;                                             // If incoming damage is greater than health, set health to 0
            } else {
                this.currentHealth -= damage;
            }
        }
    }

    /**
     * Changes the Character's x-coordinate value by the specified amount.
     *
     * @param x the amount to increase (or decrease, if negative) the x-coordinate value by.
     */
    public void changex(int x) {
        this.x += x;
    }

    /**
     * Changes the Character's y-coordinate value by the specified amount.
     *
     * @param y the amount to increase (or decrease, if negative) the y-coordinate value by.
     */
    public void changey(int y) {
        this.y += y;
    }

    /**
     * @return the number of coins this Character has stored in its Inventory.
     */
    public int getCoins() {
        return this.inventory.getBalance();
    }

    /**
     * @return the current health of the Character.
     */
    public int getCurrentHealth() {
        return this.currentHealth;
    }

    /**
     * @return the attack power of the Character's Weapon.
     */
    public int getAttackPower() {
        return this.inventory.getWeapon().getStrength();
    }

    /**
     * @return the durability of the Character's Armor.
     */
    public int getArmorDurability() {
        return this.inventory.getArmor().getStrength();
    }

    /**
     * @return the x-coordinate value of the Character.
     */
    public int getx() {
        return this.x;
    }

    /**
     * @return the y-coordinate value of the Character.
     */
    public int gety() {
        return this.y;
        /**
         * Checks if this character is facing the right side. Otherwise, character is facing left side.
         * Mostly used for player animation, but can also be used for Mechant, enemies, etc.
         * @param facing_right - True if and only if character is facing the right side
         */
    }
    public void setFacing_right(boolean facing_right){
        this.facing_right = facing_right;
    }
    public boolean isFacing_right() {
        return facing_right;
    }
}