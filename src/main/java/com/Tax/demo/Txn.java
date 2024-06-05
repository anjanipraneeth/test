package com.Tax.demo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "txn")
public class Txn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "txnId", nullable = false)
    private String txnId;

    @Column(name = "customerName", nullable = false)
    private String customerName;

    @Column(name = "service", nullable = false)
    private String service;

    @Column(name = "amount", nullable = false)
    private float amount;

    @Column(name = "gst", nullable = false)
    private float gst;

    @Column(name = "commission", nullable = false)
    private float commission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getGst() {
		return gst;
	}

	public void setGst(float gst) {
		this.gst = gst;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

	public Txn() {
		super();
	}

	public Txn(Long id, String txnId, String customerName, String service, float amount, float gst, float commission) {
		super();
		this.id = id;
		this.txnId = txnId;
		this.customerName = customerName;
		this.service = service;
		this.amount = amount;
		this.gst = gst;
		this.commission = commission;
	}
    



	
    
}
