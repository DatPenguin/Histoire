package ucp.glp.histoire.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 23/01/2017
 */
public class LeftSmallPanel extends JPanel {

    private JComboBox<String> comboBox;
    private JButton button = new JButton();

    public LeftSmallPanel(int type) {
        this.setLayout(new BorderLayout());
        button.setPreferredSize(new Dimension(50,50));

        if (type == 1) {
            comboBox = new JComboBox(MainFrame.peuplesArrayList.toArray());
            button.setText("Sélectionnez un peuple");
        }
        else {
            comboBox = new JComboBox(MainFrame.eventArrayList.toArray());
            button.setText("Sélectionnez un évènement");
        }

        this.add(button, BorderLayout.SOUTH);
        this.add(comboBox, BorderLayout.NORTH);
    }
}
