package MAIN;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

public class AdministrationMain implements MouseListener {

	JFrame frame ;
	JPanel bar;
	JPanel moduleP;
	JButton moduleB;
	JLabel labelmodule;
	ImageIcon  iconmodule;

	public AdministrationMain() {
		
		iconmodule=new ImageIcon("C:\\Users\\dell\\Documents\\module.png");
		Image imgelogM=iconmodule.getImage();
		iconmodule=new ImageIcon(imgelogM.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		
		labelmodule=new JLabel();
		labelmodule.setIcon(iconmodule);
		labelmodule.setBounds(20, 3, 40, 40);
		
		moduleB=new JButton("Module >>");
		moduleB.setBackground(new Color(31,65,102,255));
		moduleB.setForeground(Color.WHITE);
		moduleB.setFocusable(false);
		moduleB.setBounds(60,10, 200, 30);
		moduleB.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
		moduleB.addMouseListener(this);
		moduleB.setBorderPainted(false);

		moduleP=new JPanel();
		moduleP.setBackground(new Color(31,65,102,60));
		moduleP.setLayout(null);
		moduleP.add(labelmodule);
		moduleP.add(moduleB);
		moduleP.setBounds(0, 460, 300, 60);
		
		bar=new JPanel();
		bar.setPreferredSize(new Dimension(300,1000));
		bar.setBackground(new Color(31,65,102,255));
		bar.setLayout(null);
		bar.add(moduleP);

	

	    frame = new JFrame();
	    frame.setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(100, 100, 450, 300);
	    frame.add(bar);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
