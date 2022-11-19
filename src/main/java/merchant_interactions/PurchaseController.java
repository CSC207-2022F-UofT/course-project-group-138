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
     * Passes the Player and the item to be upgraded to the Merchant.
     *
     * @param player the Player whose inventory is being accessed.
     * @param userInput type of item to be upgraded, should only take on the values of
     *                  "inventory.Weapon" or "inventory.Armor".
     */
    public PurchaseController (Player player, String userInput){
        steve = player;
        //TODO: Replace String with GUI.Button presses
        if (userInput.equals("inventory.Weapon")){
            item = player.getInventory().getWeapon();
        }
        else if (userInput.equals("inventory.Armor")){
            item = player.getInventory().getArmor();
        }
        merchant = new Merchant(item, steve);
    }

    /**
     * @return true if the purchase was successful.
     */
    public boolean purchase (){
        return merchant.purchase();
    }


}
