package save.ui;

import save.save_screen.FrameBuilder;
import save.save_screen.SaveController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveScreen extends JFrame implements ActionListener, FrameBuilder {
    JFrame window = new JFrame();
    JTextField fileName = new JTextField(15);
    JButton saveButton = new JButton("Save");
    JButton cancelButton = new JButton("Cancel");

    SaveController saveController;


    public void buildSaveScreen(SaveController saveController) {
        this.saveController = saveController;
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

        buildFrame(window, panel);

        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Click " + event.getActionCommand());

        if (event.getSource() == saveButton)
        try {
            this.saveController.performSave(fileName.getText());
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
