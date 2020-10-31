package cms.webview.news.object;

import java.util.Date;

public class SearchObject {
    private String[] tags;
    private String keyword;
    private Date fromDate;
    private Date toDate;
    private long[] categoryIds;
    private long eventId;
    
    public SearchObject() {
		// TODO Auto-generated constructor stub
	}
    
    public String[] getTags() {
		return tags;
	}
    
    public String getKeyword() {
		return keyword;
	}
    
    public Date getFromDate() {
		return fromDate;
	}
    
    public Date getToDate() {
		return toDate;
	}
    
    public long[] getCategoryIds() {
		return categoryIds;
	}
    
    public long getEventId() {
		return eventId;
	}
    
    public void setTags(String[] tags) {
		this.tags = tags;
	}
    
    public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
    
    public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
    
    public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
    
    public void setCategoryIds(long[] categoryIds) {
		this.categoryIds = categoryIds;
	}
    
    public void setEventId(long eventId) {
		this.eventId = eventId;
	}
}
