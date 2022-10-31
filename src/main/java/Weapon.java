public class Weapon extends Equipment {
    private int attack;
    private int price;
    public Weapon(int attack, int price){
        this.attack = attack;
        this.price = price;

    }
    public Weapon(){
        this.attack = 0;
        this.price = 0;

    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAttack() {
        return attack;
    }

    public int getPrice() {
        return price;
    }
    public void upgrade(int attack){
        this.attack += attack;
    }
}
