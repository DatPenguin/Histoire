package ucp.glp.histoire.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 16/01/2017
 */
public class MainPanel extends JPanel {

    private InfoPanel infoPanel = new InfoPanel();
    private LeftPanel leftPanel = new LeftPanel();
    private RightPanel rightPanel = new RightPanel();

    public MainPanel() {
        this.setLayout(null);
        this.setBackground(Color.blue);

        infoPanel.setBounds(370, 35, 530, 515);
        this.add(infoPanel);

        leftPanel.setBounds(35, 35, 300, 515);
        this.add(leftPanel);

        rightPanel.setBounds(935, 35, 300, 515);
        this.add(rightPanel);
    }
}
