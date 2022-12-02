package UI.encounter_screens;

import entities.character.Player;
import useCases.merchantUseCases.PurchaseController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MerchantEncounterView extends EncounterView{

    /**
     * The Window will be poped up when the player hits the merchant.
     * The according image will be shown, as well as the according features, like purchase, and leave.
     */
    private JButton purchase;
    private Player player;
    private PurchaseController purchaseController;

    MerchantEncounterView(Player player) throws IOException {

        this.setTitle("MerchantEncountered"); // set the title of the frame

        BufferedImage img = ImageIO.read(new File("src/main/res/sample_merchant.png")); // read the image.
        Image dimg = img.getScaledInstance(200, 240, Image.SCALE_SMOOTH); // rescale the image displayed
        ImageIcon imageIcon = new ImageIcon(dimg); // create an instance of the image

        label = new JLabel(); //JLabel Creation
        label.setBounds(215, 55, 200, 240);
        label.setIcon(imageIcon); //Sets the image to be displayed as an icon

        c = this.getContentPane(); //Gets the content layer
        c.setBackground(new Color(0xECE592)); //rgb value, set the background color
        c.add(label); //Adds objects to the container

        purchase = new JButton("Purchase");
        purchase.setBounds(255, 350, 120, 30);
        purchase.addActionListener(this);
        c.add(purchase); // Add a purchase button on the container.

        leave = new JButton("Leave");
        leave.setBounds(480, 350, 120, 30);
        leave.addActionListener(this);
        c.add(leave); // Add a leave button on the container.

        // TODO: will add more buttons that characterize the features in the merchant class

        this.player = player;
        purchaseController = new PurchaseController(player, "Weapon");

        //TODO: Change based on player input

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == purchase){
            purchaseController.purchaseCheck();

            //should incorporate more features
        }

        if (e.getSource() == leave){
            System.out.println("Bye");
            // also links back to the main play state
            // TODO Incorporate more functionality
        }
    }
}



