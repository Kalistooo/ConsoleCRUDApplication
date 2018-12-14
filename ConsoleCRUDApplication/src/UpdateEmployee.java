import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee {
	DBUtilities dbu = new DBUtilities();

	public void updateEmployee() {
		System.out.println("You are updating employee's data.");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter employee's ID:");
		int id = scan.nextInt();
		if(showRecordToUpdateWhereIDIsEqualTo(id)) {

		System.out.println("Please enter employee's name:");
		String name = scan.nextLine();
		name = scan.nextLine();
		System.out.println("Please enter employee's surname:");
		String surname = scan.nextLine();
		
		System.out.println("Please enter employee's email:");
		String email = scan.nextLine();
		System.out.println("Please enter employee's phone number:");
		int contactNumber = scan.nextInt();
		System.out.println("Please enter employee's department:");
		String department = scan.nextLine();
		department = scan.nextLine();
		DBUtilities dbutilities = new DBUtilities();

		dbutilities.executeStatement(
				"UPDATE ConsoleCRUDApplication.Employees SET name='"+ name +"', surname='" + surname + "', email='" + email +"', contact_number='" + contactNumber + "', department='" 
		+ department+"' WHERE id="+ id + ";");
		}
	}

	public boolean showRecordToUpdateWhereIDIsEqualTo(int id) {
		try {
			ResultSet rs = dbu.showRecords(
					"SELECT * FROM consolecrudapplication.employees WHERE consolecrudapplication.employees.id = " + id
							+ ";");
			if(rs.next()) {
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			int columnsNumber = resultSetMetaData.getColumnCount();
			System.out.printf("%-15s%-15s%-15s%-16s%-20s%-15s\n", "ID", "Name", "Surname", "Email", "Phone Number",
					"Department");
			
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.printf("%-12s", columnValue);
				}
				System.out.println("");

			
			dbu.closeConnection();
			return true;
			}else {
				System.out.println("Record with ID: " + id +" not found.");
				dbu.closeConnection();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}

