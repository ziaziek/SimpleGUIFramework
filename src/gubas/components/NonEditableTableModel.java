/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Przemo
 */
public class NonEditableTableModel extends DefaultTableModel {
    
    public NonEditableTableModel(Object[][] data, Object[] colNames){
        super(data, colNames);
    }
    
//    @Override
//    public void setValueAt(Object o, int row, int col) {
//        if (o == null) {
//            o = 0;
//        }
//    }

    @Override
    public Object getValueAt(int x, int y) {
        Object o = super.getValueAt(x, y);
        if (o == null) {
            return " ";
        } else {
            return o;
        }
    }
         @Override
         public  boolean isCellEditable(int row, int col){
             return false;
         }
}
