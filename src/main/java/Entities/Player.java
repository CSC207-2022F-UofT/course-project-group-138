package Entities;

import inventory.*;

public class Player extends Character{
    /* temporary, used for Merchant methods, replace later with fully implemented Player */

    private Inventory playerInv;
    private int enemiesSlain;

    public Inventory getInventory(){
        return playerInv;
    }

    public Player(Inventory inventory, int maxHp, int numOfSlayed){
        this.playerInv = inventory;
        this.maxHp = maxHp;
        this.enemiesSlain = numOfSlayed;
    }
    public int showBalance(){
        return this.playerInv.getCoins();
    }
    public void showPosition(){}
    public int getNumOfEnemySlain(){
        return this.enemiesSlain;
    }
    public void setNumOfEnemySlain(int num){
        this.enemiesSlain = num;
    }
    public int getHp(){
        return this.hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public boolean isAlive(){
        return this.hp > 0;
    }
}

