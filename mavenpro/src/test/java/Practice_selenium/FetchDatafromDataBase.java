package Practice_selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDatafromDataBase {

	public static void main(String[] args) throws Throwable {

		// step1: register driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		// step2:- get connection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedata", "root", "siddup$30");

		// step3:-create SQL Statement
		Statement state = conn.createStatement();
		String Query = "select * from employee";

		//step4:- execute statement/query
		ResultSet result = state.executeQuery(Query);

		while (result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4));
			}
		//step5:- close data base connection
		conn.close();
	}
}
