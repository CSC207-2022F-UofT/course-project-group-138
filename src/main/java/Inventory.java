public class Inventory {
    private int coins;
    private Weapon weapon;
    private Armor armor;
    public Inventory(){
        this.coins = 0;
        this.weapon = new Weapon();
        this.armor = new Armor();
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
    public void upgradeWeapon(int attack, int cost){
        this.weapon.upgrade(attack);
        this.coins -= cost;
    }
    public void upgradeArmor(int hp, int cost){
        this.armor.upgrade(hp);
        this.coins -= cost;
    }
    public void SetCoins(int coins){
        this.coins = coins;
    }

}
