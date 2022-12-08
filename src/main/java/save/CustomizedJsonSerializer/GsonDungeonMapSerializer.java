package save.CustomizedJsonSerializer;

import com.google.gson.*;
import entities.dungeon.DungeonRoom;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonDungeonMapSerializer implements JsonSerializer<HashMap<DungeonRoom, List<DungeonRoom>>> {
    @Override
    public JsonElement serialize(HashMap<DungeonRoom, List<DungeonRoom>> map, Type type, JsonSerializationContext context) {
        JsonObject jsonObj = new JsonObject();

        Gson gson = new GsonBuilder().registerTypeAdapter(DungeonRoom.class, new GsonDungeonRoomSerializer()).create();

        for (Map.Entry<DungeonRoom, List<DungeonRoom>> entry : map.entrySet()) {
            jsonObj.add(gson.toJson(entry.getKey()), gson.toJsonTree(entry.getValue()));
        }

        return jsonObj;
    }
}
