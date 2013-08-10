/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author Przemek
 */
public class TableComponent extends JPanel implements MouseMotionListener {
    
    JScrollPane scroll;
    
    JTable table;
    
    DefaultTableModel tableModel = null;

    GradientHeader header;

    TableCellRenderer cellRenderer = null;

    public TableCellRenderer getCellRenderer() {
        return cellRenderer;
    }

    public void setCellRenderer(TableCellRenderer cellRenderer) {
        this.cellRenderer = cellRenderer;
        table.setDefaultRenderer(Color.class , cellRenderer);
    }
    
    public GradientHeader getHeader() {
        return header;
    }
    
    public TableComponent(){
        super();
    }
    
    public TableComponent(Object[][] data, String[] colNames){
        this();
        populateTable(data, colNames);
    }
    
    public TableComponent(DefaultTableModel model){
        this();
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
            if (table.getModel()==null && tableModel!=null)
                    table.setModel(tableModel);
            table.setDefaultRenderer(Object.class, new AlternateRowsRenderer());
            scroll = new JScrollPane(table);
            this.removeAll();
            add(scroll);
            table.addMouseMotionListener(this);
        }
    }
    
    public AbstractTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel =  tableModel;
    }
    
    public JScrollPane getScroll() {
        return scroll;
    }

    public JTable getTable() {
        return table;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public class AlternateRowsRenderer extends DefaultTableCellRenderer {
        
        protected Color alternateColor = Color.YELLOW;
        
        public AlternateRowsRenderer(){ super();
            setOpaque(true);
        }

        public AlternateRowsRenderer(Color c){
            this();
            alternateColor = c;
        }
        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
           if(row%2!=0){
               setBackground(alternateColor);
           } else
           {
               setBackground(Color.white);
           }
           setForeground(Color.gray);
           this.setText(o.toString());
            return this;
        }
        
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
