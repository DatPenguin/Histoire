package ucp.glp.histoire.ui;

import javax.swing.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 16/01/2017
 */
public class MainPanel extends JPanel {
    private JTextArea log = new JTextArea();
    private InfoPanel infoPanel = new InfoPanel();
    public MainPanel() {
        this.setLayout(null);
        infoPanel.setBounds(250,5,200,300);
        infoPanel.setVisible(true);
        this.add(infoPanel);
    }
}
