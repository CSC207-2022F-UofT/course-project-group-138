package merchant_interactions;

public interface Purchasable {
    /**
     * Entity interface for Equipments (inventory.Weapon and inventory.Armor), for incorporation of merchant_interactions.
     */
    public int getPrice();

    public void upgrade();
}
