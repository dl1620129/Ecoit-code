package com.ecoit.qa.permission.object;

public class PermissionFormObject {
	private String name;
	private String description;
	private String[] users;
	private String[] permissions;
	private String[] categories;
	
	public PermissionFormObject() {
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String[] getUsers() {
		return users;
	}
	
	public String[] getPermissions() {
		return permissions;
	}
	
	public String[] getCategories() {
		return categories;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setUsers(String[] users) {
		this.users = users;
	}
	
	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}
	
	public void setCategories(String[] categories) {
		this.categories = categories;
	}
}
