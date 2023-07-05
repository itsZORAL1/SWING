package Stylingfolder;

import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;

class CustomCellEditor extends DefaultCellEditor {
	
    private int editableRow;
    public JTable table;
    
    

    public CustomCellEditor(JTextField textField, int editableRow,JTable table) {
        super(textField);
        this.editableRow = editableRow;
        this.table=table;
    }
    

    @Override
    public boolean isCellEditable(EventObject e) {
        int row = table.getSelectedRow();
        return row == editableRow;
    }
}
