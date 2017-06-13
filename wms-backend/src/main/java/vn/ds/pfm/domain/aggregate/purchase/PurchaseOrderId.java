package vn.ds.pfm.domain.aggregate.purchase;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PurchaseOrderId implements Serializable {
	private static final long serialVersionUID = 7777413257132303063L;

	@Column(name = "po_number")
	private String poNumber;

	public String getPoNumber() {
		return poNumber;
	}

	protected void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((poNumber == null) ? 0 : poNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (poNumber == null || obj == null || getClass() != obj.getClass())
			return false;

		PurchaseOrderId other = (PurchaseOrderId) obj;
		return poNumber.equals(other.poNumber);
	}

}
