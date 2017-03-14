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
        /*for (int i = 0; i < 42; i++)
            logArea.append(MainFrame.getCurrentEvent() + "\n");*/
        this.add(scrollPane);
    }

    public void appendText(ArrayList<String> sList) {
        logArea.append("\t--- ANNEE " + RunningLoop.nbIteration + " ---\n\n");
        for (String s : sList)
            logArea.append(s + '\n');
    }
}
