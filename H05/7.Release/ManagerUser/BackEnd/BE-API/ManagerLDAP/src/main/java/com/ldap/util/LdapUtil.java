package com.ldap.util;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;

public class LdapUtil {
	public static String[] returnAttributes = {"zimbraIsSystemResource", "uid", "givenName", "sn", "cn", "status", "displayName","mail","mobile","title", "zimbraAccountStatus" };
	public static String[] returnAttributesLogin = { "uid","userPassword"};
	public static  String filter = "(objectClass=inetOrgPerson)";
	
	public static Hashtable<Object, Object> initLDAP() {
		Hashtable<Object, Object> env = new Hashtable<Object, Object>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, URL_PUBLIC());
		env.put(Context.SECURITY_AUTHENTICATION, CONNTENTTYPE());
		env.put(Context.SECURITY_PRINCIPAL, ADMINDN());
		env.put(Context.SECURITY_CREDENTIALS, PASSWORD());
		return env;
	}
	public static String URL_PUBLIC() {
		return GetterUtil.getString(PropsUtil.get("ldap.url.custom"));
	}
	public static String CONNTENTTYPE() {
		return GetterUtil.getString(PropsUtil.get("ldap.authen.custom"));
	}
	public static String ADMINDN() {
		return GetterUtil.getString(PropsUtil.get("ldap.user.custom"));
	}
	public static String PASSWORD() {
		return GetterUtil.getString(PropsUtil.get("ldap.pass.custom"));
	}
	public static String DOMAIN() {
		return GetterUtil.getString(PropsUtil.get("ldap.domain.custom"));
	}
	public static String OU_USER() {
		return GetterUtil.getString(PropsUtil.get("ldap.ou.user.custom"));
	}
	public static String OU_ORG() {
		return GetterUtil.getString(PropsUtil.get("ldap.ou.org.custom"));
	}
	
	public static String getFirstName(String fullName) {
		int lastSpaceIndex = fullName.indexOf(" ");
		if (lastSpaceIndex == -1)
			return fullName;
		else
			return fullName.substring(0, lastSpaceIndex);
	}

	public static String getLastName(String fullName) {
		int lastSpaceIndex = fullName.lastIndexOf(" ");
		if (lastSpaceIndex == -1)
			return fullName;
		else
			return fullName.substring(lastSpaceIndex + 1);
	}

	public static String getMiddleName(String fullName) {
		int firstSpace = fullName.indexOf(" ");
		int lastSpace = fullName.lastIndexOf(" ");
		int lastSpaceIndex = fullName.lastIndexOf(" ");
		if (lastSpaceIndex == -1)
			return fullName;
		else
			return fullName.substring(firstSpace, lastSpace);
	}
	
	public static long getUserIdAdmin(long companyId) {
		long adminUserId = 0;
		List<Role> lstRole = RoleLocalServiceUtil.getRoles(companyId);
		for (Role role : lstRole) {
			if (role.getName().toLowerCase().equals("administrator")) {
				System.out.println(role.getName());
				List<User> lstUser = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
				if (lstUser != null && lstUser.size() > 0) {
					adminUserId = lstUser.get(0).getUserId();
					break;
				}
			}
		}
		return adminUserId;
	}
}
