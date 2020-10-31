package ChungThuSo.api.object;

import java.util.Date;

public class ChungThuSoObject {
	private long kysoId;
	private long groupId;
	private long companyId;
	private long userId;
	private String userName;
	private String screenName;
	private Date createDate;
	private Date modifiedDate;
	private String rawData;
	private String serialNumber;
	private String organizationId;
	private long createUserId;
	private Date fromDate;
	private Date toDate;
	public ChungThuSoObject(long kysoId, long groupId, long companyId, long userId, String userName, String screenName,
			Date createDate, Date modifiedDate, String rawData, String serialNumber, String organizationId,
			long createUserId, Date fromDate, Date toDate) {
		super();
		this.kysoId = kysoId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.screenName = screenName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.rawData = rawData;
		this.serialNumber = serialNumber;
		this.organizationId = organizationId;
		this.createUserId = createUserId;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getKysoId() {
		return kysoId;
	}
	public void setKysoId(long kysoId) {
		this.kysoId = kysoId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
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
	public String getRawData() {
		return rawData;
	}
	public void setRawData(String rawData) {
		this.rawData = rawData;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public ChungThuSoObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
