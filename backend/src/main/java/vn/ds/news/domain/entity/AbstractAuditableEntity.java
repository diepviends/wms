package vn.ds.news.domain.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Thinh Tran
 */
@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractAuditableEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long createdBy;
	private Long updatedBy;
	private DateTime createdDate;
	private DateTime updatedDate;

	@CreatedBy
	@Column(name = "created_by", nullable = false, precision = 64)
	@NotNull
	public Long getCreatedBy() {
		return createdBy;
	}

	public AbstractAuditableEntity setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	@LastModifiedBy
	@Column(name = "updated_by", precision = 64)
	@NotNull
	public Long getUpdatedBy() {
		return updatedBy;
	}

	public AbstractAuditableEntity setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}

	@CreatedDate
	@Convert(converter = DateJodaConverter.class)
	@Column(name = "created_date", nullable = false)
	@NotNull
	public DateTime getCreatedDate() {
		return createdDate;
	}

	public AbstractAuditableEntity setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	@Version
	@LastModifiedDate
	@Convert(converter = DateJodaConverter.class)
	@Column(name = "updated_date")
	@NotNull
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	public AbstractAuditableEntity setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

}