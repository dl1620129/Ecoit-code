package com.ecoit.elegal.type.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.ecoit.elegal.type.object.LegalTypeObject;
import com.ecoit.elegal.type.object.TreeTypeObject;
import com.ecoit.elegal.type.utils.TreeLegalType;
import com.ecoit.elegaldocument.model.LegalDTypeRel;
import com.ecoit.elegaldocument.model.LegalType;
import com.ecoit.elegaldocument.service.GroupCategoryLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDTypeRelLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalTypeLocalServiceUtil;
import com.ecoit.elegaldocument.utils.DataResponse;
import com.ecoit.elegaldocument.utils.DocumentPermissionUtil;
import com.ecoit.elegaldocument.utils.DocumentRoleConstants;
import com.ecoit.elegaldocument.utils.ResponseCode;
import com.ecoit.elegaldocument.utils.DataResponse.DataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;


public class LegalTypeResource {
	
	private static LegalTypeResource instance = null;
	
	public static LegalTypeResource getInstance() {
		if (instance == null) {
			instance = new LegalTypeResource();
		}
		return instance;
	}

	@GET
	@Path("/getall/{groupId}/{locale}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("companyId") long companyId, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("") @QueryParam("q") String q) {
		try {
			locale = HtmlUtil.escape(locale);
            q = HtmlUtil.escape(q).trim();
			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			TreeLegalType treeType = new TreeLegalType();
			List<TreeTypeObject> treeList = treeType.getLegalTypeNodes(0, groupId, companyId, locale, "", 0, -1);
			List<TreeTypeObject> filteredList = new ArrayList<>();
			if (!q.equalsIgnoreCase("")) {
				filteredList = treeType.filterNodes(q, treeList);
			} else {
				filteredList = treeList;
			}
			/*int count = LegalTypeLocalServiceUtil.getNodeCount(0, groupId, companyId, locale, q);
			ObjectNode node = mapper.createObjectNode();
			node.put("total", count);
			node.putPOJO("data", arrayNode);*/

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, filteredList, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/getall/types/{locale}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAllTypes(@PathParam("locale") String locale, @PathParam("groupId") long groupId) {
		try {
			TreeLegalType treeType = new TreeLegalType();
			ArrayNode arrayNode = treeType.getPublishNodes(0, locale, groupId);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/item/{legalTypeId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getItem(@PathParam("legalTypeId") long legalTypeId) {
		try {
			if (legalTypeId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			LegalType legalType = LegalTypeLocalServiceUtil.getLegalType(legalTypeId);
			LegalTypeObject object = new LegalTypeObject();
			object.setTypeId(legalType.getTypeId());
			object.setName(HtmlUtil.extractText(legalType.getName()));
			object.setDescription(HtmlUtil.extractText(legalType.getDescription()));
			object.setStatusType(legalType.getStatusType());
			object.setPosition(legalType.getPosition());
			object.setParentId(legalType.getParentId());		
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, object, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse create(@PathParam("groupId") long groupId, @PathParam("companyId") long companyId,
			@PathParam("locale") String locale, @PathParam("userId") long userId, LegalTypeObject legalTypeObject) {
		try {
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_CATEGORY)) {
				locale = HtmlUtil.escape(locale);
				String name = HtmlUtil.escape(legalTypeObject.getName());
				String description = HtmlUtil.escape(legalTypeObject.getDescription());
				int position = legalTypeObject.getPosition();
				long parentId = legalTypeObject.getParentId();

				if (parentId < 0) parentId = 0;
				if (groupId < 0 || locale.isEmpty() || userId < 0 || companyId < 0 || position < 0 || name.isEmpty()) {
					return DataResponse.PARAM_ERROR;
				}

				LegalTypeLocalServiceUtil.createUpdateLegalType(-1, groupId, companyId, userId, name, description, locale, legalTypeObject.isStatusType(), position, parentId);

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update/{groupId}/{locale}/{userId}/{companyId}/{legalTypeId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse update(@PathParam("groupId") long groupId, @PathParam("companyId") long companyId, @PathParam("locale") String locale, 
			@PathParam("userId") long userId, @PathParam("legalTypeId") long legalTypeId, LegalTypeObject legalTypeObject) {
		try {
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_CATEGORY)) {
				locale = HtmlUtil.escape(locale);
				String name = HtmlUtil.escape(legalTypeObject.getName());
				String description = HtmlUtil.escape(legalTypeObject.getDescription());
				int position = legalTypeObject.getPosition();
				long parentId = legalTypeObject.getParentId();

				if (parentId < 0) parentId = 0;
				if (groupId < 0 || locale.isEmpty() || userId < 0 || companyId < 0 || position < 0 || name.isEmpty()) {
					return DataResponse.PARAM_ERROR;
				}

				LegalTypeLocalServiceUtil.createUpdateLegalType(legalTypeId, groupId, companyId, userId, name, description, locale, legalTypeObject.isStatusType(), position, parentId);

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/max-order-number/{groupId}/{locale}/{companyId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getMaxOrderNumber(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("parentId") long parentId, @PathParam("companyId") long companyId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || parentId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			int max = LegalTypeLocalServiceUtil.getMax(locale, groupId, parentId, companyId);
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node = mapper.createObjectNode();
			node.put("maxOrderNumber", max);
			if (max >= 0) {
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
			} else {
				return DataResponse.FAILED;
			}
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/delete/{groupId}/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse Delete(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("companyId") long companyId, @Context HttpServletRequest request) {
		try {
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_CATEGORY)) {
				locale = HtmlUtil.escape(locale);
				long[] legalTypeIdList = ParamUtil.getLongValues(request, "legalTypeId");
				if (groupId < 0 || locale.isEmpty() || legalTypeIdList == null || legalTypeIdList.length <= 0) {
					return DataResponse.PARAM_ERROR;
				}
				
				for (long legalTypeId : legalTypeIdList) {
					List<LegalDTypeRel> relsList = LegalDTypeRelLocalServiceUtil.getByTypeId(legalTypeId);
		            if (relsList != null && relsList.size() > 0) {
		            	return DataResponse.CONFLICT_ERROR;
		            }
		            
					TreeLegalType treeLegalType = new TreeLegalType();
					List<Long> listTypeIds = treeLegalType.getListLegalTypeIds(legalTypeId, groupId, companyId, locale);
					if (listTypeIds != null && listTypeIds.size() > 0) {
						for (Long childTypeId : listTypeIds) {
							LegalTypeLocalServiceUtil.deleteLegalType(childTypeId);
							GroupCategoryLocalServiceUtil.removeByCategoryId(childTypeId);
						}
					}
					LegalTypeLocalServiceUtil.deleteLegalType(legalTypeId);
					GroupCategoryLocalServiceUtil.removeByCategoryId(legalTypeId);
					LegalDTypeRelLocalServiceUtil.removeByTypeId(legalTypeId);
				}
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
            return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
