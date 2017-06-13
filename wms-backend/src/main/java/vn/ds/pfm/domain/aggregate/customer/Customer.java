package vn.ds.pfm.domain.aggregate.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vn.ds.pfm.domain.aggregate.base.BaseEntity;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity<Long> {
	private static final long serialVersionUID = 1426336119726891876L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cus_id")
	private Long id;

	@Column(name = "cus_name")
	private String cusName;

	private Customer() {
	}

	public Customer(String name) {
		this();
		cusName = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
}