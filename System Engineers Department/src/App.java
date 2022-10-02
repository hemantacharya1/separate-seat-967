import java.util.Scanner;


public class App {
	
	
	static String HOD_ID="Admin";
	static String HOD_Password="admin";
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome to The System..!");
		
		System.out.println("\nChoose Your Option");
		
		System.out.println("\n1: HOD Login \n2: Engineer Login \n3: Employee Login \n");
		
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("Enter HOD username:");
			String id=sc.next();
			System.out.println("Enter HOD password:");
			String pass=sc.next();
			if(id.equals(HOD_ID) && pass.equals(HOD_Password)) {
				System.out.println("Welcome:");
				HOD_Options.HOD_Select();
			}
			else {
				System.out.println("Invalid Username or Password:");
				
			}
			break;
		case 2:
			
			Engineer_usecases.engineerLoginUseCase.main(null);
			break;
		case 3:
			System.out.println("Select Option:");
			System.out.println("1: Register As new Employee \n2: Login to System");
			int choice2=sc.nextInt();
			if(choice2==1) {
				Employee_usecases.registerEmployeeUseCase.main(null);
			}
			if(choice2==2) {
				Employee_usecases.loginEmployeeUseCase.main(null);
			}
			break;
			
		default:
			System.out.println("Invalid input");
			break;
		}
		
		System.out.println("Thank You..!");
	}

}
