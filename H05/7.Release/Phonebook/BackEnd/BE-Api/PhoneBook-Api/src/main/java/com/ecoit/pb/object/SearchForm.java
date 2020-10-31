package com.ecoit.pb.object;

public class SearchForm {
    private long organizationId;
    private String searchKey;
    
    public SearchForm() {
	}
    
    public long getOrganizationId() {
		return organizationId;
	}
    
    public String getSearchKey() {
		return searchKey;
	}
    
    public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
    
    public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
}
