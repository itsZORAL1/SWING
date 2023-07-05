package MAIN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import SQL.SQLtraitement;
import Stylingfolder.AlternatingRowColorRenderer;
import Stylingfolder.ButtonPanel;
import Stylingfolder.ButtonPanelAbsence;
import Stylingfolder.ButtonPanelAdmin;
import Stylingfolder.ButtonPanelJustification;
import Stylingfolder.ButtonPanelSanction;
import Stylingfolder.ButtonPanelnote;
import Stylingfolder.CellEditor;
import Stylingfolder.CellEditorAdmin;
import Stylingfolder.CellEditorNote;
import Stylingfolder.CellEditorSanction;
import Stylingfolder.CellEditorabsence;
import Stylingfolder.CustomButton;
import Stylingfolder.CustomComboBoxRenderer;
import Stylingfolder.TrianglePanel;
import Stylingfolder.cellEditorJustification;

public class Administration  implements MouseListener,ActionListener {

	JFrame frame ;
	private Properties config;
	JPanel bar;
	JButton enseignatB_header;
	JPanel moduleP;
	JButton moduleB;
	JLabel labelmodule;
	ImageIcon  iconmodule;
	ImageIcon  imageIcon5;
	ImageIcon  imageIcon1;
	ImageIcon  imageIcon2;
	ImageIcon  imageIcon3;
	ImageIcon  imageIcon4;
	ImageIcon  imageIconProfile;
	ImageIcon   imageIcon6;
	ImageIcon   imageIcon7;
	ImageIcon   imageIcon8;
	ImageIcon   imageIcon9;
	ImageIcon   imageIcon10;
	ImageIcon imgelog11;
	ImageIcon icon;
	ImageIcon iconS;
	JPanel module_center;
	
	JButton NotCheck;
    JButton  Profile;
    JButton ProfileImage;
    JLabel label9;
	JPanel Horizantalbar;
	JPanel centerbar;
	JPanel CenterPanel_Center;
	JPanel CenterPanel_Header;
	JButton  btn2;
	JLabel label5;
	JLabel label4;
	public JTextField  field1;
	JPanel  Updateletter;
	TrianglePanel triagnePanelPage;
	CustomButton Choose;
	TrianglePanel triagnePanel;
	JPanel ProfilePanel;
	JTextField  NomComplet;
	JTextField fieldniveau;
	JTextField fieldmodule;
	JTextField  Email;
	JTextField  enseignatCode;
	JTextField  DateDeNaissance;
	JTextField Departement;
	JTextField  EmailUpdate;
	JTextField  enseignatCodeUpdate;
	JTextField  DateDeNaissanceUpdate;
	JTextField  Nom;
	JTextField Prenom;
	JTextField FonctionUpdate;
	JTextField  EtatUpdate;
	JTextField  StatusUpdate;
	JPasswordField    PassWordUpdate;
	JButton  openlettre;
	CustomButton RME; 
	CustomButton RMN; 
	JLabel label2;
	JButton Check;
	Border feild1B;
	Border feild2B;
	Border brd;
	Border brd1;
	Border feildB;
	Border feild3B;
	Border feild4B;
	Border feild5B;
	TitledBorder feildEmailB;
	TitledBorder feildNomCompletB;
	TitledBorder feildDateNaissanceB;
	TitledBorder feildEnseiCodeB;
	TitledBorder feildDepartementB;
	JButton  BModule;
	JButton  moduleB_header;
	JLabel labelAFMN;
	JLabel labelAFME;
	JLabel labelmodule1;
	
	TitledBorder feildEmailBUpdate;
	TitledBorder feildNomBUpdate;
	TitledBorder feildPrenomBUpdate;
	TitledBorder feildDateNaissanceBUadte;
	TitledBorder feildEnseiCodeBUpdate;
	TitledBorder feildDepartementUpdateB;
	TitledBorder feildFonctionUpdateB;
	TitledBorder feildEtatUpdateB;
	TitledBorder feildStatusUpdateB;
	TitledBorder feildPassWordUpdateB;
	TitledBorder feildniveauB;
    TitledBorder feildmoduleB;
    JPanel module_header;
    JLabel ModuleEntree;
    ImageIcon iconmoduleentree;
    ImageIcon deletePN;
    ImageIcon 	deletePM;
   JButton  plusniveau;   
	JButton  labelDM;
	JButton labelDN;
	JButton plusmodule;
	JComboBox Combomodule1;
	JComboBox Combomodule2;
	JComboBox Comboniveau;
	JComboBox Comboenseig;
	JPanel enseignat_header;
	JButton Benseignat;
	JButton ensB;
	JPanel enseignatP;
	JPanel enseignant_center;
	JRadioButton radioasc;
	JRadioButton radiodesc;
	JRadioButton radiodate;
	JRadioButton radioNom;
	JRadioButton radioPrenom;
	JRadioButton radioCne;
	JRadioButton radioApogge;
	JRadioButton radioId;
	 ButtonGroup groupR;
	 JScrollBar  scrollbar;
	 ButtonGroup groupR2;
	ArrayList arryEnseignt;
	 JTable ensei;
	 public DefaultTableModel dtm;
	 String[]fields= {"CNE","Nom","Prenom","Fonction","Etat","Status","Départ","DateN","Email","Password"};

	 JScrollPane scroll;
	
public Administration() throws SQLException {
	
	dtm=new DefaultTableModel (new SQLtraitement().administration(), fields) {
		 @Override
		  public Class<?> getColumnClass(int columnIndex) {
		    return JButton.class;
		  }
		@Override
		 public boolean isCellEditable(int row,int column) {
			if(column==10)
			{ 
				return true;
			}
			else {
				return false;
			}
		 }
	};
	dtm.addColumn("Action");
	ensei=new JTable(dtm);
	ensei.setAutoCreateColumnsFromModel(false);
	
	
	
	
	scroll=new JScrollPane(ensei);
	
	ensei.getTableHeader().setBackground(new Color(31,65,102,255));
	ensei.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	ensei.getTableHeader().setForeground(new Color(217,229,255,255));
   
	ensei.getTableHeader().setBorder(feild2B);
 
	ensei.getColumnModel().getColumn(10).setCellRenderer(new ButtonPanelAdmin(ensei));
	ensei.getColumnModel().getColumn(10).setCellEditor(new CellEditorAdmin(ensei));
    
 
	ensei.getTableHeader().setAlignmentX(JTable.CENTER_ALIGNMENT);

    int columnIndex = 8; // index of the second column
    int preferredWidth = 150; // new preferred width in pixels*

    TableColumn column =ensei.getColumnModel().getColumn(columnIndex);
    column.setPreferredWidth(preferredWidth);
    ensei.setRowHeight(40);
    
   


     
      
           
  

  	 
   	 scrollbar = new JScrollBar(JScrollBar.VERTICAL);
     scrollbar.setPreferredSize(new Dimension(20, 0));
     scrollbar.setBackground(Color.GRAY);
     scrollbar.setForeground(Color.BLUE);
     scrollbar.setUI(new BasicScrollBarUI() {
         @Override
         protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
             g.setColor(new Color(31,65,102,255));
             g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
         }
         @Override
         protected JButton createDecreaseButton(int orientation) {
             JButton button = new JButton();
             button.setPreferredSize(new Dimension(20, 15));
             button.setBackground(Color.LIGHT_GRAY);
             button.setForeground(Color.BLUE);
             button.setBorderPainted(false);
             return button;
         }
         @Override
         protected JButton createIncreaseButton(int orientation) {
             JButton button = new JButton();
             button.setPreferredSize(new Dimension(20, 15));
             button.setBackground(Color.LIGHT_GRAY);
             button.setForeground(Color.BLUE);
             button.setBorderPainted(false);
             return button;
         }
     });
     
 	
     
    
     
