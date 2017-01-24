package ucp.glp.histoire.ui.borderpanels;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 23/01/2017
 */
public class LeftPanel extends JPanel {

    private LeftSmallPanel top = new LeftSmallPanel(1);
    private LeftSmallPanel bot = new LeftSmallPanel(2);

    public LeftPanel() {
        this.setBackground(null);
        this.setLayout(new BorderLayout());
        this.add(top, BorderLayout.NORTH);
        this.add(bot, BorderLayout.SOUTH);
    }
}
