package Stylingfolder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

public class CustomComboBoxRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        if (isSelected) {
            label.setBackground(Color.DARK_GRAY);
            label.setForeground(Color.white);
        } else {
            label.setBackground(list.getBackground());
            label.setForeground(list.getForeground());
        }

        return label;
    }
}
