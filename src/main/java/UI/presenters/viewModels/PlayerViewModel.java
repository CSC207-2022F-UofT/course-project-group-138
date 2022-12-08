package UI.presenters.viewModels;

import entities.character.Character;
import org.jetbrains.annotations.NotNull;
import useCases.playerUseCases.FlipStrategy;

import java.awt.*;
import java.awt.image.BufferedImage;

/*
    Purpose of this class is to segregate back-end business logic and front-end GUI. Refer to the MVVM architectural
    pattern.

    TLDR: This class (the view model) observes changes from player (the model) and communicates those changes to the
    graphics (the view).
 */
public class PlayerViewModel extends CharacterViewModel {
    /**
     * Constructs a PlayerViewModel object.
     * @param character - This should be an instance of Player
     * @param size - The size of the player, retrieved from Settings
     */
    private final Rectangle collisionRect;
    public PlayerViewModel(Character character, int size) {
        super(character, size);
        this.collisionRect = new Rectangle(size, size / 3);
    }
    @Override
    public void updatePosition() {
        super.updatePosition();
        collisionRect.x = entity.getX();
        collisionRect.y = entity.getY() + collisionRect.height * 2;
    }
    public Rectangle getCollisionRect() {
        return collisionRect;
    }
    public void updateImage(BufferedImage image){
        entityImage = FlipStrategy.getAnimationFrame((Character) entity, image);
    }
    @Override
    public void render(@NotNull Graphics2D graphics) {
        super.render(graphics);
    }
}
