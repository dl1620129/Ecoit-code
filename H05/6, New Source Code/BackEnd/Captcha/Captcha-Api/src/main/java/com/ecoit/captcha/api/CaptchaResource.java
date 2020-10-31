package com.ecoit.captcha.api;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.ecoit.captcha.utils.DataResponse;
import com.ecoit.captcha.utils.DataResponse.DataType;
import com.ecoit.captcha.utils.ResponseCode;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.servlet.PortalSessionThreadLocal;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;


public class CaptchaResource {
	private static CaptchaResource instance;

	public static CaptchaResource getInstance() {
		if (instance == null) {
			instance = new CaptchaResource();
		}
		return instance;
	}
	
	@GET
	@Path("/get-captcha")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCaptcha(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			CaptchaUtil.serveImage(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("/validate-captcha")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse validateCaptcha(@Context HttpServletRequest request) {
		try {
			boolean matchedCaptcha = false;
			//HttpSession session = PortalSessionThreadLocal.getHttpSession();
			HttpSession session = request.getSession();
			String captchaText = getCaptchaText(session);
            System.out.println("Captcha text: " + captchaText);
			String userEnteredCaptcha = HtmlUtil.escape(ParamUtil.getString(request, "captchaText"));
			if (Validator.isNotNull(captchaText)) {
				if (userEnteredCaptcha.equals(captchaText)) {
					matchedCaptcha = true;
				}
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, matchedCaptcha, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	/*code for getting loaded captcha text from session*/
	private String getCaptchaText(HttpSession session) {
        Enumeration<String> atNames = session.getAttributeNames();
        System.out.println("Attribute Name size: " + session.getAttribute(WebKeys.CAPTCHA_TEXT));
        while (atNames.hasMoreElements()) {
            String name = atNames.nextElement();
            System.out.println("Attribute Name: " + name);
            if (name.toUpperCase().contains(WebKeys.CAPTCHA_TEXT)) {
                String captchaValueFromSession = (String) session.getAttribute(name);
                return captchaValueFromSession;
            }
        }
        return null;
	}
}
