/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Przemysław
 */
public class NavigationPanelFactory {
    
    public static BaseChartNavigationPanel createBaseNaviPanel(String naviLabel, ActionListener buttonsListener){
        BaseChartNavigationPanel retPanel = new BaseChartNavigationPanel(naviLabel);
        retPanel.setButtonsListener(buttonsListener);
        retPanel.createNaviButtons();
        return retPanel;
    }
    
    public static ShiftModifiedNavigationPanel createShiftModifiedNaviPanel(String naviLabel, String shiftBoxText, int initialValue,
            int minVal, int maxVal, ActionListener buttonsListener, ChangeListener shiftBoxChangeListener){
        ShiftModifiedNavigationPanel retPanel = new ShiftModifiedNavigationPanel(naviLabel, shiftBoxText, initialValue, minVal, maxVal, shiftBoxChangeListener);
        retPanel.setButtonsListener(buttonsListener);
        try {
            retPanel.buildPanel();
        } catch (Exception ex) {
            Logger.getLogger(NavigationPanelFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retPanel;
    }
}
