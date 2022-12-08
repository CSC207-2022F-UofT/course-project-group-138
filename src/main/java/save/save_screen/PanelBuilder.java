package save.save_screen;

import javax.swing.*;

public interface PanelBuilder {
     default void buildPanel (JFrame window, JPanel panel) {
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
