package UI.presenters.statePresenters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuStatePresenter implements StatePresenter {
    private BufferedImage menu;
    private BufferedImage bg;

    public void setMenu(BufferedImage menu) {
        this.menu = menu;
    }

    public void setBG(BufferedImage bg) {
        this.bg = bg;
    }

    public BufferedImage getMenu() {
        return menu;
    }

    @Override
    public void render(Graphics2D graphics) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();

//        graphics.drawImage(bg, 0, 0, width, height, null);
        graphics.drawImage(menu, width/6, 0, height, height, null);
    }
}
