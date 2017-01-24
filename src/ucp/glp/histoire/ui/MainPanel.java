package ucp.glp.histoire.ui;

import ucp.glp.histoire.ui.borderpanels.BottomPanel;
import ucp.glp.histoire.ui.borderpanels.CenterPanel;
import ucp.glp.histoire.ui.borderpanels.LeftPanel;
import ucp.glp.histoire.ui.borderpanels.RightPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 16/01/2017
 */
public class MainPanel extends JPanel {

    private CenterPanel centerPanel = new CenterPanel();

    private LeftPanel leftPanel = new LeftPanel();
    private RightPanel rightPanel = new RightPanel();

    private BottomPanel bottomPanel = new BottomPanel();

    public MainPanel() {
        this.setLayout(null);
        this.setBackground(Color.blue);

        centerPanel.setBounds(370, 35, 530, 515);
        this.add(centerPanel);

        leftPanel.setBounds(35, 185, 300, 365);
        this.add(leftPanel);

        rightPanel.setBounds(935, 35, 300, 515);
        this.add(rightPanel);

        bottomPanel.setBounds(35, 580, 1200, 85);
        this.add(bottomPanel);
    }
}
