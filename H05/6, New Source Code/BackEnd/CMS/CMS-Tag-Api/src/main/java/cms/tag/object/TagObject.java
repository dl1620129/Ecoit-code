package cms.tag.object;

public class TagObject {
	private long id;
	private String name;
	private String description;
	private long groupId;
	private String language;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public TagObject(long id, String name, String description, long groupId, String language) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.groupId = groupId;
		this.language = language;
	}
	public TagObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
