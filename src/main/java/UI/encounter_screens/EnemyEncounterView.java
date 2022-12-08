package UI.encounter_screens;

import controllers.StateManager;
import controllers.gameStates.CombatState;
import controllers.CombatController;
import controllers.gameStates.CrawlingState;
import gateways.ImageGateway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.List;

public class EnemyEncounterView extends EncounterView implements SetLabel, SetCombatButtonsandLabel {

    /**
     * The window that will be poped up, when the player hits enemies.
     * Provide more specific implementation of the EncounterView.
     */


    EnemyEncounterView() {

        this.setTitle("EnemyEncountered"); // set the title of the frame

        BufferedImage img = ImageGateway.getEnemyImg(); // read the image.
        Image dimg = img.getScaledInstance(200, 240, Image.SCALE_SMOOTH); // rescale the image displayed
        ImageIcon imageIcon = new ImageIcon(dimg); // create an instance of the image

        label.setBounds(215, 55, 200, 240); //
        label.setIcon(imageIcon); //Sets the image to be displayed as an icon

        c = this.getContentPane(); //Gets the content layer
        c.setBackground(new Color(0x123456)); //rgb value, set the background color
        c.add(label); //Adds objects to the container

        attack.setBounds(30, 290, 120, 90);
        attack.addActionListener(this);
        attack.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.add(attack); // Add a attack button on the container.

        exit.setBounds(480, 290, 120, 90);
        exit.addActionListener(this);
        exit.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.add(exit); // Add a leave button on the container.

        hp.setText("Player HP:" + "\n" + "Enemy HP:");
        hp.setForeground(new Color(0xFFFFFF));
        hp.setBounds(20, 20, 300, 300);
        hp.setFont(new Font("Comic Sans", Font.PLAIN, 10));
        getContentPane().add(hp);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attack){
            // set userinput received by the combat controller.
            CombatController.setUserInput("Attack");

            // set the state to combat state.
            StateManager s = new StateManager();
            s.setCurrState(new CombatState());

            // after one round of combat, get the corresponding HP
            // for the enemy and the player.
            List<Integer> l = CombatController.getHP();
            Integer playerHP = l.get(0);
            Integer enemyHP = l.get(1);

            hp.setText("Player HP:" + playerHP + "\n" + "Enemy HP:" + enemyHP);
            hp.setForeground(new Color(0xFFFFFF));
            hp.setBounds(20, 20, 300, 300);
            c.add(hp);

            // After each round, the user is able to see the current HP
            // for the player and the enemy. A window is poped up.

            JOptionPane.showMessageDialog(null, "Current HP for the player:" +
                    playerHP + "\n" + "Current HP for the enemy:" + enemyHP);

            // if the player is unable to proceed, the button can't be pressed again.
            // attack.setEnabled(false);

        }

        if (e.getSource() == exit){
            StateManager s = new StateManager();
            s.setCurrState(new CrawlingState());
            System.exit(0);
        }
    }
}
