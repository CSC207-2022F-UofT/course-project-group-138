package controllers.gameStates;

import UI.presenters.statePresenters.MenuStatePresenter;
import UI.presenters.statePresenters.StatePresenter;
import settings.Settings;
import useCases.KeyEventHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class MenuState implements State {
    StatePresenter presenter;
    public MenuState(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();

        Settings.setFrameHeight(height);
        Settings.setFrameWidth(width);

        MenuStatePresenter pre = new MenuStatePresenter();
        BufferedImage menu;
        BufferedImage bg;
        try {
            menu = ImageIO.read(new File("src/main/res/temp-menu.png"));
            bg = ImageIO.read(new File("src/main/res/previewbg.png"));
            pre.setMenu(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.presenter = pre;
    }
    public void loop() {
    }

    public void keyPressEvents(int code) {
        // todo: add checking for menu version
        KeyEventHandler.handleMenuStateEvents(code);
    }


    public void keyReleasedEvents(int code) {
        // todo: add checking for menu version
        KeyEventHandler.handleMenuStateEvents(code);
    }

    @Override
    public void clickEvents(int code) {

    }

    @Override
    public StatePresenter getPresenter() {
        return presenter;
    }

}