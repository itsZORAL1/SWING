package MAIN;
import java.sql.*;
import java.awt.BorderLayout;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import SQL.SQLtraitement;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;



public class FrameL  implements MouseListener ,ActionListener{
	//frame
	JFrame FrameL;
	//image
	ImageIcon imageLO;
	ImageIcon imgeLN;
	ImageIcon imgelog1;
	ImageIcon imgelog2;
	ImageIcon imgelog3;
	ImageIcon imgelog4;
	ImageIcon imgelog5;
	ImageIcon imgelog6;
	ImageIcon imgelog7;
	ImageIcon imgelog8;
	ImageIcon imgelog9;
	ImageIcon imgelog10;
	ImageIcon imgelog11;
	ImageIcon imgelog12;
	ImageIcon imgelog13;
	ImageIcon imgelog14;
	ImageIcon imgelog15;
	ImageIcon imgelog16;
	
	
	
	
	//label
	JLabel labelL ;
	JLabel labellog1 ;
	JLabel labellog2 ; 
	JLabel labellog3 ; 
	JLabel labellog4 ; 
	JLabel labellog5 ; 
	JLabel labellog6 ; 
	JLabel labellog7 ; 
	JLabel labellog8 ;
	JLabel labellog9 ; 
	JLabel labellog10 ; 
	JLabel labellog11 ; 
	JLabel labellog12; 
	JLabel labellog13; 
	JLabel labellog14; 
	JLabel labellog15;
	JLabel labellog16;
	JLabel labellog17;
	JLabel labellog18;
	JLabel labellog19;
	JLabel labellog20;
	JLabel labellog21;
	JLabel labellog22;
	JLabel labellog23;
	JLabel labellog24;
	JLabel labellog25;
	JLabel labellog26;
	JLabel labellog27;
	JLabel labellog28;
	JLabel labellog29;
	JLabel labellog30;
	JLabel labellog31;
	JLabel labellog32;
	JLabel labellog33;
	JLabel labellog34;
	JLabel labellog35;
	JLabel labellog36;
	JLabel labellog37;
	JLabel labellog38;
	JLabel labellog39;
	JLabel labellog40;
	JLabel labellog41;
	JLabel labellog42;
	JLabel labellog43;
	JLabel labellog44;
	JLabel labellog45;
	JLabel labellog46;
	JLabel labellog47;
	JLabel labellog48;
	JLabel labellog49;
	JLabel labellog50;
	JLabel labellog51;
	JLabel labellog52;
	JLabel labellog53;
	
	
	JLabel label ; 
	
	
	
	//Panel
	JPanel panelL;
	JPanel panellog;
	JPanel panelS;
	JPanel panelsign;
	JPanel panelRadio;
	JPanel PasswRecovPanel;
	JPanel PasswUpdatePanel;
	JLayeredPane pane;
	
	
	//button
	JButton logButn;
	JButton signButn;
	JButton signButn2;
	JButton see_passw;
	JButton MainLogin;
	JButton finition;
	JButton MainSign;
	JRadioButton rd1;
	JRadioButton rd2;
	JRadioButton rd3;
	ButtonGroup grp;
	JButton UpdatePass;
	JButton RecoverPass;
	JButton MainUpdatePass;
	JButton MainNotSign;
	JButton MainNotRecoverPass;
	JButton MainNotUpdatePass;
	
	
	
	//text Field
	JTextField field1;
	JPasswordField field2;
	JTextField field3;
	JPasswordField field4;
	JTextField field5;
	JTextField field6;
	JTextField field7;
	JTextField field8;
	JTextField field9;
	JTextField field10;
	JTextField field11;
	JTextField field12;
	JTextField field13;
	JTextField field14;
	JTextField field15;
	JTextField field16;//EmailUpdate
	JPasswordField field17;//password update
	JPasswordField field18;//nouv pass
	JPasswordField field19;//confirm nouveau
	
	
	
	//Value-Varibales
	String radioButtonValue;// etat civil
	String code;
	String nom;
	String prenom ;
	String fonction;
	String status;
	String departement ;
	String dateNais;
	String Email;
	String passWord;
	String Password;
	public String NomComp="";
	String EMaiL;
	int valueJopt1;
	String NomR="";
	String PrenomR="";
	String EmailR="";
	String PasswordUp="";
	String NewPasswordUp="";
	String ConfirmNewPasswordUp="";
	Hashtable<String,String> tab;
	Hashtable<String,String> tab2;
	String nomC;
	
	
	
	
	
	
	
	


