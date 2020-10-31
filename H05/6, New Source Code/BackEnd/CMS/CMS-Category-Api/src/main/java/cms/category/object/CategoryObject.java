package cms.category.object;

public class CategoryObject {
	private long categoryId;
	private long groupId;
	private String language;
	private String title;
	private String createDate;
	private String modifiedDate;
	private long createdUser;
	private long modifiedUser;
	private String path;
	private String description;
	private int parentId;
	private int active;
	private String cateChild;
	private int thutu;
	private String link;

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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public long getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(long createdUser) {
		this.createdUser = createdUser;
	}

	public long getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(long modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getCateChild() {
		return cateChild;
	}

	public void setCateChild(String cateChild) {
		this.cateChild = cateChild;
	}

	public int getThutu() {
		return thutu;
	}

	public void setThutu(int thutu) {
		this.thutu = thutu;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public CategoryObject(long categoryId, long groupId, String language, String title, String createDate,
			String modifiedDate, long createdUser, long modifiedUser, String path, String description, int parentId,
			int active, String cateChild, int thutu, String link) {
		super();
		this.categoryId = categoryId;
		this.groupId = groupId;
		this.language = language;
		this.title = title;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.createdUser = createdUser;
		this.modifiedUser = modifiedUser;
		this.path = path;
		this.description = description;
		this.parentId = parentId;
		this.active = active;
		this.cateChild = cateChild;
		this.thutu = thutu;
		this.link = link;
	}

	public CategoryObject() {
		super();
		// TODO Auto-generated constructor stub
	}

}
