package ucp.glp.histoire.ui.borderpanels;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.ui.MainFrame;
import ucp.glp.histoire.ui.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel � droite, contenant les graphiques et les logs
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class RightPanel extends JPanel {
    private final XYSeries series = new XYSeries("Population");
    private final XYSeriesCollection dataset = new XYSeriesCollection();
    private final ArrayList<XYSeriesCollection> datasetsList = new ArrayList<XYSeriesCollection>();
    private final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    private final RightLogPanel bot = new RightLogPanel();
    private final JFreeChart popChart = ChartFactory.createXYLineChart("Population globale", "Temps", "Nb d'habitants", dataset, PlotOrientation.VERTICAL, true, true, false);
    private final ArrayList<JFreeChart> chartsList = new ArrayList<JFreeChart>();
    public MainPanel mainPanel;
    private ChartPanel cPanel = new ChartPanel(popChart);

    public RightPanel() {
        this.setBackground(null);
        this.setLayout(new BorderLayout());

        for (int i = 0; i < MainFrame.getPeuplesArrayList().size(); i++) {
            dataset.addSeries(new XYSeries(MainFrame.getPeuplesArrayList().get(i).getNom()));
            renderer.setSeriesPaint(i, MainFrame.getPeuplesArrayList().get(i).getColor());
            renderer.setSeriesShapesVisible(i, false);
        }

        initDatasets();
        ((XYPlot) popChart.getPlot()).setRenderer(renderer);

        cPanel.setPreferredSize(new Dimension(10, 300));
        popChart.getXYPlot().getRangeAxis().setAutoRange(true);
        this.add(cPanel, BorderLayout.NORTH);
        this.add(bot, BorderLayout.SOUTH);
        this.setOpaque(false);
    }

    /**
     * Effectue le changement de graphiques lors de la s�lection d'un peuple
     */
    public void swapCharts() {
        this.remove(cPanel);
        cPanel = new ChartPanel(chartsList.get(mainPanel.getSelectedIndex() - 1));
        this.add(cPanel);
        this.repaint();
    }

    /**
     * Effectue le changement de graphiques lors de la d�s�lection d'un peuple
     */
    public void goGlobal() {
        this.remove(cPanel);
        cPanel = new ChartPanel(popChart);
        this.add(cPanel);
        this.repaint();
    }

    /**
     * Initialise les datasets
     */
    private void initDatasets() {
        for (int i = 0; i < MainFrame.getPeuplesArrayList().size(); i++) {
            datasetsList.add(new XYSeriesCollection());
            XYSeriesCollection c = datasetsList.get(i);
            c.addSeries(new XYSeries("Agressivit�"));
            c.addSeries(new XYSeries("Attractivit�"));
            c.addSeries(new XYSeries("Bellicisme"));
            c.addSeries(new XYSeries("Densit�"));
            c.addSeries(new XYSeries("Education"));
            c.addSeries(new XYSeries("Immigration"));
            c.addSeries(new XYSeries("Nombre de soldats"));
            c.addSeries(new XYSeries("Population"));
            c.addSeries(new XYSeries("Ressources"));
            c.addSeries(new XYSeries("Richesse"));
            c.addSeries(new XYSeries("Technologie"));
            c.addSeries(new XYSeries("Territoire"));
            chartsList.add(i, ChartFactory.createXYLineChart(MainFrame.getPeuplesArrayList().get(i).getNom(), "Temps", "test", c, PlotOrientation.VERTICAL, true, true, false));
        }
    }

    /**
     * Actualise les donn�es en vue d�taill�e
     */
    public void refreshDetailedSeries() {
        for (int i = 0; i < MainFrame.getPeuplesArrayList().size(); i++) {
            datasetsList.get(i).getSeries(0).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getAgressivite());
            datasetsList.get(i).getSeries(1).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getAttractivite());
            datasetsList.get(i).getSeries(2).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getBellicisme());
            datasetsList.get(i).getSeries(3).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getDensite());
            datasetsList.get(i).getSeries(4).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getEducation());
            datasetsList.get(i).getSeries(5).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getImmigration());
            datasetsList.get(i).getSeries(6).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getNbSoldat());
            datasetsList.get(i).getSeries(7).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getPopulation());
            datasetsList.get(i).getSeries(8).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getRessources());
            datasetsList.get(i).getSeries(9).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getRichesse());
            datasetsList.get(i).getSeries(10).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getTechnologie());
            datasetsList.get(i).getSeries(11).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getTerritoire());
        }
    }

    /**
     * Actualise les donn�es en vue globale
     */
    public void refreshSeries() {
        for (int i = 0; i < MainFrame.getPeuplesArrayList().size(); i++)
            dataset.getSeries(i).add(RunningLoop.nbIteration, MainFrame.getPeuplesArrayList().get(i).getPopulation());
    }

    public RightLogPanel getLogPanel() {
        return bot;
    }
}
