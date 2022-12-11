package UI.encounter_screens;

import controllers.CombatController;
import controllers.StateManager;
import controllers.gameStates.CombatState;
import gateways.ImageGateway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.List;

public class FinalBossEncounterView extends EncounterView implements SetLabel, SetCombatButtonsandLabel {


    /**
     * The window will be poped up, when the player hits the final Boss.
     * Provide more specific implementation of the EncounterView.
     * A window of success will pop up if the final boss is slain.
     */
    FinalBossEncounterView() {

        this.setTitle("Final Boss Encountered"); // set the title of the frame

        BufferedImage img = ImageGateway.getFinalBoss(); // read the image.
        Image dimg = img.getScaledInstance(200, 240, Image.SCALE_SMOOTH); // rescale the image displayed
        ImageIcon imageIcon = new ImageIcon(dimg); // create an instance of the image

        label.setBounds(215, 55, 200, 240);
        label.setIcon(imageIcon); //Sets the image to be displayed as an icon
        getContentPane().add(label);

        c = this.getContentPane(); //Gets the content layer
        c.setBackground(new Color(0x1234)); //rgb value, set the background color
        c.add(label); //Adds objects to the container

        attack.setBounds(30, 290, 120, 90);
        attack.addActionListener(this);
        attack.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.add(attack); // Add an attack button on the container.

        exit.setBounds(480, 290, 120, 90);
        exit.addActionListener(this);
        exit.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.add(exit); // Add a leave button on the container.

        hp.setText("Player HP Enemy HP:");
        hp.setForeground(new Color(0xFFFFFF));
        hp.setFont(new Font("Comic Sans", Font.PLAIN, 10));
        hp.setBounds(20, 20, 300, 300);
        c.add(hp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attack) {

            CombatController.setUserInput("Attack");
            StateManager s = new StateManager();
            s.setCurrState(new CombatState());

            // Same code as the one in enemyencounterview.

            // Check if the enemy is slain or not,
            if (CombatController.getEnemyHP() <= 0){
                new SuccessWindow();
            } else {

            // After each round, the user is able to see the current HP
            // for the player and the enemy. A window is poped up.

            JOptionPane.showMessageDialog(null, "Current HP for the player:" +
                    CombatController.getPlayerHP() + "\n" +
                    "Current HP for the enemy:" + CombatController.getEnemyHP());}

        }

        // The above chunk of code should not be refactored since there is an additional checker that facilitates the
        // success window, and we need that local variable to be taken into consideration.

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

}