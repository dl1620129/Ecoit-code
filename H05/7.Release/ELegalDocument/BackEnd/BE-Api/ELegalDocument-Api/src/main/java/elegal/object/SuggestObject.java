package elegal.object;

import java.util.Date;

public class SuggestObject {

	private long sugId;
	private long docId;
	private String userName;
	private String email;
	private String title;
	private String content;
	private boolean isApproved;
	private Date createdDate;
	
	public long getSugId() {
		return sugId;
	}
	
	public long getDocId() {
		return docId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public boolean isApproved() {
		return isApproved;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setSugId(long sugId) {
		this.sugId = sugId;
	}
	
	public void setDocId(long docId) {
		this.docId = docId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
