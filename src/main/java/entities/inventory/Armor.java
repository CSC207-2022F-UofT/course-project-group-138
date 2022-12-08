package entities.inventory;


public class Armor extends Equipment {
    public Armor(int durability) {
        super(durability);
    }

    /**
     * Reduces the durability of the Armor when it takes damage.
     *
     * @param damage the damage taken by the Armor.
     */
    public void reduceDurability(int damage){
        this.strength -= damage;
    }

    /**
     * Changes Armor durability to the provided durability, to renew broken Armor.
     *
     * @param durability the new durability of the Armor.
     */
    public void renewArmor(int durability) {
        this.strength = durability;
    }

    /**
     * @return whether the Armor durability is 0, therefore unable to absorb damage.
     */
    public boolean isBroken() {
        return this.strength == 0;
    }
}
