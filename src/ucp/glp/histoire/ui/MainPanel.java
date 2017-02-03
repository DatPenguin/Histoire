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

    public static float running = 0;
    public static float totalYears = 0;
    private static JLabel barLabel = new JLabel();
    private static JLabel runningLabel = new JLabel();
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

        barLabel.setBounds(35, 35, 100, 30);
        barLabel.setFont(barLabel.getFont().deriveFont(20f));
        barLabel.setForeground(Color.white);
        this.add(barLabel);
        runningLabel.setBounds(35, 70, 100, 30);
        runningLabel.setFont(runningLabel.getFont().deriveFont(20f));
        runningLabel.setForeground(Color.white);
        this.add(runningLabel);
    }

    public static void setBarLabelText(String barLabel) {
        MainPanel.barLabel.setText(barLabel);
    }

    public static void setRunningLabelText(String runningLabel) {
        MainPanel.runningLabel.setText(runningLabel);
    }

    public static JLabel getRunningLabel() {
        return runningLabel;
    }
}
