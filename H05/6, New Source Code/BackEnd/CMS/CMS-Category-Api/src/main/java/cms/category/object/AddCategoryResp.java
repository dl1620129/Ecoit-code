package cms.category.object;

public class AddCategoryResp {
	String title;
	String description;
	int thuTu;
	String rootCate;
	String backURL;
	
	public AddCategoryResp(String title, String description, int thuTu, String rootCate, String backURL) {
		super();
		this.title = title;
		this.description = description;
		this.thuTu = thuTu;
		this.rootCate = rootCate;
		this.backURL = backURL;
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
	public int getThuTu() {
		return thuTu;
	}
	public void setThuTu(int thuTu) {
		this.thuTu = thuTu;
	}
	public String getRootCate() {
		return rootCate;
	}
	public void setRootCate(String rootCate) {
		this.rootCate = rootCate;
	}
	public String getBackURL() {
		return backURL;
	}
	public void setBackURL(String backURL) {
		this.backURL = backURL;
	}
	
	
}
