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

    private STexturedButton leftButton = new STexturedButton(Swinger.getResource("leftButton.png"));
    private STexturedButton rightButton = new STexturedButton(Swinger.getResource("rightButton.png"));
    private JSlider timeSlider = new JSlider();

    public BottomPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(null);

        leftButton.setPreferredSize(new Dimension(300, 50));
        rightButton.setPreferredSize(new Dimension(300, 50));

        leftButton.addEventListener(this);
        rightButton.addEventListener(this);

        timeSlider.setBackground(null);
        timeSlider.addChangeListener(this);

        this.add(rightButton, BorderLayout.EAST);
        this.add(leftButton, BorderLayout.WEST);
        this.add(timeSlider, BorderLayout.CENTER);
    }

    @Override
    public void onEvent(SwingerEvent e) {
        if (e.getSource() == leftButton) {
            MainFrame.togglePlay();
            if (MainFrame.isPlaying())
                System.out.println("Play");
            else
                System.out.println("Pause");
        } else if (e.getSource() == rightButton)
            System.out.println("Fast Forward");
    }

    /**
     * Invoked when the target of the listener has changed its state.
     *
     * @param e a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == timeSlider)
            MainPanel.setBarLabelText(Integer.toString(this.timeSlider.getValue()));
    }
}
