/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.forms.Dialog;
import gubas.forms.DialogForm;
import gubas.javaapplication1.FormsCaller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;

/**
 *
 * @author Przemysław
 */
public class GubasChart extends ChartPanel{
    
    
    Plot myPlot = null;
    
    public GubasChart(JFreeChart chart){
        super(chart);
        addMouseListener(this);
    }
 
    @Override
    public void mouseClicked(MouseEvent me){
        super.mouseClicked(me);
        FormsCaller.callNewWindow(" Position", new DialogForm(Dialog.OK, "Clicked on "+me.getX()+", "+me.getY()));
    }
}
