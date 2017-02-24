package ucp.glp.histoire;

import ucp.glp.histoire.ui.ChosingFrame;
import ucp.glp.histoire.ui.MainFrame;

public class Histoire {

    public static void main(String[] args) {
        ChosingFrame a = new ChosingFrame();
        a.frame = new MainFrame(false);
    }
}
