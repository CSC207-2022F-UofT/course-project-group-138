package useCases;

import useCases.playerUseCases.PlayerMover;

import java.awt.*;

/**
 * An abstract class outlining Collision handling methodology
 */
public interface CollisionHandler {
    void handleCollision(Rectangle object);
}
