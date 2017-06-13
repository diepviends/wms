package vn.ds.pfm.domain.aggregate.supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vn.ds.pfm.domain.aggregate.base.BaseEntity;

@Entity
@Table(name = "supplier")
public class Supplier extends BaseEntity<Long> {
	private static final long serialVersionUID = -6044992089552105160L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sup_id")
	private Long id;

	@Column(name = "sup_name")
	private String supName;

	@Column(name = "address")
	private String address;

	private Supplier() {
	}

	public Supplier(String name, String address) {
		this();
		this.supName = name;
		this.address = address;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setSupName(String supName) {
		this.supName = supName;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public String getSupName() {
		return supName;
	}

	public String getAddress() {
		return address;
	}
}
