package com.ecoit.lichcongtac.object;

public class PermissionGroupObject {
    private long groupUserId;
    private long groupId;
    private String groupName;
    private String description;
    private int memberInGroup;

    public PermissionGroupObject() {

	}
    
    public long getGroupUserId() {
		return groupUserId;
	}
    
    public long getGroupId() {
		return groupId;
	}
    
    public String getGroupName() {
		return groupName;
	}
    
    public String getDescription() {
		return description;
	}
    
    public int getMemberInGroup() {
		return memberInGroup;
	}
    
	public void setGroupUserId(long groupUserId) {
		this.groupUserId = groupUserId;
	}
	
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setMemberInGroup(int memberInGroup) {
		this.memberInGroup = memberInGroup;
	}
}
