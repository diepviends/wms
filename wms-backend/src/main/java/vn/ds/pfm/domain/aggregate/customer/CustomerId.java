package vn.ds.pfm.domain.aggregate.customer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class CustomerId implements Serializable {
	private static final long serialVersionUID = -1702228779386776650L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cus_id")
	private Long cusId;

	public Long getCusId() {
		return cusId;
	}

	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cusId == null) ? 0 : cusId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (cusId == null || obj == null || getClass() != obj.getClass())
			return false;

		CustomerId other = (CustomerId) obj;
		return cusId.equals(other.cusId);
	}
}
