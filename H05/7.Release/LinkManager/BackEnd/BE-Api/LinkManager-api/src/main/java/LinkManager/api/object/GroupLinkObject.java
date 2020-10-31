package LinkManager.api.object;

import java.util.Date;
import java.util.List;

public class GroupLinkObject {

	private long linksgroupid;
	private long groupid;
	private long createUserId;
	private Date createddate;
	private Date modifieddate;
	private String groupName;
	private String description;
	private List<LinkObject> listLink;
	public GroupLinkObject(long linksgroupid, long groupid, long createUserId, Date createddate, Date modifieddate,
			String groupName, String description) {
		super();
		this.linksgroupid = linksgroupid;
		this.groupid = groupid;
		this.createUserId = createUserId;
		this.createddate = createddate;
		this.modifieddate = modifieddate;
		this.groupName = groupName;
		this.description = description;
	}
	public List<LinkObject> getListLink() {
		return listLink;
	}
	public void setListLink(List<LinkObject> listLink) {
		this.listLink = listLink;
	}
	
	public GroupLinkObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getLinksgroupid() {
		return linksgroupid;
	}
	public void setLinksgroupid(long linksgroupid) {
		this.linksgroupid = linksgroupid;
	}
	public long getGroupid() {
		return groupid;
	}
	public void setGroupid(long groupid) {
		this.groupid = groupid;
	}
	public long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
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
	@Override
	public String toString() {
		return "GroupResource [linksgroupid=" + linksgroupid + ", groupid=" + groupid + ", createUserId=" + createUserId
				+ ", createddate=" + createddate + ", modifieddate=" + modifieddate + ", groupName=" + groupName
				+ ", description=" + description + "]";
	}
	
	
}
