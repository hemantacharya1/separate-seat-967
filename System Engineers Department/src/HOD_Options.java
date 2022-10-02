import java.util.Scanner;


public class HOD_Options {

	
	
	public static void HOD_Select() {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nPlease Select an Option to continue:");
		System.out.println("\n1: Register a new Engineer \n2: See List of All Engineers "
				+ "\n3: Delete Engineer From System \n4: See All the Raised Problems"
				+ " \n5: Assign Problem To Engineers \n6: Exit The App");
		
		
		int choice=sc.nextInt();
		
		switch (choice) {
		case 1:
			HOD_usecases.RegisterEngineerUseCase1.main(null);
			HOD_Options.HOD_Select();
			break;
		case 2:
			HOD_usecases.ListAllEngineerUseCase.main(null);
			HOD_Options.HOD_Select();
			break;
		case 3:
			HOD_usecases.DeleteEngineerUseCase.main(null);
			HOD_Options.HOD_Select();
			break;
		case 4:
			HOD_usecases.getAllProblemsUseCase.main(null);
			HOD_Options.HOD_Select();
			break;
		case 5:
			HOD_usecases.AssignProblemUseCase.main(null);
			HOD_Options.HOD_Select();
			break;
		case 6:
			return;
			
		default:
			System.out.println("Wrong Input..!");
			HOD_Options.HOD_Select();
			break;
	}
  }
}
