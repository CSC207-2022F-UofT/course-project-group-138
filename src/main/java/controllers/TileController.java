package controllers;

import UI.presenters.TileViewModel;
import entities.dungeon.DungeonTile;
import settings.Settings;

import java.awt.*;

public class TileController {
    DungeonTile[] tiles;
    TileViewModel tViewModel;
    public TileController(){
        tiles = new DungeonTile[5];
    }
    public void init(){
        tiles = new DungeonTile[5];
    }
    public void renderTiles(Graphics2D graphics2D){
        int column = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (column < Settings.getColumns() && row < Settings.getRows()) {

        }
    }
}
