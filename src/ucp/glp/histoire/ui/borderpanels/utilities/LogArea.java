package ucp.glp.histoire.ui.borderpanels.utilities;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;

/**
 * Zone de texte affichant les logs en bas � droite de la fen�tre principale.
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Universit� de Cergy-Pontoise
 * @date 2016-2017
 */
public class LogArea extends JTextPane {
    /**
     * Cette m�thode permet d'ins�rer un String mis en forme pour pouvoir colorer les logs
     * @param str
     * @param style
     */
    public void insert(String str, Style style) {
        Document doc = getDocument();
        if (doc != null) {
            try {
                doc.insertString(0, str, style);
            } catch (BadLocationException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}
