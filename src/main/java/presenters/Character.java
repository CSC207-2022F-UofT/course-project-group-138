package Entities;

import inventory.Inventory;

import java.awt.*;

public abstract class Character {
    protected int hp;
    protected int maxHp;
    public abstract int getHp();
    public abstract void setHp(int hp);
    public abstract Inventory getInventory();
    public abstract boolean isAlive();
}