package merchant_interactions;

import character.Player;
import inventory.*;

public class Purchase {
    /**
     * Use case for Purchasables
     */

    private Equipment item;
    private Player steve;

    public Purchase(Equipment item, Player player) {
        this.item = item;
        this.steve = player;
    }

    /**
     * Helper method, checks whether the Player can afford the upgrade passed to Purchase with
     *      its current coins.
     *
     * @param balance
     * @return the money left after the item is processed by Purchase. If the number is negative,
     *      the player does not have enough coins to afford said upgrade
     */
    private int checkAfford(int balance) {
        return balance - item.getPrice();
    }

    /**
     * If the Player can afford the upgrade, upgrade the item and Player's coins accordingly.
     *
     * @return true iff the upgrade was successful
     */
    public boolean purchaseAction (){
        int tempBalance = this.checkAfford(steve.getInventory().getCoins());
        if (tempBalance >= 0){
            item.upgrade();
            steve.getInventory().setCoins(tempBalance);
            return true;
        }
        return false;
    }

}
