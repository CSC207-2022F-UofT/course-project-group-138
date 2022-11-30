package UI.presenters;

import UI.presenters.statePresenters.ViewModel;
import entities.character.Character;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
/*
    Purpose of this class is to segregate back-end business logic and front-end GUI. Refer to the MVVM architectural
    pattern.

    TLDR: This class (the view model) observes changes from player (the model) and communicates those changes to the
    graphics (the view).
 */
public class PlayerViewModel extends ViewModel {
    /**
     * Constructs a PlayerViewModel object.
     * @param character - This should be an instance of Player
     * @param size - The size of the player, retrieved from Settings
     */
    public PlayerViewModel(Character character, int size) {
        super(character, size);
    }
    //@TODO add collide method, and make this class abstract


    /**
     * This will draw the user's drawn image onto graphics
     * @param graphics - Graphics object in which the player will be drawn.
     */
    public void render(@NotNull Graphics graphics){
        graphics.drawImage(characterImage, super.x, super.y, super.width, super.height, null);
    }

}
