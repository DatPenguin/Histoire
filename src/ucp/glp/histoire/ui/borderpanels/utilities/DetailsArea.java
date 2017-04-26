package ucp.glp.histoire.ui.borderpanels.utilities;

import javax.swing.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class DetailsArea extends JTextPane {
    public void appendln(String s) {
        this.setText(this.getText() + s + '\n');
    }
}
