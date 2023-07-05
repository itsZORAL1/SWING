package Stylingfolder;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedBorder implements Border {
	private int rayon;
	public RoundedBorder(int rayon) {
		this.rayon=rayon;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		g.drawRoundRect(x, y, width-1, height-1,rayon, rayon);
		

	}

	@Override
	public Insets getBorderInsets(Component c) {
	
		return new Insets(this.rayon+1,this.rayon+1,this.rayon+2,this.rayon);
	}

	@Override
	public boolean isBorderOpaque() {
		
		return true;
	}

}