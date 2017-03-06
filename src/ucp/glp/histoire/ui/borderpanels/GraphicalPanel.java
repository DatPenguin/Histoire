package ucp.glp.histoire.ui.borderpanels;

import ucp.glp.histoire.ui.MainFrame;
import ucp.glp.histoire.utilities.Peuple;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 19/01/2017
 */
public class GraphicalPanel extends JPanel {

    private final static int nombrePeuples = MainFrame.getPeuplesNumber();
    private static ArrayList<Color> colorList = new ArrayList<>();
    private static ArrayList<Color> haloColorList = new ArrayList<>();
    private final int CIRCLE_DIAMETER = 450;
    private final int CIRCLE_RADIUS = CIRCLE_DIAMETER / 2;
    private final int PEUPLE_SIZE = 30;
    private int HALO_SIZE = 36;
    private Graphics g1;
    private Color haloColor = Color.WHITE;

    public GraphicalPanel() {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);

        initColors();
    }

    public GraphicalPanel(Color c) {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);

        initColors();
        haloColor = c;
    }

    public static void initColors() {
        Random r = new Random();
        for (int i = 0; i < nombrePeuples; i++)
            colorList.add(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()));
    }

    public void initHaloColorList(ArrayList<Peuple> peuples) {
        for (Peuple p : peuples) {
            if (!p.getListeEnnemies().isEmpty())
                haloColorList.add(Color.RED);
            else
                haloColorList.add(Color.WHITE);
        }
    }

    private void init(Graphics g) {
        Random r = new Random();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        g2d.drawOval(35, 30, CIRCLE_DIAMETER, CIRCLE_DIAMETER);

        for (int i = 1; i <= nombrePeuples; i++) {
            g2d.setColor(haloColor);
            // TODO Calculer a chaque tour la taille du halo en fonction de la puissance du pays affiche
            g2d.fill(new Ellipse2D.Double(CIRCLE_RADIUS * Math.cos(2 * i * Math.PI / nombrePeuples) + CIRCLE_RADIUS + PEUPLE_SIZE / 2, CIRCLE_RADIUS * Math.sin(2 * i * Math.PI / nombrePeuples) + CIRCLE_RADIUS + PEUPLE_SIZE / 2, HALO_SIZE, HALO_SIZE));
            g2d.setColor(colorList.get(i - 1));
            g2d.fill(new Ellipse2D.Double(CIRCLE_RADIUS * Math.cos(2 * i * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE / 2, CIRCLE_RADIUS * Math.sin(2 * i * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE / 2, PEUPLE_SIZE, PEUPLE_SIZE));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g1 = g;
        this.setOpaque(false);
        init(g);
    }
}
