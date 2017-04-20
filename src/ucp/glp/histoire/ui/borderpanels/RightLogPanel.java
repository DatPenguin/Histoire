package ucp.glp.histoire.ui.borderpanels;

import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.ui.borderpanels.utilities.LogArea;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class RightLogPanel extends JPanel {

    private LogArea logArea = new LogArea();
    private JScrollPane scrollPane = new JScrollPane(logArea);

    public RightLogPanel() {
        this.setLayout(new BorderLayout());
        logArea.setEditable(false);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        this.add(scrollPane);
    }

    public void appendText(ArrayList<String> sList) {
        StyledDocument doc = logArea.getStyledDocument();

        Style war = logArea.addStyle("war", null);
        StyleConstants.setForeground(war, GraphicalPanel.WAR_COLOR);

        Style trade = logArea.addStyle("trade", null);
        StyleConstants.setForeground(trade, GraphicalPanel.TRADE_COLOR);

        Style event = logArea.addStyle("event", null);
        StyleConstants.setForeground(event, new Color(44, 114, 36));
        logArea.setMargin(new Insets(5, 10, 5, 10));

        for (String s : sList) {
            if (s.contains("guerre"))
                logArea.insert(s + '\n', 0, war);
            else if (s.toLowerCase().contains("commerce"))
                logArea.insert(s + '\n', 0, trade);
            else
                logArea.insert(s + '\n', 0, event);
        }
        if (RunningLoop.nbIteration == 1)
            logArea.insert("\t--- ANNÉE 0 ---\n\n", 0, null);
        else
            logArea.insert("\t--- ANNÉE " + (RunningLoop.nbIteration - 1) + "0 ---\n\n", 0, null);
        logArea.setCaretPosition(0);
    }
}
