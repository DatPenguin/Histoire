package ucp.glp.histoire.ui.borderpanels;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;
import ucp.glp.histoire.ui.MainFrame;
import ucp.glp.histoire.ui.MainPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 24/01/2017
 */
public class BottomPanel extends JPanel implements SwingerEventListener, ChangeListener {

    private static JSlider timeSlider = new JSlider();
    private static MainPanel mainPanel;
    private STexturedButton playPauseButton = new STexturedButton(Swinger.getResource("playPauseButton.png"));
    private STexturedButton fastForwardButton = new STexturedButton(Swinger.getResource("fastForwardButton.png"));

    public BottomPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(null);
        this.setOpaque(false);

        playPauseButton.setPreferredSize(new Dimension(300, 50));
        fastForwardButton.setPreferredSize(new Dimension(300, 50));

        playPauseButton.addEventListener(this);
        fastForwardButton.addEventListener(this);

        timeSlider.setOpaque(false);
        timeSlider.addChangeListener(this);
        timeSlider.setMaximum(1000);
        timeSlider.setValue(0);

        this.add(fastForwardButton, BorderLayout.EAST);
        this.add(playPauseButton, BorderLayout.WEST);
        this.add(timeSlider, BorderLayout.CENTER);
    }

    public static JSlider getTimeSlider() {
        return timeSlider;
    }

    public static void setTimeSlider(JSlider timeSlider) {
        BottomPanel.timeSlider = timeSlider;
    }

    public static MainPanel getMainPanel() {
        return mainPanel;
    }

    public static void setMainPanel(MainPanel mainPanel) {
        BottomPanel.mainPanel = mainPanel;
    }

    @Override
    public void onEvent(SwingerEvent e) {
        if (e.getSource() == playPauseButton) {
            MainFrame.togglePlay();
            if (MainFrame.isPlaying())
                System.out.println("Play");
            else
                System.out.println("Pause");
        } else if (e.getSource() == fastForwardButton) {
            System.out.println("Fast Forward");
        }
    }

    /**
     * Invoked when the target of the listener has changed its state.
     *
     * @param e a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
    }
}
