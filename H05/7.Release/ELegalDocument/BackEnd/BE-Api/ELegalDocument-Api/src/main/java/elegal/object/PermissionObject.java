package elegal.object;

public class PermissionObject {
	private String groupName;
	private String description;
	private String[] users;
	private String[] permissions;
	private String[] categories;
	private String[] organizations;
	private String[] fields;
	
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
	
	public String[] getCategories() {
		return categories;
	}
	
	public String[] getOrganizations() {
		return organizations;
	}
	
	public String[] getFields() {
		return fields;
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
	
	public void setCategories(String[] categories) {
		this.categories = categories;
	}
	
	public void setOrganizations(String[] organizations) {
		this.organizations = organizations;
	}
	
	public void setFields(String[] fields) {
		this.fields = fields;
	}
}
