package vn.ds.news.domain.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(name = "packing_instance", schema = "public")
public class PackingInstance extends AbstractUnidentifiedEntity<PackingInstanceId> implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/* Primary Key */
	private PackingInstanceId id;

	/* Attributes */
	private String subInvCode;
	private Double quantity;

	/* Composition */
	private List<PackingInstancePath> children;

	/* Constructors */

	public PackingInstance() {
		super();
	}

	public PackingInstance(PackingInstanceId id) {
		this();
		this.id = id;
	}

	public PackingInstance(PackingInstanceId id, String subInvCode, Double quantity) {
		this(id);
		this.subInvCode = subInvCode;
		this.quantity = quantity;
	}

	@Override
	@EmbeddedId
	public PackingInstanceId getId() {
		return id;
	}

	protected void setId(PackingInstanceId id) {
		this.id = id;
	}

	@Column(name = "sub_inv_code", nullable = false, length = 50)
	@NotNull
	@Size(max = 50)
	public String getSubInvCode() {
		return subInvCode;
	}

	protected void setSubInvCode(String subInvCode) {
		this.subInvCode = subInvCode;
	}

	@Column(name = "qty", nullable = false, precision = 64)
	public Double getQty() {
		return quantity;
	}

	protected void setQty(Double qty) {
		this.quantity = qty;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumns({ @JoinColumn(name = "product_no", referencedColumnName = "product_no"),
	//		@JoinColumn(name = "customer_code", referencedColumnName = "customer_code"),
	//		@JoinColumn(name = "serial_no", referencedColumnName = "serial_no"),
	//		@JoinColumn(name = "status", referencedColumnName = "status") })
	@Fetch(FetchMode.SUBSELECT)
	public List<PackingInstancePath> getChildren() {
		return children;
	}

	protected void setChildren(List<PackingInstancePath> children) {
		this.children = children;
	}

	public void pack(String serialNoChild, String productNo, String subInvCode, Double qty) {
		// TODO
	}

	public void unpack(String serialNoChild) {
		// TODO
	}

	public boolean isPacked() {
		return this.id.getStatus() == "0";
	}

	public boolean isReceived() {
		return this.id.getStatus() == "1";
	}

}
