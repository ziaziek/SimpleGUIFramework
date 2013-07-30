/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Przemek
 */
public class DefaultShiftNavigationPanelChangeListener implements ChangeListener {
    
    private int shiftValue = 1;

    public int getShiftValue() {
        return shiftValue;
    }

    public DefaultShiftNavigationPanelChangeListener(int shV){
        shiftValue = shV;
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() instanceof JSpinner){
            shiftValue = (int)((JSpinner)e.getSource()).getValue();
        }
    }
    
}
