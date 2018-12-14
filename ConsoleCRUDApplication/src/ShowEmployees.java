import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ShowEmployees {

	DBUtilities dbu = new DBUtilities();

	public void showEmployees() {

		try {
			ResultSet resultSet = dbu.showRecords("SELECT * FROM consolecrudapplication.employees;");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnsNumber = resultSetMetaData.getColumnCount();
			System.out.printf("%-15s%-15s%-15s%-16s%-20s%-15s\n", "ID", "Name", "Surname", "Email", "Phone Number",
					"Department");
			while (resultSet.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = resultSet.getString(i);
					System.out.printf("%-12s", columnValue);
				}
				System.out.println("");

			}
			dbu.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
