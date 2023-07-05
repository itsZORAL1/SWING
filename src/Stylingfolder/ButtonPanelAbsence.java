package Stylingfolder;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonPanelAbsence extends DefaultTableCellRenderer{
	public JTable table;
    
	  public ButtonPanelAbsence(JTable table) {
		  this.table=table;
	  }
	
	
	@Override public Component getTableCellRendererComponent(JTable table,
			Object value, boolean isSelected, boolean isSelected1, int row, int column) {
		
		  Component com=	super.getTableCellRendererComponent(table, value, isSelected1, isSelected1, row, column);
		  
		
		    
		    ActionPanelabsence panel=new ActionPanelabsence ();
		    return panel.ActionPanelabsence(table);
			
			}
}
