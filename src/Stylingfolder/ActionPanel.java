package Stylingfolder;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import MAIN.GestionGeneral;
import SQL.SQLtraitement;

public class ActionPanel extends JPanel  implements MouseListener{
	public JTable table;
	public ImageIcon imageIcondelete;
	 public ImageIcon imageIconedit;
	 public ImageIcon imageIconregister;
	 public JButton delete;
	public	JButton Edit;
	public	JButton Register;
	public JPanel ActionPanel;
	public JPanel ActionPanel(JTable table) {
		
		this.table=table;
		
		 imageIcondelete=new ImageIcon("C:\\Users\\dell\\Documents\\delete_icon.png");
			Image imgelogDN=imageIcondelete.getImage();
			imageIcondelete =new ImageIcon(imgelogDN.getScaledInstance(25,25, Image.SCALE_SMOOTH));
			
			
			imageIconedit=new ImageIcon("C:\\Users\\dell\\Documents\\modify_icon.png");
			Image imgelogEN=imageIconedit.getImage();
			imageIconedit =new ImageIcon(imgelogEN.getScaledInstance(25,25, Image.SCALE_SMOOTH));
			
			imageIconregister=new ImageIcon("C:\\Users\\dell\\Documents\\plusEtudiant_Icon.png");
			Image imgelogRN=imageIconregister.getImage();
			imageIconregister =new ImageIcon(imgelogRN.getScaledInstance(35,35, Image.SCALE_SMOOTH));
			
			
			 delete=new JButton();
			 delete.setBackground(Color.WHITE);
			 delete.setIcon(imageIcondelete);
			 delete.setFocusable(false);
			 delete.setBounds(20, 5, 30, 30);
			 delete.setBorderPainted(false);
			 delete.addMouseListener(this);
			
			 
			 Edit= new JButton();
			 Edit.setIcon(imageIconedit);
			 Edit.setBackground(Color.WHITE);
			 Edit.setFocusable(false);
			 Edit.setBounds(60, 5, 30, 30);
			 Edit.setBorderPainted(false);
			 Edit.addMouseListener(this);
			
			 Register=new JButton();
			 Register.setIcon(imageIconregister);
			 Register.setBackground(Color.WHITE);
			 Register.setFocusable(false);
			 Register.setBounds(95, 5, 30, 30);
			 Register.setBorderPainted(false);
			 Register.addMouseListener(this);
		
		
			 
			 
			 
		    ActionPanel=new JPanel();
		    ActionPanel.setBackground(Color.WHITE);
		    ActionPanel.setLayout(null);
		    ActionPanel.add(delete);
		    ActionPanel.add(Edit);
		    ActionPanel.add(Register);
		    return ActionPanel;
		   
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==Edit) {
		
			

			Point componentLocation =  ActionPanel.getLocation();
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
		            if (row == rowIndex && column != 0 &&column!=8) {
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
	if(e.getSource()==Register)	{
		

		Point componentLocation =  ActionPanel.getLocation();
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
	        	
	    			if(column==11  )
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
	    

	 /*   int cne=(int) table.getValueAt(row, 0);
	   String nom=(String) table.getValueAt(row, 1);
	   System.out.println(cne+""+nom+"2");
	   
*/      SQLtraitement sql=new SQLtraitement();
	    int cne=Integer.parseInt((String) table.getValueAt(row, 1));
	    String nom=(String) table.getValueAt(row, 2);
	    String prenom=(String) table.getValueAt(row, 3);
	    String etat=(String) table.getValueAt(row, 4);
	    int apogee=Integer.parseInt((String) table.getValueAt(row, 5));;
	    String diplome=(String) table.getValueAt(row, 6);
	    LocalDate date=LocalDate.parse((CharSequence) table.getValueAt(row, 7));
	    String nivau=(String) table.getValueAt(row, 8);
	    String tele=(String) table.getValueAt(row, 9);
	    String adr=(String) table.getValueAt(row, 10);
	    
	    int id_etud=Integer.parseInt((String) table.getValueAt(row, 0));
	    if(cne!=0&&!nom.equals("")&&!prenom.equals("")&&apogee!=0&&!date.equals("")&&!nivau.equals("")&&id_etud!=0) {
	    try {
	    	if(!sql.getFiliere().contains(nivau)) {
	    		sql.setFiliere(nivau);
	    		System.out.println("niveau is set");
	    	}
			sql.setDynamiqueEtudiantsAllSql(cne, nom, prenom, etat, apogee, diplome, date, nivau, id_etud,tele,adr);
			System.out.println("it did isert");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("it did not isert");
		}

	    } 
	}
	if(e.getSource()==delete) {
		Point componentLocation =  ActionPanel.getLocation();
		 int col = table.columnAtPoint(componentLocation);
		 int row = table.rowAtPoint(componentLocation);
		 int id_etud=Integer.parseInt((String) table.getValueAt(row, 0));
		int cne=Integer.parseInt((String) table.getValueAt(row, 1));
		 String nivau=(String) table.getValueAt(row, 8);
		 int choice = JOptionPane.showConfirmDialog(ActionPanel, "Do you want to proceed?");
		 if (choice == JOptionPane.YES_OPTION) {
			 try {
					new SQLtraitement().deleteEtudiant(cne,id_etud,nivau);

					if (row != -1) {
					    TableModel model = table.getModel();
					    ((DefaultTableModel) model).removeRow(row); // Remove the selected row from the table model
					    System.out.println("Row :"+row+" with value "+cne +"   was removed.");
					} else {
					    System.out.println("No row selected.");
					}

					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		     System.out.println("User clicked Yes.");
		 } else if (choice == JOptionPane.NO_OPTION) {
		     System.out.println("User clicked No.");
		 } else if (choice == JOptionPane.CANCEL_OPTION) {
		     System.out.println("User clicked Cancel.");
		 } else {
		     System.out.println("Dialog closed.");
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
