package entities.inventory;

public abstract class Equipment {
    protected int strength;                              // Attack power for Weapon, defense durability for Armor

    public Equipment(int power) {
        this.strength = power;
    }

    /**
     * @return the attack power for Weapon, or the defense durability for Armor.
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     * Increases the attack power for Weapon, or the defense durability for Armor, by the specified percentage.
     *
     * @param multiplier the percentage to increase by.
     */
    public void upgradeStrength(double multiplier) {
        this.strength = (int)Math.round(this.strength * (1.00 + multiplier));
    }
}
