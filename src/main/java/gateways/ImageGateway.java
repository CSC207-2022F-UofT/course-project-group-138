package gateways;

import useCases.BImageStrategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageGateway {
    /**
     * Reads and returns the player image from its specified file location
     * @return - the player image
     */
    public static BufferedImage getPlayerImage(){
        return getImage("src/main/res/default_character.png");
    }

    /**
     * Reads and returns the stone tile image from its specified file location
     * @return - A regular stone tile image
     */
    public static BufferedImage getStoneTileImage(){
        return getImage("src/main/res/tiles/stone_tile.png");
    }
    public static BufferedImage getPinkFloorTileImage(){
        return getImage("src/main/res/tiles/pink_floor_tile.jpg");
    }
    public static BufferedImage getBrownWallTileImage(){
        return getImage("src/main/res/tiles/brown_wall_tile.png");
    }
    public static BufferedImage getBrokeRightTileImage(){return getImage("src/main/res/tiles/broke_right_tile.png");}
    public static BufferedImage getBrokeLeftTileImage(){return getImage("src/main/res/tiles/broke_left_tile.png");}
    public static BufferedImage getBrickWallTileImage() {
        return getImage("src/main/res/tiles/brick_wall_tile.png");
    }
    public static BufferedImage getSquareTileImage(){
        return getImage("src/main/res/tiles/square_tile.png");
    }
    public static BufferedImage getFloor1Image(){
        return getImage("src/main/res/tiles/floor1.png");
    }
    public static BufferedImage getGrassImage(){
        return getImage("src/main/res/tiles/grass.png");
    }
    public static BufferedImage getGround3(){
        return getImage("src/main/res/tiles/ground_03.png");
    }
    public static BufferedImage getDarknessRight(){
        return getImage("src/main/res/tiles/items/darkness_right.png");
    }
    public static BufferedImage getDarknessLeft(){
        return getImage("src/main/res/tiles/items/darkness_left.png");
    }
    public static BufferedImage getDarknessTop(){
        return getImage("src/main/res/tiles/items/darkness_top.png");
    }
    public static BufferedImage getDarknessBottom(){
        return getImage("src/main/res/tiles/items/darkness_bottom.png");
    }
    public static BufferedImage getDoorClosed(){
        return getImage("src/main/res/tiles/items/door_closed.png");
    }
    public static BufferedImage getDoorOpened(){
        return getImage("src/main/res/tiles/items/door_opened.png");
    }
    public static BufferedImage getFloorPlain(){
        return getImage("src/main/res/tiles/items/floor_plain.png");
    }
    public static BufferedImage getWallOuterEast(){
        return getImage("src/main/res/tiles/items/Wall_outer_e.png");
    }
    public static BufferedImage getWallOuterWest(){
        return getImage("src/main/res/tiles/items/Wall_outer_w.png");
    }
    public static BufferedImage getWallOuterNorth(){
        return getImage("src/main/res/tiles/items/Wall_outer_n.png");
    }
    public static BufferedImage getWallInnerSE(){
        return getImage("src/main/res/tiles/items/Wall_inner_se.png");
    }
    public static BufferedImage getWallInnerSW(){
        return getImage("src/main/res/tiles/items/Wall_inner_sw.png");
    }
    public static BufferedImage getWallCenter(){
        return getImage("src/main/res/tiles/items/wall_center.png");
    }
    public static BufferedImage getBlack(){
        return getImage("src/main/res/tiles/items/black.png");
    }
    public static BufferedImage getWallFront(){
        return getImage("src/main/res/tiles/items/Wall_front.png");
    }
    public static BufferedImage getWallInnerE(){
        return getImage("src/main/res/tiles/items/Wall_inner_e.png");
    }
    public static BufferedImage getWallInnerW(){
        return getImage("src/main/res/tiles/items/Wall_inner_w.png");
    }
    public static BufferedImage getWallInnerNW(){
        return getImage("src/main/res/tiles/items/Wall_inner_nw.png");
    }
    public static BufferedImage getWallInnerNE() {
        return getImage("src/main/res/tiles/items/Wall_inner_ne.png");
    }
    public static BufferedImage getColumn(){
        return getImage("src/main/res/tiles/items/column.png");
    }
    public static BufferedImage getWallMissingBrick1(){
        return getImage("src/main/res/tiles/items/wall_missing_brick_1.png");
    }
    public static BufferedImage getWallDrain(){
        return getImage("src/main/res/tiles/items/wall_drain_gate.png");
    }
    public static BufferedImage getWallGratings(){
        return getImage("src/main/res/tiles/items/wall_gratings.png");
    }
    public static BufferedImage getWallFlagRed(){
        return getImage("src/main/res/tiles/items/wall_flag_red.png");
    }
    public static BufferedImage getWallOuterTop(){
        return getImage("src/main/res/tiles/items/Wall_outer_top.png");
    }
    public static BufferedImage getGargoyleRed(){
        return getImage("src/main/res/tiles/items/wall_gargoyle_red_1.png");
    }
    public static BufferedImage getGargoyleGreen(){
        return getImage("src/main/res/tiles/items/wall_gargoyle_green_1.png");
    }
    public static BufferedImage getTorch1(){
        return getImage("src/main/res/tiles/items/torch_1.png");
    }
    public static BufferedImage getTorch2(){
        return getImage("src/main/res/tiles/items/torch_2.png");
    }
    public static BufferedImage getTorch3(){
        return getImage("src/main/res/tiles/items/torch_3.png");
    }
    public static BufferedImage getTorch4(){
        return getImage("src/main/res/tiles/items/torch_4.png");
    }
    public static BufferedImage getTorch5(){
        return getImage("src/main/res/tiles/items/torch_5.png");
    }
    public static BufferedImage getTorch6(){
        return getImage("src/main/res/tiles/items/torch_6.png");
    }
    public static BufferedImage getTorch7(){
        return getImage("src/main/res/tiles/items/torch_7.png");
    }
    public static BufferedImage getTorch8(){
        return getImage("src/main/res/tiles/items/torch_8.png");
    }
    public static BufferedImage getBox(){
        return getImage("src/main/res/tiles/items/box.png");
    }
    public static BufferedImage getBoxStacked(){
        return getImage("src/main/res/tiles/items/boxes_stacked.png");
    }
    public static BufferedImage getEdgeSingle(){
        return getImage("src/main/res/tiles/items/Edge_single.png");
    }
    public static BufferedImage getStairsTop(){
        return getImage("src/main/res/tiles/items/stairs_top.png");
    }
    public static BufferedImage getStairsMid(){
        return getImage("src/main/res/tiles/items/stairs_mid.png");
    }
    public static BufferedImage getStairsBot(){
        return getImage("src/main/res/tiles/items/stairs_bottom.png");
    }
    public static BufferedImage getBoxLeft(){
        return getImage("src/main/res/tiles/items/box_left.png");
    }
    public static BufferedImage getMud1(){
        return getImage("src/main/res/tiles/items/floor_mud_mid_1.png");
    }
    public static BufferedImage getFloorLight(){
        return getImage("src/main/res/tiles/items/floor_light.png");
    }
    public static BufferedImage getFloorStain(){
        return getImage("src/main/res/tiles/items/Floor_stain_n.png");
    }
    public static BufferedImage getMud_n1(){
        return getImage("src/main/res/tiles/items/floor_mud_n_1.png");
    }
    public static BufferedImage getMud_n2(){
        return getImage("src/main/res/tiles/items/floor_mud_n_2.png");
    }
    public static BufferedImage getMud_light(){
        return getImage("src/main/res/tiles/items/floor_mud_light.png");
    }
    public static BufferedImage getChestGoldenClosed(){
        return getImage("src/main/res/tiles/items/chest_golden_closed.png");
    }
    public static BufferedImage getFlagBlue(){
        return getImage("src/main/res/tiles/items/wall_flag_blue.png");
    }
    public static BufferedImage getFlagGreen(){
        return getImage("src/main/res/tiles/items/wall_flag_green.png");
    }
    public static BufferedImage getWallGoo(){
        return getImage("src/main/res/tiles/items/wall_goo.png");
    }
    public static BufferedImage getMonster1(){
        return getImage("src/main/res/tiles/items/monster_demon.png");
    }
    public static BufferedImage getMonster2(){
        return getImage("src/main/res/tiles/items/monster_chort.png");
    }
    public static BufferedImage getMonster3(){
        return getImage("src/main/res/tiles/items/monster_demonolog.png");
    }
    public static BufferedImage getMonster4(){
        return getImage("src/main/res/tiles/items/monster_tentackle.png");
    }
    public static BufferedImage getMonster5(){
        return getImage("src/main/res/tiles/items/monster_orc_veteran.png");
    }
    public static BufferedImage getMonster6(){
        return getImage("src/main/res/tiles/items/monster_rokita.png");
    }
    public static BufferedImage getMonster7(){
        return getImage("src/main/res/tiles/items/monster_necromancer.png");
    }
    public static BufferedImage getMonster8(){
        return getImage("src/main/res/tiles/items/monster_ogre.png");
    }
    public static BufferedImage getAnMonster1(){
        return getImage("src/main/res/tiles/items/demonf1.png");
    }
    public static BufferedImage getAnMonster2(){
        return getImage("src/main/res/tiles/items/demonf2.png");
    }
    public static BufferedImage getAnMonster3(){
        return getImage("src/main/res/tiles/items/demonf3.png");
    }
    public static BufferedImage getAnMonster4(){
        return getImage("src/main/res/tiles/items/demonf4.png");
    }
    public static BufferedImage getBackground(){
        return getImage("src/main/res/background/background.png");
    }
    public static BufferedImage getMerchant1(){
        return getImage("src/main/res/tiles/items/npc_merchant.png");
    }
    public static BufferedImage getMerchant2(){
        return getImage("src/main/res/tiles/items/npc_merchant_2.png");
    }

    /**
     * Reads and returns the stone tile image from its specified file location
     * @return - A representation of Merchant
     */

    public static BufferedImage getMerchantImg(){return getImage("src/main/res/encounterViewRes/sample_merchant.png");}


    /**
     * Reads and returns the stone tile image from its specified file location
     * @return - A representation of an Enemy
     */

    public static BufferedImage getEnemyImg(){return getImage("src/main/res/encounterViewRes/regular_enemy.png");}


    /**
     * Reads and returns the stone tile image from its specified file location
     * @return - A representation of the Final Boss
     */

    public static BufferedImage getFinalBoss(){return getImage("src/main/res/encounterViewRes/final_boss.png");}





    private static BufferedImage getImage(String fileName){
        try{
            // Convert to Buffered Image first
            return BImageStrategy.toBufferedImage(ImageIO.read(new File(fileName)));
        } catch (IOException e){
            System.out.println("Trouble getting image from res");
            e.printStackTrace();
            return null;
        }
    }

}
