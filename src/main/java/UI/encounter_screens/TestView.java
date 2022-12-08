package UI.encounter_screens;


import entities.character.Player;
import entities.inventory.Armor;
import entities.inventory.Inventory;
import entities.inventory.Weapon;

public class TestView {
    public static void main(String[] args) {

        EnemyEncounterView eev = new EnemyEncounterView();
        MerchantEncounterView mev =
                new MerchantEncounterView(new Player(new Inventory(0, new Weapon(3), new Armor(3)), 0, 0, 0));



/*        ImageIcon image = new ImageIcon();

        JLabel label = new JLabel();
        label.setText("ccccccccc");
        // lable.setIcon(image);
        myFrame.add(label);

 */









    }
}
