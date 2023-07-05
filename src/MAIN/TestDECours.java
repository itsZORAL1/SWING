package MAIN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestDECours  
{   JFrame fram1=new JFrame();
	JLabel lbel1;
	JLabel lbel2;
	JLabel lbel3;
	JLabel Etat;
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JButton buttn;
	JRadioButton rdb1;
	JRadioButton rdb2;
	JPanel panel;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JMenuBar menu;
	JMenu men;
	JMenu men2;
	JMenuItem itm1;
	JMenuItem itm2;
	JMenuItem itm3;
	public TestDECours() {
		//label
		Etat=new JLabel();
		Etat.setText("Etat :");
		lbel1= new JLabel();
		lbel1.setText("Code :");
		lbel2=new JLabel();
		lbel2.setText("Nom :");
	    lbel3=new JLabel();
	    lbel3.setText("Prenom :");
	    //textF
	    txt1=new JTextField("Code");
	    txt1.setPreferredSize(new Dimension(300,20));
	    txt2=new JTextField("Nom");
	    txt2.setPreferredSize(new Dimension(300,20));
	    txt3=new JTextField("Prenom");
	    txt3.setPreferredSize(new Dimension(300,20));
	    //Button
	    buttn=new JButton();
	    buttn.setText("Boutton");
	    buttn.setSize(40,20);
	    buttn.setFocusable(false);;
	    buttn.setSize(30, 15);
	    buttn.addActionListener(new Ecouteur());
	    //RadioButton
	    rdb1=new JRadioButton();
	    rdb1.setText("Marie");
	    rdb2=new JRadioButton();
	    rdb2.setText("Celibataire");
	    ButtonGroup grp=new ButtonGroup();
	    grp.add(rdb1);
	    grp.add(rdb2);
	    //Panel
	    panel=new JPanel();
	    panel2=new JPanel();
	    panel3=new JPanel();
	    panel4=new JPanel();
	    panel5=new JPanel();
	    panel2.setBackground(Color.BLUE);
	    panel2.setBackground(Color.CYAN);
	    panel3.setBackground(Color.gray);
	    panel4.setBackground(Color.green);
	    panel5.setBackground(Color.PINK);
	    panel.setLayout(new GridBagLayout());
	    GridBagConstraints gc=new GridBagConstraints();
	    gc.gridx=0;
	    gc.gridy=0;
	    panel.add(lbel1,gc);
	    gc.gridx=1;
	    gc.gridy=0;
	    panel.add(txt1,gc);
	    //---
	    gc.gridx=0;
	    gc.gridy=1;
	    panel.add(lbel2,gc);
	    gc.gridx=1;
	    gc.gridy=1;
	    panel.add(txt2,gc);
	    //--
	    gc.gridx=0;
	    gc.gridy=4;
	    panel.add(Etat,gc);
	    gc.gridx=1;
	    gc.gridy=4;
	    panel.add(rdb1,gc);
	    gc.gridx=2;
	    gc.gridy=4;
	    panel.add(rdb2,gc);
	    //---
	    gc.gridx=1;
	    gc.gridy=8;
	    panel.add(buttn,gc);
	    
	    //Menu
	    menu=new JMenuBar();
	    men=new JMenu("Client");
	    men2=new JMenu("Fournisseur");
	    itm1=new JMenuItem("MENU1");
	    itm2=new JMenuItem("MENU2");
	    itm3=new JMenuItem("MENU3");
	    men.add(itm1);
	    men.add(itm2);
	    men.add(itm3);
	    menu.add(men);
	    menu.add(men2);
	    //JToolBar
	    //WindowListner or windowAdapter?
	   
	    
		fram1.setSize(500,500);
		fram1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram1.setVisible(true);
		fram1.setLayout(new BorderLayout());
		fram1.add(panel,BorderLayout.CENTER);
		fram1.add(panel2,BorderLayout.NORTH);
		fram1.add(panel3,BorderLayout.SOUTH);
		fram1.add(panel4,BorderLayout.EAST);
		fram1.add(panel5,BorderLayout.WEST);
		fram1.setJMenuBar(menu);
		fram1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		
	}
	class Ecouteur implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttn){
				System.out.println(txt1.getText());
				//JOption
			}
			
			
		}
		
	}
	
	

}
