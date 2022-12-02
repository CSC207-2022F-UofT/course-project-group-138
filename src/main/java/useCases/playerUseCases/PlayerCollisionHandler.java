package useCases.playerUseCases;

import entities.character.Character;
import useCases.CollisionHandler;

import java.awt.*;

public class PlayerCollisionHandler extends CollisionHandler {

    public PlayerCollisionHandler(Rectangle rectangle, Character character) {
        super(rectangle, character);
    }

    @Override
    public void handleCollision(Rectangle object) {

        Rectangle intersection = self.intersection(object);
        if (intersection.isEmpty()){return;}

        // TOTAL 4 CASES: Top, Bottom, Left or right collisions

        // CASE 1: Top/Bottom collision: Intersection width would be greater than height.

        if (intersection.width > intersection.height){
            // Visually, this rectangle will stop moving. However, it "teleports" rectangle back to a non-intersecting
            // point, just in case player is stuck in a immovable loop.
            if (self.y < object.y){
                // TOP INTERSECTION
                character.setY(object.y - self.height);
            }
            else {
                self.y = object.y + self.height;
                character.setY(object.y + self.height);
            }
        }
    }
}
