package UI.encounter_screens;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnemyEncounterView extends EncounterView {

    /**
     * The window that will be poped up, when the player hits enemies.
     * Provide more specific implementation of the EncounterView.
     */
    private JButton attack;

    EnemyEncounterView() throws IOException {


        this.setTitle("EnemyEncountered"); // set the title of the frame

        BufferedImage img = ImageIO.read(new File("src/main/res/regular_enemy.png")); // read the image.
        Image dimg = img.getScaledInstance(200, 240, Image.SCALE_SMOOTH); // rescale the image displayed
        ImageIcon imageIcon = new ImageIcon(dimg); // create an instance of the image

        label = new JLabel(); //JLabel Creation
        label.setBounds(215, 55, 200, 240);
        label.setIcon(imageIcon); //Sets the image to be displayed as an icon

        c = this.getContentPane(); //Gets the content layer
        c.setBackground(new Color(0x12345)); //rgb value, set the background color
        c.add(label); //Adds objects to the container

        attack = new JButton("Attack");
        attack.setBounds(255, 350, 120, 30);
        attack.addActionListener(this);
        c.add(attack); // Add a attack button on the container.

        leave = new JButton("Leave");
        leave.setBounds(480, 350, 120, 30);
        leave.addActionListener(this);
        c.add(leave); // Add a leave button on the container.

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attack){
            System.out.println("Ouch!!!");

            //should incorporate the features in player and enemy.
            JOptionPane.showMessageDialog(null, "oh no you died :(");
        }

        if (e.getSource() == leave){
            System.out.println("Bye");
            // also links back to the main play state
            // TODO Incorporate more functionality
        }
    }
}
