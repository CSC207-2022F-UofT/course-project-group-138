package entities.character;

public class Merchant extends Entity implements NPC{
    private final String item;
    private final int originalPrice;
    private int currentPrice;
    private int timesPurchased;
    private int id;

    public Merchant(String item, int price, int x, int y) {
        super(x, y);
        this.item = item;
        this.originalPrice = price;
        this.currentPrice = this.originalPrice;
        this.timesPurchased = 0;
    }

    public int getPrice(boolean renewArmor) {
        if (renewArmor) {
            return this.originalPrice;
        } else {
            return this.currentPrice;
        }
    }

    public double getUpgradeValue() {
        return 0.1 * (double)(2^(this.timesPurchased / 2));
    }

    public String getItem() {
        return this.item;
    }

    public void purchase() {
        this.timesPurchased++;
        this.currentPrice = this.originalPrice * 2^(this.timesPurchased / 2);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setImageID(int id) {
        this.id = id;
    }

    @Override
    public int getImageID() {
        return id;
    }
}
