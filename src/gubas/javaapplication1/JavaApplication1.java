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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.DefaultXYDataset;
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
        DefaultXYDataset seria = new DefaultXYDataset();
        seria.addSeries("Seria A", getASeries());
        JFreeChart chart = new JFreeChart(new XYPlot(seria, getXAxis(), getYAxis(), new StandardXYItemRenderer(StandardXYItemRenderer.LINES)));
        ChartPanel p = new ChartPanel(chart);
        f.add(p);
    }
    
    private static ValueAxis getYAxis(){
        return new NumberAxis();
    }
    private static ValueAxis getXAxis(){
        return new NumberAxis();
    }
    private static double[][] getASeries(){
        return new double[][]{
            {1, 2, 3},
            {5, 7, 2}
        };
    }
}
