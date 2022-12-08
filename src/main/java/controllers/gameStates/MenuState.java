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

// todo: after clicking done on paint it switches to crawling state
// todo: add popup on paint where if u skip drawing the character it goes to crawling state

public class MenuState implements State {
    StatePresenter presenter;
    public MenuState(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();

        Settings.setFrameHeight(height);
        Settings.setFrameWidth(width);

        MenuStatePresenter pre = new MenuStatePresenter();
        BufferedImage button1;
        try {
            button1 = ImageIO.read(new File("src/main/res/temp-menu.png"));
            pre.setButtonImage1(button1);
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