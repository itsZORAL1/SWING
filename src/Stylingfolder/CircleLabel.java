package Stylingfolder;

import java.awt.*;
import javax.swing.*;

public class CircleLabel extends JLabel {
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      int diameter = Math.min(getWidth(), getHeight());
      int x = (getWidth() - diameter) / 2;
      int y = (getHeight() - diameter) / 2;
      g2d.setColor(Color.pink);
      g2d.fillOval(x, y, diameter, diameter);
   }
}

