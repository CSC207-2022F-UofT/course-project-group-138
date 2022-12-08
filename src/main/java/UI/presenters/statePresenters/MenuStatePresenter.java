package UI.presenters.statePresenters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuStatePresenter implements StatePresenter {
    private BufferedImage buttonImage1;

    public void setButtonImage1(BufferedImage buttonImage1) {
        this.buttonImage1 = buttonImage1;
    }

    public BufferedImage getButtonImage1() {
        return buttonImage1;
    }

    @Override
    public void render(Graphics2D graphics) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();

        graphics.drawImage(buttonImage1, height/4, height/4, height/2, height/2, null);
    }
}
