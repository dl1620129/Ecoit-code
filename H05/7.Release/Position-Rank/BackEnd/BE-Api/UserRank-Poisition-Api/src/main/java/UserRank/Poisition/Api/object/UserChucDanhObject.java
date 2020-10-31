package UserRank.Poisition.Api.object;

import java.util.Date;

public class UserChucDanhObject {
	private long userChuDanhId;
	private String userChuDanhName;
	private Date createDate;
	private Date modifiedDate;
	private String description;
	private long totalMember;
	public long getUserChuDanhId() {
		return userChuDanhId;
	}
	public void setUserChuDanhId(long userChuDanhId) {
		this.userChuDanhId = userChuDanhId;
	}
	public String getUserChuDanhName() {
		return userChuDanhName;
	}
	public void setUserChuDanhName(String userChuDanhName) {
		this.userChuDanhName = userChuDanhName;
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
	public UserChucDanhObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserChucDanhObject(long userChuDanhId, String userChuDanhName, Date createDate, Date modifiedDate,
			String description, long totalMember) {
		super();
		this.userChuDanhId = userChuDanhId;
		this.userChuDanhName = userChuDanhName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.description = description;
		this.totalMember = totalMember;
	}
	
}
