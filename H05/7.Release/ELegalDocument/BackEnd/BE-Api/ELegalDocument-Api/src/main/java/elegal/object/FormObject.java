package elegal.object;

import java.io.File;
import java.util.Date;

public class FormObject {
	private String num;
	private String symbol;
	private Date promulDate;
	private Date effectivedDate;
	private Date expiredDate;
	private String summary;
	private String content;
	private String replaceDoc;
	private int action;
	private int isPublic;
	private long fieldId;
	private long organizationId;
	private String docRelation;
	private long[] typeIds;
	private long[] signerIds;
	private File[] attachments;
	
	public FormObject() {
	}
	
	public String getNum() {
		return num;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public Date getPromulDate() {
		return promulDate;
	}
	
	public Date getEffectivedDate() {
		return effectivedDate;
	}
	
	public Date getExpiredDate() {
		return expiredDate;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getReplaceDoc() {
		return replaceDoc;
	}
	
	public int getAction() {
		return action;
	}
	
	public int getIsPublic() {
		return isPublic;
	}
	
	public long getFieldId() {
		return fieldId;
	}
	
	public long getOrganizationId() {
		return organizationId;
	}
	
	public String getDocRelation() {
		return docRelation;
	}
	
	public long[] getTypeIds() {
		return typeIds;
	}
	
	
	public long[] getSignerIds() {
		return signerIds;
	}
	
	public File[] getAttachments() {
		return attachments;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public void setPromulDate(Date promulDate) {
		this.promulDate = promulDate;
	}
	
	public void setEffectivedDate(Date effectivedDate) {
		this.effectivedDate = effectivedDate;
	}
	
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setReplaceDoc(String replaceDoc) {
		this.replaceDoc = replaceDoc;
	}
	
	public void setAction(int action) {
		this.action = action;
	}
	
	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}
	
	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}
	
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	
	public void setDocRelation(String docRelation) {
		this.docRelation = docRelation;
	}
	
	public void setTypeIds(long[] typeIds) {
		this.typeIds = typeIds;
	}
	
	public void setSignerIds(long[] signerIds) {
		this.signerIds = signerIds;
	}
	
	public void setAttachments(File[] attachments) {
		this.attachments = attachments;
	}
	
}
