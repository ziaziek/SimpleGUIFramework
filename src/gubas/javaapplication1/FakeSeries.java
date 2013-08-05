/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.javaapplication1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.ComparableObjectItem;
import org.jfree.data.time.Day;
import org.jfree.data.time.ohlc.OHLCItem;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.OHLCDataItem;

/**
 *
 * @author Przemek
 */
public class FakeSeries {
    
    public static double[][] getASeries(){
        return new double[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {5, 7, 2, 5, 3, 7.5, 8, 4,1}
        };
    }
    
    public static OHLCSeriesCollection getOHLCSeriesCollection(){
        OHLCSeriesCollection sercol = new OHLCSeriesCollection();
        try {
            sercol.addSeries(getSeries());
        } catch (ParseException ex) {
            Logger.getLogger(FakeSeries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sercol;
    }
    
    protected static OHLCSeries getSeries() throws ParseException{
        OHLCSeries seria = new OHLCSeries("Seria czasowa");
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        seria.add(new Day(df.parse("2001-05-02")), 4.89, 4.99, 4.88, 4.89);
        seria.add(new Day(df.parse("2001-05-03")), 4.90, 5.50, 4.80, 4.92);
        seria.add(new Day(df.parse("2001-05-04")), 5.01, 5.55, 4.80, 4.99);
        seria.add(new Day(df.parse("2001-05-05")), 5.25, 5.60, 5.01, 5.55);
        return seria;
    }
    
    protected static double[][] getLineOHLCSeries(){
        try {
            OHLCSeries s = getSeries();
            double[][] ret = new double[2][s.getItemCount()];
            for(int i=0; i<s.getItemCount(); i++){
                OHLCItem item = (OHLCItem)s.getDataItem(i);
                ret[0][i]=s.getPeriod(i).getMiddleMillisecond();
                ret[1][i]=0.5*(item.getCloseValue()+item.getOpenValue());
            }
            return ret;
        } catch (ParseException ex) {
            Logger.getLogger(FakeSeries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
