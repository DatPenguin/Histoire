package ucp.glp.histoire.utilitaires;

import ucp.glp.histoire.ui.MainFrame;
import ucp.glp.histoire.ui.MainPanel;
import ucp.glp.histoire.ui.borderpanels.BottomPanel;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 27/01/2017
 */
public class RunningTime implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            if (MainFrame.isPlaying()) {
                MainPanel.running += 1 * ((float) BottomPanel.timeSlider.getValue()) / 1000;
                MainPanel.setRunningLabelText(String.valueOf(((int) MainPanel.running)));

                if (((int) MainPanel.running) % 10 == 0) {
                    System.out.println("Lancement de la boucle");
                    MainPanel.running = 1;
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
