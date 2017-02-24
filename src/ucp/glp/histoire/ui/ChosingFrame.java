package ucp.glp.histoire.ui;

import fr.theshark34.swinger.util.WindowMover;

import javax.swing.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 24/02/2017
 */
public class ChosingFrame extends JFrame {
    public MainFrame frame;
    private ChosingPanel panel = new ChosingPanel();

    public ChosingFrame() {
        this.setContentPane(panel);
        ChosingPanel.frame = this;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();

        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        }));
    }
}
