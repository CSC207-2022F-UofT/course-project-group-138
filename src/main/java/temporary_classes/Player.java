package temporary_classes;

import inventory.*;

public class Player extends Character{
    /* temporary, used for Merchant methods, replace later with fully implemented Player */

    private Inventory playerInv;
    private int HP;
    private int NumOfEnemySlayed;

    public Inventory getInventory(){
        return playerInv;
    }

    public Player(Inventory inventory, int HP, int numOfSlayed){
        this.playerInv = inventory;
        this.HP = HP;
        this.NumOfEnemySlayed = numOfSlayed;

    }
    public int showBalance(){
        return this.playerInv.getCoins();
    }
    public void showPosition(){

    }
    public int getNumOfEnemySlain(){
        return this.NumOfEnemySlayed;
    }
    public void setNumOfEnemySlain(int num){
        this.NumOfEnemySlayed = num;
    }

    public int getHP(){
        return this.HP;
    }

    public void setHP(int HP){
        this.HP = HP;
    }
    public boolean isAlive(){
        return this.HP > 0;
    }

}

