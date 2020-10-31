package com.ecoit.mr.object;

public class PermissionGroupObject {
	  private long groupUserId;
	  private long groupId;
	  private String groupName;
	  private String description;
	  private int memberInGroup;
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
	public int getMemberInGroup() {
		return memberInGroup;
	}
	public void setMemberInGroup(int memberInGroup) {
		this.memberInGroup = memberInGroup;
	}
	public PermissionGroupObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PermissionGroupObject(long groupUserId, long groupId, String groupName, String description,
			int memberInGroup) {
		super();
		this.groupUserId = groupUserId;
		this.groupId = groupId;
		this.groupName = groupName;
		this.description = description;
		this.memberInGroup = memberInGroup;
	}
	  

}
