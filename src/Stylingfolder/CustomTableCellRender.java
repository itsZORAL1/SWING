package Stylingfolder;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CustomTableCellRender extends DefaultTableCellRenderer {
	private final TableCellRenderer delegate;
	public CustomTableCellRender(JTable table) {
        delegate = table.getDefaultRenderer(Object.class);
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    
    	
    	
    	
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setPreferredSize(new Dimension(c.getPreferredSize().width, 50));
        // set the border color to red
        ((JComponent) c).setBorder(BorderFactory.createLineBorder(new Color(31,65,102,255)));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

      
        

       

        return c;
    }
}


