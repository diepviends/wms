package vn.ds.pfm.domain.aggregate.purchase;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import vn.ds.pfm.domain.aggregate.base.BaseEntity;

@Entity
@Table(name = "purchase_order_detail")
public class PurchaseOrderDetail extends BaseEntity<PurchaseOrderDetailId> {
	private static final long serialVersionUID = -280954450310099951L;

	@EmbeddedId
	private PurchaseOrderDetailId id;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price")
	private Double price;

	public PurchaseOrderDetailId getId() {
		return id;
	}

	public void setId(PurchaseOrderDetailId id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}