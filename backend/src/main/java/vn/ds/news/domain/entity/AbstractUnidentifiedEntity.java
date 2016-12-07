package vn.ds.news.domain.entity;

import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

/**
 * @author Thinh Tran
 */
@MappedSuperclass
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractUnidentifiedEntity<ID> extends AbstractAuditableEntity implements Entity<ID> {

    private static final long serialVersionUID = 1L;

    /* Primary Key */

    /* Attributes */
    private UUID nid;

    /* Constructors */

    /* Getters | Setters */

    @Override
    // @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
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
        AbstractUnidentifiedEntity<?> that = (AbstractUnidentifiedEntity<?>) obj;
        return this.getId().equals(that.getId());
    }

}