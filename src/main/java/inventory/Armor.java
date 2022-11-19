package inventory;

public class Armor extends Equipment{
    public int price;
    public int hp;
    public Armor(int hp, int price){
        this.hp = hp;
        this.price = price;
    }
    public Armor(){
        this.price = 0;
        this.hp = 0;
    }

    public int getHp() {
        return hp;
    }

    /**
     * Merchant interactions
     */

    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public void upgrade(){
        this.hp += hp;
    }
}
