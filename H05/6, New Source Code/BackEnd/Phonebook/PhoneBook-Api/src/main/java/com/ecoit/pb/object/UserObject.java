package com.ecoit.pb.object;

import java.util.Date;

public class UserObject {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private int gender;
    private String screenName;
    private String email;
    private String password;
    private boolean passwordReset;
    private long organizationId;
    private String jobTitle;
    private String phoneNumber;
    
    public UserObject() {
	}
    
    public Date getBirthDate() {
		return birthDate;
	}
    
    public String getFirstName() {
		return firstName;
	}
    
    public String getMiddleName() {
		return middleName;
	}
    
    public String getLastName() {
		return lastName;
	}
    
    public int getGender() {
		return gender;
	}
    
    public String getScreenName() {
		return screenName;
	}
    
    public String getEmail() {
		return email;
	}
    
    public String getPassword() {
		return password;
	}
    
    public boolean isPasswordReset() {
		return passwordReset;
	}
    
    public long getOrganizationId() {
		return organizationId;
	}
    
    public String getJobTitle() {
		return jobTitle;
	}
    
    public String getPhoneNumber() {
		return phoneNumber;
	}
    
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
    public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
    
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
    
    public void setGender(int gender) {
		this.gender = gender;
	}
    
    public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
    
    public void setEmail(String email) {
		this.email = email;
	}
    
    public void setPassword(String password) {
		this.password = password;
	}
    
    public void setPasswordReset(boolean passwordReset) {
		this.passwordReset = passwordReset;
	}
    
    public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
    
    public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
    
    public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
