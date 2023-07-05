package Stylingfolder;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class CellEditorNote extends DefaultCellEditor{
JTable table;
JComboBox box;

	
    public CellEditorNote(JTable table,JComboBox box ) {
		super(new JCheckBox());
		this.table=table;
		this.box=box;
		
	}

	
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellEditorComponent(JTable table,Object value, boolean isSelected, int row,int  column) {
		ActionPanelnote panel=new ActionPanelnote ();
		    return panel.ActionPanelnote(table,box);
	}
}
