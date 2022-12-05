package UI.encounter_screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class EncounterView extends JFrame implements ActionListener {

    /**
     * An abstract class where the EnemyEncounterView and MerchantEncounterView can extend from.
     * We create a frame that sets a default button on, and an image that displays an according image,
     * for example, an image that represents a merchant might be incorporated in a merchant encounter view.
     */
    protected JLabel label;
    protected Container c;
    protected JButton exit;

    EncounterView() {

        this.setTitle(null); //Add the title to frame
        this.setLayout(null); //Terminates default flow layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        this.setSize(630, 420); //Sets the position of the frame
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true); // Exhibit the frame
    }

}