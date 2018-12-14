import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtilities {
	
	private static final String databaseUrl = "jdbc:mysql://localhost/consolecrudapplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	private static final String userName = "root";
	private static final String password = "123456789";
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	public DBUtilities (){
		
			try {
				connection = DriverManager.getConnection(databaseUrl, userName, password);
			} catch (SQLException e) {			
				System.out.println("Error: " + e.getMessage());
			}
		
	}
	
	public ResultSet showRecords (String stmt) {
		try {
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(stmt);
			
			return resultSet;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void executeStatement (String stmt) {
		try {
			statement = connection.createStatement();
			int rowsAffected = statement.executeUpdate(stmt);
			System.out.println("Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}
	
	public void closeConnection () {
		try {
			connection.close();
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
