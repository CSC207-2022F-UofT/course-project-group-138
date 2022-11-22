package encounter_screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyEncounterView extends JFrame implements ActionListener {
    private JButton attack;

    EnemyEncounterView() {


        this.setVisible(true);
        this.setSize(630, 420);
        this.setTitle("EnemyEncountered");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of app
        this.setResizable(false); // can't resize
        this.setLocationRelativeTo(null); //centered
        // ImageIcon image = new ImageIcon("logo.png");
        // frame.setIconImage(image.getImage());
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x12345)); //rgb value


        attack = new JButton("attack");
        attack.setBounds(255, 350, 120, 30);

        attack.addActionListener(this);

        add(attack);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attack){
            System.out.println("Ha");

            //should incorporate the features in player and enemy.
            JOptionPane.showMessageDialog(null, "oh no you died :(");
        }
    }
}
