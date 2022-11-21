package character;

import inventory.*;

public class Player extends Character{

    /**
     * Instance Variables
     */
    private int kills;


    /**
     * === Constructor ===
     */
    public Player(Inventory inv, int HPmax, int x, int y, int kills){
        super(inv, HPmax, x, y);
        this.kills = kills;
    }
    public Player(Inventory inv, int HPmax, int x, int y) {
        super(inv, HPmax, x, y);
        this.kills = 0;
    }


    /**
     * === Getters and Setters ===
     */
    public int getKills(){
        return this.kills;
    }

    public void increaseKills() {
        this.kills += 1;
    }


    /**
     * === Methods ===
     */

}


