package UserRank.Poisition.Api.object;

import java.util.Date;

public class UserPoisitionObject {
	private long userPoisitionId;
	private String userPoisitionName;
	private Date createDate;
	private Date modifiedDate;
	private String description;
	private long totalMember;
	public long getUserPoisitionId() {
		return userPoisitionId;
	}
	public void setUserPoisitionId(long userPoisitionId) {
		this.userPoisitionId = userPoisitionId;
	}
	public String getUserPoisitionName() {
		return userPoisitionName;
	}
	public void setUserPoisitionName(String userPoisitionName) {
		this.userPoisitionName = userPoisitionName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getTotalMember() {
		return totalMember;
	}
	public void setTotalMember(long totalMember) {
		this.totalMember = totalMember;
	}
	public UserPoisitionObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPoisitionObject(long userPoisitionId, String userPoisitionName, Date createDate, Date modifiedDate,
			String description, long totalMember) {
		super();
		this.userPoisitionId = userPoisitionId;
		this.userPoisitionName = userPoisitionName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.description = description;
		this.totalMember = totalMember;
	}
	
}
