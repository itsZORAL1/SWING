package Stylingfolder;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import MAIN.HelpAbsence;

public class ActionPanelSanction implements MouseListener {
	public JTable table;
	public JTable table2;
	public ImageIcon imageIcondelete;
	 public ImageIcon imageIconedit;
	 public ImageIcon imageIconregister;
	 public JButton delete;
	public	JButton Edit;
	public	JButton Register;
	public JPanel ActionPanel;
	public JPanel ActionPanelSanction(JTable table,JTable tabl2) {
		this.table=table;
		this.table2=tabl2;
		
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
			 Register.setBounds(45, 5, 30, 30);
			 Register.setBorderPainted(false);
			 Register.addMouseListener(this);
		     
		
			 
			 
			 
		    ActionPanel=new JPanel();
		    ActionPanel.setBackground(Color.WHITE);
		    ActionPanel.setLayout(null);
		   // ActionPanel.add(delete);
		    //ActionPanel.add(Edit);
		    ActionPanel.add(Register);
		    return ActionPanel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Register) {
			
			Point componentLocation =  ActionPanel.getLocation();
			 int col = table.columnAtPoint(componentLocation);
			 int row = table.rowAtPoint(componentLocation);	
		
			HelpAbsence aa=new HelpAbsence();
			if(table.getValueAt(row, 0)!=null) {
			aa.setvalueCNE((int) table.getValueAt(row, 0));
				System.out.println(table.getValueAt(row, 0));
				System.out.println( table.getValueAt(row, 0).getClass());
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
