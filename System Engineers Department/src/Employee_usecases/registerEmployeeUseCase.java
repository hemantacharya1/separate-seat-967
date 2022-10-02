package Employee_usecases;

import java.util.Scanner;

import beanClass.Employee;
import dao.Employee_Dao;
import dao.Employee_dao_impl;
import exception.employeeException;

public class registerEmployeeUseCase {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Employee Name:");
		String name=sc.nextLine();
		System.out.println("Enter Username(email):");
		String username=sc.nextLine();
		System.out.println("Enter Password:");
		String password=sc.nextLine();
		
		Employee employee=new Employee();
		employee.setEmpName(name);
		employee.setUsername(username);
		employee.setPassword(password);
		
		Employee_Dao dao=new Employee_dao_impl();
		try {
			String result=dao.registerEmployee(employee);
			System.out.println(result);
		} catch (employeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
