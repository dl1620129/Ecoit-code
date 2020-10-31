package adv.manager.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import adv.api.utils.DataResponse;
import adv.api.utils.ResponseCode;
import adv.api.utils.DataResponse.DataType;
import adv.manager.utils.AdvManagerConstant;
import adv.manager.utils.FileUtils;
import adv.model.QuangCao;
import adv.service.QuangCaoLocalServiceUtil;

public class AdvResource {
	private static AdvResource instance = null;

	public static AdvResource getInstance() {
		if (instance == null) {
			instance = new AdvResource();
		}
		return instance;
	}

	@GET
	@Path("/getall/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetSubSite(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("") @QueryParam("q") String q) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node = mapper.createObjectNode();

			List<QuangCao> allAdv = QuangCaoLocalServiceUtil.getAllAdv(groupId, start, limit, locale, q);
			int countAbv = QuangCaoLocalServiceUtil.countAbv(groupId, locale, q);
			ArrayNode arrayNode = mapper.createArrayNode();
			for (QuangCao quangCao : allAdv) {

				Map<String, Object> map = quangCao.getModelAttributes();
				if (quangCao.getImageId() > 0) {
					String urlFileEntry = FileUtils.getUrlFileEntry(quangCao.getImageId(), groupId);
					map.put("imageUrl", urlFileEntry);
				}
				arrayNode.addPOJO(map);
			}

			node.put("total", countAbv);
			node.putPOJO("data", arrayNode);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/get/item/{groupId}/{advId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAdvertisement(@PathParam("groupId") long groupId, @PathParam("advId") long advId) {
		try {
			
			if (advId < 0 || groupId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			QuangCao quangCao = QuangCaoLocalServiceUtil.getQuangCao(advId);
			ObjectNode res = JsonNodeFactory.instance.objectNode();
			res.put("quangCaoId", quangCao.getQuangCaoId());
			res.put("tenQuangCao", quangCao.getTenQuangCao());
			res.put("moTa", quangCao.getMoTa());
			res.put("url", quangCao.getUrl());
			if (quangCao.getImageId() > 0) {
				res.put("imageId", quangCao.getImageId());
				String urlFileEntry = FileUtils.getUrlFileEntry(quangCao.getImageId(), groupId);
				res.put("imageUrl", urlFileEntry);
			}

			res.put("target", quangCao.getTarget());
			boolean isShow = false;
			if (quangCao.getStatus() == AdvManagerConstant.ADV_STATUS_SHOW) {
				isShow = true;
			}
			res.put("isShow", isShow);
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, res, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}
	
	@POST
	@Path("/update/{groupId}/{locale}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse UpdateAdv(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@DefaultValue("-1") @QueryParam("advId") long advId, @PathParam("userId") long userId,
			@Context HttpServletRequest request) {
		try {
			locale = HtmlUtil.escape(locale);

			String nameAdv = HtmlUtil.escape(ParamUtil.getString(request, "nameAdv", ""));
			String description = HtmlUtil.escape(ParamUtil.getString(request, "description", ""));
			boolean target = ParamUtil.getBoolean(request, "target", false);
			String url = HtmlUtil.escapeURL(ParamUtil.getString(request, "url", ""));
			boolean isShow = ParamUtil.getBoolean(request, "isShow", true);
			int status = AdvManagerConstant.ADV_STATUS_SHOW;
			long imageId = 0;

			if (groupId < 0 || locale.isEmpty() || nameAdv.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node = mapper.createObjectNode();

			try {
				imageId = FileUtils.uploadGuest(request, "imageId", "Image_Quang_Cao", groupId, userId)
						.getFileEntryId();
			} catch (Exception e) {
				imageId = 0;
			}
			System.out.println("imageId: " + imageId);
			if (!isShow)
				status = AdvManagerConstant.ADV_STATUS_HIDE;

			if (advId == -1) {
				long qCId = CounterLocalServiceUtil.increment(QuangCao.class.getName());
				QuangCao quangCao = QuangCaoLocalServiceUtil.createQuangCao(0);
				quangCao.setQuangCaoId(qCId);
				quangCao.setTenQuangCao(nameAdv);
				quangCao.setImageId(imageId);
				quangCao.setMoTa(description);
				quangCao.setUrl(url);
				quangCao.setTarget(target);
				quangCao.setGroupId(groupId);
				quangCao.setCreateDate(new Date());
				quangCao.setLanguage(locale);
				quangCao.setUserId(userId);
				quangCao.setStatus(status);
				QuangCaoLocalServiceUtil.addQuangCao(quangCao);

				node.putPOJO("data", quangCao.getModelAttributes());
			} else if (advId > 0) {
				QuangCao quangCao = QuangCaoLocalServiceUtil.getQuangCao(advId);
				if (imageId > 0) {
					if (quangCao.getImageId() > 0) {
						FileUtils.XoaFile(quangCao.getImageId());
					}
					quangCao.setImageId(imageId);
				}
				quangCao.setTenQuangCao(nameAdv);
				quangCao.setMoTa(description);
				quangCao.setUrl(url);
				quangCao.setTarget(target);
				quangCao.setModifiedDate(new Date());
				quangCao.setGroupId(groupId);
				quangCao.setLanguage(locale);
				quangCao.setStatus(status);
				QuangCaoLocalServiceUtil.updateQuangCao(quangCao);

				node.putPOJO("data", quangCao.getModelAttributes());
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@DELETE
	@Path("/delete/{advId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse DeleteAdv(@DefaultValue("-1") @PathParam("advId") long advId) {
		try {

			if (advId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			QuangCao quangCao = QuangCaoLocalServiceUtil.getQuangCao(advId);
			if (quangCao.getImageId() > 0) {
				FileUtils.XoaFile(quangCao.getImageId());
			}
			QuangCaoLocalServiceUtil.deleteQuangCao(quangCao);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@DELETE
	@Path("/delete/image/{advId}/{imageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse DeleteAdvImage(@DefaultValue("-1") @PathParam("advId") long advId,
			@DefaultValue("-1") @PathParam("imageId") long imageId) {
		try {

			if (advId < 0 || imageId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			QuangCao quangCao = QuangCaoLocalServiceUtil.getQuangCao(advId);
			if (quangCao.getImageId() == imageId) {
				FileUtils.XoaFile(imageId);
				quangCao.setImageId(0);
				QuangCaoLocalServiceUtil.updateQuangCao(quangCao);
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

}
