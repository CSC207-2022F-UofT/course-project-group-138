package save.save_screen;

import com.google.gson.Gson;
import save.save_use_case.DsGateway;
import save.save_use_case.DsRequest;
import save.save_use_case.LoadRequest;

import java.io.*;
import java.util.*;

public class GameFiles implements DsGateway {

    private final File SAVE_FILES;

    private final Map<String, Integer> gameSavesDataOrder = new LinkedHashMap<>();

    private final Map<String, DsRequest> gameSavesData = new HashMap<>();


    /**
     * Load the data from file with specifed file path into `gameSavesData`.
     * If no data is presented in the file, it will do nothing.
     * @param filePath A file path for the saved game file
     */
    public GameFiles(String filePath) throws IOException {
        SAVE_FILES = new File(filePath);

        // if there is saved game data, then load them into `gameSavesData`
        if(SAVE_FILES.length() != 0) {
            BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILES));


            Gson gson = new Gson();
            String row;
            while ((row = reader.readLine()) != null) {
                DsRequest saveData = gson.fromJson(row, DsRequest.class);
                gameSavesData.put(saveData.getFileName(), saveData);
            }
            reader.close();
        }
    }

    /**
     * Save the request into the Map `gameSavesData`, then it calls `save()` to write the map into the database entry by entry
     * @param dsRequest A save request to the database containing File name, Player, Dungeon, Creation Time
     */
    @Override
    public void save(DsRequest dsRequest) {
        gameSavesData.put(dsRequest.getFileName(), dsRequest);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try{
            writer  = new BufferedWriter(new FileWriter(SAVE_FILES));
            Gson gson = new Gson();
            for (DsRequest saveData : gameSavesData.values()) {
                writer.write(gson.toJson(saveData));
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return the save data from with specified file name in `loadRequest`, or return the latest save data if user requests quick load
     * @param loadRequest A load request to the database
     * @return return a SaveDsRequest that contains the loaded file name, characters, creation time
     */

    public DsRequest load(LoadRequest loadRequest) {
        // Quick load does not require user to provide file name,
        // so it will sort the saved data and return the latest save data
        if (loadRequest.isQuickLoad()) {
            List<DsRequest> sortedList = sortByComparator(gameSavesData, "Creation Time Descending");
            return sortedList.get(0);
        }

        // return the save data with specified file name in `loadRequest`
        DsRequest loadedFile = gameSavesData.get(loadRequest.getFileName());
        return loadedFile;
    }

    /**
     * Sort a Map with specifed sort method
     * @param unsortedMap An unsorted map that contains all game saved data
     * @param sortMethod  sort the map using this method (for now, it is either "Creation Time Descending" or "Creation Time Ascending")
     * @return return a SaveDsRequest that contains the loaded file name, characters, Dungeons,creation time
     */
    private List<DsRequest> sortByComparator(Map<String, DsRequest> unsortedMap, String sortMethod) {
        List<Map.Entry<String, DsRequest>> entryList = new LinkedList<Map.Entry<String, DsRequest>>(unsortedMap.entrySet());

        // sort the entry list based on given order
        // for now, it is either "Creation Time Descending" or "Creation Time Ascending"
        Collections.sort(entryList, new Comparator<Map.Entry<String, DsRequest>>() {
            @Override
            public int compare(Map.Entry<String, DsRequest> o1, Map.Entry<String, DsRequest> o2) {
                if (sortMethod.equals("Creation Time Ascending")) {
                    return o1.getValue().getCreationTime().compareTo(o2.getValue().getCreationTime());
                }
                else {
                    return o2.getValue().getCreationTime().compareTo(o1.getValue().getCreationTime());
                }
            }
        });

        List<DsRequest> sortedList = new ArrayList<DsRequest>();
        for (Map.Entry<String, DsRequest> entry : entryList) {
            sortedList.add(entry.getValue());
        }

        return sortedList;
    }

    /**
     * Return True if there is no data in databaase
     */
    public boolean isEmptyDatabase() {
        return (gameSavesData == null);
    }

    /**
     * Return True if filename exists in database
     */
    @Override
    public boolean fileExists(String fileName) {
        return gameSavesData.containsKey(fileName);
    }
}
