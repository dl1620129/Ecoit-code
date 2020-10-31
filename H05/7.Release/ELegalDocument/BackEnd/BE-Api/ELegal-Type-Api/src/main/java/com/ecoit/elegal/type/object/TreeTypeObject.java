package com.ecoit.elegal.type.object;

import java.util.List;


public class TreeTypeObject {
    private long typeId;
    private String name;
    private String description;
    private boolean statusType;
    private long parentId;
    private int position;
    private List<TreeTypeObject> child;
    
    public TreeTypeObject() {
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
    
    public long getParentId() {
		return parentId;
	}
    
    public int getPosition() {
		return position;
	}
    
    public List<TreeTypeObject> getChild() {
		return child;
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
    
    public void setParentId(long parentId) {
		this.parentId = parentId;
	}
    
    public void setPosition(int position) {
		this.position = position;
	}
    
    public void setChild(List<TreeTypeObject> child) {
		this.child = child;
	}
}
