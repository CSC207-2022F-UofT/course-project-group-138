package save.CustomizedJsonDeserializer;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import entities.dungeon.DungeonRoom;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonDungeonMapDeserializer implements JsonDeserializer<HashMap<DungeonRoom, List<DungeonRoom>>> {
    @Override
    public  HashMap<DungeonRoom, List<DungeonRoom>> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        HashMap<DungeonRoom, List<DungeonRoom>> map = new HashMap<DungeonRoom, List<DungeonRoom>>();

        Gson gson = new Gson();
        JsonObject jsonObj = jsonElement.getAsJsonObject();


        for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
            DungeonRoom key = gson.fromJson(entry.getKey(), DungeonRoom.class);

            Type typeOfKey = new TypeToken<List<DungeonRoom>>(){}.getType();
            List<DungeonRoom> value = gson.fromJson(entry.getValue(), typeOfKey);
            map.put(key, value);
        }

        return map;

    }
}
