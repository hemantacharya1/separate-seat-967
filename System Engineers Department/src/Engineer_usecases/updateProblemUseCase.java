package Engineer_usecases;

import java.util.Scanner;

import dao.Engineer_Dao;
import dao.Engineer_dao_impl;
import exception.engineerException;

public class updateProblemUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Problem Id:");
		int probId=sc.nextInt();
		System.out.println("Enter the Update on Problem: "+probId+"(Resolved/Pending)");
		String updates=sc.next();
		
		Engineer_Dao dao=new Engineer_dao_impl();
		
		try {
			String result=dao.updateProblem(updates, 1, probId);
			System.out.println(result);
		} catch (engineerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
