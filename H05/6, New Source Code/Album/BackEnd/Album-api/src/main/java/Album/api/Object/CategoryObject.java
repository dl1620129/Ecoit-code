package Album.api.Object;

import java.util.Date;

public class CategoryObject {

	private long categoryId;
	private long groupId;
	private long companyId;
	private long view;
	private long parentId;
	private long fieldId;
	private long status;
	private int thuTu;
	private String createByUser;
	private String modifiedByUser;
	private String name;
	private String description;
	private String tacGiaAlbum;
	private Date createDate;
	private Date modifiedDate;
	private Boolean isDaiDien;
	private String urlImage;
	private int countImage;
	
	public int getCountImage() {
		return countImage;
	}
	public void setCountImage(int countImage) {
		this.countImage = countImage;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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
	public long getView() {
		return view;
	}
	public void setView(long view) {
		this.view = view;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public long getFieldId() {
		return fieldId;
	}
	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
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
	public String getCreateByUser() {
		return createByUser;
	}
	public void setCreateByUser(String createByUser) {
		this.createByUser = createByUser;
	}
	public String getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(String modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
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
	public String getTacGiaAlbum() {
		return tacGiaAlbum;
	}
	public void setTacGiaAlbum(String tacGiaAlbum) {
		this.tacGiaAlbum = tacGiaAlbum;
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
	public Boolean getIsDaiDien() {
		return isDaiDien;
	}
	public void setIsDaiDien(Boolean isDaiDien) {
		this.isDaiDien = isDaiDien;
	}
	
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public CategoryObject(long categoryId, long groupId, long companyId, long view, long parentId, long fieldId,
			long status, int thuTu, String createByUser, String modifiedByUser, String name, String description,
			String tacGiaAlbum, Date createDate, Date modifiedDate, Boolean isDaiDien,String urlImage) {
		super();
		this.categoryId = categoryId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.view = view;
		this.parentId = parentId;
		this.fieldId = fieldId;
		this.status = status;
		this.thuTu = thuTu;
		this.createByUser = createByUser;
		this.modifiedByUser = modifiedByUser;
		this.name = name;
		this.description = description;
		this.tacGiaAlbum = tacGiaAlbum;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.isDaiDien = isDaiDien;
		this.urlImage = urlImage;
	}
	public CategoryObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
