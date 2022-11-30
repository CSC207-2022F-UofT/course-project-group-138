package UI.presenters.statePresenters;

import entities.character.Character;
import org.jetbrains.annotations.NotNull;
import settings.Settings;

import java.awt.*;

public abstract class ViewModel extends Rectangle {
    private Character character;
    private Image characterImage;
    public ViewModel(Character character, int size){
        super(character.getx() * size, character.gety() * size, size, size);
        this.character = character;
    }
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
