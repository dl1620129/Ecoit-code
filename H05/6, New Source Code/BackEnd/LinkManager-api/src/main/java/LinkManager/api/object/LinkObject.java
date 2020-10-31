package LinkManager.api.object;

import java.util.Date;

public class LinkObject {
	private long linksid;
	private long groupid;
	private Date createddate;
	private Date modifieddate;
	private long linksgroupid;
	private String name;
	private String decription;
	private String url;
	private long imageid;
	private Boolean hasimage;
	private int position;
	private Boolean show;
	private Boolean icon;
	private long parentId;
	public long getLinksid() {
		return linksid;
	}
	public void setLinksid(long linksid) {
		this.linksid = linksid;
	}
	public long getGroupid() {
		return groupid;
	}
	public void setGroupid(long groupid) {
		this.groupid = groupid;
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
	public long getLinksgroupid() {
		return linksgroupid;
	}
	public void setLinksgroupid(long linksgroupid) {
		this.linksgroupid = linksgroupid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getImageid() {
		return imageid;
	}
	public void setImageid(long imageid) {
		this.imageid = imageid;
	}
	public Boolean getHasimage() {
		return hasimage;
	}
	public void setHasimage(Boolean hasimage) {
		this.hasimage = hasimage;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Boolean getShow() {
		return show;
	}
	public void setShow(Boolean show) {
		this.show = show;
	}
	public Boolean getIcon() {
		return icon;
	}
	public void setIcon(Boolean icon) {
		this.icon = icon;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	

	public LinkObject(long linksid, long groupid, Date createddate, Date modifieddate, long linksgroupid, String name,
			String decription, String url, long imageid, Boolean hasimage, int position, Boolean show, Boolean icon,
			long parentId) {
		super();
		this.linksid = linksid;
		this.groupid = groupid;
		this.createddate = createddate;
		this.modifieddate = modifieddate;
		this.linksgroupid = linksgroupid;
		this.name = name;
		this.decription = decription;
		this.url = url;
		this.imageid = imageid;
		this.hasimage = hasimage;
		this.position = position;
		this.show = show;
		this.icon = icon;
		this.parentId = parentId;
	}
	public LinkObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LinkObject [linksid=" + linksid + ", groupid=" + groupid + ", createddate=" + createddate
				+ ", modifieddate=" + modifieddate + ", linksgroupid=" + linksgroupid + ", name=" + name
				+ ", decription=" + decription + ", url=" + url + ", imageid=" + imageid + ", hasimage=" + hasimage
				+ ", position=" + position + ", show=" + show + ", icon=" + icon + ", parentId=" + parentId + "]";
	}
	

}
