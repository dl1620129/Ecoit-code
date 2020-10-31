package elegal.object;

import java.util.List;

public class TreeOrgObject {
    private long organizationId;
    private String name;
    private String description;
    private boolean statusOrg;
    private long parentId;
    private int position;
    private List<TreeOrgObject> child;
    
    public TreeOrgObject() {
	}
    
    public long getOrganizationId() {
		return organizationId;
	}
    
    public String getName() {
		return name;
	}
    public String getDescription() {
		return description;
	}
    
    public boolean isStatusOrg() {
		return statusOrg;
	}
    
    public long getParentId() {
		return parentId;
	}
    
    public int getPosition() {
		return position;
	}
    
    public List<TreeOrgObject> getChild() {
		return child;
	}
    
    public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public void setDescription(String description) {
		this.description = description;
	}
    
    public void setStatusOrg(boolean statusOrg) {
		this.statusOrg = statusOrg;
	}
    
    public void setParentId(long parentId) {
		this.parentId = parentId;
	}
    
    public void setPosition(int position) {
		this.position = position;
	}
    
    public void setChild(List<TreeOrgObject> child) {
		this.child = child;
	}
}
