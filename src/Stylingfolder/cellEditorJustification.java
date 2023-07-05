package Stylingfolder;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class cellEditorJustification  extends DefaultCellEditor  {
JTable table;

	
    public cellEditorJustification(JTable table ) {
		super(new JCheckBox());
		this.table=table;
		
	}

	
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellEditorComponent(JTable table,Object value, boolean isSelected, int row,int  column) {
		ActionPanelJustification panel=new ActionPanelJustification ();
		    return panel.ActionPanelJustification(table);
	}
}
