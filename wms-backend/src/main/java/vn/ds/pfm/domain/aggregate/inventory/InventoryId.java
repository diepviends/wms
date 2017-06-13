package vn.ds.pfm.domain.aggregate.inventory;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class InventoryId implements Serializable {
	private static final long serialVersionUID = 7777413257132303063L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inv_id")
	private Long invId;

	public InventoryId() {
		super();
	}

	public InventoryId(Long invId) {
		this();
		this.invId = invId;
	}

	public Long getInvId() {
		return invId;
	}

	protected void setInvId(Long invId) {
		this.invId = invId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invId == null) ? 0 : invId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (invId == null || obj == null || getClass() != obj.getClass())
			return false;

		InventoryId other = (InventoryId) obj;
		return invId.equals(other.invId);
	}

}
