package ucp.glp.histoire.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 23/01/2017
 */
public class LeftPanel extends JPanel {

    private JComboBox<String> peopleComboBox = new JComboBox(MainFrame.peuplesArrayList.toArray());

    public LeftPanel() {
        this.setBackground(Color.RED); //TODO POURQUOI CA MARCHE PAS ?
        this.setLayout(new BorderLayout());
        this.add(peopleComboBox, BorderLayout.NORTH);
    }
}
