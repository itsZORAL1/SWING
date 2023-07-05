package MAIN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 

public class Intro implements MouseListener,ActionListener {
	JFrame frame;
	JButton next;
	JLabel mainlabel;
	JLabel labelimage1;
	JLabel labelimage2;
	JLabel labelimage3;
	JLabel logo;
	JLabel labelnumber;
	JPanel paneltop;
	ImageIcon imageIcon1;
	ImageIcon imageIcon2;
	ImageIcon imageIcon3;
	JLabel text;
  public Intro() {
	  
	  
	  imageIcon1=new ImageIcon("C:\\\\Users\\\\dell\\\\Documents\\\\next.png");
		Image imgelog1N=imageIcon1.getImage();
		imageIcon1 =new ImageIcon(imgelog1N.getScaledInstance(60,60, Image.SCALE_SMOOTH));
		
		
		 imageIcon2=new ImageIcon("C:\\Users\\dell\\Documents\\student illustation.png");
			Image imgelog2N=imageIcon2.getImage();
			imageIcon2 =new ImageIcon(imgelog2N.getScaledInstance(250,250, Image.SCALE_SMOOTH));
			
			
			 imageIcon3=new ImageIcon("C:\\Users\\dell\\Documents\\moduleentree.png");
				Image imgelog3N=imageIcon3.getImage();
				imageIcon3 =new ImageIcon(imgelog3N.getScaledInstance(250,250, Image.SCALE_SMOOTH));
		
					
				next=new JButton();
				next.setIcon(imageIcon1);
				next.setBounds(1100, 540, 60, 60);
				next.setBorderPainted(false);
				next.setBackground(null);
				next.addActionListener(this);
				  
	  logo=new JLabel();
	  logo.setText("SchoolSavey");
	  logo .setBounds(590, 285,200, 60);
	 logo .setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,25));
	 logo.setForeground(new Color(250,162,29,255));
	 
	 labelimage1=new JLabel();
	 labelimage1.setIcon(imageIcon3);
	 labelimage1.setBounds(890, 90,250, 250);
	 
	 labelimage2=new JLabel();
	 labelimage2.setIcon(imageIcon2);
	 labelimage2.setBounds(150, 300,250,250);
	 
	 text=new JLabel();
     text.setText("<html>Bienvenue dans notre application de gestion scolaire ! Notre plateforme est conçue pour simplifier la gestion quotidienne de votre établissement scolaire, que vous soyez un directeur d'école, un enseignant ou un membre du personnel administratif. Grâce à notre système complet, vous pourrez gérer efficacement toutes les facettes de votre établissement.</html>");
     text.setPreferredSize(new Dimension(380, 150)); 
	 text.setBounds(430, 340, 560, 150);
	 text.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,13));
	 text.setBackground(null);
	
	  
	  mainlabel=new JLabel();
	  mainlabel.setText("Vol.");
	  mainlabel.setBounds(500, 150,400, 120);
	  mainlabel.setForeground(new Color(38,50,56,255));
	  mainlabel.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,120));
	  mainlabel.setBackground(null);
	  
	  labelnumber=new JLabel();
	  labelnumber.setText("I");
	  labelnumber.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,120));
	  labelnumber.setBounds(760, 150, 400, 120);
	  labelnumber.setForeground(new Color(250,162,29,255));
	  labelnumber.setBackground(null);
	  


	  
	  
	  
	  frame=new JFrame();
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	  frame.setLayout(new BorderLayout());
	  frame.setLayout(null);
	  frame.add(mainlabel);
	  frame.add(labelnumber);
	  frame.add(logo);
	  frame.add(labelimage1);
	  frame.add( labelimage2);
	  frame.add(text);
	  frame.add( next);
	  frame.getContentPane().setBackground(new Color(179,202,255,255));
	  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  }
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	
	
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
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==next) {
		try {
			new FrameL();
			frame.dispose();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
}
