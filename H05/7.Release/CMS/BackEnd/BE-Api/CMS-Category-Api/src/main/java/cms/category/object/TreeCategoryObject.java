package cms.category.object;

import java.util.List;

public class TreeCategoryObject {
    private String title;
    private long cateId;
    private long parentId;
    private int orderNumber;
    private long createDate;
    private String link;
    private String description;
    private List<TreeCategoryObject> child;
    
    public TreeCategoryObject() {
	}
    
    public String getTitle() {
		return title;
	}
    
    public long getCateId() {
		return cateId;
	}
    
    public long getParentId() {
		return parentId;
	}
    
    public int getOrderNumber() {
		return orderNumber;
	}
    
    public long getCreateDate() {
		return createDate;
	}
    
    public String getLink() {
		return link;
	}
    
    public String getDescription() {
		return description;
	}
    
    public List<TreeCategoryObject> getChild() {
		return child;
	}
    
    public void setTitle(String title) {
		this.title = title;
	}
    
    
    public void setCateId(long cateId) {
		this.cateId = cateId;
	}
    
    public void setParentId(long parentId) {
		this.parentId = parentId;
	}
    
    public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
    
    public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
    
    public void setLink(String link) {
		this.link = link;
	}
    
    public void setDescription(String description) {
		this.description = description;
	}
    
    public void setChild(List<TreeCategoryObject> child) {
		this.child = child;
	}
}
