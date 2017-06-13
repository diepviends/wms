package vn.ds.pfm.domain.aggregate.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<ID> implements Entity<ID> {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "created_time", updatable = false)
	@JsonIgnore
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "last_modified_time")
	private Date lastModifiedTime;

	@CreatedBy
	@Column(name = "created_by")
	private Long createdBy;

	@LastModifiedBy
	@Column(name = "last_modified_by")
	private Long lastModifiedBy;

	@Version
	@Column(name = "version")
	private Long version;

	public Date getCreatedTime() {
		return createdTime;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public Long getVersion() {
		return version;
	}

	protected void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	protected void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	protected void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	protected void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	protected void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.getId() == null ? 0 : this.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getId() == null || obj == null || !this.getClass().equals(obj.getClass()))
			return false;
		if (this == obj)
			return true;
		BaseEntity<?> other = (BaseEntity<?>) obj;
		return this.getId().equals(other.getId());
	}
}
