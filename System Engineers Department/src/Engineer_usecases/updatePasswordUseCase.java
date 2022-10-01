package Engineer_usecases;

import java.util.Scanner;

import dao.Engineer_Dao;
import dao.Engineer_dao_impl;
import exception.engineerException;

public class updatePasswordUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Password:");
		int password=sc.nextInt();
		
		Engineer_Dao dao=new Engineer_dao_impl();
		
		try {
			String result=dao.updatePassword(1, password);
			System.out.println(result);
		} catch (engineerException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
