package Stylingfolder;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import MAIN.Help;
import SQL.SQLtraitement;

public class ActionPanelnote extends JPanel  implements MouseListener{
	Hashtable Htable;
	public JTable table;
	public JComboBox box;
	public ImageIcon imageIcondelete;
	 public ImageIcon imageIconedit;
	 public ImageIcon imageIconregister;
	public	JButton Editnote;
	public	JButton Registernote;
	public JPanel ActionPanelnote;
	  String ComboChoice;
	  int Id;
	  String test;
	  
	public  ActionPanelnote() {
		 Htable=new Hashtable<>();
	 }
	
	public JPanel ActionPanelnote(JTable table,JComboBox box) {
	    	
	    	this.table=table;
	    	this.box=box;
	    	test=ComboChoice;
		 imageIcondelete=new ImageIcon("C:\\Users\\dell\\Documents\\delete_icon.png");
			Image imgelogDN=imageIcondelete.getImage();
			imageIcondelete =new ImageIcon(imgelogDN.getScaledInstance(25,25, Image.SCALE_SMOOTH));
			
			
			imageIconedit=new ImageIcon("C:\\Users\\dell\\Documents\\modify_icon.png");
			Image imgelogEN=imageIconedit.getImage();
			imageIconedit =new ImageIcon(imgelogEN.getScaledInstance(25,25, Image.SCALE_SMOOTH));
			
			imageIconregister=new ImageIcon("C:\\Users\\dell\\Documents\\plusEtudiant_Icon.png");
			Image imgelogRN=imageIconregister.getImage();
			imageIconregister =new ImageIcon(imgelogRN.getScaledInstance(35,35, Image.SCALE_SMOOTH));
			

			
			 
			 Editnote= new JButton();
			 Editnote.setIcon(imageIconedit);
			 Editnote.setBackground(Color.WHITE);
			 Editnote.setFocusable(false);
			 Editnote.setBounds(40, 5, 30, 30);
			 Editnote.setBorderPainted(false);
			 Editnote.addMouseListener(this);
			
			 Registernote=new JButton();
			 Registernote.setIcon(imageIconregister);
			 Registernote.setBackground(Color.WHITE);
			 Registernote.setFocusable(false);
			 Registernote.setBounds(85, 5, 30, 30);
			 Registernote.setBorderPainted(false);
			 Registernote.addMouseListener(this);
		
		
			 
			 
			 
		    ActionPanelnote=new JPanel();
		    ActionPanelnote.setBackground(Color.WHITE);
		    ActionPanelnote.setLayout(null);
	
		    ActionPanelnote.add(Editnote);
		    ActionPanelnote.add(Registernote);
		     
		    return ActionPanelnote;
		    
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==Editnote) {

			Point componentLocation =  ActionPanelnote.getLocation();
			 int col = table.columnAtPoint(componentLocation);
			 int row = table.rowAtPoint(componentLocation);

		
			
			
			TableModel model = table.getModel();
			
			TableModel originalModel = table.getModel();
			int rowIndex = row ;// Replace with the actual row index
			int columnIndex = col; // Replace with the actual column index
			
			TableModel editableModel = new DefaultTableModel(originalModel.getRowCount(), originalModel.getColumnCount()) {
		        @Override
		        public Object getValueAt(int row, int column) {
		            return originalModel.getValueAt(row, column); // Use the original values
		        }
		        @Override
		        public boolean isCellEditable(int row, int column) {
		            // Check if the current row is the desired row
		            if (row == rowIndex && column != 0&& column != 1&& column != 2&& column != 3&& column != 4&& column != 5) {
		                return true; // Make all cells in the row, except the first column, editable
		            } else {
		                return false; // Make cells in other rows and first column non-editable
		            }
		        }



		        @Override
		        public void setValueAt(Object value, int row, int column) {
		            // Override the setValueAt() method to update the original model
		            originalModel.setValueAt(value, row, column);
		            fireTableCellUpdated(row, column);
		        }
		    };
		    table.setModel(editableModel);
		    table.editCellAt(rowIndex, columnIndex);
		   
		}
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==Registernote) {
	
			Point componentLocation =  ActionPanelnote.getLocation();
			 int col = table.columnAtPoint(componentLocation);
			 int row = table.rowAtPoint(componentLocation);

			
			
			TableModel originalModel = table.getModel();
			TableModel editableModel = new DefaultTableModel(originalModel.getRowCount(), originalModel.getColumnCount()) {
				@Override
		        public Object getValueAt(int row, int column) {
		            return originalModel.getValueAt(row, column); // Use the original values
		        }

		        @Override
		        public boolean isCellEditable(int row, int column) {
		        	
		    			if(column==8  )
		    			{ 
		    				return true;
		    			}
		    			else {
		    				return false;
		    			}
		        	
		        	
		    	}
		        


		        @Override
		        public void setValueAt(Object value, int row, int column) {
		            // Override the setValueAt() method to update the original model
		            originalModel.setValueAt(value, row, column);
		            fireTableCellUpdated(row, column);
		        }


		        
		    };
		    table.setModel(editableModel);
		    Help a=new Help();
		    String espacenote1=(String) table.getValueAt(row, 6);
		    String espacenote2=(String) table.getValueAt(row, 7);
		   
		    SQLtraitement sql= new	SQLtraitement();
		    boolean alldigit1=false;
		    boolean alldigit2=false;
		    if(espacenote1!=null) {
		      alldigit1=espacenote1.matches("\\d+\\.?\\d*");}
		    if(espacenote2!=null) {
		    alldigit2=espacenote2.matches("\\d+\\.?\\d*");}
		     
		   
		   
		     System.out.println(alldigit2+"D2");
		     System.out.println(alldigit1+"D1");
		    try {
		    	Hashtable<Integer,Integer> hash= sql.selectionEtudmodule();
		    	System.out.println(hash);
		    	int idmodule=sql.moduleId(a.getvalueCombo());
		    	if(alldigit1==true&&alldigit2==true) {
		    	int cne=Integer.parseInt((String) table.getValueAt(row, 0));
		    	float note1=Float.parseFloat((String) table.getValueAt(row, 6));
		    	float note2=Float.parseFloat((String) table.getValueAt(row, 7));
		    	String module=a.getvalueCombo();
		    	sql.insertNotes(idmodule, cne, note1, note2);
	    		System.out.println("updataed");
		   // 	if(hash.containsKey(idmodule)&&hash.contains(cne)&&hash.get(idmodule)==cne) {
		    		
		    		
		    //	}
		    /*	else if(hash.containsKey(idmodule)&&hash.contains(cne)&&hash.get(idmodule)!=cne) {
		    		System.out.println("insert");
		    		sql.insertNotes(idmodule, cne, note1, note2);
		    	}
		    	else if(!hash.containsKey(idmodule)||!hash.contains(cne)) {
		    		System.out.println("insert");
                	sql.insertNotes(idmodule, cne, note1, note2);
		    	}*/
		    	}
		    
		    	if(alldigit1==true &&alldigit2==false) {
		    		int cne=Integer.parseInt((String) table.getValueAt(row, 0));
			    	float note1=Float.parseFloat((String) table.getValueAt(row, 6));
		                	sql.insertNote1(idmodule, cne, note1);
		                	System.out.println("note1inserted");
				    
			    	
			    	
		    	}
		    	if(alldigit1==false &&alldigit2==true) {
		    		int cne=Integer.parseInt((String) table.getValueAt(row, 0));
			    	float note2=Float.parseFloat((String) table.getValueAt(row, 7));
		            sql.insertNote2(idmodule, cne, note2);
		            System.out.println("note2inserted");
				 
			    	
			    	
		    	}
		    	
		    	if(alldigit1==false&&alldigit2==false) {
		    		System.out.println("note sont des float");
		    	}
		    	
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   
			
		}	            	
     		         
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

