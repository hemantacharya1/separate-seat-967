package HOD_usecases;

import java.util.Scanner;

import beanClass.Engineer;
import dao.HOD_Dao;
import dao.HOD_Dao_implements;

public class RegisterEngineerUseCase2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Engineer's Name:");
		String name=sc.next();
		System.out.println("Enter The Department (Software/Hardware): ");
		String department=sc.next();
		System.out.println("Enter The username(email): ");
		String email=sc.next();
		System.out.println("Enter The Password:");
		String password=sc.next();
		
		HOD_Dao dao=new HOD_Dao_implements();
		
		Engineer engineer =new Engineer();
		
		engineer.setName(name);
		engineer.setDepartment(department);
		engineer.setEmail(email);
		engineer.setPassword(password);
		
		String result = dao.registerEngineer(engineer);
		
		System.out.println(result);
	}
}
