package ucp.glp.histoire.ui.borderpanels;

import ucp.glp.histoire.managers.RunningLoop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class RightLogPanel extends JPanel {

    private JTextArea logArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(logArea);

    public RightLogPanel() {
        this.setLayout(new BorderLayout());
        logArea.setEditable(false);
        logArea.setRows(10);
        logArea.setLineWrap(true);
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        this.add(scrollPane);
    }

    public void appendText(ArrayList<String> sList) {
        logArea.append("\n\t--- ANNEE " + RunningLoop.nbIteration + " ---\n\n");
        for (String s : sList)
            logArea.append(s + '\n');
    }
}
