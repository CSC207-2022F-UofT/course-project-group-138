package UI.game_menu;

import save.save_screen.LoadController;
import save.save_screen.SaveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuScreen extends JPanel implements ActionListener {
    private JLabel screenTitle = new JLabel("Main Menu");

    private JButton newGameButton = new JButton("New Game");

    private JButton saveButton = new JButton("Save");

    private JButton loadButton = new JButton("Load");

    private JButton exitButton = new JButton("Exit Game");

    SaveController saveController;

    LoadController loadController;

    public MainMenuScreen(SaveController saveController, LoadController loadController) {
/*        // create and set up the menu window
        JFrame mainMenu = new JFrame("Main Menu");
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set up the content pane
        addComponentsToPane(mainMenu.getContentPane());

        // display the menu window
        mainMenu.pack();
        mainMenu.setVisible(true);*/

        this.saveController = saveController;
        this.loadController = loadController;



        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.add(this.newGameButton);
        buttons.add(this.saveButton);
        buttons.add(this.loadButton);
        buttons.add(this.exitButton);
        //buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

        newGameButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        exitButton.addActionListener(this);



        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(screenTitle);
        this.add(buttons);
    }

/*    public void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        addAButton(this.newGameButton, pane);
        addAButton(this.saveButton, pane);
        addAButton(this.loadButton, pane);
        addAButton(this.exitButton, pane);


    }*/

/*    private void addAButton(JButton button, Container container) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }*/

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Click " +  event.getActionCommand());

/*        if (event.getSource() == saveButton) {
            try {
                this.saveController.performSave()
            }
        }*/
    }
}
