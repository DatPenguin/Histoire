package ucp.glp.histoire.test.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class GraphicalPanel extends JPanel {

    private final int n = 10;

    public GraphicalPanel() {
        this.setLayout(null);
    }

    private void init(Graphics g) {
        Random r = new Random();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawOval(35, 15, 450, 450);

        for (int i = 1; i <= n; i++) {
            g2d.setColor(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()));
            g2d.fill(new Ellipse2D.Double(225 * Math.cos(2 * i * Math.PI / n) + 245, 225 * Math.sin(2 * i * Math.PI / n) + 225, 30, 30));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        init(g);
    }
}
