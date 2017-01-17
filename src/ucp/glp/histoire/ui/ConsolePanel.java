package ucp.glp.histoire.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 16/01/2017
 */
public class ConsolePanel extends JPanel {
    private JTextArea cArea = new JTextArea();
    public ConsolePanel() {
        this.setLayout(null);
        cArea.setBackground(Color.black);
        cArea.setForeground(new Color(44, 114, 36));
        cArea.setText("J'aime le chocolat\nEt les kebabs");
        cArea.setBounds(2,5,590,365);
        cArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && cArea.hasFocus()) {
                    System.out.println("ENTER !");
                }
            }
        });
        this.add(cArea);
    }
}
