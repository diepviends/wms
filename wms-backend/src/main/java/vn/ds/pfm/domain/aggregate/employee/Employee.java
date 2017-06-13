package vn.ds.pfm.domain.aggregate.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vn.ds.pfm.domain.aggregate.base.BaseEntity;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity<Long> {
	private static final long serialVersionUID = -6044992089552105160L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "password")
	private String password;

	private Employee() {
	}

	public Employee(String name, String pass) {
		this();
		empName = name;
		password = pass;
	}

	public Long getId() {
		return id;
	}

	public String getEmpName() {
		return empName;
	}

	public String getPassword() {
		return password;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setEmpName(String empName) {
		this.empName = empName;
	}

	protected void setPassword(String password) {
		this.password = password;
	}
}
