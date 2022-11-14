package merchant_interactions;

public class Merchant {
    /**
     * Use case for Purchasables
     */

    private Purchasable item;

    public Merchant(Purchasable item) {
        this.item = item;
    }

    /**
     * Returns the money left after the item is processed by merchant_interactions.Merchant.
     * If the number is negative, the balance is not enough to afford said upgrade.
     */
    public int checkAfford(int balance) {
        return balance - item.getPrice();
    }

}
