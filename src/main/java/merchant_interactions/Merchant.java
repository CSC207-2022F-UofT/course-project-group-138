package merchant_interactions;

import temporary_classes.Player;

public class Merchant {
    /**
     * Use case for Purchasables & Player/Inventory
     */

    private Purchasable item;
    private Player steve;

    public Merchant(Purchasable item, Player player) {
        this.item = item;
        this.steve = player;
    }

    /**
     * Helper method
     * Calculates the money left after item is upgraded by Merchant.
     * If the number is negative, the balance is not enough to afford said upgrade.
     *
     * @param balance the player's coins.
     * @return int representing the leftover coins after an upgrade of item.
     */
    private int checkAfford(int balance) {
        return balance - item.getPrice();
    }

    /**
     * Upgrades item and Player's coins accordingly, iff the Player can afford the upgrade.
     *
     * @return whether the upgrade was successful
     */
    public boolean purchase (){
        int tempBalance = this.checkAfford(steve.getInventory().getCoins());
        if (tempBalance >= 0){
            item.upgrade();
            steve.getInventory().setCoins(tempBalance);
            return true;
        }
        return false;
    }

}
