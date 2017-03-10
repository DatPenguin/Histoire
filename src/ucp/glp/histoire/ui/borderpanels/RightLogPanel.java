package ucp.glp.histoire.ui.borderpanels;

import ucp.glp.histoire.ui.MainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 24/01/2017
 */
public class RightLogPanel extends JPanel {

    private JTextArea logArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(logArea);

    public RightLogPanel() {
        this.setLayout(new BorderLayout());
        logArea.setEditable(false);
        logArea.setRows(10);
        logArea.append("\t--- ANNEE 1492 ---\n\n");
        for (int i = 0; i < 42; i++)
            logArea.append(MainFrame.getCurrentEvent() + "\n");
        this.add(scrollPane);
    }
}
