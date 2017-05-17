package ucp.glp.histoire.ui;

import ucp.glp.histoire.utilities.Peuple;
import ucp.glp.histoire.utilities.peuples.Azteques;
import ucp.glp.histoire.utilities.peuples.Belges;
import ucp.glp.histoire.utilities.peuples.Britanniques;
import ucp.glp.histoire.utilities.peuples.Byzantins;
import ucp.glp.histoire.utilities.peuples.Chinois;
import ucp.glp.histoire.utilities.peuples.Espagnols;
import ucp.glp.histoire.utilities.peuples.Gandhi;
import ucp.glp.histoire.utilities.peuples.Grecs;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class ChosingPanel extends JPanel implements ActionListener {
    private static final ArrayList<Peuple> availablePeuples = new ArrayList<>();
    private static final ArrayList<Peuple> peuplesList = new ArrayList<>();
    private static ChosingFrame frame;
    private final JSpinner nbSpinner = new JSpinner(new SpinnerNumberModel(2, 2, 16, 1));
    private final JButton validateNumber = new JButton("Valider");
    private final JButton validatePeuples = new JButton("Valider");
    private final JLabel choseLabel = new JLabel("Choisissez le nombre de peuples");
    private final JLabel themeLabel = new JLabel("Thème :");
    private final JComboBox<String> themeCB = new JComboBox<String>();

    public ChosingPanel() {
        initPeuples();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        this.add(Box.createRigidArea(new Dimension(300, 10)));
        choseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        choseLabel.setFont(choseLabel.getFont().deriveFont(15f));
        this.add(choseLabel);
        this.add(Box.createRigidArea(new Dimension(200, 10)));
        nbSpinner.setMaximumSize(new Dimension(100, 50));
        nbSpinner.setAlignmentX(Component.CENTER_ALIGNMENT);
        validateNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(nbSpinner);
        this.add(Box.createRigidArea(new Dimension(200, 10)));
        validateNumber.addActionListener(this);
        this.add(validateNumber);
        this.add(Box.createRigidArea(new Dimension(200, 10)));
    }

    public static void setFrame(ChosingFrame frame) {
        ChosingPanel.frame = frame;
    }

    private static void initPeuples() {
        // TODO Creer ici tous les peuples choisissables
        availablePeuples.add(new Belges());
        availablePeuples.add(new Grecs());
        availablePeuples.add(new Gandhi());
        availablePeuples.add(new Azteques());
        availablePeuples.add(new Britanniques());
        availablePeuples.add(new Byzantins());
        availablePeuples.add(new Chinois());
        availablePeuples.add(new Espagnols());
    }

    private void createComponents(int nb) {
        for (int i = 0; i < nb; i++) {
            JComboBox<Peuple> peupleBox = new JComboBox<>();
            for (Object p : availablePeuples) {
            	// TODO Ajouter chaque peuple ici aussi
                if (p instanceof Belges)
                    peupleBox.addItem(new Belges());
                else if (p instanceof Grecs)
                    peupleBox.addItem(new Grecs());
                else if (p instanceof Gandhi)
                    peupleBox.addItem(new Gandhi());
                else if (p instanceof Azteques)
                    peupleBox.addItem(new Azteques());
                else if (p instanceof Britanniques)
                    peupleBox.addItem(new Britanniques());
                else if (p instanceof Byzantins)
                    peupleBox.addItem(new Byzantins());
                else if (p instanceof Chinois)
                    peupleBox.addItem(new Chinois());
                else if (p instanceof Espagnols)
                    peupleBox.addItem(new Espagnols());
            }
            peupleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(peupleBox);
            this.add(Box.createRigidArea(new Dimension(100, 10)));
        }
        validatePeuples.addActionListener(this);
        validatePeuples.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(validatePeuples);
        this.add(Box.createRigidArea(new Dimension(100, 10)));
        choseLabel.setText("Choisissez les peuples");

        ArrayList<String> themeList = initThemes();
        for (String s : themeList)
            themeCB.addItem(s);
        themeCB.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(themeLabel);
        this.add(themeCB);
        this.add(Box.createRigidArea(new Dimension(100, 10)));
    }

    private ArrayList<String> initThemes() {
        ArrayList<String> out = new ArrayList<String>();
        out.add("standard");
        out.add("alternatif");
        out.add("warcraft");
        return out;
    }

    private void populateAL() {
        Component[] components = this.getComponents();
        for (Component c : components)
            if (c instanceof JComboBox && ((JComboBox) c).getSelectedItem() instanceof Peuple)
                peuplesList.add((Peuple) ((JComboBox) c).getSelectedItem());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == validateNumber) {
            createComponents((int) nbSpinner.getValue());
            this.remove(nbSpinner);
            this.remove(validateNumber);
            frame.pack();
        } else if (e.getSource() == validatePeuples) {
            populateAL();
            frame.dispose();
            Thread t = new Thread() {
                public void run() {
                    new MainFrame(peuplesList, (String) themeCB.getSelectedItem());
                }
            };
            t.start();
        }
    }
}
