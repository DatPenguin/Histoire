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

    public static String THEME = "standard";
    public static HashMap<String, GlobalHistoricEvent> eventHashMap = new HashMap<String, GlobalHistoricEvent>();
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

    public static String getCurrentEvent() {
        return "X a déclaré la guerre à Y !";
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

    public static void setPeuplesArrayList(ArrayList<Peuple> peuplesArrayList) {
        MainFrame.peuplesArrayList = peuplesArrayList;
    }

    public static ArrayList<String> getEventArrayList() {
        return eventArrayList;
    }

    public static void setEventArrayList(ArrayList<String> eventArrayList) {
        MainFrame.eventArrayList = eventArrayList;
    }

    public static ArrayList<String> getLogArrayList() {
        return logArrayList;
    }

    public static void setLogArrayList(ArrayList<String> logArrayList) {
        MainFrame.logArrayList = logArrayList;
    }

    private void initEventList() {
        eventArrayList.add("Séisme");
        eventArrayList.add("Réchauffement Climatique");

        eventHashMap.put("Séisme", new Seisme());
        eventHashMap.put("Réchauffement Climatique", new GlobalWarming());
    }
}
