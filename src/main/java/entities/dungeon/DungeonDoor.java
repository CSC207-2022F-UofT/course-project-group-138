package entities.dungeon;

import java.awt.*;

public class DungeonDoor extends DungeonTile{
    /**
     * Just an idea for now. But we need to a way for the player to traverse between rooms. This would need to be
     * instantiated when generating the dungeon map.
     */
    DungeonRoom room; // Represents what room this door leads to
    Enum<Door> type;

    public enum Door{
        TOP_LEFT,
        TOP_MID,
        TOP_RIGHT,
        LEFT,
        RIGHT,
        BOTTOM
    }
    public void setRect(Rectangle rectangle){
        this.tileRect = rectangle;
    }
    public Rectangle getRect(){
        return this.tileRect;
    }

    public Enum<Door> getType() {
        return type;
    }
    public void setType(Enum<Door> type) {
        this.type = type;
    }
}
