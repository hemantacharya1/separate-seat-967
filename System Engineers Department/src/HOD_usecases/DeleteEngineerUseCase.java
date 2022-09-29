package HOD_usecases;

import java.util.Scanner;

import dao.HOD_Dao;
import dao.HOD_Dao_implements;
import exception.engineerException;

public class DeleteEngineerUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Engineer-Id to Delete: ");
		
		int id=sc.nextInt();
		
		HOD_Dao dao=new HOD_Dao_implements();
		
		try {
			String result = dao.deleteEngineerById(id);
				
			System.out.println(result);
		} catch (engineerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}	
	}
}
