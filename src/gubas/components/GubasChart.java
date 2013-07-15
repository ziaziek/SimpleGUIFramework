/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;

/**
 *
 * @author Przemysław
 */
public class GubasChart extends JPanel{
    
    
    Plot myPlot = null;
    ChartPanel chart = null;

    public ChartPanel getChart() {
        return chart;
    }
    
    public GubasChart(ChartPanel chart){
        this.chart = chart;
        this.setLayout(new BorderLayout());
        this.add(chart, BorderLayout.CENTER);
        this.add(getNavigation(), BorderLayout.SOUTH);
    }
 
    
    protected JPanel getNavigation(){
        JPanel naviPan = new JPanel(new BorderLayout());
        JLabel naviTxt = new JLabel("Navigation");     
        JPanel labPanel = new JPanel(new BorderLayout());
        naviPan.add(labPanel, BorderLayout.NORTH);
        JPanel labLeftPanel = new JPanel();
        
        
        naviPan.add(labPanel, BorderLayout.NORTH);
        naviPan.setPreferredSize(new Dimension(50, 50));
        labLeftPanel.setPreferredSize(new Dimension(250, 1));
        labPanel.add(labLeftPanel, BorderLayout.WEST);
        labPanel.add(naviTxt, BorderLayout.CENTER);
        return naviPan;
    }


}
