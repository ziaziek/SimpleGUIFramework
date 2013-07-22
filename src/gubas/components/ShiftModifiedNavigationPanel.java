/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Przemek
 */
public class ShiftModifiedNavigationPanel extends BaseChartNavigationPanel {

    JPanel shiftPanel;
    ChangeListener shiftListener;
    
    public ShiftModifiedNavigationPanel(String naviLabel) {
        super(naviLabel);
        panelComponents = new JComponent[]{moveLeft, zoomIn, shiftPanel, zoomOut, moveRight};
    }
    
    public void createShiftTextBox(String text, int initialValue, int minVal, int maxVal, ChangeListener chl){
        shiftListener=chl;
        shiftPanel = new JPanel();
        JLabel l = new JLabel(text);
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(initialValue, minVal, maxVal, 1));
        spinner.addChangeListener(chl);
        shiftPanel.add(l);
        shiftPanel.add(spinner);
        shiftPanel.setBackground(Color.white); //this might be set by some renderer
        spinner.getEditor().setPreferredSize(new Dimension(20,30));
    }
}
