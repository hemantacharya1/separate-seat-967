package dao;

import java.util.List;

import beanClass.Engineer;
import beanClass.Problem;
import exception.engineerException;
import exception.problemException;

public interface HOD_Dao {

	public String registerEngineer2(String name, String department , String email, String password);
	
	public String registerEngineer(Engineer engineer);
	
	public List<Engineer> getAllEngineerDetails() throws engineerException;
	
	public String deleteEngineerById(int id) throws engineerException;
	
	public List<Problem> getAllProblems() throws problemException;
	
	public String assignProblem(int engineerId,int problemId) throws engineerException;
	
}
