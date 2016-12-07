package vn.ds.news.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class PackingInstanceId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productNo;
    private String customerCode;
    private String serialNo;
    private String status;

    @Column(name = "product_no", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getProductNo() {
        return this.productNo;
    }

    protected void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    @Column(name = "customer_code", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getCustomerCode() {
        return this.customerCode;
    }

    protected void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Column(name = "serial_no", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getSerialNo() {
        return this.serialNo;
    }

    protected void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Column(name = "status", nullable = false, length = 1)
    @NotNull
    @Size(max = 1)
    public String getStatus() {
        return status;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    protected PackingInstanceId() {
        super();
    }

    public PackingInstanceId(String customerCode, String productNo, String serialNo, String status) {
        super();
        this.customerCode = customerCode;
        this.productNo = productNo;
        this.serialNo = serialNo;
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerCode == null) ? 0 : customerCode.hashCode());
        result = prime * result + ((productNo == null) ? 0 : productNo.hashCode());
        result = prime * result + ((serialNo == null) ? 0 : serialNo.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.productNo == null || this.customerCode == null || this.serialNo == null || this.status == null
                || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }
        PackingInstanceId that = (PackingInstanceId) obj;
        return this.getProductNo().equals(that.getProductNo()) && this.getCustomerCode().equals(that.getCustomerCode())
                && this.getSerialNo().equals(that.getSerialNo()) && this.getStatus().equals(that.getStatus());
    }

}
