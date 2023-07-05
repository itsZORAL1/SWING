package Stylingfolder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class CellEditor extends DefaultCellEditor {
	JTable table;

	
    public CellEditor(JTable table ) {
		super(new JCheckBox());
		this.table=table;
		
	}

	
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellEditorComponent(JTable table,Object value, boolean isSelected, int row,int  column) {
		ActionPanel panel=new ActionPanel ();
		    return panel.ActionPanel(table);
	}
	
	

}
