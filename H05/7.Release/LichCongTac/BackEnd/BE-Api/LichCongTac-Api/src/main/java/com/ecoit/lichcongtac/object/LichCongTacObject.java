package com.ecoit.lichcongtac.object;

import java.util.Date;
import java.util.List;


public class LichCongTacObject {
	private long lichCongTacId;
    private Date startDate;
    private Date endDate;
    private String name;
    private long organizationId;
    private String organizationName;
    private boolean coLyDo;
    private String lyDoTraVe;
    private List<String> organizations;
    private List<String> users;
    private List<LichChiTietObject> lichChiTietList;
    private int action;
    
    public LichCongTacObject() {
	}
    
    public long getLichCongTacId() {
		return lichCongTacId;
	}
    
    public Date getStartDate() {
		return startDate;
	}
    
    public Date getEndDate() {
		return endDate;
	}

    public String getName() {
		return name;
	}
    
    public long getOrganizationId() {
		return organizationId;
	}
    
    public String getOrganizationName() {
		return organizationName;
	}
    
    public boolean isCoLyDo() {
		return coLyDo;
	}
    
    public String getLyDoTraVe() {
		return lyDoTraVe;
	}
    
    public List<String> getOrganizations() {
		return organizations;
	}
    
    public List<String> getUsers() {
		return users;
	}
    
    public List<LichChiTietObject> getLichChiTietList() {
		return lichChiTietList;
	}
    
    public int getAction() {
		return action;
	}
    
    public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
    
    public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
    public void setLichCongTacId(long lichCongTacId) {
		this.lichCongTacId = lichCongTacId;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
    
    public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
    
    public void setCoLyDo(boolean coLyDo) {
		this.coLyDo = coLyDo;
	}
    
    public void setLyDoTraVe(String lyDoTraVe) {
		this.lyDoTraVe = lyDoTraVe;
	}
    
    public void setLichChiTietList(List<LichChiTietObject> lichChiTietList) {
		this.lichChiTietList = lichChiTietList;
	}
    
    public void setOrganizations(List<String> organizations) {
	    this.organizations = organizations;
    }
   
    public void setUsers(List<String> users) {
	    this.users = users;
    }
    
    public void setAction(int action) {
		this.action = action;
	}
}
