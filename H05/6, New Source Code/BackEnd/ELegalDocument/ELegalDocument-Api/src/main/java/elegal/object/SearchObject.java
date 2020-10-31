package elegal.object;

import java.util.Date;

public class SearchObject {
	private long typeId;
    private long organizationId;
    private String searchKey;
    private String symbol;
    private int isPublic;
    private long signerId;
    private long fieldId;
    private Date promulDate;
    private Date fromDate;
    private Date toDate;
    private String newGopY;
    
    public SearchObject() {
	}
       
    public int getIsPublic() {
		return isPublic;
	}
    
    public String getSymbol() {
		return symbol;
	}
    
    public long getTypeId() {
		return typeId;
	}
    
    public long getOrganizationId() {
		return organizationId;
	}
    
    public String getSearchKey() {
		return searchKey;
	}
    
    public long getSignerId() {
		return signerId;
	}
    
    public long getFieldId() {
		return fieldId;
	}
    
    public Date getPromulDate() {
		return promulDate;
	}
    
    public Date getFromDate() {
		return fromDate;
	}
    
    public Date getToDate() {
		return toDate;
	}
    
    public String getNewGopY() {
		return newGopY;
	}
    
    public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}
    
    public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
    
    public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
    
    public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
    
    public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
    
    public void setSignerId(long signerId) {
		this.signerId = signerId;
	}
    
    public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}
    
    public void setPromulDate(Date promulDate) {
		this.promulDate = promulDate;
	}
    
    public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
    
    public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
    
    public void setNewGopY(String newGopY) {
		this.newGopY = newGopY;
	}
}
