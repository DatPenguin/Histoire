package ucp.glp.histoire.ui.borderpanels;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class RightPanel extends JPanel {
    private XYSeries series = new XYSeries("Population");
    private XYDataset dataset = new XYSeriesCollection(series);

    private RightEventPanel top = new RightEventPanel();
    private RightLogPanel bot = new RightLogPanel();
    private JFreeChart popChart = ChartFactory.createXYLineChart("Population", "Temps", "Nb d'habitants", dataset, PlotOrientation.VERTICAL, true, true, false);
    private ChartPanel cPanel = new ChartPanel(popChart);

    public RightPanel() {
        this.setBackground(null);
        this.setLayout(new BorderLayout());
        cPanel.setPreferredSize(new Dimension(10, 300));
        popChart.getXYPlot().getRangeAxis().setAutoRange(true);
        this.add(cPanel, BorderLayout.NORTH);
        this.add(bot, BorderLayout.SOUTH);
        this.setOpaque(false);
    }

    public void addToSeries(int x, double y) {
        series.add(x, y);
    }

    public RightLogPanel getLogPanel() {
        return bot;
    }
}
