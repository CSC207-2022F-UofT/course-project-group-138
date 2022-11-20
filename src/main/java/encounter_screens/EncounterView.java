package encounter_screens;

abstract class EncounterView {
    /**
     * Possible GUI for interaction with Enemy and merchant_interactions.Merchant
     */

    /**
     * Method for interacting with either merchant_interactions.Merchant or Enemy.
     * Triggers corresponding action.
     */
    public abstract void action();

    /**
     * Leave the encounter screen.
     */
    public void leave(){
        /* leave */
    }
}
