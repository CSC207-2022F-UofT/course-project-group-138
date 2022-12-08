package entities.character;

public class Merchant {
    private final String item;
    private final int originalPrice;
    private int currentPrice;
    private int timesPurchased;
    private int x, y;

    public Merchant(String item, int price, int x, int y) {
        this.item = item;
        this.originalPrice = price;
        this.currentPrice = this.originalPrice;
        this.timesPurchased = 0;
        this.x = x;
        this.y = y;
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
}
