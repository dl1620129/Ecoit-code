package com.ecoit.elegal.object;

public class LegalFieldObject {
	private long fieldId;
	private String name;
	private String description;
	private boolean statusField;
	private int position;
	
	public LegalFieldObject() {
	}
	
	public long getFieldId() {
		return fieldId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isStatusField() {
		return statusField;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStatusField(boolean statusField) {
		this.statusField = statusField;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}

}
