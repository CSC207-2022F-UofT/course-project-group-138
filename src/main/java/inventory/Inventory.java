package inventory;

public class Inventory {
    private int coins;
    private Weapon weapon;
    private Armor armor;
    public Inventory(){
        this.coins = 0;
        this.weapon = new Weapon();
        this.armor = new Armor();
    }
    public Inventory(Weapon weapon, Armor armor, int coins){
        this.coins = coins;
        this.weapon = weapon;
        this.armor = armor;
    }
    public Weapon getWeapon(){
        return this.weapon;
    }
    public int getCoins(){
        return this.coins;
    }
    public Armor getArmor(){
        return this.armor;
    }
    public void setCoins(int coins){
        this.coins = coins;
    }

    /*
     * Due to Merchant interactions below methods have been handled in the inventory.Weapon and inventory.Armor
     * classes alone, not through inventory

    public void upgradeWeapon(int attack, int cost){
        this.weapon.upgrade(attack);
        this.coins -= cost;
    }
    public void upgradeArmor(int hp, int cost){
        this.armor.upgrade(hp);
        this.coins -= cost;
    }

     */

}
