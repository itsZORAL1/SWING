package Coneection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneect {
	public static void Connection() throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	public static Connection AvoirConnection() throws SQLException {
		Connection cont=DriverManager.getConnection("jdbc:mysql://localhost:3306/absence","HAJAR","alouahajar2002");
		return cont;
	}

}

