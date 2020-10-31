package com.ecoit.lichcongtac.object;

public class SearchObject {
	private String searchKey;
	private int action;
	private String fromDate;
	private String toDate;
	
	public SearchObject() {
	}
	
	public String getFromDate() {
		return fromDate;
	}
	
	public String getToDate() {
		return toDate;
	}
	
	public int getAction() {
		return action;
	}
	
	public String getSearchKey() {
		return searchKey;
	}
	
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	public void setAction(int action) {
		this.action = action;
	}
	
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
}
