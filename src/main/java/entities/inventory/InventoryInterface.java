package entities.inventory;

public interface InventoryInterface {
    /**
     * Interface for Inventory, requiring it to have all the methods Player and Enemy depends on.
     */

    int getBalance();
    Weapon getWeapon();
    Armor getArmor();
}
