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

public class FinalBossEncounterView extends EncounterView {


    /**
     * The window will be poped up, when the player hits the final Boss.
     * Provide more specific implementation of the EncounterView.
     * A window of success will pop up if the final boss is slain.
     */
    private JButton attack;


    FinalBossEncounterView() {


        this.setTitle("Final Boss Encountered"); // set the title of the frame

        BufferedImage img = ImageGateway.getFinalBoss(); // read the image.
        Image dimg = img.getScaledInstance(200, 240, Image.SCALE_SMOOTH); // rescale the image displayed
        ImageIcon imageIcon = new ImageIcon(dimg); // create an instance of the image

        label = new JLabel(); //JLabel Creation
        label.setBounds(215, 55, 200, 240);
        label.setIcon(imageIcon); //Sets the image to be displayed as an icon

        c = this.getContentPane(); //Gets the content layer
        c.setBackground(new Color(0x12345)); //rgb value, set the background color
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
        if (e.getSource() == attack) {
            // set userinput received by the combat controller.
            CombatController.setUserInput("Attack");

            // set the state to combat state. run the combat loop.
            StateManager s = new StateManager();
            s.setCurrState(new CombatState());

            // after one round of combat, get the corresponding HP
            // for the enemy and the player.
            List<Integer> l = CombatController.getHP();
            Integer playerHP = l.get(0);
            Integer enemyHP = l.get(1);

            // After each round, the user is able to see the current HP
            // for the player and the enemy. A window is poped up.

            JOptionPane.showMessageDialog(null, "Current HP for the player:" +
                    playerHP + "\n" + "Current HP for the enemy:" + enemyHP);

            // if the player is unable to proceed, the button can't be pressed again.
            // attack.setEnabled(false);

            // TODO how the final boss scene will be triggered??? If there is no checker function
            // if the final boss is slain, the success window is triggered.
            // new SuccessWindow();
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

// TODO: Display enemy's and player's current HP after one round (after the user clicks the button) on GUI.

}