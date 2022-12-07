package save.CustomizedJsonSerializer;

import com.google.gson.*;
import entities.dungeon.DungeonRoom;

import java.lang.reflect.Type;
import java.util.List;

public class GsonConnectedRooms implements JsonSerializer<List<DungeonRoom>> {
    @Override
    public JsonElement serialize(List<DungeonRoom> src, Type srcType, JsonSerializationContext context) {
        JsonArray jsonArr = new JsonArray();

        Gson gson = new Gson();

        for (DungeonRoom room : src) {
            jsonArr.add(gson.toJson(room));
        }

        return jsonArr.getAsJsonPrimitive();
    }
}
