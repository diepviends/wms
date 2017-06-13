package vn.ds.pfm.domain.aggregate.employee;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class EmployeeId implements Serializable {
	private static final long serialVersionUID = 2445975729781935437L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long empId;

	public Long getEmpId() {
		return empId;
	}

	protected void setEmpId(Long empId) {
		this.empId = empId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (empId == null || obj == null || getClass() != obj.getClass())
			return false;

		EmployeeId other = (EmployeeId) obj;
		return empId.equals(other.empId);
	}

}
