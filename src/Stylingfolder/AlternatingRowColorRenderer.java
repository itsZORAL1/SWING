package Stylingfolder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class AlternatingRowColorRenderer extends DefaultTableCellRenderer {
    private static final Color EVEN_ROW_COLOR =  new Color(240, 240, 240, 255);
    private static final Color ODD_ROW_COLOR = Color.WHITE;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setPreferredSize(new Dimension(c.getPreferredSize().width, 50));
        ((JComponent) c).setBorder(BorderFactory.createLineBorder(new Color(31,65,102,255)));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
        
            if (!isSelected) {
            if (row % 2 == 0) {
                c.setBackground(EVEN_ROW_COLOR);
            } else {
                c.setBackground(ODD_ROW_COLOR);
            }
        }

        return c;
    }
}


