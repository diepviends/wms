package vn.ds.pfm.domain.aggregate.inventory;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vn.ds.pfm.domain.aggregate.base.BaseEntity;
import vn.ds.pfm.domain.aggregate.product.ProductId;

@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity<Long> {
	private static final long serialVersionUID = -280954450310099951L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inv_id")
	private Long id;

	@Embedded
	private ProductId product;

	@Column(name = "quantity")
	private Integer quantity;

	private Inventory() {
		super();
	}

	public Inventory(ProductId product, Integer quantity) {
		this();
		this.product = product;
		this.quantity = quantity;
	}

	public void increaseQuantity(Integer amount) {
		quantity = quantity + amount;
	}

	public void decreaseQuantity(Integer amount) {
		quantity = quantity - amount;
	}

	public Long getId() {
		return id;
	}

	public ProductId getProduct() {
		return product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setProduct(ProductId product) {
		this.product = product;
	}

	protected void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}