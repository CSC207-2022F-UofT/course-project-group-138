package useCases.playerUseCases;

import controllers.gameStates.RoomSwitcher;
import entities.dungeon.DungeonDoor;
import useCases.CollisionHandler;

import java.awt.*;

public class PlayerCollisionHandler implements CollisionHandler {
    protected Rectangle self;
    protected PlayerMover mover;
    RoomSwitcher roomSwitcher;
    public PlayerCollisionHandler(Rectangle rectangle, PlayerMover mover, RoomSwitcher switcher){
        this.self = rectangle;
        this.mover = mover;
        this.roomSwitcher = switcher;
    }
    public void handleTileCollisions(Rectangle[] dungeonTiles){
        for (Rectangle tile: dungeonTiles){
            handleCollision(tile);
        }
    }
    public void handleDoorCollisions(DungeonDoor[] doors){
        for (DungeonDoor door : doors){
            if (self.intersects(door.getRect())){
                roomSwitcher.changeRoom(door.getType());
            }
        }
    }
    private void handleCollision(Rectangle object) {

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
                mover.setPlayerY(mover.getY() - intersection.height);
            }
            else if (self.y > object.y) {
                // BOTTOM INTERSECTION
                mover.setPlayerY(mover.getY() + intersection.height);
            }
        }
        // CASE 2: Left/Right collision
        else {
            // RIGHT COLLISION
            if (self.x < object.x){
                mover.setPlayerX(mover.getX() - intersection.width);
            }
            // LEFT COLLISION
            else {
                mover.setPlayerX(mover.getX() + intersection.width);;
            }
        }
    }
}
