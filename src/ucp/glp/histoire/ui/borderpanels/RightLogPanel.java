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
        this.add(scrollPane);
    }

    public void appendText(ArrayList<String> sList) {
        for (String s : sList)
            logArea.insert(s + '\n', 0);
        if (RunningLoop.nbIteration == 1)
            logArea.insert("\t--- ANNÉE 0 ---\n\n", 0);
        else
            logArea.insert("\t--- ANNÉE " + (RunningLoop.nbIteration - 1) + "0 ---\n\n", 0);
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMinimum());
    }
}
