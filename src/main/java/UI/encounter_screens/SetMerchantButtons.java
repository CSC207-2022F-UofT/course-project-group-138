package UI.encounter_screens;

import controllers.MerchantController;

import javax.swing.*;

public interface SetMerchantButtons {
    
    static final MerchantController merchantController = new MerchantController();

    static final JButton exit = new JButton("Exit");
    static final JButton Upgrade = new JButton("Upgrade");
}
