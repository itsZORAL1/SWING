package Stylingfolder;


import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        int size = Math.max(getWidth(), getHeight());
        return new Dimension(size, size);
  
    }
}




