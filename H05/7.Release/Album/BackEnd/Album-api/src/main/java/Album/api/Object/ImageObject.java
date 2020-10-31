package Album.api.Object;

import java.util.Date;

public class ImageObject {
	
	private long imageId;
	private long groupId;
	private long companyId;
	private long categoryId;
	private long fileAttachId;
	private long view;
	private long fieldId;
	private long imageFileId;
	private long folderId;
	private int thuTu;
	private String addByUser;
	private String modifiedByUser;
	private String title;
	private String description;
	private String tacGia;
	private Date addDate;
	private Date modifiedDate;
	private Boolean display;
	private Boolean isDaiDien;
	private String imageUrl;
	public long getImageId() {
		return imageId;
	}
	public void setImageId(long imageId) {
		this.imageId = imageId;
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
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getFileAttachId() {
		return fileAttachId;
	}
	public void setFileAttachId(long fileAttachId) {
		this.fileAttachId = fileAttachId;
	}
	public long getView() {
		return view;
	}
	public void setView(long view) {
		this.view = view;
	}
	public long getFieldId() {
		return fieldId;
	}
	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}
	public long getImageFileId() {
		return imageFileId;
	}
	public void setImageFileId(long imageFileId) {
		this.imageFileId = imageFileId;
	}
	public long getFolderId() {
		return folderId;
	}
	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}
	public int getThuTu() {
		return thuTu;
	}
	public void setThuTu(int thuTu) {
		this.thuTu = thuTu;
	}
	public String getAddByUser() {
		return addByUser;
	}
	public void setAddByUser(String addByUser) {
		this.addByUser = addByUser;
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
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Boolean getDisplay() {
		return display;
	}
	public void setDisplay(Boolean display) {
		this.display = display;
	}
	public Boolean getIsDaiDien() {
		return isDaiDien;
	}
	public void setIsDaiDien(Boolean isDaiDien) {
		this.isDaiDien = isDaiDien;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public ImageObject(long imageId, long groupId, long companyId, long categoryId, long fileAttachId, long view,
			long fieldId, long imageFileId, long folderId, int thuTu, String addByUser, String modifiedByUser,
			String title, String description, String tacGia, Date addDate, Date modifiedDate, Boolean display,
			Boolean isDaiDien, String imageUrl) {
		super();
		this.imageId = imageId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.categoryId = categoryId;
		this.fileAttachId = fileAttachId;
		this.view = view;
		this.fieldId = fieldId;
		this.imageFileId = imageFileId;
		this.folderId = folderId;
		this.thuTu = thuTu;
		this.addByUser = addByUser;
		this.modifiedByUser = modifiedByUser;
		this.title = title;
		this.description = description;
		this.tacGia = tacGia;
		this.addDate = addDate;
		this.modifiedDate = modifiedDate;
		this.display = display;
		this.isDaiDien = isDaiDien;
		this.imageUrl = imageUrl;
	}
	public ImageObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
