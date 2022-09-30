package Engineer_usecases;

import java.util.ArrayList;
import java.util.List;

import beanClass.Problem;
import dao.Engineer_Dao;
import dao.Engineer_dao_impl;
import exception.engineerException;

public class assignProblemUseCase {

	public static void main(String[] args) {
		
		List<Problem> problems=new ArrayList<>();
		
		Engineer_Dao dao=new Engineer_dao_impl();
		
		try {
			problems=dao.viewAssignedProblem(10);
			problems.forEach(i-> System.out.println(i));
		} catch (engineerException e) {
			// TODO Auto-generated catch block
				System.out.println(e.getMessage());
		}
	}
}
