package ucp.glp.histoire.ui.borderpanels.utilities;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class LogArea extends JTextPane {
    public void insert(String str, int pos, Style style) {
        Document doc = getDocument();
        if (doc != null) {
            try {
                doc.insertString(pos, str, style);
            } catch (BadLocationException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}
