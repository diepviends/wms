package vn.ds.news.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class PackingInstancePathId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String serialNoParent;
	private String serialNoChild;

	protected PackingInstancePathId() {
        super();
    }

	public PackingInstancePathId(String p, String c) {
        super();
        this.serialNoParent  = p;
        this.serialNoChild = c;
    }

	@Column(name = "product_no_parent", nullable = false, length = 50)
	@NotNull
	@Size(max = 50)
	public String getSerialNoParent() {
		return serialNoParent;
	}

	public void setSerialNoParent(String serialNoParent) {
		this.serialNoParent = serialNoParent;
	}

	@Column(name = "product_no_child", nullable = false, length = 50)
	@NotNull
	@Size(max = 50)
	public String getSerialNoChild() {
		return serialNoChild;
	}

	public void setSerialNoChild(String serialNoChild) {
		this.serialNoChild = serialNoChild;
	}
}