package beanClass;

public class Employee {

	private int empId;
	private String empName;
	private String username;
	private String password;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, String username, String password) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.username = username;
		this.password = password;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
}
