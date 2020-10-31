package UserRank.Poisition.Api.object;

import java.util.Date;

public class UserRankObject {

	private long userRankId;
	private String userRankName;
	private Date createDate;
	private Date modifiedDate;
	private String description;
	private long totalMember;
	public long getUserRankId() {
		return userRankId;
	}
	public void setUserRankId(long userRankId) {
		this.userRankId = userRankId;
	}
	public String getUserRankName() {
		return userRankName;
	}
	public void setUserRankName(String userRankName) {
		this.userRankName = userRankName;
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
	public UserRankObject(long userRankId, String userRankName, Date createDate, Date modifiedDate, String description,
			long totalMember) {
		super();
		this.userRankId = userRankId;
		this.userRankName = userRankName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.description = description;
		this.totalMember = totalMember;
	}
	public UserRankObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
