package ucp.glp.histoire.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 23/01/2017
 */
public class LeftPanel extends JPanel {

    private JComboBox<String> peopleComboBox = new JComboBox(MainFrame.peuplesArrayList.toArray());
    private JButton peopleButton = new JButton("Sélectionner un peuple");

    public LeftPanel() {
        this.setLayout(new BorderLayout());
        peopleButton.setMinimumSize(new Dimension(50, 50));
        this.add(peopleButton, BorderLayout.SOUTH);
        this.add(peopleComboBox, BorderLayout.NORTH);
    }
}
