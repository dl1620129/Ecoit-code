package com.ecoit.qa.question.object;

public class SearchObject {

	private String searchKey;
	private long categoryId;
	
	public SearchObject() {
	}
	
	public String getSearchKey() {
		return searchKey;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
}
