package vn.ds.news.domain.entity;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Thinh Tran
 */
public interface Entity<ID> extends Serializable {

	ID getId();

    UUID getNid();

    void setNid(UUID nid);
}
