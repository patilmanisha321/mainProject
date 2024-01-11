package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organisationDB","root","root");
		Statement state=con.createStatement();
		 int res = state.executeUpdate("UPDATE orginfo SET name=\"Pspider\" WHERE id=3");
		System.out.println(res);
		con.close();
	}

}
