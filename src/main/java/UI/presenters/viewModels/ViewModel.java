package UI.presenters.viewModels;

import entities.character.Entity;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class ViewModel extends Rectangle {
    protected Entity entity;
    protected BufferedImage entityImage;
    /**
     * Not to be called, contains code so that children can inherit.
     * @param entity - The character object
     * @param size - The size of the character, retrieved from Settings
     */
    public ViewModel(Entity entity, int size){
        super(entity.getX() * size, entity.getY() * size, size, size);
        this.entity = entity;
    }
    /**
     * This should be continuously called from the game loop, so that the view model can observe the changes.
     * This method updates the character's rectangle position so that it matches with its actual position.
     *
     * This method is encapsulated here in case we want to implement movable enemies in the future.
     */
    public void updatePosition(){
        super.x = entity.getX();
        super.y = entity.getY();
    }
    public abstract void updateImage(BufferedImage image);

    /**
     * This will draw this character's sprite
     * @param graphics - Graphics object in which the player will be drawn.
     */
    public void render(@NotNull Graphics2D graphics){
        graphics.drawImage(entityImage, super.x, super.y, super.width, super.height, null);
    }
}
