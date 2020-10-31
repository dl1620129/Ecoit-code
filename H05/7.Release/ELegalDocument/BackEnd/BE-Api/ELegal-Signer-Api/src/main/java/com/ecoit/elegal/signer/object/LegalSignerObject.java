package com.ecoit.elegal.signer.object;

public class LegalSignerObject {

	private long sigId;
	private String firstName;
	private String lastName;
	private String language;
	private boolean statusSigner;
	private String fullName;
	
	public LegalSignerObject() {
		// TODO Auto-generated constructor stub
	}
	
	public long getSigId() {
		return sigId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public boolean isStatusSigner() {
		return statusSigner;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setSigId(long sigId) {
		this.sigId = sigId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public void setStatusSigner(boolean statusSigner) {
		this.statusSigner = statusSigner;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
