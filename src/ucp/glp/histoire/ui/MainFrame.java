package ucp.glp.histoire.ui;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.util.WindowMover;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 16/01/2017
 */
public class MainFrame extends JFrame {

    public static ArrayList<String> peuplesArrayList = new ArrayList<>();

    public MainFrame() {
        peuplesArrayList.add("Peuple X");
        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);

        Swinger.setResourcePath("/ucp/glp/resources");

        this.setContentPane(new MainPanel());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setResizable(false);
        this.setTitle("History Simulator 2017");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }
}
