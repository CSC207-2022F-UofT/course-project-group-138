package UI.encounter_screens;

import gateways.ImageGateway;
import controllers.MerchantController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class MerchantEncounterView extends EncounterView {

    /**
     * The Window will be poped up when the player hits the merchant.
     * The according image will be shown, as well as the according features, like purchase, and leave.
     */
    private JButton Upgrade;
    private MerchantController merchantController;

    public MerchantEncounterView() {

        this.setTitle("MerchantEncountered"); // set the title of the frame

        BufferedImage img = ImageGateway.getMerchant1(); // read the image.
        Image dimg = img.getScaledInstance(200, 240, Image.SCALE_SMOOTH); // rescale the image displayed
        ImageIcon imageIcon = new ImageIcon(dimg); // create an instance of the image

        label = new JLabel(); //JLabel Creation
        label.setBounds(190, 30, 200, 240);
        label.setIcon(imageIcon); //Sets the image to be displayed as an icon

        c = this.getContentPane(); //Gets the content layer
        c.setBackground(new Color(0xECE592)); //rgb value, set the background color
        c.add(label); //Add later objects to the container

        exit = new JButton("Exit");
        exit.setBounds(480, 290, 120, 90);
        exit.addActionListener(merchantController.getMerchantListener());
        exit.setActionCommand("Exit");
        exit.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.add(exit); // Add an Exit button on the container.

        Upgrade = new JButton("Upgrade");
        Upgrade.setBounds(30, 290, 190, 90);
        Upgrade.addActionListener(merchantController.getMerchantListener());
        Upgrade.setActionCommand("Upgrade");
        Upgrade.setFont(new Font("Comic Sans", Font.BOLD, 17));
        c.add(Upgrade);// Add an Upgrade button on the container


    }

//    ActionListener commandListener = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            purchaseController = new PurchaseController(e);
//            boolean success = purchaseController.purchaseCheck();
//            if (success) {
//                JOptionPane.showMessageDialog(null, String.format("%s upgraded.", e.getActionCommand()));
//            } else {
//                JOptionPane.showMessageDialog(null, "Can't make the purchse. Not enough coins.");
//            }
//        }
//    };

//    ActionListener exitListener = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.exit(0);
//        }
//    };

    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Upgrade){
            state.clickEvents(0);
        }
        if(e.getSource() == exit){
            System.exit(0);
        }

    }

     */
}


