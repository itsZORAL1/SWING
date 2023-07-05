package Stylingfolder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class CustomComboBox<T> extends JComboBox<T> {

    private final Image icon;

    public CustomComboBox(T[] items, Image icon) {
        super(items);
        this.icon = icon;
        setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                return new JButton() {
                    @Override
                    public int getWidth() {
                        return 0;
                    }
                };
            }
        });

        setEditable(true);
        setEditor((ComboBoxEditor) new CustomComboBoxEditor());
    }

    public void setSelectionColor(Color color) {
        ((CustomComboBoxEditor) getEditor()).setSelectionColor(color);
    }

    private class CustomComboBoxEditor implements ComboBoxEditor, ActionListener {
        private final JTextField textField;
        private final Color selectionColor = new Color(240, 240, 240);

        public CustomComboBoxEditor() {
            textField = new JTextField();
            textField.setBorder(BorderFactory.createEmptyBorder());
            textField.addActionListener(this);
            textField.setHorizontalAlignment(SwingConstants.LEFT);
        }

        @Override
        public Object getItem() {
            return textField.getText();
        }

        @Override
        public void setItem(Object item) {
            if (item != null) {
                textField.setText(item.toString());
            } else {
                textField.setText("");
            }
        }

        public void setSelectionColor(Color color) {
            if (color != null) {
                textField.setSelectionColor(color);
            } else {
                textField.setSelectionColor(selectionColor);
            }
        }

        @Override
        public Component getEditorComponent() {
            return textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // nothing to do here
        }

        
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            g.setColor(Color.BLACK);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }

       
        public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
            g.drawImage(icon, bounds.x, bounds.y, null);
            Border border = BorderFactory.createEmptyBorder(0, 5, 0, 0);
            textField.setBorder(border);
            Dimension size = textField.getPreferredSize();
            size.width = bounds.width - icon.getWidth(null) - 5;
            size.height = bounds.height;
            textField.setPreferredSize(size);
        }

        @Override
        public void selectAll() {
            textField.selectAll();
        }

        @Override
        public void addActionListener(ActionListener l) {
            textField.addActionListener(l);
        }

        @Override
        public void removeActionListener(ActionListener l) {
            textField.removeActionListener(l);
        }
    }
}
