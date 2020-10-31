package ChungThuSo.api.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import ChungThuSo.Service.model.Kyso;
import ChungThuSo.Service.service.KysoLocalServiceUtil;
import ChungThuSo.Service.service.util.DataRespone;
import ChungThuSo.Service.service.util.DataRespone.DataType;
import ChungThuSo.Service.service.util.ResponeCode;
import ChungThuSo.api.object.ChungThuSoObject;

public class ChungThuSoApi {

	private static ChungThuSoApi instance = null;

	public static ChungThuSoApi getInstance() {
		if (instance == null) {
			instance = new ChungThuSoApi();
		}
		return instance;
	}
	@POST
	@Path("/create/{groupId}/{userId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone createKyso(@PathParam("groupId") long groupId,@PathParam("userId") long userId,
			@Context HttpServletRequest request) {
	
		try {
			
			String rawData=HtmlUtil.escape(ParamUtil.getString(request,"rawData",""));
			String screenName=HtmlUtil.escape(ParamUtil.getString(request,"screenName",""));
			String details=HtmlUtil.escape(ParamUtil.getString(request,"details",""));
			String serialNumber=HtmlUtil.escape(ParamUtil.getString(request,"serialNumber",""));
			String organization=HtmlUtil.escape(ParamUtil.getString(request,"organization",""));
			String userName=HtmlUtil.escape(ParamUtil.getString(request,"userName",""));
			long createUserId=ParamUtil.getLong(request,"createUserId",0);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate=ParamUtil.getDate(request,"fromDate",dateFormat);
			Date toDate=ParamUtil.getDate(request,"toDate",dateFormat);
			if(KysoLocalServiceUtil.getCountSerialNumber(groupId, serialNumber)>0) {
				return new DataRespone(ResponeCode.PARAM_ERROR,ResponeCode.PARAM_ERROR, "serial number da ton tai", DataType.JSON_STR);
			}
			Kyso kyso = KysoLocalServiceUtil.createKyso(0);
			if(screenName != null && !screenName.equals("")) {
				kyso.setGroupId(groupId);
				kyso.setUserId(userId);
				kyso.setRawData(rawData);
				kyso.setSerialNumber(serialNumber);
				kyso.setUserName(userName);
				kyso.setOrganization(organization);
				kyso.setFromDate(fromDate);
				kyso.setToDate(toDate);
				kyso.setDetails(details);
				kyso.setScreenName(screenName);
				kyso.setCreateUserId(createUserId);
				kyso= KysoLocalServiceUtil.addKyso(kyso);
			}else {
				return new DataRespone(ResponeCode.PARAM_ERROR,ResponeCode.PARAM_ERROR, "", DataType.JSON_STR);
			}
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
	}
	@PUT
	@Path("/update/{groupId}/{userId}/{sn}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone updateKySo(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("sn") String sn,
			@Context HttpServletRequest request) {
	
		try {
			Kyso kyso = KysoLocalServiceUtil.findBygetByScreenName(sn);
			String rawData=HtmlUtil.escape(ParamUtil.getString(request,"rawData",""));
			String screenName=HtmlUtil.escape(ParamUtil.getString(request,"screenName",""));
			String userName=HtmlUtil.escape(ParamUtil.getString(request,"userName",""));
			String details=HtmlUtil.escape(ParamUtil.getString(request,"details",""));
			String serialNumber=HtmlUtil.escape(ParamUtil.getString(request,"serialNumber",""));
			String organization=HtmlUtil.escape(ParamUtil.getString(request,"organization",""));
			long createUserId=ParamUtil.getLong(request,"createUserId",0);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate=ParamUtil.getDate(request,"fromDate",dateFormat);
			Date toDate=ParamUtil.getDate(request,"toDate",dateFormat);
			if(screenName != null && !screenName.equals("")) {
				kyso.setGroupId(groupId);
				kyso.setUserId(userId);
				kyso.setUserName(userName);
				kyso.setRawData(rawData);
				kyso.setSerialNumber(serialNumber);
				kyso.setOrganization(organization);
				kyso.setFromDate(fromDate);
				kyso.setToDate(toDate);
				kyso.setDetails(details);
				kyso.setScreenName(screenName);
				kyso.setCreateUserId(createUserId);
				kyso= KysoLocalServiceUtil.updateKyso(kyso);
			}else {
				return new DataRespone(ResponeCode.PARAM_ERROR,ResponeCode.PARAM_ERROR, "", DataType.JSON_STR);
			}
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			e.printStackTrace();
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
	}
	@GET
	@Path("/getKyso/{groupId}/{userId}/{sn}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getKySo(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("sn") String sn,
			@Context HttpServletRequest request) {
		try {
			Kyso kyso= KysoLocalServiceUtil.findBygetByScreenName(sn);
			if(kyso==null) {
				return DataRespone.PARAM_ERROR;
			}
			ChungThuSoObject chungThuSoObject= new ChungThuSoObject(kyso.getKysoId(), kyso.getGroupId(), kyso.getCompanyId(), kyso.getUserId(),kyso.getUserName(), kyso.getScreenName(), kyso.getCreateDate(), kyso.getModifiedDate(), kyso.getRawData(), kyso.getSerialNumber(), kyso.getOrganization(), kyso.getCreateUserId(), kyso.getFromDate(), kyso.getToDate());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, chungThuSoObject, DataType.JSON_STR);
		} catch (Exception e) {
		
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, "data null", DataType.JSON_STR);

		}
	}
	@GET
	@Path("/getKySoBySerialNumber/{serialnumber}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getKySoBySerialNumber(@PathParam("serialnumber") String serialnumber,
			@Context HttpServletRequest request) {
		try {
			Kyso kyso= KysoLocalServiceUtil.findBygetBySerialNumber(serialnumber);
			if(kyso==null) {
				return DataRespone.PARAM_ERROR;
			}
			ChungThuSoObject chungThuSoObject= new ChungThuSoObject(kyso.getKysoId(), kyso.getGroupId(), kyso.getCompanyId(), kyso.getUserId(),kyso.getUserName(), kyso.getScreenName(), kyso.getCreateDate(), kyso.getModifiedDate(), kyso.getRawData(), kyso.getSerialNumber(), kyso.getOrganization(), kyso.getCreateUserId(), kyso.getFromDate(), kyso.getToDate());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, chungThuSoObject, DataType.JSON_STR);
		} catch (Exception e) {
		
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, "data null", DataType.JSON_STR);

		}
	}
	@DELETE
	@Path("/delete/{sn}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone delteKySo(@PathParam("sn") String sn) {
		try {
			Kyso kyso= KysoLocalServiceUtil.findBygetByScreenName(sn);
			if(kyso==null) {
				return DataRespone.PARAM_ERROR;
			}
			KysoLocalServiceUtil.deleteKyso(kyso);
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
		
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, "data null", DataType.JSON_STR);

		}
	}
}
