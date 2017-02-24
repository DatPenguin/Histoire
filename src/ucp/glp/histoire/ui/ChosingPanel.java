package ucp.glp.histoire.ui;

import ucp.glp.histoire.utilitaires.Peuple;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 24/02/2017
 */
public class ChosingPanel extends JPanel {
    ArrayList<Peuple> peupleList = new ArrayList<>();

    public ChosingPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(100, 10)));
        for (int i = 0; i < 6; i++) {
            JComboBox<Peuple> peupleBox = new JComboBox<Peuple>(peupleList.toArray());
            // TODO Trouver comment peupler les combobox a partir de l'arraylist
            peupleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(peupleBox);
            this.add(Box.createRigidArea(new Dimension(100, 10)));
        }
    }

    private void initPeuples() {
        // TODO Creer ici tous les peuples choisissables
        peupleList.add(new Peuple(50, 50, 50, 70, 50, "Belges"));
        peupleList.add(new Peuple(90, 80, 50, 25, 22, "Grecs"));
    }
}
