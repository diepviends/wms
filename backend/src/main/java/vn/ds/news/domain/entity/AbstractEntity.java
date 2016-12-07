package vn.ds.news.domain.entity;

import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author Thinh Tran
 */
@MappedSuperclass
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractEntity extends AbstractAuditableEntity implements Entity<UUID> {

    private static final long serialVersionUID = 1L;

    private UUID nid;

    protected AbstractEntity() {
        super();
    }

    protected AbstractEntity(UUID id) {
        this.nid = id;
    }

    @Override
    public UUID getId() {
        return this.nid;
    }

    protected void setId(UUID id) {
        this.nid = id;
    }

    @Override
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Type(type = "pg-uuid")
    @Column(name = "nid", unique = true, nullable = false)
    @NotNull
    public UUID getNid() {
        return this.nid;
    }

    @Override
    public void setNid(UUID nid) {
        this.nid = nid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getId() == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }
        AbstractEntity that = (AbstractEntity) obj;
        return this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return nid == null ? 0 : nid.hashCode();
    }

}