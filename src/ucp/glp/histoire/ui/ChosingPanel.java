package ucp.glp.histoire.ui;

import ucp.glp.histoire.utilities.Peuple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 24/02/2017
 */
public class ChosingPanel extends JPanel implements ActionListener {
    public static ChosingFrame frame;
    private static ArrayList<Peuple> availablePeuples = new ArrayList<>();
    private static ArrayList<Peuple> peuplesList = new ArrayList<>();
    private JSpinner nbSpinner = new JSpinner(new SpinnerNumberModel(2, 2, 16, 1));
    private JButton validateNumber = new JButton("Valider");
    private JButton validatePeuples = new JButton("Valider");
    private JLabel choseLabel = new JLabel("Choisissez le nombre de peuples");

    public ChosingPanel() {
        initPeuples();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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

    private static void initPeuples() {
        // TODO Creer ici tous les peuples choisissables
        availablePeuples.add(new Peuple(50, 50, 50, 70, 50, "Belges"));
        availablePeuples.add(new Peuple(90, 80, 50, 25, 22, "Grecs"));
    }

    private void createComponents(int nb) {
        for (int i = 0; i < nb; i++) {
            JComboBox<Peuple> peupleBox = new JComboBox<>();
            for (Object p : availablePeuples)
                peupleBox.addItem((Peuple) p);
            peupleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(peupleBox);
            this.add(Box.createRigidArea(new Dimension(100, 10)));
        }
        validatePeuples.addActionListener(this);
        this.add(validatePeuples);
        this.add(Box.createRigidArea(new Dimension(100, 10)));
        choseLabel.setText("Choisissez les peuples");
    }


    private void populateAL() {
        Component[] components = this.getComponents();
        for (Component c : components) {
            if (c instanceof JComboBox)
                peuplesList.add((Peuple) ((JComboBox) c).getSelectedItem());
        }

        System.out.println(peuplesList);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
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
            		new MainFrame(peuplesList);
            	}
            };
            t.start();
        }
    }
}
