package Engineer_usecases;
import java.util.Scanner;


import beanClass.Engineer;
import dao.Engineer_Dao;
import dao.Engineer_dao_impl;
import exception.engineerException;
public class engineerLoginUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Engineer UserName:");
		String username=sc.next();
		System.out.println("Enter Engineer Password:");
		String password=sc.next();
		
		Engineer_Dao dao=new Engineer_dao_impl();
		
		try {
			Engineer eng=dao.loginToSystem(username, password);
			System.out.println("Welcome "+eng.getName());
			int id=eng.getEngId();
			
			Engineer_usecases.Engineer_options.Select(id);
		
		} catch (engineerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
