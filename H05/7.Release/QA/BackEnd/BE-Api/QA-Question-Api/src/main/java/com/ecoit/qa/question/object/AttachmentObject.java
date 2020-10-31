package com.ecoit.qa.question.object;

public class AttachmentObject {
    private long attachmentId;
    private String attachmentUrl;
    private String attachmentName;
    
    public AttachmentObject() {
	}
    
    public long getAttachmentId() {
		return attachmentId;
	}
    
    public String getAttachmentName() {
		return attachmentName;
	}
    
    public String getAttachmentUrl() {
		return attachmentUrl;
	}
    
    public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}
    
    public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
    
    public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}
}
