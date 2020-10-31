package cms.mapcategory.layout.object;

public class MapCategoryLayoutObject {
	private long mapCateLayoutId;
	private long companyId;
	private long groupId;
	private long categoryId;
	private long type;
	private String categoryName;
	private String pageName;
	private long pageId;

	public long getPageId() {
		return pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public long getMapCateLayoutId() {
		return mapCateLayoutId;
	}

	public void setMapCateLayoutId(long mapCateLayoutId) {
		this.mapCateLayoutId = mapCateLayoutId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public MapCategoryLayoutObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MapCategoryLayoutObject(long mapCateLayoutId, long companyId, long groupId, long categoryId, long type,
			String categoryName, String pageName, long pageId) {
		super();
		this.mapCateLayoutId = mapCateLayoutId;
		this.companyId = companyId;
		this.groupId = groupId;
		this.categoryId = categoryId;
		this.type = type;
		this.categoryName = categoryName;
		this.pageName = pageName;
		this.pageId = pageId;
	}

	public static class Layout {
		private long id;
		private String name;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Layout() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Layout(long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

	}
}
