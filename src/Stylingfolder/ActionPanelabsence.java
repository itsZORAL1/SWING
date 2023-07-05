package Stylingfolder;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import MAIN.FichierAbsence;
import MAIN.HelpAbsence;
import SQL.SQLtraitement;

public class ActionPanelabsence implements MouseListener{
	public JTable table;
	public ImageIcon imageIcondelete;
	 public ImageIcon imageIconedit;
	 public ImageIcon imageIconregister;
	 public JButton delete;
	public	JButton Edit;
	public	JButton Register;
	public JPanel ActionPanel;
	public JPanel ActionPanelabsence(JTable table)  {
		
		this.table=table;
		
		 imageIcondelete=new ImageIcon("C:\\Users\\dell\\Documents\\delete_icon.png");
			Image imgelogDN=imageIcondelete.getImage();
			imageIcondelete =new ImageIcon(imgelogDN.getScaledInstance(25,25, Image.SCALE_SMOOTH));
			
			
			imageIconedit=new ImageIcon("C:\\Users\\dell\\Documents\\view_icon2.png");
			Image imgelogEN=imageIconedit.getImage();
			imageIconedit =new ImageIcon(imgelogEN.getScaledInstance(25,25, Image.SCALE_SMOOTH));
			
			imageIconregister=new ImageIcon("C:\\Users\\dell\\Documents\\view_icon2.png");
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
		    //ActionPanel.add(Edit);
		    ActionPanel.add(Register);
		    return ActionPanel;
		   
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==Register) {
			Point componentLocation =  ActionPanel.getLocation();
			 int col = table.columnAtPoint(componentLocation);
			 int row = table.rowAtPoint(componentLocation);
			 
			 
			try {
				String[][] data= new SQLtraitement().dataAbsence(Integer.parseInt((String)table.getValueAt(row, 0)));
				FichierAbsence fich=new FichierAbsence ();
				Container container = (Container) SwingUtilities.getRoot(table);
                if (container instanceof JFrame) {
                    JFrame parentFrame = (JFrame) container;
                    parentFrame.dispose();}
				DefaultTableModel model3 = (DefaultTableModel) fich.table.getModel();
			    model3.setRowCount(0); 
			    TableModel originalModel3 = fich.table.getModel();
				TableModel editableModel3 = new DefaultTableModel(originalModel3.getRowCount(), originalModel3.getColumnCount()) {
			    };
			 // Copy values from original model to new model
			    for (int i = 0; i < originalModel3.getRowCount(); i++) {
			        for (int j = 0; j < originalModel3.getColumnCount(); j++) {
			        	editableModel3 .setValueAt(originalModel3.getValueAt(i, j), i, j);
			        }
			    }

			    for (String[] rowd : data) {
			        Vector<String> rowDataVector = new Vector<String>();
			        for (String cellValue : rowd) {
			            rowDataVector.add(cellValue);
			        }
			        ((DefaultTableModel) editableModel3).addRow(rowDataVector);
			    }
			    fich.table.setModel(editableModel3);
			    editableModel3.addTableModelListener(ee -> {
		            if (ee.getType() == ee.UPDATE && ee.getColumn() == 4) {
		                int row2 = ee.getFirstRow();
		                int col2 = ee.getColumn();
		                Boolean value = (Boolean) fich.table.getValueAt(row2, col2);
		                DefaultTableModel dtm2 = (DefaultTableModel) fich.table.getModel();
		                int checkboxColumnIndex = 4;
		                Boolean[] checkBoxValues = new Boolean[dtm2.getRowCount()];
		                for (int i = 0; i < dtm2.getRowCount(); i++) {
		                    checkBoxValues[i] =(Boolean) dtm2.getValueAt(i, checkboxColumnIndex);
		                    System.out.println(Arrays.deepToString(checkBoxValues));
		                }
		               // print the checkbox values
		               
		            }
		        });
			   
			 
				 String[][] DT= {{null,null,null}};
				HelpAbsence aa=new HelpAbsence();
				
				String[] fields= {"ID","CNE","Nom","P"};
				/*String[] fields= {"ID","CNE","Nom","Prenom"};
				TableModel editableModel = new DefaultTableModel(data, fields) {
			        
			    };*/
		
				
				 fich.field1.setText(aa.getvalueNomC());
				 fich.field2.setText((String)table.getValueAt(row, 1));
				 fich.field4.setText((String)table.getValueAt(row, 3));
				 fich.add.setVisible(false);
				

				
				// fich.data= new SQLtraitement().dataAbsence();
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource()==delete) {
			JOptionPane.showMessageDialog(ActionPanel, "you  realy want to delete?");
			SQLtraitement sql=new SQLtraitement();
			Point componentLocation =  ActionPanel.getLocation();
			 int col = table.columnAtPoint(componentLocation);
			 int row = table.rowAtPoint(componentLocation);
			int ID =Integer.parseInt((String)table.getValueAt(row, 0));
			int choice = JOptionPane.showConfirmDialog(null, "Do you want to proceed?");
			if (choice == JOptionPane.YES_OPTION) {
				try {
					sql.deleteAbsence(ID);
					if (row != -1) {
					    TableModel model = table.getModel();
					    ((DefaultTableModel) model).removeRow(row); // Remove the selected row from the table model
					    System.out.println("Row :"+row+" with value "+ID +"   was removed.");
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
