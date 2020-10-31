package ThuVienClip.api.Object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import LinkManager.Service.model.Category;

public class ClipObject {

	private long id;
	private long groupId;
	private long companyId;
	private Date createDate;
	private String createByUser;
	private Date modifiedDate;
	private String modifiedByUser;
	private String title;
	private String description;
	private long clipAttachId;
	private long imageAttachId;
	private long viewCount;
	private long likeCount;
	private long categoryId;
	private Boolean isAudio;
	private Boolean display;
	private String nguonVideo;
	private String tacGia;
	private String thoiLuongVideo;
	private Boolean isDaiDien;
	private long clipFileId;
	private long folderId;
	private String clipUrl;
	private List<CategoryObject> cateTitle;
	public ClipObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public List<CategoryObject> getCateTitle() {
		return cateTitle;
	}


	public void setCateTitle(List<CategoryObject> cateTitle) {
		this.cateTitle = cateTitle;
	}


	public ClipObject(long id, long groupId, long companyId, Date createDate, String createByUser, Date modifiedDate,
			String modifiedByUser, String title, String description, long clipAttachId, long imageAttachId,
			long viewCount, long likeCount, long categoryId, Boolean isAudio, Boolean display, String nguonVideo,
			String tacGia, String thoiLuongVideo, Boolean isDaiDien, long clipFileId, long folderId, String clipUrl) {
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
		this.clipAttachId = clipAttachId;
		this.imageAttachId = imageAttachId;
		this.viewCount = viewCount;
		this.likeCount = likeCount;
		this.categoryId = categoryId;
		this.isAudio = isAudio;
		this.display = display;
		this.nguonVideo = nguonVideo;
		this.tacGia = tacGia;
		this.thoiLuongVideo = thoiLuongVideo;
		this.isDaiDien = isDaiDien;
		this.clipFileId = clipFileId;
		this.folderId = folderId;
		this.clipUrl = clipUrl;
	}

	public String getClipUrl() {
		return clipUrl;
	}
	public void setClipUrl(String clipUrl) {
		this.clipUrl = clipUrl;
	}
	
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
	public long getClipAttachId() {
		return clipAttachId;
	}
	public void setClipAttachId(long clipAttachId) {
		this.clipAttachId = clipAttachId;
	}
	public long getImageAttachId() {
		return imageAttachId;
	}
	public void setImageAttachId(long imageAttachId) {
		this.imageAttachId = imageAttachId;
	}
	public long getViewCount() {
		return viewCount;
	}
	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}
	public long getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public Boolean getIsAudio() {
		return isAudio;
	}
	public void setIsAudio(Boolean isAudio) {
		this.isAudio = isAudio;
	}
	public Boolean getDisplay() {
		return display;
	}
	public void setDisplay(Boolean display) {
		this.display = display;
	}
	public String getNguonVideo() {
		return nguonVideo;
	}
	public void setNguonVideo(String nguonVideo) {
		this.nguonVideo = nguonVideo;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getThoiLuongVideo() {
		return thoiLuongVideo;
	}
	public void setThoiLuongVideo(String thoiLuongVideo) {
		this.thoiLuongVideo = thoiLuongVideo;
	}
	public Boolean getIsDaiDien() {
		return isDaiDien;
	}
	public void setIsDaiDien(Boolean isDaiDien) {
		this.isDaiDien = isDaiDien;
	}
	public long getClipFileId() {
		return clipFileId;
	}
	public void setClipFileId(long clipFileId) {
		this.clipFileId = clipFileId;
	}
	public long getFolderId() {
		return folderId;
	}
	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}
	
	
	
	
	
}
