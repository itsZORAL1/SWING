package Stylingfolder;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class CellEditorAdmin  extends DefaultCellEditor {
JTable table;

	
    public CellEditorAdmin(JTable table ) {
		super(new JCheckBox());
		this.table=table;
		
	}

	
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellEditorComponent(JTable table,Object value, boolean isSelected, int row,int  column) {
		ActionPanelAdmin panel=new ActionPanelAdmin ();
		    return panel.ActionPanelAdmin(table);
	}
	
}
