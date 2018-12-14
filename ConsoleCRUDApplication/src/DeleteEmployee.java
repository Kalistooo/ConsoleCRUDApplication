import java.util.Scanner;

public class DeleteEmployee {
	public void deleteEmployee() {
		System.out.println("You are deleting employee's data.");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter employee's ID:");
		int id = scan.nextInt();
		UpdateEmployee ue = new UpdateEmployee();
		if(ue.showRecordToUpdateWhereIDIsEqualTo(id)) {
			System.out.println("Are you sure you want to delete this employee? Write 'yes' to approve.");
			String accept = scan.nextLine();
			accept = scan.nextLine();
			if(accept.equals("yes")) {
				DBUtilities dbu = new DBUtilities();
				dbu.executeStatement("DELETE FROM consolecrudapplication.employees WHERE consolecrudapplication.employees.id=" + id + ";");
			}else {
				System.out.println("Delete cancelled.");
			}
		}
	}
}
