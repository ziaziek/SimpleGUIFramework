/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Przemo
 */
public class DefaultTableComponentMouseListener implements MouseMotionListener {
    
    protected TableComponent tc;
    
    public DefaultTableComponentMouseListener(TableComponent tComp){
        tc = tComp;
    }
    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Point p = me.getPoint();
        if (tc.table.contains(p)) {
            tc.itsRow = tc.table.rowAtPoint(me.getPoint());
        } else {
            tc.itsRow = -1;
        }
        tc.table.repaint();
    }
}
