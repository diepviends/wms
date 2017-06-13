package vn.ds.pfm.domain.aggregate.supplier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class SupplierId implements Serializable {
	private static final long serialVersionUID = 2445975729781935437L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sup_id")
	private Long supId;

	private SupplierId() {
		super();
	}

	public SupplierId(Long id) {
		this();
		supId = id;
	}

	public Long getSupId() {
		return supId;
	}

	protected void setSupId(Long supId) {
		this.supId = supId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supId == null) ? 0 : supId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (supId == null || obj == null || getClass() != obj.getClass())
			return false;

		SupplierId other = (SupplierId) obj;
		return supId.equals(other.supId);
	}

}
