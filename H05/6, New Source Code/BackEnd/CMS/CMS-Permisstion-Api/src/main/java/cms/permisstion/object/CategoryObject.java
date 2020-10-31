package cms.permisstion.object;

public class CategoryObject {
	private String selected;
	private String groupName;
	private String description;
	private String treeCate;

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTreeCate() {
		return treeCate;
	}

	public void setTreeCate(String treeCate) {
		this.treeCate = treeCate;
	}

	public CategoryObject(String selected, String groupName, String description, String treeCate) {
		super();
		this.selected = selected;
		this.groupName = groupName;
		this.description = description;
		this.treeCate = treeCate;
	}

}