	//Border
	Border brd=BorderFactory.createLineBorder(new Color(31,65,102,255));
	Border brd2=BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(31,65,102,255));
	Border br3=BorderFactory.createLineBorder(new Color(248,165,33,255));//orange
	Border feild1B=BorderFactory.createTitledBorder(brd,"Email");
	Border feild2B=BorderFactory.createTitledBorder(brd,"PassWord");
	Border feild3B=BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(31,65,102,255));
	Border feild4B=BorderFactory.createMatteBorder(1, 0, 0,1 , Color.LIGHT_GRAY);
	Border feild5B=BorderFactory.createLoweredBevelBorder();
	Border feild6B=BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(31,65,102,255));
	Border feild7B=BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(31,65,102,255));
	Border feild8B=BorderFactory.createMatteBorder(0, 0, 0,1 ,new Color(31,65,102,255));
	Border feild9B=BorderFactory.createMatteBorder(1, 1, 0,1 ,new Color(31,65,102,255));
	Border feild10B=BorderFactory.createTitledBorder(brd,"Nom");
	Border feild11B=BorderFactory.createTitledBorder(brd,"Prenom");
	Border feild12B=BorderFactory.createTitledBorder(brd,"Enseignant Code");
	Border feild13B=BorderFactory.createTitledBorder(brd,"Fonction");
	Border feild14B=BorderFactory.createTitledBorder(brd,"Departement");
	Border feild15B=BorderFactory.createTitledBorder(brd,"Status");
	Border feild16B=BorderFactory.createTitledBorder(brd,"Nom Complet");
	Border feild17B=BorderFactory.createTitledBorder(brd2,"Etat Civile");
	Border feild18B=BorderFactory.createTitledBorder(brd,"Date De Naissance");
	
	TitledBorder feild19B=BorderFactory.createTitledBorder(brd,"Nouveu PassWord");
	TitledBorder feild20B=BorderFactory.createTitledBorder(brd,"Confirmer Nouveau PassWord");
	TitledBorder feild21B=BorderFactory.createTitledBorder(brd,"Email");
	TitledBorder feild22B=BorderFactory.createTitledBorder(brd,"Password");
	
	
	
	//Connection 
	Connection cont;
	Statement st;
	PreparedStatement st2;
	ResultSet rs1;
	ResultSet rs;
	String sql;
	String sql2;

	
	public FrameL() throws ClassNotFoundException, SQLException {
		//Icon image
				imageLO=new ImageIcon("C:\\Users\\dell\\Pictures\\login_wallpaper.jpeg");
				Image imgLO=imageLO.getImage();
				imgeLN=new  ImageIcon(imgLO.getScaledInstance(500, 500, Image.SCALE_SMOOTH));
				
				imgelog1=new ImageIcon("C:\\Users\\dell\\Pictures\\teacher _ogo.png");
				Image imgelog1N=imgelog1.getImage();
				imgelog1 =new ImageIcon(imgelog1N.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				
				imgelog2=new ImageIcon("C:\\Users\\dell\\Documents\\password_wallpaper.png");
				Image imgelog2N=imgelog2.getImage();
				imgelog2 =new ImageIcon(imgelog2N.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
				
				imgelog3=new ImageIcon("C:\\Users\\dell\\Documents\\see_password.jpeg");
				Image imgelog3N=imgelog3.getImage();
				imgelog3 =new ImageIcon(imgelog3N.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
				
				imgelog4=new ImageIcon("C:\\Users\\dell\\Documents\\plus_signe.jpeg");
				Image imgelog4N=imgelog4.getImage();
				imgelog4 =new ImageIcon(imgelog4N.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
				
				imgelog5=new ImageIcon("C:\\Users\\dell\\Documents\\code_enseignat.jpeg");
				Image imgelog5N=imgelog5.getImage();
				imgelog5 =new ImageIcon(imgelog5N.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				
				imgelog6=new ImageIcon("C:\\Users\\dell\\Documents\\calender.png");
				Image imgelog6N=imgelog6.getImage();
				imgelog6 =new ImageIcon(imgelog6N.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
				
			//	imgelog7=new ImageIcon("C:\\Users\\dell\\Documents\\fonction.jpeg");
			//	Image imgelog7N=imgelog7.getImage();
			//	imgelog7 =new ImageIcon(imgelog7N.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
				
				imgelog8=new ImageIcon("C:\\Users\\dell\\Documents\\departement.jpeg");
				Image imgelog8N=imgelog8.getImage();
				imgelog8 =new ImageIcon(imgelog8N.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
				
				//imgelog9=new ImageIcon("C:\\Users\\dell\\Documents\\status.png");
			//	Image imgelog9N=imgelog9.getImage();
			//	imgelog9 =new ImageIcon(imgelog9N.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
				
				imgelog9=new ImageIcon("C:\\Users\\dell\\Documents\\circle_check.png");
				Image imgelog9N=imgelog9.getImage();
				imgelog9 =new ImageIcon(imgelog9N.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
				
				imgelog7=new ImageIcon("C:\\Users\\dell\\Documents\\empty_field.png");
				Image imgelog7N=imgelog7.getImage();
				imgelog7 =new ImageIcon(imgelog7N.getScaledInstance(10, 10, Image.SCALE_SMOOTH));
				
				imgelog10=new ImageIcon("C:\\Users\\dell\\Documents\\Wrong_password.jpeg");
				Image imgelog10N=imgelog10.getImage();
				imgelog10 =new ImageIcon(imgelog10N.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
				
				imgelog11=new ImageIcon("C:\\Users\\dell\\Documents\\PassWord_Recovering.jpeg");
				Image imgelog11N=imgelog11.getImage();
				imgelog11 =new ImageIcon(imgelog11N.getScaledInstance(500, 500, Image.SCALE_SMOOTH));
				
				
				imgelog12=new ImageIcon("C:\\Users\\dell\\Documents\\password_cheching.jpeg");
				Image imgelog12N=imgelog12.getImage();
				imgelog12 =new ImageIcon(imgelog12N.getScaledInstance(180, 180, Image.SCALE_SMOOTH));
				
				
				imgelog13=new ImageIcon("C:\\Users\\dell\\Documents\\not_check_image.png");
				Image imgelog13N=imgelog13.getImage();
				imgelog13 =new ImageIcon(imgelog13N.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
				
				
				imgelog14=new ImageIcon("C:\\Users\\dell\\Documents\\Sign_up_successfully.jpeg");
				Image imgelog14N=imgelog14.getImage();
				imgelog14 =new ImageIcon(imgelog14N.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				
				imgelog15=new ImageIcon("C:\\Users\\dell\\Documents\\Update Panel.jpeg");
				Image imgelog15N=imgelog15.getImage();
				imgelog15 =new ImageIcon(imgelog15N.getScaledInstance(500, 500, Image.SCALE_SMOOTH));
				
				imgelog16=new ImageIcon("C:\\Users\\dell\\Documents\\UpdatePassSideImage.jpeg");
				Image imgelog16N=imgelog16.getImage();
				imgelog16 =new ImageIcon(imgelog16N.getScaledInstance(180, 170, Image.SCALE_SMOOTH));
				
				
				
				
				
				
				
				
				
				
				
		// Button
				logButn=new JButton();
				logButn.setText("Log In");
				logButn.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
				logButn.setFocusable(false);
				logButn.setBackground(Color.white);
				logButn.setBorderPainted(true);
				logButn.setBounds(0, 0, 150, 40);
				logButn.setForeground(new Color(31,65,102,255));
				logButn.setOpaque(true);
				logButn.setBorder(feild3B);
				
				signButn=new JButton();
				signButn.setText("Sign Up");
				signButn.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
				signButn.setFocusable(false);
				signButn.setBackground(Color.white);
				signButn.setBounds(450, 0, 150, 60);
				signButn.setForeground(Color.lightGray);
				signButn.setOpaque(true);
				signButn.addMouseListener(this);
				signButn.setBorder(feild4B);
				
				signButn2=new JButton();
				signButn2.setText("Sign Up");
				signButn2.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
				signButn2.setFocusable(false);
				signButn2.setBackground(Color.white);
				signButn2.setBounds(450, 0, 150, 60);
				signButn2.setForeground(Color.lightGray);
				signButn2.setOpaque(true);
				signButn2.addMouseListener(this);
				signButn2.setBorder(feild9B);
				signButn2.setForeground(new Color(31,65,102,255));
				
				see_passw=new JButton();
				see_passw.setFocusable(false);
				see_passw.setBorderPainted(false);
				see_passw.addActionListener(this);
				see_passw.setIcon(imgelog3);
				see_passw.setBounds(450, 360, 40, 40);
				
				MainLogin=new JButton();
	//	MainLogin.setText("Log In");
	//	MainLogin.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
	//	MainLogin.setBackground(new Color(31,65,102,255));
	//	MainLogin.setForeground(Color.white);
				MainLogin.setOpaque(false);
				MainLogin.setBounds( 470, 470, 60,60);
	//	MainLogin.setBorder(new RoundedBorder(30));
				MainLogin.setFocusable(false);
				MainLogin.setBorderPainted(false);
				MainLogin.setContentAreaFilled(false);
				MainLogin.setFocusPainted(false);
				MainLogin.setIcon(imgelog9);
				MainLogin.addMouseListener(this);
				
				MainSign=new JButton();
			    MainSign.setOpaque(false);
				MainSign.setBounds(470, 490, 60,60);
				MainSign.setFocusable(false);
				MainSign.addMouseListener(this);
				MainSign.setFocusable(false);
				MainSign.setBorderPainted(false);
				MainSign.setContentAreaFilled(false);
				MainSign.setFocusPainted(false);
				MainSign.setIcon(imgelog9);
			
				
				
				finition=new JButton();
				finition.setFocusable(false);
				finition.setBackground(Color.white);
				finition.setBounds(0, 0, 450, 60);
				finition.setBorder(feild7B);
				
				rd1=new JRadioButton();
				rd1.setText("Marié");
				rd1.setBounds(140,540,20,15);
				rd1.setFocusable(false);
				rd1.setBackground(Color.white);
				rd1.addActionListener(this);
				rd2=new JRadioButton();
				rd2.setText("Célibaire");
				rd2.setBounds(210,540,20,15);
				rd2.setFocusable(false);
				rd2.setBackground(Color.white);
				rd2.addActionListener(this);
				grp=new ButtonGroup();
				grp.add(rd1);
				grp.add(rd2);
				
				
				UpdatePass=new JButton();
				UpdatePass.setBounds( 100, 470, 160,60);
				UpdatePass.setBorder(feild3B);
				UpdatePass.setText("Update Password ?");
				UpdatePass.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
				UpdatePass.setBackground(Color.WHITE);
				UpdatePass.setForeground(new Color(31,65,102,255));
				UpdatePass.setVisible(true);
				UpdatePass.setFocusable(false);
				UpdatePass.addMouseListener(this);
				
				
				
				RecoverPass=new JButton();
		    	RecoverPass.setOpaque(false);
		    	RecoverPass.setBounds(440, 460, 60,60);
		    	RecoverPass.setFocusable(false);
		    	RecoverPass.addMouseListener(this);
		    	RecoverPass.setBorderPainted(false);
		    	RecoverPass.setContentAreaFilled(false);
		    	RecoverPass.setFocusPainted(false);
		    	RecoverPass.setIcon(imgelog9);
		    	
		    	MainNotSign=new JButton();
		    	MainNotSign.setOpaque(false);
		    	MainNotSign.setBounds(20, 70, 60,60);
		    	MainNotSign.setFocusable(false);
		    	MainNotSign.addMouseListener(this);
		    	MainNotSign.setBorderPainted(false);
		    	MainNotSign.setContentAreaFilled(false);
		    	MainNotSign.setFocusPainted(false);
		    	MainNotSign.setIcon(imgelog13);
		    	
		    	MainNotRecoverPass=new JButton();
		    	MainNotRecoverPass.setOpaque(false);
		    	MainNotRecoverPass.setBounds(5, 9, 60,60);
		    	MainNotRecoverPass.setFocusable(false);
		    	MainNotRecoverPass.addMouseListener(this);
		    	MainNotRecoverPass.setBorderPainted(false);
		    	MainNotRecoverPass.setContentAreaFilled(false);
		    	MainNotRecoverPass.setFocusPainted(false);
		    	MainNotRecoverPass.setIcon(imgelog13);
		    	
		    	MainNotUpdatePass=new JButton();
		    	MainNotUpdatePass.setBounds(495, 3, 60, 60);
		    	MainNotUpdatePass.setIcon(imgelog13);
		    	MainNotUpdatePass.setFocusable(false);
		    	MainNotUpdatePass.addMouseListener(this);
		    	MainNotUpdatePass.setBorderPainted(false);
		    	MainNotUpdatePass.setContentAreaFilled(false);
		    	MainNotUpdatePass.setFocusPainted(false);
		    	MainNotUpdatePass.setIcon(imgelog13);
		    	
		    	
		    	
		    	MainUpdatePass=new JButton();
		    	MainUpdatePass.setOpaque(false);
		    	MainUpdatePass.setBounds(450, 490, 60,60);
		    	MainUpdatePass.setFocusable(false);
		    	MainUpdatePass.addMouseListener(this);
		    	MainUpdatePass.setFocusable(false);
		    	MainUpdatePass.setBorderPainted(false);
		    	MainUpdatePass.setContentAreaFilled(false);
		    	MainUpdatePass.setFocusPainted(false);
		    	MainUpdatePass.setIcon(imgelog9);
				
				
				
				
				
				
				
				
		//Text field
				field1=new JTextField();
				field1.setBounds(180,200,270,40);
				field1.setBorder(feild1B);
				
				field2=new JPasswordField();
				field2.setBounds(180,360,270,40);
				field2.setBorder(feild2B);
				
				field3=new JTextField();
				field3.setBounds(100,90,270,40);
				field3.setBorder(feild1B);
				
				field4=new JPasswordField();
				field4.setBounds(100,140,270,40);
				field4.setBorder(feild2B);
				
				field5=new JTextField ();
				field5.setBounds(100,190,270,40);
				field5.setBorder(feild10B);//+
				
				field6=new JTextField ();
				field6.setBounds(100,240,270,40);
				field6.setBorder(feild11B);
				
				field7=new JTextField ();
				field7.setBounds(100,290,270,40);
				field7.setBorder(feild12B);
				
				field8=new JTextField ();
				field8.setBounds(100,390,270,40);
				field8.setBorder(feild13B);
				
				field9=new JTextField ();
				field9.setBounds(100,440,270,40);
				field9.setBorder(feild14B);
				
				field10=new JTextField ();
				field10.setBounds(100,490,270,40);
				field10.setBorder(feild15B);
				
				field11=new JTextField ();

				field11.setBounds(180,280,270,40);
				field11.setBorder(feild16B);//+
				
				
				field12=new JTextField ();

				field12.setBounds(100,340,270,40);
				field12.setBorder(feild18B);//
				
				
				field13=new JTextField ();
				field13.setBounds(190, 250, 270, 40);
				field13.setBorder(feild16B);//NomComp
				
				
				field14=new JTextField();
				field14.setBounds(190,370,270,40);
				field14.setBorder(feild1B); //Email
				
				//annule
				field15=new JTextField();
				field15.setBounds(190,310,270,40);
				field15.setBorder(feild14B);
			/*	
               (new Color(248,165,33,255));//orange
				*/
			/*	feild19B.setTitleColor(new Color(248,165,33,255));
				feild20B.setTitleColor(new Color(248,165,33,255));
				feild21B.setTitleColor(new Color(248,165,33,255));
				feild22B.setTitleColor(new Color(248,165,33,255));*/
				
				field16=new JTextField();
				field16.setBounds(150,200,270,40);
				field16.setBorder( feild21B);
				field16.setBackground(Color.white);
				field16.setForeground(new Color(31,65,102,255));
				
				field17=new JPasswordField();
				field17.setBounds(150,280,270,40);
				field17.setBorder( feild22B);
				field17.setBackground(Color.white);
				field17.setForeground(new Color(31,65,102,255));
				
				field18=new JPasswordField();
				field18.setBounds(150,360,270,40);
				field18.setBorder( feild19B);
				field18.setBackground(Color.white);
				field18.setForeground(new Color(31,65,102,255));
				
				
				field19=new JPasswordField();
				field19.setBounds(150,440,270,40);
				field19.setBorder( feild20B);
				field19.setBackground(Color.white);
				field19.setForeground(new Color(31,65,102,255));
				
				
				
				
				
				
				
				
			
				 
				
		
		
		//Label
				
		labelL =new JLabel();
		labelL.setLayout(new FlowLayout());
		labelL.setIcon(imgeLN);
		labelL.setBackground(Color.cyan);
		labelL.setBounds(800, 100, 500, 500);
		
		
		
		
		
		labellog1=new JLabel();
		labellog1.setBounds(140, 200, 40, 40);
		labellog1.setIcon(imgelog1);
		
		labellog2 =new JLabel();
		labellog2.setBounds(145, 360, 40, 40);
		labellog2.setIcon(imgelog2);
		
		labellog4=new JLabel();
		labellog4.setBounds(56, 90, 40, 40);
		labellog4.setIcon(imgelog1);
		
		labellog5=new JLabel();
		labellog5.setBounds(56, 140, 40, 40);
		labellog5.setIcon(imgelog2);
		
		labellog6=new JLabel();
		labellog6.setBounds(56, 190, 40, 40);
		labellog6.setIcon(imgelog4);
		
		labellog7=new JLabel();
		labellog7.setBounds(56, 240, 40, 40);
		labellog7.setIcon(imgelog4);//+
		
		labellog3=new JLabel();
		labellog3.setBounds(53, 290, 40, 40);
		labellog3.setIcon(imgelog5);
		
		labellog8=new JLabel();
		labellog8.setBounds(56, 340, 40, 40);
		labellog8.setIcon(imgelog6);
		
		labellog9=new JLabel();
		labellog9.setBounds(56, 390, 40, 40);
		labellog9.setIcon(imgelog8);
		
		labellog10=new JLabel();
		labellog10.setBounds(56, 440, 40, 40);
		labellog10.setIcon(imgelog8);
		
		labellog11=new JLabel();
		labellog11.setBounds(56, 490, 40, 40);
		labellog11.setIcon(imgelog8);
		
		labellog12=new JLabel();
		labellog12.setBounds(145, 280, 40, 40);
		labellog12.setIcon(imgelog4);
		
		labellog13=new JLabel();
		labellog13.setBounds(50,540, 40, 40);
		labellog13.setIcon(imgelog4);
		
		
	           
		labellog16=new JLabel();
		labellog16.setBounds(56,540, 40, 40);
		labellog16.setIcon(imgelog8);
		
		labellog17=new JLabel();
		labellog17.setBounds(370,100,30,30);
		labellog17.setIcon(imgelog7);
		labellog17.setVisible(false);
		
		labellog18=new JLabel();
		labellog18.setBounds(370,150,30,30);
		labellog18.setIcon(imgelog7);
		labellog18.setVisible(false);
		
		
		labellog19=new JLabel();
		labellog19.setBounds(370,200,30,30);
		labellog19.setIcon(imgelog7);
		labellog19.setVisible(false);
		
		labellog20=new JLabel();
		labellog20.setBounds(370,250,30,30);
		labellog20.setIcon(imgelog7);
		labellog20.setVisible(false);
		
		labellog21=new JLabel();
		labellog21.setBounds(370,300,30,30);
		labellog21.setIcon(imgelog7);
		labellog21.setVisible(false);
		
		labellog22=new JLabel();
		labellog22.setBounds(370,350,30,30);
		labellog22.setIcon(imgelog7);
		labellog22.setVisible(false);
		
		labellog23=new JLabel();
		labellog23.setBounds(460,210,30,30);
		labellog23.setIcon(imgelog7);
		labellog23.setVisible(false);
		
		labellog24=new JLabel();
		labellog24.setBounds(490,370,30,30);
		labellog24.setIcon(imgelog7);
		labellog24.setVisible(false);
		
		
		labellog25=new JLabel();
		labellog25.setBounds(370,450,30,30);
		labellog25.setIcon(imgelog7);
		labellog25.setVisible(false);
		
		
		labellog26=new JLabel();
		labellog26.setBounds(210,0,200,150);
		labellog26.setIcon(imgelog12);
		labellog26.setVisible(true);
		
		labellog27=new JLabel();
		labellog27.setBounds(150, 250, 40, 40);
		labellog27.setIcon(imgelog1); //fil13
		//annule
		labellog28=new JLabel();
		labellog28.setBounds(150, 310, 40, 40);
		labellog28.setIcon(imgelog4);
		
		labellog29=new JLabel();
		labellog29.setBounds(150, 370, 40, 40);
		labellog29.setIcon(imgelog4);
		
		labellog30=new JLabel();
		labellog30.setBounds(470, 250, 270, 40);
		labellog30.setIcon(imgelog7);
		labellog30.setVisible(false);
		
		
		labellog31=new JLabel();
		labellog31.setBounds(470,370,270,40);
		labellog31.setIcon(imgelog7);
		labellog31.setVisible(false);
		
		labellog32=new JLabel();
		labellog32.setBounds(800, 100, 500, 500);
		labellog32.setIcon(imgelog15);
		labellog32.setVisible(true);
		
		labellog33=new JLabel();
		labellog33.setBounds(0, 0, 170, 170);
		labellog33.setIcon(imgelog16);
		
		labellog34=new JLabel();
		labellog34.setBounds(200, 80, 270, 50);
		labellog34.setText("Update PassWord !");
		labellog34.setFont(new Font(Font.MONOSPACED,Font.ITALIC,25));
		labellog34.setForeground(new Color(248,165,33,255));
		
		//update
		labellog35=new JLabel();
		labellog35.setBounds(150,510,250,30);
		labellog35.setText("entrer au minimum 8 caractères! ");
		labellog35.setForeground(Color.red);
		labellog35.setVisible(false);
		
		labellog36=new JLabel();
		labellog36.setBounds(150,390,250,30);
		labellog36.setText("entrer au minimum 8 caractères! ");
		labellog36.setForeground(Color.red);
		labellog36.setVisible(false);
		
		labellog37=new JLabel();
		labellog37.setBounds(150,470,250,30);
		labellog37.setText("choisissez un nouveau mot de passe !");
		labellog37.setForeground(Color.red);
		labellog37.setVisible(false);
		
		labellog42=new JLabel();
		labellog42.setBounds(150,230,280,30);
		labellog42.setText("les (@,.com) ne sont pas trouvés!");
		labellog42.setForeground(Color.red);
		labellog42.setVisible(false);
		
		
		labellog43=new JLabel();
		labellog43.setBounds(150,490,300,30);
		labellog43.setText(" c'est different de votre precedent choix");
		labellog43.setForeground(Color.red);
		labellog43.setVisible(false);
		
		
		labellog38=new JLabel();
		labellog38.setBounds(425,290,30,30);//Empty pasword
		labellog38.setIcon(imgelog7);
		labellog38.setVisible(false);
		
		
		labellog39=new JLabel();
		labellog39.setBounds(425,360,30,40);//Empty Newpasword
		labellog39.setIcon(imgelog7);
		labellog39.setVisible(false);
		
		
		labellog40=new JLabel();
		labellog40.setBounds(425,440,40,40);//Empty Confirmpasword
		labellog40.setIcon(imgelog7);
		labellog40.setVisible(false);
		
		labellog41=new JLabel();
		labellog41.setBounds(425,200,40,40);//Empty EmailUpdate
		labellog41.setIcon(imgelog7);
		labellog41.setVisible(false);
		//signupTraitemet
		labellog44=new JLabel();
		labellog44.setBounds(400,90,310,40);
		labellog44.setText("les  (@ or .com)  ne sont pas trouvés!");//3
		labellog44.setForeground(Color.red);
		labellog44.setVisible(false);
		
		labellog45=new JLabel();
		labellog45.setBounds(400,150,250,30);
		labellog45.setText("entrer au minimum 8 caractères!");//4
		labellog45.setForeground(Color.red);
		labellog45.setVisible(false);
		

		labellog46=new JLabel();
		labellog46.setBounds(400,300,250,30);
		labellog46.setText("entrer au minimum 8 caractères!");//7
		labellog46.setForeground(Color.red);
		labellog46.setVisible(false);
		
		labellog47=new JLabel();
		labellog47.setBounds(400,350,250,30);
		labellog47.setText("(YYYY-MM-DD) format !");//8
		labellog47.setForeground(Color.red);
		labellog47.setVisible(false);
		
		labellog48=new JLabel();
		labellog48.setBounds(400,450,250,30);
		labellog48.setText("exemple: 'génie-informatique'");//8
		labellog48.setForeground(Color.red);
		labellog48.setVisible(false);
		
		labellog49=new JLabel();
		labellog49.setBounds(180,310,250,30);
		labellog49.setText("*nom prenom");//8
		//labellog49.setForeground(Color.red);
		labellog49.setVisible(true);
		
		
		
	
	
	
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
	
		
		
	
		
		
		

		
		
		
		
		
		//Panel
		
		
		
		
		
		panelRadio=new JPanel();
		panelRadio.setLayout(new GridLayout(1,2));
		panelRadio.add(rd1);
		panelRadio.setBounds(100,540,270,40);
		panelRadio.add(rd2);
		panelRadio.setBackground(Color.white);
		panelRadio.setBorder(feild17B);
		
		
		PasswRecovPanel=new JPanel();
		PasswRecovPanel.setBackground(Color.white);
		PasswRecovPanel.setBounds(100, 60, 560, 590);
		PasswRecovPanel.add(labellog26);
		PasswRecovPanel.setLayout(null);
		PasswRecovPanel.setVisible(false);
		PasswRecovPanel.add(labellog27);
		PasswRecovPanel.add(field13);
		PasswRecovPanel.add(labellog28);
		PasswRecovPanel.add(field15);
		PasswRecovPanel.add(labellog29);
		PasswRecovPanel.add(field14);
		PasswRecovPanel.add(RecoverPass);
		PasswRecovPanel.setBorder(brd);
		PasswRecovPanel.add(MainNotRecoverPass);
		PasswRecovPanel.add(labellog30);
		PasswRecovPanel.add(labellog31);
		
		
		PasswUpdatePanel=new JPanel();
		PasswUpdatePanel.setBackground(Color.white);
		PasswUpdatePanel.setBounds(100, 60, 560, 600);
	//	PasswUpdatePanel.add(labellog32);
		PasswUpdatePanel.setLayout(null);
		PasswUpdatePanel.setVisible(false);
		PasswUpdatePanel.setBorder(brd);
		PasswUpdatePanel.add(field16);
		PasswUpdatePanel.add(field17);
		PasswUpdatePanel.add(field18);
		PasswUpdatePanel.add(field19);
		PasswUpdatePanel.add(labellog33);
		PasswUpdatePanel.add(labellog34);
		PasswUpdatePanel.add(labellog35);
		PasswUpdatePanel.add(labellog36);
		PasswUpdatePanel.add(labellog37);
		PasswUpdatePanel.add(labellog38);
		PasswUpdatePanel.add(labellog39);
		PasswUpdatePanel.add(labellog40);
		PasswUpdatePanel.add(labellog41);
		PasswUpdatePanel.add(labellog42);
		PasswUpdatePanel.add(labellog43);
		PasswUpdatePanel.add(labellog35);
		PasswUpdatePanel.add(MainNotUpdatePass);
		PasswUpdatePanel.add(MainUpdatePass);
		
		
		
		
		
	
		
		
		
		panellog=new JPanel();
		panellog.setBackground(Color.white);
		panellog.setBounds(70, 70, 600, 580);
		panellog.setLayout(null);
		panellog.add(logButn);
		panellog.add(signButn);
		panellog.add(labellog1);
		panellog.add(field1);
		panellog.add(labellog2);
		panellog.add(field2);
		panellog.add(see_passw);
		panellog.add(MainLogin);
		panellog.setBorder(feild6B);
		panellog.add(field11);
		panellog.add(labellog12);
		panellog.add(labellog23);
		panellog.add(labellog24);
		panellog.add(UpdatePass);
		panellog.add(labellog49);
		panellog.setVisible(true);
		
		//panellog.add(PasswRecovPanel);
		
	
		
		panelsign=new JPanel();
		panelsign.setBackground(Color.white);
		panelsign.setBounds(70, 70, 600, 580);
		panelsign.add(signButn2);
		panelsign.setLayout(null);
		panelsign.setBorder(feild8B);
		panelsign.add(labellog4);
		panelsign.add(field3);
		panelsign.add(labellog5);
		panelsign.add(field4);
		panelsign.add(labellog6);
		panelsign.add(field5);
		panelsign.add(labellog7);
		panelsign.add(labellog3);
		panelsign.add(labellog8);
		panelsign.add(labellog9);
		panelsign.add(labellog10);
		panelsign.add(labellog11);
		panelsign.add(field6);
		panelsign.add(field7);
		panelsign.add(field8);
		panelsign.add(field9);
		panelsign.add(field10);
		panelsign.add(finition);
		panelsign.add(labellog16);
		panelsign.add(MainSign);
		panelsign.add(panelRadio);
		panelsign.add(labellog17);
		panelsign.add(labellog18);
		panelsign.add(labellog19);
		panelsign.add(labellog20);
		panelsign.add(labellog21);
		panelsign.add(labellog22);
		panelsign.add(labellog25);
		panelsign.add(labellog44);
		panelsign.add(labellog45);
		panelsign.add(labellog46);
		panelsign.add(labellog47);
		panelsign.add(labellog48);
		panelsign.add(field12);
		//panelsign.add(MainNotSign);
		
		
		
		
		
		panelL=new JPanel();
		panelL.setBackground(Color.white);
		panelL.setBounds(0, 0, 800, 800);
		panelL.setLayout(null);
		panelL.add(panellog);
		panelL.add(PasswRecovPanel);
		panelL.add(PasswUpdatePanel);
		
		
		
		
		panelS=new JPanel();
		panelS.setBackground(Color.white);
		panelS.setBounds(0, 0, 800, 800);
		panelS.setLayout(null);
		panelS.add(panelsign);
		panelS.setVisible(false);
		panelS.add(MainNotSign);
		
	
		
	
		
		
		
		
	
		
		
		
		
		
		
		
			
		
		
		
	
		
		
		//panelsign.add(field5);
		
	
		
		
		
		
	
		//FRAME
		FrameL=new JFrame();
	    FrameL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    FrameL.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    FrameL.setVisible(true);
	    FrameL.getContentPane().setBackground(Color.WHITE);
	    FrameL.setLayout(null);
	    FrameL.add(panelL);
	    FrameL.add(panelS);
	    FrameL.add(labelL);
	    //labelL
	    
	   
	    
	    
	    //Connection base de donnee
	    
	    
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    cont=DriverManager.getConnection("jdbc:mysql://localhost:3306/absence","HAJAR","alouahajar2002");
	    st=cont.createStatement();
	    
	    
	    //Pane
	    
		UIManager UI=new UIManager();
		UI.put("OptionPane.background", new Color(31,65,102,255));
		UI.put("panel.background", new Color(31,65,102,255));
	    


	}
	
   
	
	public void mouseClicked(MouseEvent e) {
		/*
		 field16=new JTextField();
				field16.setBounds(150,200,270,40);
				field16.setBorder( feild21B);
				field16.setBackground(Color.white);
				field16.setForeground(new Color(31,65,102,255));
				
				field17=new JPasswordField();
				field17.setBounds(150,280,270,40);
				field17.setBorder( feild22B);
				field17.setBackground(Color.white);
				field17.setForeground(new Color(31,65,102,255));
				
				field18=new JPasswordField();
				field18.setBounds(150,360,270,40);
				field18.setBorder( feild19B);
				field18.setBackground(Color.white);
				field18.setForeground(new Color(31,65,102,255));
				
				
				field19=new JPasswordField();
				field19.setBounds(150,440,270,40);
				field19.setBorder( feild20B);
				field19.setBackground(Color.white);
				field19.setForeground(new Color(31,65,102,255));
				
				String PasswordUp="";
	String NewPasswordUp="";
	String ConfirmNewPasswordUp="";
				
		 */
		if(e.getSource()==MainUpdatePass) {
			PasswordUp="";
			NewPasswordUp="";
			ConfirmNewPasswordUp="";
			System.out.println(1);
			brd2=BorderFactory.createLineBorder(Color.RED);
			Border brd3=BorderFactory.createLineBorder(Color.BLUE);
			feild19B=BorderFactory.createTitledBorder(brd2,"Nouveu PassWord");
			feild20B=BorderFactory.createTitledBorder(brd2,"Confirmer Nouveau PassWord");
			feild22B=BorderFactory.createTitledBorder(brd2,"Password");
			//Password
			Character asci2;
			char[] passwrd2=field17.getPassword();
			for(int i : passwrd2) {
				asci2= (char) i;
				PasswordUp+=asci2;
			}
			
			//NEW password
			Character asci;
			char[] passwrd=field18.getPassword();
			for(int i : passwrd) {
				asci= (char) i;
				NewPasswordUp+=asci;
			}
			
		  //Confirm Paswword
			Character asci3;
			char[] passwrd3=field19.getPassword();
			for(int i : passwrd3) {
				asci3= (char) i;
				ConfirmNewPasswordUp+=asci3;
			}

		   //check empty field
			if(PasswordUp.equals("")) {
				labellog38.setVisible(true);
				field17.setBorder(feild22B);
			}
			
			if(!PasswordUp.equals(""))
			{   
				labellog38.setVisible(false);
				feild22B=BorderFactory.createTitledBorder(brd2,"Password");
				field17.setBorder(feild22B);
			}
			System.out.println(labellog38.isVisible()+""+3);
			if(NewPasswordUp.equals("")) {
				labellog39.setVisible(true);
				field18.setBorder(feild19B);
			}
			if(!NewPasswordUp.equals("")) {
				labellog39.setVisible(false);
				feild19B=BorderFactory.createTitledBorder(brd2,"Nouveu PassWord");
				field18.setBorder(feild19B);
				
			}
			if(!NewPasswordUp.equals(ConfirmNewPasswordUp))
			{   System.out.println(NewPasswordUp+1);
			System.out.println(ConfirmNewPasswordUp+2);
				labellog43.setVisible(true);
			}
			if(NewPasswordUp.equals(ConfirmNewPasswordUp))
			{System.out.println(NewPasswordUp+11);
			System.out.println(ConfirmNewPasswordUp+22);
				labellog43.setVisible(false);
			}
			
			if(ConfirmNewPasswordUp.equals("")) {
				labellog40.setVisible(true);
				field19.setBorder(feild20B);
			}
			
			if(!ConfirmNewPasswordUp.equals("")) {
				labellog40.setVisible(false);
				
			}
			
			if(PasswordUp.equals(ConfirmNewPasswordUp))
			{
				labellog37.setVisible(true);
			}
			
			if(!PasswordUp.equals(ConfirmNewPasswordUp))
			{
				labellog37.setVisible(false);
			}
			if(!ConfirmNewPasswordUp.equals("")&&NewPasswordUp.equals(ConfirmNewPasswordUp))
			{
				feild20B=BorderFactory.createTitledBorder(brd2,"Confirmer Nouveau PassWord");
				field19.setBorder(feild20B);
			}
			if( NewPasswordUp.length()<8) {
				labellog36.setVisible(true);
			}
			if( NewPasswordUp.length()>=8) {
				labellog36.setVisible(false);
			}
			/*
			if(PasswordUp.length()<8 ) {
				labellog35.setVisible(true);
			
			if(PasswordUp.length()>=8 ) {
				labellog35.setVisible(false);
			}
			*/
			if(field16.getText().equals("")) {
			 feild1B=BorderFactory.createTitledBorder(brd2,"Email");
			 field16.setBorder(feild1B);
			 labellog41.setVisible(true);
			 labellog42.setVisible(true);
			
			}
			if(!field16.getText().equals("")) {
				 feild1B=BorderFactory.createTitledBorder(brd2,"Email");
				 field16.setBorder(feild1B);
				 labellog41.setVisible(false);
				 labellog42.setVisible(false);
				
				}
			if(!field16.getText().contains("@")||!field16.getText().contains(".com")) {
				 labellog42.setVisible(true);
			}
			if(field16.getText().contains("@")&&field16.getText().contains(".com")) {
				 labellog42.setVisible(false);
			}
			
            //SQL
			if(!PasswordUp.equals("")&&!field16.getText().equals("")&&!PasswordUp.equals(ConfirmNewPasswordUp)&&NewPasswordUp.equals(ConfirmNewPasswordUp)&&NewPasswordUp.length()>=8) {
			sql="update enseignat set password=? where email=?";
			sql2="select email , password from enseignat";
			Hashtable<String,String> tab1=new Hashtable<>();
			System.out.println("enterde");
			try {
				PreparedStatement st=cont.prepareStatement(sql);
				PreparedStatement st2=cont.prepareStatement(sql2);
				ResultSet rs1=st2.executeQuery();
				while(rs1.next()) {
					tab1.put(rs1.getString(1), rs1.getString(2));
				}
				   if(!tab1.containsValue(PasswordUp)&&!tab1.containsKey(field16.getText())) {
			        	JOptionPane.showMessageDialog(FrameL, " upps! vous netes pas une membre de notre application                                     !  ");
			        }
			        if(!tab1.containsValue(PasswordUp)&&tab1.containsKey(field16.getText())) {
			        	JOptionPane.showMessageDialog(FrameL, " upps! Check vote mot de passe!                 ");
			        }
			        if(!tab1.containsKey(field16.getText())&&tab1.containsValue(PasswordUp)) {
			        	JOptionPane.showMessageDialog(FrameL, " upps! Check votre email!                    ");
			        }
				
		        if(tab1.containsValue(PasswordUp)&&tab1.containsKey(field16.getText())&&tab1.get(field16.getText()).equals(PasswordUp)) {
		        labellog38.setVisible(false);
		        labellog39.setVisible(false);
		        labellog35.setVisible(false);
		        labellog36.setVisible(false);
		        labellog40.setVisible(false);
		        labellog43.setVisible(false);
		        //
		    	feild19B=BorderFactory.createTitledBorder(brd3,"Nouveu PassWord");
				feild20B=BorderFactory.createTitledBorder(brd3,"Confirmer Nouveau PassWord");
				feild22B=BorderFactory.createTitledBorder(brd3,"Password");
				feild1B=BorderFactory.createTitledBorder(brd3,"Email");
				field16.setBorder(feild1B);
				field19.setBorder(feild20B);
				field17.setBorder(feild22B);
				field18.setBorder(feild19B);
				//
				st.setString(1,NewPasswordUp);
				st.setString(2,field16.getText());
				st.executeUpdate();
				JOptionPane.showMessageDialog(FrameL, " Yes! your information are updated !   ");
				}
		     
				
			} 
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
			}
			

       
			
		}
		
		
		//NEW BUTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTON
		if(e.getSource()==MainNotUpdatePass) {
			panellog.setVisible(true);
			PasswUpdatePanel.setVisible(false);
			labelL.setIcon(imgeLN);
		}
		
		
		
		//NEW BUTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTON
		if(e.getSource()==UpdatePass) {
			panellog.setVisible(false);
			PasswUpdatePanel.setVisible(true);
			labelL.setIcon(imgelog15);
		}
		
		
		//NEW BUTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTON
		if(e.getSource()==MainNotRecoverPass) {
			PasswRecovPanel.setVisible(false);
			panellog.setVisible(true);
			labelL.setIcon(imgeLN);
		}
		
		
		//NEW BUTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTON
		if(e.getSource()==RecoverPass) {
			String NomPrenom=field13.getText();
			if(!NomPrenom.equals("")) {
			 NomR= NomPrenom.split("\\s+")[0];
			 PrenomR= NomPrenom.split("\\s+")[1];
			}
			 EmailR=field14.getText();
			if(NomR.equals("")||PrenomR.equals("")) {
				brd=BorderFactory.createLineBorder(Color.RED);
				feild16B=BorderFactory.createTitledBorder(brd,"Nom Complet");
				 field13.setBorder(feild16B);
				 labellog30.setVisible(true);
				 
			}
			if(EmailR.equals("")) {
				brd=BorderFactory.createLineBorder(Color.RED);
				 feild1B=BorderFactory.createTitledBorder(brd,"Email");
				 field14.setBorder(feild1B);
				 labellog31.setVisible(true);
				
			}
			
			if(!NomR.equals("")&&!PrenomR.equals("")&&!EmailR.equals("")) {
				if(EmailR.equals(EMaiL)) {
				try {
					nomC = new  SQLtraitement().getEnseignat(EmailR).get(1)+" "+new  SQLtraitement().getEnseignat(EmailR).get(2);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(nomC.equals(NomR+" "+PrenomR )){
				
				brd=BorderFactory.createLineBorder(Color.BLUE);
				feild16B=BorderFactory.createTitledBorder(brd,"Nom Complet");
				 field13.setBorder(feild16B);
				 labellog30.setVisible(false);
				 
				 feild1B=BorderFactory.createTitledBorder(brd,"Email");
				 field14.setBorder(feild1B);
				 labellog31.setVisible(false);
				 
				 
			try {
				PreparedStatement st1=cont.prepareStatement("select password from enseignat where nom=? and email=? ;");
				st1.setString(1, NomR);
				st1.setString(2,  EmailR);
				ResultSet rs1=st1.executeQuery();
				String pass = "";
				while(rs1.next()) {
					pass=rs1.getString(1);
				}
				JOptionPane.showMessageDialog(FrameL, "votre mote de passe est "+pass,"password revealing",JOptionPane.INFORMATION_MESSAGE);;
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 
			panellog.setVisible(true);
			 PasswRecovPanel.setVisible(false);
			 labelL.setIcon(imgeLN);
			}
				else {
					JOptionPane.showMessageDialog(FrameL, " upps! Check la forme ou l'ortho de votre nom complet!            ");
				}
				}
				else {
					JOptionPane.showMessageDialog(FrameL, " upps! Check votre email!               ");
				}
				}
			
		
		//	JOptionPane.showMessageDialog(FrameL, "your password is "+passWord,"password revealing",JOptionPane.INFORMATION_MESSAGE);;
		}
		
		
		
		
		//NEW BUTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTON
		if(e.getSource()==MainNotSign) {
			panelL.setVisible(true);
			panelS.setVisible(false);
			
			 
			
		//	JOptionPane.showMessageDialog(FrameL, "your password is "+passWord,"password revealing",JOptionPane.INFORMATION_MESSAGE);;
		}
		
		
		
		
		//NEW BUTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTON
		if(e.getSource()==MainLogin) {
			try {
				tab2=new SQLtraitement().Admin();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			tab=new Hashtable<>();
			Password="";
			Character asci2;
			char[] passwrd2=field2.getPassword();
			for(int ii : passwrd2) {
				asci2= (char) ii;
				 Password+=asci2;
				 }
			 NomComp=field11.getText();
			 EMaiL=field1.getText();
			 
			 try {
				rs=st.executeQuery("select email , password from enseignat");
				while(rs.next()) {
					tab.put(rs.getString(1), rs.getString(2));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//         
			 
			 if(tab2.containsKey(EMaiL)&&tab2.containsValue(Password)&&tab2.get(EMaiL).equals(Password)) {
				 
					try {
						nomC = new  SQLtraitement().GetAdministrateur(EMaiL, Password).get(1)+" "+new  SQLtraitement().GetAdministrateur(EMaiL, Password).get(2);
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					 if(nomC.equals(NomComp)) {
					 System.out.println("your loged in");
					 brd=BorderFactory.createLineBorder(Color.BLUE);
					 feild1B=BorderFactory.createTitledBorder(brd,"Email");
					 field1.setBorder(feild1B);
					 feild2B=BorderFactory.createTitledBorder(brd,"PassWord");
					 field2.setBorder(feild2B);
					 labellog24.setVisible(false);
					 labellog23.setVisible(false);
					 JOptionPane.showMessageDialog(FrameL, " Yes! you are logged in");
					
					try {
						HelpAbsence aa=new HelpAbsence();
						aa.setvalueNomC(NomComp);
						aa.setvaluePass(Password);
						aa.setvalueEmail(EMaiL);
                        Administration admin=new Administration();
                        admin.field1.setText(NomComp);
						FrameL.dispose();
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				/*	Gestion.SetLoginName(NomComp);
					ArrayList<String> tab1=new ArrayList<>();
					tab1.add(EMaiL);
					tab1.add(Password);
				    Gestion.setEmailPasww(tab1); */
					
				 }else {
					 JOptionPane.showMessageDialog(FrameL, " upps! check la forme de votre nom complet ou voir l'orthographe                    ");
				 }
					 }
			 
			 
			 
			 ///

			 if(tab.containsKey(EMaiL)&&tab.containsValue(Password)&&tab.get(EMaiL).equals(Password)) {
				 
				try {
					nomC = new  SQLtraitement().getEnseignat(EMaiL, Password).get(1)+" "+new  SQLtraitement().getEnseignat(EMaiL, Password).get(2);
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 if(nomC.equals(NomComp)) {
				 System.out.println("your loged in");
				 brd=BorderFactory.createLineBorder(Color.BLUE);
				 feild1B=BorderFactory.createTitledBorder(brd,"Email");
				 field1.setBorder(feild1B);
				 feild2B=BorderFactory.createTitledBorder(brd,"PassWord");
				 field2.setBorder(feild2B);
				 labellog24.setVisible(false);
				 labellog23.setVisible(false);
				 JOptionPane.showMessageDialog(FrameL, " Yes! you are logged in");
				
				try {
					HelpAbsence aa=new HelpAbsence();
					aa.setvalueNomC(NomComp);
					aa.setvaluePass(Password);
					aa.setvalueEmail(EMaiL);

					GestionGeneral gestion=	new GestionGeneral();
					gestion.SetLoginName(NomComp);
					gestion.setPassword(Password);
					gestion.setEmail(EMaiL);
					ArrayList<String> tabEP=new ArrayList<>();
					tabEP.add(EMaiL);
					tabEP.add(Password);
					gestion.setEmailPasww(tabEP);
					FrameL.dispose();
					
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			/*	Gestion.SetLoginName(NomComp);
				ArrayList<String> tab1=new ArrayList<>();
				tab1.add(EMaiL);
				tab1.add(Password);
			    Gestion.setEmailPasww(tab1); */
				
			 }else {
				 JOptionPane.showMessageDialog(FrameL, " upps! check la forme de votre nom complet ou voir l'orthographe                    ");
			 }
				 }
			 if(!tab.containsKey(EMaiL)&&!tab2.containsKey(EMaiL)) {
				 JOptionPane.showMessageDialog(FrameL, " upps! votre email est erroné          ");
			 }
			
			 if(EMaiL.equals("")) {
				 brd=BorderFactory.createLineBorder(Color.RED);
				 feild1B=BorderFactory.createTitledBorder(brd,"Email");
				 field1.setBorder(feild1B);
				 labellog23.setVisible(true);
			 }
			 if(Password.equals("")) {
				brd=BorderFactory.createLineBorder(Color.RED);
				feild2B=BorderFactory.createTitledBorder(brd,"PassWord");
				field2.setBorder(feild2B);
				labellog24.setVisible(true);
			 }
			 
	
			 if(tab.containsKey(EMaiL)&&!tab.containsValue(Password)) {
				 String[] option= {"Yes","No"};
				 valueJopt1=JOptionPane.showOptionDialog(FrameL, "Pardon votre mot de passe n'est pas correcte, on peut vous aidez pour le récupéré. Vous voulez le récupérer     ","PasswordRecovering", 0, 0, imgelog10, option, option[0]);
				 if(valueJopt1==0) {
					 panellog.setVisible(false);
					 PasswRecovPanel.setVisible(true);
					 labelL.setIcon(imgelog11);
				 }
			 }
			 if(tab2.containsKey(EMaiL)&&!tab2.containsValue(Password)) {
				 String[] option= {"Yes","No"};
				 valueJopt1=JOptionPane.showOptionDialog(FrameL, "Pardon votre mot de passe n'est pas correcte, on peut vous aidez pour le récupéré. Vous voulez le récupérer     ","PasswordRecovering", 0, 0, imgelog10, option, option[0]);
				 if(valueJopt1==0) {
					 panellog.setVisible(false);
					 PasswRecovPanel.setVisible(true);
					 labelL.setIcon(imgelog11);
				 }
			 }
			 
		/*	 if(!tab.containsKey(EMaiL)||!tab.containsValue(Password)) {
				 JOptionPane.showMessageDialog(FrameL, " Error! , Either Password or Email is invalid");
				 
				 
			 }
			 */
			
			
			
			
			 
			 
			 
		}
				
	
		
		//NEW BUTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTON
		
		if(e.getSource()==signButn) {
			signButn.setForeground(new Color(31,65,102,255));
			feild4B=BorderFactory.createMatteBorder(1, 0, 0, 1, new Color(31,65,102,255));
			signButn.setBorder(feild4B);
			panelL.setVisible(false);
			panelS.setVisible(true);
		}
		
		
	   
		
		//NEW BUTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTON
	 if(e.getSource()==MainSign) {
		 ArrayList<String> emaill=new ArrayList<>();
		 ArrayList<String> passwordd=new ArrayList<>();
		 ArrayList<String> codd=new ArrayList<>();
		 brd=BorderFactory.createLineBorder(Color.BLUE);
		 // varibale
		 
		 code=field7.getText();
		 nom=field5.getText();
		 prenom =field6.getText();
		 fonction=field8.getText();
		 status=field10.getText();
		 departement =field9.getText();
		 dateNais=field12.getText();
		 Email=field3.getText();
		 
		 //passWorld
		 passWord="";
			Character asci;
			char[] passwrd=field4.getPassword();
			for(int i : passwrd) {
				asci= (char) i;
				passWord+=asci;
				
			}
		
		// ----------
		 if(Email.equals("")) {
			  brd=BorderFactory.createLineBorder(Color.RED);
			  feild1B=BorderFactory.createTitledBorder(brd,"Email");
			  field3.setBorder(feild1B);
			 labellog17.setVisible(true);
			 labellog44.setVisible(true);
			 
		 }
		 if(!Email.contains("@")||!Email.contains(".com"))
		 {
			 labellog44.setVisible(true);
		 }
		 if(Email.contains("@")&&Email.contains(".com")) {
			 labellog17.setVisible(false);
			 labellog44.setVisible(false);
			 feild1B=BorderFactory.createTitledBorder(brd,"Email");
			 field3.setBorder(feild1B);
		 }
		 if(passWord.equals("")) {
			  brd=BorderFactory.createLineBorder(Color.RED);
			 feild2B=BorderFactory.createTitledBorder(brd,"PassWord");
			 field4.setBorder(feild2B);
			 labellog18.setVisible(true);
			 labellog45.setVisible(true);
		 }
		 if(passWord.length()<8)
		 {
			 labellog45.setVisible(true);
		 }
		 if(passWord.length()>=8) {
			 labellog18.setVisible(false);
			 labellog45.setVisible(false);
			 feild2B=BorderFactory.createTitledBorder(brd,"PassWord");
			 field4.setBorder(feild2B);
		 }
	
		 if(nom.equals("")) {
			 brd=BorderFactory.createLineBorder(Color.RED);
			 feild10B=BorderFactory.createTitledBorder(brd,"Nom");
			 field5.setBorder(feild10B);
			 labellog19.setVisible(true);
		 }
		 if(!nom.equals("")) {
			 labellog19.setVisible(false);
			 feild10B=BorderFactory.createTitledBorder(brd,"Nom");
			 field5.setBorder(feild10B);
		 }
		 
		 if(prenom.equals("")) {
			 brd=BorderFactory.createLineBorder(Color.RED);
			 feild11B=BorderFactory.createTitledBorder(brd,"Prenom");
			 field6.setBorder( feild11B);
			 labellog20.setVisible(true);
		 }
		 if(!prenom.equals("")) {
			 labellog20.setVisible(false);
			 feild11B=BorderFactory.createTitledBorder(brd,"Prenom");
			 field6.setBorder( feild11B);
		 }
		 
		 if(code.equals("")) {
			 brd=BorderFactory.createLineBorder(Color.RED);
			 feild12B=BorderFactory.createTitledBorder(brd,"Enseignant Code");
			 field7.setBorder(feild12B);
			 labellog21.setVisible(true);
			 labellog46.setVisible(true);
		 }
		 if(code.length()!=8) {
			 labellog46.setVisible(true); 
		 }
		 if(code.length()==8) {
			 labellog21.setVisible(false);
			 labellog46.setVisible(false);
			 feild12B=BorderFactory.createTitledBorder(brd,"Enseignant Code");
			 field7.setBorder(feild12B);
		 }
		if(dateNais.equals("")) {
			 brd=BorderFactory.createLineBorder(Color.RED);
			 feild18B=BorderFactory.createTitledBorder(brd,"Date De Naissance");
			 field12.setBorder(feild18B);
			 labellog22.setVisible(true);
			 labellog47.setVisible(true);
		}
		if(!dateNais.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
			labellog47.setVisible(true);
		}
		if(dateNais.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
			 labellog22.setVisible(false);
			 labellog47.setVisible(false);
			 feild18B=BorderFactory.createTitledBorder(brd,"Date De Naissance");
			 field12.setBorder(feild18B);
		}
		if(departement.equals("")) {
			 brd=BorderFactory.createLineBorder(Color.RED);
			 feild14B=BorderFactory.createTitledBorder(brd,"Departement");
			 field9.setBorder(feild14B);
			 labellog25.setVisible(true);
			 labellog48.setVisible(true);
		 }
		if(!departement.equals("")) {
			 labellog25.setVisible(false);
			 feild14B=BorderFactory.createTitledBorder(brd,"Departement");
			 field9.setBorder(feild14B);
			 labellog48.setVisible(false);
		}
		//------------
		
		  if(dateNais.matches("\\d{4}-\\d{1,2}-\\d{1,2}")&&code.length()==8&&passWord.length()>=8&&Email.contains("@")&&Email.contains(".com")&&!nom.equals("")&&!prenom.equals("")) {
	       sql="insert into enseignat values(?,?,?,?,?,?,?,?,?,?);";
		
			try {
				PreparedStatement st3=cont.prepareStatement("select email ,password,code,nom,prenom from enseignat;");
				ResultSet rs1=st3.executeQuery();
				while(rs1.next()) {
					emaill.add(rs1.getString(1));
					passwordd.add(rs1.getString(2));
					codd.add(rs1.getString(3));
					
				}
				System.out.println(!codd.contains(code));
				System.out.println(!passwordd.contains(passWord));
				System.out.println(!emaill.contains(Email));
				if(!codd.contains(code)&&!emaill.contains(Email)&&!passwordd.contains(passWord)) {
				st2=cont.prepareStatement(sql);
				st2.setInt(1, Integer.parseInt(code));
				st2.setString(2, nom);
				st2.setString(3, prenom);
				st2.setString(4, fonction);
				st2.setString(5, radioButtonValue);
				st2.setString(6, status);
				st2.setString(7, departement);
				LocalDate date=LocalDate.parse(dateNais);
				st2.setDate(8, Date.valueOf(date));
				st2.setString(9, Email);
				st2.setString(10, passWord);
				st2.execute();
				}
				if(codd.contains(code)||emaill.contains(Email)||passwordd.contains(passWord)) {
					System.out.println("contains either email,or code or password");
				}
				
			} catch (SQLException e1) {
	
				e1.printStackTrace();
			}
			try {
				st2.execute();
			} catch (SQLException e1) {
		
				e1.printStackTrace();
			}
			
			//-----
			String[] option={"Ok"};
			JOptionPane.showOptionDialog(FrameL, "You are SIGN UP successfully      ","Result", 0, 0, imgelog14, option, null);
			 
			 
			 
			 
			 
		
			/* 
			 
			 labellog25.setVisible(false);
			labellog22.setVisible(false);
			 labellog21.setVisible(false);
			 labellog20.setVisible(false);
			 labellog19.setVisible(false);
			 labellog18.setVisible(false);
			 labellog17.setVisible(false);
			 labellog44.setVisible(false);
			 labellog45.setVisible(false);
			 labellog46.setVisible(false);
			 labellog47.setVisible(false);*/
			 
			
		  }
		  
			
	     }
		
			
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
		if(e.getSource()==signButn) {
			signButn.setForeground(new Color(31,65,102,255));
			feild4B=BorderFactory.createMatteBorder(1, 0, 0, 1, new Color(31,65,102,255));
			signButn.setBorder(feild4B);
		}
		
	
		
	}
	
	
	
@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==signButn) {
			signButn.setForeground(Color.lightGray);
			feild4B=BorderFactory.createMatteBorder(1, 0, 0,1 , Color.LIGHT_GRAY);
			signButn.setBorder(feild4B);
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		//------------

				if(e.getSource()==rd1) {
					
					radioButtonValue=rd1.getText();
					

				}
				
				//---------------
				
				 if(e.getSource()==rd2) {
					radioButtonValue=rd2.getText();
					
				}
				
			    //----------
		 
		if(e.getSource()==see_passw ) {
			passWord="";
			Character asci;
			char[] passwrd=field2.getPassword();
			for(int i : passwrd) {
				asci= (char) i;
				passWord+=asci;
				
			}
		JOptionPane.showMessageDialog(FrameL, "your password is "+passWord,"password revealing",JOptionPane.INFORMATION_MESSAGE);;
		
		}
		
		
	}

}
