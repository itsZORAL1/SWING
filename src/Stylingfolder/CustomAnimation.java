package Stylingfolder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomAnimation extends JPanel {
    
    private int x = 0;
    private int y = 0;
    private int deltaX = 1;
    private int deltaY = 1;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);
        g2d.fillOval(x, y, 50, 50);
        
        // Move the oval
        x += deltaX;
        y += deltaY;
        
        // Reverse direction if we hit a boundary
        if (x < 0 || x > getWidth() - 50) {
            deltaX = -deltaX;
        }
        if (y < 0 || y > getHeight() - 50) {
            deltaY = -deltaY;
        }
        
        // Repaint the panel
        repaint();
    }

    
}
