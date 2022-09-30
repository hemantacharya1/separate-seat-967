package beanClass;

public class Problem {

	private int problemId;
	private String type;
	private String description;
	private String status;
	private String date;
	
	public Problem() {
		// TODO Auto-generated constructor stub
	}

	public Problem(int problemId, String type, String description, String status, String date) {
		super();
		this.problemId = problemId;
		this.type = type;
		this.description = description;
		this.status = status;
		this.date = date;
	}

	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Problem [problemId=" + problemId + ", type=" + type + ", description=" + description + ", status="
				+ status + ", date=" + date + "]";
	}
	
}
