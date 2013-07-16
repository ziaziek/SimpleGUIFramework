/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.icons.Icons;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
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
        JPanel labPanel = new JPanel();
        naviPan.add(labPanel, BorderLayout.NORTH);
        labPanel.add(naviTxt);
  
        JPanel buttonsPanel = new JPanel();
        JButton moveLeft, moveRight;
        try {
             moveLeft= new JButton(Icons.getIcon(Icons.MoveLeftButton));
             moveRight = new JButton(Icons.getIcon(Icons.MoveRightButton));
        } catch (IOException ex) {
            Logger.getLogger(GubasChart.class.getName()).log(Level.SEVERE, null, ex);
            moveLeft = new JButton("Left");
            moveRight = new JButton("Right");
        }
        moveLeft.setPreferredSize(new Dimension(40,40));
        moveRight.setPreferredSize(new Dimension(40,40));
        buttonsPanel.add(moveLeft);
        buttonsPanel.add(moveRight);
        
        naviPan.add(labPanel, BorderLayout.NORTH);
        naviPan.add(buttonsPanel, BorderLayout.CENTER);
        naviPan.setPreferredSize(new Dimension(50, 70));
        return naviPan;
    }


}
