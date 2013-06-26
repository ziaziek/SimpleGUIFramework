/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author Przemek
 */
public class TableComponent extends JPanel {
    
    JScrollPane scroll;
    
    JTable table;
    
    AbstractTableModel tableModel;

    GradientHeader header;

    public GradientHeader getHeader() {
        return header;
    }
    
    public TableComponent(){
        super();
    }
    
    public TableComponent(Object[][] data, String[] colNames){
        super();
        populateTable(data, colNames);
    }
    
    public TableComponent(DefaultTableModel model){
        super();
        populateTable(model);
    }
    
    public void populateTable(Object[][] data, String[] columnNames){
        table = new JTable(data, columnNames);
        prepare();
        
    }
    
    public void populateTable(DefaultTableModel m){
        table = new JTable(m);
        prepare();
    }
    
    
    protected void createHeader(){
        header = new GradientHeader();
        if(table.getModel()!=null){
            header.setColumnModel(table.getColumnModel());
            table.setTableHeader(header);
        }
    }
    
    protected void prepare(){
        if(table!=null){
            createHeader();
            scroll = new JScrollPane(table);
            this.removeAll();
            add(scroll);
        }
    }
    
    public AbstractTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(AbstractTableModel tableModel) {
        this.tableModel = tableModel;
    }
    
    public JScrollPane getScroll() {
        return scroll;
    }

    public JTable getTable() {
        return table;
    }
    
    protected class GradientHeader extends JTableHeader{
        public Color startCol = new Color(0,55,255,100);
        public Color endColor = new Color(255,255,255,120);
        private final float SIDE = 20;
        
        private GradientPaint gPaint = new GradientPaint(0,0,startCol, 0, 20, endColor, true);
        
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            this.setForeground(Color.blue);
            this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            Graphics2D g2 = (Graphics2D)g;
            g2.setPaint(gPaint);
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        
    }
}
