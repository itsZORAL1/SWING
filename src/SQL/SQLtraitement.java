package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import Coneection.Coneect;





public class SQLtraitement {
	
	 public static void UpdateEnseignatSql(String nom,String prenom,String email,String date_naissance,String code,String deprt,String fonction,String etat,String status,String password) throws SQLException, ClassNotFoundException{
		 Coneect connecter=new Coneect();
		 PreparedStatement st =connecter.AvoirConnection().prepareStatement("update enseignat set nom=? , prenom=?, email=?, date_naissance=? , code=? , departement=? , fonction=? , statuss=? ,etat_civil=? where password=? ");
	     st.setString(1, nom);
	     st.setString(2, prenom);
	     st.setString(3, email);
	     java.sql.Date sqlDate = java.sql.Date.valueOf(date_naissance);
	     st.setDate(4, sqlDate);
	     st.setInt(5, Integer.parseInt(code));
	     st.setString(6, deprt);
	     st.setString(7, fonction);
	     st.setString(8, status);
	     st.setString(9, etat);
	     st.setString(10, password);
	     st.executeUpdate();
	     st.close();
	     connecter.AvoirConnection().close();
	 }
	 public static Hashtable<String,String> Admin() throws SQLException{
		 Hashtable<String,String> holder=new Hashtable<String,String>();
		 Coneect connecter=new Coneect();
		 PreparedStatement st =connecter.AvoirConnection().prepareStatement("select email,password from administrateur");
		 ResultSet rs=st.executeQuery();
		 while(rs.next()){
			 holder.put(rs.getString(1),rs.getString(2) );
		 }
		 connecter.AvoirConnection().close();
		return holder;
		 
	 }
	 public static Hashtable<String,String> ENS() throws SQLException{
		 Hashtable<String,String> holder=new Hashtable<String,String>();
		 Coneect connecter=new Coneect();
		 PreparedStatement st =connecter.AvoirConnection().prepareStatement("select email,password from enseignat");
		 ResultSet rs=st.executeQuery();
		 while(rs.next()){
			 holder.put(rs.getString(1),rs.getString(2) );
		 }
		 connecter.AvoirConnection().close();
		return holder;
		 
	 }
	 public static void UpdateAdministrateurtSql(String nom,String prenom,String email,String date_naissance,String code,String fonction,String etat,String status,String password) throws SQLException, ClassNotFoundException{
		 Coneect connecter=new Coneect();
		 PreparedStatement st =connecter.AvoirConnection().prepareStatement("update administrateur set nom=? , prenom=?, email=?, date_naissance=? , code=?  , fonction=? , satatus=? ,etat_civil=? where password=? ");
	     st.setString(1, nom);
	     st.setString(2, prenom);
	     st.setString(3, email);
	     java.sql.Date sqlDate = java.sql.Date.valueOf(date_naissance);
	     st.setDate(4, sqlDate);
	     st.setInt(5, Integer.parseInt(code));
	     st.setString(6, fonction);
	     st.setString(7, status);
	     st.setString(8, etat);
	     st.setString(9, password);
	     st.executeUpdate();
	     st.close();
	     connecter.AvoirConnection().close();
	 }
	 public static void DeleteEns(String email,String pass) throws SQLException {
		 Coneect connecter=new Coneect();
		 PreparedStatement st =connecter.AvoirConnection().prepareStatement(" delete from `administrateur` where email=? and password=?");
		 st.setString(1, email);
		 st.setString(2, pass);
		 st.executeUpdate();
		 connecter.AvoirConnection().close();
		 
	 }
	 public static String[][] OrderByEns(String field,String type) throws SQLException{
	
			   Coneect connecter=new Coneect();
	           int RowNombre = 0;
				ArrayList holder =new ArrayList<>();
				PreparedStatement st =connecter.AvoirConnection().prepareStatement("SELECT * FROM enseignat ORDER BY " + field + " " + type);
				ResultSet rs=st.executeQuery();
				PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("SELECT count(*) FROM enseignat ORDER BY " + field + " " + type);
			    ResultSet rs2=st2.executeQuery();
				while(rs2.next()) {
					RowNombre=rs2.getInt(1);
				}
				
				int i =0;
				int arayindex=0;
				String[][] data=new String[RowNombre][10];
				while(rs.next()) {
					holder.add(rs.getInt(1));
					holder.add(rs.getString(2));
					holder.add(rs.getString(3));
					holder.add(rs.getString(4));
					holder.add(rs.getString(5));
					holder.add(rs.getString(6));
					holder.add(rs.getString(7));
					holder.add(rs.getDate(8));
					holder.add(rs.getString(9));
					holder.add(rs.getString(10));
					
					
					
					
					
					

				for(int j=0;j<10;j++) {
						data[i][j]= String.valueOf(holder.get(arayindex));
						arayindex++;
					}
				i++;
				arayindex=0;
				holder.clear();   
				
		   }
				 connecter.AvoirConnection().close();
			return data;
		   }
		 
	
	
