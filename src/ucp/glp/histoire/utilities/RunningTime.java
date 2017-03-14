package ucp.glp.histoire.utilities;

import ucp.glp.histoire.managers.RunningLoop;
import ucp.glp.histoire.ui.MainFrame;
import ucp.glp.histoire.ui.MainPanel;
import ucp.glp.histoire.ui.borderpanels.BottomPanel;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @project GLP Histoire (L2S4 I) - Université de Cergy-Pontoise
 * @date 2016-2017
 */
public class RunningTime implements Runnable {
    private static RunningLoop loop = new RunningLoop(MainFrame.getPeuplesArrayList());

    public static void fastForward() {
        System.out.println("Lancement de la boucle");
        loop.loopAction();
        MainPanel.setRunning(0);
        MainPanel.getEvent().hasLooped();
    }

    @Override
    public void run() {
        while (true) {
            if (MainFrame.isPlaying()) {
                MainPanel.setRunning(MainPanel.getRunning() + 1 * ((float) BottomPanel.getTimeSlider().getValue()) / 1000);
                MainPanel.setTotalYears(MainPanel.getTotalYears() + 1 * ((float) BottomPanel.getTimeSlider().getValue()) / 1000);
                MainPanel.setRunningLabelText(String.valueOf(((int) MainPanel.getRunning())));
                MainPanel.setBarLabelText(String.valueOf(((int) MainPanel.getTotalYears())));

                if (((int) MainPanel.getRunning()) == 10) {
                    System.out.println("Lancement de la boucle");
                    loop.loopAction();
                    MainPanel.setRunning(0);
                    MainPanel.getEvent().hasLooped();
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
