package useCases.playerUseCases;

import useCases.CollisionHandler;
import entities.dungeon.DungeonTile;

import java.awt.*;

public class PlayerCollisionHandler implements CollisionHandler {
    private Rectangle[] dungeonTiles;
    protected Rectangle self;
    protected PlayerMover mover;
    public PlayerCollisionHandler(Rectangle rectangle, PlayerMover mover, Rectangle[] dungeonTiles){
        this.self = rectangle;
        this.mover = mover;
        this.dungeonTiles = dungeonTiles;
    }
    public void handleTileCollisions(){
        for (Rectangle tile: dungeonTiles){
            handleCollision(tile);
        }
    }

    @Override
    public void handleCollision(Rectangle object) {

        Rectangle intersection = self.intersection(object);
        if (intersection.isEmpty()){return;}
        int playerTop = self.y - 30;

        // TOTAL 4 CASES: Top, Bottom, Left or right collisions

        // CASE 1: Top/Bottom collision: Intersection width would be greater than height.

        if (intersection.width > intersection.height){
            // Visually, this rectangle will stop moving. However, it "teleports" rectangle back to a non-intersecting
            // point, just in case player is stuck in a immovable loop.
            if (self.y < object.y){
                // TOP INTERSECTION
                mover.setPlayerY(self.y - intersection.height);
            }
            else if (self.y > object.y) {
                // BOTTOM INTERSECTION
                mover.setPlayerY(self.y + intersection.height);
            }
        }
        // CASE 2: Left/Right collision
        else {
            // RIGHT COLLISION
            if (self.x < object.x){
                mover.setPlayerX(self.x - intersection.width);
            }
            // LEFT COLLISION
            else {
                mover.setPlayerX(self.x + intersection.width);;
            }
        }
    }

}
