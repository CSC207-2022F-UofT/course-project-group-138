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

    public int getPrice() {
        return price;
    }

    public int getHp() {
        return hp;
    }
    public void upgrade(int hp){
        this.hp += hp;
    }
}
