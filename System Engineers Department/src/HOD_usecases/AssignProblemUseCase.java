package HOD_usecases;

import java.util.Scanner;

import dao.HOD_Dao;
import dao.HOD_Dao_implements;
import exception.engineerException;

public class AssignProblemUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Engineer Id:");
		int engId=sc.nextInt();
		System.out.println("Enter the Problem Id:");
		int probId=sc.nextInt();
		
		HOD_Dao dao=new HOD_Dao_implements();
		
		try {
			String result=dao.assignProblem(engId,probId);
			
			System.out.println(result);
		} catch (engineerException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
