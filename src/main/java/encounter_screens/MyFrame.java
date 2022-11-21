package encounter_screens;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{

    MyFrame() {
        this.setVisible(true);
        this.setSize(420, 420);
        this.setTitle("wattttt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of app
        this.setResizable(false); // can't resize
        this.setLocationRelativeTo(null); //centered
        // ImageIcon image = new ImageIcon("logo.png");
        // frame.setIconImage(image.getImage());
        this.setLayout(null);

        this.getContentPane().setBackground(new Color(0x12345)); //rgb value
    }
}
