package save.save_screen;

import javax.swing.*;

public interface FrameBuilder {
     default void buildFrame (JFrame window, JPanel panel) {
         window.setUndecorated(true);
         //window.setExtendedState(JFrame.MAXIMIZED_BOTH);
         window.setLocationRelativeTo(null);
         window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         window.add(panel);
         window.pack();
    }
}
