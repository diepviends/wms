package vn.ds.pfm.domain.aggregate.purchase;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import vn.ds.pfm.domain.aggregate.base.BaseEntity;
import vn.ds.pfm.domain.aggregate.supplier.SupplierId;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder extends BaseEntity<PurchaseOrderId> {
	private static final long serialVersionUID = -280954450310099951L;

	@EmbeddedId
	private PurchaseOrderId id;

	@Embedded
	private SupplierId supplier;

	@Column(name = "required_date")
	private Date requiredDate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "po_number", referencedColumnName = "po_number", insertable = false, updatable = false)
	@Fetch(FetchMode.SUBSELECT)
	private Set<PurchaseOrderDetail> details;

	private PurchaseOrder() {
		super();
	}

	public PurchaseOrder(PurchaseOrderId id) {
		this();
		this.id = id;
	}

	public PurchaseOrderId getId() {
		return id;
	}

	public SupplierId getSupplier() {
		return supplier;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	protected void setId(PurchaseOrderId id) {
		this.id = id;
	}

	protected void setSupplier(SupplierId supplier) {
		this.supplier = supplier;
	}

	protected void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Set<PurchaseOrderDetail> getDetails() {
		return details;
	}

	protected void setDetails(Set<PurchaseOrderDetail> details) {
		this.details = details;
	}

}