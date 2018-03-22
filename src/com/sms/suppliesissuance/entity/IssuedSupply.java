package com.sms.suppliesissuance.entity;

import java.util.Date;

public class IssuedSupply {
	private Integer issueId;
	private Integer supplyId;
	private Date issueDate;
	private String requestor;
	private Integer quantity;
	private String deptId;
	private String lastUser;
	private Date lastUpdate;
	
	
	public IssuedSupply(Integer issueId, Integer supplyId, Date issueDate, String requestor, Integer quantity,
			String deptId, String lastUser, Date lastUpdate) {
		super();
		this.issueId = issueId;
		this.supplyId = supplyId;
		this.issueDate = issueDate;
		this.requestor = requestor;
		this.quantity = quantity;
		this.deptId = deptId;
		this.lastUser = lastUser;
		this.lastUpdate = lastUpdate;
	}

	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public Integer getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(Integer supplyId) {
		this.supplyId = supplyId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getLastUser() {
		return lastUser;
	}
	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "IssuedSupply [issueId=" + issueId + ", supplyId=" + supplyId + ", issueDate=" + issueDate
				+ ", requestor=" + requestor + ", quantity=" + quantity + ", deptId=" + deptId + ", lastUser="
				+ lastUser + ", lastUpdate=" + lastUpdate + "]";
	}
	
	
}
