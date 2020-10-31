package ThuVienClip.api.Object;

import java.util.Date;

public class CategoryObject {
	private long id;
	private long groupId;
	private long companyId;
	private Date createDate;
	private String createByUser;
	private Date modifiedDate;
	private String modifiedByUser;
	private String title;
	private String description;
	private Boolean isAudio;
	private long view;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateByUser() {
		return createByUser;
	}
	public void setCreateByUser(String createByUser) {
		this.createByUser = createByUser;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(String modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsAudio() {
		return isAudio;
	}
	public void setIsAudio(Boolean isAudio) {
		this.isAudio = isAudio;
	}
	public long getView() {
		return view;
	}
	public void setView(long view) {
		this.view = view;
	}
	public CategoryObject(long id, long groupId, long companyId, Date createDate, String createByUser,
			Date modifiedDate, String modifiedByUser, String title, String description, Boolean isAudio, long view) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.companyId = companyId;
		this.createDate = createDate;
		this.createByUser = createByUser;
		this.modifiedDate = modifiedDate;
		this.modifiedByUser = modifiedByUser;
		this.title = title;
		this.description = description;
		this.isAudio = isAudio;
		this.view = view;
	}
	public CategoryObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
