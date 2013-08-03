/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.components.interfaces.ShiftValueContaining;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Przemek
 */
public class DefaultShiftNavigationPanelChangeListener implements ChangeListener {
    
    private ShiftValueContaining shiftContainer = null;

    public DefaultShiftNavigationPanelChangeListener(ShiftValueContaining shV){
        shiftContainer = shV;
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() instanceof JSpinner){
            shiftContainer.setShiftValue((int)((JSpinner)e.getSource()).getValue());
        }
    }
    
}
