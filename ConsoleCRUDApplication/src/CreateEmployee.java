import java.sql.SQLException;
import java.util.Scanner;

public class CreateEmployee {

	public void createEmployee() {
		Scanner scan = new Scanner(System.in);
		System.out.println("You choose to create employee");
		System.out.println("Please enter employee's name:");
		String name = scan.nextLine();
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
				"INSERT INTO ConsoleCRUDApplication.Employees (name, surname, email, contact_number, department) VALUES ('"
						+ name + "', '" + surname + "', '" + email + "', '" + contactNumber + "', '" + department
						+ "');");

		dbutilities.closeConnection();
		
	}

}
