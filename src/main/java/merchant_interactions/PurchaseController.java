package merchant_interactions;

import temporary_classes.*;
import inventory.*;

public class PurchaseController {
    /**
     * Controller for facilitating transaction between temporary_classes.Player and merchant_interactions.Merchant
     */

    private Player steve;
    private Merchant merchant;
    private Equipment item;

    /**
     * userInput is used temporarily in place for GUI button press, and should only take on the values
     * of "inventory.Weapon" or "inventory.Armor"
     */
    public PurchaseController (Player player, String userInput){
        steve = player;
        if (userInput.equals("inventory.Weapon")){
            item = player.getInventory().getWeapon();
        }
        else if (userInput.equals("inventory.Armor")){
            item = player.getInventory().getArmor();
        }
        merchant = new Merchant(item);
    }

    /**
     * Returns whether a purchase is successful; if so, deduct the Player's coins accordingly
     */
    public boolean purchase (){
        int balance = steve.getInventory().getCoins();
        if (merchant.checkAfford(balance) >= 0){
            item.upgrade();
            steve.getInventory().setCoins(merchant.checkAfford(balance));
            return true;
        }
        return false;
    }
}
