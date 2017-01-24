package ucp.glp.histoire.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 24/01/2017
 */
public class RightPanel extends JPanel {
    private RightSmallPanel top = new RightSmallPanel(1);
    private RightSmallPanel bot = new RightSmallPanel(2);

    public RightPanel() {
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
        this.add(top, BorderLayout.NORTH);
        this.add(bot, BorderLayout.SOUTH);
    }
}
