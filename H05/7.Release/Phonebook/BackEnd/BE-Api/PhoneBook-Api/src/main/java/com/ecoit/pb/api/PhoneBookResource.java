package com.ecoit.pb.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ecoit.pb.object.SearchForm;
import com.ecoit.pb.util.DataResponse;
import com.ecoit.pb.util.DataResponse.DataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ecoit.pb.util.ResponseCode;
import com.ecoit.pb.util.TreeOrg;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;

import organizationalStructure.service.model.UserOrganization;
import organizationalStructure.service.model.organization;
import organizationalStructure.service.service.UserOrganizationLocalServiceUtil;
import organizationalStructure.service.service.organizationLocalServiceUtil;

public class PhoneBookResource {
	private static PhoneBookResource instance = null;
	
	public static PhoneBookResource getInstance() {
		if (instance == null) {
			instance = new PhoneBookResource();
		}
		return instance;
	}
	
	ObjectMapper mapper = new ObjectMapper();
	@POST
	@Path("/search-user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse searchUser(@PathParam("userId") long userId, SearchForm searchForm) {
		try {
			String searchKey = HtmlUtil.escape(searchForm.getSearchKey());
			List<User> usersList = new ArrayList<>();
			if (searchForm.getOrganizationId() > 0) {
				usersList = UserLocalServiceUtil.getOrganizationUsers(searchForm.getOrganizationId());
			} else {
				usersList = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			}
			ArrayNode arrUser = mapper.createArrayNode();
			for (User user : usersList) {
				if (user.getFullName().toLowerCase().contains(searchKey.toLowerCase()) && !user.getDefaultUser() && user.getUserId() != userId) {
					ObjectNode object = mapper.createObjectNode();
					object.put("userId", user.getUserId());
					object.put("fullName", user.getFullName());
					object.put("job", user.getJobTitle());
					String organizationNames = "";
					List<UserOrganization> userOrgList = UserOrganizationLocalServiceUtil.getByUser(user.getUserId());
					for (int i = 0; i < userOrgList.size(); i++) {
						try {
							organization org = organizationLocalServiceUtil.getorganization(userOrgList.get(i).getOrganizationId());
							organizationNames += org.getName();
							if (i < (userOrgList.size() - 1)) {
								organizationNames += ", ";
							}
						} catch (Exception e) {
							
						}

					}
					object.put("organization", organizationNames);
					String phoneNumbers = "";
					for (int i = 0; i < user.getPhones().size(); i++) {
						phoneNumbers += user.getPhones().get(i).getNumber();
						if (i < (user.getPhones().size() - 1)) {
							phoneNumbers += ", ";
						}
					}
					object.put("phoneNumber", phoneNumbers);
					object.put("email", user.getEmailAddress());
					arrUser.addPOJO(object);
					
				}
			}
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrUser, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/{groupId}/all-org")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getSuggestedOrg(@PathParam("groupId") long groupId) {
		try {
			// organization
			TreeOrg treeOrg = new TreeOrg();
			ArrayNode arrOrg = treeOrg.getNodes(0, groupId, treeOrg.NODE_PARENT, "", -1, -1);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrOrg, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	/*@GET
	@Path("/get/item/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse createNewUser(@PathParam("userId") long userId) {
		try {
			User user = UserLocalServiceUtil.getUser(userId);
			UserObject userObject = new UserObject();
			userObject.setFirstName(user.getFirstName());
			userObject.setMiddleName(user.getMiddleName());
			userObject.setLastName(user.getLastName());
			userObject.setBirthDate(user.getBirthday());
			int gender = 1;
		    if (user.getFemale()) {
		    	gender = 2;
		    }
		    userObject.setGender(gender);
		    userObject.setScreenName(user.getScreenName());
		    userObject.setEmail(user.getEmailAddress());
		    userObject.setPasswordReset(user.getPasswordReset());
		    long organizationId = 0;
		    List<UserOrganization> userOrgList = UserOrganizationLocalServiceUtil.getByUser(user.getUserId());
		    if (userOrgList != null && userOrgList.size() > 0) {
		    	organizationId = userOrgList.get(0).getOrganizationId();
		    }
		    userObject.setOrganizationId(organizationId);
		    userObject.setJobTitle(user.getJobTitle());
		    String phoneNumber = "";
		    if (user.getPhones() != null && !user.getPhones().isEmpty()) {
		    	phoneNumber = user.getPhones().get(0).getNumber();
		    }
		    userObject.setPhoneNumber(phoneNumber);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, userObject, DataType.JSON_STR); 
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}*/
	
	/*@POST
	@Path("/create/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse createNewUser(@PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("companyId") long companyId, UserObject userObject) {
		try {
			UserUtil.createUpdateUser(0, userObject, locale, companyId);
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR); 
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update/{locale}/{userId}/{companyId}/{selectedUserId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse updateUser(@PathParam("locale") String locale, @PathParam("userId") long userId, 
			@PathParam("companyId") long companyId, @PathParam("selectedUserId") long selectedUserId, UserObject userObject) {
		try {
			UserUtil.createUpdateUser(selectedUserId, userObject, locale, companyId);
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR); 
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@DELETE
	@Path("/delete/{userId}/{selectedUserId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse updateUser(@PathParam("userId") long userId, @PathParam("selectedUserId") long selectedUserId) {
		try {
			User user = UserLocalServiceUtil.getUser(selectedUserId);
			UserOrganizationLocalServiceUtil.deleteByUserId(user.getUserId());
			
			if (user.getPhones() != null  && !user.getPhones().isEmpty()) {
				for (Phone phone : user.getPhones()) {
					PhoneLocalServiceUtil.deletePhone(phone.getPhoneId());
				}
			}
			
			if (user.getContact() != null) {
				ContactLocalServiceUtil.deleteContact(user.getContact());
			}
			
			UserLocalServiceUtil.deleteUser(selectedUserId);
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR); 
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}*/
}
