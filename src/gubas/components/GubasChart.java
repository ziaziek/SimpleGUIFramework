/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.icons.Icons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.data.Range;

/**
 *
 * @author Przemysław
 */
public class GubasChart extends JPanel implements ActionListener, ChangeListener{
    
    
    Plot myPlot = null;
    ChartPanel chart = null;
    int shiftValue = 1; //this value will be editable for the users ina textfield in the UI.
    
    public ChartPanel getChart() {
        return chart;
    }
    
    public GubasChart(ChartPanel chart){
        this.chart = chart;
        this.setLayout(new BorderLayout());
        this.add(chart, BorderLayout.CENTER);
        //This should be done only for charts that display in XY form
        if(chart.getChart().getXYPlot()!=null){
            ShiftModifiedNavigationPanel navi = new ShiftModifiedNavigationPanel("Navigation", "Shift value:",1, 0, 100, this);
            navi.setButtonsListener(this);
            try {
                navi.buildPanel();
                this.add(navi, BorderLayout.SOUTH);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(GubasChart.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    

    protected void shiftDomainAxis(ValueAxis vax, int direction, double distance){
        double d = direction*distance;
        vax.setRange(vax.getRange().getLowerBound()+ d, vax.getRange().getUpperBound()+d);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ChartPanel p = this.chart;
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

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() instanceof JSpinner){
            shiftValue = (int)((JSpinner)e.getSource()).getValue();
        }
    }
}
