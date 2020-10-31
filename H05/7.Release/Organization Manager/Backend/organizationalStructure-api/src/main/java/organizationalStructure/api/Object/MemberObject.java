package organizationalStructure.api.Object;

import java.util.Date;

public class MemberObject {

	private String fullName;
	private String address;
	private String position;

	
	private long memberId;
	private long groupId;
	private long organizationId;
	private long createUser;
	private long modifiedUser;
	
	private Date birthday;
	private Date createDate;
	private Date modifiedDate;
	private Boolean sex;
	private Boolean isLeader;
	private String urlImage;
	private long foderId;
	private long imageFileId;
	
	public MemberObject(String fullName, String address, String position, long memberId, long groupId,
			long organizationId, long createUser, long modifiedUser, Date birthday, Date createDate, Date modifiedDate,
			Boolean sex, Boolean isLeader, String urlImage, long foderId, long imageFileId) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.position = position;
		this.memberId = memberId;
		this.groupId = groupId;
		this.organizationId = organizationId;
		this.createUser = createUser;
		this.modifiedUser = modifiedUser;
		this.birthday = birthday;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.sex = sex;
		this.isLeader = isLeader;
		this.urlImage = urlImage;
		this.foderId = foderId;
		this.imageFileId = imageFileId;
	}
	public Boolean getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(Boolean isLeader) {
		this.isLeader = isLeader;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public long getFoderId() {
		return foderId;
	}
	public void setFoderId(long foderId) {
		this.foderId = foderId;
	}
	public long getImageFileId() {
		return imageFileId;
	}
	public void setImageFileId(long imageFileId) {
		this.imageFileId = imageFileId;
	}
	public MemberObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public long getCreateUser() {
		return createUser;
	}
	public void setCreateUser(long createUser) {
		this.createUser = createUser;
	}
	public long getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(long modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	
}
