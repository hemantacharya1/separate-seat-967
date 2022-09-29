package beanClass;

public class Engineer {

	private int engId;
	private String name;
	private String department;
	private String email;
	private String password;
	
	public Engineer() {
		// TODO Auto-generated constructor stub
	}
	
	public Engineer(int engId, String name, String department, String email, String password) {
		super();
		this.engId = engId;
		this.name = name;
		this.department = department;
		this.email = email;
		this.password = password;
	}

	public int getEngId() {
		return engId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Engineer [engId=" + engId + ", name=" + name + ", department=" + department + ", email=" + email
				+ ", password=" + password + "]";
	}

	
}
