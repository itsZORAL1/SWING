package MAIN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;


import SQL.SQLtraitement;
import Stylingfolder.AlternatingRowColorRenderer;
import Stylingfolder.CustomButton;
import Stylingfolder.CustomTableCellRender;

public class FichierAbsence  implements ActionListener{
	//Frame
	JFrame frameAbsence=new JFrame();
	
	//Date
	LocalDate date=LocalDate.now();
	
	
	
	//IconImage
	ImageIcon imageIcon1;
	ImageIcon imageIcon2;
	ImageIcon imageIcon3;
	ImageIcon imageIcon4;
	ImageIcon imageIcon5;
	ImageIcon imageIcon6;
	
	
	//LABEL
	JLabel label1 ;
	JLabel label2 ;
	JLabel label3 ;
	JLabel label4 ;
	JLabel label5 ;
	JLabel label6 ;
	JLabel label7 ;
	JLabel label8 ;
	JLabel label9 ;
	
	//TextFiled
	public JTextField field1;
	public  JTextField field2;
	public JTextField field3;
	public  JTextField field4;
	public  JTextField field5;
	JTextField field6;
	
	//Border
	Border feild1B;
	Border feild2B;
	
	//JTableVariable
	public DefaultTableModel dtm;
	public JTable table;
	JScrollPane scroll;
	JCheckBox check;
	JScrollBar scrollbar ;
	
	//Button
	CustomButton myButton;
	CustomButton myButtonOut;
	public JButton add;
	
	//Panel 
	JPanel panel1;
	JPanel panel2; 
	public String[][] data;
	
	ArrayList checkvalue=new ArrayList<>();
	static Boolean[] checkBoxValues;
	
	public FichierAbsence () throws IOException, ClassNotFoundException, SQLException {
		
		
		
		
		//Border
				feild1B=BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(31,65,102,255));
				feild2B=BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
		
		//JtableVariable Jtable and JScrollPane
	   HelpAbsence a=new HelpAbsence();
	   System.out.println(a.getvalueEmail()+" "+a.getvalueCombo());
		String[] fields= {"CNE","Nom","Prenom","ID"};
		
		SQLtraitement traitement=new SQLtraitement();
		data=SQLtraitement.SelectionEtudiantModuleABsence(a.getvalueEmail(),a.getvalueCombo());
	    
