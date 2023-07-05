package Stylingfolder;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class CellEditorSanction extends DefaultCellEditor {
JTable table;
JTable table2;
	
    public CellEditorSanction (JTable table ,JTable table2) {
		super(new JCheckBox());
		this.table=table;
		this.table2=table2;
		
	}

	
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellEditorComponent(JTable table,Object value, boolean isSelected, int row,int  column) {
		ActionPanelSanction panel=new ActionPanelSanction ();
		    return panel.ActionPanelSanction(table,table2);
	}
}
