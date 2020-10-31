package com.ecoit.qa.question.object;

import java.util.List;

public class AnswerObject {

	private long answerId;
	private String content;
    private List<AttachmentObject> attachments;
    
    public AnswerObject() {
	}
    
    public long getAnswerId() {
		return answerId;
	}
    
    public String getContent() {
		return content;
    }
    
    public List<AttachmentObject> getAttachments() {
		return attachments;
	}
    
    public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}
    
    public void setContent(String content) {
		this.content = content;
	}
    
    public void setAttachments(List<AttachmentObject> attachments) {
		this.attachments = attachments;
	}
}
