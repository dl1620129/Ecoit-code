package organizationalStructure.api.Utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;

import organizationalStructure.service.model.organization;
import organizationalStructure.service.service.organizationLocalServiceUtil;


public class TreeNode {
	public final static int NODE_CHILD = 0;
	public final static int NODE_PARENT = 1;

	/***
	 * @param parentId   0 node 1 || > 0 get child
	 * @param groupId
	 * @param language
	 * @param chooseNode if parent 0 chooseNode = -1 || chooseNode = 0 get child
	 * @return
	 * @throws Exception
	 */
	public ArrayNode getNodes(long parentId, long groupId, int chooseNode, String name, int start,
			int limit) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<organization> allNode = organizationLocalServiceUtil.getNode(parentId, groupId,name, start, limit);
		for (organization organization : allNode) {
			ObjectNode object = mapper.createObjectNode();
			long organId = organization.getOrganCoreId();
			object.put("organizationId",organId );
			object.put("organizationCode", HtmlUtil.extractText(organization.getOrganizationCode()));
			object.put("name", HtmlUtil.extractText(organization.getName()));
			object.put("description",HtmlUtil.extractText(organization.getDescription()));
			object.put("leader", organization.getLeader());
			object.put("thuTu",organization.getThuTu());
			object.put("parentId",organization.getParentId());
			object.put("orgCoreId",organization.getOrganCoreId());
			object.put("createDate", organization.getCreateDate().getTime());
			object.putPOJO("child", getNodes(organId, groupId, -1, name, start, limit)); 
			arr.add(object);
		}
		try {
			if (chooseNode == NODE_CHILD) {
				ArrayNode arrr = mapper.createArrayNode();
				ObjectNode object = mapper.createObjectNode();
				organization organization = organizationLocalServiceUtil.getorganization(parentId);
				object.put("organizationId", organization.getOrganCoreId());
				object.put("organizationCode", HtmlUtil.extractText(organization.getOrganizationCode()));
				object.put("name", HtmlUtil.extractText(organization.getName()) );
				object.put("description",HtmlUtil.extractText(organization.getDescription()));
				object.put("leader", organization.getLeader());
				object.put("createDate", organization.getCreateDate().getTime());
				object.put("orgCoreId",organization.getOrganCoreId());
				object.put("thuTu",organization.getThuTu());
				object.putPOJO("child", arr);
				System.out.println("5");
				arrr.add(object);
				return arrr;
			}
		} catch (Exception e) {
		}

		return arr;
	}
	public List<Long> getListOrgan(long parentId, long groupId, int chooseNode, String name,
			int start, int limit) throws Exception {
		List<Long> arr = new ArrayList<>();

		List<organization> allNode = organizationLocalServiceUtil.getNode(parentId, groupId, name, start, limit);
		for (organization organ : allNode) {
			long child = organ.getParentId();
//			if (child == 0) {
				long organId = organ.getOrganCoreId();
				getListOrgan(organId, groupId, -1, name, start, limit);
				arr.add(organId);
//			} else if (child != 0) {
//				arr.add(organ.getOrganizationId());
//			}
		}
		try {
			if (chooseNode == NODE_CHILD) {
				List<Long> arrr = new ArrayList<>();
				organization organ = organizationLocalServiceUtil.getorganization(parentId);
				arrr.add(organ.getOrganCoreId());
				return arrr;
			}
		} catch (Exception e) {
		}

		return arr;
	}
}
