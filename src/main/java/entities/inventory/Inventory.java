package entities.inventory;

public class Inventory implements InventoryInterface {
    private int coins;
    private Weapon weapon;
    private Armor armor;

    public Inventory(int coins, Weapon weapon, Armor armor) {
        this.coins = coins;
        this.weapon = weapon;
        this.armor = armor;
    }

    /**
     * @return the Weapon stored in this Inventory.
     */
    public Weapon getWeapon() {
        return this.weapon;
    }

    /**
     * @return the Armor stored in this inventory.
     */
    public Armor getArmor() {
        return this.armor;
    }

    /**
     * @return the number of coins stored in this inventory.
     */
    public int getBalance() {
        return this.coins;
    }

    /**
     * Reduces the Inventory's coin balance by the specified cost an item being purchased.
     *
     * @param cost the cost of an item being purchased.
     */
    public void reduceBalance(int cost) {
        this.coins -= cost;
    }
}
