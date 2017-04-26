package ucp.glp.histoire.ui.borderpanels;

import ucp.glp.histoire.ui.borderpanels.utilities.DetailsArea;
import ucp.glp.histoire.utilities.Peuple;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class DetailsPanel extends JPanel {
    private final DetailsArea textArea = new DetailsArea();

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
        textArea.appendln("Population : " + p.getPopulation());
        textArea.appendln("Ressources : " + p.getRessources());
        textArea.appendln("Agressivit� : " + p.getAgressivite());
        textArea.appendln("Education : " + p.getEducation());
        textArea.appendln("Territoire : " + p.getTerritoire() + '\n');

        textArea.appendln("Attributs secondaires :");
        textArea.appendln("Attractivit� : " + p.getAttractivite());
        textArea.appendln("Bellicisme : " + p.getBellicisme());
        textArea.appendln("Densit� : " + p.getDensite());
        textArea.appendln("Immigration : " + p.getImmigration());
        textArea.appendln("Nombre de soldats : " + p.getNbSoldat());
        textArea.appendln("Richesse : " + p.getRichesse());
        textArea.appendln("Technologie : " + p.getTechnologie());
    }
}
