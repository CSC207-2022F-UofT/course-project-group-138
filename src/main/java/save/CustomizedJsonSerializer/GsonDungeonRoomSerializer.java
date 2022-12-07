package save.CustomizedJsonSerializer;

import com.google.gson.*;
import entities.dungeon.DungeonRoom;

import java.lang.reflect.Type;

public class GsonDungeonRoomSerializer implements JsonSerializer<DungeonRoom> {
    @Override
    public JsonElement serialize(DungeonRoom dungeonRoom, Type type, JsonSerializationContext context) {
        JsonObject jsonObj = new JsonObject();

        // Note that the Strings needs to be matched with the name of DungeonRoom's fields
/*        try {
            jsonObj.add("nonPlayerCharacter",
                    dungeonRoom.hasNPC() ? context.serialize(dungeonRoom.getNPC()) : context.serialize(null));
        } catch (Exception ignore) {}
        try {
            jsonObj.add("previousRoom",
                    dungeonRoom.hasPreviousRoom() ? context.serialize(dungeonRoom.getPreviousRoom()) : context.serialize(null));
        } catch (Exception ignore) {}*/
        jsonObj.add("nonPlayerCharacter", context.serialize(dungeonRoom.getNonPlayerCharacter()));
        jsonObj.add("previousRoom",context.serialize(dungeonRoom.retrievePreviousRoom()));
        return jsonObj;
    }
}
