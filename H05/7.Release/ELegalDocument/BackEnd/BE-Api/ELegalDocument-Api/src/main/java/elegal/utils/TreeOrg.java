package elegal.utils;

import com.ecoit.elegaldocument.model.LegalOrg;
import com.ecoit.elegaldocument.service.GroupOrganizationLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalOrgLocalServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;

import elegal.object.TreeOrgObject;

import java.util.ArrayList;
import java.util.List;

public class TreeOrg {

	/***
	 * @param parentId   0 node 1 || > 0 get child
	 * @param groupId
	 * @param language
	 * @param chooseNode if parent 0 chooseNode = -1 || chooseNode = 0 get child
	 * @return
	 * @throws Exception
	 */
	public List<TreeOrgObject> getNodes(long parentId, long groupId, long companyId, String language, String name, int start,
			int limit, long userId) throws Exception {
		List<TreeOrgObject> mainList = new ArrayList<>();
		List<LegalOrg> allNode = LegalOrgLocalServiceUtil.getNode(parentId, groupId, companyId, language, "", start, limit);
		for (LegalOrg legalorg : allNode) {
			long orgId = legalorg.getOrganizationId();
			if (userId <= 0 || PermissionUtil.userHasOrganization(userId, orgId)) {
				List<TreeOrgObject> childrenList = getNodes(orgId, groupId, companyId, language, "", 0, -1, userId);
				TreeOrgObject object = new TreeOrgObject();
				object.setOrganizationId(legalorg.getOrganizationId());
				object.setName(HtmlUtil.extractText(legalorg.getName()));
				object.setDescription(HtmlUtil.extractText(legalorg.getDescription()));
				object.setStatusOrg(legalorg.isStatusOrg());
				object.setParentId(legalorg.getParentId());
				object.setPosition(legalorg.getPosition());
				object.setChild(childrenList);
				mainList.add(object);
			}
		}
		return mainList;
	}
	
	public List<TreeOrgObject> filterNodes(String searchKey, List<TreeOrgObject> originalList) {
		List<TreeOrgObject> filteredList = new ArrayList<TreeOrgObject>();
		for (TreeOrgObject object : originalList) {
			boolean isAdd = false;
			if (object.getName().toLowerCase().contains(searchKey.toLowerCase())) {
				isAdd = true;
			}
			
			List<TreeOrgObject> newChildList = filterNodes(searchKey, object.getChild());
			object.setChild(newChildList);
			if (newChildList.size() > 0) {
				isAdd = true;
			}
			
			if (isAdd) {
				filteredList.add(object);
			}
		}
		return filteredList;
	}

	public ArrayNode getCheckedNodes(long parentId, long groupId, long companyId, String language, long groupUserId) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<LegalOrg> allNode = LegalOrgLocalServiceUtil.getNode(parentId, groupId, companyId, language, "", 0, -1);
		for (LegalOrg legalorg : allNode) {
			if (legalorg.getStatusOrg()) {
				long orgId = legalorg.getOrganizationId();
				ArrayNode node = getCheckedNodes(orgId, groupId, companyId, language, groupUserId);
				ObjectNode object = mapper.createObjectNode();
				object.put("organizationId", legalorg.getOrganizationId());
				object.put("name", HtmlUtil.extractText(legalorg.getName()));
				object.put("description", HtmlUtil.extractText(legalorg.getDescription()));
				object.put("parentId", legalorg.getParentId());
				object.put("statusOrg", legalorg.isStatusOrg());
				object.put("position", legalorg.getPosition());
				boolean checked = GroupOrganizationLocalServiceUtil.hasGroupOrganization(groupUserId, orgId);
				object.putPOJO("checked", checked);
				object.putPOJO("child", node);
				arr.add(object);
			}
		}
		return arr;
	}
	
	
	public List<Long> getListLegalOrgIds(long parentId, long groupId, long companyId, String language) throws Exception {
		List<Long> arr = new ArrayList<>();
		List<LegalOrg> allNode = LegalOrgLocalServiceUtil.getNode(parentId, groupId, companyId, language, "", -1, -1);
		for (LegalOrg legalorg : allNode) {
			long cateId = legalorg.getOrganizationId();
			arr.add(cateId);
			List<Long> childArr = getListLegalOrgIds(cateId, groupId, companyId, language);
			for (Long childId : childArr) {
				arr.add(childId);
			}
		}
		
		return arr;
	}
	
	public ArrayNode getPublishNodes(long parentId, String language, long groupId) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arr = mapper.createArrayNode();
		List<LegalOrg> legalOrgsList = LegalOrgLocalServiceUtil.getPublishOrganizations(parentId, language, true, groupId);
		for (LegalOrg legalOrg : legalOrgsList) {
			long orgId = legalOrg.getOrganizationId();
			ArrayNode node = getPublishNodes(orgId, language, groupId);
			ObjectNode object = mapper.createObjectNode();
			object.put("organizationId", legalOrg.getOrganizationId());
			object.put("name", HtmlUtil.extractText(legalOrg.getName()));
			object.put("description", HtmlUtil.extractText(legalOrg.getDescription()));
			object.put("parentId", legalOrg.getParentId());
			object.put("statusOrg", legalOrg.isStatusOrg());
			object.put("position", legalOrg.getPosition());
			object.putPOJO("child", node);
			arr.add(object);
		}
		return arr;
	}

}
