package controllers;

import UI.presenters.viewModels.EnemyViewModel;
import UI.presenters.viewModels.MerchantViewModel;
import entities.character.Enemy;
import entities.character.Merchant;
import entities.dungeon.DungeonRoom;
import gateways.ImageGateway;
import settings.Settings;
import useCases.AnimationStrategy;

import java.awt.image.BufferedImage;

public class NPCUIManager {
    private final BufferedImage ogre = ImageGateway.getMonster8();
    private BufferedImage[] monsterFrames;
    private final BufferedImage merchant1 = ImageGateway.getMerchant1();
    private final BufferedImage merchant2 = ImageGateway.getMerchant2();
    private EnemyViewModel enemyViewModel;
    private MerchantViewModel merchantViewModel;
    private AnimationStrategy animator;
    public NPCUIManager(){
        retrieveImages();
        animator = new AnimationStrategy(0, 4);
    }
    public void spawnEnemy(DungeonRoom room, EnemyViewModel enemyViewModel){
        Enemy enemy = room.getEnemy();
        this.enemyViewModel = enemyViewModel;
        this.enemyViewModel.updateEnemy(enemy);
        this.enemyViewModel.updateImage(determineEnemyImage(enemy.getImageID()));
    }
    public void spawnMerchant(DungeonRoom room, MerchantViewModel merchantViewModel) {
        Merchant merchant = room.getMerchant();
        this.merchantViewModel = merchantViewModel;
        this.merchantViewModel.updateMerchant(merchant);
        this.merchantViewModel.updateImage(determineMerchantImage(merchant.getImageID()));
    }
    public void animateEnemy(){
        if (enemyViewModel.isAnimated()){
            int currFrame = animator.getNextFrame();
            this.enemyViewModel.updateImage(monsterFrames[currFrame]);
        }
    }
    public void update(){
        if (enemyViewModel == null) return;
        animateEnemy();
    }
    public void setEnemyLocation(int x, int y){
//        enemyViewModel.getEntity().setX(x);
//        enemyViewModel.getEntity().setY(y);
        enemyViewModel.x = x;
        enemyViewModel.y = y;
    }
    public void setMerchantLocation(int x, int y){
//        merchantViewModel.getEntity().setX(x);
//        merchantViewModel.getEntity().setY(y);
        enemyViewModel.x = x;
        enemyViewModel.y = y;
    }

    /**
     * Determine which sprite to use depending on enemy image id
     * @param imageID - the image id of this enemy
     * @return - A buffered image representing it's sprite
     */
    private BufferedImage determineEnemyImage(int imageID){
        BufferedImage image = null;
        switch (imageID){
            case 0:
                enemyViewModel.setAnimated(true);
                image = monsterFrames[0];
                break;
            case 1:
                enemyViewModel.setAnimated(false);
                image = ogre;
                break;
        }
        if (image == null) image = ogre;
        return image;
    }
    private BufferedImage determineMerchantImage(int imageID){
        BufferedImage image = null;
        switch (imageID){
            case 0:
                image = merchant1;
                break;
            case 1:
                image = merchant2;
                break;
        }
        if (image == null) image = merchant1;
        return image;
    }
    private void retrieveImages(){
        monsterFrames = new BufferedImage[]{ImageGateway.getAnMonster1(), ImageGateway.getAnMonster2(),
                                            ImageGateway.getAnMonster3(), ImageGateway.getAnMonster4()};
    }


}
