package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import beanClass.Engineer;
import beanClass.Problem;
import exception.engineerException;
import exception.problemException;
import system.engineers.utility.DButil;

public class HOD_Dao_implements implements HOD_Dao{
	
	@Override
	public String registerEngineer2(String name, String department, String email, String password) {
			
		String result="Not Inserted...!";
			
			try(Connection con=DButil.provideConnection()) {
				
				PreparedStatement ps=con.prepareStatement
											("insert into engineer(name,department,email,password) values(?,?,?,?)");
				
				ps.setString(1, name);
				ps.setString(2,	department);
				ps.setString(3, email);
				ps.setString(4, password);
				
				int x= ps.executeUpdate();
				
				if(x>0)
					result="Engineer "+name+" added sucessfully!";
				
				
			} catch (SQLException se) {
					result =se.getMessage();
			}
			
			return result;
	}

	@Override
	public String registerEngineer(Engineer engineer) {
		// TODO Auto-generated method stub
		
		String result="Not Inserted...!";
			
			try(Connection con=DButil.provideConnection()) {
				
				PreparedStatement ps=con.prepareStatement
											("insert into engineer(name,department,email,password) values(?,?,?,?)");
				
				ps.setString(1, engineer.getName());
				ps.setString(2,	engineer.getDepartment());
				ps.setString(3, engineer.getEmail());
				ps.setString(4, engineer.getPassword());
				
				int x= ps.executeUpdate();
				
				if(x>0)
					result="Engineer "+engineer.getName()+" added sucessfully!";
				
				
			} catch (SQLException se) {
					result =se.getMessage();
			}
			
			return result;
	}

	@Override
	public List<Engineer> getAllEngineerDetails() throws engineerException {
		// TODO Auto-generated method stub
		List<Engineer> engineers = new ArrayList<>();
		
		try(Connection con = DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("select * from engineer");
			
			ResultSet rs =	ps.executeQuery();
			
			while(rs.next()) {
				int id= rs.getInt("engId");
				String name= rs.getString("name");
				String department=rs.getString("department");
				String email=rs.getString("email");
				String pass=rs.getString("password");
				
				Engineer en=new Engineer(id, name, department, email, pass);
				
				engineers.add(en);
			}
		} catch (SQLException se) {
				throw new engineerException(se.getMessage());
		}
		
		if(engineers.size() == 0) {
			throw new engineerException("No Engineer Found....!");
		}
		
		return engineers;
	}

	@Override
	public String deleteEngineerById(int id) throws engineerException {
		String result = "Not Deleted";
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("delete from engineer where engid = ?");
			ps.setInt(1, id);
			
			int x=ps.executeUpdate();
			
			if(x>0)
				result="Engineer id "+id+" is Deleted:";
			else
				throw new engineerException("Engineer id "+id+" is not found");
			
		} catch (SQLException se) {
			throw new engineerException(se.getMessage());
		}
		
		
		
		return result;
	}

	@Override
	public List<Problem> getAllProblems() throws problemException {
		List<Problem> problems =new ArrayList<>();
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("select * from problem");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("problemId");
				String t=rs.getString("type");
				String d=rs.getString("description");
				String s=rs.getString("status");
				String date=rs.getString("date");
				
				Problem p=new Problem(id, t, d, s, date);
				
				problems.add(p);
			}
			
		} catch (SQLException e) {
			throw new problemException(e.getMessage());
		}
		
		if(problems.size()==0) {
			throw new problemException("No Problem Found...!");
		}
		return problems;
	}

	@Override
	public String assignProblem(int engineerID,int problemId) throws engineerException {
		
		String result="Not Assigned";
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("insert into engineer_problem values(?,?)");
			ps.setInt(1, engineerID);
			ps.setInt(2, problemId);
			
			int x=ps.executeUpdate();
			
			if(x>0)
				result="Problem "+problemId+" is Assigned to Engineer, engId->"+engineerID;
			
		} catch (SQLException e) {
			throw new engineerException(e.getMessage());
		}
		
		return result;
		
		
	}

	
}









