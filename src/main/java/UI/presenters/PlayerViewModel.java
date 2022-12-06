package UI.presenters;

import entities.character.Character;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/*
    Purpose of this class is to segregate back-end business logic and front-end GUI. Refer to the MVVM architectural
    pattern.

    TLDR: This class (the view model) observes changes from player (the model) and communicates those changes to the
    graphics (the view).
 */
public class PlayerViewModel extends CharacterViewModel{
    /**
     * Constructs a PlayerViewModel object.
     * @param character - This should be an instance of Player
     * @param size - The size of the player, retrieved from Settings
     */
    private final Rectangle collisionRect;
    public PlayerViewModel(Character character, int size) {
        super(character, size);
        this.collisionRect = new Rectangle(size, size / 2);
    }
    @Override
    public void updatePosition() {
        super.updatePosition();
        collisionRect.x = entity.getx();
        collisionRect.y = entity.gety() - collisionRect.height;
    }
    public Rectangle getCollisionRect() {
        return collisionRect;
    }
}
