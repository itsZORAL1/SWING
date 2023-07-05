package MAIN;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class FirstPage {
	JFrame fp;
	
	public  FirstPage() {
		//Frame
				fp=new JFrame();
				fp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        fp.setVisible(true);
				fp.setLayout(new BorderLayout());
				fp.getContentPane().setBackground(Color.WHITE);
				fp.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
}
