package UI.encounter_screens;

import entities.character.Merchant;
import entities.character.Player;
import useCases.merchantUseCases.PurchaseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MerchantEncounterView extends JFrame implements ActionListener {
    private JButton purchase;
    private Player player;
    private PurchaseController purchaseController;
    private Merchant merchant;

    MerchantEncounterView(Player player) {

        this.setVisible(true);
        this.setSize(630, 420);
        this.setTitle("MerchantEncountered");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of app
        this.setResizable(false); // can't resize
        this.setLocationRelativeTo(null); //centered
        // ImageIcon image = new ImageIcon("logo.png");
        // frame.setIconImage(image.getImage());
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x12345)); //rgb value

        this.player = player;
        purchaseController = new PurchaseController(player, merchant);
        //TODO: Change based on player input

        purchase = new JButton("purchase");
        purchase.setBounds(255, 350, 120, 30);

        purchase.addActionListener(this);

        add(purchase);



        // will add more buttons that characterize the features in the merchant class
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == purchase){
//            purchaseController.purchaseCheck();                       // TODO: Fix method with new PurchaseController implementation

            //should incorporate more features
        }
    }
}



