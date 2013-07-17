/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.icons.Icons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
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
        JButton moveLeft, moveRight, zoomIn, zoomOut;
        
        moveLeft = createNaviButton(Icons.MoveLeftIcon, "Left");
        moveRight = createNaviButton(Icons.MoveRightIcon, "Right");
        zoomIn = createNaviButton(Icons.PlusIcon32, "Zoom In");
        zoomOut = createNaviButton(Icons.MinusIcon32, "Zoom Out");
        moveLeft.setPreferredSize(new Dimension(40,40));
        moveRight.setPreferredSize(new Dimension(40,40));
        zoomIn.setPreferredSize(new Dimension(40,40));
        zoomOut.setPreferredSize(new Dimension(40,40));
        JButton[] buttons = new JButton[]{moveLeft, zoomIn, zoomOut, moveRight};
        //add the buttons to the panel
        for(int i=0; i<buttons.length; i++){
            buttonsPanel.add(buttons[i]);
        }
        buttonsPanel.setPreferredSize(new Dimension(50, 60));
        buttonsPanel.setBackground(Color.WHITE);
        naviPan.add(labPanel, BorderLayout.NORTH);
        naviPan.add(buttonsPanel, BorderLayout.CENTER);
        naviPan.setPreferredSize(new Dimension(50, 70));
        return naviPan;
    }


    private JButton createNaviButton(String icon, String alternativeString){
        JButton b ;
        try {
            b = new JButton(Icons.getIcon(icon));
        } catch(IOException ex){
            Logger.getLogger(GubasChart.class.getName()).log(Level.SEVERE, null, ex);
            b = new JButton(alternativeString);
        }
        return b;
    }
}
