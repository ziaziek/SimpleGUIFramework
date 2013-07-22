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


    
    public static final String ZOOM_IN_COMMAND = "zoomin";
    public static final String ZOOM_OUT_COMMAND = "zoomout";
    public static final String MOVE_LEFT_COMMAND = "moveLeft";
    public static final String MOVE_RIGHT_COMMAND = "moveRight";
    
    public ChartPanel getChart() {
        return chart;
    }
    
    public GubasChart(ChartPanel chart){
        this.chart = chart;
        this.setLayout(new BorderLayout());
        this.add(chart, BorderLayout.CENTER);
        //This should be done only for charts that display in XY form
        if(chart.getChart().getXYPlot()!=null){
            this.add(getNavigation(), BorderLayout.SOUTH);
        }
        
    }
 
    protected double calculateRangeChanges(Range r, double coeff){
        return  coeff*(r.getUpperBound()-r.getLowerBound());
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
        zoomIn.setActionCommand(ZOOM_IN_COMMAND);
        zoomOut.setPreferredSize(new Dimension(40,40));
        zoomOut.setActionCommand(ZOOM_OUT_COMMAND);
        moveLeft.setActionCommand(MOVE_LEFT_COMMAND);
        moveRight.setActionCommand(MOVE_RIGHT_COMMAND);
        JComponent[] components = new JComponent[]{moveLeft, zoomIn, createShiftTextBox(shiftValue, 0, (int)chart.getChart().getXYPlot().getDomainAxis().getRange().getLength()), zoomOut, moveRight};
        //add the buttons to the panel
        for(int i=0; i<components.length; i++){
            buttonsPanel.add(components[i]);
            if(components[i] instanceof AbstractButton)
            ((AbstractButton)components[i]).addActionListener(this);
        }
        buttonsPanel.setPreferredSize(new Dimension(50, 60));
        buttonsPanel.setBackground(Color.WHITE);
        naviPan.add(labPanel, BorderLayout.NORTH);
        naviPan.add(buttonsPanel, BorderLayout.CENTER);
        naviPan.setPreferredSize(new Dimension(50, 70));
        return naviPan;
    }


    private JPanel createShiftTextBox(int initialValue, int minVal, int maxVal){
        JPanel retPanel = new JPanel();
        JLabel l = new JLabel("Shift value:");
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(initialValue, minVal, maxVal, 1));
        spinner.addChangeListener(this);
        retPanel.add(l);
        retPanel.add(spinner);
        retPanel.setBackground(Color.white); //this might be set by some renderer
        spinner.getEditor().setPreferredSize(new Dimension(20,30));
        return retPanel;
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
    
    protected void shiftDomainAxis(ValueAxis vax, int direction, double distance){
        double d = direction*distance;
        vax.setRange(vax.getRange().getLowerBound()+ d, vax.getRange().getUpperBound()+d);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ChartPanel p = this.chart;
       switch(e.getActionCommand()){
           case ZOOM_IN_COMMAND :
               p.zoomInDomain(p.getX()+ p.getWidth()/2, p.getY()+p.getHeight()/2);
               break;
           case ZOOM_OUT_COMMAND:
               p.zoomOutDomain(p.getX()+ p.getWidth()/2, p.getY()+p.getHeight()/2);
               break;
           case MOVE_LEFT_COMMAND:
               shiftDomainAxis(p.getChart().getXYPlot().getDomainAxis(), -1, shiftValue);
               break;
           case MOVE_RIGHT_COMMAND:
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
