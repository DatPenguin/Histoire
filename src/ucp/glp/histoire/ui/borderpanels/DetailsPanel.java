package ucp.glp.histoire.ui.borderpanels;

import ucp.glp.histoire.ui.MainPanel;
import ucp.glp.histoire.ui.borderpanels.utilities.DetailsArea;
import ucp.glp.histoire.utilities.Peuple;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class DetailsPanel extends JPanel {
    public MainPanel mainPanel = null;
    private DetailsArea textArea = new DetailsArea();

    public DetailsPanel(Peuple p) {
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        this.add(textArea, BorderLayout.CENTER);
        textArea.setEditable(false);
        initTextArea(p);
    }

    private void initTextArea(Peuple p) {
        textArea.appendln("Attributs primaires :");
        textArea.appendln("Nom : " + p.getNom());
        textArea.appendln("Agressivité : " + p.getAgressivite());
        textArea.appendln("Attractivité : " + p.getAttractivite());
        textArea.appendln("Bellicisme : " + p.getBellicisme());
        textArea.appendln("Densité : " + p.getDensite());
        textArea.appendln("Education : " + p.getEducation());
        textArea.appendln("Education : " + p.getImmigration());
        textArea.appendln("Nombre de soldats : " + p.getNbSoldat());
        textArea.appendln("Population : " + p.getPopulation());
        textArea.appendln("Ressources : " + p.getRessources());
        textArea.appendln("Richesse : " + p.getRichesse());
        textArea.appendln("Technologie : " + p.getTechnologie());
        textArea.appendln("Territoire : " + p.getTerritoire());
    }
}
