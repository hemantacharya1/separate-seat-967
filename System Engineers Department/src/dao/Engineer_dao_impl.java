package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beanClass.Engineer;
import beanClass.Problem;
import exception.engineerException;
import system.engineers.utility.DButil;

public class Engineer_dao_impl implements Engineer_Dao {

	@Override
	public Engineer loginToSystem(String username, String password) throws engineerException {
		
		Engineer engineer=null;
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("select * from engineer where email=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				int id=rs.getInt("engId");
				String n=rs.getString("name");
				String d=rs.getString("department");
				String e=rs.getString("email");
				String p=rs.getString("password");  
				
				engineer=new Engineer(id, n, d, e, p);
			}
			else {
				throw new engineerException("Invalid Username or Password");
			}
		
		} catch (SQLException e) {
				
			throw new engineerException(e.getMessage());   
		}
		
		return engineer;
		
	}

	@Override
	public List<Problem> viewAssignedProblem(int id) throws engineerException {
		
		List<Problem> problems=new ArrayList<>();
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement(" select ep.problemId, p.type, p.description, p.status from "
					+ "engineer_problem ep Inner join problem p where ep.engId=?");
			ps.setInt(1, id);
		
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int problemId=rs.getInt("problemId");
				String type=rs.getString("type");
				String description=rs.getString("description");
				String status=rs.getString("status");
				
				Problem p= new Problem();
				p.setProblemId(problemId);
				p.setType(type);
				p.setDescription(description);
				p.setStatus(status);
				
				problems.add(p);
			}
			
		} catch (Exception e) {
				throw new engineerException(e.getMessage());
		}
		
		if(problems.size()==0) {
			throw new engineerException("No Task is Assigned to You..");
		}
		return problems;
	}

	@Override
	public String updateProblem(String update, int engId, int problemId) throws engineerException {
		
		String result="Not Resolved";
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("update problem inner join engineer_problem set problem.status=?"
					+ " where engId=? and problem.problemId=?");
			
			ps.setString(1, update);
			ps.setInt(2, engId);
			ps.setInt(3, problemId);
			
			int x=ps.executeUpdate();
			
			if(x>0)
				result="Problem Updated..!";
			
		} catch (SQLException e) {
			
			throw new engineerException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public List<Problem> viewAttendProblem(int id) throws engineerException {
		List<Problem> problems=new ArrayList<>();
		
		try(Connection con=DButil.provideConnection()) {
			
		PreparedStatement ps=con.prepareStatement("select p.problemId,p.type,p.description,p.status,p.date from problem p inner join"
					+ " engineer_problem ep where engId=? and p.problemid=ep.problemId;");
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int probId=rs.getInt("problemId");
				String type=rs.getString("type");
				String desc= rs.getString("description");
				String status=rs.getString("status");
				
				Problem p=new Problem();
				p.setProblemId(probId);
				p.setType(type);
				p.setDescription(desc);
				p.setStatus(status);
				
				problems.add(p);
			}
			
			if(problems.size()==0) {
				throw new engineerException("No Problem Found..!");
			}
		
		} catch (SQLException e) {

			throw new engineerException(e.getMessage());
		}
		
		return problems;
		
	}

	@Override
	public String updatePassword(int id,int password) throws engineerException {

		String result="Not Updated..";
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("update engineer set password=? where engid=?");
			ps.setInt(1, password);
			ps.setInt(2, id);
			
			int x=ps.executeUpdate();
			
			if(x>0)
				result="Password Updated Successfully..!!";
			
		} catch (SQLException e) {
			
			throw new engineerException(e.getMessage());
		}
		
		return result;
	}

}





