package ucp.glp.histoire.test;

import ucp.glp.histoire.ui.ChosingFrame;
import ucp.glp.histoire.ui.MainFrame;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 03/02/2017
 */
public class GraphicalTest {
    public static void main(String[] args) {
        ChosingFrame a = new ChosingFrame();
        a.frame = new MainFrame(false);
    }
}
