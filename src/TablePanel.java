import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;

import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel{

    private JTable table;
    
    public TablePanel(){

        setLayout(new BorderLayout());
        
        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        
        add(new JScrollPane(table), BorderLayout.CENTER);

        setVisible(true);

        model.addColumn("Nome");
        model.addColumn("Cognome");
        model.addColumn("Telefono");
        
        Border bordoInterno = BorderFactory.createEtchedBorder();
        Border bordoEsterno = BorderFactory.createEmptyBorder(0, 5, 5, 5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);
        setBorder(bordoFinale);
    }

    public int getSelectedRow(){
        return table.getSelectedRow();
    }

    public void clearSelection(){
        table.clearSelection();
    }

    public void addRow(String nome, String cognome, String telefono){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.addRow(new Object[]{nome, cognome, telefono});
    }

    public void removeRow(int row){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.removeRow(row);
    }

    public void updateRow(String nome, String cognome, String telefono, int row){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setValueAt(nome, row, 0);
        tableModel.setValueAt(cognome, row, 1);
        tableModel.setValueAt(telefono, row, 2);
    }
}
