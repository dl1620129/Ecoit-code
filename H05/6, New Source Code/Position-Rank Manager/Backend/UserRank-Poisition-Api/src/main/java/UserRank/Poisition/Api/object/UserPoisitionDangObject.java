package UserRank.Poisition.Api.object;

import java.util.Date;

public class UserPoisitionDangObject {
	private long userPoisitionDangId;
	private String userPoisitionDangName;
	private Date createDate;
	private Date modifiedDate;
	private String description;
	private long totalMember;
	public UserPoisitionDangObject(long userPoisitionDangId, String userPoisitionDangName, Date createDate, Date modifiedDate,
			String description, long totalMember) {
		super();
		this.userPoisitionDangId = userPoisitionDangId;
		this.userPoisitionDangName = userPoisitionDangName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.description = description;
		this.totalMember = totalMember;
	}
	public long getUserPoisitionDangId() {
		return userPoisitionDangId;
	}
	public void setUserPoisitionDangId(long userPoisitionDangId) {
		this.userPoisitionDangId = userPoisitionDangId;
	}
	public String getUserPoisitionDangName() {
		return userPoisitionDangName;
	}
	public void setUserPoisitionDangName(String userPoisitionDangName) {
		this.userPoisitionDangName = userPoisitionDangName;
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
	public UserPoisitionDangObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
