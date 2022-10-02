package Engineer_usecases;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beanClass.Problem;
import dao.Engineer_Dao;
import dao.Engineer_dao_impl;
import exception.engineerException;

public class Engineer_options {

	static Engineer_Dao dao=new Engineer_dao_impl();
	
	public static void Select(int id) {
		try {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nPlease Select an Option to continue:");
		System.out.println("\n1: See All Assigned Problems  \n2: Update Status of Problems "
				+ "\n3: See List of All attended Problems  \n4: Change Password"
				+ " \n5: Exit The App");
		
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				List<Problem> problems=new ArrayList<>();
				
				problems=dao.viewAssignedProblem(id);
				problems.forEach(i-> System.out.println(i));
				
				Engineer_options.Select(id);
				break;
			case 2:
				List<Problem>attendedProblems=new ArrayList<>();
				attendedProblems=dao.viewAttendProblem(id);
				attendedProblems.forEach(i->System.out.println(i));
				
				Engineer_options.Select(id);
				break;
				
			case 3:
				System.out.println("Enter the Problem Id:");
				int probId=sc.nextInt();
				System.out.println("Enter the Update on Problem: "+probId+"(Resolved/Pending)");
				String updates=sc.next();
				
				String result1=dao.updateProblem(updates, id, probId);
				System.out.println(result1);
				
				Engineer_options.Select(id);
				break;
			case 4:
				System.out.println("Enter Your username:");
				String username=sc.next();
				System.out.println("Enter Your Password");
				String password=sc.next();
				
				String result=dao.updatePassword(username, password);
				System.out.println(result);
				
				Engineer_options.Select(id);
				break;
				
			case 5:
				return;
				
			default:
				System.out.println("Wrong Input..!");
				Engineer_options.Select(id);
				break;
		}
		} catch (engineerException e) {
			
			System.out.println(e.getMessage());
			Engineer_options.Select(id);
		
		}
  }
}
