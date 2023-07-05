package MAIN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import SQL.SQLtraitement;
import Stylingfolder.*;

public class GestionGeneral implements MouseListener , ActionListener{
	//Frame
	public JFrame Gestion;
	//Panel
	public JPanel bar;
	public JPanel Horizantalbar;
	JPanel centerbar;
	JPanel eleves;
	JPanel absencePanel;
	JPanel CenterPanel_Header;
	JPanel CenterPanel_Center;
	JPanel ButtonPanel;
	JPanel ActionPanel;
	JPanel ProfilePanel;
	TrianglePanel triagnePanel;
	TrianglePanel triagnePanelPage;
	CirclePanel circle;
	JPanel Updateletter;
	JPanel Student;
	JPanel NotePanel;
	JPanel Centralmainabsence;
	JPanel CentralMainAbsence_hreader;
	JPanel ViewAbsence;
	JPanel moduleP;
	JPanel module_header;
	JPanel module_center;
	JPanel sanct_header;


	
	
	
	 //ComboBox
	 static JComboBox Combo;
	JComboBox Combo1;
	JComboBox Combomodule1;
	JComboBox Combomodule2;
	JComboBox Comboniveau;
	JComboBox Comboenseig;
	JButton btn1;
	JButton btnsearch;
	JButton btnabsence;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton delete;
	JButton Edit;
	JButton Register;
	JButton  butnModule;
	JButton  Profile;
	JButton  openlettre;
	JButton  Check;
	JButton  NotCheck;
	JButton  ProfileImage;
	JButton Search;
	JButton moduleB;
	JButton moduleB_header;
	JRadioButton radiodate;
	JRadioButton radioNom;
	JRadioButton radioPrenom;
	JRadioButton radioCne;
	JRadioButton radioApogge;
	JRadioButton radioId;
	ButtonGroup groupR;
	JRadioButton radiodesc;
	JRadioButton radioasc;
	JRadioButton Cours;
	JRadioButton Epreuve;
	JRadioButton Cours2;
	JRadioButton Epreuve2;
	ButtonGroup groupR2;
	ButtonGroup Absence;
	ButtonGroup Absence2;
	JButton note;
	JButton notcheckajout;
	JButton headerabs;
	JButton labelABSnew;
	JButton labelABSview;
	JButton BStudent;
	JButton BModule;
	CustomButton RME; 
	CustomButton RMN; 
	
	//iconimage
	ImageIcon imageIcon1;
	ImageIcon left;
	ImageIcon imageIcon;
	ImageIcon imageIcon2;
	ImageIcon imageIcon3;
	ImageIcon imageIcon4;
	ImageIcon imageIcon5;
	ImageIcon imageIcon6;
	ImageIcon imageIcon7;
	ImageIcon imageIcon8;
	ImageIcon imageIcon9;
	ImageIcon imageIcon10;
	ImageIcon imgelog11;
	ImageIcon imgelognote;
	ImageIcon imageIcondelete;
	ImageIcon imageIconedit;
	ImageIcon imageIconregister;
	ImageIcon imageIconProfile;
	ImageIcon icon;
	ImageIcon iconabsnece;
	ImageIcon iconABS;
	ImageIcon iconABSnew;
	ImageIcon iconABSview;
	ImageIcon iconStudent;
	ImageIcon iconmodule;
	ImageIcon iconS;
	ImageIcon iconmoduleentree;
	ImageIcon SeachIabs;
	ImageIcon deletePN;
	ImageIcon deletePM;
	ImageIcon judge;
	ImageIcon EntreeSacnt;
	ImageIcon sancB2;
	ImageIcon sancsmall;
	//Label 
	JLabel label1;
	JLabel labelAbsence;
	JButton labelDN;
	JButton labelDM;
	JLabel labelAFMN;
	JLabel labelAFME;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;
	JLabel label9;
	JLabel label10;
	JLabel label11;
	JButton plusmodule;
	JButton BSanc;
	JButton plusniveau;
	JLabel labelnote;
	JLabel labelimage;
	JLabel labelabsicon;
	JLabel labelABS;
	JLabel labelmodule;
	JLabel labelStudent;
	JLabel labeljudge;
	JLabel ModuleEntree;
	JLabel sancsmalllabel;
	JLabel sanctionentree;
	JButton AjoutEtudiant;
	JButton SearchBabs;
	JButton Bsanction;
	JButton BSH;
	JButton Bsanc2;
	JButton TRight;
	
	
	//TextField
	JTextField field1;
	JTextField fieldS;
	JTextField fieldniveau;
	JTextField fieldmodule;
	JTextField field2;
	JTextField field3;
	JTextField field4;
	JTextField NomComplet;
	JTextField Email;
	JTextField DateDeNaissance;
	JTextField enseignatCode;
	JTextField Departement;
	JTextField Nom;
	JTextField Prenom;
	JTextField EmailUpdate;
	JTextField DateDeNaissanceUpdate;
	JTextField enseignatCodeUpdate;
	JTextField DepartementUpdate;
	JTextField FonctionUpdate;
	JTextField EtatUpdate;
	JTextField StatusUpdate;
    JPasswordField  PassWordUpdate;
    JTextField SearchTabs;
	
	
	//Border
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
	
	
	
	//Table
	public DefaultTableModel dtm;
	public DefaultTableModel dtmnote;
	public DefaultTableModel dtmabsence;
	public DefaultTableModel modele;
	public JTable table;
	public JTable tableS;
	public JTable tablenote;
	public JTable tableAjout;
	public JTable tableabsence;
	public JTable tableS2;
	JScrollPane scroll;
	JScrollPane scrollnote;
	JScrollPane scrollAjout;
	JScrollPane scrollabsence;
	JCheckBox check;
	JScrollBar scrollbar;
	JScrollBar scrollbar1;
	JScrollBar scrollbar2;
	JScrollBar scrollbar3;
	JScrollBar scrollbar4;
	JScrollBar scrollbar5;
	JScrollBar scrollbarnote ;
	JScrollBar scrollbarabsence;
	ButtonPanelnote pB;
	JPanel Sanction;
	JPanel Sanction_center;
	JButton sanc1;
	JButton sanc2;
	public DefaultTableModel Sdtm;
	public DefaultTableModel Sdtm2;
	JScrollPane scrollAjoutSanc;
	JScrollPane scrollAjoutSanc2;
	
	
	//Variable
	 String EmailEns;
	 String PassEns;
	 ArrayList<String> tabE;
	 ArrayList<String> modules;
	 String[]fields= {"CNE","Nom","Prenom","Etat","Apoge","Diplome","DateN","Niveau","Id","Télép","Adresse"};
	 String[]fieldsAjout= {"CNE","Nom","Prenom","Etat","Apoge","Diplome","DateN","Niveau","Télép","Adresse"};
	 String[]fieldsnote= {"CNE","Nom","Prenom","Apogee","Niveau","Id","NoteC1","NoteC2"};
	 String[]fieldsabsence= {"ID","Module","Date","Type","NbrAbsence"};
	 String[]fieldssanction= {"Cne","Nom","Prenom","Module","NbrAbsence","Sanction"};
	 String[]fieldssanction2= {"ID_Fich","Date","Type","Justification"};
	 String EMAIL=null;
	 String PASSW=null;
	 int ID;
	 
	 private Properties config;
	 String[][] data= {{null,null,null,null,null,null,null,null,null,null,null}};
	 String[][] dataS= {{null,null,null,null,null,null,null}};
	 
