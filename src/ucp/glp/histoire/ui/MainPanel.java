package ucp.glp.histoire.ui;

import fr.theshark34.swinger.Swinger;
import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.ui.borderpanels.*;
import ucp.glp.histoire.ui.events.LoopEvent;
import ucp.glp.histoire.ui.events.LoopListener;
import ucp.glp.histoire.utilities.Peuple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class MainPanel extends JPanel implements LoopListener {

    private static LoopEvent e = new LoopEvent();

    private static float running = 0;
    private static float totalYears = 0;
    private static JLabel barLabel = new JLabel();
    private static JLabel runningLabel = new JLabel();
    private static RightPanel rightPanel = new RightPanel();
    private JPanel centerPanel = new GraphicalPanel();
    private LeftPanel leftPanel = new LeftPanel();
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

        BottomPanel.setMainPanel(this);
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

        leftPanel.getTop().setMainPanel(this);

        e.addListener(this);
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

    public static float getRunning() {
        return running;
    }

    public static void setRunning(float running) {
        MainPanel.running = running;
    }

    public static float getTotalYears() {
        return totalYears;
    }

    public static void setTotalYears(float totalYears) {
        MainPanel.totalYears = totalYears;
    }

    public static LoopEvent getEvent() {
        return e;
    }

    public static void addToLog(ArrayList<String> logList) {
        rightPanel.getLogPanel().appendText(logList);
    }

    public void addToSeries(int x, double y) {
        rightPanel.addToSeries(x, y);
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public void swapCenter(Peuple p) {
        this.remove(centerPanel);
        centerPanel = new DetailsPanel(p);
        centerPanel.setBounds(370, 35, 530, 515);
        this.add(centerPanel);
    }

    public void refresh() {
        this.remove(centerPanel);
        centerPanel = new GraphicalPanel();
        centerPanel.setBounds(370, 35, 530, 515);
        this.add(centerPanel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        Swinger.drawFullsizedImage(g, this, Swinger.getResource("background.png"));
    }

    @Override
    public void looped() {
        int totalPop = 0;
        for (Peuple p : MainFrame.getPeuplesArrayList())
            totalPop += p.getPopulation();
        this.getParent().repaint();
        leftPanel.getTop().actionPerformed(new ActionEvent(this, 42, "refresh"));
        addToSeries(RunningLoop.nbIteration, totalPop);
    }
}
