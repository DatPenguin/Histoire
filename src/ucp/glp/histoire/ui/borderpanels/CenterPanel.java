package ucp.glp.histoire.ui.borderpanels;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 19/01/2017
 */
public class CenterPanel extends JPanel {

    final int nombrePeuples = 5;

    final int CIRCLE_DIAMETER = 450;
    final int CIRCLE_RADIUS = CIRCLE_DIAMETER / 2;

    public CenterPanel() {
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
    }

    private void init(Graphics g) {
        Random r = new Random();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        g2d.drawOval(35, 30, CIRCLE_DIAMETER, CIRCLE_DIAMETER);

        for (int i = 1; i <= nombrePeuples; i++) {
            g2d.setColor(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()));
            g2d.fill(new Ellipse2D.Double(CIRCLE_RADIUS * Math.cos(2 * i * Math.PI / nombrePeuples) + CIRCLE_RADIUS + 20, CIRCLE_RADIUS * Math.sin(2 * i * Math.PI / nombrePeuples) + CIRCLE_RADIUS + 15, 30, 30));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        init(g);
    }
}
