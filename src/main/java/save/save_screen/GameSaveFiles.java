package save.save_screen;

import entities.character.Player;
import entities.inventory.EquipmentInterface;
import entities.inventory.Inventory;
import entities.temporary_entities.*;
import save.save_use_case.SaveDsGateway;
import save.save_use_case.SaveDsRequest;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class GameSaveFiles implements SaveDsGateway {

    private final File SAVE_FILES;

    private final Map<String, Integer> gameSavesDataOrder = new LinkedHashMap<>();

    private final Map<String, SaveDsRequest> gameSavesData = new HashMap<>();

    public GameSaveFiles(String filePath) throws IOException {
        SAVE_FILES = new File(filePath);

        // the order of the save_files
        int x = 0;
        gameSavesDataOrder.put("file_name", x++);
        gameSavesDataOrder.put("player_coins", x++);
        gameSavesDataOrder.put("player_weapon_attack", x++);
        gameSavesDataOrder.put("player_weapon_price", x++);
        gameSavesDataOrder.put("player_armor_hp", x++);
        gameSavesDataOrder.put("player_armor_pricce", x++);
        gameSavesDataOrder.put("player_hp", x++);
        gameSavesDataOrder.put("player_kills", x++);
        gameSavesDataOrder.put("creation_time", x++);
        gameSavesDataOrder.put("player_location_x", x++);
        gameSavesDataOrder.put("player_location_y", x++);


        if (SAVE_FILES.length() == 0) {
            save();
        }

        else {
            BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILES));
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> sections = new ArrayList<String>();
                sections.addAll(Arrays.asList(line.split(",")));

                String extraLines;
                // continue reading the next line if not all data were read
                while (sections.size() < gameSavesDataOrder.size() && (extraLines = reader.readLine()) != null) {
                    sections.addAll(Arrays.asList(extraLines.split(",")));
                }

                String fileName = sections.get(gameSavesDataOrder.get("file_name"));
                String playerCoins = sections.get(gameSavesDataOrder.get("player_coins"));
                String playerWeaponAttack = sections.get(gameSavesDataOrder.get("player_weapon_attack"));
                String playerWeaponPrice = sections.get(gameSavesDataOrder.get("player_weapon_price"));
                String playerArmorHp = sections.get(gameSavesDataOrder.get("player_armor_hp"));
                String playerArmorPrice = sections.get(gameSavesDataOrder.get("player_armor_price"));
                String playerHp = sections.get(gameSavesDataOrder.get("player_hp"));
                String playerKills = sections.get(gameSavesDataOrder.get("player_kills"));
                String creationTimeStr = sections.get(gameSavesDataOrder.get("creation_time"));
                String playerX = sections.get(gameSavesDataOrder.get("player_lcoation_x"));
                String playerY = sections.get(gameSavesDataOrder.get("player_location_y"));

                // construct the player for `saveDsRequest` using the data
                EquipmentCreator equipmentCreator = new CommonEquipmentCreator();
                InventoryCreator inventoryCreator = new CommonInventoryCreator();
                CharacterCreator playerCreator = new CommonCharacterCreator();

                EquipmentInterface weapon = equipmentCreator.createWeapon(Integer.parseInt(playerWeaponAttack),
                        Integer.parseInt(playerWeaponPrice));
                EquipmentInterface armor = equipmentCreator.createArmor(Integer.parseInt(playerArmorHp),
                        Integer.parseInt(playerArmorPrice));
                Inventory playerInventory = inventoryCreator.createInventory(weapon,
                        armor,
                        Integer.parseInt(playerCoins));
                Player player = playerCreator.createPlayer(playerInventory,
                        Integer.parseInt(playerHp),
                        Integer.parseInt(playerX),
                        Integer.parseInt(playerY),
                        Integer.parseInt(playerKills));

                // connvert `creationTimeStr`from type `String` to type `LocalDateTime`
                LocalDateTime creationTime = LocalDateTime.parse(creationTimeStr);

                SaveDsRequest saveDsRequest = new SaveDsRequest(fileName, player, creationTime);
                gameSavesData.put(fileName,saveDsRequest);
            }
            reader.close();
        }
    }

    public void readData(SaveDsRequest saveData, List<String> lines) {
        int fileLineThreshold = 300;

        String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",saveData.getFileName(),
                saveData.getPlayerCoins(),
                saveData.getPlayerWeaponAttack(),
                saveData.getPlayerWeaponPrice(),
                saveData.getPlayerArmorHp(),
                saveData.getPlayerArmorPrice(),
                saveData.getPlayerHp(),
                saveData.getPlayerKills(),
                saveData.getCreationTime(),
                saveData.getPlayerX(),
                saveData.getPlayerY());

        if (line.length() >= fileLineThreshold) {
            int startIndex = 0;
            while (startIndex < line.length()) {
                String subStr;
                if (startIndex + fileLineThreshold > line.length()) {
                    lines.add(line.substring(startIndex, line.length()));
                    startIndex = line.length(); // this cause the while loop to terminate
                }
                else {
                    subStr = line.substring(startIndex, startIndex + fileLineThreshold);
                    int endIndex = subStr.lastIndexOf(",") + 1; // plus 1 to include ","
                    lines.add(line.substring(startIndex, endIndex));
                    startIndex = endIndex;
                }
            }
        }
        else {
            lines.add(line);
        }
    }

    @Override
    public void save(SaveDsRequest saveDsRequest) {
        gameSavesData.put(saveDsRequest.getFileName(), saveDsRequest);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try{
            writer  = new BufferedWriter(new FileWriter(SAVE_FILES));
            for (SaveDsRequest saveData : gameSavesData.values()) {

                List<String> lines = new ArrayList<String>();
                this.readData(saveData, lines);
                for(String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean fileExists(String fileName) {
        return gameSavesData.containsKey(fileName);
    }
}
