package inventory;

public class Armor implements Equipment {
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

    public int getAttribute() {
        return hp;
    }

    /**
     * merchant_interactions.Merchant interactions
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
