package UI.presenters;

import entities.character.Character;
import org.jetbrains.annotations.NotNull;
import settings.Settings;

import java.awt.*;

public abstract class ViewModel extends Rectangle {
    protected Character character;
    protected Image characterImage;
    /**
     * Not to be called, contains code so that children can inherit.
     * @param character - The character object
     * @param size - The size of the character, retrieved from Settings
     */
    public ViewModel(Character character, int size){
        super(character.getx() * size, character.gety() * size, size, size);
        this.character = character;
    }
    /**
     * This should be continuously called from the game loop, so that the view model can observe the changes.
     * This method updates the character's
     */
    public void updatePosition(){
        super.x = character.getx();
        super.y = character.gety();
    }

    /**
     * Updates the image of this character. Must call this method before render method.
     */
    public void updateImage(Image image){
        characterImage = image;
    }
    /**
     * This will draw the user's drawn image onto graphics
     * @param graphics - Graphics object in which the player will be drawn.
     */
    public void render(@NotNull Graphics graphics){
        graphics.drawImage(characterImage, super.x, super.y, super.width, super.height, null);
    }
}
