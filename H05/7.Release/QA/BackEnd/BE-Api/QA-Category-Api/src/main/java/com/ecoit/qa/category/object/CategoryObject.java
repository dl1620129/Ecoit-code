package com.ecoit.qa.category.object;

public class CategoryObject {
	private long categoryId;
	private String name;
	private String description;
	private int position;
	private long parentId;
	
	public CategoryObject() {
		
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getPosition() {
		return position;
	}
	
	public long getParentId() {
		return parentId;
	}
	
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
}
