package save_screen;

import save_use_case.SaveDsGateway;
import save_use_case.SaveDsRequest;
import save_use_case.SaveRequest;

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
        gameSavesDataOrder.put("file_name", 0);
        gameSavesDataOrder.put("player_coins", 1);
        gameSavesDataOrder.put("player_weapon_attack", 2);
        gameSavesDataOrder.put("player_weapon_price", 4);
        gameSavesDataOrder.put("player_armor_hp", 4);
        gameSavesDataOrder.put("player_armor_price", 5);
        gameSavesDataOrder.put("player_hp", 6);
        gameSavesDataOrder.put("player_num_of_enenmy_slayed", 7);
        gameSavesDataOrder.put("creation_time", 8);

        if (SAVE_FILES.length() == 0) {
            // create a new txt. file
        }

        else {
            BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILES));
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> sections = new ArrayList<String>();
                sections.addAll(Arrays.asList(line.split(",")));

                String extraLines;
                // continue reading the next line if less than 9 Strings were added
                while (sections.size() < 9 && (extraLines = reader.readLine()) != null) {
                    sections.addAll(Arrays.asList(extraLines.split(",")));
                }

                String fileName = sections.get(gameSavesDataOrder.get("file_name"));
                String playerCoins = sections.get(gameSavesDataOrder.get("player_coins"));
                String playerWeaponAttack = sections.get(gameSavesDataOrder.get("player_weapon_attack"));
                String playerWeaponPrice = sections.get(gameSavesDataOrder.get("player_weapon_price"));
                String playerArmorHp = sections.get(gameSavesDataOrder.get("player_armor_hp"));
                String playerArmorPrice = sections.get(gameSavesDataOrder.get("player_armor_price"));
                String playerHp = sections.get(gameSavesDataOrder.get("player_hp"));
                String playerNumOfEnenmySlayed = sections.get(gameSavesDataOrder.get("player_num_of_enenmy_slayed"));
                String creationTimeStr = sections.get(gameSavesDataOrder.get("creation_time"));

                LocalDateTime creationTime = LocalDateTime.parse(creationTimeStr);

                SaveDsRequest saveDsRequest = new SaveDsRequest(fileName,
                        playerCoins,
                        playerWeaponAttack,
                        playerWeaponPrice,
                        playerArmorHp,
                        playerArmorPrice,
                        playerHp,
                        playerNumOfEnenmySlayed,
                        creationTime);
                gameSavesData.put(fileName,saveDsRequest);
            }
            reader.close();
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
            for (SaveDsRequest saveFiles : gameSavesData.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",saveFiles.getFileName(),
                        saveFiles.getPlayerCoins(),
                        saveFiles.getPlayerWeaponAttack(),
                        saveFiles.getPlayerWeaponPrice(),
                        saveFiles.getPlayerArmorHp(),
                        saveFiles.getPlayerArmorPrice(),
                        saveFiles.getPlayerHp(),
                        saveFiles.getPlayerNumOfEnenmySlayed(),
                        saveFiles.getCreationTime());
            }
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
