package com.ecoit.lichcongtac.object;

import java.util.Date;
import java.util.List;


public class LichChiTietObject {
	private long lichChiTietId;
    private Date startTime;
    private Date selectedDate;
    private String description;
    private String tenLich;
    private List<GenericObject> nguoiThamDu;
    private List<GenericObject> nguoiChuTri;
    private String address;
    private String note;
    private int action;
    private long organizationId;
    private String organizationName;
    private boolean coLyDo;
    private String lyDoTraVe;
    
    public LichChiTietObject() {
	}
    
    public long getLichChiTietId() {
		return lichChiTietId;
	}
    
    public Date getStartTime() {
		return startTime;
	}
    
    public Date getSelectedDate() {
		return selectedDate;
	}
    
    public String getTenLich() {
		return tenLich;
	}
    
    public String getDescription() {
		return description;
	}
    
    public String getNote() {
		return note;
	}
    
    public List<GenericObject> getNguoiChuTri() {
		return nguoiChuTri;
	}
    
    public List<GenericObject> getNguoiThamDu() {
		return nguoiThamDu;
	}
    
    public String getAddress() {
		return address;
	}
    
    public int getAction() {
		return action;
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
    
    public void setLichChiTietId(long lichChiTietId) {
		this.lichChiTietId = lichChiTietId;
	}
    
    public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
    
    public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}
    
    public void setTenLich(String tenLich) {
		this.tenLich = tenLich;
	}
    
    public void setDescription(String description) {
		this.description = description;
	}
    
    public void setNguoiChuTri(List<GenericObject> nguoiChuTri) {
		this.nguoiChuTri = nguoiChuTri;
	}
    
    public void setNguoiThamDu(List<GenericObject> nguoiThamDu) {
		this.nguoiThamDu = nguoiThamDu;
	}
    
    public void setAddress(String address) {
		this.address = address;
	}
    
    public void setNote(String note) {
		this.note = note;
	}
    
    public void setAction(int action) {
		this.action = action;
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
}
