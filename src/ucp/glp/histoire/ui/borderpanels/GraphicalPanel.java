package ucp.glp.histoire.ui.borderpanels;

import ucp.glp.histoire.ui.MainFrame;
import ucp.glp.histoire.utilities.Peuple;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

/**
 * Zone centrale affichant le diagramme
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class GraphicalPanel extends JPanel {

    public final static Color WAR_COLOR = new Color(178, 62, 76);
    public final static Color TRADE_COLOR = new Color(71, 175, 255);
    private final static int nombrePeuples = MainFrame.getPeuplesNumber();
    private final int CIRCLE_DIAMETER = 450;
    private final int CIRCLE_RADIUS = CIRCLE_DIAMETER / 2;
    private final int PEUPLE_SIZE = 30 /* * 2*/;
    private final int HALO_SIZE = PEUPLE_SIZE + 6;
    private Graphics g1;
    private Color haloColor = Color.WHITE;

    public GraphicalPanel() {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
    }

    /**
     * Cr�e un lien entre deux peuples
     * @param peupleA
     * @param peupleB
     * @param couleur
     */
    private void createBond(int peupleA, int peupleB, Color couleur) {
        Graphics2D g2d = (Graphics2D) g1.create();
        g2d.setColor(couleur);
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(new Line2D.Double(CIRCLE_RADIUS * Math.cos(2 * peupleA * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE, CIRCLE_RADIUS * Math.sin(2 * peupleA * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE, CIRCLE_RADIUS * Math.cos(2 * peupleB * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE, CIRCLE_RADIUS * Math.sin(2 * peupleB * Math.PI / nombrePeuples) + CIRCLE_RADIUS + HALO_SIZE));
    }

    /**
     * Retourne l'index du pays avec lequel construire le lien
     * @param p
     * @return
     */
    private int getAlterIndex(Peuple p) {
        for (int i = 0; i < nombrePeuples; i++)
            if (MainFrame.getPeuplesArrayList().get(i) == p)
                return i;
        return 0;
    }

    /**
     * Cr�e le diagramme
     * @param g
     */
    private void init(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        g2d.drawOval(35, 30, CIRCLE_DIAMETER, CIRCLE_DIAMETER);

        for (int i = 0; i < nombrePeuples; i++) {
            if (MainFrame.getPeuplesArrayList().get(i).getListeEnnemies() != null)
                for (Peuple p : MainFrame.getPeuplesArrayList().get(i).getListeEnnemies())
                    createBond(i, getAlterIndex(p), WAR_COLOR);
            if (MainFrame.getPeuplesArrayList().get(i).getListeTrade() != null)
                for (Peuple p : MainFrame.getPeuplesArrayList().get(i).getListeTrade())
                    createBond(i, getAlterIndex(p), TRADE_COLOR);
        }

        for (int i = 1; i <= nombrePeuples; i++) {
            if (MainFrame.getPeuplesArrayList().get(i - 1).getListeEnnemies() != null && !MainFrame.getPeuplesArrayList().get(i - 1).getListeEnnemies().isEmpty())
                g2d.setColor(WAR_COLOR);
            else if (MainFrame.getPeuplesArrayList().get(i - 1).getListeTrade() != null && !MainFrame.getPeuplesArrayList().get(i - 1).getListeTrade().isEmpty())
                g2d.setColor(TRADE_COLOR);
            else
                g2d.setColor(haloColor);
            g2d.fill(new Ellipse2D.Double(CIRCLE_RADIUS * Math.cos(2 * i * Math.PI / nombrePeuples) + CIRCLE_RADIUS + PEUPLE_SIZE / 2, CIRCLE_RADIUS * Math.sin(2 * i * Math.PI / nombrePeuples) + CIRCLE_RADIUS + PEUPLE_SIZE / 2, HALO_SIZE, HALO_SIZE));
            g2d.setColor(MainFrame.getPeuplesArrayList().get(i - 1).getColor());
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
