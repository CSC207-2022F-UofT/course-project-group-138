package useCases.playerUseCases;

import controllers.gameStates.RoomSwitcher;
import entities.dungeon.DungeonDoor;
import useCases.CollisionHandler;
import entities.dungeon.DungeonDoor.Door;

import java.awt.*;
import java.util.HashMap;

public class PlayerCollisionHandler implements CollisionHandler {
    protected Rectangle self;
    protected PlayerMover mover;
    RoomSwitcher roomSwitcher;
    HashMap<Door, Integer> doorMap;
    public PlayerCollisionHandler(Rectangle rectangle, PlayerMover mover, RoomSwitcher switcher){
        this.self = rectangle;
        this.mover = mover;
        this.roomSwitcher = switcher;
        doorMap = buildDoorMap();
    }
    public void handleTileCollisions(Rectangle[] dungeonTiles){
        for (Rectangle tile: dungeonTiles){
            handleCollision(tile);
        }
    }
    public void handleDoorCollisions(DungeonDoor[] doors, int roomType){
        for (DungeonDoor door : doors){
            if (roomType >= doorMap.get(door.getType()) && self.intersects(door.getRect())){
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
    /**
     * Creates a HashMap and notes which tiles correspond with which room type
     * @return - The door map
     */
    private HashMap<Door, Integer> buildDoorMap(){
        HashMap<Door, Integer> doorMap = new HashMap<>();
        doorMap.put(Door.TOP_LEFT, 5);
        doorMap.put(Door.TOP_MID, 3);
        doorMap.put(Door.TOP_RIGHT, 6);
        doorMap.put(Door.LEFT, 1);
        doorMap.put(Door.RIGHT, 0);
        doorMap.put(Door.BOTTOM, 4);
        return doorMap;
    }
}
