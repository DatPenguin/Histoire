package ucp.glp.histoire.ui.borderpanels;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class RightPanel extends JPanel {
    private RightEventPanel top = new RightEventPanel();
    private RightLogPanel bot = new RightLogPanel();

    public RightPanel() {
        this.setBackground(null);
        this.setLayout(new BorderLayout());
        this.add(top, BorderLayout.NORTH);
        this.add(bot, BorderLayout.SOUTH);
        this.setOpaque(false);
    }

    public RightLogPanel getLogPanel() {
        return bot;
    }
}
