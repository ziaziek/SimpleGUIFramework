/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.data.Range;
import org.jfree.data.time.DateRange;

/**
 *
 * @author Przemek
 */
public class DefaultNavigationPanelActionListener implements ActionListener {

    ChartPanel p = null;
    int shiftValue = 1;
    
    public DefaultNavigationPanelActionListener(ChartPanel p) {
        this.p=p;
    }
    
    public DefaultNavigationPanelActionListener(ChartPanel p, int shV){
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
               shiftDomainAxis(p.getChart().getXYPlot().getDomainAxis(), -1, shiftValue);
               break;
           case BaseChartNavigationPanel.MOVE_RIGHT_COMMAND:
              shiftDomainAxis(p.getChart().getXYPlot().getDomainAxis(), 1, shiftValue);
               break;
       }
    }
    
    protected void shiftDomainAxis(ValueAxis vax, int direction, double distance){
        double d = direction*distance;
        Range r = vax.getRange();
        if (r instanceof DateRange){
            //NIE !!! - stworz rozne obiekty ActionListener'ów i pozwól faktorii lub programiście wybrać ten, który powinien być w danym miejscu zastosowany
        }
        double l = r.getLength();
        int p = vax.getStandardTickUnits().getCeilingTickUnit(1).getMinorTickCount();
        
        vax.setRange(vax.getRange().getLowerBound()+ d, vax.getRange().getUpperBound()+d);
        
    }
    
}
