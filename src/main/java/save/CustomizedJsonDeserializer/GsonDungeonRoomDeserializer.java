package save.CustomizedJsonDeserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import entities.dungeon.DungeonRoom;

import java.lang.reflect.Type;

public class GsonDungeonRoomDeserializer implements JsonDeserializer<DungeonRoom> {
    @Override
    public DungeonRoom deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        DungeonRoom dungeonRoom = new DungeonRoom();
        JsonElement npc = jsonElement.getAsJsonObject().get("nonPlayerCharacter");
        dungeonRoom.addNPC(context.deserialize(npc, Object.class));

        JsonElement previousRoom = jsonElement.getAsJsonObject().get("previousRoom");
        if (previousRoom != null) {
            dungeonRoom.setPreviousRoom(context.deserialize(previousRoom, DungeonRoom.class));
        }
        return dungeonRoom;
    }
}
