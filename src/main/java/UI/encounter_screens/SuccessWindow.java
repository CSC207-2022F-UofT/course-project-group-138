package UI.encounter_screens;

import controllers.StateManager;
import controllers.gameStates.CrawlingState;
import controllers.gameStates.MenuState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessWindow extends JFrame implements ActionListener{
    /**
     * This window will be triggered, when the final boss has been slain.
     * Provide more specific implementation of the EncounterView.
     */

    private JButton exit;

    // TODO should be called in the game loop or else. Check when boss (enemy) has 0 HP or not to trigger.

    SuccessWindow() {

        this.setTitle("Congrats!!! You made it!!!"); //Add the title to frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        this.setSize(320, 200); //Sets the position of the frame
        this.setLocationRelativeTo(null);
        this.setVisible(true); // Exhibit the frame

        exit = new JButton("Back to the menu :)");
        exit.setBounds(40, 40, 240, 120);
        exit.addActionListener(this);
        exit.setFont(new Font("Comic Sans", Font.BOLD, 15));
        this.getContentPane().add(exit); // Add a leave button on the container.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StateManager s = new StateManager();
        s.setCurrState(new MenuState());
    }
}

