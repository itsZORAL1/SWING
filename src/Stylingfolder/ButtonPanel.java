package Stylingfolder;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonPanel extends DefaultTableCellRenderer {
	public JTable table;
        
	  public ButtonPanel(JTable table) {
		  this.table=table;
	  }
	
	
	@Override public Component getTableCellRendererComponent(JTable table,
			Object value, boolean isSelected, boolean isSelected1, int row, int column) {
		
		  Component com=	super.getTableCellRendererComponent(table, value, isSelected1, isSelected1, row, column);
		  
		
		    
		    ActionPanel panel=new ActionPanel ();
		    return panel.ActionPanel(table);
			
			}
	
}

