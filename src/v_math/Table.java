package v_math;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Table {

    private String[] columnNames;
    private String[][] tableData = null;
    JScrollPane scrollPane;
    DefaultTableModel model;
   // private ArrayList<Point> points;
    private JTable table;

    public Table() {
        //columnNames = new String[]{"x","y"};
        //table = new JTable(tableData, columnNames);
       // table.setBorder(BorderFactory.createEmptyBorder(50,30,50,50));
        //scrollPane = new JScrollPane(table);
        model = new DefaultTableModel(new Object[]{"x", "y"}, 0);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(60, 50));
        scrollPane.setMaximumSize(new Dimension(600, 152));
    }

    public JTable getInstance() {
        return table;
    }

    public void clearTable(){

        while (model.getRowCount() > 0) {
           model.removeRow(0);
        }
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setTableData(ArrayList<Point> points) {
        //tableData = new String[points.size()][2];
        clearTable();
        //clearTable();
        for (int i = 0; i < points.size(); i++){
            model.addRow(new Object[]{points.get(i).getX(),points.get(i).getY() });
            //tableData[i][0] = String.valueOf(points.get(i).getX());
            //tableData[i][1] = String.valueOf(points.get(i).getY());
        }
        //table = new JTable(tableData, columnNames);
        //table.repaint();
    }
}
