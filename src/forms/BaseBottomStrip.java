/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import icons.Icons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Przemysław
 */
public class BaseBottomStrip extends JPanel implements MouseMotionListener {
    
    private final int iconPadding = 5;
    private JLabel helpIconButton;
    public BaseBottomStrip(){
        float[] bgColor = new float[3];
        
        Color.RGBtoHSB(116, 161, 207, bgColor);
        setBackground(Color.getHSBColor(bgColor[0], bgColor[1], bgColor[2]));
        setLayout(new BorderLayout());
        ImageIcon helpIcon = Icons.getIcon(Icons.HelpIcon32);
        setPreferredSize(new Dimension(50, helpIcon.getIconHeight() + iconPadding));
        helpIconButton = new JLabel(helpIcon);
        helpIconButton.addMouseMotionListener(this);
        setBorder(BorderFactory.createLoweredBevelBorder());
        this.add(helpIconButton, BorderLayout.EAST);
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        helpIconButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
