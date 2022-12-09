package save.ui;

import save.save_screen.LoadController;
import save.save_screen.FrameBuilder;
import save.save_use_case.LoadResponse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadScreen extends JFrame implements ActionListener, FrameBuilder {
    JFrame window = new JFrame();
    JTextField fileName = new JTextField(15);
    JButton loadButton = new JButton("Load");
    JButton quickLoadButton = new JButton("Quick Load");
    JButton cancelButton = new JButton("Cancel");
    LoadController loadController;

    public LoadScreen (LoadController loadController) {
        this.loadController = loadController;
    }

    public void buildLoadScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        LabelPanel fileNamePanel = new LabelPanel(
                new JLabel("Enter your game save's name:"), fileName);

        JPanel buttons = new JPanel();
        buttons.add(loadButton);
        buttons.add(quickLoadButton);
        buttons.add(cancelButton);


        loadButton.addActionListener(this);
        quickLoadButton.addActionListener(this);
        cancelButton.addActionListener(this);

        panel.add(fileNamePanel);
        panel.add(buttons);

        buildFrame(window, panel);

        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Click " + event.getActionCommand());

        if (event.getSource() == loadButton) {
            try {
                this.loadController.performLoad(fileName.getText(), false);
                JOptionPane.showMessageDialog(this, String.format("%s loaded.", fileName.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else if (event.getSource() == quickLoadButton) {
            try {
                LoadResponse response = this.loadController.performLoad("a", true);
                JOptionPane.showMessageDialog(this, String.format("%s loaded.", response.getFilename()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else if (event.getSource() == cancelButton) {
            window.dispose();
        }
    }
}
