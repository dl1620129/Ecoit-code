package cms.category.object;

import com.fasterxml.jackson.databind.ObjectMapper;
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
//			Gson gson = new Gson();
//			PermisstionObject obj = gson.fromJson(json, PermisstionObject.class);
//			System.out.println(obj.getName());
//			return obj;

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
}
