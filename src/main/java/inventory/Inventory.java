package inventory;

public class Inventory implements Inv{
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
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public Armor getArmor(){
        return this.armor;
    }
    public int getCoins(){
        return this.coins;
    }
    public void setCoins(int coins){
        this.coins = coins;
    }

    /*
     * Due to merchant_interactions.Merchant interactions below methods have been handled in the inventory.Weapon and inventory.Armor
     * classes alone, not through inventory

    public void upgrade(){
        this.attribute += attribute;
    }

    }

     */

}
