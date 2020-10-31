package com.ecoit.lichcongtac.object;

public class PermissionObject {
	private String groupName;
	private String description;
	private String[] users;
	private String[] permissions;
	private String[] columns;
	
	public PermissionObject() {
	}
	
	public String getGroupName() {
		return groupName;
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
	
	public String[] getColumns() {
		return columns;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
	
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
}
