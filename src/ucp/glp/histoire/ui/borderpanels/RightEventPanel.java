package ucp.glp.histoire.ui.borderpanels;

import fr.theshark34.swinger.Swinger;
import ucp.glp.histoire.ui.MainFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author Matteo STAIANO, Mathieu HANNOUN
 * @date 24/01/2017
 */
public class RightEventPanel extends JPanel {

    JLabel eventImage = new JLabel();
    JLabel eventDesc = new JLabel();

    public RightEventPanel() {
        this.setLayout(new BorderLayout());
        eventImage.setIcon(new ImageIcon(Swinger.getResource("eventimage.png")));
        eventImage.setBorder(LineBorder.createBlackLineBorder());
        this.add(eventImage, BorderLayout.NORTH);

        eventDesc.setText(MainFrame.getCurrentEvent());
        eventDesc.setHorizontalAlignment(SwingConstants.CENTER);
        eventDesc.setFont(eventDesc.getFont().deriveFont(20f));
        this.add(eventDesc, BorderLayout.SOUTH);
    }
}
