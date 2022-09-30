package dao;

import java.util.List;

import beanClass.Engineer;
import beanClass.Problem;
import exception.engineerException;

public interface Engineer_Dao {

	public Engineer loginToSystem(String username,String password) throws engineerException;
	
	public List<Problem> viewAssignedProblem(int id) throws engineerException;
	
	public String updateProblem(String update,int id) throws engineerException;
	
	
	
}
