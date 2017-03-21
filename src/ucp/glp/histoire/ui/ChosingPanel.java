package ucp.glp.histoire.ui;

import ucp.glp.histoire.utilities.Peuple;
import ucp.glp.histoire.utilities.inherited.Belges;
import ucp.glp.histoire.utilities.inherited.Gandhi;
import ucp.glp.histoire.utilities.inherited.Grecs;

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
    private static ChosingFrame frame;
    private static ArrayList<Peuple> availablePeuples = new ArrayList<>();
    private static ArrayList<Peuple> peuplesList = new ArrayList<>();
    private JSpinner nbSpinner = new JSpinner(new SpinnerNumberModel(2, 2, 16, 1));
    private JButton validateNumber = new JButton("Valider");
    private JButton validatePeuples = new JButton("Valider");
    private JLabel choseLabel = new JLabel("Choisissez le nombre de peuples");

    private JComboBox<String> themeCB = new JComboBox<String>();

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
    }

    private void createComponents(int nb) {
        for (int i = 0; i < nb; i++) {
            JComboBox<Peuple> peupleBox = new JComboBox<>();
            for (Object p : availablePeuples) {
                if (p instanceof Belges)
                    peupleBox.addItem(new Belges());
                else if (p instanceof Grecs)
                    peupleBox.addItem(new Grecs());
                else if (p instanceof Gandhi)
                    peupleBox.addItem(new Gandhi());
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
        this.add(themeCB);
        this.add(Box.createRigidArea(new Dimension(100, 10)));
    }

    private ArrayList<String> initThemes() {
        ArrayList<String> out = new ArrayList<String>();
        out.add("standard");
        out.add("alternatif");
        return out;
    }

    private void populateAL() {
        //TODO Faire en sorte de ne pas envoyer les memes objets
        Component[] components = this.getComponents();
        for (Component c : components) {
            if (c instanceof JComboBox && ((JComboBox) c).getSelectedItem() instanceof Peuple)
                peuplesList.add((Peuple) ((JComboBox) c).getSelectedItem());
        }
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
