package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;



public class JDBCExecuteQuery {

	public static void main(String[] args) throws SQLException
	{
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organisationDB","root","root");
		Statement state=con.createStatement();
		ResultSet result=state.executeQuery("select * from orginfo");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
			
		}
		con.close();
	
	}	

}
