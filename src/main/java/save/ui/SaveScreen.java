package save.ui;

import entities.character.Player;
import entities.dungeon.Dungeon;
import save.save_screen.PanelBuilder;
import save.save_screen.SaveController;
import settings.Initializer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveScreen extends JFrame implements ActionListener, PanelBuilder {
    JFrame window = new JFrame();
    JTextField fileName = new JTextField(15);
    JButton saveButton = new JButton("Save");
    JButton cancelButton = new JButton("Cancel");

    SaveController saveController;

    public SaveScreen (SaveController saveController) {
        this.saveController = saveController;
    }

    public void buildSaveScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LabelPanel fileNamePanel = new LabelPanel(
                new JLabel("Name your game save:"), fileName);

        JPanel buttons = new JPanel();
        buttons.add(saveButton);
        buttons.add(cancelButton);

        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);

        panel.add(fileNamePanel);
        panel.add(buttons);

/*        window.add(panel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);*/

        buildPanel(window, panel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Click " + event.getActionCommand());

        if (event.getSource() == saveButton)
        try {
            Initializer initializer = new Initializer();
            initializer.init();
            Player player = initializer.getPlayer();

            Dungeon dungeon = new Dungeon();
            dungeon.generateDungeonMap();

            this.saveController.performSave(fileName.getText(), player, dungeon);
            JOptionPane.showMessageDialog(this, String.format("%s created.", fileName.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        else if (event.getSource() == cancelButton) {
            window.dispose();
            //System.exit(0);
        }

    }
}
