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
	private String ItemName;
	private Integer currQuantity;
	private Integer currSupplyId;
	private String deptName;
	private String lastUserName;

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
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLastUserName() {
		return lastUserName;
	}
	public void setLastUserName(String lastUserName) {
		this.lastUserName = lastUserName;
	}
	public Integer getCurrQuantity() {
		return currQuantity;
	}
	public void setCurrQuantity(Integer currQuantity) {
		this.currQuantity = currQuantity;
	}
	public Integer getCurrSupplyId() {
		return currSupplyId;
	}
	public void setCurrSupplyId(Integer currSupplyId) {
		this.currSupplyId = currSupplyId;
	}
	@Override
	public String toString() {
		return "IssuedSupply [issueId=" + issueId + ", supplyId=" + supplyId + ", issueDate=" + issueDate
				+ ", requestor=" + requestor + ", quantity=" + quantity + ", deptId=" + deptId + ", lastUser="
				+ lastUser + ", lastUpdate=" + lastUpdate + ", ItemName=" + ItemName + ", currQuantity=" + currQuantity
				+ ", currSupplyId=" + currSupplyId + ", deptName=" + deptName + ", lastUserName=" + lastUserName + "]";
	}
	
}
