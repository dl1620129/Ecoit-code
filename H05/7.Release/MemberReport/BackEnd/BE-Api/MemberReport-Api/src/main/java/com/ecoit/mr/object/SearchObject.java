package com.ecoit.mr.object;

import java.util.Date;

public class SearchObject {
	private String modifiedDate;
	private long unitId;
	
	public SearchObject() {
	}
	
	public String getModifiedDate() {
		return modifiedDate;
	}
	
	public long getUnitId() {
		return unitId;
	}
	
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}
}
