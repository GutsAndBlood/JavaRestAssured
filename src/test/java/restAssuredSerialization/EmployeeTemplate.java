package restAssuredSerialization;

public class EmployeeTemplate {
	
	private int id;
	private String name;
	private String DepartmentID;
	private String DepartmentIDNum;
	private String RegistrationDate;

	public EmployeeTemplate(int id, String name, String departmentID, String DepartmentIDNum, String registrationDate) {
		super();
		this.id = id;
		this.name = name;
		this.DepartmentID = departmentID;
		this.DepartmentIDNum = DepartmentIDNum;
		this.RegistrationDate = registrationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentId() {
		return DepartmentID;
	}

	public void setDepartmentId(String departmentID) {
		this.DepartmentID = departmentID;
	}

	public String getRegistrationDate() {
		return RegistrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.RegistrationDate = registrationDate;
	}

	public String getDepartmentIDNum() {
		return DepartmentIDNum;
	}

	public void setDepartmentIDNum(String departmentIDNum) {
		DepartmentIDNum = departmentIDNum;
	}
	
	

}
