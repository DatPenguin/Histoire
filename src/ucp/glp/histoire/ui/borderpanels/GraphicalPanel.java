package ucp.glp.histoire.ui.borderpanels;

import ucp.glp.histoire.ui.MainFrame;
import ucp.glp.histoire.utilities.Peuple;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
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

    public void createBond(int a, int b) {
        Graphics2D g2d = (Graphics2D) g1.create();
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(new Line2D.Double(CIRCLE_RADIUS * Math.cos(2 * a * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE, CIRCLE_RADIUS * Math.sin(2 * a * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE, CIRCLE_RADIUS * Math.cos(2 * b * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE, CIRCLE_RADIUS * Math.sin(2 * b * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE));
    }

    public void createBond(int a, int b, Color c) {
        Graphics2D g2d = (Graphics2D) g1.create();
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(new Line2D.Double(CIRCLE_RADIUS * Math.cos(2 * a * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE, CIRCLE_RADIUS * Math.sin(2 * a * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE, CIRCLE_RADIUS * Math.cos(2 * b * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE, CIRCLE_RADIUS * Math.sin(2 * b * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE));
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

        for (int i = 0; i < nombrePeuples; i++)
            for (int j = 0; j < nombrePeuples; j++) {
                if (j % 2 == 0)
                    createBond(i, j, new Color(178, 62, 76));
                else
                    createBond(i, j, new Color(71, 175, 255));
            }

        for (int i = 1; i <= nombrePeuples; i++) {
/*            if (!MainFrame.getPeuplesArrayList().get(i).getListeEnnemies().isEmpty())
                g2d.setColor(Color.RED);
            else if (!MainFrame.getPeuplesArrayList().get(i - 1).getListeTrade().isEmpty())
                g2d.setColor(Color.GREEN);
            else*/
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
