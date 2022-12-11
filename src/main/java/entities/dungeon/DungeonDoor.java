package entities.dungeon;

import java.awt.*;

public class DungeonDoor extends DungeonTile{
    /**
     * Just an idea for now. But we need to a way for the player to traverse between rooms. This would need to be
     * instantiated when generating the dungeon map.
     *
     */
    DungeonRoom room; // Represents what room this door leads to
    Door type;

    public enum Door{
        TOP_LEFT,
        TOP_MID,
        TOP_RIGHT,
        LEFT,
        RIGHT,
        BOTTOM
    }

    /**
     * Sets the door's collision rectangle
     * @param rectangle - The door's collision rectangle
     */
    public void setRect(Rectangle rectangle){
        this.tileRect = rectangle;
    }

    /**
     * Gets the door's collision rectangle
     * @return - The door's collision rectangle
     */
    public Rectangle getRect(){
        return this.tileRect;
    }

    /**
     * Type of the door (Which is the enum above)
     * @return - the door type
     */
    public Door getType() {
        return type;
    }

    /**
     * Sets the type of the door
     * @param type - door type (enum)
     */
    public void setType(Door type) {
        this.type = type;
    }
}
