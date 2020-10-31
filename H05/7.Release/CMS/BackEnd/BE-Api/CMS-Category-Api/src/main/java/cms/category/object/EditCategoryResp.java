package cms.category.object;

public class EditCategoryResp {
	long idCate;
	String title;
	String description;
	int thuTu;
	String rootCate;
	String backURL;
	
	public EditCategoryResp(long idCate,String title, String description, int thuTu, String rootCate, String backURL) {
		super();
		this.idCate = idCate;
		this.title = title;
		this.description = description;
		this.thuTu = thuTu;
		this.rootCate = rootCate;
		this.backURL = backURL;
	}
	
	public long getIdCate() {
		return idCate;
	}
	
	public void setIdCate(long idCate) {
		this.idCate = idCate;
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
