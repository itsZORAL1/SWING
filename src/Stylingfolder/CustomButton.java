package Stylingfolder;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
        setOpaque(false); // Make button background transparent
        setForeground(Color.WHITE); // Set text color to white
        setContentAreaFilled(false); // Remove default button fill
        setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Add padding to button text
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0, 0,new Color(51,98,204,255), 0, getHeight(),new Color(31,65,102,255))); // Set gradient colors
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Draw rounded rectangle button
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(0, 0, 0, 100)); // Set border color
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Draw rounded rectangle border
        g2.dispose();
    }
}