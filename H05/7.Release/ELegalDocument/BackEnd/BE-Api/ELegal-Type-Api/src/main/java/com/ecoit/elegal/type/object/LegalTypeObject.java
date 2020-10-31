package com.ecoit.elegal.type.object;

public class LegalTypeObject {
	private long typeId;
	private String name;
	private String description;
	private boolean statusType;
	private int position;
	private long parentId;
	
	public LegalTypeObject() {
	}
	
	public long getTypeId() {
		return typeId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isStatusType() {
		return statusType;
	}
	
	public int getPosition() {
		return position;
	}
	
	public long getParentId() {
		return parentId;
	}
	
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStatusType(boolean statusType) {
		this.statusType = statusType;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

}
