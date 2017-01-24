package ucp.glp.histoire.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 24/01/2017
 */
public class RightPanel extends JPanel {
    private RightEventPanel top = new RightEventPanel();
    private RightLogPanel bot = new RightLogPanel();

    public RightPanel() {
        this.setBackground(null);
        this.setLayout(new BorderLayout());
        this.add(top, BorderLayout.NORTH);
        this.add(bot, BorderLayout.SOUTH);
    }
}
