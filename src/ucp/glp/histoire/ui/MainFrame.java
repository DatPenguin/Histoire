package ucp.glp.histoire.ui;

import javax.swing.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 16/01/2017
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        this.setContentPane(new MainPanel());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(650, 400);
        this.setResizable(false);
        this.setTitle("History Simulator 2017");
        this.setLocationRelativeTo(null);
    }
}
