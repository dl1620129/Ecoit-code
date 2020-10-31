package cms.category.object;

public class AddCategoryJsonBody {
	String backUrl;
	String languageId;
	long groupId;
	
	public AddCategoryJsonBody(String backUrl, String languageId, long groupId) {
		super();
		this.backUrl = backUrl;
		this.languageId = languageId;
		this.groupId = groupId;
	}
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	public String getLanguageId() {
		return languageId;
	}
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	
}
