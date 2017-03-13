package ucp.glp.histoire.ui.borderpanels;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class LeftPanel extends JPanel {

    private LeftSmallPanel top = new LeftSmallPanel(1);
    private LeftSmallPanel bot = new LeftSmallPanel(2);

    public LeftPanel() {
        this.setBackground(null);
        this.setLayout(new BorderLayout());
        this.add(top, BorderLayout.NORTH);
        this.add(bot, BorderLayout.SOUTH);
        this.setOpaque(false);
    }

    public LeftSmallPanel getTop() {
        return top;
    }
}
