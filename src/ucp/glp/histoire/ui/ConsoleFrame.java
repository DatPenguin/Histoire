package ucp.glp.histoire.ui;

import javax.swing.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 16/01/2017
 */
public class ConsoleFrame extends JFrame {
    public ConsoleFrame() {
        this.setContentPane(new ConsolePanel());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(650, 400);
        this.setResizable(false);
        this.setTitle("OSsobuco");
        this.setLocationRelativeTo(null);
    }
}
