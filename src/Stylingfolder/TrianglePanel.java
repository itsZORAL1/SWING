package Stylingfolder;

import java.awt.*;
import javax.swing.*;



public class TrianglePanel extends JPanel {
	private Color triangleColor = Color.DARK_GRAY;
	@Override
	   protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      Graphics2D g2d = (Graphics2D) g;
	      int width = getWidth();
	      int height = getHeight();
	      int[] xPoints = {0, width, width/2};
	      int[] yPoints = {0, 0, height};
	      Polygon triangle = new Polygon(xPoints, yPoints, 3);
	      g2d.setColor(triangleColor);
	      g2d.fill(triangle);
	   }

	   public void setColor(Color color) {
	      this.triangleColor = color;
	      repaint();
	   }
}


