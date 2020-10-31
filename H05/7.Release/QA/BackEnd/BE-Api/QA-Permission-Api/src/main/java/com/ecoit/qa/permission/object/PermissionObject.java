package com.ecoit.qa.permission.object;

public class PermissionObject {
    private long groupUserId;
    private long groupId;
    private String name;
    private String description;
    private int memberInGroup;

    public PermissionObject() {

	}
    
    public long getGroupUserId() {
		return groupUserId;
	}
    
    public long getGroupId() {
		return groupId;
	}
    
    public String getName() {
		return name;
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
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setMemberInGroup(int memberInGroup) {
		this.memberInGroup = memberInGroup;
	}
}
