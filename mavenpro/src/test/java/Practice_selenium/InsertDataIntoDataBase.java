package Practice_selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDataBase {
	
	public static void main(String[] args) throws Throwable {

		// step1: register driver
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);

				// step2:- get connection to database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedata", "root", "siddup$30");

				// step3:-create SQL Statement
				Statement state = conn.createStatement();
				String query = "insert into employee(regno,firstname,lastname,address)values('3','rathin','reddy','bglore')";
				
				int result = state.executeUpdate(query);

				if(result==1)
				{
					System.out.println("user is created");
				}
				else
				{
					System.out.println("user is not created");
				}
				conn.close();
	}

}
