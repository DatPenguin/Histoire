package ucp.glp.histoire.ui.borderpanels;

import ucp.glp.histoire.ui.MainFrame;
import ucp.glp.histoire.ui.MainPanel;
import ucp.glp.histoire.utilities.Peuple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class LeftSmallPanel extends JPanel implements ActionListener {

    private MainPanel mainPanel = null;
    private JComboBox<String> comboBox;
    private JButton button = new JButton();
    private int type = 0;

    public LeftSmallPanel(int type) {
        this.setLayout(new BorderLayout());
        button.setPreferredSize(new Dimension(50,50));
        button.addActionListener(this);

        if (type == 1) {
            comboBox = new JComboBox(MainFrame.getPeuplesArrayList().toArray());
            comboBox.insertItemAt("Aucun", 0);
            button.setText("Sélectionnez un peuple");
            this.type = 1;
        }
        else {
            comboBox = new JComboBox(MainFrame.getEventArrayList().toArray());
            button.setText("Sélectionnez un évènement");
        }

        this.add(button, BorderLayout.SOUTH);
        this.add(comboBox, BorderLayout.NORTH);
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public Peuple getSelected() {
        return (Peuple) comboBox.getSelectedItem();
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
        }
    }
}
