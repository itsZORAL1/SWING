package Stylingfolder;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonPanelnote extends DefaultTableCellRenderer {
public JTable table;
public JComboBox box;
public static String choiceC;

    
	  public ButtonPanelnote(JTable table,JComboBox box) {
		  this.table=table;
		  this.box=box;
	  }
	
	  
	  
	@Override public Component getTableCellRendererComponent(JTable table,
			Object value, boolean isSelected, boolean isSelected1, int row, int column) {
		
		  Component com=	super.getTableCellRendererComponent(table, value, isSelected1, isSelected1, row, column);
		  
		
		    
		    ActionPanelnote panel=new ActionPanelnote ();
		   
		    return panel.ActionPanelnote(table,box);
			
			}
}
