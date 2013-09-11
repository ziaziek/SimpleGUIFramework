/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Przemo
 */
public class DefaultTableComponentMouseListener implements MouseMotionListener , MouseListener {
    
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
            int rn = tc.table.rowAtPoint(me.getPoint());
            if(rn!=tc.itsRow){
              tc.animateRow(tc.itsRow);  
              tc.itsRow = rn;  
            }
            
        } else {
            tc.itsRow = -1;
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        tc.animateRow(tc.itsRow);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tc.animateRow(-1);
    }
}
