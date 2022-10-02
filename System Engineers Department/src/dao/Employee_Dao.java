package dao;

import java.util.List;

import beanClass.Employee;
import beanClass.Problem;
import exception.employeeException;

public interface Employee_Dao {

	public String registerEmployee(Employee emp) throws employeeException;
	
	public Employee employeeLogin(String username, String password) throws employeeException;
	
	public String registerComplain(Problem problem, int id) throws employeeException;
	
	public String viewStatus(int id)throws employeeException;
	
	public List<Problem> checkHistory(int id) throws employeeException;
	
	public String updatePassword(String Username ,String password) throws employeeException;
	
	
}
