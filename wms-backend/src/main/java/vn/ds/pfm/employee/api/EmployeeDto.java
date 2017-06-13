package vn.ds.pfm.employee.api;

public class EmployeeDto {
	private String username;
	private String password;

	public EmployeeDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public EmployeeDto() {
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
