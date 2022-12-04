package combat;

import entities.character.Character;

public class Attack {
    /**
     * A class for handling one character attacking another. To be repeatedly called on by a combat loop.
     *
     * Performing an attack would be considered a use case, and thus class Attack is allowed to depend on entities.
     */

//    /**
//     * === Instance Variables ===
//     */
//    private final Character char1;
//    private final Character char2;
//    private boolean isPlayerTurn;

//    /**
//     * === Constructor ===
//     */
//    public Attack(Character char1, Character char2) {
//        this.char1 = char1;
//        this.char2 = char2;
//        this.isPlayerTurn = true;
//    }

    /**
     * Performs an attack using the weapon attack value in the char1's inventory, applying the damage to char2's hp.
     * @param char1 - the character attacking
     * @param char2 - the character being attacked
     * @return - return whether or not the attack resulted in a kill
     */
    public static boolean taketurn(Character char1, Character char2) {
        int damage = char1.attack();
        char2.changeHP(-damage);
        return char2.isAlive();
//        if (isPlayerTurn) {
//            int damage = this.player.attack();
//            this.enemy.changeHP(-damage);
//            this.isPlayerTurn = false;
//            return this.enemy.isAlive();
//        }
//        else {
//            int damage = this.enemy.attack();
//            this.player.changeHP(-damage);
//            this.isPlayerTurn = true;
//            return this.player.isAlive();
//        }
    }


}
