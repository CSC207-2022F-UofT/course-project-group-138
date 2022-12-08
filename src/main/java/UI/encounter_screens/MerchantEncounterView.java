package UI.encounter_screens;

import gateways.ImageGateway;
import controllers.MerchantController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class MerchantEncounterView extends EncounterView implements SetLabel, SetMerchantButtons{

    /**
     * The Window will be poped up when the player hits the merchant.
     * The according image will be shown, as well as the according features, like purchase, and leave.
     */


    public MerchantEncounterView() {

        this.setTitle("MerchantEncountered"); // set the title of the frame

        BufferedImage img = ImageGateway.getMerchant1(); // read the image.
        Image dimg = img.getScaledInstance(200, 240, Image.SCALE_SMOOTH); // rescale the image displayed
        ImageIcon imageIcon = new ImageIcon(dimg); // create an instance of the image

        label.setBounds(215, 30, 200, 240);
        label.setIcon(imageIcon); //Sets the image to be displayed as an icon

        c = this.getContentPane(); //Gets the content layer
        c.setBackground(new Color(0xECE592)); //rgb value, set the background color
        c.add(label); //Add later objects to the container

        exit.setBounds(480, 290, 120, 90);
        exit.addActionListener(this);
        exit.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.add(exit); // Add an Exit button on the container.

        Upgrade.setBounds(30, 290, 190, 90);
        Upgrade.addActionListener(this);
        Upgrade.setActionCommand("Weapon");
        Upgrade.setFont(new Font("Comic Sans", Font.BOLD, 17));
        c.add(Upgrade);// Add an Upgrade button on the container
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Upgrade){
            //TODO: call MerchantController
        }
        if(e.getSource() == exit){
            System.exit(0);
        }
    }}


