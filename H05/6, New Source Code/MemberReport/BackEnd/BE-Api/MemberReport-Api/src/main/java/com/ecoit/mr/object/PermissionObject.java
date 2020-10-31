package com.ecoit.mr.object;

public class PermissionObject {
	private String groupName;
	private String description;
	private String[] users;
	private String[] permissions;
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getUsers() {
		return users;
	}
	public void setUsers(String[] users) {
		this.users = users;
	}
	public String[] getPermissions() {
		return permissions;
	}
	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}
	public PermissionObject(String groupName, String description, String[] users, String[] permissions) {
		super();
		this.groupName = groupName;
		this.description = description;
		this.users = users;
		this.permissions = permissions;
	}
	public PermissionObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
