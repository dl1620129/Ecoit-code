package com.ecoit.mr.object;

public class UnitObject {
    private long unitId;
    private String name;
    private String description;
    
    public UnitObject() {
		
	}
    
    public String getDescription() {
		return description;
	}
    
    public String getName() {
		return name;
	}
    
    public long getUnitId() {
		return unitId;
	}
    
    public void setUnitId(long unitId) {
		this.unitId = unitId;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public void setDescription(String description) {
		this.description = description;
	}
}
