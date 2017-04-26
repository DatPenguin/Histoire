package ucp.glp.histoire.ui;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.util.WindowMover;
import ucp.glp.histoire.event.global.GlobalHistoricEvent;
import ucp.glp.histoire.event.global.GlobalWarming;
import ucp.glp.histoire.event.global.Seisme;
import ucp.glp.histoire.utilities.Peuple;
import ucp.glp.histoire.utilities.RunningTime;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class MainFrame extends JFrame {

    public static final HashMap<String, GlobalHistoricEvent> eventHashMap = new HashMap<String, GlobalHistoricEvent>();
    public static String THEME = "standard";
    private static ArrayList<Peuple> peuplesArrayList = new ArrayList<Peuple>();
    private static ArrayList<String> eventArrayList = new ArrayList<String>();
    private static ArrayList<String> logArrayList = new ArrayList<String>();
    private static boolean playing = false;

    public MainFrame() {
        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        Swinger.setResourcePath("/ucp/glp/histoire/resources/" + THEME);

        this.setContentPane(new MainPanel());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setResizable(false);
        this.setTitle("History Simulator 2017");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setIconImage(Swinger.getResource("Icone.png"));

        new RunningTime().run();
        initEventList();
    }

    public MainFrame(ArrayList<Peuple> peupleList, String theme) {
        THEME = theme;
        peuplesArrayList = peupleList;
        initEventList();
        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        Swinger.setResourcePath("/ucp/glp/histoire/resources/" + THEME);

        this.setContentPane(new MainPanel());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setResizable(false);
        this.setTitle("History Simulator 2017");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.setIconImage(Swinger.getResource("Icone.png"));

        new RunningTime().run();
    }

    public static int getPeuplesNumber() {
        return peuplesArrayList.size();
    }

    public static void togglePlay() {
        playing = !playing;
    }

    public static boolean isPlaying() {
        return playing;
    }

    public static ArrayList<Peuple> getPeuplesArrayList() {
        return peuplesArrayList;
    }

    public static ArrayList<String> getEventArrayList() {
        return eventArrayList;
    }

    public static ArrayList<String> getLogArrayList() {
        return logArrayList;
    }

    private void initEventList() {
        eventArrayList.add("Séisme");
        eventArrayList.add("Réchauffement Climatique");
        eventHashMap.put("Séisme", new Seisme());
        eventHashMap.put("Réchauffement Climatique", new GlobalWarming());
    }
}
