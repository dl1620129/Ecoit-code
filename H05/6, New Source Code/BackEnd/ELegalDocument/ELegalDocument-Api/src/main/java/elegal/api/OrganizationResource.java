package elegal.api;

import com.ecoit.elegaldocument.model.LegalDocument;
import com.ecoit.elegaldocument.model.LegalOrg;
import com.ecoit.elegaldocument.service.GroupOrganizationLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDocumentLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalOrgLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalOrgServiceUtil;
import com.ecoit.elegaldocument.utils.DataResponse;
import com.ecoit.elegaldocument.utils.DocumentPermissionUtil;
import com.ecoit.elegaldocument.utils.DocumentRoleConstants;
import com.ecoit.elegaldocument.utils.DataResponse.DataType;
import com.ecoit.elegaldocument.utils.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import elegal.object.OrganObject;
import elegal.object.TreeOrgObject;
import elegal.utils.TreeOrg;

@Path("/organization")
public class OrganizationResource {
	private static OrganizationResource instance = null;

	public static OrganizationResource getInstance() {
		if (instance == null) {
			instance = new OrganizationResource();
		}
		return instance;
	}

	@GET
	@Path("/getall/{groupId}/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Get(@PathParam("groupId") long groupId, @PathParam("locale") String locale,@PathParam("userId") long userId, 
			@PathParam("companyId") long companyId, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("") @QueryParam("q") String q) {
		try {
			locale = HtmlUtil.escape(locale);
            q = HtmlUtil.escape(q).trim();
			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			TreeOrg treeOrg = new TreeOrg();
			List<TreeOrgObject> orgsList = treeOrg.getNodes(0, groupId, companyId, locale, q, 0, -1, 0);
			List<TreeOrgObject> filteredList = new ArrayList<>();
			if (!q.equalsIgnoreCase("")) {
				filteredList = treeOrg.filterNodes(q, orgsList);
			} else {
				filteredList = orgsList;
			}
			
			/*int count = filteredList.size();
			ObjectNode node = mapper.createObjectNode();
			node.put("total", count);
			node.putPOJO("data", orgsList);*/

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, filteredList, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	/*@GET
	@Path("/getall/orgs/{locale}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAllTypes(@PathParam("locale") String locale, @PathParam("groupId") long groupId) {
		try {
			TreeOrg treeOrg = new TreeOrg();
			ArrayNode arrayNode = treeOrg.getPublishNodes(0, locale, groupId);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}*/
	
	@GET
	@Path("/get/item/{orgId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getOrganizationDetail(@PathParam("orgId") long orgId) {
		try {
			if (orgId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			LegalOrg org = LegalOrgServiceUtil.getOrg(orgId);
			ObjectNode res = JsonNodeFactory.instance.objectNode();
			res.put("organizationId", org.getOrganizationId());
			res.put("parentId", org.getParentId());	
			res.put("name", HtmlUtil.extractText(org.getName()));
			res.put("description", HtmlUtil.extractText(org.getDescription()));
			res.put("statusOrg", org.isStatusOrg());
			res.put("position", org.getPosition());
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, res, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/get/max-order-number/{groupId}/{locale}/{companyId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetMaxOrderNumber(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("parentId") long parentId, @PathParam("companyId") long companyId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || parentId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			int max = LegalOrgServiceUtil.getMax(locale, groupId, parentId, companyId);
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
	@Path("/create/{groupId}/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Create(@PathParam("groupId") long groupId, @PathParam("companyId") long companyId,
			@PathParam("locale") String locale, @PathParam("userId") long userId, OrganObject organObject) {
		try {
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_ORGANIZATION)) {
				locale = HtmlUtil.escape(locale);
				String name = HtmlUtil.escape(organObject.getName());
				String description = HtmlUtil.escape(organObject.getDescription());
				boolean statusorg = organObject.isStatus();
				int position = organObject.getPosition();
				long parentId = organObject.getParentId();

				if (parentId < 0)
					parentId = 0;
				if (groupId < 0 || locale.isEmpty() || userId < 0 || companyId < 0 || position < 0 || name.isEmpty()) {
					return DataResponse.PARAM_ERROR;
				}
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode node = mapper.createObjectNode();

				LegalOrg addLegalOrg = LegalOrgServiceUtil.addLegalOrg(groupId, companyId, userId, userId, name,
						description, locale, statusorg, false, position, parentId);
				
				node.putPOJO("data", addLegalOrg.getModelAttributes());

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, addLegalOrg.getModelAttributes(), DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@PUT
	@Path("/update/{groupId}/{locale}/{userId}/{orgId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Update(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("orgId") long orgId, OrganObject organObject) {
		try {
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_ORGANIZATION)) {
				locale = HtmlUtil.escape(locale);
				String name = HtmlUtil.escape(organObject.getName());
				String description = HtmlUtil.escape(organObject.getDescription());
				boolean statusOrg = organObject.isStatus();
				int position = organObject.getPosition();
				long parentId = organObject.getParentId();
				
				if (groupId < 0 || locale.isEmpty() || orgId < 0) {
					return DataResponse.PARAM_ERROR;
				}
				
				LegalOrg org = LegalOrgServiceUtil.getOrg(orgId);
				Date date = new Date();
				org.setName(name);
				org.setDescription(description);
				org.setStatusOrg(statusOrg);
				org.setPosition(position);
				org.setParentId(parentId);
				org.setModifiedByUser(userId);
				org.setModifiedDate(date);
				LegalOrgLocalServiceUtil.updateLegalOrg(org);
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
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
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_ORGANIZATION)) {
				locale = HtmlUtil.escape(locale);
				if (groupId < 0 || locale.isEmpty()) {
					return DataResponse.PARAM_ERROR;
				}
	               		
                long[] legalOrgIdList = ParamUtil.getLongValues(request, "organizationId");   
        		if (legalOrgIdList == null || legalOrgIdList.length <= 0) {
        			return DataResponse.PARAM_ERROR;
        		}
        		
        		for (long orgId : legalOrgIdList) {   		
    				List<LegalDocument> legalDocsList = LegalDocumentLocalServiceUtil.getByOrgId(orgId);
    				if (legalDocsList != null && legalDocsList.size() > 0) {
    					return DataResponse.CONFLICT_ERROR;
    				}
    				
    				TreeOrg treeOrg = new TreeOrg();
    				List<Long> listOrgIds = treeOrg.getListLegalOrgIds(orgId, groupId, companyId, locale);
    				if (listOrgIds != null && listOrgIds.size() > 0) {
    					for (Long childOrgId : listOrgIds) {
    						LegalOrgLocalServiceUtil.deleteLegalOrg(childOrgId);
    						GroupOrganizationLocalServiceUtil.removeByOrganizationId(childOrgId);
    					}
    				}
    				LegalOrgLocalServiceUtil.deleteLegalOrg(orgId);
    				GroupOrganizationLocalServiceUtil.removeByOrganizationId(orgId);
        		}

				//LegalDocumentLocalServiceUtil.resetOrganizationId(orgId);
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
            return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
