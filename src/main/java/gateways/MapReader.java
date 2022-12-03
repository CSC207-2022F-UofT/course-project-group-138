package gateways;

import settings.Settings;

import java.io.*;

public class MapReader {
    int[][] tileMap;
    String[] mapFiles;
    public MapReader(){
        tileMap = new int[20][12];
        mapFiles = new String[20];
        mapFiles[0] = "src/main/res/room_maps/room1.txt";
    }
    public int[][] loadMap(int mapNum){
        // Get file from given code
        String file = "src/main/res/room_maps/room1.txt"; // in case given invalid input
        try {
            if (mapFiles[mapNum] == null){
                throw new IndexOutOfBoundsException(); // to avoid null pointers
            }
            file = mapFiles[mapNum];
        } catch (IndexOutOfBoundsException ie){
            System.out.println("error: Invalid map input");
            ie.printStackTrace();
        }

        // Convert file into rectangular array algorithm
        int screenCol = Settings.getColumns();
        int screenRow = Settings.getRows();
        try{
            InputStream is = new FileInputStream("src/main/res/room_maps/room1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;

            while (col < screenCol && row < screenRow){
                String line = br.readLine();

                // Parse each number in the input file
                while (col < screenCol){
                    String[] data = line.split(" ");
                    int num = Integer.parseInt(data[col]);
                    tileMap[col][row] = num;
                    col ++;
                }
                if (col == screenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e){
            System.out.println("Cant Read input file: room1.txt");
            e.printStackTrace();
        }
        return tileMap;
    }
}
