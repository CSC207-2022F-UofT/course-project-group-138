package entities.inventory;

public interface Inv {

    /**
     * Interface for Inventory, requiring it to have all the methods Player and Enemy depends on.
     */
    int getCoins();
    Weapon getWeapon();
    Armor getArmor();
}
