package cms.permisstion.object;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.software.cms.model.GroupUser;

import java.util.List;

public class PermisstionObject {
	private String groupName;
	private String description;
	private String[] users;
	private String[] permissions;
	private String[] categories;

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

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public PermisstionObject(String groupName, String description, String[] users, String[] permissions,
			String[] categories) {
		super();
		this.groupName = groupName;
		this.description = description;
		this.users = users;
		this.permissions = permissions;
		this.categories = categories;
	}

	public PermisstionObject() {

	}

	public static PermisstionObject toObject(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			PermisstionObject obj = mapper.readValue(json, PermisstionObject.class);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static class PermissionsGroup {
		long groupId;
		long groupUserId;
		String language;
		int memberInGroup;
		String nameGroup;
		String description;

		public long getGroupUserId() {
			return groupUserId;
		}

		public void setGroupUserId(long groupUserId) {
			this.groupUserId = groupUserId;
		}

		public long getGroupId() {
			return groupId;
		}

		public void setGroupId(long groupId) {
			this.groupId = groupId;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public int getMemberInGroup() {
			return memberInGroup;
		}

		public void setMemberInGroup(int memberInGroup) {
			this.memberInGroup = memberInGroup;
		}

		public String getNameGroup() {
			return nameGroup;
		}

		public void setNameGroup(String nameGroup) {
			this.nameGroup = nameGroup;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public PermissionsGroup() {
		}

		public PermissionsGroup(long groupId, long groupUserId, String language, int memberInGroup, String nameGroup,
				String description) {
			super();
			this.groupId = groupId;
			this.groupUserId = groupUserId;
			this.language = language;
			this.memberInGroup = memberInGroup;
			this.nameGroup = nameGroup;
			this.description = description;
		}
	}

	public static class PermissionsUpdate {
		String name;
		String description;
		List<PermissionsUpdate.User> users;
		List<PermissionsUpdate.Permission> permissions;
		List<PermissionsUpdate.Category> categories;
		ArrayNode categoriesNode;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<PermissionsUpdate.User> getUsers() {
			return users;
		}

		public void setUsers(List<PermissionsUpdate.User> users) {
			this.users = users;
		}

		public List<PermissionsUpdate.Permission> getPermissions() {
			return permissions;
		}

		public void setPermissions(List<PermissionsUpdate.Permission> permissions) {
			this.permissions = permissions;
		}

		public List<PermissionsUpdate.Category> getCategories() {
			return categories;
		}

		public void setCategories(List<PermissionsUpdate.Category> categories) {
			this.categories = categories;
		}

		public ArrayNode getCategoriesNode() {
			return categoriesNode;
		}

		public void setCategoriesNode(ArrayNode categoriesNode) {
			this.categoriesNode = categoriesNode;
		}

		public PermissionsUpdate() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PermissionsUpdate(String name, String description, List<User> users, List<Permission> permissions,
				List<Category> categories, ArrayNode categoriesNode) {
			super();
			this.name = name;
			this.description = description;
			this.users = users;
			this.permissions = permissions;
			this.categories = categories;
			this.categoriesNode = categoriesNode;
		}

		public static class User {
			long userId;
			String screenName;
			boolean checked;

			public boolean isChecked() {
				return checked;
			}

			public void setChecked(boolean checked) {
				this.checked = checked;
			}

			public long getUserId() {
				return userId;
			}

			public void setUserId(long userId) {
				this.userId = userId;
			}

			public String getScreenName() {
				return screenName;
			}

			public void setScreenName(String screenName) {
				this.screenName = screenName;
			}

			public User() {
				super();
				// TODO Auto-generated constructor stub
			}

			public User(long userId, String screenName, boolean checked) {
				super();
				this.userId = userId;
				this.screenName = screenName;
				this.checked = checked;
			}

		}

		public static class Permission {
			int permissionId;
			String role;
			boolean checked;

			public String getRole() {
				return role;
			}

			public void setRole(String role) {
				this.role = role;
			}

			public int getPermissionId() {
				return permissionId;
			}

			public void setPermissionId(int permissionId) {
				this.permissionId = permissionId;
			}

			public boolean isChecked() {
				return checked;
			}

			public void setChecked(boolean checked) {
				this.checked = checked;
			}

			public Permission() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Permission(int permissionId, String role, boolean checked) {
				super();
				this.permissionId = permissionId;
				this.role = role;
				this.checked = checked;
			}

		}

		public static class Category {
			long categoryId;
			String categoryName;
			boolean checked;

			public long getCategoryId() {
				return categoryId;
			}

			public void setCategoryId(long categoryId) {
				this.categoryId = categoryId;
			}

			public String getCategoryName() {
				return categoryName;
			}

			public void setCategoryName(String categoryName) {
				this.categoryName = categoryName;
			}

			public boolean isChecked() {
				return checked;
			}

			public void setChecked(boolean checked) {
				this.checked = checked;
			}

			public Category() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Category(long categoryId, String categoryName, boolean checked) {
				super();
				this.categoryId = categoryId;
				this.categoryName = categoryName;
				this.checked = checked;
			}

		}

	}

}
