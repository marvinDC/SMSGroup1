package com.sms.suppliesmaintenance.entity;

import java.util.Date;

public class Supplies {
	private Integer 		supplyId;
	private Integer			supplyTypeId;	
	private String			supplyType;
	private String			itemName;
	private String			itemUnit;
	private String			obsoleteTag;
	private String			location;
	private Integer			reorderLevel;
	private Integer			actualCount;
	private String			remarks;
	private Date			dateAdded;
	private String			lastUser;
	private Date			lastUpdate;
	
	public Integer getSupplyId() { 
		return supplyId;
	}
	public void setSupplyId(Integer supplyId) {
		this.supplyId = supplyId;
	}
	public Integer getSupplyTypeId() {
		return supplyTypeId;
	}
	public void setSupplyTypeId(Integer supplyTypeId) {
		this.supplyTypeId = supplyTypeId;
	}
	public String getSupplyType() {
		return supplyType;
	}
	public void setSupplyType(String supplyType) {
		this.supplyType = supplyType;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemUnit() {
		return itemUnit;
	}
	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}
	public String getObsoleteTag() {
		return obsoleteTag;
	}
	public void setObsoleteTag(String obsoleteTag) {
		this.obsoleteTag = obsoleteTag;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public Integer getActualCount() {
		return actualCount;
	}
	public void setActualCount(Integer actualCount) {
		this.actualCount = actualCount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
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
		return "Supplies [supplyId=" + supplyId + ", supplyTypeId=" + supplyTypeId + ", supplyType=" + supplyType
				+ ", itemName=" + itemName + ", itemUnit=" + itemUnit + ", obsoleteTag=" + obsoleteTag + ", location="
				+ location + ", reorderLevel=" + reorderLevel + ", actualCount=" + actualCount + ", remarks=" + remarks
				+ ", dateAdded=" + dateAdded + ", lastUser=" + lastUser + ", lastUpdate=" + lastUpdate + "]";
	}
	
	

}