     ensei.setPreferredScrollableViewportSize(new Dimension(500,500));
     ensei.setGridColor(new Color(31,65,102,255));
     ensei.setShowHorizontalLines(true);
     ensei.setShowVerticalLines(false);
     ensei.setDefaultRenderer(Object.class, new AlternatingRowColorRenderer());
     ensei.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
     
  



  






   //  scroll.setBackground(Color.WHITE);
     scroll.setBounds(70, 90, 900, 410);
     scroll.setVerticalScrollBar(scrollbar);
     
  
	
	
	
	//Border
		feild1B=BorderFactory.createMatteBorder(1, 0, 0, 1, new Color(31,65,102,255));
		feildB=BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(31,65,102,255));
		feild2B=BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(31,65,102,255));
		feild3B=BorderFactory.createMatteBorder(1, 1, 0, 1, new Color(31,65,102,255));
		
		brd=BorderFactory.createLineBorder(Color.WHITE);
		brd1=BorderFactory.createLineBorder(new Color(31,65,102,255));
		
		
	    feildEmailBUpdate=BorderFactory.createTitledBorder(brd1,"Email");
	     feildniveauB=BorderFactory.createTitledBorder(brd1,"Niveau");
	     feildmoduleB=BorderFactory.createTitledBorder(brd1,"Module");
	    feildNomBUpdate=BorderFactory.createTitledBorder(brd1,"Nom");
		feildPrenomBUpdate=BorderFactory.createTitledBorder(brd1,"Prenom");
		feildDateNaissanceBUadte=BorderFactory.createTitledBorder(brd1,"Date De Naissance");
		feildEnseiCodeBUpdate=BorderFactory.createTitledBorder(brd1,"Administrateur Code");
		feildDepartementUpdateB=BorderFactory.createTitledBorder(brd1,"Département");
		
		feildFonctionUpdateB=BorderFactory.createTitledBorder(brd1,"Fonction");
		feildEtatUpdateB=BorderFactory.createTitledBorder(brd1,"Etat Civil");
		feildStatusUpdateB=BorderFactory.createTitledBorder(brd1,"Status");
		feildPassWordUpdateB=BorderFactory.createTitledBorder(brd1,"PassWord");
		
		feildEmailBUpdate.setTitleColor(new Color(31,65,102,255));
		feildNomBUpdate.setTitleColor(new Color(31,65,102,255));
		feildPrenomBUpdate.setTitleColor(new Color(31,65,102,255));
		feildDateNaissanceBUadte.setTitleColor(new Color(31,65,102,255));
		feildEnseiCodeBUpdate.setTitleColor(new Color(31,65,102,255));
		feildDepartementUpdateB.setTitleColor(new Color(31,65,102,255));
		feildFonctionUpdateB.setTitleColor(new Color(31,65,102,255));
		feildEtatUpdateB.setTitleColor(new Color(31,65,102,255));
		feildStatusUpdateB.setTitleColor(new Color(31,65,102,255));
		feildPassWordUpdateB.setTitleColor(new Color(31,65,102,255));
		
		
		
		feildEmailB=BorderFactory.createTitledBorder(brd,"Email");
		feildNomCompletB=BorderFactory.createTitledBorder(brd,"Nom Complet");
		feildDateNaissanceB=BorderFactory.createTitledBorder(brd,"Date De Naissance");
		feildEnseiCodeB=BorderFactory.createTitledBorder(brd,"Administrateur Code");
		feildDepartementB=BorderFactory.createTitledBorder(brd,"Département");
		
		feildEmailB.setTitleColor(Color.WHITE);
		feildNomCompletB.setTitleColor(Color.WHITE);
		feildDateNaissanceB.setTitleColor(Color.WHITE);
		feildEnseiCodeB.setTitleColor(Color.WHITE);
		feildDepartementB.setTitleColor(Color.WHITE);
	iconmodule=new ImageIcon("C:\\Users\\dell\\Documents\\module.png");
	Image imgelogM=iconmodule.getImage();
	iconmodule=new ImageIcon(imgelogM.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
	
	labelmodule=new JLabel();
	labelmodule.setIcon(iconmodule);
	labelmodule.setBounds(20, 3, 40, 40);
	
	labelmodule1=new JLabel();
	labelmodule1.setIcon(iconmodule);
	labelmodule1.setBounds(20, 3, 40, 40);
	
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
	moduleP.add(labelmodule1);
	moduleP.add(moduleB);
	moduleP.setBounds(0, 350, 300, 60);
	
	
	
	 
	
	
	
	imageIcon1=new ImageIcon("C:\\Users\\dell\\Documents\\white_laptop.png");
	Image imgelog1N=imageIcon1.getImage();
	imageIcon1 =new ImageIcon(imgelog1N.getScaledInstance(30,30, Image.SCALE_SMOOTH));
	
	imageIcon2=new ImageIcon("C:\\Users\\dell\\Documents\\GestionGeneral_Theme.png");
	Image imgelog2N=imageIcon2.getImage();
	imageIcon2 =new ImageIcon(imgelog2N.getScaledInstance(200,200, Image.SCALE_SMOOTH));
	
	imageIcon3=new ImageIcon("C:\\Users\\dell\\Documents\\Student_icon.png");
	Image imgelog3N=imageIcon3.getImage();
	imageIcon3 =new ImageIcon(imgelog3N.getScaledInstance(40,40, Image.SCALE_SMOOTH));
	
	imgelog11=new ImageIcon("C:\\Users\\dell\\Documents\\not_check_image.png");
	Image imgelog11N=imgelog11.getImage();
	imgelog11 =new ImageIcon(imgelog11N.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	imageIcon4=new ImageIcon("C:\\Users\\dell\\Documents\\Home.png");
	Image imgelog4N=imageIcon4.getImage();
	imageIcon4 =new ImageIcon(imgelog4N.getScaledInstance(35,35,Image.SCALE_SMOOTH));
	
	imageIcon5=new ImageIcon("C:\\Users\\dell\\Documents\\Profile.png");
	Image imgelog5N=imageIcon5.getImage();
	imageIcon5 =new ImageIcon(imgelog5N.getScaledInstance(35,35,Image.SCALE_SMOOTH));
	
	imageIconProfile=new ImageIcon("C:\\Users\\dell\\Documents\\white_profile.png");
	Image imgelogPN=imageIconProfile.getImage();
	imageIconProfile =new ImageIcon(imgelogPN.getScaledInstance(35,35,Image.SCALE_SMOOTH));
	
	
	imageIcon6=new ImageIcon("C:\\Users\\dell\\Documents\\plus_person.png");
	Image imgelog6N=imageIcon6.getImage();
	imageIcon6 =new ImageIcon(imgelog6N.getScaledInstance(35,35,Image.SCALE_SMOOTH));
	
	
	imageIcon7=new ImageIcon("C:\\Users\\dell\\Documents\\Search.png");
	Image imgelog7N=imageIcon7.getImage();
	imageIcon7 =new ImageIcon(imgelog7N.getScaledInstance(35,35,Image.SCALE_SMOOTH));
	
	
	imageIcon8=new ImageIcon("C:\\Users\\dell\\Documents\\pull_down.png");
	Image imgelog8N=imageIcon8.getImage();
	imageIcon8 =new ImageIcon(imgelog8N.getScaledInstance(30,30,Image.SCALE_SMOOTH));
	
	imageIcon9=new ImageIcon("C:\\Users\\dell\\Documents\\profile_enseignt.png");
	Image imgelog9N=imageIcon9.getImage();
	imageIcon9 =new ImageIcon(imgelog9N.getScaledInstance(400,400,Image.SCALE_SMOOTH));
	
	imageIcon10=new ImageIcon("C:\\Users\\dell\\Documents\\circle_check.png");
	Image imgelog10N=imageIcon10.getImage();
	imageIcon10 =new ImageIcon(imgelog10N.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	iconS=new ImageIcon("C:\\Users\\dell\\Documents\\to_right.png");
	Image imgelogSt=iconS.getImage();
	iconS=new ImageIcon(imgelogSt.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	
	iconmodule=new ImageIcon("C:\\Users\\dell\\Documents\\module.png");
	Image imgelogMI=iconmodule.getImage();
	iconmodule=new ImageIcon(imgelogMI.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
	
	
	iconmoduleentree=new ImageIcon("C:\\Users\\dell\\Documents\\ModuleEntree.png");
	Image imgelogMO=iconmoduleentree.getImage();
	iconmoduleentree=new ImageIcon(imgelogMO.getScaledInstance(480, 480, Image.SCALE_SMOOTH));
	
	deletePN=new ImageIcon("C:\\Users\\dell\\Documents\\mins_person.png");
	Image imgelogPN1=deletePN.getImage();
	deletePN=new ImageIcon(imgelogPN1.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
	
	deletePM=new ImageIcon("C:\\Users\\dell\\Documents\\mins_person.png");
	Image imgelogPM1=deletePM.getImage();
	deletePM=new ImageIcon(imgelogPM1.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
	
	 btn2=new JButton();
	 btn2.setIcon(imageIcon4);
	 btn2.setBounds(1080, 2, 35, 35);
	 btn2.setFocusable(false);
	 btn2.setBackground(Color.DARK_GRAY);
	 btn2.addMouseListener(this);
	 btn2.setBorderPainted(false);
	 
	 
	 
	    label9=new JLabel();
		label9.setIcon(imageIcon9);
		label9.setBounds(20,120, 400, 400);
		label9.setVisible(false);
    
		
		label5=new JLabel();
		label5.setIcon(imageIcon5);
		label5.setBounds(1150, 3, 35, 35);
		label5.setBackground(Color.DARK_GRAY);
		
		NotCheck=new JButton();
		NotCheck.setBounds(10,10, 60, 60);
		NotCheck.setIcon(imgelog11);
		NotCheck.addMouseListener(this);
		NotCheck.setBackground(Color.WHITE);
		NotCheck.setBorderPainted(false);
		NotCheck.setVisible(false);
	
	CenterPanel_Header=new JPanel();
	CenterPanel_Header.setBackground(Color.DARK_GRAY);
	CenterPanel_Header.setLayout(new BorderLayout());
	CenterPanel_Header.setBounds(30, 40, 1000,50 );
	CenterPanel_Header.setVisible(false);
	
	
	label4=new JLabel();
	label4.setText("Espace De Traitement");;
	label4.setBounds(20, 3, 200, 40);
	label4.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	label4.setBackground(Color.DARK_GRAY);
	label4.setForeground(Color.WHITE);
	
	Choose= new CustomButton("Select"); 
	Choose.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
	Choose.setPreferredSize(new Dimension(150, 30));
	Choose.setBackground(Color.GRAY);
	Choose.setForeground(Color.WHITE);
	Choose.setBounds(450,510, 140, 40);
	Choose.setFocusable(false);
	Choose.addActionListener(this);

	
	Check=new JButton();
	Check.setBounds(380,500, 60, 60);
	Check.setIcon(imageIcon10);
	Check.addMouseListener(this);
	Check.setBackground(Color.WHITE);
	Check.setBorderPainted(false);
	
	ProfileImage=new JButton();
	ProfileImage.setIcon(imageIcon10);
	ProfileImage.setBounds(100,50, 90, 90);
	ProfileImage.addActionListener(this);
	ProfileImage.setVisible(false);
	ProfileImage.setBackground(Color.WHITE);
	ProfileImage.setBorderPainted(false);
	
	field1=new JTextField();
	field1.setBounds(1190, 3, 160, 30);
	field1.setBackground(Color.DARK_GRAY);
	field1.setForeground(Color.white);
	field1.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	field1.setBorder(null);
	

    NomComplet=new JTextField();
    NomComplet.setBounds(180, 230, 260, 40);
    NomComplet.setBackground(new Color(31,65,102,255));
    NomComplet.setForeground(Color.white);
    NomComplet.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
    NomComplet.setBorder(feildNomCompletB);
    
    
	Email=new JTextField();
	Email.setBounds(180, 290, 260, 40);
	Email.setBackground(new Color(31,65,102,255));
	Email.setForeground(Color.white);
	Email.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	Email.setBorder(feildEmailB);
	
	enseignatCode=new JTextField();
	enseignatCode.setBounds(180, 350, 260, 40);
	enseignatCode.setBackground(new Color(31,65,102,255));
	enseignatCode.setForeground(Color.white);
	enseignatCode.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	enseignatCode.setBorder(feildEnseiCodeB);
	
	
	DateDeNaissance=new JTextField();
	DateDeNaissance.setBounds(180, 410, 260, 40);
	DateDeNaissance.setBackground(new Color(31,65,102,255));
	DateDeNaissance.setForeground(Color.white);
	DateDeNaissance.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	DateDeNaissance.setBorder(feildDateNaissanceB);
	
	Departement=new JTextField();
	Departement.setBounds(180, 470, 260, 40);
	Departement.setBackground(new Color(31,65,102,255));
	Departement.setForeground(Color.white);
	Departement.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	Departement.setBorder(feildDepartementB);

	EmailUpdate=new JTextField();
	EmailUpdate.setBounds(100, 80, 260, 35);
	EmailUpdate.setBackground(Color.WHITE);
	EmailUpdate.setForeground(new Color(31,65,102,255));
	EmailUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	EmailUpdate.setBorder(feildEmailBUpdate);
	
	enseignatCodeUpdate=new JTextField();
	enseignatCodeUpdate.setBounds(100, 130, 260, 35);
	enseignatCodeUpdate.setBackground(Color.WHITE);
	enseignatCodeUpdate.setForeground(new Color(31,65,102,255));
	enseignatCodeUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	enseignatCodeUpdate.setBorder(feildEnseiCodeBUpdate);
	
	
	DateDeNaissanceUpdate=new JTextField();
	DateDeNaissanceUpdate.setBounds(100, 280, 260, 35);
	DateDeNaissanceUpdate.setBackground(Color.WHITE);
	DateDeNaissanceUpdate.setForeground(new Color(31,65,102,255));
	DateDeNaissanceUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	DateDeNaissanceUpdate.setBorder(feildDateNaissanceBUadte);
	
	
	labelAFMN=new JLabel();
	labelAFMN.setText("Affectation Module-Niveau");;
	labelAFMN.setBounds(70, 200, 300, 40);
	labelAFMN.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	labelAFMN.setBackground(Color.white);
	labelAFMN.setForeground(new Color(31,65,102,255));
	labelAFMN.setVisible(false);
	
	labelAFME=new JLabel();
	labelAFME.setText("Affectation Module-Enseignant");
	labelAFME.setBounds(70, 320, 300, 40);
	labelAFME.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	labelAFME.setBackground(Color.white);
	labelAFME.setForeground(new Color(31,65,102,255));
	labelAFME.setVisible(false);
	

	
	Nom=new JTextField();
	Nom.setBorder(feildNomBUpdate);
	Nom.setBounds(100, 180, 260, 35);
	Nom.setBackground(Color.WHITE);
	Nom.setForeground(new Color(31,65,102,255));
	Nom.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));

	
	Prenom=new JTextField();
	Prenom.setBounds(100, 230, 260, 35);
	Prenom.setBackground(Color.WHITE);
	Prenom.setForeground(new Color(31,65,102,255));
	Prenom.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	Prenom.setBorder(feildPrenomBUpdate);
	
	FonctionUpdate=new JTextField();
	FonctionUpdate.setBounds(100, 390, 260, 35);
	FonctionUpdate.setBackground(Color.WHITE);
	FonctionUpdate.setForeground(new Color(31,65,102,255));
	FonctionUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	FonctionUpdate.setBorder(feildFonctionUpdateB);
	
	EtatUpdate=new JTextField();
	EtatUpdate.setBounds(100, 440, 260, 35);
	EtatUpdate.setBackground(Color.WHITE);
	EtatUpdate.setForeground(new Color(31,65,102,255));
	EtatUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	EtatUpdate.setBorder(feildEtatUpdateB);
	
	StatusUpdate=new JTextField();
	StatusUpdate.setBounds(100, 490, 260, 35);
	StatusUpdate.setBackground(Color.WHITE);
	StatusUpdate.setForeground(new Color(31,65,102,255));
	StatusUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	StatusUpdate.setBorder(feildStatusUpdateB);
	
    PassWordUpdate=new JPasswordField();
    PassWordUpdate.setBounds(100, 340, 260, 35);
    PassWordUpdate.setBackground(Color.WHITE);
    PassWordUpdate.setForeground(new Color(31,65,102,255));
    PassWordUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
    PassWordUpdate.setBorder(feildPassWordUpdateB);
    PassWordUpdate.setEditable(false);
	
	Updateletter=new JPanel();
    Updateletter.setBackground(Color.WHITE);
    Updateletter.setBounds(75,50, 450, 580);
    Updateletter.setVisible(false);
    Updateletter.setLayout(null);
    Updateletter.add(EmailUpdate);
    Updateletter.add(enseignatCodeUpdate);
    Updateletter.add(DateDeNaissanceUpdate);
    Updateletter.add(Nom);
    Updateletter.add(Prenom);
    Updateletter.add(FonctionUpdate);
    Updateletter.add(EtatUpdate);
    Updateletter.add(StatusUpdate);
    Updateletter.add(PassWordUpdate);
    Updateletter.add(Check);
    Updateletter.setBorder(brd);
    
    triagnePanelPage=new TrianglePanel();
    triagnePanelPage.setBounds(75,50, 450, 150);
    triagnePanelPage.setVisible(true);
    triagnePanelPage.setBackground(Color.WHITE);
    triagnePanelPage.setColor(Color.WHITE);
    triagnePanelPage.setBackground(new Color(31,65,102,255));
     triagnePanelPage.add(ProfileImage);
    triagnePanelPage.setLayout(new FlowLayout());
    
    openlettre=new JButton();
	 openlettre.setBounds(280, 150, 30, 30);
	 openlettre.setIcon(imageIcon8);
	 openlettre.addMouseListener(this);
	 openlettre.setBackground(Color.WHITE);
	 openlettre.setBorderPainted(false);
    
 
    triagnePanel=new TrianglePanel();
    triagnePanel.setBounds(0,0,600,200);
    triagnePanel.setVisible(true);
    triagnePanel.setBackground(new Color(31,65,102,255));
    triagnePanel.add(openlettre);
    triagnePanel.add(triagnePanelPage);
    triagnePanel.setLayout(null);
    
    moduleB_header=new JButton("Module >>");
	moduleB_header.setBackground(Color.DARK_GRAY);
	moduleB_header.setForeground(Color.WHITE);
	moduleB_header.setFocusable(false);
	moduleB_header.setBounds(60,10, 200, 30);
	moduleB_header.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	moduleB_header.addMouseListener(this);
	moduleB_header.setBorderPainted(false);
	
	

	
	enseignatB_header=new JButton("Enseignant>>");
	enseignatB_header.setBackground(Color.DARK_GRAY);
	enseignatB_header.setForeground(Color.WHITE);
	enseignatB_header.setFocusable(false);
	enseignatB_header.setBounds(60,10, 200, 30);
	enseignatB_header.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	enseignatB_header.addMouseListener(this);
	enseignatB_header.setBorderPainted(false);
	
	
	 radiodesc=new JRadioButton();
     radiodesc.setBounds(0,200, 70, 30);
     radiodesc.setText("desc");
     radiodesc.setBackground(Color.white);
     radiodesc.setForeground(new Color(31,65,102,255)); 
     radiodesc.setActionCommand("desc");
     radiodesc.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
     
	     radioasc=new JRadioButton();
	     radioasc.setBounds(0,240, 70, 30);
	     radioasc.setText("asc");
	     radioasc.setActionCommand("asc");
	     radioasc.setActionCommand("asc");
	     radioasc.setBackground(Color.white);
	     radioasc.setForeground(new Color(31,65,102,255)); 
	     radioasc.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	     
	     
	     groupR2=new ButtonGroup();
	     groupR2.add(radioasc);
	     groupR2.add(radiodesc);
	     
	    
	  
	   
 radiodate=new JRadioButton();
 radiodate .setBounds(420,40, 70, 30);
 radiodate.setText("date");
 radiodate.setActionCommand("date_naissance");
 radiodate.setBackground(Color.white);
 radiodate.setForeground(new Color(31,65,102,255)); 
 radiodate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
 

 radioNom=new JRadioButton();
 radioNom.setBounds(220,40, 50, 30);
 radioNom.setText("nom");
 radioNom.setActionCommand("nom");
 radioNom.setBackground(Color.white);
 radioNom.setForeground(new Color(31,65,102,255)); 
 radioNom.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
 

 radioPrenom=new JRadioButton();
 radioPrenom .setBounds(280,40, 80, 30);
 radioPrenom.setText("prenom");
 radioPrenom.setActionCommand("prenom");
 radioPrenom.setBackground(Color.white);
 radioPrenom.setForeground(new Color(31,65,102,255)); 
 radioPrenom.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
 

 radioCne=new JRadioButton();
 radioCne .setBounds(360,40, 50, 30);
 radioCne.setText("CNE");
 radioCne.setActionCommand("code");
 radioCne.setBackground(Color.white);
 radioCne.setForeground(new Color(31,65,102,255)); 
 radioCne.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
 

 radioApogge=new JRadioButton();
 radioApogge .setBounds(490,40, 80, 30);
 radioApogge.setText("CodeEn");
 radioApogge.setActionCommand("apogee");
 radioApogge.setBackground(Color.white);
 radioApogge.setForeground(new Color(31,65,102,255)); 
 radioApogge.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
 

 radioId=new JRadioButton();
 radioId .setBounds(160,40, 50, 30);
 radioId.setText("Id");
 radioId.setActionCommand("etud_id");
 radioId.setBackground(Color.white);
 radioId.setForeground(new Color(31,65,102,255)); 
 radioId.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
 
 groupR=new ButtonGroup();
 groupR.add(radiodate);
 groupR.add(radioNom);
 groupR.add(radioPrenom);
 groupR.add(radioCne);

    
    module_header=new JPanel();
	module_header.setBackground(Color.DARK_GRAY);
	module_header.setLayout(new BorderLayout());
	module_header.setBounds(30, 40, 1000,50 );
	module_header.add(moduleB_header);
	module_header.setVisible(false);
	module_header.setVisible(false);
	
	enseignat_header=new JPanel();
	enseignat_header.setBackground(Color.DARK_GRAY);
	enseignat_header.setLayout(new BorderLayout());
	enseignat_header.setBounds(30, 40, 1000,50 );
	enseignat_header.add(enseignatB_header);
	enseignat_header.setVisible(true);

	
	
	Benseignat=new JButton(); 
	Benseignat.setIcon(iconS);
	Benseignat.setBounds(800, 340, 100, 100);
	Benseignat.setFocusable(false);
	Benseignat.setBorderPainted(false);
	Benseignat.setBackground(Color.WHITE);
	Benseignat.addMouseListener(this);
	
	ensB=new JButton("Enseignant >>");
	ensB.setBackground(new Color(31,65,102,255));
	ensB.setForeground(Color.WHITE);
	ensB.setFocusable(false);
	ensB.setBounds(60,10, 200, 30);
	ensB.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	ensB.addMouseListener(this);
	ensB.setBorderPainted(false);
	
	enseignatP=new JPanel();
	enseignatP.setBackground(new Color(31,65,102,60));
	enseignatP.setLayout(null);
	enseignatP.add(labelmodule);
	enseignatP.add(ensB);
	enseignatP.setBounds(0, 260, 300, 60);
	
	label2=new JLabel();
	label2.setIcon(imageIcon2);
	label2.setBounds(50, 0, 200, 200);
	
	 BModule=new JButton(); 
	 BModule.setIcon(iconS);
	 BModule.setBounds(800, 340, 100, 100);
	 BModule.setFocusable(false);
	 BModule.setBorderPainted(false);
	 BModule.setBackground(Color.WHITE);
	 BModule.addMouseListener(this);
    
	  ModuleEntree=new JLabel();
	    ModuleEntree.setIcon(iconmoduleentree);
	    ModuleEntree.setBounds(250, 0, 480, 480);
	    ModuleEntree.setVisible(true);
	    
		 plusmodule=new JButton();
		 plusmodule.setIcon(imageIcon6);
		 plusmodule.setBounds(420, 90, 35, 35);
		 plusmodule.setFocusable(false);
		 plusmodule.setBackground(null);
		 plusmodule.setBorderPainted(false);
		 plusmodule.addMouseListener(this);
		 plusmodule.setVisible(false);
		 
		 labelDN=new JButton();
		 labelDN.setIcon(deletePN);
		 labelDN.setBounds(10, 90, 35, 35);
		 labelDN.setFocusable(false);
		 labelDN.setBackground(null);
		 labelDN.setBorderPainted(false);
		 labelDN.addMouseListener(this);
		 labelDN.setVisible(false);
		 
		 
		 labelDM=new JButton();
		 labelDM.setIcon(deletePN);
		 labelDM.setBounds(390, 90, 35, 35);
		 labelDM.setFocusable(false);
		 labelDM.setBackground(null);
		 labelDM.setBorderPainted(false);
		 labelDM.addMouseListener(this);
		 labelDM.setVisible(false);
	
		 
		 
		 plusniveau=new JButton();
		 plusniveau.setIcon(imageIcon6);
		 plusniveau.setBounds(40, 90, 35, 35);
		 plusniveau.setFocusable(false);
		 plusniveau.setBackground(null);
		 plusniveau.setBorderPainted(false);
		 plusniveau.addMouseListener(this);
		 plusniveau.setVisible(false);   
		 
		 fieldniveau=new JTextField();
		    fieldniveau.setBounds(100, 90, 260, 40);
		    fieldniveau.setBackground(Color.WHITE);
		    fieldniveau.setForeground(new Color(31,65,102,255));
		    fieldniveau.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
		    fieldniveau.setBorder(feildniveauB);
		    fieldniveau.setVisible(false);
		    
		    
		    fieldmodule=new JTextField();
		    fieldmodule.setBounds(480,90, 260, 40);
		    fieldmodule.setBackground(Color.WHITE);
		    fieldmodule.setForeground(new Color(31,65,102,255));
		    fieldmodule.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
		    fieldmodule.setBorder(feildmoduleB);
		    fieldmodule.setVisible(false);
		    
		    
		    String[] items2= {};
			 Combomodule1=new JComboBox(items2);
			 Combomodule1.setBounds(70, 240, 250, 30);
			 Combomodule1.setForeground(new Color(31,65,102,255));
			 Combomodule1.setBackground(Color.WHITE);
			 Combomodule1.setBorder(null);
			 Combomodule1.setRenderer(new CustomComboBoxRenderer());
			 Combomodule1.setBorder(BorderFactory.createLineBorder(new Color(31,65,102,255)));
			 Combomodule1.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
			 Combomodule1.addMouseListener(this);
			 Combomodule1.addActionListener(this);
			 Combomodule1.setVisible(false);
			 
			 String[] items3= {};
			 Combomodule2=new JComboBox(items3);
			 Combomodule2.setBounds(70, 360, 250, 30);
			 Combomodule2.setForeground(new Color(31,65,102,255));
			 Combomodule2.setBackground(Color.WHITE);
			 Combomodule2.setBorder(null);
			 Combomodule2.setRenderer(new CustomComboBoxRenderer());
			 Combomodule2.setBorder(BorderFactory.createLineBorder(new Color(31,65,102,255)));
			 Combomodule2.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
			 Combomodule2.addMouseListener(this);
			 Combomodule2.addActionListener(this);
			 Combomodule2.setVisible(false);
			 
			 
			 String[] items4= {};
			 Comboniveau=new JComboBox(items4);
			 Comboniveau.setBounds(410, 360, 250, 30);
			 Comboniveau.setForeground(new Color(31,65,102,255));
			 Comboniveau.setBackground(Color.WHITE);
			 Comboniveau.setBorder(null);
			 Comboniveau.setRenderer(new CustomComboBoxRenderer());
			 Comboniveau.setBorder(BorderFactory.createLineBorder(new Color(31,65,102,255)));
			 Comboniveau.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
			 Comboniveau.addMouseListener(this);
			 Comboniveau.addActionListener(this);
			 Comboniveau.setVisible(false);
			 
			 String[] items5= {};
			 Comboenseig=new JComboBox(items5);
			 Comboenseig.setBounds(410, 240, 250, 30);
			 Comboenseig.setForeground(new Color(31,65,102,255));
			 Comboenseig.setBackground(Color.WHITE);
			 Comboenseig.setBorder(null);
			 Comboenseig.setRenderer(new CustomComboBoxRenderer());
			 Comboenseig.setBorder(BorderFactory.createLineBorder(new Color(31,65,102,255)));
			 Comboenseig.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
			 Comboenseig.addMouseListener(this);
			 Comboenseig.addActionListener(this);
			 Comboenseig.setVisible(false);
			 
	
			 
			 RMN= new CustomButton("RegisterNM"); 
		     RMN.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
			 RMN.setPreferredSize(new Dimension(150, 30));
			 RMN.setBounds(700, 350, 140, 40);
			 RMN.setFocusable(false);
			 RMN.addActionListener(this);
			 RMN.setVisible(false);
			 
			 
			 RME= new CustomButton("RegisterME"); 
		     RME.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
			 RME.setPreferredSize(new Dimension(150, 30));
			 RME.setBounds(700, 230, 140, 40);
			 RME.setFocusable(false);
			 RME.addActionListener(this);
			 RME.setVisible(false);
    module_center=new JPanel();
	module_center.setBackground(Color.WHITE);
	module_center.add(ModuleEntree);
	module_center.add(BModule);
	module_center.add(plusniveau);
	module_center.add(plusmodule);
	module_center.add(fieldniveau);
	module_center.add(fieldmodule);
	module_center.add(Combomodule1);
	module_center.add(Combomodule2);
	module_center.add(Comboniveau);
	module_center.add(Comboenseig);
	module_center.add(labelAFMN);
	module_center.add(labelAFME);
	module_center.add(labelDN);
	module_center.add(labelDM);
	module_center.add(RMN);
	module_center.add(RME);
	module_center.setLayout(null);
	module_center.setBounds(30, 90, 1000,550 );
	module_center.setVisible(false);
	
	enseignant_center=new JPanel();
	enseignant_center.setBackground(Color.WHITE);
	enseignant_center.setLayout(null);
	enseignant_center.setBounds(30, 90, 1000,550 );
	enseignant_center.add(Choose);
	enseignant_center.add(radioasc);
	enseignant_center.add( radiodesc);
	enseignant_center.add(radiodate);
	enseignant_center.add(radioNom);
	enseignant_center.add( radioPrenom);
	enseignant_center.add( radioCne);
//	enseignant_center.add( radioApogge);
	enseignant_center.add(radiodesc);
	enseignant_center.add( scroll);
	enseignant_center.setVisible(true);
	
     
    ProfilePanel=new JPanel();
    ProfilePanel.setBackground(new Color(31,65,102,255));
    ProfilePanel.setBounds(400,3, 600, 650);
    ProfilePanel.setVisible(false);
    ProfilePanel.setLayout(null);
    ProfilePanel.add(triagnePanel);
    ProfilePanel.add(NomComplet);
    ProfilePanel.add(Email);
    ProfilePanel.add(DateDeNaissance);
    ProfilePanel.add(enseignatCode);
    ProfilePanel.add(Updateletter);
    
     Profile=new JButton("Check Profile");
	 Profile.setIcon(imageIconProfile);
	 Profile.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	 Profile.setForeground(Color.WHITE);
	 Profile.setBounds(30,600, 200, 35);
	 Profile.setBackground(new Color(31,65,102,255));
	 Profile.setBorderPainted(false);
	 Profile.setFocusable(false);
	 Profile.addMouseListener(this);
    
	 bar=new JPanel();
		bar.setPreferredSize(new Dimension(300,1000));
		bar.setBackground(new Color(31,65,102,255));
		bar.setLayout(null);
		bar.add(Profile);
		bar.add(moduleP);
		bar.add(enseignatP);
		bar.add(label2);
	

	Horizantalbar=new JPanel();
	Horizantalbar.setBackground(Color.DARK_GRAY);
	Horizantalbar.setPreferredSize(new Dimension(0,40));
	Horizantalbar.setLayout(null);
	Horizantalbar.add(btn2);
	Horizantalbar.add(label4);
	Horizantalbar.add(label5);
	Horizantalbar.add(field1);
	
	
	
	CenterPanel_Center=new JPanel();
	CenterPanel_Center.setBackground(Color.WHITE);
	CenterPanel_Center.setLayout(null);
	CenterPanel_Center.setBounds(30, 90, 1000,550 );
	CenterPanel_Center.setVisible(false);

	

	

	centerbar=new JPanel();
	centerbar.setBackground(Color.WHITE);
	centerbar.setLayout(null);
	centerbar.add(module_header);
	centerbar.add(CenterPanel_Header);
	centerbar.add(enseignant_center);
	centerbar.add(enseignat_header);
	centerbar.add(CenterPanel_Center);
	centerbar.add(ProfilePanel);
	centerbar.add(NotCheck);
	centerbar.add(label9);
	centerbar.add(module_center);
	centerbar.setBackground(Color.WHITE);
	
	
	config = loadConfig();
    String imagePath = config.getProperty("imagePath");
    if (imagePath != null) {
        File imageFile = new File(imagePath);
        if (imageFile.exists()) {
            try {
                Image image = ImageIO.read(imageFile);
                icon = new ImageIcon(image.getScaledInstance(100,100,Image.SCALE_SMOOTH));
                ProfileImage.setIcon(icon);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }



frame=new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
frame.setLayout(new BorderLayout());
frame.getContentPane().setBackground(Color.WHITE);
frame.add(Horizantalbar,BorderLayout.NORTH);
frame.add(bar,BorderLayout.WEST);
frame.add(centerbar,BorderLayout.CENTER);
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
}
private void saveConfig(String imagePath) {
    config.setProperty("imagePath", imagePath);
    try (FileOutputStream out = new FileOutputStream("config.properties")) {
        config.store(out, null);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
private Properties loadConfig() {
    Properties prop = new Properties();
    try (FileInputStream in = new FileInputStream("config.properties")) {
        prop.load(in);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return prop;
}

@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource()==Check) {
		HelpAbsence aa=new HelpAbsence();
		 SQLtraitement sqlT=	new SQLtraitement();
		 String nom= Nom.getText();
		 String prenom= Prenom.getText();
		 String email=EmailUpdate.getText();
        String date= DateDeNaissanceUpdate.getText();
        String code=  enseignatCodeUpdate.getText();
		 String fonction=FonctionUpdate.getText();
		 String etat=EtatUpdate.getText();
		 String status=StatusUpdate.getText();
		
		 if(email.contains("@")&&email.contains(".com")&&code.matches("\\d+")&&date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
			 try {
				sqlT. UpdateAdministrateurtSql(nom, prenom, email, date, code, fonction, etat,status,aa.getvaluePass());
				JOptionPane.showMessageDialog(frame, " Yes! your information are updated !                             ");
			 } catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 }
		 else {
			 JOptionPane.showMessageDialog(frame, "ReCheck your information !                   ");
		 }
		 
		 
		 
	   
	}
	
	if(e.getSource()==openlettre) {
		SQLtraitement sqlT=	new SQLtraitement();
		HelpAbsence aa=new HelpAbsence();
		PassWordUpdate.setText(aa.getvalueEmail());
		  try {
			  ArrayList arry=sqlT.GetAdministrateur(aa.getvalueEmail(),aa.getvaluePass());
			  enseignatCodeUpdate.setText(String.valueOf( arry.get(0)));
			  Nom.setText((String) arry.get(1));
			  Prenom.setText((String) arry.get(2));
			  FonctionUpdate.setText((String) arry.get(3));
			  EtatUpdate.setText((String) arry.get(4));
			  StatusUpdate.setText((String) arry.get(5));
			  DateDeNaissanceUpdate.setText(String.valueOf( arry.get(6)));
			  EmailUpdate.setText(aa.getvalueEmail());
			  PassWordUpdate.setText(aa.getvaluePass());
			  
			  
			  
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
	if(e.getSource()==ensB) {
		module_center.setVisible(false);
		module_header.setVisible(false);
		CenterPanel_Header.setVisible(false);
		enseignant_center.setVisible(true);
		enseignat_header.setVisible(true);
		CenterPanel_Center.setVisible(false);
		ProfilePanel.setVisible(false);
		NotCheck.setVisible(false);
	}
	
	
	if(e.getSource()==Profile) {
		 HelpAbsence aa=new HelpAbsence();
		try {
		
			 arryEnseignt=new SQLtraitement().GetAdministrateur(aa.getvalueEmail(), aa.getvaluePass());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		enseignant_center.setVisible(false);
		enseignat_header.setVisible(false);
		CenterPanel_Center.setVisible(false);
		ProfilePanel.setVisible(true);
		CenterPanel_Header.setVisible(false);
        label9.setVisible(true);
        module_center.setVisible(false);
		module_header.setVisible(false);
		NomComplet.setText(arryEnseignt.get(1)+"-"+arryEnseignt.get(2));
	    Email.setText(aa.getvalueEmail());
	    DateDeNaissance.setText(String.valueOf(arryEnseignt.get(6)));
	    enseignatCode.setText(String.valueOf(arryEnseignt.get(0)));

   

         
            
	}
	if(e.getSource()==openlettre) {
		triagnePanelPage.setBounds(75,10, 450, 120);
		triagnePanelPage.setBackground(Color.WHITE);
		triagnePanelPage.setColor(Color.WHITE);
        triagnePanel.setBounds(0,0, 600, 100);
        triagnePanel.setBackground(new Color(31,65,102,255));
        NomComplet.setVisible(false);
    	Email.setVisible(false);
    	enseignatCode.setVisible(false);
    	DateDeNaissance.setVisible(false);
    	Departement.setVisible(false);
    	Updateletter.setVisible(true);
    	ProfileImage.setVisible(true);
    	NotCheck.setVisible(true);
	}
	if(e.getSource()==NotCheck) {

		triagnePanelPage.setBounds(75,50, 450, 150);
		triagnePanelPage.setBackground(new Color(31,65,102,255));
		triagnePanelPage.setColor(Color.WHITE);
        triagnePanel.setBounds(0,0, 600, 200);
        triagnePanel.setBackground(new Color(31,65,102,255));
		NomComplet.setVisible(true);
    	Email.setVisible(true);
    	enseignatCode.setVisible(true);
    	DateDeNaissance.setVisible(true);
    	Departement.setVisible(true);
    	Updateletter.setVisible(false);
    	ProfileImage.setVisible(false);
    
	}
	if(e.getSource()==moduleB) {
		enseignant_center.setVisible(false);
		enseignat_header.setVisible(false);
		NotCheck.setVisible(false);
		ModuleEntree.setVisible(true);
		BModule.setVisible(true);
		CenterPanel_Header.setVisible(false);
		CenterPanel_Center.setVisible(false);
		ProfilePanel.setVisible(false);
		label9.setVisible(false);
		module_center.setVisible(true);
		module_header.setVisible(true);
		labelAFME.setVisible(false);
		labelAFMN.setVisible(false);
		labelDM.setVisible(false);
		labelDN.setVisible(false);
		plusniveau.setVisible(false);
		plusmodule.setVisible(false);
		fieldniveau.setVisible(false);
		fieldmodule.setVisible(false);
		Combomodule1.setVisible(false);
		Combomodule2.setVisible(false);
		Comboenseig.setVisible(false);
		Comboniveau.setVisible(false);
		RME.setVisible(false);
		RMN.setVisible(false);

		
	}
	if(e.getSource()==plusniveau) {

		SQLtraitement sql=new SQLtraitement();
		
		try {
			if(sql.toutNiveau().contains(fieldniveau.getText())) {
				System.out.println("already niveau existe");
			}
			if(!sql.toutNiveau().contains(fieldniveau.getText())&&!fieldniveau.getText().equals("")) {
				sql.insertNiveau(fieldniveau.getText());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Comboniveau.removeAllItems();
		Combomodule1.removeAllItems();
		Combomodule2.removeAllItems();
		Comboenseig.removeAllItems();
		try {
			ArrayList<String> arrniveau=sql.toutNiveau();
			for(String key:arrniveau) {
				Comboniveau.addItem(key);
			
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Hashtable<String,Integer> hashmodule=sql.toutModule();
			for(String key:hashmodule.keySet()) {
				Combomodule1.addItem(key);
				Combomodule2.addItem(key);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Hashtable<String,String> hashenseig=sql.toutEnseignt();
			for(String key:hashenseig.keySet()) {
				Comboenseig.addItem(key);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
if(e.getSource()==labelDM) {
	SQLtraitement sql=new SQLtraitement();
	
	try {
		if(sql.toutModule().containsKey(fieldmodule.getText())) {
			int idmodule =sql.toutModule().get(fieldmodule.getText());
			sql.deleteModule(fieldmodule.getText(), idmodule);
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	Comboniveau.removeAllItems();
	Combomodule1.removeAllItems();
	Combomodule2.removeAllItems();
	Comboenseig.removeAllItems();
	try {
		ArrayList<String> arrniveau=sql.toutNiveau();
		for(String key:arrniveau) {
			Comboniveau.addItem(key);
		
		}
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Hashtable<String,Integer> hashmodule=sql.toutModule();
		for(String key:hashmodule.keySet()) {
			Combomodule1.addItem(key);
			Combomodule2.addItem(key);
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Hashtable<String,String> hashenseig=sql.toutEnseignt();
		for(String key:hashenseig.keySet()) {
			Comboenseig.addItem(key);
			
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}
if(e.getSource()==labelDN) {
	SQLtraitement sql=new SQLtraitement();
	try {
		if(sql.toutNiveau().contains(fieldniveau.getText())) {
			sql.deleteNiveau(fieldniveau.getText());
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	Comboniveau.removeAllItems();
	Combomodule1.removeAllItems();
	Combomodule2.removeAllItems();
	Comboenseig.removeAllItems();
	try {
		ArrayList<String> arrniveau=sql.toutNiveau();
		for(String key:arrniveau) {
			Comboniveau.addItem(key);
		
		}
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Hashtable<String,Integer> hashmodule=sql.toutModule();
		for(String key:hashmodule.keySet()) {
			Combomodule1.addItem(key);
			Combomodule2.addItem(key);
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Hashtable<String,String> hashenseig=sql.toutEnseignt();
		for(String key:hashenseig.keySet()) {
			Comboenseig.addItem(key);
			
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}
if(e.getSource()==plusmodule) {
	
	SQLtraitement sql=new SQLtraitement();

	try {
		if(sql.toutModule().containsKey(fieldmodule.getText())) {
			System.out.println("already module existe");
		}
		if(!sql.toutModule().containsKey(fieldmodule.getText())&&!fieldmodule.getText().equals("")) {
			sql.insertModule(fieldmodule.getText());
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.out.println("error");
	}
	Comboniveau.removeAllItems();
	Combomodule1.removeAllItems();
	Combomodule2.removeAllItems();
	Comboenseig.removeAllItems();
	try {
		ArrayList<String> arrniveau=sql.toutNiveau();
		for(String key:arrniveau) {
			Comboniveau.addItem(key);
		
		}
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Hashtable<String,Integer> hashmodule=sql.toutModule();
		for(String key:hashmodule.keySet()) {
			Combomodule1.addItem(key);
			Combomodule2.addItem(key);
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Hashtable<String,String> hashenseig=sql.toutEnseignt();
		for(String key:hashenseig.keySet()) {
			Comboenseig.addItem(key);
			
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
	}
	if(e.getSource()==BModule) {
		SQLtraitement sql= new SQLtraitement();
		try {
			ArrayList<String> arrniveau=sql.toutNiveau();
			for(String key:arrniveau) {
				Comboniveau.addItem(key);
			
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Hashtable<String,Integer> hashmodule=sql.toutModule();
			for(String key:hashmodule.keySet()) {
				Combomodule1.addItem(key);
				Combomodule2.addItem(key);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Hashtable<String,String> hashenseig=sql.toutEnseignt();
			for(String key:hashenseig.keySet()) {
				Comboenseig.addItem(key);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		labelAFME.setVisible(true);
		labelAFMN.setVisible(true);
		labelDM.setVisible(true);
		labelDN.setVisible(true);
		plusniveau.setVisible(true);
		plusmodule.setVisible(true);
		ModuleEntree.setVisible(false);
		BModule.setVisible(false);
		fieldniveau.setVisible(true);
		fieldmodule.setVisible(true);
		Combomodule1.setVisible(true);
		Combomodule2.setVisible(true);
		Comboenseig.setVisible(true);
		Comboniveau.setVisible(true);
		RME.setVisible(true);
		RMN.setVisible(true);
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
	if(e.getSource()==moduleB) {
		moduleP.setBackground(Color.DARK_GRAY);
		moduleB.setBackground(Color.DARK_GRAY);
	}
	if(e.getSource()==ensB) {
		enseignatP.setBackground(Color.DARK_GRAY);
		ensB.setBackground(Color.DARK_GRAY);
	}
	
}


@Override
public void mouseExited(MouseEvent e) {
	if(e.getSource()==moduleB) {
		moduleP.setBackground(new Color(31,65,102,255));
		moduleB.setBackground(new Color(31,65,102,255));
	}
	if(e.getSource()==ensB) {
		enseignatP.setBackground(new Color(31,65,102,255));
		ensB.setBackground(new Color(31,65,102,255));
	}
	
}


@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==Choose) {
		if(groupR.getSelection()!=null&&groupR2.getSelection()!=null) {
			System.out.println(groupR.getSelection().getActionCommand()+" "+groupR2.getSelection().getActionCommand());
			try {
				String[][] newData=new SQLtraitement().OrderByEns(groupR.getSelection().getActionCommand(), groupR2.getSelection().getActionCommand());
				for(String[] row :new SQLtraitement().OrderByEns(groupR.getSelection().getActionCommand(), groupR2.getSelection().getActionCommand())){
					System.out.println(Arrays.toString(row));
				}

				DefaultTableModel model3 = (DefaultTableModel) ensei.getModel();
			    model3.setRowCount(0); 
			    TableModel originalModel3 = ensei.getModel();
				TableModel editableModel3 = new DefaultTableModel(originalModel3.getRowCount(), originalModel3.getColumnCount()) {
			        
			        public boolean isCellEditable(int row, int column) {
			        	
			    			if(column==10  )
			    			{ 
			    				return true;
			    			}
			    			else {
			    				return false;
			    			}
			        	
			        	
			    	}


			       
			    };
			 // Copy values from original model to new model
			    for (int i = 0; i < originalModel3.getRowCount(); i++) {
			        for (int j = 0; j < originalModel3.getColumnCount(); j++) {
			        	editableModel3 .setValueAt(originalModel3.getValueAt(i, j), i, j);
			        }
			    }

			    ensei.setModel(editableModel3);
			    for (String[] row : newData) {
			        Vector<String> rowDataVector = new Vector<String>();
			        for (String cellValue : row) {
			            rowDataVector.add(cellValue);
			        }
			        ((DefaultTableModel) editableModel3).addRow(rowDataVector);
			    }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	 if (e.getSource() == ProfileImage) {
		  
         JFileChooser fileChooser = new JFileChooser();
         int result = fileChooser.showOpenDialog(null);
         if (result == JFileChooser.APPROVE_OPTION) {
             File selectedFile = fileChooser.getSelectedFile();
             try {
          	   icon=new ImageIcon(selectedFile.getAbsolutePath());
                 Image imgelog6N=icon.getImage();
                 Image image = ImageIO.read(selectedFile);
                 icon = new ImageIcon(imgelog6N.getScaledInstance(100,100,Image.SCALE_SMOOTH));
                 ProfileImage.setIcon(icon);
                 config.setProperty("imagePath", selectedFile.getAbsolutePath());
                 try (FileOutputStream out = new FileOutputStream("config.properties")) {
                     config.store(out, null);
                 } catch (IOException ex) {
                     ex.printStackTrace();
                 }
             } catch (Exception ex) {
                 ex.printStackTrace();
             }
         }
     }
	
}
}