	   public static String[][] SelectionDynamiqueEtudiantsSql() throws SQLException, ClassNotFoundException{
			Coneect connecter=new Coneect();
			ArrayList holder =new ArrayList<>();
			int ColumnNombre = 0;
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select cne,nom,prenom from etudiant ");
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(cne) from etudiant ;");
			ResultSet rs2=st2.executeQuery();
			ResultSet rs=st.executeQuery();
			while(rs2.next()) {
				ColumnNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[ColumnNombre+1][3];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
			for(int j=0;j<3;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		  return data;
		
	   }
	   public static String[][] SelectionEtudiantExceptoinSql(String email) throws SQLException, ClassNotFoundException{
			Coneect connecter=new Coneect();
			ArrayList holder =new ArrayList<>();
			int RowNombre = 0;
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=?  ");
			st.setString(1, email);
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne)  from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=?  ");
			st2.setString(1, email);
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		  return data;	
	   }
	   
	   public static String[][] SelectionEtudiantExceptoinSql(String email,String choix1,String choix2) throws SQLException, ClassNotFoundException{
			Coneect connecter=new Coneect();
			ArrayList holder =new ArrayList<>();
			int RowNombre = 0;
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=?  order by ? ? ");
			st.setString(1, email);
			st.setString(2, choix1);
			st.setString(3, choix2);
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne)  from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? order by ? ? ");
			st2.setString(1, email);
			st2.setString(2, choix1);
			st2.setString(3, choix2);
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		  return data;	
	   }
	   public static String[][] getEtudiantCne(int cne,String email) throws SQLException{
		   Coneect connecter=new Coneect();
		   int RowNombre = 0;
			ArrayList holder =new ArrayList<>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and cne like ?");
			st.setString(1, email);
			st.setString(2, cne+"%");
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne) from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and  cne like ?");
			st2.setString(1, email);
			st2.setString(2, cne+"%");
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		return data;
		
   }
   
	 
	   public static String[][] getEtudiantApogee(int apogee,String email) throws SQLException{
		   Coneect connecter=new Coneect();
		   int RowNombre = 0;
			ArrayList holder =new ArrayList<>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and  apogee like ?");
			st.setString(1, email);
			st.setString(2, apogee+"%");
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne) from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and  apogee like ?");
			st2.setString(1, email);
			st2.setString(2, apogee+"%");
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		return data;
		
   }
	   public static String[][] getEtudiantNom(String Nom,String email) throws SQLException{
		   Coneect connecter=new Coneect();
		   int RowNombre = 0;
			ArrayList holder =new ArrayList<>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and  etudiant.nom like ?");
			st.setString(1, email);
			st.setString(2, Nom+"%");
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne) from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and etudiant.nom like ?");
			st2.setString(1, email);
			st2.setString(2, Nom+"%");
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		return data;
		
   }
	   public static ArrayList getEnseignat(String email,String password) throws SQLException {
		   Coneect connecter=new Coneect();
		   ArrayList holder =new ArrayList<>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("select * from enseignat where email=? and password=? ");
		   st.setString(1, email);
		   st.setString(2, password);
		   ResultSet rs=st.executeQuery();
		   while(rs.next()) {
			   holder.add(rs.getInt(1));  
			   holder.add(rs.getString(2)); 
			   holder.add(rs.getString(3));
			   holder.add(rs.getString(4));
			   holder.add(rs.getString(5));
			   holder.add(rs.getString(6));
			   holder.add(rs.getString(7));
			   holder.add(rs.getDate(8));
		   }
		   st.close();
		   connecter.AvoirConnection().close();
		   return holder;
		   
	   }
	   public static ArrayList getEnseignat(String email) throws SQLException {
		   Coneect connecter=new Coneect();
		   ArrayList holder =new ArrayList<>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("select * from enseignat where email=?  ");
		   st.setString(1, email);
		   ResultSet rs=st.executeQuery();
		   while(rs.next()) {
			   holder.add(rs.getInt(1));  
			   holder.add(rs.getString(2)); 
			   holder.add(rs.getString(3));
			   holder.add(rs.getString(4));
			   holder.add(rs.getString(5));
			   holder.add(rs.getString(6));
			   holder.add(rs.getString(7));
			   holder.add(rs.getDate(8));
		   }
		   st.close();
		   connecter.AvoirConnection().close();
		   return holder;
		   
	   }
	   public static String[][] getEtudiantElm(String field ,String email,String Elm) throws SQLException{
		   
		   Coneect connecter=new Coneect();
		   int RowNombre = 0;
			ArrayList holder =new ArrayList<>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and "+Elm+" like ?");
			st.setString(1, email);
			st.setString(2, field+"%");
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne) from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and "+Elm+" like ?");
			st2.setString(1, email);
			st2.setString(2,field+"%");
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();	
		return data;

		   
	   }
	   public static ArrayList<Integer> CNE() throws SQLException{
		   Coneect connecter=new Coneect();
		   ArrayList holder =new ArrayList<>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement(" select cne from etudiant;");
		   ResultSet rs=st.executeQuery();
		   while(rs.next()) {
			   holder.add(rs.getInt(1));
		   }
		   connecter.AvoirConnection().close();
		   return holder;
	   }
	   public static Object[][] asetud(String email,String password,String module) throws SQLException{  
		 	ArrayList<List> lists=new ArrayList<List>();
			String sql = null;
			Coneect  con=new Coneect();
			PreparedStatement stm=null;  
			if(module==null) {
		   
		    
		    sql="select module.nom, etudiant.cne, etudiant.nom, etudiant.prenom \r\n"
		    		+ "						from enseignat\r\n"
		    		+ "						inner join ensei_module\r\n"
		    		+ "						on ensei_module.email=enseignat.email and ensei_module.password=enseignat.password\r\n"
		    		+ "						inner join module\r\n"
		    		+ "						on ensei_module.id_module=module.id_module\r\n"
		    		+ "						inner join filiere\r\n"
		    		+ "						on filiere.niveau=module.niveau\r\n"
		    		+ "						inner join etudiant\r\n"
		    		+ "						on filiere.niveau=etudiant.niveau\r\n"
		    	
		    		+ "						where enseignat.email=? and enseignat.password=?";}
			
			else if(module!=null) {
				sql="select module.nom, etudiant.cne, etudiant.nom, etudiant.prenom \r\n"
						+ "						from enseignat\r\n"
						+ "						inner join ensei_module\r\n"
						+ "						on ensei_module.email=enseignat.email and ensei_module.password=enseignat.password\r\n"
						+ "						inner join module\r\n"
						+ "						on ensei_module.id_module=module.id_module\r\n"
						+ "						inner join filiere\r\n"
						+ "						on filiere.niveau=module.niveau\r\n"
						+ "						inner join etudiant\r\n"
						+ "						on filiere.niveau=etudiant.niveau\r\n"
						+ "						where enseignat.email=? and enseignat.password=? and module.nom=? ";
				
			}
				   try {
						stm= con.AvoirConnection().prepareStatement(sql);
						stm.setString(1, email);
					    stm.setString(2, password);
					    if(module!=null) {
					    stm.setString(3, module);}
					} catch (SQLException e) { 
						e.printStackTrace();
					}     
			try { 
				    ResultSet result=stm.executeQuery();
			    	  while(result.next()) {  
			    		   List<Object> list= new ArrayList<>(); 
			    		   list.add(result.getInt(2));
			    		   list.add(result.getString(4));
			    		   list.add(result.getString(3));
			    		   list.add(result.getString(1));
			    		   String sql1="select count(etudfich.id_fich) \r\n"
			    		   		+ "from etudfich \r\n"
			    		   		+ "inner join fichabsence \r\n"
			    		   		+ "on etudfich.id_fich=fichabsence.id_fich \r\n"
			    		   		+ "inner join module \r\n"
			    		   		+ "on module.id_module=fichabsence.id_module \r\n"
			    		   		+ "where cne=? \r\n"
			    		   		+ "group by cne ";
			    		   stm=con.AvoirConnection().prepareStatement(sql1);
							stm.setInt(1, result.getInt(2));
		
						    ResultSet result2=stm.executeQuery();
						    if(result2.next()) {
						    	int n=result2.getInt(1);
						    	list.add(n);
						    	String sact;
						    	if(n<=1) {
						    		sact="nothing";
						    		System.out.print(n+"n");
						    	}
						    	else if(2<=n && n<=3) {
						    		sact="Participation-"+(0.25*n);
						    		
						    	}
						    	else if(4<=n && n<=10) {
						    		sact="Participation-"+(0.75*n);
						    	}
						    	else {
						    		
						    		sact="ne pass pas exam";
						    	}
						    	list.add(sact);
						    	lists.add(list); 
						    }
						   
			    	  }
				} catch (SQLException ex) {
					ex.printStackTrace();
				}  
					Object[][] table = new Object[lists.size()][];
					for (int i = 0; i < lists.size(); i++) {
					    table[i] = lists.get(i).toArray();
					}
					stm.close();
					con.AvoirConnection().close();
			return table;  
		}
 
	   public static String[][] getEtudiantId(int id,String email) throws SQLException{
		   Coneect connecter=new Coneect();
		   int RowNombre = 0;
			ArrayList holder =new ArrayList<>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and  etud_id like ?");
			st.setString(1, email);
			st.setString(2, id+"%");
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne) from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and etud_id like ?");
			st2.setString(1, email);
			st2.setString(2,id+"%");
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			st.close();
			 connecter.AvoirConnection().close();
		return data;
		
      }
	   public static String[][] getEtudiantPrenom(String PRNom,String email) throws SQLException{
		   Coneect connecter=new Coneect();
		   int RowNombre = 0;
			ArrayList holder =new ArrayList<>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and prenom like ?");
			st.setString(1,email);
			st.setString(2, PRNom+"%");
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne) from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and prenom like ?");
			st2.setString(1,email);
			st2.setString(2,PRNom+"%");
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		return data;
		}
	   public static ArrayList GetAdministrateur(String email,String pass) throws SQLException {
		   Coneect connecter=new Coneect();
		   ArrayList holder =new ArrayList<>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("select * from administrateur where email=? and password=? ");
		   st.setString(1, email);
		   st.setString(2, pass);
		   ResultSet rs=st.executeQuery();
		   while(rs.next()) {
			   holder.add(rs.getInt(1));  
			   holder.add(rs.getString(2)); 
			   holder.add(rs.getString(3));
			   holder.add(rs.getString(4));
			   holder.add(rs.getString(5));
			   holder.add(rs.getString(6));
			   holder.add(rs.getDate(7));
		   }
		   st.close();
		   connecter.AvoirConnection().close();
		   return holder;
		   
	   }
	   public static String[][] dataAbsence(int fich_id) throws SQLException{
		   Coneect connecter=new Coneect();
           int RowNombre = 0;
			ArrayList holder =new ArrayList<>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select etud_id,etudfich.cne,etudiant.nom,prenom  from fichabsence natural join  etudfich natural join module inner join   etudiant on etudiant.cne=etudfich.cne where id_fich=? order by etud_id ");
		    st.setInt(1, fich_id);
		    ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count( etudiant.cne) from fichabsence natural join  etudfich natural join module inner join   etudiant on etudiant.cne=etudfich.cne where id_fich=? order by etud_id");
		    st2.setInt(1,fich_id);
		    ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][4];
			while(rs.next()) {
				holder.add(rs.getInt(2));
				holder.add(rs.getString(4));
				holder.add(rs.getString(3));
				holder.add(rs.getInt(1));
				
				
				
				
				
				

			for(int j=0;j<4;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 st.close();
			 st2.close();
			 connecter.AvoirConnection().close();
			
		return data;
	   }
	   public static String[][] FichCNE(int cne) throws SQLException{
		   Coneect connecter=new Coneect();
           int RowNombre = 0;
			ArrayList holder =new ArrayList<>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select fichabsence.id_fich,dates,type,justification from etudfich inner join fichabsence on etudfich.id_fich =fichabsence.id_fich where cne=? order by fichabsence.id_fich");
			 st.setInt(1, cne);
			 ResultSet rs=st.executeQuery();
				PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count( *) from etudfich inner join fichabsence on etudfich.id_fich =fichabsence.id_fich where cne=?");
			    st2.setInt(1,cne);
			    ResultSet rs2=st2.executeQuery();
				while(rs2.next()) {
					RowNombre=rs2.getInt(1);
				}
				
				int i =0;
				int arayindex=0;
				String[][] data=new String[RowNombre][4];
				while(rs.next()) {
					holder.add(rs.getInt(1));
					holder.add(rs.getTimestamp(2));
					holder.add(rs.getString(3));
					holder.add(rs.getString(4));
					
					
				for(int j=0;j<4;j++) {
						data[i][j]= String.valueOf(holder.get(arayindex));
						arayindex++;
					}
				i++;
				arayindex=0;
				holder.clear();   
				
		   }
				 connecter.AvoirConnection().close();
			return data;
	   }
	   public static String[][] administration() throws SQLException{
		   Coneect connecter=new Coneect();
           int RowNombre = 0;
			ArrayList holder =new ArrayList<>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select * from enseignat");
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(*) from enseignat");
		    ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][10];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getString(5));
				holder.add(rs.getString(6));
				holder.add(rs.getString(7));
				holder.add(rs.getDate(8));
				holder.add(rs.getString(9));
				holder.add(rs.getString(10));
				
				
				
				
				
				

			for(int j=0;j<10;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		return data;
	   }
	   public static void inserJustification(int id_fich,int cne,String just) throws SQLException {
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("delete from etudfich where id_fich=? and cne=? ");
		   st2.setInt(1, id_fich);
		   st2.setInt(2, cne);
		   st2.executeUpdate();
		   st2.close();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("insert into etudfich(id_fich,cne,justification) values(?,?,?)");
		   st.setInt(1, id_fich);
		   st.setInt(2, cne);
		   st.setString(3, just);
		   st.executeUpdate();
		   st.close();
		   connecter.AvoirConnection().close();
		   
	   }
	   
	   public static String[][]  selectionFichierAbsence() throws SQLException{
		           Coneect connecter=new Coneect();
		            int RowNombre = 0;
					ArrayList holder =new ArrayList<>();
					PreparedStatement st =connecter.AvoirConnection().prepareStatement("select id_fich,module.nom,dates,type ,count(*) as 'absence' from fichabsence natural join  etudfich natural join module  group by id_fich");
					ResultSet rs=st.executeQuery();
					PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(*)  from (select    id_fich as 'absence' from fichabsence natural join  etudfich natural join module  group by id_fich)  as  absence;");
					ResultSet rs2=st2.executeQuery();
					while(rs2.next()) {
						RowNombre=rs2.getInt(1);
					}
					int i =0;
					int arayindex=0;
					String[][] data=new String[RowNombre][5];
					while(rs.next()) {
						holder.add(rs.getInt(1));
						holder.add(rs.getString(2));
						Date date = rs.getTimestamp(3); 
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // create a SimpleDateFormat object with the desired date format
						String dateString = format.format(date); // format the Date object as a string
						holder.add(dateString);
						holder.add(rs.getString(4));
						holder.add(rs.getInt(5));
		
					for(int j=0;j<5;j++) {
							data[i][j]= String.valueOf(holder.get(arayindex));
							arayindex++;
						}
					i++;
					arayindex=0;
					holder.clear();   
					
			   }
					 connecter.AvoirConnection().close();
				return data;
	   }
	   
	   public static String[][] searchabsenceDate(String value,String type) throws SQLException{
		   Coneect connecter=new Coneect();
		   int RowNombre = 0;
		   ArrayList holder =new ArrayList<>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("select id_fich,module.nom,dates,type ,count(*) as 'absence' from fichabsence natural join  etudfich natural join module  where dates like ?  and type=? group by id_fich");
		   st.setString(1, value+"%");
		   st.setString(2, type);
		   ResultSet rs=st.executeQuery();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count( distinct id_fich) from fichabsence natural join  etudfich natural join module  where dates like ? and type= ? ");
		  
		   st2.setString(1,value+"%");
		   st2.setString(2, type);
		   ResultSet rs2=st2.executeQuery();
		   while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
		   int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][5];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				Date date = rs.getTimestamp(3); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));

			for(int j=0;j<5;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			st.close();
			st2.close();
			 connecter.AvoirConnection().close();
		return data;
		
			
			
			
	   }
	   public static String[][] searchabsencemodule(String value,String type) throws SQLException{
		   Coneect connecter=new Coneect();
		   int RowNombre = 0;
		   ArrayList holder =new ArrayList<>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("select id_fich,module.nom,dates,type ,count(*) as 'absence' from fichabsence natural join  etudfich natural join module  where module.nom like ? and type=? group by id_fich");
		   st.setString(1, value+"%");
		   st.setString(2, type);
		   ResultSet rs=st.executeQuery();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count( distinct id_fich) from fichabsence natural join  etudfich natural join module  where module.nom like 	? and type=? ");
		   st2.setString(1,value+"%");
		   st2.setString(2, type);
		   ResultSet rs2=st2.executeQuery();
		   while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
		   int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][5];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				Date date = rs.getTimestamp(3); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));

			for(int j=0;j<5;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		return data;
			
			
			
	   }
	   public static String[][] getEtudiantDate(String date1,String email) throws SQLException{
		   Coneect connecter=new Coneect();
		   int RowNombre = 0;
			ArrayList holder =new ArrayList<>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and  date_naissance like ?");
			st.setString(1, email);
			st.setString(2, date1+"%");
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne) from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and  date_naissance like ?");
			st2.setString(1,email);
			st2.setString(2,date1+"%");
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
	    st.close();
	    st2.close();
	    connecter.AvoirConnection().close();
		return data;
		}
		
	  
	   public static String[][] SelectionEtudiantModuleExceptoinSql(String email,String module) throws SQLException, ClassNotFoundException{
			Coneect connecter=new Coneect();
			ArrayList holder =new ArrayList<>();
			int RowNombre = 0;
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and module.nom=?  ");
			st.setString(1, email);
			st.setString(2,module);
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne)  from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and module.nom=? ");
			st2.setString(1, email);
			st2.setString(2,module);
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
	   st.close();
	   st2.close();
	   connecter.AvoirConnection().close();
		  return data;	
	
	
	   }
	   public static Hashtable<String,Integer> toutModule() throws SQLException{
		   Coneect connecter=new Coneect();
		   Hashtable holder =new  Hashtable<String,Integer>();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select module.nom , module.id_module from module;");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				holder.put(rs.getString(1), rs.getInt(2));
			}
			 connecter.AvoirConnection().close();
			return holder;
	   }
	   public static ArrayList<String> toutNiveau() throws SQLException{
		   Coneect connecter=new Coneect();
		   ArrayList holder =new ArrayList<>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("select * from filiere");
		   ResultSet rs=st.executeQuery();
		   while(rs.next()) {
				holder.add(rs.getString(1));
			}
		   st.close();
		   connecter.AvoirConnection().close();
			return holder;
			
		   
	   }
	   public static void insertNiveau(String niveau) throws SQLException {
		   Coneect connecter=new Coneect();
		   ArrayList holder =new ArrayList<>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("insert into filiere value(?);");
		   st.setString(1, niveau);
		   st.executeUpdate();
		   connecter.AvoirConnection().close();
	   }
	   
	   public static void insertModule(String module) throws SQLException {
		   Coneect connecter=new Coneect();
		   ArrayList holder =new ArrayList<>();
		   int ID = 0;
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select id_module from module order by id_module desc limit 1");
		   ResultSet rs2=st2.executeQuery();
		   while(rs2.next()) {
			   ID=rs2.getInt(1);
		   }
		   ID+=1;
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("insert into module(id_module,nom) value(?,?);");
		   st.setInt(1, ID);
		   st.setString(2,module);
		   st.executeUpdate();
		   connecter.AvoirConnection().close();
	   }
	   public static void deleteNiveau(String niveau) throws SQLException {
		   Coneect connecter=new Coneect();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("delete from filiere where niveau=?");
		   st.setString(1, niveau);
		   st.executeUpdate();
		   connecter.AvoirConnection().close();
	   }
	   public static void deleteModule(String module,int id) throws SQLException {
		   Coneect connecter=new Coneect();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("delete from module where nom=?");
		   st.setString(1, module);
		   st.executeUpdate();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement(" update module set id_module=id_module-1 where id_module>?");
		   st2.setInt(1, id);
		   st2.executeUpdate();
		   connecter.AvoirConnection().close();
	   }
	   public static Hashtable<String,String> toutEnseignt() throws SQLException{
		   Coneect connecter=new Coneect();
		   Hashtable holder =new  Hashtable<String,String>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("select concat(nom,' ', prenom),email from enseignat");
		   ResultSet rs=st.executeQuery();
		   while(rs.next()) {
				holder.put(rs.getString(1), rs.getString(2));
			}
		   st.close();
		   connecter.AvoirConnection().close();
			return holder;
		   
	   }
	   public static void registerNM(String niveau,String module) throws SQLException {
		   Coneect connecter=new Coneect();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("update module set niveau=? where nom=?");
		   st.setString(1,niveau);
		   st.setString(2,module);
		   st.executeUpdate();
		   connecter.AvoirConnection().close();
		   
	   }
	   public static void registerME(String email,String Password,int module) throws SQLException {
		   Coneect connecter=new Coneect();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("insert into ensei_module(email,password,id_module) values(?,?,?)");
		   st.setString(1, email);
		   st.setString(2, Password);
		   st.setInt(3, module);
		   st.executeUpdate();
		   connecter.AvoirConnection().close();
		   
	   }
	   public static String[][] SelectionEtudiantModuleNote(String email,String module) throws SQLException, ClassNotFoundException{
			Coneect connecter=new Coneect();
			ArrayList holder =new ArrayList<>();
			int RowNombre = 0;
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and module.nom=?  order by etudiant.etud_id;");
			st.setString(1, email);
			st.setString(2,module);
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne)  from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and module.nom=?  order by etudiant.etud_id;");
			st2.setString(1, email);
			st2.setString(2,module);
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][6];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
	
			for(int j=0;j<6;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
	   st.close();
	   connecter.AvoirConnection().close();
		  return data;	
	   }
	   
	   public static String[][] SelectionEtudiantModuleABsence(String email,String module) throws SQLException, ClassNotFoundException{
			Coneect connecter=new Coneect();
			ArrayList holder =new ArrayList<>();
			int RowNombre = 0;
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and module.nom=?  order by etudiant.etud_id;");
			st.setString(1, email);
			st.setString(2,module);
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne)  from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and module.nom=?  order by etudiant.etud_id;");
			st2.setString(1, email);
			st2.setString(2,module);
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][4];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getInt(9));
				
				
	
			for(int j=0;j<4;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
	   st.close();
	   connecter.AvoirConnection().close();
		  return data;	
	   }
	   public static int moduleId(String module) throws SQLException {
		   Coneect connecter=new Coneect();
		   int id = 0;
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("select id_module from module where nom=?;");
		   st.setString(1, module);
		   ResultSet rs=st.executeQuery();
		   while(rs.next()) {
			   id=rs.getInt(1);
		   }
		   st.close();
		   connecter.AvoirConnection().close();
		   return id;
	   }
	   public static ArrayList selectionNotes(int cne,int id) throws SQLException {
		   Coneect connecter=new Coneect();
		   ArrayList holder =new ArrayList<>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("select noteC1,noteC2 from module_etud where cne=? and id_module=?;");
		   st.setInt(1,cne);
		   st.setInt(2, id);
		   ResultSet rs=st.executeQuery();
		   while(rs.next()) {
			   holder.add(rs.getFloat(1));
			   holder.add(rs.getFloat(2));
		   }
		   st.close();
		   connecter.AvoirConnection().close();
		   
		   
		   return holder;
	   }
	   public static void insertNotes(int id,int cne,float note1,float note2) throws SQLException {
		   Coneect connecter=new Coneect(); 

		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("delete from module_etud where id_module=? and cne=?;");
		   st2.setInt(1, id);
		   st2.setInt(2, cne);
		   st2.executeUpdate();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement( " insert into module_etud(id_module,cne,noteC1,noteC2) values(?,?,?,?);");
	       st.setInt(1,id);
	       st.setInt(2, cne);
	       st.setFloat(3, note1);
	       st.setFloat(4, note2);
	       st.executeUpdate();
	       connecter.AvoirConnection().close();
	   }
	   public static void insertNote1(int id,int cne,float note1) throws SQLException {
		   Coneect connecter=new Coneect(); 
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("delete from module_etud where id_module=? and cne=?;");
		   st2.setInt(1, id);
		   st2.setInt(2, cne);
		   st2.executeUpdate();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("insert into module_etud(id_module,cne,noteC1) values(?,?,?);");
	       st.setInt(1, id);
	       st.setInt(2, cne);
	       st.setFloat(3, note1);
	       st.executeUpdate();
	       connecter.AvoirConnection().close();
	   }
	   public static void insertNote2(int id,int cne,float note2) throws SQLException {
		   Coneect connecter=new Coneect(); 
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("delete from module_etud where id_module=? and cne=?;");
		   st2.setInt(1, id);
		   st2.setInt(2, cne);
		   st2.executeUpdate();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("insert into module_etud(id_module,cne,noteC2) values(?,?,?);");
	       st.setInt(1, id);
	       st.setInt(2, cne);
	       st.setFloat(3, note2);
	       st.executeUpdate();
	       connecter.AvoirConnection().close();
	   }
	   public static void UpdateNotes(float note1,float note2,int id,int cne) throws SQLException {
		   Coneect connecter=new Coneect(); 
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement(" update  module_etud set noteC1=?, noteC2=? where id_module=? and cne=?;");
		   st.setFloat(1, note1);
		   st.setFloat(2, note2);
		   st.setInt(3, id);
		   st.setInt(4, cne);
		   st.executeUpdate();
		   connecter.AvoirConnection().close();
	   }
	   public static void UpdateNote1(float note1,int id,int cne) throws SQLException {
		   Coneect connecter=new Coneect(); 
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement(" update  module_etud set noteC1=? where id_module=? and cne=?;");
		   st.setFloat(1, note1);
		   st.setInt(2, id);
		   st.setInt(3, cne);
		   st.executeUpdate();
	   }
	   public static void UpdateNote2(float note2,int id,int cne) throws SQLException {
		   Coneect connecter=new Coneect(); 
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement(" update  module_etud set noteC2=? where id_module=? and cne=?;");
		   st.setFloat(1, note2);
		   st.setInt(2, id);
		   st.setInt(3, cne);
		   st.executeUpdate();
		   connecter.AvoirConnection().close();
	   }
	   public static Hashtable<Integer,Integer> selectionEtudmodule() throws SQLException {
		   Coneect connecter=new Coneect();
		   Hashtable<Integer,Integer> table =new Hashtable<>();
		   PreparedStatement st =connecter.AvoirConnection().prepareStatement("select id_module,cne from module_etud");
		   ResultSet rs=st.executeQuery();
		   while(rs.next()) {
			   table.put(rs.getInt(1),rs.getInt(2) );
		   }
		   connecter.AvoirConnection().close();
		   return table;
		   
	   }
	   public static String[][] SelectionEtudiantModuleExceptoinSql(String email,String module,String choix1,String choix2) throws SQLException, ClassNotFoundException{
			Coneect connecter=new Coneect();
			ArrayList holder =new ArrayList<>();
			int RowNombre = 0;
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select distinct etudiant.* from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and module.nom=? "+"ORDER BY " + choix1 + " " + choix2);
			st.setString(1, email);
			st.setString(2,module);
			ResultSet rs=st.executeQuery();
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne)  from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and module.nom=?  order by ? ?");
			st2.setString(1, email);
			st2.setString(2,module);
			st2.setString(3,choix1);
			st2.setString(4,choix2);
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				RowNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[RowNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		  return data;	
	   }
	   public static void AjoutEtud(int cne,String nom,String prenom,String etat,int apooge,String diplome,LocalDate naissance ,String niveau,String tele,String adresse) throws SQLException {
		   Coneect connecter=new Coneect();
		   int id_etud=0;
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("insert into etudiant "
				+ " values(?,?,?,?,?,?,?,?,?,?,?); ");
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select etud_id from etudiant where niveau=? order by   etud_id  desc limit 1");
			st2.setString(1, niveau);
			ResultSet rs=st2.executeQuery();
	
			while(rs.next()) {
				id_etud=rs.getInt(1);
			}
			id_etud+=1;
			st.setInt(1, cne);
			st.setString(2, nom);
			st.setString(3, prenom);
			st.setString(4, etat);
			st.setInt(5, apooge);
			st.setString(6, diplome);
			java.sql.Date sqlDate = java.sql.Date.valueOf(naissance);
			st.setDate(7, sqlDate);
			st.setString(8, niveau);
			st.setInt(9,id_etud);
			st.setString(10,tele);
			st.setString(11,adresse);
			st.executeUpdate();
			 connecter.AvoirConnection().close();
	   }
	   public static int fichId() throws SQLException {
		   Coneect connecter=new Coneect();
		   int id_fich=0;
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select id_fich from fichabsence  order by   id_fich  desc limit 1");
		   ResultSet rs=st2.executeQuery();
			while(rs.next()) {
				id_fich=rs.getInt(1);
			}
			id_fich+=1;
			 connecter.AvoirConnection().close();
			return id_fich;
		   
	   }
	   public static void newFich(int id_fich,int id_module,String type) throws SQLException {
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("insert into fichabsence(id_fich,id_module,type) values(?,?,?);");
		   st2.setInt(1, id_fich);
		   st2.setInt(2, id_module);
		   st2.setString(3, type);
		   st2.executeUpdate();
		   connecter.AvoirConnection().close();
	   }
	   
	   
	   public static String[][] SelectionDynamiqueEtudiantsAllSql() throws SQLException, ClassNotFoundException{
		   Coneect connecter=new Coneect();
			ArrayList holder =new ArrayList<>();
			int ColumnNombre = 0;
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("select cne,nom,prenom,etat_civil,apogee,diplome,date_naissance,niveau,etud_id from etudiant ");
			PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(cne) from etudiant ;");
			ResultSet rs2=st2.executeQuery();
			ResultSet rs=st.executeQuery();
			while(rs2.next()) {
				ColumnNombre=rs2.getInt(1);
			}
			int i =0;
			int arayindex=0;
			String[][] data=new String[ColumnNombre][11];
			while(rs.next()) {
				holder.add(rs.getInt(1));
				holder.add(rs.getString(2));
				holder.add(rs.getString(3));
				holder.add(rs.getString(4));
				holder.add(rs.getInt(5));
				holder.add(rs.getString(6));
				Date date = rs.getDate(7); 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // create a SimpleDateFormat object with the desired date format
				String dateString = format.format(date); // format the Date object as a string
				holder.add(dateString);
				holder.add(rs.getString(8));
				holder.add(rs.getInt(9));
				holder.add(rs.getString(10));
				holder.add(rs.getString(11));
			for(int j=0;j<11;j++) {
					data[i][j]= String.valueOf(holder.get(arayindex));
					arayindex++;
				}
			i++;
			arayindex=0;
			holder.clear();   
			
	   }
			 connecter.AvoirConnection().close();
		  return data;
		 
		   
	   }
	   public static  void setDynamiqueEtudiantsAllSql(int cne,String nom,String prenom,String etat,int apooge,String diplome,LocalDate naissance ,String niveau,int etud_id,String tele,String adr) throws SQLException {
		   Coneect connecter=new Coneect();
			PreparedStatement st =connecter.AvoirConnection().prepareStatement("update etudiant \r\n"
					+ "set nom=?, prenom=? ,etat_civil=?,apogee=?,diplome=?,date_naissance=?,niveau=?,etud_id=?,téléphone=?,adresse=? where cne=?; ");
			st.setString(1, nom);
			st.setString(2, prenom);
			st.setString(3, etat);
			st.setInt(4, apooge);
			st.setString(5, diplome);
			java.sql.Date sqlDate = java.sql.Date.valueOf(naissance);
			st.setDate(6, sqlDate);
			st.setString(7, niveau);
			st.setInt(8, etud_id);
			st.setString(9, tele);
			st.setString(10, adr);
			st.setInt(11, cne);
			st.executeUpdate();
			 connecter.AvoirConnection().close();
	   }
	   public static ArrayList<Boolean> intialisingCheckbox(String Email,String module) throws ClassNotFoundException, SQLException {
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select count(distinct etudiant.cne)  from ensei_module natural join module natural join filiere  inner join  etudiant on module.niveau=etudiant.niveau where email=? and module.nom=?  order by etudiant.etud_id;");
		   st2.setString(1, Email);
		   st2.setString(2, module);
		   int ColumnNombre = 0;
		   ResultSet rs2=st2.executeQuery();
			while(rs2.next()) {
				ColumnNombre=rs2.getInt(1);
			}
			ArrayList<Boolean> checkboxvalue=new ArrayList<>();
			for(int i=0;i<ColumnNombre;i++) {
				checkboxvalue.add(false);
			}
			 connecter.AvoirConnection().close();
			return checkboxvalue ;
	   }
	   public static void insertAbsence(int id,ArrayList<Integer> etud) {
		// Assuming the ArrayList is called 'values'
		   Coneect connecter=new Coneect();
		   String sql = "INSERT INTO etudfich (id_fich, cne) VALUES ( "+id+", ?);";
		   try {
		       PreparedStatement pstmt = connecter.AvoirConnection().prepareStatement(sql);
		       for (int value : etud) {
		           pstmt.setInt(1, value);
		           pstmt.executeUpdate();
		       }
		       pstmt.close();
		       connecter.AvoirConnection().close();
		   } catch (SQLException e) {
		       e.printStackTrace();
		   }
		 
	   }
	   public static ArrayList<Integer> EtudiantId() throws SQLException {
		   ArrayList<Integer> arry=new ArrayList<>();
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select etud_id from etudiant ;");
		   ResultSet rs=st2.executeQuery();
		   while(rs.next()) {
			  
               arry.add(rs.getInt(1));
		   }
			   
		  return arry;
	   }
	   public static Hashtable<String,String> passEn() throws SQLException{
		   Hashtable<String,String> holder =new Hashtable<String,String>();
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select email,password from enseignat");
		   ResultSet rs=st2.executeQuery();
		   while(rs.next()) {
			   holder.put(rs.getString(1),rs.getString(2)); 
		   }
		   connecter.AvoirConnection().close();
		   return holder;
		   
	   }
	   public void deleteEtudiant( int cne,int id,String niveau) throws SQLException {
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("delete from etudiant  where cne=? ;");
		   st2.setInt(1, cne);
		   st2.executeUpdate();
		   String updateSql = "update etudiant SET etud_id = etud_id - 1 WHERE etud_id > ? and niveau=?";
		   PreparedStatement update = connecter.AvoirConnection().prepareStatement(updateSql);
		   update.setInt(1, id);
		   update.setString(2, niveau);
		   update.executeUpdate();
		  
		   
	   }
	   
	   public void deleteAbsence( int id) throws SQLException {
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("delete from fichabsence  where id_fich=? ;");
		   st2.setInt(1, id);
		   st2.executeUpdate();
		   String updateSql = "update fichabsence SET id_fich = id_fich - 1 WHERE id_fich > ? ";
		   PreparedStatement update = connecter.AvoirConnection().prepareStatement(updateSql);
		   update.setInt(1, id);
		   update.executeUpdate();
		   connecter.AvoirConnection().close();
		   
	   }
	   public void setFiliere(String nivau) throws SQLException {
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("insert into filiere values(?) ;");
		   st2.setString(1, nivau);
		   st2.executeUpdate();
		   
	   }
	   public ArrayList<String> getFiliere() throws SQLException{
		   ArrayList<String> arry=new ArrayList<>();
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select * from filiere ;");
		   ResultSet rs=st2.executeQuery();
		   while(rs.next()) {
			  
               arry.add(rs.getString(1));
		   }
		   connecter.AvoirConnection().close();
		  return arry;
	   }
	   public static ArrayList<LocalDate> EtudiantDateDeNaissance() throws SQLException {
		   ArrayList<LocalDate> arry=new ArrayList<>();
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select date_naissance from etudiant ;");
		   ResultSet rs=st2.executeQuery();
		   while(rs.next()) {
			   LocalDate date = rs.getDate(1).toLocalDate();
               arry.add(date);
		   }
		   connecter.AvoirConnection().close();
		  return arry; 
	   }
	   public static ArrayList<Integer> EtudiantApogee() throws SQLException{
		   ArrayList<Integer> arry=new ArrayList<>();
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select apogee from etudiant ;");
		   ResultSet rs=st2.executeQuery();
		   while(rs.next()) {
			  
               arry.add(rs.getInt(1));
		   }
		   connecter.AvoirConnection().close();   
		  return arry; 
	   }
	   public static ArrayList<String> getModule(String email,String password) throws SQLException {
		   ArrayList<String> arry=new ArrayList<>();
		   Coneect connecter=new Coneect();
		   PreparedStatement st2 =connecter.AvoirConnection().prepareStatement("select nom from ensei_module inner join module on ensei_module.id_module=module.id_module where email=? and password=?;");
		   st2.setString(2, password);
		   st2.setString(1,email);
		   ResultSet rs=st2.executeQuery();
		   while(rs.next()) {
               arry.add(rs.getString(1));
		   }
		
		   return  arry;
	   }
	}
