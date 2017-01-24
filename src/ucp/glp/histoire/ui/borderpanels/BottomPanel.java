package ucp.glp.histoire.ui.borderpanels;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;
import ucp.glp.histoire.ui.MainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 24/01/2017
 */
public class BottomPanel extends JPanel implements SwingerEventListener {
    ;

    private STexturedButton leftButton = new STexturedButton(Swinger.getResource("leftButton.png"));
    private STexturedButton rightButton = new STexturedButton(Swinger.getResource("rightButton.png"));

    public BottomPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(null);

        leftButton.setPreferredSize(new Dimension(300, 50));
        rightButton.setPreferredSize(new Dimension(300, 50));

        leftButton.addEventListener(this);
        rightButton.addEventListener(this);

        this.add(rightButton, BorderLayout.EAST);
        this.add(leftButton, BorderLayout.WEST);
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
}
