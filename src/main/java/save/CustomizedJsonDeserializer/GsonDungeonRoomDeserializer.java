package save.CustomizedJsonDeserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import entities.character.Enemy;
import entities.character.Merchant;
import entities.dungeon.DungeonRoom;

import java.lang.reflect.Type;

public class GsonDungeonRoomDeserializer implements JsonDeserializer<DungeonRoom> {
    @Override
    public DungeonRoom deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        DungeonRoom dungeonRoom = new DungeonRoom();

        JsonElement npc = jsonElement.getAsJsonObject().get("merchant");
        dungeonRoom.addMerchant(context.deserialize(npc, Merchant.class));

        npc = jsonElement.getAsJsonObject().get("enemy");
        dungeonRoom.addEnemy(context.deserialize(npc, Enemy.class));

        JsonElement previousRoom = jsonElement.getAsJsonObject().get("previousRoom");
        dungeonRoom.setPreviousRoom(context.deserialize(previousRoom, DungeonRoom.class));

        return dungeonRoom;
    }
}
