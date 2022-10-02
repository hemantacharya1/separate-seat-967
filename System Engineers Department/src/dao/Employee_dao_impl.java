package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PrinterStateReason;

import beanClass.Employee;
import beanClass.Problem;
import exception.employeeException;
import exception.engineerException;
import system.engineers.utility.DButil;

public class Employee_dao_impl implements Employee_Dao{

	@Override
	public String registerEmployee(Employee emp) throws employeeException {
		
		String result="Not Registerd";
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("insert into employee(empName,username,password)"
					+ " values(?,?,?)");

			ps.setString(1,emp.getEmpName());
			ps.setString(2, emp.getUsername());
			ps.setString(3, emp.getPassword());
			
			int x=ps.executeUpdate();
			
			if(x>0)
				result="Employee "+emp.getEmpName()+" Registered";
			
		} catch (SQLException e) {

			throw new employeeException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public Employee employeeLogin(String username, String password) throws employeeException {
		
		Employee employee=null;
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("select * from employee where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				int id=rs.getInt("empId");
				String name=rs.getString("empName");
				String uname=rs.getString("username");
				String upass=rs.getString("password");	
				
				employee=new Employee(id, name, uname, upass);
				
			}
			else {
				throw new employeeException("Invalid Username or Password...");
			}
			
		} catch (SQLException e) {
			
			throw new employeeException(e.getMessage());
		}
		
		return employee;
	}

	@Override
	public String registerComplain(Problem problem, int id) throws employeeException {
		String result= null;
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("insert into problem (type,description,date) values(?,?,?)");
			
			ps.setString(1, problem.getType());
			ps.setString(2, problem.getDescription());
			ps.setString(3, problem.getDate());
			
			int x=ps.executeUpdate();
			
			PreparedStatement ps2=con.prepareStatement("select max(problemId) from problem");
			ResultSet rs=ps2.executeQuery();
			
			int probId=0;
			
			if(rs.next()) {
				probId=rs.getInt("max(problemId)");
			}
			
			PreparedStatement ps3=con.prepareStatement("insert into problem_history values(?,?)");
			
			ps3.setInt(1, id);
			ps3.setInt(2, probId);
			
			ps3.executeUpdate();
			
			if(x>0)
				result="Problem Registerd with ProblemId: "+probId;
			
		} catch (SQLException e) {

			throw new employeeException(e.getMessage());
			
		}
		
		return result;
		
	}

	@Override
	public String viewStatus(int id) throws employeeException {

		String result="Not Assigned";
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("select * from problem where problemid=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			String type=null;
			String status=null;
			
			if(rs.next()) {
				type=rs.getString("type");
				status=rs.getString("status");
			}
			
			PreparedStatement ps2=con.prepareStatement("select e.name from engineer e inner join engineer_problem ep where ep.problemId=?");
			
			ps2.setInt(1, id);
			ResultSet rs2=ps2.executeQuery();
			
			if(rs2.next()) {
				String name=rs2.getString("name");
				
				result="The Problem id: "+id+", type "+type.toUpperCase()+" is "+status.toUpperCase()+" and Assigned to "+name.toUpperCase();
			}
			
		} catch (Exception e) {
			
			throw new employeeException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public List<Problem> checkHistory(int id) throws employeeException {
		List<Problem> problems=new ArrayList<>();
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("select * from problem_history where empId=?");
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int x=rs.getInt("problemId");
				String t=rs.getString("type");
				String d=rs.getString("description");
				String s=rs.getString("status");
				String date=rs.getString("date");
				
				Problem p=new Problem(id, t, d, s, date);
				
				problems.add(p);
			}
			
			if(problems.size()==0)
				throw new employeeException("No Problems Found...");
			
		} catch (Exception e) {
				throw new employeeException(e.getMessage());
		}
		
		return problems;
	}

	@Override
	public String updatePassword(String username, String password) throws employeeException {

		String result=null;
		
		try(Connection con=DButil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("update employee set password=? where username=?");
			ps.setString(1, password);
			ps.setString(2, username);
			
			int x=ps.executeUpdate();
			
			if(x>0)
				result="Password Updated Successfully..!!";
			
		} catch (SQLException e) {
			
			throw new employeeException(e.getMessage()); 
		}
				
		return result;
	}

}



