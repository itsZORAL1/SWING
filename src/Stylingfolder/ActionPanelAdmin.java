package Stylingfolder;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import SQL.SQLtraitement;

public class ActionPanelAdmin  extends JPanel  implements MouseListener {
	public JTable table;
	public ImageIcon imageIcondelete;
	 public ImageIcon imageIconedit;
	 public ImageIcon imageIconregister;
	 public JButton delete;
	public	JButton Edit;
	public	JButton Register;
	public JPanel ActionPanel;
	public JPanel ActionPanelAdmin(JTable table) {
		
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
			 delete.setBounds(30, 5, 30, 30);
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
		   // ActionPanel.add(Edit);
		  //  ActionPanel.add(Register);
		    return ActionPanel;
		   
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==delete) {
			Point componentLocation =  ActionPanel.getLocation();
			 int col = table.columnAtPoint(componentLocation);
			 int row = table.rowAtPoint(componentLocation);
			 int choice = JOptionPane.showConfirmDialog(ActionPanel, "Do you want to proceed?");
			 if (choice == JOptionPane.YES_OPTION) {
				 try {
					new SQLtraitement().DeleteEns((String)table.getValueAt(row, 8),(String)table.getValueAt(row, 9) );
					if (row != -1) {
					    TableModel model = table.getModel();
					    ((DefaultTableModel) model).removeRow(row); // Remove the selected row from the table model
					    System.out.println("Row :"+row+" with value    was removed.");
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
