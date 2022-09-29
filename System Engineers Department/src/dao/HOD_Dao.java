package dao;

import java.util.List;

import beanClass.Engineer;
import exception.engineerException;

public interface HOD_Dao {

	public String registerEngineer2(String name, String department , String email, String password);
	
	public String registerEngineer(Engineer engineer);
	
	public List<Engineer> getAllEngineerDetails() throws engineerException;
	
	public String deleteEngineerById(int id) throws engineerException;
	
}
