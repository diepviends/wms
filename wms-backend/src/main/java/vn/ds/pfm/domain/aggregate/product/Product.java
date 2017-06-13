package vn.ds.pfm.domain.aggregate.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vn.ds.pfm.domain.aggregate.base.BaseEntity;

@Entity
@Table(name = "product")
public class Product extends BaseEntity<Long> {
	private static final long serialVersionUID = -280954450310099951L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long id;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "unit")
	private String unit;

	@Column(name = "price")
	private Double price;

	private Product() {
	}

	public Product(String name) {
		this();
		prodName = name;
	}

	public Product(String name, String unit, Double price) {
		this(name);
		this.unit = unit;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getProdName() {
		return prodName;
	}

	public String getUnit() {
		return unit;
	}

	public Double getPrice() {
		return price;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setProdName(String prodName) {
		this.prodName = prodName;
	}

	protected void setUnit(String unit) {
		this.unit = unit;
	}

	protected void setPrice(Double price) {
		this.price = price;
	}
}