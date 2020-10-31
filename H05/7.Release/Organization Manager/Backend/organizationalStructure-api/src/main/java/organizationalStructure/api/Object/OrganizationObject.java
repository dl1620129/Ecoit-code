package organizationalStructure.api.Object;

import java.util.Date;

public class OrganizationObject {
	
	private String name;
	private String leader;
	private String address;
	private String organizationCode;
	private String description;
	private String position;private String phoneNumber;

	
	private long organizationId;
	private long groupId;
	private long member;
	private long parentId;
	private long createUser;
	private long modifiedUser;
	private long status; 
	private long orgCoreId;
	public int thuTu;
	
	private Date createDate;
	private Date modifiedDate;
	public long getOrgCoreId() {
		return orgCoreId;
	}
	public void setOrgCoreId(long orgCoreId) {
		this.orgCoreId = orgCoreId;
	}
	
	public OrganizationObject(String name, String leader, String address, String organizationCode, String description,
			String position, String phoneNumber, long organizationId, long groupId, long member, long parentId,
			long createUser, long modifiedUser, long status, long orgCoreId, int thuTu, Date createDate,
			Date modifiedDate) {
		super();
		this.name = name;
		this.leader = leader;
		this.address = address;
		this.organizationCode = organizationCode;
		this.description = description;
		this.position = position;
		this.phoneNumber = phoneNumber;
		this.organizationId = organizationId;
		this.groupId = groupId;
		this.member = member;
		this.parentId = parentId;
		this.createUser = createUser;
		this.modifiedUser = modifiedUser;
		this.status = status;
		this.orgCoreId = orgCoreId;
		this.thuTu = thuTu;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public OrganizationObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getMember() {
		return member;
	}
	public void setMember(long member) {
		this.member = member;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
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
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public int getThuTu() {
		return thuTu;
	}
	public void setThuTu(int thuTu) {
		this.thuTu = thuTu;
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


}
