package Employee_usecases;

import java.util.Scanner;

import beanClass.Employee;
import dao.Employee_Dao;
import dao.Employee_dao_impl;
import exception.employeeException;

public class loginEmployeeUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Enter Employee UserName:");
		String username=sc.nextLine();
		System.out.println("Enter Employee Password:");
		String password=sc.nextLine();
		
		Employee_Dao dao=new Employee_dao_impl();
		try {
			
			Employee emp=dao.employeeLogin(username, password);
			System.out.println("Welcome "+emp.getEmpName());
			int id=emp.getEmpId();
			Employee_options.Select(id);
			
		} catch (employeeException e) {

			System.out.println(e.getMessage());
		}
	}
}
