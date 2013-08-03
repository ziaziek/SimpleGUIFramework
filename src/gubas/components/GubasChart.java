/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.components.interfaces.ShiftValueContaining;
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
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.data.Range;
import org.jfree.data.time.DateRange;

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
