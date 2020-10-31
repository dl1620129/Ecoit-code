package cms.category.object;

public class GetCategoryJsonBody {
	String urlEdit;
	String urlDelete;
	
	public GetCategoryJsonBody(String urlEdit, String urlDelete) {
		super();
		this.urlEdit = urlEdit;
		this.urlDelete = urlDelete;
	}
	public String getUrlDelete() {
		return urlDelete;
	}
	public String getUrlEdit() {
		return urlEdit;
	}
	public void setUrlDelete(String urlDelete) {
		this.urlDelete = urlDelete;
	}
	public void setUrlEdit(String urlEdit) {
		this.urlEdit = urlEdit;
	}
	
}
