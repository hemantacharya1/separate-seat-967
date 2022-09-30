package HOD_usecases;

import java.util.ArrayList;
import java.util.List;

import beanClass.Problem;
import dao.HOD_Dao;
import dao.HOD_Dao_implements;
import exception.problemException;

public class getAllProblemsUseCase {

	public static void main(String[] args) {
		
		List<Problem> problems=new ArrayList<>();
		
		HOD_Dao dao=new HOD_Dao_implements();
		
		try {
			problems=dao.getAllProblems();
			problems.forEach(i->System.out.println(i));
			
		} catch (problemException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
