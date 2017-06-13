package vn.ds.pfm.domain.aggregate.purchase;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import vn.ds.pfm.domain.aggregate.product.ProductId;

@Embeddable
public class PurchaseOrderDetailId implements Serializable {
	private static final long serialVersionUID = 7777413257132303063L;

	@Embedded
	private PurchaseOrderId poId;

	@Embedded
	private ProductId product;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((poId == null) ? 0 : poId.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (poId == null || product == null || obj == null || getClass() != obj.getClass())
			return false;

		PurchaseOrderDetailId other = (PurchaseOrderDetailId) obj;
		return poId.equals(other.poId) && product.equals(other.product);
	}
}
