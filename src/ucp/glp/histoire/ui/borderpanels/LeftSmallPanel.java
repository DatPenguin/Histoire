package ucp.glp.histoire.ui.borderpanels;

import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.ui.MainFrame;
import ucp.glp.histoire.ui.MainPanel;
import ucp.glp.histoire.utilities.Peuple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class LeftSmallPanel extends JPanel implements ActionListener {

    private final JComboBox<String> comboBox;
    private final JButton button = new JButton();
    private MainPanel mainPanel = null;
    private int type = 0;

    public LeftSmallPanel(int type) {
        this.setLayout(new BorderLayout());
        button.setPreferredSize(new Dimension(50, 50));
        button.addActionListener(this);

        if (type == 1) {
            comboBox = new JComboBox(MainFrame.getPeuplesArrayList().toArray());
            comboBox.insertItemAt("Aucun", 0);
            button.setText("S�lectionnez un peuple");
            this.type = 1;
        } else {
            comboBox = new JComboBox(MainFrame.getEventArrayList().toArray());
            button.setText("S�lectionnez un �v�nement");
        }

        this.add(button, BorderLayout.SOUTH);
        this.add(comboBox, BorderLayout.NORTH);
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public int getSelectedIndex() {
        return comboBox.getSelectedIndex();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button && type == 1) {
            if (comboBox.getSelectedItem().equals("Aucun")) {
                mainPanel.refresh();
                mainPanel.repaint();
            } else {
                mainPanel.swapCenter((Peuple) comboBox.getSelectedItem());
                mainPanel.repaint();
            }
        } else if (e.getActionCommand().equals("refresh") && mainPanel.getCenterPanel() instanceof DetailsPanel) {
            if (comboBox.getSelectedItem().equals("Aucun")) {
                mainPanel.refresh();
                mainPanel.repaint();
            } else {
                mainPanel.swapCenter((Peuple) comboBox.getSelectedItem());
                mainPanel.repaint();
            }
        } else if (e.getSource() == button) {
            RunningLoop.fileGlobalEvent.add(MainFrame.eventHashMap.get(comboBox.getSelectedItem()));
            System.out.println(MainFrame.eventHashMap.get(comboBox.getSelectedItem()));
        }
    }
}
