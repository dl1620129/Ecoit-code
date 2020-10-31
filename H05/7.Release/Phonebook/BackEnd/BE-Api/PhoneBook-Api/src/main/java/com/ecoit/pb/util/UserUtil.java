package com.ecoit.pb.util;

import java.util.Date;

import com.ecoit.pb.object.UserObject;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;

import organizationalStructure.service.model.organization;
import organizationalStructure.service.service.UserOrganizationLocalServiceUtil;
import organizationalStructure.service.service.organizationLocalServiceUtil;

public class UserUtil {

	public static void createUpdateUser(long newUserId, UserObject userObject, String locale, long companyId) throws Exception {
		String firstName = HtmlUtil.escape(userObject.getFirstName());
		String middleName = HtmlUtil.escape(userObject.getMiddleName());
		String lastName = HtmlUtil.escape(userObject.getLastName());
		String screenName = HtmlUtil.escape(userObject.getScreenName());
		String email = HtmlUtil.escape(userObject.getEmail());
		String password = HtmlUtil.escape(userObject.getPassword());
		String jobTitle = HtmlUtil.escape(userObject.getJobTitle());
		String phoneNumber = HtmlUtil.escape(userObject.getPhoneNumber());

		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(newUserId);
		} catch (Exception e) {
			
		}
		
		if (user == null) {
			newUserId = CounterLocalServiceUtil.increment();
			user = UserLocalServiceUtil.createUser(newUserId);		
		}
		
		user.setCompanyId(companyId);
		user.setLanguageId(locale);
		user.setCreateDate(new Date());
		user.setModifiedDate(new Date());
		user.setFirstName(firstName);
		user.setMiddleName(middleName);
		user.setLastName(lastName);
		
		Contact contact = null;
		try {
			contact = user.getContact();
		} catch (Exception e) {
			
		}
		
		if (contact == null) {
			long contactId = CounterLocalServiceUtil.increment();
			contact = ContactLocalServiceUtil.createContact(contactId);
			contact.setEmailAddress(email);
			contact.setFirstName(firstName);
			contact.setMiddleName(middleName);
			contact.setLastName(lastName);
			contact.setJobTitle(jobTitle);
			contact.setUserId(newUserId);
			user.setContactId(contactId);
		}
		
		if (userObject.getGender() == 1) {
			contact.setMale(true);
		} else {
			contact.setMale(false);
		}
		
		contact.setBirthday(userObject.getBirthDate());
		user.setScreenName(screenName);
		user.setEmailAddress(email);
		user.setPassword(password);
		user.setPasswordReset(userObject.isPasswordReset());

		user.setJobTitle(jobTitle);
		
		Phone phone = null;
		if (user.getPhones() != null && user.getPhones().size() > 0) {
			phone = user.getPhones().get(0);
		} else {
			long phoneId = CounterLocalServiceUtil.increment();			
			//add phone number
			phone = PhoneLocalServiceUtil.createPhone(phoneId);
			phone.setUserId(newUserId);
			phone.setCompanyId(companyId);
			phone.setPrimary(true);
			long classId = ClassNameLocalServiceUtil.getClassNameId(Contact.class.getName());
			phone.setClassNameId(classId);
			phone.setClassName(Contact.class.getName());
			phone.setClassPK(contact.getContactId());
			phone.setPrimary(true);
		}
		phone.setNumber(phoneNumber);
		ContactLocalServiceUtil.updateContact(contact);
		PhoneLocalServiceUtil.updatePhone(phone);
		
		UserLocalServiceUtil.updateUser(user);
		
		organization newOrganization = null;
		try {
			newOrganization = organizationLocalServiceUtil.getorganization(userObject.getOrganizationId());
		} catch (Exception e) {
			
		}
		
		if (newOrganization != null) {
			UserOrganizationLocalServiceUtil.deleteByUserId(user.getUserId());
			UserOrganizationLocalServiceUtil.createUserOrganization(user.getUserId(), userObject.getOrganizationId());
		}
	}
}
