package useCases;

import entities.character.Character;

public class Attack {
    /**
     * A class for handling one character attacking another. To be repeatedly called on by a combat loop.
     *
     * Performing an attack would be considered a use case, and thus class Attack is allowed to depend on entities.
     */

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
    }


}
