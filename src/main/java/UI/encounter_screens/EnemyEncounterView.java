package UI.encounter_screens;

import controllers.StateManager;
import controllers.gameStates.CrawlingState;
import gateways.ImageGateway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class EnemyEncounterView extends EncounterView {

    /**
     * The window that will be poped up, when the player hits enemies.
     * Provide more specific implementation of the EncounterView.
     */
    private JButton attack;


    EnemyEncounterView() {


        this.setTitle("EnemyEncountered"); // set the title of the frame

        BufferedImage img = ImageGateway.getEnemyImg(); // read the image.
        Image dimg = img.getScaledInstance(200, 240, Image.SCALE_SMOOTH); // rescale the image displayed
        ImageIcon imageIcon = new ImageIcon(dimg); // create an instance of the image

        label = new JLabel(); //JLabel Creation
        label.setBounds(215, 55, 200, 240);
        label.setIcon(imageIcon); //Sets the image to be displayed as an icon

        c = this.getContentPane(); //Gets the content layer
        c.setBackground(new Color(0x123456)); //rgb value, set the background color
        c.add(label); //Adds objects to the container

        attack = new JButton("Attack");
        attack.setBounds(30, 290, 120, 90);
        attack.addActionListener(this);
        attack.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.add(attack); // Add a attack button on the container.

        exit = new JButton("Exit");
        exit.setBounds(480, 290, 120, 90);
        exit.addActionListener(this);
        exit.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.add(exit); // Add a leave button on the container.

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attack){
            // System.out.println("Ouch!!!");

            //should incorporate the features in player and enemy.
            JOptionPane.showMessageDialog(null, "oh no you died :(");
            // TODO Incorporate more functionality. Refer to MerchantEncounterView.java.

            //attack.setEnabled(false);
        }

        if (e.getSource() == exit){
            System.exit(0);
        }
    }

    // TODO: Display enemy's and player's current HP after one round (after the user clicks the button) on GUI.

}
