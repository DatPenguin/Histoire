package ucp.glp.histoire.ui.borderpanels;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 19/01/2017
 */
public class CenterPanel extends JPanel {

    JButton a = new JButton("Bonjour");

    public CenterPanel() {
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        this.add(a, BorderLayout.SOUTH);
    }
}
