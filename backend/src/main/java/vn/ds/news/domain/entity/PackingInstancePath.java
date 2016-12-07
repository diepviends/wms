package vn.ds.news.domain.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(name = "packing_instance_path", schema = "public")
public class PackingInstancePath extends AbstractUnidentifiedEntity<PackingInstancePathId>
		implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/* Primary Key */
	private PackingInstancePathId id;

	public PackingInstancePath() {
		super();
	}

	public PackingInstancePath(PackingInstancePathId id) {
		this();
		this.id = id;
	}

	@MapsId("id")
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "product_no", referencedColumnName = "product_no"),
			@JoinColumn(name = "customer_code", referencedColumnName = "customer_code"),
			@JoinColumn(name = "serial_no", referencedColumnName = "serial_no"),
			@JoinColumn(name = "status", referencedColumnName = "status") })
	private PackingInstance packingInstance;

	@Override
	@EmbeddedId
	public PackingInstancePathId getId() {
		return id;
	}

	protected void setId(PackingInstancePathId id) {
		this.id = id;
	}

}
