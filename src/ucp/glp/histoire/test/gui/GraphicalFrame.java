package ucp.glp.histoire.test.gui;

import fr.theshark34.swinger.util.WindowMover;

import javax.swing.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 03/02/2017
 */
public class GraphicalFrame extends JFrame {
    public GraphicalFrame() {
        this.setSize(530, 515);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Graphics Test");
        this.setLocationRelativeTo(null);

        this.setContentPane(new GraphicalPanel());

        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);
    }
}
