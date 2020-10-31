package com.ecoit.mr.object;

import java.util.Date;

public class MemberReportObject {
    private long memberReportId;
    private long tong;
    private long congTac;
    private long hocTap;
    private long nghiPhep;
    private long nghiOm;
    private long nghiBu;
    private long liDoKhac;
    private String note;
    private long unitId;
    private String language;
    private Date modifiedDate;
    private String userName;
    private String unitName;
    private String status;
    
    public MemberReportObject(long memberReportId, long tong, long congTac, long hocTap, long nghiPhep, long nghiOm,
			long nghiBu, long liDoKhac, String note, long unitId, String language, Date modifiedDate, String userName,
			String unitName, String status) {
		super();
		this.memberReportId = memberReportId;
		this.tong = tong;
		this.congTac = congTac;
		this.hocTap = hocTap;
		this.nghiPhep = nghiPhep;
		this.nghiOm = nghiOm;
		this.nghiBu = nghiBu;
		this.liDoKhac = liDoKhac;
		this.note = note;
		this.unitId = unitId;
		this.language = language;
		this.modifiedDate = modifiedDate;
		this.userName = userName;
		this.unitName = unitName;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MemberReportObject() {
	}
    
    public long getMemberReportId() {
		return memberReportId;
	}
    
    public long getTong() {
		return tong;
	}
    
    public long getCongTac() {
		return congTac;
	}
    
    public long getHocTap() {
		return hocTap;
	}
    
    public long getNghiPhep() {
		return nghiPhep;
	}
    
    public long getNghiOm() {
		return nghiOm;
	}
    
    public long getNghiBu() {
		return nghiBu;
	}
    
    public long getLiDoKhac() {
		return liDoKhac;
	}
    
    public String getNote() {
		return note;
	}
    
    public long getUnitId() {
		return unitId;
	}
    
    public String getLanguage() {
		return language;
	}
			
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUnitName() {
		return unitName;
	}
	
	public void setMemberReportId(long memberReportId) {
		this.memberReportId = memberReportId;
	}
	
	public void setTong(long tong) {
		this.tong = tong;
	}
	
	public void setCongTac(long congTac) {
		this.congTac = congTac;
	}
	
	public void setHocTap(long hocTap) {
		this.hocTap = hocTap;
	}
	
	public void setNghiPhep(long nghiPhep) {
		this.nghiPhep = nghiPhep;
	}
	
	public void setNghiOm(long nghiOm) {
		this.nghiOm = nghiOm;
	}
	
	public void setNghiBu(long nghiBu) {
		this.nghiBu = nghiBu;
	}
	
	public void setLiDoKhac(long liDoKhac) {
		this.liDoKhac = liDoKhac;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
}
