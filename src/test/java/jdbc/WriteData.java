package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class WriteData {

	public static void main(String[] args) throws SQLException {
Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		System.out.println("Database connection is established");
		int result= connection.createStatement().executeUpdate("insert into lead values('Chandan','Roy','Wipro');");
		if(result==1) {
			System.out.println("Database has beeb updated");
		}
		else
			System.out.println("Database has not been updated");
	}

}
