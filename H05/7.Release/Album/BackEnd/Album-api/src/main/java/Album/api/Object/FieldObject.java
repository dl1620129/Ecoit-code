package Album.api.Object;

import java.util.Date;


public class FieldObject {
	private long fieldsId;
	private long groupId;
	private long createByUser;
	private long modifiedByUser;
	private int thuTu;
	private Date createDate;
	private Date modifiedDate;
	private String name;
	private String description;
	public FieldObject(long fieldsId, long groupId, long createByUser, long modifiedByUser, int thuTu, Date createDate,
			Date modifiedDate, String name, String description) {
		super();
		this.fieldsId = fieldsId;
		this.groupId = groupId;
		this.createByUser = createByUser;
		this.modifiedByUser = modifiedByUser;
		this.thuTu = thuTu;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.description = description;
	}
	public FieldObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getFieldsId() {
		return fieldsId;
	}
	public void setFieldsId(long fieldsId) {
		this.fieldsId = fieldsId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getCreateByUser() {
		return createByUser;
	}
	public void setCreateByUser(long createByUser) {
		this.createByUser = createByUser;
	}
	public long getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(long modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
