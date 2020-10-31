package com.ecoit.qa.question.object;

import java.util.List;

public class QuestionObject {
    private long questionId;
    private String title;
    private String address;
    private String email;
    private String content;
    private String phoneNumber;
    private String userName;
    private long categoryId;
    private int status;
    private List<AttachmentObject> attachments;
    
    public QuestionObject() {
	}
    
    public long getQuestionId() {
		return questionId;
	}
    
    public String getAddress() {
		return address;
	}
    
    public String getTitle() {
		return title;
	}
    
    public String getEmail() {
		return email;
	}
    
    public String getContent() {
		return content;
	}
    
    public String getPhoneNumber() {
		return phoneNumber;
	}
    
    public String getUserName() {
		return userName;
	}
    
    public long getCategoryId() {
		return categoryId;
	}
    
    public int getStatus() {
		return status;
	}
    
    public List<AttachmentObject> getAttachments() {
		return attachments;
	}
    
    public void setAddress(String address) {
		this.address = address;
	}

    public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
    
    public void setContent(String content) {
		this.content = content;
	}
    
    public void setEmail(String email) {
		this.email = email;
	}
    
    public void setUserName(String userName) {
		this.userName = userName;
	}
    
    public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
    
    public void setTitle(String title) {
		this.title = title;
	}
    
    public void setStatus(int status) {
		this.status = status;
	}
    
	public void setAttachments(List<AttachmentObject> attachments) {
		this.attachments = attachments;
	}
}
