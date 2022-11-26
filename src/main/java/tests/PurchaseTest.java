package tests;

import character.Player;
import inventory.Armor;
import inventory.Inventory;
import inventory.Weapon;
import merchant_interactions.Purchase;
import merchant_interactions.PurchaseController;
import org.junit.Test;
import settings.Settings;

public class PurchaseTest {
    private Weapon weapon = new Weapon(1,2);
    private Armor armor = new Armor(3,4);
    private Inventory inv = new Inventory(weapon, armor, 0);
    private Player player = new Player(inv, 0,0,0);

    @Test
    public void testPurchaseSuccess(){
        Purchase p = new Purchase(weapon, player);
        player.getInventory().setCoins(2);
        assert p.purchaseAction();
        assert player.getInventory().getCoins() == 0;
    }

    @Test
    public void testPurchaseFail(){
        Purchase p = new Purchase(weapon, player);
        player.getInventory().setCoins(1);
        assert !p.purchaseAction();
        assert player.getInventory().getCoins() == 1;
    }

    @Test
    public void testPurchaseController(){
        player.getInventory().setCoins(2);
        PurchaseController pc = new PurchaseController(player, "Weapon");
        assert pc.purchaseCheck();
    }
}