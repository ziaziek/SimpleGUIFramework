/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.components.interfaces.ShiftValueContaining;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.ValueAxis;

/**
 *
 * @author Przemek
 */
public class DefaultNavigationPanelActionListener implements ActionListener {

    ChartPanel p = null;
    ShiftValueContaining shiftValue = null;


    public void setShiftValue(ShiftValueContaining shiftValue) {
        this.shiftValue = shiftValue;
    }
    
    public DefaultNavigationPanelActionListener(ChartPanel p) {
        this.p=p;
    }
    
    public DefaultNavigationPanelActionListener(ChartPanel p, ShiftValueContaining shV){
        this(p);
        shiftValue=shV;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
           case BaseChartNavigationPanel.ZOOM_IN_COMMAND :
               p.zoomInDomain(p.getX()+ p.getWidth()/2, p.getY()+p.getHeight()/2);
               break;
           case BaseChartNavigationPanel.ZOOM_OUT_COMMAND:
               p.zoomOutDomain(p.getX()+ p.getWidth()/2, p.getY()+p.getHeight()/2);
               break;
           case BaseChartNavigationPanel.MOVE_LEFT_COMMAND:
               shiftDomainAxis(p.getChart().getXYPlot().getDomainAxis(), -1, shiftValue.getShiftValue());
               break;
           case BaseChartNavigationPanel.MOVE_RIGHT_COMMAND:
              shiftDomainAxis(p.getChart().getXYPlot().getDomainAxis(), 1, shiftValue.getShiftValue());
               break;
       }
    }
    
    
    protected double calculateTheShiftValue(ValueAxis vax, int direction, double distance){
        return direction*distance*(int)(vax.getRange().getLength()/10);
    }
    
    
    protected void shiftDomainAxis(ValueAxis vax, int direction, double distance){
        double d = calculateTheShiftValue(vax, direction, distance);
        vax.setRange(vax.getRange().getLowerBound()+ d, vax.getRange().getUpperBound()+d);
        
    }
    
}
