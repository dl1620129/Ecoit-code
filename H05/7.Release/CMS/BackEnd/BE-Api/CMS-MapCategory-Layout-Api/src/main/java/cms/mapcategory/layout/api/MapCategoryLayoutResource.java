package cms.mapcategory.layout.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.software.cms.model.Category;
import com.software.cms.model.MapCateLayout;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.cms.service.MapCateLayoutLocalServiceUtil;
import com.software.util.DataResponse;
import com.software.util.PermissionUtil;
import com.software.util.ResponseCode;
import com.software.util.RoleConstants;
import com.software.util.DataResponse.DataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import cms.mapcategory.layout.object.MapCategoryLayoutObject;
import cms.mapcategory.layout.utils.TreeCategory;

public class MapCategoryLayoutResource {
	private static MapCategoryLayoutResource instance = null;

	public static MapCategoryLayoutResource getInstance() {
		if (instance == null) {
			instance = new MapCategoryLayoutResource();
		}
		return instance;
	}

	@GET
	@Path("/getall/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetAll(@PathParam("groupId") long groupId, @DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("0") @QueryParam("start") int start, @PathParam("locale") String locale) {
		try {
			locale = HtmlUtil.escape(locale);
			if (groupId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectNode = mapper.createObjectNode();

			List<MapCateLayout> listMapCateLayout = MapCateLayoutLocalServiceUtil.getListMapCateLayout(groupId, -1,
					start, limit);
			int total = MapCateLayoutLocalServiceUtil.countMapCateLayout(groupId, -1);
			if (total == -1) {
				return DataResponse.FAILED;
			}
			List<MapCategoryLayoutObject> categoryLayoutObjects = new ArrayList<>();
			for (MapCateLayout mapCateLayout : listMapCateLayout) {
				Category category = CategoryLocalServiceUtil.getCategory(mapCateLayout.getCategoryId());
				String layoutName = LayoutLocalServiceUtil.getLayout(mapCateLayout.getLayoutId()).getName(locale);
				MapCategoryLayoutObject layoutObject = new MapCategoryLayoutObject(mapCateLayout.getMapCateLayoutId(),
						mapCateLayout.getCompanyId(), mapCateLayout.getGroupId(), mapCateLayout.getCategoryId(),
						mapCateLayout.getType(), category.getTitle(), layoutName, mapCateLayout.getLayoutId());
				categoryLayoutObjects.add(layoutObject);
			}

			objectNode.put("total", total);
			objectNode.putPOJO("data", categoryLayoutObjects);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@DELETE
	@Path("/delete/{groupId}/{mapCateLayoutId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Delete(@PathParam("groupId") long groupId,
			@DefaultValue("-1") @PathParam("mapCateLayoutId") long mapCateLayoutId) {
		try {
			if (mapCateLayoutId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			MapCateLayoutLocalServiceUtil
					.deleteMapCateLayout(MapCateLayoutLocalServiceUtil.getMapCateLayout(mapCateLayoutId));

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/update/view/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse UpdateView(@PathParam("groupId") long groupId, @PathParam("locale") String locale) {
		try {
			locale = HtmlUtil.escape(locale);
			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectNode = mapper.createObjectNode();
			TreeCategory treeCategory = new TreeCategory();
//			ArrayNode data = treeCategory.getNodes(0, groupId, locale, treeCategory.NODE_PARENT, cate, start, limit);
			ArrayNode data = treeCategory.getNodes(0, groupId, locale, treeCategory.NODE_PARENT, "", -1, -1);

			// list page
			List<Layout> listLayout = LayoutLocalServiceUtil.getLayouts(groupId, false);
			List<MapCategoryLayoutObject.Layout> layouts = new ArrayList<>();
			for (Layout layout : listLayout) {
				MapCategoryLayoutObject.Layout layoutObject = new MapCategoryLayoutObject.Layout();
				layoutObject.setId(layout.getPlid());
				layoutObject.setName(layout.getName(locale));
				layouts.add(layoutObject);
			}

			objectNode.putPOJO("category", data);
			objectNode.putPOJO("layout", layouts);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/get/map-layout-by-category/{groupId}/{locale}/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetMapLayoutByCategory(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("categoryId") long categoryId) {
		try {
			locale = HtmlUtil.escape(locale);
			if (groupId < 0 || locale.isEmpty() || categoryId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectNode = mapper.createObjectNode();

			MapCateLayout mapCateLayout = MapCateLayoutLocalServiceUtil.getFriendsUrlByCategoryId(categoryId);
			MapCategoryLayoutObject mapCateLayoutObj = new MapCategoryLayoutObject();
			mapCateLayoutObj.setMapCateLayoutId(mapCateLayout.getMapCateLayoutId());
			mapCateLayoutObj.setCategoryId(mapCateLayout.getCategoryId());
			mapCateLayoutObj.setCompanyId(mapCateLayout.getCompanyId());
			mapCateLayoutObj.setType(mapCateLayout.getType());
			mapCateLayoutObj.setGroupId(mapCateLayout.getGroupId());
			mapCateLayoutObj.setPageId(mapCateLayout.getLayoutId());

			objectNode.putPOJO("data", mapCateLayoutObj);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@PUT
	@Path("/update/{groupId}/{locale}/{categoryId}/{layoutId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse UdpateItem(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("categoryId") long categoryId, @PathParam("layoutId") long layoutId,
			@PathParam("companyId") long companyId, @DefaultValue("2") @QueryParam("type") int type,
			@DefaultValue("-1") @QueryParam("mapCateLayoutId") long mapCateLayoutId) {
		try {
			locale = HtmlUtil.escape(locale);
			if (groupId < 0 || locale.isEmpty() || categoryId < 0 || layoutId < 0 || type < 0) {
				return DataResponse.PARAM_ERROR;
			}

			MapCateLayout cateLayout = null;
			if (MapCateLayoutLocalServiceUtil.checkExits(categoryId, type) <= 0) {
				try {
					if (mapCateLayoutId < 0) {
						cateLayout = MapCateLayoutLocalServiceUtil
								.createMapCateLayout(CounterLocalServiceUtil.increment(MapCateLayout.class.getName()));
						cateLayout = MapCateLayoutLocalServiceUtil.addMapCateLayout(cateLayout);
					} else {
						cateLayout = MapCateLayoutLocalServiceUtil.getMapCateLayout(mapCateLayoutId);
					}
					cateLayout.setGroupId(groupId);
					cateLayout.setCategoryId(categoryId);
					cateLayout.setLayoutId(layoutId);
					cateLayout.setCompanyId(companyId);
					cateLayout.setType(type);
					cateLayout = MapCateLayoutLocalServiceUtil.updateMapCateLayout(cateLayout);
				} catch (Exception ex) {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, ex.getMessage(),
							DataType.JSON_STR);
				}
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

}