	 String[][] datanote;
	 String[][] dataabsence;
	 ArrayList arryEnseignt;
	 public String combochoice=null;
	 String moduleE;
	 String moduleN;
	 String niveau;
	 String nomenseig;
	 
	
	
	
public GestionGeneral()  throws ClassNotFoundException, SQLException  {
	
	String[][] dataNull =null;
	modele=new DefaultTableModel (data, fieldsAjout);
	tableAjout =new JTable(modele);
	SQLtraitement traitement=new SQLtraitement();
	dtmabsence=new DefaultTableModel (traitement.selectionFichierAbsence(), fieldsabsence) {
		 @Override
		  public Class<?> getColumnClass(int columnIndex) {
		    return JButton.class;
		  }
		@Override
		 public boolean isCellEditable(int row,int column) {
			if(column==5 )
			{ 
				return true;
			}
			else {
				return false;
			}
		 }
		
	};
	
	dtm=new DefaultTableModel (dataNull, fields) {
		 @Override
		  public Class<?> getColumnClass(int columnIndex) {
		    return JButton.class;
		  }
		@Override
		 public boolean isCellEditable(int row,int column) {
			if(column==11  )
			{ 
				return true;
			}
			else {
				return false;
			}
		 }
	};
  HelpAbsence aa=new HelpAbsence();
	
	Sdtm=new DefaultTableModel(traitement.asetud(aa.getvalueEmail(), aa.getvaluePass(), aa.getvalueCombo()),fieldssanction) {
		 @Override
		  public Class<?> getColumnClass(int columnIndex) {
		    return JButton.class;
		  }
		@Override
		 public boolean isCellEditable(int row,int column) {
			if(column==6 )
			{ 
				return true;
			}
			else {
				return false;
			}
		 }
		
	};
	Sdtm2=new DefaultTableModel (dataS,fieldssanction2) {
		 @Override
		  public Class<?> getColumnClass(int columnIndex) {
		    return JButton.class;
		  }
		@Override
		 public boolean isCellEditable(int row,int column) {
			if(column==4  )
			{ 
				return true;
			}
			else {
				return false;
			}
		 }
		
	};
	dtmnote=new DefaultTableModel (datanote, fieldsnote) {
		 @Override
		  public Class<?> getColumnClass(int columnIndex) {
		    return JButton.class;
		  }
		@Override
		 public boolean isCellEditable(int row,int column) {
			if(column==8  )
			{ 
				return true;
			}
			else {
				return false;
			}
		 }
	};
	dtm.addColumn("Action");
	dtmnote.addColumn("Action");
	dtmabsence.addColumn("Action");
	Sdtm2.addColumn("Action");
	Sdtm.addColumn("Action");
	tableS=new JTable(Sdtm);
	tableS2=new JTable(Sdtm2);
    table =new JTable(dtm);
    tablenote=new JTable(dtmnote);
    tableabsence=new JTable(dtmabsence);
    table.setAutoCreateColumnsFromModel(false);
    tablenote.setAutoCreateColumnsFromModel(false);
    tableabsence.setAutoCreateColumnsFromModel(false);
    tableS.setAutoCreateColumnsFromModel(false);
    tableS2.setAutoCreateColumnsFromModel(false);
    // Assume "table" is your JTable object

    int fromIndex = 8; // the index of the column you want to move
    int toIndex = 0; // the index to which you want to move the column
    
    // Move the column in the table view
    table.moveColumn(fromIndex, toIndex);

    // Update the table model to reflect the column move
    TableModel model = table.getModel();
    if (model instanceof AbstractTableModel) {
        AbstractTableModel abstractModel = (AbstractTableModel) model;
        abstractModel.fireTableStructureChanged();
    }
	scroll=new JScrollPane(table);
	scrollnote=new JScrollPane(tablenote);
	scrollAjout=new JScrollPane(tableAjout);
	scrollabsence=new JScrollPane(tableabsence);
	scrollAjoutSanc=new JScrollPane(tableS);
	scrollAjoutSanc2=new JScrollPane( tableS2);
	scrollAjout.setBounds(40, 30, 880, 40);
	scrollAjout.setVisible(false);
    table.getTableHeader().setBackground(new Color(31,65,102,255));
    tablenote.getTableHeader().setBackground(new Color(31,65,102,255));
    tableAjout.getTableHeader().setBackground(new Color(31,65,102,255));
    tableabsence.getTableHeader().setBackground(new Color(31,65,102,255));
    tableS2.getTableHeader().setBackground(new Color(31,65,102,255));
    tableS.getTableHeader().setBackground(new Color(31,65,102,255));
    tableAjout.getTableHeader().setForeground(new Color(217,229,255,255));
    tableS.getTableHeader().setForeground(new Color(217,229,255,255));
    tableS2.getTableHeader().setForeground(new Color(217,229,255,255));
    tableAjout.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
    tableS.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
    tableS2.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
    tableabsence.getTableHeader().setForeground(new Color(217,229,255,255));
    tableabsence.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
    table.getTableHeader().setForeground(new Color(217,229,255,255));
    tablenote.getTableHeader().setForeground(new Color(217,229,255,255));
    tableAjout.getTableHeader().setBorder(feild2B);
    tableabsence.getTableHeader().setBorder(feild2B);
    tableS.getTableHeader().setBorder(feild2B);
    table.getTableHeader().setBorder(feild2B);
    tableS2.getTableHeader().setBorder(feild2B);
    tablenote.getTableHeader().setBorder(feild2B);
    tableS.getColumnModel().getColumn(6).setCellRenderer(new ButtonPanelSanction(tableS,tableS2));
    tableS.getColumnModel().getColumn(6).setCellEditor(new CellEditorSanction(tableS,tableS2));
    
    tableS2.getColumnModel().getColumn(4).setCellRenderer(new ButtonPanelJustification(tableS2));
    tableS2.getColumnModel().getColumn(4).setCellEditor(new cellEditorJustification(tableS2));
    table.getColumnModel().getColumn(11).setCellRenderer(new ButtonPanel(table));
    tableabsence.getColumnModel().getColumn(5).setCellRenderer(new ButtonPanelAbsence(tableabsence));
    pB=  new ButtonPanelnote(tablenote,GestionGeneral.Combo);
    tablenote.getColumnModel().getColumn(8).setCellRenderer(pB);
    table.getColumnModel().getColumn(11).setCellEditor(new CellEditor(table));
    tableabsence.getColumnModel().getColumn(5).setCellEditor(new CellEditorabsence( tableabsence));
    tablenote.getColumnModel().getColumn(8).setCellEditor(new CellEditorNote(tablenote,GestionGeneral.Combo));
    table.getTableHeader().setAlignmentX(JTable.CENTER_ALIGNMENT);
    tablenote.getTableHeader().setAlignmentX(JTable.CENTER_ALIGNMENT);
    tableabsence.getTableHeader().setAlignmentX(JTable.CENTER_ALIGNMENT);
    tableS.getTableHeader().setAlignmentX(JTable.CENTER_ALIGNMENT);
    tableS2.getTableHeader().setAlignmentX(JTable.CENTER_ALIGNMENT);
    int columnIndex = 11; // index of the second column
    int preferredWidth = 150; // new preferred width in pixels*

    TableColumn column = table.getColumnModel().getColumn(columnIndex);
    column.setPreferredWidth(preferredWidth);
    table.setRowHeight(40);
    
    int columnIndexnote = 8; // index of the second column
    int preferredWidthnote = 150; // new preferred width in pixels*

    TableColumn columnnote = tablenote.getColumnModel().getColumn(columnIndexnote);
    columnnote.setPreferredWidth(preferredWidthnote);
    tablenote.setRowHeight(40);
    
    int columnIndexab = 5; // index of the second column
    int preferredWidthab = 150; // new preferred width in pixels*

    TableColumn columnab = tableabsence.getColumnModel().getColumn(columnIndexab);
    columnab.setPreferredWidth(preferredWidthab);
    tableabsence.setRowHeight(40);
    
    
    TableColumn columnab2 = tableabsence.getColumnModel().getColumn(3);
    columnab2.setPreferredWidth(70);
    
    TableColumn columnab3 = tableabsence.getColumnModel().getColumn(0);
    columnab2.setPreferredWidth(10);
    
    int columnIndexS = 6; // index of the second column
    int preferredWidtS = 100; // new preferred width in pixels*

    TableColumn columnS = tableS.getColumnModel().getColumn(columnIndexS);
    columnS.setPreferredWidth(preferredWidtS);
    
    TableColumn columnSS = tableS.getColumnModel().getColumn(5);
    columnSS.setPreferredWidth(150);
    
    TableColumn columnSSS = tableS.getColumnModel().getColumn(6);
    columnSSS.setPreferredWidth(150);
    tableS.setRowHeight(40);
    
    TableColumn columnS2 = tableS2.getColumnModel().getColumn(4);
    columnS2.setPreferredWidth(preferredWidtS);
    tableS2.setRowHeight(40);
   


     
      
           
  

  	 
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
     
 	 
   	 scrollbar1 = new JScrollBar(JScrollBar.VERTICAL);
     scrollbar1.setPreferredSize(new Dimension(20, 0));
     scrollbar1.setBackground(Color.GRAY);
     scrollbar1.setForeground(Color.BLUE);
     scrollbar1.setUI(new BasicScrollBarUI() {
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
     scrollbar2 = new JScrollBar(JScrollBar.VERTICAL);
     scrollbar2.setPreferredSize(new Dimension(20, 0));
     scrollbar2.setBackground(Color.GRAY);
     scrollbar2.setForeground(Color.BLUE);
     scrollbar2.setUI(new BasicScrollBarUI() {
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
     
     scrollbar3 = new JScrollBar(JScrollBar.VERTICAL);
     scrollbar3.setPreferredSize(new Dimension(20, 0));
     scrollbar3.setBackground(Color.GRAY);
     scrollbar3.setForeground(Color.BLUE);
     scrollbar3.setUI(new BasicScrollBarUI() {
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
     scrollbar4 = new JScrollBar(JScrollBar.VERTICAL);
     scrollbar4.setPreferredSize(new Dimension(20, 0));
     scrollbar4.setBackground(Color.GRAY);
     scrollbar4.setForeground(Color.BLUE);
     scrollbar4.setUI(new BasicScrollBarUI() {
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
     scrollbar5 = new JScrollBar(JScrollBar.VERTICAL);
     scrollbar5.setPreferredSize(new Dimension(20, 0));
     scrollbar5.setBackground(Color.GRAY);
     scrollbar5.setForeground(Color.BLUE);
     scrollbar5.setUI(new BasicScrollBarUI() {
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
     
    
     
     table.setPreferredScrollableViewportSize(new Dimension(500,500));
     table.setGridColor(new Color(31,65,102,255));
     table.setShowHorizontalLines(true);
     table.setShowVerticalLines(false);
     table.setDefaultRenderer(Object.class, new AlternatingRowColorRenderer());
     table.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
     
     tablenote.setPreferredScrollableViewportSize(new Dimension(500,500));
     tablenote.setGridColor(new Color(31,65,102,255));
     tablenote.setShowHorizontalLines(true);
     tablenote.setShowVerticalLines(false);
     tablenote.setDefaultRenderer(Object.class, new AlternatingRowColorRenderer());
     tablenote.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
     
     
     tableabsence.setPreferredScrollableViewportSize(new Dimension(500,500));
     tableabsence.setGridColor(new Color(31,65,102,255));
     tableabsence.setShowHorizontalLines(true);
     tableabsence.setShowVerticalLines(false);
     tableabsence.setDefaultRenderer(Object.class, new AlternatingRowColorRenderer());
     tableabsence.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
  
     

     tableS.setPreferredScrollableViewportSize(new Dimension(500,500));
     tableS.setGridColor(new Color(31,65,102,255));
     tableS.setShowHorizontalLines(true);
     tableS.setShowVerticalLines(false);
     tableS.setDefaultRenderer(Object.class, new AlternatingRowColorRenderer());
     tableS.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
     
     
     tableS2.setPreferredScrollableViewportSize(new Dimension(500,500));
     tableS2.setGridColor(new Color(31,65,102,255));
     tableS2.setShowHorizontalLines(true);
     tableS2.setShowVerticalLines(false);
     tableS2.setDefaultRenderer(Object.class, new AlternatingRowColorRenderer());
     tableS2.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));

 
  



  






   //  scroll.setBackground(Color.WHITE);
     scroll.setBounds(70, 200, 900, 340);
     scroll.setVerticalScrollBar(scrollbar);
     
     scrollnote.setBounds(7, 100, 780, 340);
     scrollnote.setVerticalScrollBar(scrollbar5);
     
     
     scrollabsence.setBounds(90, 170, 780, 340);
     scrollabsence.setVerticalScrollBar(scrollbar2);
     
     scrollAjoutSanc.setBounds(90, 170, 780, 340);
     scrollAjoutSanc.setVerticalScrollBar(scrollbar3);
     scrollAjoutSanc.setVisible(false);
     
     scrollAjoutSanc2.setBounds(90, 170, 800, 340);
     scrollAjoutSanc2.setVerticalScrollBar(scrollbar4);
     scrollAjoutSanc2.setVisible(false);
     
     scrollAjout.setVisible(false);
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	feildEnseiCodeBUpdate=BorderFactory.createTitledBorder(brd1,"Enseigant Code");
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
	feildEnseiCodeB=BorderFactory.createTitledBorder(brd,"Enseigant Code");
	feildDepartementB=BorderFactory.createTitledBorder(brd,"Département");
	
	feildEmailB.setTitleColor(Color.WHITE);
	feildNomCompletB.setTitleColor(Color.WHITE);
	feildDateNaissanceB.setTitleColor(Color.WHITE);
	feildEnseiCodeB.setTitleColor(Color.WHITE);
	feildDepartementB.setTitleColor(Color.WHITE);
	
	
	
	//Icon image
	
	imageIcon1=new ImageIcon("C:\\Users\\dell\\Documents\\white_laptop.png");
	Image imgelog1N=imageIcon1.getImage();
	imageIcon1 =new ImageIcon(imgelog1N.getScaledInstance(30,30, Image.SCALE_SMOOTH));
	
	imageIcon2=new ImageIcon("C:\\Users\\dell\\Documents\\GestionGeneral_Theme.png");
	Image imgelog2N=imageIcon2.getImage();
	imageIcon2 =new ImageIcon(imgelog2N.getScaledInstance(200,200, Image.SCALE_SMOOTH));
	
	imageIcon3=new ImageIcon("C:\\Users\\dell\\Documents\\Student_icon.png");
	Image imgelog3N=imageIcon3.getImage();
	imageIcon3 =new ImageIcon(imgelog3N.getScaledInstance(40,40, Image.SCALE_SMOOTH));
	
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
	
	
	imgelog11=new ImageIcon("C:\\Users\\dell\\Documents\\not_check_image.png");
	Image imgelog11N=imgelog11.getImage();
	imgelog11 =new ImageIcon(imgelog11N.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	imgelognote=new ImageIcon("C:\\Users\\dell\\Documents\\note_illustration.png");
	Image imgelognoteN=imgelognote.getImage();
	imgelognote =new ImageIcon(imgelognoteN.getScaledInstance(300, 300, Image.SCALE_SMOOTH));
	
	
	iconabsnece=new ImageIcon("C:\\Users\\dell\\Documents\\iconabsnece.png");
	Image imgelogAb=iconabsnece.getImage();
	iconabsnece =new ImageIcon(imgelogAb.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
	
	iconABS=new ImageIcon("C:\\Users\\dell\\Documents\\absence3.jpeg");
	Image imgelogAbS=iconABS.getImage();
	iconABS =new ImageIcon(imgelogAbS.getScaledInstance(480, 480, Image.SCALE_SMOOTH));
	
	iconABSnew=new ImageIcon("C:\\Users\\dell\\Documents\\newAbsence.png");
	Image imgelogAbSnew=iconABSnew.getImage();
	iconABSnew =new ImageIcon(imgelogAbSnew.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	
	iconABSview=new ImageIcon("C:\\Users\\dell\\Documents\\viewAbsence.png");
	Image imgelogAbSview=iconABSview.getImage();
	iconABSview=new ImageIcon(imgelogAbSview.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	
	iconStudent=new ImageIcon("C:\\Users\\dell\\Documents\\student illustation.png");
	Image imgelogS=iconStudent.getImage();
	iconStudent=new ImageIcon(imgelogS.getScaledInstance(480, 480, Image.SCALE_SMOOTH));
	
	iconS=new ImageIcon("C:\\Users\\dell\\Documents\\to_right.png");
	Image imgelogSt=iconS.getImage();
	iconS=new ImageIcon(imgelogSt.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	
	left=new ImageIcon("C:\\Users\\dell\\Documents\\left.png");
	Image imgelogl=left.getImage();
	left=new ImageIcon(imgelogl.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	
	sancB2=new ImageIcon("C:\\Users\\dell\\Documents\\to_right.png");
	Image imgelogSt2=sancB2.getImage();
	sancB2=new ImageIcon(imgelogSt2.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	iconmodule=new ImageIcon("C:\\Users\\dell\\Documents\\module.png");
	Image imgelogM=iconmodule.getImage();
	iconmodule=new ImageIcon(imgelogM.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
	
	
	iconmoduleentree=new ImageIcon("C:\\Users\\dell\\Documents\\ModuleEntree.png");
	Image imgelogMO=iconmoduleentree.getImage();
	iconmoduleentree=new ImageIcon(imgelogMO.getScaledInstance(480, 480, Image.SCALE_SMOOTH));
	
	deletePN=new ImageIcon("C:\\Users\\dell\\Documents\\mins_person.png");
	Image imgelogPN1=deletePN.getImage();
	deletePN=new ImageIcon(imgelogPN1.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
	
	deletePM=new ImageIcon("C:\\Users\\dell\\Documents\\mins_person.png");
	Image imgelogPM1=deletePM.getImage();
	deletePM=new ImageIcon(imgelogPM1.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
	
	judge=new ImageIcon("C:\\Users\\dell\\Documents\\judge.png");
	Image imgelogJ=judge.getImage();
	judge=new ImageIcon(imgelogJ.getScaledInstance(30,30, Image.SCALE_SMOOTH));
	
	
	EntreeSacnt=new ImageIcon("C:\\Users\\dell\\Documents\\Sanction.png");
	Image imgelogSE=EntreeSacnt.getImage();
	EntreeSacnt=new ImageIcon(imgelogSE.getScaledInstance(480,480, Image.SCALE_SMOOTH));
	
	sancsmall=new ImageIcon("C:\\Users\\dell\\Documents\\icon_petite.png");
	Image imgelogSM=sancsmall.getImage();
	sancsmall=new ImageIcon(imgelogSM.getScaledInstance(160,160, Image.SCALE_SMOOTH));
	
	
	//TextField
	field1=new JTextField();
	field1.setBounds(1190, 3, 160, 30);
	field1.setBackground(Color.DARK_GRAY);
	field1.setForeground(Color.white);
	field1.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	field1.setBorder(null);
	
	
	SearchTabs=new JTextField();
	SearchTabs.setBounds(810, 40, 190, 30);
	SearchTabs.setBackground(Color.WHITE);
	SearchTabs.setForeground(Color.DARK_GRAY);
	SearchTabs.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	SearchTabs.setBorder(brd1);
	

	fieldS=new JTextField();
	fieldS.setBounds(810, 40, 190, 30);
	fieldS.setBackground(Color.WHITE);
	fieldS.setForeground(Color.DARK_GRAY);
	fieldS.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	fieldS.setBorder(brd1);
	fieldS.setVisible(false);
	

	field2=new JTextField();
	field2.setBounds(820,160, 160, 35);
	field2.setBackground(Color.WHITE);
	
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
	
	DepartementUpdate=new JTextField();
	DepartementUpdate.setBounds(100, 330, 260, 35);
	DepartementUpdate.setBackground(Color.WHITE);
	DepartementUpdate.setForeground(new Color(31,65,102,255));
	DepartementUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	DepartementUpdate.setBorder(feildDepartementUpdateB);
	
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
	FonctionUpdate.setBounds(100, 430, 260, 35);
	FonctionUpdate.setBackground(Color.WHITE);
	FonctionUpdate.setForeground(new Color(31,65,102,255));
	FonctionUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	FonctionUpdate.setBorder(feildFonctionUpdateB);
	
	EtatUpdate=new JTextField();
	EtatUpdate.setBounds(100, 480, 260, 35);
	EtatUpdate.setBackground(Color.WHITE);
	EtatUpdate.setForeground(new Color(31,65,102,255));
	EtatUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	EtatUpdate.setBorder(feildEtatUpdateB);
	
	StatusUpdate=new JTextField();
	StatusUpdate.setBounds(100, 530, 260, 35);
	StatusUpdate.setBackground(Color.WHITE);
	StatusUpdate.setForeground(new Color(31,65,102,255));
	StatusUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	StatusUpdate.setBorder(feildStatusUpdateB);
	
    PassWordUpdate=new JPasswordField();
    PassWordUpdate.setBounds(100, 380, 260, 35);
    PassWordUpdate.setBackground(Color.WHITE);
    PassWordUpdate.setForeground(new Color(31,65,102,255));
    PassWordUpdate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
    PassWordUpdate.setBorder(feildPassWordUpdateB);
    PassWordUpdate.setEditable(false);
	
	//Label
	/*label1=new JLabel();
	label1.setIcon(imageIcon1);
	label1.setBounds(25, 240, 30, 30);*/
    labelStudent=new JLabel();
    labelStudent.setIcon(iconStudent); 
    labelStudent.setBounds(50, 0, 480, 480);
    
    sancsmalllabel=new JLabel();
    sancsmalllabel.setIcon(sancsmall);
    sancsmalllabel.setBounds(0,0,35,35);
    sancsmalllabel.setBackground(Color.BLUE);
    
    labelABS=new JLabel();
    labelABS.setIcon(iconABS);
    labelABS.setBounds(250, 0, 480, 480);
    
    ModuleEntree=new JLabel();
    ModuleEntree.setIcon(iconmoduleentree);
    ModuleEntree.setBounds(250, 0, 480, 480);
    ModuleEntree.setVisible(true);
    
    labelnote=new JLabel();
    labelnote.setIcon(imgelognote);
    labelnote.setBounds(750, 80, 300, 300);
	
	label2=new JLabel();
	label2.setIcon(imageIcon2);
	label2.setBounds(50, 0, 200, 200);
	
	label3=new JLabel();
	label3.setIcon(imageIcon3);
	label3.setBounds(20, 3, 40, 40);
	
	labelAbsence=new JLabel();
	labelAbsence.setIcon(sancsmall);
	labelAbsence.setBounds(50, 10, 160, 160);
	labelAbsence.setVisible(false);
	
	labelabsicon=new JLabel();
	labelabsicon.setIcon(iconabsnece);
	labelabsicon.setBounds(20, 3, 40, 40);
	
	labelmodule=new JLabel();
	labelmodule.setIcon(iconmodule);
	labelmodule.setBounds(20, 3, 40, 40);
	
	sanctionentree=new JLabel();
	sanctionentree.setIcon(EntreeSacnt);
	sanctionentree.setBounds(60,60, 480, 480);

	
    labeljudge=new JLabel();
    labeljudge.setIcon(judge);
    labeljudge.setBounds(20, 3, 40, 40);
    labeljudge.setVisible(true);
	
	
	label4=new JLabel();
	label4.setText("Espace De Traitement");;
	label4.setBounds(20, 3, 200, 40);
	label4.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	label4.setBackground(Color.DARK_GRAY);
	label4.setForeground(Color.WHITE);
	
	labelAFMN=new JLabel();
	labelAFMN.setText("Affectation Module-Niveau");;
	labelAFMN.setBounds(70, 210, 300, 40);
	labelAFMN.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	labelAFMN.setBackground(Color.white);
	labelAFMN.setForeground(new Color(31,65,102,255));
	labelAFMN.setVisible(false);
	
	labelAFME=new JLabel();
	labelAFME.setText("Affectation Module-Enseignant");;
	labelAFME.setBounds(70, 350, 300, 40);
	labelAFME.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	labelAFME.setBackground(Color.white);
	labelAFME.setForeground(new Color(31,65,102,255));
	labelAFME.setVisible(false);
	
	label5=new JLabel();
	label5.setIcon(imageIcon5);
	label5.setBounds(1150, 3, 35, 35);
	label5.setBackground(Color.DARK_GRAY);

	
	
	
	label7=new JLabel();
	label7.setText("Ajouter un élève");
	label7.setBounds(70, 20, 210, 35);
	label7.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	label7.setForeground(new Color(31,65,102,255));
	

	
	
	
	label9=new JLabel();
	label9.setIcon(imageIcon9);
	label9.setBounds(20,120, 400, 400);
	label9.setVisible(false);
	

	labelimage=new JLabel();
	labelimage.setBounds(0,0, 400, 400);
	labelimage.setBackground(Color.red);
	labelimage.setVisible(true);
	
	
	
	
	
	
	
	
	
	//Combo &Button
	Epreuve=new JRadioButton();
	Epreuve.setBounds(370,500, 90, 30);
	Epreuve.setText("Epreuve");
	Epreuve.setActionCommand("Epreuve");
	Epreuve.setBackground(Color.white);
	Epreuve.setForeground(new Color(31,65,102,255));
	Epreuve.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	
	Cours=new JRadioButton();
	Cours.setBounds(470,500, 70, 30);
	Cours.setText("Cours");
	Cours.setActionCommand("Cours");
	Cours.setBackground(Color.white);
	Cours.setForeground(new Color(31,65,102,255));
	Cours.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	
	
	Epreuve2=new JRadioButton();
	Epreuve2.setBounds(370,40, 90, 30);
	Epreuve2.setText("Epreuve");
	Epreuve2.setActionCommand("Epreuve");
	Epreuve2.setBackground(Color.white);
	Epreuve2.setForeground(new Color(31,65,102,255));
	Epreuve2.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	
	Cours2=new JRadioButton();
	Cours2.setBounds(470,40, 70, 30);
	Cours2.setText("Cours");
	Cours2.setActionCommand("Cours");
	Cours2.setBackground(Color.white);
	Cours2.setForeground(new Color(31,65,102,255));
	Cours2.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	
	Absence=new ButtonGroup();
    Absence .add(Epreuve);
    Absence.add(Cours);
    
    Absence2=new ButtonGroup();
    Absence2 .add(Epreuve2);
    Absence2.add(Cours2);
	
	    radiodesc=new JRadioButton();
	     radiodesc.setBounds(0,300, 70, 30);
	     radiodesc.setText("desc");
	     radiodesc.setBackground(Color.white);
	     radiodesc.setForeground(new Color(31,65,102,255)); 
	     radiodesc.setActionCommand("desc");
	     radiodesc.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	     
		     radioasc=new JRadioButton();
		     radioasc.setBounds(0,340, 70, 30);
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
	 radiodate .setBounds(420,160, 70, 30);
	 radiodate.setText("date");
	 radiodate.setActionCommand("date_naissance");
	 radiodate.setBackground(Color.white);
	 radiodate.setForeground(new Color(31,65,102,255)); 
	 radiodate.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	 
	 
     radioNom=new JRadioButton();
     radioNom.setBounds(220,160, 50, 30);
     radioNom.setText("nom");
     radioNom.setActionCommand("nom");
     radioNom.setBackground(Color.white);
     radioNom.setForeground(new Color(31,65,102,255)); 
     radioNom.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
     
     
     radioPrenom=new JRadioButton();
     radioPrenom .setBounds(280,160, 80, 30);
     radioPrenom.setText("prenom");
     radioPrenom.setActionCommand("prenom");
     radioPrenom.setBackground(Color.white);
     radioPrenom.setForeground(new Color(31,65,102,255)); 
     radioPrenom.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
     
     
     radioCne=new JRadioButton();
     radioCne .setBounds(360,160, 50, 30);
     radioCne.setText("cne");
     radioCne.setActionCommand("cne");
     radioCne.setBackground(Color.white);
     radioCne.setForeground(new Color(31,65,102,255)); 
     radioCne.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
     
     
     radioApogge=new JRadioButton();
     radioApogge .setBounds(490,160, 80, 30);
     radioApogge.setText("apogee");
     radioApogge.setActionCommand("apogee");
     radioApogge.setBackground(Color.white);
     radioApogge.setForeground(new Color(31,65,102,255)); 
     radioApogge.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
     
     
     radioId=new JRadioButton();
     radioId .setBounds(160,160, 50, 30);
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
     groupR.add(radioApogge);
     groupR.add(radioId);
    
    
     
	
	Check=new JButton();
	Check.setBounds(380,500, 60, 60);
	Check.setIcon(imageIcon10);
	Check.addMouseListener(this);
	Check.setBackground(Color.WHITE);
	Check.setBorderPainted(false);
	
	AjoutEtudiant=new JButton();
	AjoutEtudiant.setBounds(930, 30, 60, 60);
	AjoutEtudiant.setIcon(imageIcon10);
	AjoutEtudiant.addMouseListener(this);
	AjoutEtudiant.setBackground(Color.WHITE);
	AjoutEtudiant.setBorderPainted(false);
	AjoutEtudiant.setVisible(false);
	
	
	NotCheck=new JButton();
	NotCheck.setBounds(10,10, 60, 60);
	NotCheck.setIcon(imgelog11);
	NotCheck.addMouseListener(this);
	NotCheck.setBackground(Color.WHITE);
	NotCheck.setBorderPainted(false);
	NotCheck.setVisible(false);
	
	
    notcheckajout=new JButton();
    notcheckajout.setBounds(0,0, 60, 60);
    notcheckajout.setIcon(imgelog11);
    notcheckajout.addMouseListener(this);
    notcheckajout.setBackground(Color.WHITE);
    notcheckajout.setBorderPainted(false);
    notcheckajout.setVisible(false);
	
	ProfileImage=new JButton();
	ProfileImage.setIcon(imageIcon10);
	ProfileImage.setBounds(100,50, 90, 90);
	ProfileImage.addActionListener(this);
	ProfileImage.setVisible(false);
	ProfileImage.setBackground(Color.WHITE);
	ProfileImage.setBorderPainted(false);
	
	Search = new JButton();
	Search.setIcon(imageIcon7);
	Search.setBounds(780,160, 35, 35);
	Search.addMouseListener(this);
	Search.setBackground(Color.WHITE);
	Search.setBorderPainted(false);
		
	SearchBabs = new JButton();
	SearchBabs.setIcon(imageIcon7);
	SearchBabs.setBounds(760,40, 35, 35);
	SearchBabs.addMouseListener(this);
	SearchBabs.setBackground(Color.WHITE);
	SearchBabs.setBorderPainted(false);
	
	btnsearch= new JButton();
	btnsearch.setIcon(imageIcon7);
	btnsearch.setBounds(760,40, 35, 35);
	btnsearch.addMouseListener(this);
	btnsearch.setBackground(Color.WHITE);
	btnsearch.setBorderPainted(false);
	btnsearch.setVisible(false);
	
	
	 openlettre=new JButton();
	 openlettre.setBounds(280, 150, 30, 30);
	 openlettre.setIcon(imageIcon8);
	 openlettre.addMouseListener(this);
	 openlettre.setBackground(Color.WHITE);
	 openlettre.setBorderPainted(false);
	
	 butnModule=new JButton();
     butnModule.setIcon(imageIcon1);
	 butnModule.setBounds(25, 240, 30, 30);
	 butnModule.addMouseListener(this);
	 butnModule.setBackground(new Color(31,65,102,255));
	 butnModule.setBorderPainted(false);
	
	 btn1=new JButton("Eléves >>");
	 btn1.setBackground(new Color(31,65,102,255));
	 btn1.setForeground(Color.WHITE);
	 btn1.setFocusable(false);
	 btn1.setBounds(60,10, 200, 30);
	 btn1.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	 btn1.addMouseListener(this);
	 btn1.setBorderPainted(false);
	 
	 
	 btnabsence=new JButton("Absence >>");
	 btnabsence.setBackground(new Color(31,65,102,255));
	 btnabsence.setForeground(Color.WHITE);
	 btnabsence.setFocusable(false);
	 btnabsence.setBounds(60,10, 200, 30);
	 btnabsence.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	 btnabsence.addMouseListener(this);
	 btnabsence.setBorderPainted(false);
	 
	 
	moduleB=new JButton("Module >>");
	moduleB.setBackground(new Color(31,65,102,255));
	moduleB.setForeground(Color.WHITE);
	moduleB.setFocusable(false);
	moduleB.setBounds(60,10, 200, 30);
	moduleB.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	moduleB.addMouseListener(this);
	moduleB.setBorderPainted(false);
	
	
	sanc1=new JButton("Sanction >>");
	sanc1.setBackground(new Color(31,65,102,255));
	sanc1.setForeground(Color.WHITE);
	sanc1.setFocusable(false);
	sanc1.setBounds(60,10, 200, 30);
	sanc1.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	sanc1.addMouseListener(this);
	sanc1.setBorderPainted(false);
	
	
	moduleB_header=new JButton("Module >>");
	moduleB_header.setBackground(Color.DARK_GRAY);
	moduleB_header.setForeground(Color.WHITE);
	moduleB_header.setFocusable(false);
	moduleB_header.setBounds(60,10, 200, 30);
	moduleB_header.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	moduleB_header.addMouseListener(this);
	moduleB_header.setBorderPainted(false);
	
	
	BSH=new JButton("Sanction >>");
	BSH.setBackground(Color.DARK_GRAY);
	BSH.setForeground(Color.WHITE);
	BSH.setFocusable(false);
	BSH.setBounds(60,10, 200, 30);
	BSH.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	BSH.addMouseListener(this);
	BSH.setBorderPainted(false);
	 
	 
	 
	 btn2=new JButton();
	 btn2.setIcon(imageIcon4);
	 btn2.setBounds(1080, 2, 35, 35);
	 btn2.setFocusable(false);
	 btn2.setBackground(Color.DARK_GRAY);
	 btn2.addMouseListener(this);
	 btn2.setBorderPainted(false);
	 
	 
	 
	 btn3=new JButton("Eléves   >> ");
	 btn3.setBackground(Color.DARK_GRAY);
	 btn3.setForeground(Color.WHITE);
	 btn3.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	 btn3.setBorderPainted(false);
	 btn3.setBounds(60,10, 200, 30);
	 btn3.setFocusable(false);
	 
	 headerabs=new JButton("Absence   >> ");
	 headerabs.setBackground(Color.DARK_GRAY);
	 headerabs.setForeground(Color.WHITE);
	 headerabs.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	 headerabs.setBorderPainted(false);
	 headerabs.setBounds(60,10, 200, 30);
	 headerabs.setFocusable(false);
	 
	 
	    labelABSnew=new JButton();
	    labelABSnew.setIcon(iconABSnew);
	    labelABSnew.setBounds(800, 300, 100, 100);
	    labelABSnew.setFocusable(false);
	    labelABSnew.setBorderPainted(false);
	    labelABSnew.setBackground(Color.WHITE);
	    labelABSnew.addActionListener(this);
	    
	    labelABSview=new JButton();
	    labelABSview.setIcon(iconABSview);
	    labelABSview.setBounds(60, 300, 100, 100);
	    labelABSview.setFocusable(false);
	    labelABSview.setBorderPainted(false);
	    labelABSview.setBackground(Color.WHITE);
	    labelABSview.addActionListener(this);
	    labelABSview.addMouseListener(this);
	    
	 BStudent=new JButton(); 
	 BStudent.setIcon(iconS);
	 BStudent.setBounds(800, 340, 100, 100);
	 BStudent.setFocusable(false);
	 BStudent.setBorderPainted(false);
	 BStudent.setBackground(Color.WHITE);
	 BStudent.addMouseListener(this);
	 
	 Bsanction=new JButton(); 
	 Bsanction.setIcon(iconS);
	 Bsanction.setBounds(800, 340, 100, 100);
	 Bsanction.setFocusable(false);
	 Bsanction.setBorderPainted(false);
	 Bsanction.setBackground(Color.WHITE);
	 Bsanction.addMouseListener(this);
		
	 BModule=new JButton(); 
	 BModule.setIcon(iconS);
	 BModule.setBounds(800, 340, 100, 100);
	 BModule.setFocusable(false);
	 BModule.setBorderPainted(false);
	 BModule.setBackground(Color.WHITE);
	 BModule.addMouseListener(this);
	 
	 TRight=new JButton(); 
	 TRight.setIcon(left);
	 TRight.setBounds(0, 340, 70, 70);
	 TRight.setFocusable(false);
	 TRight.setBorderPainted(false);
	 TRight.setBackground(Color.WHITE);
	 TRight.addMouseListener(this);
	 TRight.setVisible(false);
	 
	 
	 Bsanc2=new JButton(); 
	 Bsanc2.setIcon(sancB2);
	 Bsanc2.setBounds(920, 340, 60, 60);
	 Bsanc2.setFocusable(false);
	 Bsanc2.setBorderPainted(false);
	 Bsanc2.setBackground(Color.WHITE);
	 Bsanc2.addMouseListener(this);
	 Bsanc2.setVisible(false);
	 
	 Profile=new JButton("Check Profile");
	 Profile.setIcon(imageIconProfile);
	 Profile.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	 Profile.setForeground(Color.WHITE);
	 Profile.setBounds(30,600, 200, 35);
	 Profile.setBackground(new Color(31,65,102,255));
	 Profile.setBorderPainted(false);
	 Profile.setFocusable(false);
	 Profile.addMouseListener(this);
	
	 
	 btn4=new JButton();
	 btn4.setIcon(imageIcon6);
	 btn4.setBounds(20, 20, 35, 35);
	 btn4.setFocusable(false);
	 btn4.setBackground(null);
	 btn4.setBorderPainted(false);
	 btn4.addMouseListener(this);
	 
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
	 
	 
	 
	 
	 btn5=new JButton();
	 btn5.setText("Genral");
	 btn5.setBounds(0, 100, 80, 50);
	 btn5.setFocusable(false);
	 btn5.setForeground(new Color(31,65,102,255));
	 btn5.setBackground(Color.WHITE);
	 btn5.setBorder(feild1B);
	 btn5.addMouseListener(this);
	 
	 
	 note=new JButton();
	 note.setText("Note");
	 note.setBounds(50, 0, 80, 50);
	 note.setFocusable(false);
	 note.setForeground(Color.LIGHT_GRAY);
	 note.setBackground(Color.white);
	 note.setBorder(feildB);
	 note.addMouseListener(this);
	 
	 
	 delete=new JButton();
	 delete.setIcon(imageIcondelete);
	 delete.setFocusable(false);
	 delete.setBounds(0, 0, 35, 35);
	
	 
	 Edit= new JButton();
	 Edit.setIcon(imageIconedit);
	 Edit.setFocusable(false);
	 Edit.setBounds(50, 0, 35, 35);
	
	 Register=new JButton();
	 Register.setIcon(imageIconregister);
	 Register.setFocusable(false);
	 Register.setBounds(70, 0, 35, 35);
	 
	 
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
	 
	 
	 
	 //ArrayList<String> modules=new SQLtraitement().getModule(EmailEns,PassEns );
	 String[] items= {};
	 Combo=new JComboBox(items);
	 Combo.setBounds(70, 240, 200, 30);
	 Combo.setForeground(Color.WHITE);
	 Combo.setBackground(new Color(31,65,102,255));
	 Combo.setBorder(null);
	 Combo.setRenderer(new CustomComboBoxRenderer());
	 Combo.setBorder(BorderFactory.createLineBorder(new Color(31,65,102,255)));
	 Combo.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
	 Combo.addMouseListener(this);
	 Combo.addActionListener(this);
	 
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
	 
	 Combo1=new JComboBox();
	 
	 
	 
	 
	//Panel
	 
	   /* circle=new CirclePanel();
	    circle.setBounds(100,50, 100, 100);
	    circle.setVisible(false);
	    circle.setBackground(new Color(31,65,102,255));*/
	 
	 
	    triagnePanelPage=new TrianglePanel();
	    triagnePanelPage.setBounds(75,50, 450, 150);
	    triagnePanelPage.setVisible(true);
	    triagnePanelPage.setBackground(Color.WHITE);
	    triagnePanelPage.setColor(Color.WHITE);
	    triagnePanelPage.setBackground(new Color(31,65,102,255));
	    triagnePanelPage.add(ProfileImage);
	    triagnePanelPage.setLayout(new FlowLayout());
	    
	 
	    triagnePanel=new TrianglePanel();
	    triagnePanel.setBounds(0,0,600,200);
	    triagnePanel.setVisible(true);
	    triagnePanel.setBackground(new Color(31,65,102,255));
	    triagnePanel.add(openlettre);
	    triagnePanel.add(triagnePanelPage);
	    triagnePanel.setLayout(null);

	    
	    NotePanel=new JPanel();
	    NotePanel.setBackground(Color.white);
	    NotePanel.add(labelnote);
	    NotePanel.setLayout(null);
	    NotePanel.setBounds(30, 90, 1000,550 );
	    NotePanel.add(scrollnote);
	    NotePanel.setVisible(false);
	    
	    Updateletter=new JPanel();
	    Updateletter.setBackground(Color.WHITE);
	    Updateletter.setBounds(75,50, 450, 580);
	    Updateletter.setVisible(false);
	    Updateletter.setLayout(null);
	    Updateletter.add(EmailUpdate);
	    Updateletter.add(enseignatCodeUpdate);
	    Updateletter.add(DateDeNaissanceUpdate);
	    Updateletter.add(DepartementUpdate);
	    Updateletter.add(Nom);
	    Updateletter.add(Prenom);
	    Updateletter.add(FonctionUpdate);
	    Updateletter.add(EtatUpdate);
	    Updateletter.add(StatusUpdate);
	    Updateletter.add(PassWordUpdate);
	    Updateletter.add(Check);
	    Updateletter.setBorder(brd);
	   
	     
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
	    ProfilePanel.add(Departement);
	    ProfilePanel.add(Updateletter);
	    

	    eleves=new JPanel();
	    eleves.setBackground(new Color(31,65,102,60));
		eleves.setLayout(null);
		eleves.add(label3);
		eleves.add(btn1);
		eleves.setBounds(0, 310, 300, 60);
		
		
		ViewAbsence=new JPanel();
		ViewAbsence.setBackground(Color.white);
		ViewAbsence.setLayout(null);
		ViewAbsence.setBounds(30, 90, 1000,550 );
		ViewAbsence.add(scrollabsence);
		ViewAbsence.add(SearchTabs);
		ViewAbsence.add(SearchBabs);
		ViewAbsence.add(Cours2);
		ViewAbsence.add(Epreuve2);
		ViewAbsence.setVisible(false);
		
		Student=new JPanel();
		Student.setBackground(Color.WHITE);
		Student.setLayout(null);
		Student.add(labelStudent);
		Student.add(BStudent);
		Student.setBounds(30, 90, 1000,550 );
	
		
		
		absencePanel=new JPanel();
		absencePanel.setBackground(new Color(31,65,102,60));
		absencePanel.setLayout(null);
		absencePanel.add(labelabsicon);
		absencePanel.add(btnabsence);
		absencePanel.setBounds(0, 410, 300, 60);
		
		
		moduleP=new JPanel();
		moduleP.setBackground(new Color(31,65,102,60));
		moduleP.setLayout(null);
		moduleP.add(labelmodule);
		moduleP.add(moduleB);
		moduleP.setBounds(0, 460, 300, 60);
		
		

		 Sanction=new JPanel();
		 Sanction.setBackground(new Color(31,65,102,60));
		 Sanction.setLayout(null);
		 Sanction.setBounds(30, 90, 1000,550 );
		 Sanction.add(sanc1);
		 Sanction.add(labeljudge);
		 Sanction.setBounds(0, 500, 300, 60);
		 
		
		
		ButtonPanel=new JPanel();
		ButtonPanel.setBackground(Color.WHITE);
		ButtonPanel.setBounds(30, 100, 960,50 );
		ButtonPanel.setBorder(feild2B);
		ButtonPanel.setLayout(null);
		ButtonPanel.add(note);
		
		CenterPanel_Header=new JPanel();
		CenterPanel_Header.setBackground(Color.DARK_GRAY);
		CenterPanel_Header.setLayout(new BorderLayout());
		CenterPanel_Header.setBounds(30, 40, 1000,50 );
		CenterPanel_Header.add(btn3);
		
		
		sanct_header=new JPanel();
		sanct_header.setBackground(Color.DARK_GRAY);
		sanct_header.setLayout(new BorderLayout());
		sanct_header.setBounds(30, 40, 1000,50 );
		sanct_header.add(BSH);
		sanct_header.setVisible(false);
		
		CentralMainAbsence_hreader=new JPanel();
		CentralMainAbsence_hreader.setBackground(Color.DARK_GRAY);
		CentralMainAbsence_hreader.setLayout(new BorderLayout());
		CentralMainAbsence_hreader.setBounds(30, 40, 1000,50 );
		CentralMainAbsence_hreader.add(headerabs);
		CentralMainAbsence_hreader.setVisible(false);
		CentralMainAbsence_hreader.setVisible(false);
		
		
		module_header=new JPanel();
		module_header.setBackground(Color.DARK_GRAY);
		module_header.setLayout(new BorderLayout());
		module_header.setBounds(30, 40, 1000,50 );
		module_header.add(moduleB_header);
		module_header.setVisible(false);
		module_header.setVisible(false);
		
		
		
		CenterPanel_Center=new JPanel();
		CenterPanel_Center.setBackground(Color.WHITE);
		CenterPanel_Center.setLayout(null);
		CenterPanel_Center.setBounds(30, 90, 1000,550 );
		CenterPanel_Center.add(label7);
		CenterPanel_Center.add(btn4);
		CenterPanel_Center.add(btn5);
		CenterPanel_Center.add(ButtonPanel);
		CenterPanel_Center.add(Search);
		CenterPanel_Center.add(radiodate);
	     CenterPanel_Center.add(radioNom);
	     CenterPanel_Center.add(radioPrenom);
	     CenterPanel_Center.add(radioCne);
	     CenterPanel_Center.add(radioApogge);
	     CenterPanel_Center.add(radioId);
	     CenterPanel_Center.add(radiodesc);
	     CenterPanel_Center.add(radioasc);
		CenterPanel_Center.add(field2);
		CenterPanel_Center.add(scroll);
		CenterPanel_Center.add(scrollAjout);
		CenterPanel_Center.add(AjoutEtudiant);
		CenterPanel_Center.add(NotePanel);
		CenterPanel_Center.setVisible(false);
		
		
		Sanction_center=new JPanel();
		Sanction_center.setBackground(Color.white);
		Sanction_center.setLayout(null);
		Sanction_center.add(sanctionentree);
		Sanction_center.setBounds(30, 90, 1000,550 );
		Sanction_center.add(scrollAjoutSanc);
		Sanction_center.add(scrollAjoutSanc2);
		//Sanction_center.add(sancsmalllabel);
		Sanction_center.add(Bsanc2);
		Sanction_center.add(TRight);
		Sanction_center.add(Bsanction);
		//Sanction_center.add(fieldS);
	//	Sanction_center.add(btnsearch);
		Sanction_center.add(labelAbsence);
		Sanction_center.setVisible(false);
		
		
		
		
		Centralmainabsence=new JPanel();
		Centralmainabsence.setBackground(Color.WHITE);
		Centralmainabsence.setLayout(null);
		Centralmainabsence.setBounds(30, 90, 1000,550 );
		Centralmainabsence.add(labelABS);
		Centralmainabsence.add(labelABSnew);
		Centralmainabsence.add(labelABSview);
		Centralmainabsence.add(Epreuve);
		Centralmainabsence.add(Cours);
		Centralmainabsence.setVisible(false);
		
		
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
		
		

		
		bar=new JPanel();
		bar.setPreferredSize(new Dimension(300,1000));
		bar.setBackground(new Color(31,65,102,255));
		bar.setLayout(null);
		bar.add(Combo);
		bar.add(butnModule);
		bar.add(label2);
		bar.add(eleves);
		bar.add(absencePanel);
		bar.add(Profile);
		//bar.add(moduleP);
		bar.add(Sanction);
	
		
		Horizantalbar=new JPanel();
		Horizantalbar.setBackground(Color.DARK_GRAY);
		Horizantalbar.setPreferredSize(new Dimension(0,40));
		Horizantalbar.setLayout(null);
		Horizantalbar.add(btn2);
		Horizantalbar.add(label4);
		Horizantalbar.add(label5);
		Horizantalbar.add(field1);

		

		centerbar=new JPanel();
		centerbar.setBackground(Color.WHITE);
		centerbar.setLayout(null);
		centerbar.add(Student);
		centerbar.add(ViewAbsence);
		centerbar.add(module_header);
		centerbar.add(CenterPanel_Header);
		centerbar.add(CentralMainAbsence_hreader);
		centerbar.add(CenterPanel_Center);
		centerbar.add(sanct_header);
		centerbar.add(Centralmainabsence);
		centerbar.add(ProfilePanel);
		centerbar.add(NotCheck);
		centerbar.add(label9);
		centerbar.add(module_center);
		centerbar.add(Sanction_center);
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
	       
		
	
	
	
	
	
    	UIManager UI=new UIManager();
		UI.put("OptionPane.background", new Color(31,65,102,255));
		UI.put("panel.background", new Color(31,65,102,255));
	
	//Frame
	Gestion=new JFrame();
	Gestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Gestion.setVisible(true);
	Gestion.setLayout(new BorderLayout());
	Gestion.getContentPane().setBackground(Color.WHITE);
	Gestion.add(Horizantalbar,BorderLayout.NORTH);
	Gestion.add(bar,BorderLayout.WEST);
	Gestion.add(centerbar,BorderLayout.CENTER);
	Gestion.setExtendedState(JFrame.MAXIMIZED_BOTH);
	
}






public void setEmailPasww(ArrayList<String> tab1) throws SQLException {
	 modules=new SQLtraitement().getModule(tab1.get(0),tab1.get(1) );

	 
	 System.out.println(modules+"2");
	      
	
}

public void setEmail(String eMaiL2) throws ClassNotFoundException, SQLException {
	
	data=SQLtraitement.SelectionEtudiantExceptoinSql(eMaiL2);
	EMAIL=eMaiL2;
	HelpAbsence a=new HelpAbsence();
	a.setvalueEmail(eMaiL2);
	
}
public void setPassword(String password) {
	PASSW=password;
	
}
public String[][] getGlobalVariable() {
    return data; 
}
public String getGlobalVariableEmail() {
    return EMAIL; 
}
public String getGlobalVariablePass() {
    return PASSW; 
}
private void reorderTableModel() {
    TableColumnModel columnModel = table.getColumnModel();
    int columnCount = columnModel.getColumnCount();
    List<Object> columnIdentifiers = new ArrayList<>();
    List<Object[]> dataVector = new ArrayList<>();

    // Get the column identifiers and data vector in the new order
    for (int i = 0; i < columnCount; i++) {
        TableColumn column = columnModel.getColumn(i);
        int modelIndex = column.getModelIndex();
        columnIdentifiers.add(dtm.getColumnName(modelIndex));

        Object[] columnData = new Object[dtm.getRowCount()];
        for (int j = 0; j < dtm.getRowCount(); j++) {
            columnData[j] = dtm.getValueAt(j, modelIndex);
        }
        dataVector.add(columnData);
    }

    // Create a new table model with the new column order
    DefaultTableModel newModel = new DefaultTableModel(dataVector.toArray(new Object[][]{}), columnIdentifiers.toArray());
    table.setModel(newModel);
    dtm = newModel; // update the reference to the new model
}


@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource()==TRight) {
		scrollAjoutSanc.setVisible(true);
		TRight.setVisible(false);
		scrollAjoutSanc2.setVisible(false);
		Bsanc2.setVisible(true);
	}
	if(e.getSource()== Bsanc2) {
		Bsanc2.setVisible(false);
		labelAbsence.setVisible(true);
		scrollAjoutSanc.setVisible(false);
		TRight.setVisible(true);
		scrollAjoutSanc2.setVisible(true);
		  DefaultTableModel model = (DefaultTableModel) tableS2.getModel();
		    model.setRowCount(0); 
		    TableModel originalModel = tableS2.getModel();
			TableModel editableModel = new DefaultTableModel(originalModel.getRowCount(), originalModel.getColumnCount()) {
		        
		        public boolean isCellEditable(int row, int column) {
		        	
			    			if(column==4 || column==3) {
		    				return true;
		    			}
		    			else {
		    				return false;
		    			}
		        	
		        	
		    	}
	

		       
		    };
		 // Copy values from original model to new model
		    for (int i = 0; i < originalModel.getRowCount(); i++) {
		        for (int j = 0; j < originalModel.getColumnCount(); j++) {
		        	editableModel .setValueAt(originalModel.getValueAt(i, j), i, j);
		        }
		    }

		    tableS2.setModel(editableModel);
		    
		    
		   HelpAbsence aa =new HelpAbsence(); 
		   if(aa.getvalueCNE()!=0) {
		    String[][] rowData;
			try {
				rowData = new SQLtraitement().FichCNE(aa.getvalueCNE());
			
				  for (String[] row : rowData) {
				        Vector<String> rowDataVector = new Vector<String>();
				        System.out.println(Arrays.toString(row));
				        for (String cellValue : row) {
				            rowDataVector.add(cellValue);
				        }
				        ((DefaultTableModel) editableModel).addRow(rowDataVector);
				    }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
		   }
		    
	
	}
	
	if(e.getSource()==Bsanction) {
		TRight.setVisible(false);
		labelAbsence.setVisible(true);
		scrollAjoutSanc.setVisible(true);
	    sanctionentree.setVisible(false);
	    Bsanction.setVisible(false);
	    fieldS.setVisible(true);
		btnsearch.setVisible(true);
		Bsanc2.setVisible(true);
		scrollAjoutSanc2.setVisible(false);
		  NotCheck.setVisible(false);
		
		 
	}
	if(e.getSource()==sanc1) {
		TRight.setVisible(false);
		labelAbsence.setVisible(false);
		//sancsmalllabel.setVisible(true);
		Bsanc2.setVisible(false);
		scrollAjoutSanc2.setVisible(false);
		fieldS.setVisible(false);
		btnsearch.setVisible(false);
	    module_header.setVisible(false);
        CenterPanel_Header.setVisible(false);
		CentralMainAbsence_hreader.setVisible(false);
		sanct_header.setVisible(true);
		 Bsanction.setVisible(true);
		 sanctionentree.setVisible(true);
		 scrollAjoutSanc.setVisible(false);
		Student.setVisible(false);
		CenterPanel_Center.setVisible(false);
	    Centralmainabsence.setVisible(false);
		ProfilePanel.setVisible(false);
		label9.setVisible(false);
		module_center.setVisible(false);
		Sanction_center.setVisible(true);
		System.out.println("button check");
		  NotCheck.setVisible(false);
		
	}
	if(e.getSource()==RME) {
		
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
	if(e.getSource()==moduleB) {
		sanct_header.setVisible(false);
		Sanction_center.setVisible(false);
		ModuleEntree.setVisible(true);
		BModule.setVisible(true);
		Student.setVisible(false);
		ViewAbsence.setVisible(false);
		CenterPanel_Header.setVisible(false);
		CentralMainAbsence_hreader.setVisible(false);
		CenterPanel_Center.setVisible(false);
		Centralmainabsence.setVisible(false);
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
	
	if(e.getSource()==SearchBabs) {
		SQLtraitement sql=new SQLtraitement();
		 String input=SearchTabs.getText();
		 String[][] DATA;
		 DefaultTableModel model3 = (DefaultTableModel) tableabsence.getModel();
		    model3.setRowCount(0); 
		    TableModel originalModel3 = tableabsence.getModel();
			TableModel editableModel3 = new DefaultTableModel(originalModel3.getRowCount(), originalModel3.getColumnCount()) {
		        
		        public boolean isCellEditable(int row, int column) {
		        	
		    			if(column==5  )
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

		    tableabsence.setModel(editableModel3);
		    
		 if(!input.equals("")&&Absence2.getSelection()!=null) {
			    boolean allDate=input.matches("^\\d{4}-\\d{2}-\\d{2}$");
				boolean allDateY1=input.matches("^\\d{4}-");
				boolean allDateY2=input.matches("^\\d{4}");
				boolean allDateM1=input.matches("^\\d{4}-\\d{2}-");
				boolean allDateM2=input.matches("^\\d{4}-\\d{2}");
				boolean allDateD=input.matches("^\\d{4}-\\d{2}-\\\\d{2}$");
				boolean alldate = input.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}$");

		   if(allDate||allDateY1||allDateY2||allDateM1||allDateM2||allDateD||alldate) {
			   try {
				 DATA=sql.searchabsenceDate( input,Absence2.getSelection().getActionCommand());
			for (String[] row :   DATA) {
				        Vector<String> rowDataVector = new Vector<String>();
				        for (String cellValue : row) {
				            rowDataVector.add(cellValue);
				        }
				        ((DefaultTableModel) editableModel3).addRow(rowDataVector);
				}
				System.out.println(Arrays.deepToString(sql.searchabsenceDate( input,Absence2.getSelection().getActionCommand())));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   System.out.println("it hs a date patten");
		   }
		   else {
			   try {
					 DATA=sql.searchabsencemodule(input,Absence2.getSelection().getActionCommand());
						for (String[] row :   DATA) {
							        Vector<String> rowDataVector = new Vector<String>();
							        for (String cellValue : row) {
							            rowDataVector.add(cellValue);
							        }
							        ((DefaultTableModel) editableModel3).addRow(rowDataVector);
							}
				   System.out.println();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   System.out.println("other than date");
		   }
		
		 }
		 
		 if(input.equals("")) {
			 System.out.println("Empty ");
		 }
	}
	if(e.getSource()==BStudent) {
		Student.setVisible(false);
		CenterPanel_Center.setVisible(true);
		sanct_header.setVisible(false);
		
	}
	if(e.getSource()==labelABSnew) {

	}
	if(e.getSource()==labelABSview) {
		ViewAbsence.setVisible(true);
		Centralmainabsence.setVisible(false);

	}
	
	if(e.getSource()==btnabsence) {
		sanct_header.setVisible(false);
		Sanction_center.setVisible(false);
		module_header.setVisible(false);
		CenterPanel_Center.setVisible(false);
		Centralmainabsence.setVisible(true);
		CentralMainAbsence_hreader.setVisible(true);
		CenterPanel_Header.setVisible(false);
		ProfilePanel.setVisible(false);
        label9.setVisible(false);
        Student.setVisible(false);
        ViewAbsence.setVisible(false);
        NotCheck.setVisible(false);
        module_center.setVisible(false);

   	 
		DefaultTableModel model3 = (DefaultTableModel) tableabsence.getModel();
	    model3.setRowCount(0); 
	    TableModel originalModel3 = tableabsence.getModel();
		TableModel editableModel3 = new DefaultTableModel(originalModel3.getRowCount(), originalModel3.getColumnCount()) {
	        
	        public boolean isCellEditable(int row, int column) {
	        	
	    			if(column==5  )
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

	    tableabsence.setModel(editableModel3);
	     try {
			for (String[] row :   new SQLtraitement().selectionFichierAbsence()) {
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
    if(e.getSource()==note) {
    	note.setForeground(new Color(31,65,102,255));
    	note.setBorder(feild3B);
    	btn5.setBorder(feildB);
    	btn5.setForeground(Color.LIGHT_GRAY);
    	Search.setVisible(false);
    	radiodate.setVisible(false);
    	radioNom.setVisible(false);
    	radioPrenom.setVisible(false);
    	radioCne.setVisible(false);
    	radioApogge.setVisible(false);
    	radioId.setVisible(false);
    	radiodesc.setVisible(false);
    	radioasc.setVisible(false);
    	field2.setVisible(false);
    	scroll.setVisible(false);
    	scrollAjout.setVisible(false);
    	AjoutEtudiant.setVisible(false);
    	NotePanel.setVisible(true);
    }
    if(e.getSource()==btn5) {
    	note.setBorder(feildB);
    	note.setForeground(Color.LIGHT_GRAY);
    	btn5.setBorder(feild1B);
    	btn5.setForeground(new Color(31,65,102,255));
    	Search.setVisible(true);
    	radiodate.setVisible(true);
    	radioNom.setVisible(true);
    	radioPrenom.setVisible(true);
    	radioCne.setVisible(true);
    	radioApogge.setVisible(true);
    	radioId.setVisible(true);
    	radiodesc.setVisible(true);
    	radioasc.setVisible(true);
    	field2.setVisible(true);
    	scroll.setVisible(true);
    	scrollAjout.setVisible(true);
    	AjoutEtudiant.setVisible(true);
    	NotePanel.setVisible(false);
   
    }
	if(e.getSource()==openlettre) {
		SQLtraitement sqlT=	new SQLtraitement();
		PassWordUpdate.setText(getGlobalVariablePass());
		  try {
			  ArrayList arry=sqlT.getEnseignat(getGlobalVariableEmail(),getGlobalVariablePass());
			  enseignatCodeUpdate.setText(String.valueOf( arry.get(0)));
			  Nom.setText((String) arry.get(1));
			  Prenom.setText((String) arry.get(2));
			  FonctionUpdate.setText((String) arry.get(3));
			  EtatUpdate.setText((String) arry.get(4));
			  StatusUpdate.setText((String) arry.get(5));
			  DepartementUpdate.setText((String) arry.get(6));
			  DateDeNaissanceUpdate.setText(String.valueOf( arry.get(7)));
			  EmailUpdate.setText(getGlobalVariableEmail());
			  PassWordUpdate.setText(getGlobalVariablePass());
			  
			  
			  
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	if(e.getSource()==Check) {
		
		 SQLtraitement sqlT=	new SQLtraitement();
		 String nom= Nom.getText();
		 String prenom= Prenom.getText();
		 String email=EmailUpdate.getText();
         String date= DateDeNaissanceUpdate.getText();
         String code=  enseignatCodeUpdate.getText();
	     String deprt= DepartementUpdate.getText();
		 String fonction=FonctionUpdate.getText();
		 String etat=EtatUpdate.getText();
		 String status=StatusUpdate.getText();
		
		 if(email.contains("@")&&email.contains(".com")&&code.matches("\\d+")&&date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
			 try {
				sqlT.UpdateEnseignatSql(nom, prenom, email, date, code, deprt, fonction, etat,status,getGlobalVariablePass());
				JOptionPane.showMessageDialog(Gestion, " Yes! your information are updated !                             ");
			 } catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 }
		 else {
			 JOptionPane.showMessageDialog(Gestion, "ReCheck your information !                   ");
		 }
		 
		 
		 
	   
	}

	
	if(e.getSource()==Search ) {
		int test=2;
		DefaultTableModel model3 = (DefaultTableModel) table.getModel();
	    model3.setRowCount(0); 
	    TableModel originalModel3 = table.getModel();
		TableModel editableModel3 = new DefaultTableModel(originalModel3.getRowCount(), originalModel3.getColumnCount()) {
	        
	        public boolean isCellEditable(int row, int column) {
	        	
	    			if(column==11  )
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

	    table.setModel(editableModel3);
		//----------------------------
	
		SQLtraitement sqlT=	new SQLtraitement();
		String search=field2.getText();
		String[][] rowData = {{null,null,null,null,null,null,null,null,null,null,null}} ;
		String[][] Nullrow= new String[0][11];
		String[][] dataD1 = {{null,null,null,null,null,null,null,null,null,null,null}} ;
		String[][] dataD2 = null;
		String[][] dataC1 = null;
		String[][] dataC2 = null;
		if(!search.equals("")) {
		boolean allDigits = search.matches("\\d+"); 
		boolean allDate=search.matches("^\\d{4}-\\d{2}-\\d{2}$");
		boolean allDateY1=search.matches("^\\d{4}-");
		boolean allDateY2=search.matches("^\\d{4}");
		boolean allDateM1=search.matches("^\\d{4}-\\d{2}-");
		boolean allDateM2=search.matches("^\\d{4}-\\d{2}");
		boolean allDateD=search.matches("^\\d{4}-\\d{2}-\\\\d{2}$");
		
		if(groupR.getSelection()!=null) {
			if(groupR.getSelection().getActionCommand().equals("etud_id")) {
				try { if (allDigits) {
					System.out.println("id");
					//dataD1=sqlT.getEtudiantId(Integer.parseInt(search),getGlobalVariableEmail());
					dataD1=sqlT.getEtudiantElm(search, getGlobalVariableEmail(),groupR.getSelection().getActionCommand());
					System.out.println(Arrays.deepToString(dataD1));
					}
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
            if(groupR.getSelection().getActionCommand().equals("nom")) {
            	try {
	
					dataD1=sqlT.getEtudiantElm(search, getGlobalVariableEmail(),groupR.getSelection().getActionCommand());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	System.out.println("search"+"nom");
			}
            if(groupR.getSelection().getActionCommand().equals("prenom")) {
            	try {
            		dataD1=sqlT.getEtudiantElm(search, getGlobalVariableEmail(),groupR.getSelection().getActionCommand());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	System.out.println("search"+"prenom");
			}
            if(groupR.getSelection().getActionCommand().equals("cne")) {
            	try { if (allDigits) {
            		dataD1=sqlT.getEtudiantElm(search, getGlobalVariableEmail(),groupR.getSelection().getActionCommand());}
            	  
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
			}
            if(groupR.getSelection().getActionCommand().equals("apogee")) {
            	try {if (allDigits) {
            		dataD1=sqlT.getEtudiantElm(search, getGlobalVariableEmail(),groupR.getSelection().getActionCommand());}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	System.out.println("search"+"apogee");
			}
           
            if(groupR.getSelection().getActionCommand().equals("date_naissance")) {
            	 
            	try {  
            		if(allDate||allDateY2||allDateY1||allDateM1||allDateM2||allDateD) {

            			dataD1=sqlT.getEtudiantElm(search, getGlobalVariableEmail(),groupR.getSelection().getActionCommand());
					}
            	 
            	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
            
           rowData=dataD1;
			
			
		}
        if(groupR.getSelection()==null) {
		if (allDigits) {
			try {
				dataD1=sqlT.getEtudiantCne(Integer.parseInt(search),getGlobalVariableEmail());
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			try {
				dataD2=sqlT.getEtudiantApogee(Integer.parseInt(search),getGlobalVariableEmail());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			test=1; 
			if(!Arrays.deepEquals(dataD1, Nullrow)&&!Arrays.deepEquals(dataD2, Nullrow)) {
				String[][] result = new String[dataD1.length + dataD2.length][dataD1[0].length];
				for (int i = 0; i < dataD1.length; i++) {
				    System.arraycopy(dataD1[i], 0, result[i], 0,dataD1[i].length);
				}
				for (int i = 0; i <dataD2.length; i++) {
				    System.arraycopy(dataD2[i], 0, result[i + dataD1.length], 0, dataD2[i].length);
				}
				
				rowData=result ;
			}
			
			
			
			if(Arrays.deepEquals(dataD1, Nullrow)) {
				rowData=dataD2;
			}
			if(Arrays.deepEquals(dataD2, Nullrow)) {
				rowData=dataD1;
			}
			
			
			
			
		} 
        
		ArrayList<Boolean> testallcaracter=new ArrayList<>();
		 for (char c : search.toCharArray()) {
		        if (Character.isDigit(c)) {
		        	testallcaracter.add(false);
		        }
		        else {
		        	testallcaracter.add(true);
		        }
		    }
		 int size = testallcaracter.size(); 
		 ArrayList<Boolean> list = new ArrayList<>(Collections.nCopies(size, true));
		 if(list.equals(testallcaracter)) {
			 try {
				dataC1=sqlT.getEtudiantNom(search,getGlobalVariableEmail());
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			 try {
				dataC2=sqlT.getEtudiantPrenom(search,getGlobalVariableEmail());
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			 test=0;
			 if(!Arrays.deepEquals(dataC1, Nullrow)&&!Arrays.deepEquals(dataC2, Nullrow)) {
					String[][] result = new String[dataC1.length + dataC2.length][dataC1[0].length];
					for (int i = 0; i < dataC1.length; i++) {
					    System.arraycopy(dataC1[i], 0, result[i], 0,dataC1[i].length);
					}
					for (int i = 0; i <dataC2.length; i++) {
					    System.arraycopy(dataC2[i], 0, result[i + dataC1.length], 0, dataC2[i].length);
					}
					
					rowData=result ;
				}
			 
			 if(Arrays.deepEquals(dataC1, Nullrow)) {
					rowData=dataC2;
					
				}
				if(Arrays.deepEquals(dataC2, Nullrow)) {
					rowData=dataC1;
				}
				
		 }
		 
        }

		if(search.equals("")) {
			System.out.println("empty field");
		}
		if(test==2) {
	
			System.out.println(" search contains both digit and charcters");
		}
		 for (String[] row : rowData) {
		        Vector<String> rowDataVector = new Vector<String>();
		        for (String cellValue : row) {
		            rowDataVector.add(cellValue);
		        }
		        ((DefaultTableModel) editableModel3).addRow(rowDataVector);
		    }
		 
		}
      
		

	}

	if(e.getSource()==butnModule) {
		Sanction_center.setVisible(false);
		    DefaultTableModel model = (DefaultTableModel) table.getModel();
		    model.setRowCount(0); 
		    TableModel originalModel = table.getModel();
			TableModel editableModel = new DefaultTableModel(originalModel.getRowCount(), originalModel.getColumnCount()) {
		        
		        public boolean isCellEditable(int row, int column) {
		        	
		    			if(column==11  )
		    			{ 
		    				return true;
		    			}
		    			else {
		    				return false;
		    			}
		        	
		        	
		    	}
	

		       
		    };
		 // Copy values from original model to new model
		    for (int i = 0; i < originalModel.getRowCount(); i++) {
		        for (int j = 0; j < originalModel.getColumnCount(); j++) {
		        	editableModel .setValueAt(originalModel.getValueAt(i, j), i, j);
		        }
		    }

		    table.setModel(editableModel);
		    
		    
		   
		    if(groupR.getSelection()==null||groupR2.getSelection()==null) {
		    String[][] rowData = getGlobalVariable();
		    for (String[] row : rowData) {
		        Vector<String> rowDataVector = new Vector<String>();
		        for (String cellValue : row) {
		            rowDataVector.add(cellValue);
		        }
		        ((DefaultTableModel) editableModel).addRow(rowDataVector);
		    }
		    
		    }
		
		String[] items=new String[modules.size()];
		items= modules.toArray(items);
		DefaultComboBoxModel<String> modelCombo = (DefaultComboBoxModel<String>)  Combo.getModel();
		modelCombo.removeAllElements();
		for (String item : items) {
			
	       Combo.addItem(item);
	    }
		
		if(groupR.getSelection()!=null&&groupR2.getSelection()!=null) {
			   try {
					String[][] rowData2 =SQLtraitement.SelectionEtudiantExceptoinSql( getGlobalVariableEmail(), groupR.getSelection().getActionCommand(),groupR2.getSelection().getActionCommand());
					for (String[] row : rowData2) {
				        Vector<String> rowDataVector = new Vector<String>();
				        for (String cellValue : row) {
				            rowDataVector.add(cellValue);
				        }
				        ((DefaultTableModel) editableModel).addRow(rowDataVector);
				    }
			    
			   } catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
			 
			   }
		
		
	
		
	}
	if(e.getSource()==btn2) {
		try {
			new FrameL();
			Gestion.dispose();
			
		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		}
	}
	if(e.getSource()==btn1) {
		scrollAjout.setVisible(false);
		Sanction_center.setVisible(false);
		 CenterPanel_Center.setVisible(false);
		  ProfilePanel.setVisible(false);
		  CenterPanel_Header.setVisible(true);
		  Student.setVisible(true);
          label9.setVisible(false);
          Centralmainabsence.setVisible(false);
          ViewAbsence.setVisible(false);
          NotCheck.setVisible(false);
          module_header.setVisible(false);
          module_center.setVisible(false);
  		
          
	}
	if(e.getSource()==Profile) {
		try {
			
			 arryEnseignt=new SQLtraitement().getEnseignat(getGlobalVariableEmail(),getGlobalVariablePass());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sanct_header.setVisible(false);
		Sanction_center.setVisible(false);
		module_header.setVisible(false);
	    module_center.setVisible(false);
		ViewAbsence.setVisible(false);
		Centralmainabsence.setVisible(false);
		CentralMainAbsence_hreader.setVisible(false);
		Student.setVisible(false);
		CentralMainAbsence_hreader.setVisible(false);
		CenterPanel_Center.setVisible(false);
		ProfilePanel.setVisible(true);
		CenterPanel_Header.setVisible(false);
        label9.setVisible(true);
        NomComplet.setText(arryEnseignt.get(1)+"-"+arryEnseignt.get(2));
    	Email.setText(getGlobalVariableEmail());
        DateDeNaissance.setText(String.valueOf(arryEnseignt.get(7)));
    	enseignatCode.setText(String.valueOf(arryEnseignt.get(0)));
    	Departement.setText(String.valueOf(arryEnseignt.get(6)));

         
            
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
	if(e.getSource()==btn4) {
		notcheckajout.setVisible(true);
		scrollAjout.setVisible(true);
		btn4.setVisible(false);
		scrollAjout.setVisible(true);
		label7.setVisible(false);
		AjoutEtudiant.setVisible(true);
	}
	
	if(e.getSource()==AjoutEtudiant) {
		 
		
			
			try {
		
		// Get the currently selected cell in the JTable
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();

        // Stop cell editing in the JTable
        if (tableAjout.isEditing()) {
        	tableAjout.getCellEditor().stopCellEditing();
        }
        if(tableAjout.getValueAt(0, 0)!=null&&tableAjout.getValueAt(0, 6)!=null&&tableAjout.getValueAt(0, 1)!=null&&tableAjout.getValueAt(0, 2)!=null&&tableAjout.getValueAt(0, 3)!=null&&tableAjout.getValueAt(0, 4)!=null&&tableAjout.getValueAt(0, 5)!=null&&tableAjout.getValueAt(0, 7)!=null&&tableAjout.getValueAt(0, 8)!=null&&tableAjout.getValueAt(0, 9)!=null) {
      
                KeyEvent enterEvent = new KeyEvent(tableAjout, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, '\n');
                tableAjout.dispatchEvent(enterEvent);
                int cne=Integer.parseInt((String) tableAjout.getValueAt(0, 0));
		      	String value=(String) tableAjout.getValueAt(0, 6) ;
		        String dateString = value.toString();
		        LocalDate dateN = LocalDate.parse(dateString);
			    String nom=(String)tableAjout.getValueAt(0, 1);
			    String prenom=(String)tableAjout.getValueAt(0, 2);
			    String etat=(String) tableAjout.getValueAt(0, 3);
			    int apogee=Integer.parseInt((String) tableAjout.getValueAt(0, 4));
			    String diplome=(String)tableAjout.getValueAt(0, 5);
			    String niveau=(String)tableAjout.getValueAt(0, 7);
			    String tele=(String)tableAjout.getValueAt(0, 8);
			    String adresse=(String)tableAjout.getValueAt(0, 9);
			   
            if(!new SQLtraitement().CNE().contains(cne)) {
			new SQLtraitement().AjoutEtud(cne,nom,prenom,etat, apogee ,diplome,dateN,niveau,tele,adresse);
		     tableAjout.setBackground(Color.GREEN);
		     System.out.println("it happend");
		     }
            
            if(new SQLtraitement().CNE().contains(cne)) {
            	tableAjout.setBackground(Color.red);
           	 System.out.println("already existing");
            }
		}
        else {
        	 tableAjout.setBackground(Color.red);
        	 System.out.println("it did not happend");
            }
			} 
			
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}
	
			
		
	

	 
	
	
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
	if(e.getSource()==btn1) {
		btn1.setBackground(Color.DARK_GRAY);
     eleves.setBackground(Color.DARK_GRAY);
	}
	if(e.getSource()==btnabsence) {
		btnabsence.setBackground(Color.DARK_GRAY);
		absencePanel.setBackground(Color.DARK_GRAY);
	}                                                           
	if(e.getSource()==moduleB) {
		moduleP.setBackground(Color.DARK_GRAY);
		moduleB.setBackground(Color.DARK_GRAY);
	}
	if(e.getSource()==sanc1) {
		sanc1.setBackground(Color.DARK_GRAY);
		Sanction.setBackground(Color.DARK_GRAY);
	}
	
}



@Override
public void mouseExited(MouseEvent e) {
	if(e.getSource()==btn1) {
		btn1.setBackground(new Color(31,65,102,255));
	     eleves.setBackground(new Color(31,65,102,255));
		}
	if(e.getSource()==btnabsence) {
		btnabsence.setBackground(new Color(31,65,102,255));
		absencePanel.setBackground(new Color(31,65,102,255));
	}
	if(e.getSource()==moduleB) {
		moduleP.setBackground(new Color(31,65,102,255));
		moduleB.setBackground(new Color(31,65,102,255));
	}
	if(e.getSource()==sanc1) {
		sanc1.setBackground(new Color(31,65,102,255));
		Sanction.setBackground(new Color(31,65,102,255));
	}
}
public void SetLoginName(String nom) {
	field1.setText(nom);
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
public void actionPerformed(ActionEvent e) {
	

		for (int i = 0; i < Combomodule1.getItemCount(); i++) {
		    final int index = i;
		    Combomodule1.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	
		            if (Combomodule1.getSelectedIndex() == index) {
		            	
		            	moduleE=(String) Combomodule1.getItemAt(index);
		            	System.out.println(moduleE);
		            }
		            }
		        });
		    }
		
		for (int i = 0; i < Combomodule2.getItemCount(); i++) {
		    final int index = i;
		    Combomodule2.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	
		            if (Combomodule2.getSelectedIndex() == index) {
		            	
		            	moduleN=(String) Combomodule2.getItemAt(index);
		            	System.out.println(moduleN);
		            }
		            }
		        });
		    }
		
		for (int i = 0; i < Comboniveau.getItemCount(); i++) {
		    final int index = i;
		    Comboniveau.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	
		            if (Comboniveau.getSelectedIndex() == index) {
		            	niveau=(String)Comboniveau.getItemAt(index);
		            	System.out.println(niveau);
		            }
		            }
		        });
		    }
		
		for (int i = 0; i < Comboenseig.getItemCount(); i++) {
		    final int index = i;
		    Comboenseig.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	
		            if (Comboenseig.getSelectedIndex() == index) {
		            	nomenseig=(String)Comboenseig.getItemAt(index);
		            	System.out.println(nomenseig);
		            }
		            }
		        });
		    }
		
		for (int i = 0; i < Combomodule1.getItemCount(); i++) {
		    final int index = i;
		    Combomodule1.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	
		            if (Combomodule1.getSelectedIndex() == index) {
		            	System.out.println(Combomodule1.getItemAt(index));
		            }
		            }
		        });
		    }
	
	
	
     		for (int i = 0; i < Combo.getItemCount(); i++) {
     		    final int index = i;
     		    Combo.addActionListener(new ActionListener() {
     		        public void actionPerformed(ActionEvent e) {
     		        	
     		            if (Combo.getSelectedIndex() == index) {
     		            	DefaultTableModel model = (DefaultTableModel) table.getModel();
     		       		    model.setRowCount(0); 
     		       		    TableModel originalModel = table.getModel();
     		       			TableModel editableModel = new DefaultTableModel(originalModel.getRowCount(), originalModel.getColumnCount()) {
     		       		        
     		       		        public boolean isCellEditable(int row, int column) {
     		       		        	
     		       		    			if(column==11  )
     		       		    			{ 
     		       		    				return true;
     		       		    			}
     		       		    			else {
     		       		    				return false;
     		       		    			}
     		       		        	
     		       		        	
     		       		    	}
     		       	

     		       		       
     		       		    };
     		       		 // Copy values from original model to new model
     		       		    for (int i = 0; i < originalModel.getRowCount(); i++) {
     		       		        for (int j = 0; j < originalModel.getColumnCount(); j++) {
     		       		        	editableModel .setValueAt(originalModel.getValueAt(i, j), i, j);
     		       		        }
     		       		    }

     		       		    table.setModel(editableModel);
     		       		    
     		       		    
     		       		DefaultTableModel modelnote = (DefaultTableModel) tablenote.getModel();
 		       		    modelnote.setRowCount(0); 
 		       		    TableModel originalModelnote = tablenote.getModel();
 		       			TableModel editableModelnote = new DefaultTableModel(originalModelnote.getRowCount(), originalModelnote.getColumnCount()) {
 		       		        
 		       		        public boolean isCellEditable(int row, int column) {
 		       		        	
 		       		    			if(column==8  )
 		       		    			{ 
 		       		    				return true;
 		       		    			}
 		       		    			else {
 		       		    				return false;
 		       		    			}
 		       		        	
 		       		        	
 		       		    	}
 		       	

 		       		       
 		       		    };
 		       		 // Copy values from original model to new model
 		       		    for (int i = 0; i < originalModelnote.getRowCount(); i++) {
 		       		        for (int j = 0; j < originalModelnote.getColumnCount(); j++) {
 		       		        	editableModelnote .setValueAt(originalModelnote.getValueAt(i, j), i, j);
 		       		        }
 		       		    }

 		       		    tablenote.setModel(editableModelnote);   

 		       		new Help().setvalueCombo((String) Combo.getItemAt(index));
 		       		new HelpAbsence().setvalueCombo((String) Combo.getItemAt(index));
 		
     		       		if(groupR.getSelection()==null||groupR2.getSelection()==null) {
     		            	try {
    
     		       		    String[][] rowData = new SQLtraitement().SelectionEtudiantModuleExceptoinSql(EMAIL, (String) Combo.getItemAt(index));
     		       		    for (String[] row : rowData) {
     		       		        Vector<String> rowDataVector = new Vector<String>();
     		       		        for (String cellValue : row) {
     		       		            rowDataVector.add(cellValue);
     		       		        }
     		       		    ((DefaultTableModel) editableModel).addRow(rowDataVector);
     		       		    }
								
							} catch (ClassNotFoundException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
     		       		}
     		            	if(groupR.getSelection()!=null&&groupR2.getSelection()!=null) {
         		       			
          					   try {
          					System.out.println(groupR2.getSelection().getActionCommand());
          							String[][] rowData2 =new SQLtraitement().SelectionEtudiantModuleExceptoinSql(EMAIL, (String) Combo.getItemAt(index),groupR.getSelection().getActionCommand(),groupR2.getSelection().getActionCommand());
          							System.out.println(Arrays.deepToString(rowData2));
          							for (String[] row : rowData2) {
          						        Vector<String> rowDataVector = new Vector<String>();
          						        for (String cellValue : row) {
          						            rowDataVector.add(cellValue);
          						        }
          						        ((DefaultTableModel) editableModel).addRow(rowDataVector);
          						    }
          					    
          					   } catch (ClassNotFoundException | SQLException e1) {
          							// TODO Auto-generated catch block
          							e1.printStackTrace();
          						}
          						  
          					 
          					   }
     		     //Note
     		            	
         		       		try {
         		       	     
    							String[][] rowDatanote = new SQLtraitement().SelectionEtudiantModuleNote(EMAIL,(String) Combo.getItemAt(index));
    							for (String[] row : rowDatanote) {
      						        Vector<String> rowDataVectornote = new Vector<String>();
      						        for (String cellValue : row) {
      						            rowDataVectornote.add(cellValue);
      						        }
      						        	float note1=0.0f;
           		       	                float	note2=0.0f;
           		       	                int id=new SQLtraitement().moduleId((String) Combo.getItemAt(index));
      						        if(!new SQLtraitement().selectionNotes(Integer.parseInt(row[0]),id).isEmpty()) {
      						        	note1=(float) new SQLtraitement().selectionNotes(Integer.parseInt(row[0]),id).get(0);
      						        	System.out.println(note1+"note1");
      						        	note2=(float) new SQLtraitement().selectionNotes(Integer.parseInt(row[0]),id).get(1);
      						        	System.out.println(note2+"note2");
      						        }
      						         if(note1==0.0f&&note2!=0.0f) {
      						         rowDataVectornote.add(String.valueOf(null));
      						         rowDataVectornote.add(String.valueOf(note2));
      						         }
      						         else if(note2==0.0f&&note1!=0.0f) {
        						         rowDataVectornote.add(String.valueOf(note1));
        						         rowDataVectornote.add(null);
        						     }
      						         else if(note1!=0.0f&&note2!=0.0f) {
      						         rowDataVectornote.add(String.valueOf(note1));
      						          rowDataVectornote.add(String.valueOf(note2));
      						         }
      						         else if(note2==0.0f&&note1==0.0f) {
        						         rowDataVectornote.add(null);
        						         rowDataVectornote.add(null);
        						         }
      						      
      						        
      						        
      						        ((DefaultTableModel) editableModelnote).addRow(rowDataVectornote);
      						    }
    							
    							
      					    
    						
         		       		} catch (ClassNotFoundException | SQLException e2) {
    							// TODO Auto-generated catch block
    							e2.printStackTrace();
    						}
     		            	
     		            	
     		    }
     		        }
     		    });
     		}
     	if(e.getSource()==RME) {
     		SQLtraitement sql=new SQLtraitement();
     		if(!moduleE.equals("")&& !nomenseig.equals("")) {
     			try {
					sql.registerME(sql.toutEnseignt().get(nomenseig), sql.passEn().get(sql.toutEnseignt().get(nomenseig)), sql.moduleId(moduleE));
					JOptionPane.showInternalMessageDialog(Gestion, "l'Enseignat "+nomenseig+" est responsable au module "+moduleE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
     		}
     		
     	}
     	if(e.getSource()==RMN) {
     		SQLtraitement sql=new SQLtraitement();
     		if(!moduleN.equals("")&&!niveau.equals("")) {
     			try {
					sql.registerNM(niveau, moduleN);
					JOptionPane.showInternalMessageDialog(Gestion, "le module "+moduleN+" est affecté "+"au "+niveau);
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
	   
	   if(e.getSource()==labelABSnew) {
		   System.out.println("TEST NEW");
		   int id=0;
		   Help a =new Help();
		   HelpAbsence aa=new HelpAbsence();
          SQLtraitement sql=  new SQLtraitement();
              try {
				ID=sql.fichId();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       
           if(Absence.getSelection()!=null) {
    		 System.out.println(ID+" "+a.getvalueCombo() +" "+Absence.getSelection().getActionCommand()+" : Absence");
    		   }
    		if(Absence.getSelection()==null) {
    		       System.out.println(ID+" "+a.getvalueCombo()+" "+" no radio selected : Absence");
    		 }
    		if(Absence.getSelection()!=null&&a.getvalueCombo()!=null) {
    		try {
    			aa.setvalueId(ID);
    			sql.newFich(ID, sql.moduleId(a.getvalueCombo()), Absence.getSelection().getActionCommand());
    			
    		     
    			FichierAbsence FICHE=	new FichierAbsence();
    			FICHE.field1.setText(new SQLtraitement().getEnseignat(getGlobalVariableEmail(),getGlobalVariablePass()).get(1)+" "+new SQLtraitement().getEnseignat(getGlobalVariableEmail(),getGlobalVariablePass()).get(2));//prof
    			FICHE.field2.setText(a.getvalueCombo());//module
    			FICHE.field4.setText(Absence.getSelection().getActionCommand());
    			
    			
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		Gestion.dispose();
    		}
    		       		
    		         
    		
    		
    		
    		
	   }
	
}

 
}