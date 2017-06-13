package vn.ds.pfm.domain.aggregate.base;

import java.io.Serializable;

public interface Entity<ID> extends Serializable {
	public ID getId();
}
