package ucp.glp.histoire.ui;

import fr.theshark34.swinger.util.WindowMover;

import javax.swing.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class ChosingFrame extends JFrame {
    private ChosingPanel panel = new ChosingPanel();

    public ChosingFrame() {
        this.setContentPane(panel);
        ChosingPanel.setFrame(this);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();

        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);
    }
}
