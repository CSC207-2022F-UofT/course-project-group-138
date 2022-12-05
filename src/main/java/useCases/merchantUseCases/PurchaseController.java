package useCases.merchantUseCases;

import entities.character.Merchant;
import entities.character.Player;
import settings.Settings;

import java.util.HashMap;

public class PurchaseController {

    private Player player;
    private Merchant merchant;

    public PurchaseController(Player player, Merchant merchant) {
        this.player = player;
        this.merchant = merchant;
    }

    public String getPurchaseOption() {
        /*
        Item available for sale depends on the Merchant and Player.
            (1) If the Merchant is selling Armor, and the Player's Armor is broken, the Merchant will offer new default Armor.
            (2) If the Merchant is selling Armor, and the Player's Armor is NOT broken, the Merchant will offer to upgrade the Player's Armor.
            (3) If the Merchant is selling a Weapon, the Merchant will offer to upgrade the Player's Weapon.

        These options are returned as a String with 3 terms seperated by dashes (-) with the following format:
            (1) RA  -   (New Armor durability as int)           -   (Price of new Armor as int)
            (2) UA  -   (Armor upgrade percentage as double)    -   (Price of Armor upgrade as int)
            (3) UW  -   (Weapon upgrade percentage as double)   -   (Price of Weapon upgrade as int)
         */
        if (this.merchant.getItem().equals("Armor")) {
            if (this.player.getArmorDurability() == 0) {
                return String.format("RA-%d-%d", Settings.getDefaultPlayerArmor(), this.merchant.getPrice(true));           // Option (1)
            } else {
                return String.format("UA-%f-%d", this.merchant.getUpgradeValue(), this.merchant.getPrice(false));           // Option (2)
            }
        } else {
            return String.format("UW-%f-%d", this.merchant.getUpgradeValue(), this.merchant.getPrice(false));               // Option (3)
        }
    }

    public void purchase() throws LowBalanceException {
        String[] purchaseOptionTerms = this.getPurchaseOption().split("-");
        if (this.player.getCoins() < Integer.parseInt(purchaseOptionTerms[2])) {
            throw new LowBalanceException();
        } else {
            this.player.spendCoins(Integer.parseInt(purchaseOptionTerms[2]));
        } switch (purchaseOptionTerms[0]) {
            case "RA":
                this.player.renewArmor(Integer.parseInt(purchaseOptionTerms[1]));
                break;
            case "UA":
                this.player.upgradeArmor(Double.parseDouble(purchaseOptionTerms[1]));
                break;
            case "UW":
                this.player.upgradeWeapon(Double.parseDouble(purchaseOptionTerms[1]));
                break;
        }
    }

    private static class LowBalanceException extends Exception {
        public LowBalanceException() {
            super("Insufficient coinc balance to purchase item(s).");
        }
    }
}
