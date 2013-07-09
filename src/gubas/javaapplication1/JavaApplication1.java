/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.javaapplication1;

import gubas.components.TableComponent;
import gubas.forms.*;
import gubas.icons.Icons;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Przemysław
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataForm f = new DataForm();
//        TableComponent tc = new TableComponent(new Object[][]{{0,0,0}, {0,0,0}}, new String[]{"A","B", "C"});
//        tc.setOpaque(false);
//        f.add(tc);
        showChart(f);
        FormsCaller.callNewWindow("Table window", f);
    }
    
    public static void showChart(BaseForm f){
        JFreeChart chart = new JFreeChart(new XYPlot(new Seria(), null, null, null));
        ChartPanel p = new ChartPanel(chart);
        f.add(p);
    }
    
    public class Seria implements XYDataset {

        int[] x = new int[] {1, 2, 3, 4, 5};
        int[] y = new int[]{3, 7, 3, 2, 8};
        @Override
        public DomainOrder getDomainOrder() {
            return DomainOrder.ASCENDING;
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getItemCount(int i) {
            return x.length;
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Number getX(int i, int i1) {
            if(i==0 && i1<x.length){
                return x[i1];
            }
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public double getXValue(int i, int i1) {
            return (double) getX(i, i1);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Number getY(int i, int i1) {
            if(i==0 && i1<y.length){
                return y[i1];
            }
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public double getYValue(int i, int i1) {
            return (double) getY(i, i1);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getSeriesCount() {
            return 1;
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comparable getSeriesKey(int i) {
            return 0;
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int indexOf(Comparable cmprbl) {
            return 0;
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addChangeListener(DatasetChangeListener dl) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void removeChangeListener(DatasetChangeListener dl) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public DatasetGroup getGroup() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setGroup(DatasetGroup dg) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
