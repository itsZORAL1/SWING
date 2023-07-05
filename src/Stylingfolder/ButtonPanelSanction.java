package Stylingfolder;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonPanelSanction extends DefaultTableCellRenderer{
	public JTable table;
	public JTable table2;
	
    
	  public ButtonPanelSanction(JTable table,JTable tabl2) {
		  this.table=table;
		  this.table2=table2;
	  }
	
	
	@Override public Component getTableCellRendererComponent(JTable table,
			Object value, boolean isSelected, boolean isSelected1, int row, int column) {
		
		  Component com=	super.getTableCellRendererComponent(table, value, isSelected1, isSelected1, row, column);
		  
		
		    
		    ActionPanelSanction panel=new ActionPanelSanction ();
		    return panel.ActionPanelSanction(table,table2);
			
			}
}
