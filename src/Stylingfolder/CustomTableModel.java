package Stylingfolder;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {
    private boolean isFirstRowAdded = false;

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 11) {
            return true; // make only column 11 editable
        } else {
            return false; // make all other columns not editable
        }
    }

    @Override
    public void addRow(Object[] rowData) {
        super.addRow(rowData);
        isFirstRowAdded = true;
    }
}


