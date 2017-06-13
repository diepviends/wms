package vn.ds.pfm.domain.aggregate.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class ProductId implements Serializable {
	private static final long serialVersionUID = 7777413257132303063L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long proId;

	public Long getProdId() {
		return proId;
	}

	protected void setProdId(Long proId) {
		this.proId = proId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proId == null) ? 0 : proId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (proId == null || obj == null || getClass() != obj.getClass())
			return false;

		ProductId other = (ProductId) obj;
		return proId.equals(other.proId);
	}

}
