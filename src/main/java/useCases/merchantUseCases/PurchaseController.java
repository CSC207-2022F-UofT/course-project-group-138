package useCases.merchantUseCases;

import entities.character.Player;
import entities.inventory.Equipment;

import java.awt.event.ActionEvent;

public class PurchaseController {
    /**
     * Controller for facilitating transaction between temporary_classes.Player and merchant_interactions.Merchant
     */

    private Player steve;
    private Purchase purchase;
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
        if (userInput.equals("Weapon")) {
            item = player.getInventory().getWeapon();
        } else if (userInput.equals("Armor")) {
            item = player.getInventory().getArmor();
        }
        purchase = new Purchase(item, steve);
    }

    public PurchaseController(ActionEvent e) {
    }

    /**
     * @return true if the purchase was successful.
     */
    public boolean purchaseCheck (){
        return purchase.purchaseAction();
    }

}
