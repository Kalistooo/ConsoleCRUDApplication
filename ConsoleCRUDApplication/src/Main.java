import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean quit = false;
		System.out.println("Welcome in console CRUD application!");

		do {
			showMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				CreateEmployee ce = new CreateEmployee();
				ce.createEmployee();
				break;
			case 2:
				ShowEmployees se = new ShowEmployees();
				se.showEmployees();
				break;
			case 3:
				UpdateEmployee ue = new UpdateEmployee();
				ue.updateEmployee();
				break;
			case 4:
				DeleteEmployee de = new DeleteEmployee();
				de.deleteEmployee();
				break;
			case 5:
				System.out.println("Closing...");
				quit = true;
				break;
			default:
				System.out.println("Wrong input. Try again.");
			}

		} while (!quit);
	}

	private static void showMenu() {
		System.out.println();
		System.out.println("Please choose action: ");
		System.out.println("1. Create record.");
		System.out.println("2. Read records.");
		System.out.println("3. Update record.");
		System.out.println("4. Delete record.");
		System.out.println("5. Quit\n\nChoose action: ");
	}
}
