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
    
    private TableModel modelT=null;

    public TableModel getModelT() {
        return modelT;
    }

    public void setModelT(TableModel modelT) {
        this.modelT = modelT;
    }

        
    public boolean isWrappedModelSet(){
        return modelT!=null;
    }
    
        public NonEditableTableModel(TableModel model){
            modelT = model; 
        }
        
        public NonEditableTableModel(){
            
        }
        
        @Override
        public void setValueAt(Object o, int row, int col){
            if(modelT!=null){
                modelT.setValueAt(o, row, col);
            } else {
                setValueAt(o, row, col);
            }
        }
        
        @Override
        public Object getValueAt(int row, int col){
            if(modelT!=null){
              return modelT.getValueAt(row, col);  
            } else {
                return getValueAt(row, col);
            }   
        }
        
        @Override
        public int getColumnCount(){
            if(modelT!=null){
              return modelT.getColumnCount();  
            } else {
                return getColumnCount();
            }  
        }
        
         @Override
         public  boolean isCellEditable(int row, int col){
             return false;
         }
}
