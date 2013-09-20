/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.components.interfaces.ShiftValueContaining;
import java.awt.BorderLayout;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.Plot;

/**
 *
 * @author Przemysław
 */
public class GubasChart extends JPanel implements ShiftValueContaining{
    
    
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
            this.add(NavigationPanelFactory.createShiftModifiedNaviPanel("Navigation", "Shift value", 1, 0, 100, new DefaultNavigationPanelActionListener(this.getChart(), this),
                    new DefaultShiftNavigationPanelChangeListener(this)),
                    BorderLayout.SOUTH);   
        }
        
    }

    @Override
    public int getShiftValue() {
        return shiftValue;
    }

    @Override
    public void setShiftValue(int sh) {
        shiftValue = sh;
    }
}