		 dtm=new DefaultTableModel (data,fields){
			private static final long serialVersionUID = 1L;
			@Override
			 public boolean isCellEditable(int row,int column) {
				if(column==4||column==5 )
				{ 
					return true;
				}
				else {
					return false;
				}
			 } 
			
			@Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) {
                    return Boolean.class; // set the checkbox column to Boolean class
                }
                return super.getColumnClass(columnIndex);
            }
        };
        Vector<Boolean> vector = new Vector<Boolean>(SQLtraitement.intialisingCheckbox(a.getvalueEmail(),a.getvalueCombo()));
       // Vector<Integer> vector1 = new Vector<Integer>(SQLtraitement.EtudiantId());
        dtm.addColumn("",vector );
        table =new JTable(dtm);

        table.setAutoCreateColumnsFromModel(false);
   		scroll=new JScrollPane(table);
   	    check = new JCheckBox();
   		check.setBackground(Color.BLUE); 
   		DefaultCellEditor checkBoxEditor = new DefaultCellEditor(check);
   		table.getColumnModel().getColumn(4).setCellRenderer(new CheckBoxRenderer());
		table.getColumnModel().getColumn(4).setCellEditor(checkBoxEditor);
		table.getColumnModel().getColumn(4).setPreferredWidth(check.getPreferredSize().width);
        table.getColumnModel().getColumn(4).setMaxWidth(18);
        table.getTableHeader().setBackground(new Color(31,65,102,255));
        table.getTableHeader().setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,14));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setBorder(feild2B);
        table.setDefaultRenderer(Object.class, new CustomTableCellRender(table));
        table.getTableHeader().setAlignmentX(JTable.CENTER_ALIGNMENT);
        table.getModel().addTableModelListener(e -> {
            if (e.getType() == e.UPDATE && e.getColumn() == 4) {
                int row = e.getFirstRow();
                int col = e.getColumn();
                Boolean value = (Boolean) table.getValueAt(row, col);
                DefaultTableModel dtm2 = (DefaultTableModel) table.getModel();
                int checkboxColumnIndex = 4;
                 checkBoxValues = new Boolean[dtm2.getRowCount()];
                for (int i = 0; i < dtm2.getRowCount(); i++) {
                    checkBoxValues[i] = (Boolean) dtm2.getValueAt(i, checkboxColumnIndex);
                }
               // print the checkbox values
               
            }
        });
      	 table.getColumnModel().moveColumn(3, 0);
         int newIndex = table.convertColumnIndexToModel(0);

        // for(int i=0; i<vector1.size(); i++) {
    	 // dtm.setValueAt(vector1.get(i), i, newIndex);}
          table.getColumnModel().getColumn(0).setMaxWidth(100);
          System.out.println(Arrays.deepToString(SQLtraitement.SelectionEtudiantModuleABsence(a.getvalueEmail(),a.getvalueCombo())));
          table.setRowHeight(40);
          int columnIndex = 4; // index of the second column
          int preferredWidth = 150; // new preferred width in pixels*

          TableColumn column = table.getColumnModel().getColumn(columnIndex);
          column.setPreferredWidth(preferredWidth);
          table.setRowHeight(40);
         
         

         
          
               
      

      	 
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
         table.setPreferredScrollableViewportSize(new Dimension(500,500));
         table.setGridColor(new Color(31,65,102,255));
         table.setShowHorizontalLines(true);
         table.setShowVerticalLines(false);
         table.setDefaultRenderer(Object.class, new AlternatingRowColorRenderer());



       //  scroll.setBackground(Color.WHITE);
         scroll.setBounds(0, 0, 800, 340);
         scroll.setVerticalScrollBar(scrollbar);

         
        
        
		
		
		//IconImage
		imageIcon1=new ImageIcon("C:\\Users\\dell\\Documents\\choose_absent.png");
		Image imgelog1N=imageIcon1.getImage();
		imageIcon1 =new ImageIcon(imgelog1N.getScaledInstance(280, 280, Image.SCALE_SMOOTH));
		
		imageIcon2=new ImageIcon("C:\\Users\\dell\\Documents\\manWithFiles.png");
		Image imgelog2N=imageIcon2.getImage();
		imageIcon2 =new ImageIcon(imgelog2N.getScaledInstance(280, 280, Image.SCALE_SMOOTH));
		
		
		imageIcon3=new ImageIcon("C:\\Users\\dell\\Documents\\Absence_illus.png");
		Image imgelog3N=imageIcon3.getImage();
		imageIcon3 =new ImageIcon(imgelog3N.getScaledInstance(280, 280, Image.SCALE_SMOOTH));
    
	    //TextField
		field1=new JTextField();
		field1.setBorder(feild1B);
		field1.setBounds(200, 150, 200, 35);
		field1.setFont(new Font(Font.SERIF,Font.ITALIC,16));
		
		
		field2=new JTextField();
		field2.setBorder(feild1B);
		field2.setBounds(530, 150, 200, 35);
		field2.setFont(new Font(Font.SERIF,Font.ITALIC,16));
		
		field3=new JTextField();
		field3.setBorder(feild1B);
		field3.setBounds(840, 150, 100, 35);
		field3.setFont(new Font(Font.SERIF,Font.ITALIC,16));
		field3.setText(""+date);
		
		field4=new JTextField();
		field4.setBorder(feild1B);
		field4.setBounds(265, 210, 100, 35);
		field4.setFont(new Font(Font.SERIF,Font.ITALIC,16));
		
		field5=new JTextField();
		field5.setBorder(feild1B);
		field5.setBounds(650, 210, 100, 35);
		field5.setFont(new Font(Font.SERIF,Font.ITALIC,16));
		field5.setVisible(false);
		

		field6=new JTextField();
		field6.setBounds(20, 20, 200, 35);
		field6.setBorder(null);;
		field6.setFont(new Font(Font.SERIF,Font.ITALIC,16));
		field6.setText("Today Date: "+date);
		field6.setVisible(false);
		
		
	    
	    
	    //LABEL
		label1 = new JLabel();
		label1.setBounds(1000, 0, 280, 280);
		label1.setIcon(imageIcon1);
		label1.setVisible(true);
		
		
		label2 = new JLabel("Modèle De Présence.");
		label2.setBounds(500,40, 280,50);
		label2.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,20));
		label2.setForeground( new Color(31,65,102,255));
		label2.setVisible(true);
	    
		
		label3 = new JLabel();
		label3.setBounds(70,150, 140,50);
		label3.setText("Professeur :");
		label3.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,16));
		label3.setVisible(true);
		
		label4 = new JLabel();
		label4.setBounds(440,150, 90,50);
		label4.setText("Module :");
		label4.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,16));
		label4.setVisible(true);
		
		label5 = new JLabel();
		label5.setBounds(770,150, 60,50);
		label5.setText("Date :");
		label5.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,16));
		label5.setVisible(true);
		
		label6 = new JLabel();
		label6.setBounds(90,210, 170,50);
		label6.setText(" Cours/Epreuve :");
		label6.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,16));
		label6.setVisible(true);
		
		label7 = new JLabel();
		label7.setBounds(450,210, 250,50);
		label7.setText(" Periode De Cours :");
		label7.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,16));
		label7.setVisible(false);
		
		label8 = new JLabel();
		label8.setBounds(20, 295, 280, 280);
		label8.setIcon(imageIcon2);
		label8.setVisible(true);
		
		label9 = new JLabel();
		label9.setBounds(700, 400, 280, 280);
		label9.setIcon(imageIcon3);
		label9.setVisible(true);
		
		//Table
		
		
		
		//Button
				myButton = new CustomButton("Save Data");
				myButton.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
				myButton.setPreferredSize(new Dimension(150, 50));
				myButton.addActionListener(e -> saveTableDataToFile(table));
				myButton.setFocusable(false);
				
				myButtonOut= new CustomButton("Out");
				myButtonOut.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
				myButtonOut.setPreferredSize(new Dimension(150, 40));
				myButtonOut.addActionListener(this);
				myButtonOut.setFocusable(false);
				
                add= new CustomButton("Register"); 
                add.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
				add.setPreferredSize(new Dimension(150, 30));
				add.setFocusable(false);
				add.addActionListener(this);
				
    /*      {
			   
				File imageFile = null;
				try {
					imageFile = FichierAbsence.saveFrameAsImage(this.frameAbsence, "fichierAbsence");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

		        try {
		        	System.out.println("Saved image file: " + imageFile.getAbsolutePath());
		            BufferedImage image = ImageIO.read(imageFile);
		            System.out.println("Image width: " + image.getWidth());
		            System.out.println("Image height: " + image.getHeight());
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
				});*/
				

			

		
				//Panel
			      panel1=new JPanel();
			      panel1.setBounds(260, 280, 800, 340);
			      panel1.add(scroll);
			      panel1.setBackground(Color.black);
			      panel1.setLayout(null);
			      
			      panel2 = new JPanel();
				  panel2.add(myButton);
				  panel2.add(add);
				  panel2.add( myButtonOut);
				  panel2.setBounds(1130,450,150,200);
				  panel2.setBackground(Color.white);
					
				
				 
				
		
		//FRAME
		frameAbsence.setVisible(true);
		frameAbsence.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameAbsence.setBackground(Color.WHITE);
		frameAbsence.setLayout(null);
		frameAbsence.add(label1);
		frameAbsence.add(label2);
		frameAbsence.add(label3);
		frameAbsence.add(field1);
		frameAbsence.add(label4);
		frameAbsence.add(field2);
		frameAbsence.add(label5);
		frameAbsence.add(field3);
		frameAbsence.add(label6);
		frameAbsence.add(field4);
		frameAbsence.add(label7);
		frameAbsence.add(field5);
		frameAbsence.add(label8);
		frameAbsence.add( panel1);
		//frameAbsence.add(field6);
		frameAbsence.add( panel2);
		//frameAbsence.add(label9);
		frameAbsence.getContentPane().setBackground(Color.white);
		frameAbsence.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	
		
		
	}
	public void SetLoginName(String NomComp ) {
		field1.setText(NomComp);
	}
	
	
	public void saveTableDataToFile(JTable table) {
	    JFileChooser fileChooser = new JFileChooser();
	   
	    JDialog dialog = new JDialog();
	    int result = fileChooser.showSaveDialog(dialog);
	    if (result == JFileChooser.APPROVE_OPTION) {
	        File file = fileChooser.getSelectedFile();
	        System.out.println(file.getAbsolutePath());
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	            for (int i = 0; i < table.getColumnCount(); i++) {
	                writer.write(table.getColumnName(i));
	                if (i < table.getColumnCount() - 1) {
	                    writer.write(",");
	                }
	            }
	            writer.newLine();
	            for (int i = 0; i < table.getRowCount(); i++) {
	                for (int j = 0; j < table.getColumnCount(); j++) {
	                    writer.write(String.valueOf(table.getValueAt(i, j)));
	                    if (j < table.getColumnCount() - 1) {
	                        writer.write(",");
	                    }
	                }
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
		public static File saveFrameAsImage(JFrame frame, String filename) throws Exception {
	    
        BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        frame.paint(graphics);
        graphics.dispose();

        File output = new File(filename);
        ImageIO.write(image, "png", output);

        return output;
    }
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==myButtonOut) {
				try {
					GestionGeneral gestion=	new GestionGeneral();
					HelpAbsence aa=new HelpAbsence();
					gestion.SetLoginName(aa.getvalueNomC());
					gestion.setPassword(aa.getvaluePass());
					gestion.setEmail(aa.getvalueEmail());
					ArrayList<String> tabEP=new ArrayList<>();
					tabEP.add(aa.getvalueEmail());
					tabEP.add(aa.getvaluePass());
					gestion.setEmailPasww(tabEP);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frameAbsence.dispose();
			}
			if(e.getSource()==add) {
				  int test=0;
				  SQLtraitement sql=new SQLtraitement();
				  HelpAbsence a=new HelpAbsence();
				  ArrayList<Integer> integerList = new ArrayList<Integer>();
				  if(checkBoxValues!=null) {
				   ArrayList cne=new ArrayList<>();
				 
				  int columncne = 1; // the index of the second column (indexing starts from 0)
				  ArrayList<Object> columnData = new ArrayList<>();
				  for (int row = 0; row < table.getRowCount(); row++) {
				      Object value = table.getValueAt(row, columncne);
				      columnData.add(value);
				  }	
				  
				Hashtable<Object,Boolean> hash=new Hashtable<>();
				ArrayList<Boolean> values=new ArrayList<>(Arrays.asList(checkBoxValues));
				ArrayList<Object> keys=new ArrayList<>(columnData);
				

		       // Hashtable<String, Integer> hashtable = new Hashtable<>();
		       for (int i = 0; i < keys.size(); i++) {
		            hash.put(keys.get(i), values.get(i));
		        }
				
				for(Entry<Object,Boolean> entry :hash.entrySet()) {
					if(entry.getValue()) {
						cne.add(entry.getKey());
					}
				}
				
				if(!cne.isEmpty()) {
				for (Object obj : cne) {
				    Integer intValue = Integer.parseInt((String) obj);
				    integerList.add(intValue);
				}
				}
				if(cne.isEmpty()) {
				for (int i = 0; i < values.size(); i++) {
					 integerList.add(null);
				}
					
				}
				
				}
				  if(checkBoxValues==null) {
					  ArrayList cne=new ArrayList<>();
					  int columncne = 1; // the index of the second column (indexing starts from 0)
					  ArrayList<Object> columnData = new ArrayList<>();
					  for (int row = 0; row < table.getRowCount(); row++) {
					      Object value = table.getValueAt(row, columncne);
					      columnData.add(value);
					  }	
					
					  Hashtable<Object,Boolean> hash=new Hashtable<>();
					   ArrayList<Boolean> values=new ArrayList<>();
						ArrayList<Object> keys=new ArrayList<>(columnData);
						for (int row = 0; row < table.getRowCount(); row++) {
							values.add(false);
						}

				   
				        for (int i = 0; i < keys.size(); i++) {
				            hash.put(keys.get(i), values.get(i));
				        }
						
					for(int i=0;i<hash.size();i++) {
						integerList.add(null);
					}
						
			    
			    }
				  System.out.println(integerList);
				  sql.insertAbsence(a.getvalueId(), integerList);
				  
				  try {
					  HelpAbsence aa=new HelpAbsence();
					  GestionGeneral gestion=	new GestionGeneral();
					  gestion.SetLoginName(aa.getvalueNomC());
						gestion.setPassword(aa.getvaluePass());
						gestion.setEmail(aa.getvalueEmail());
						ArrayList<String> tabEP=new ArrayList<>();
						tabEP.add(aa.getvalueEmail());
						tabEP.add(aa.getvaluePass());
						gestion.setEmailPasww(tabEP);
						frameAbsence.dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
         
			}
			
		}
	
}
