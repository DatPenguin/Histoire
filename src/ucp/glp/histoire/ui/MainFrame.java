package ucp.glp.histoire.ui;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.util.WindowMover;
import ucp.glp.histoire.utilitaires.Peuple;
import ucp.glp.histoire.utilitaires.RunningTime;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 16/01/2017
 */
public class MainFrame extends JFrame {

    public static ArrayList<Peuple> peuplesArrayList = new ArrayList<Peuple>();    // Ajout du cast string a l'ArrayList sinon erreur sur la compilation
    public static ArrayList<String> eventArrayList = new ArrayList<String>();
    public static ArrayList<String> logArrayList = new ArrayList<String>();

    private static boolean playing = true;

    public MainFrame() {
        eventArrayList.add("Ouragan");
        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        Swinger.setResourcePath("/ucp/glp/histoire/resources");

        this.setContentPane(new MainPanel());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setResizable(false);
        this.setTitle("History Simulator 2017");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        new RunningTime().run();
    }

    public MainFrame(ArrayList<Peuple> peupleList) {
        peuplesArrayList = peupleList;
        eventArrayList.add("Ouragan");
        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        Swinger.setResourcePath("/ucp/glp/histoire/resources");

        this.setContentPane(new MainPanel());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setResizable(false);
        this.setTitle("History Simulator 2017");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

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
}
