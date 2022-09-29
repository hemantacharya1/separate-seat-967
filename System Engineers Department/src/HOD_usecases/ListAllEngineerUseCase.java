package HOD_usecases;

import java.util.ArrayList;
import java.util.List;

import beanClass.Engineer;
import dao.HOD_Dao;
import dao.HOD_Dao_implements;
import exception.engineerException;

public class ListAllEngineerUseCase {

	public static void main(String[] args) {
		List<Engineer> engineers=new ArrayList<>();
		
		HOD_Dao dao=new HOD_Dao_implements();
		
		try {
			engineers=dao.getAllEngineerDetails();
			
			engineers.forEach(i->System.out.println(i));
			
		} catch (engineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
