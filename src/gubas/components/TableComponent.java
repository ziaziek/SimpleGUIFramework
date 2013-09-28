/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.management.impl.ComponentAnimationManager;
import gubas.management.interfaces.AnimationManagable;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Przemek
 */
public class TableComponent extends JPanel implements AnimationManagable {
    
    JScrollPane scroll;
    
    JTable table;
    
    DefaultTableModel tableModel = null;

    GradientHeader header;

    TableCellRenderer cellRenderer = null;

    MouseMotionListener mmListener = null;
    
    TableRowSorter rowSorter = null;
    
    TableComponentStylist tableStylist = null;
    
    ComponentAnimationManager animMan = null;

    public TableComponentStylist getTableStylist() {
        return tableStylist;
    }

    public void setTableStylist(TableComponentStylist tableStylist) {
        this.tableStylist = tableStylist;
    }

    public MouseMotionListener getMmListener() {
        return mmListener;
    }

    public void setMmListener(MouseMotionListener mmListener) {
        this.mmListener = mmListener;
    }

    public TableRowSorter getRowSorter() {
        return rowSorter;
    }

    public void setRowSorter(TableRowSorter rowSorter) {
        this.rowSorter = rowSorter;
    }
    
    int itsRow = -1;
    
    int curAlfa = 0;
    
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
    
    @Override
    public void setSize(Dimension d){
        this.setPreferredSize(d);
        this.table.setFillsViewportHeight(true);
    }
    
    public TableComponent() {
        super();
        if (tableStylist == null) {
            tableStylist = new TableComponentStylist(this.table);
        }
        setLayout(new BorderLayout());
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
        table.getModel().addTableModelListener(table);
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
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.setDefaultRenderer(Object.class, new AlternateRowsRenderer());
            table.setRowSorter(new TableRowSorter(table.getModel()));
            scroll = new JScrollPane(table);
            this.removeAll();
            add(scroll);
            mmListener = new DefaultTableComponentMouseListener(this);
            table.addMouseMotionListener(mmListener);
            this.addMouseMotionListener(mmListener);
            if(mmListener instanceof MouseListener){
               table.addMouseListener((MouseListener) mmListener); 
            }
            animMan = new ComponentAnimationManager(this);
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
    
    
    public void animateRow(final int rowNumber) {
        animMan.animate();
    }

    @Override
    public int getCurrentAlpha() {
        return curAlfa;
    }

    @Override
    public void setCurrentAlpha(int a) {
        curAlfa = a;
    }

    @Override
    public void repaintAnimRegion() {
        repaint();
    }


    public class AlternateRowsRenderer extends DefaultTableCellRenderer {
        
        public AlternateRowsRenderer(){ super();
            setOpaque(true);
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, final int row, int column) {
               // setForeground(tableStylist.getHoverOverForegroundColor());
                //here we have to introduce threading for fading in and out
            if(row==itsRow){
                Color lHovCol = tableStylist.getHoverOverBackgroundColor();
                setBackground(new Color(lHovCol.getRed(),
                        lHovCol.getGreen(),
                        lHovCol.getBlue(),
                        curAlfa));
                setForeground(tableStylist.getHoverOverForegroundColor());
            } else {
                if (row % 2 != 0) {
                    setBackground(tableStylist.getOddRowBackgroundColor());
                    setForeground(tableStylist.getOddRowForegroundColor());
                } else {
                    setBackground(tableStylist.getEvenRowBackgroundColor());
                    setForeground(tableStylist.getEvenRowForegroundColor());
                }
            }
            if(o!=null){
              this.setText(o.toString());  
            }    
            
            return this;
        }
        
    }
    
    protected class GradientHeader extends JTableHeader{
        public Color startCol = tableStylist.getTableHeaderGradientFromColor();
        public Color endColor = tableStylist.getTableHeaderGradientToColor();
        private final float SIDE = 20;
        
        private GradientPaint gPaint = new GradientPaint(0,0,startCol, 0, SIDE, endColor, true);
        
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            this.setForeground(tableStylist.getTableHeaderGradientForegroundColor());
            this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            Graphics2D g2 = (Graphics2D)g;
            g2.setPaint(gPaint);
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        
    }
    

    
}
