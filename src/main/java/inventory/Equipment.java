package inventory;

import merchant_interactions.Purchasable;

public abstract class Equipment implements Purchasable {
    public abstract int getPrice();

    public abstract void upgrade();
}
