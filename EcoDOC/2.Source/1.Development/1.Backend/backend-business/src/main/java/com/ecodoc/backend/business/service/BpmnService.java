package com.ecodoc.backend.business.service;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.ecodoc.backend.business.domain.BpmnModel;
import com.ecodoc.backend.business.domain.BpmnModel.TYPE_DOCUMENT;
import com.ecodoc.backend.business.domain.Condition;
import com.ecodoc.backend.business.domain.NodeModel;
import com.ecodoc.backend.business.dto.BpmnActiveWrapper;
import com.ecodoc.backend.business.dto.BpmnSearchDto;
import com.ecodoc.backend.business.dto.NodeDto;
import com.ecodoc.backend.business.dto.UserConditionDto;
import com.ecodoc.backend.business.dto.UserDelegateDto;
import com.ecodoc.backend.business.dto.UserPositionBase;
import com.ecodoc.backend.business.repository.IBpmnRepository;
import com.ecodoc.backend.business.repository.INodeRepository;
import com.ecodoc.backend.business.util.NodeType;
import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestFieldExceptionHandler;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.service.BaseService;
import com.ecodoc.backend.core.service.OrganizationService;
import com.ecodoc.backend.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BpmnService extends BaseService<BpmnModel> {

	private static List<String> allowType = Arrays.asList("startEvent", "endEvent", "exclusiveGateway", "task",
			"sequenceFlow");

	@Autowired
	private IBpmnRepository bpmnRepository;

	@Autowired
	private INodeRepository nodeRepository;

	@Autowired
	private OrganizationService organizationService;
 
	@Autowired
	private DelegateService delegateService;


	@Override
	public IRepository<BpmnModel> getRepository() {
		return bpmnRepository;
	}

	@Override
	public BpmnModel save(BpmnModel bpmn) {
		if (StringUtils.isNullOrEmpty(bpmn.getContent())) {
			bpmn.setContent(BpmnModel.CONTENT_DEFAULT);
		}
		Map<String, NodeModel> identMap = new HashMap<>();
		List<NodeModel> nodes = rawNode(bpmn, identMap);
		mapNodeWithIdent(nodes, identMap);
		mapNodeWithCondition(nodes, bpmn.fullNodes());
		bpmn.setNodes(nodes);

		return preSave(bpmn, true);
	}

	public BpmnModel update(Long id, BpmnModel bpmn) {
		log.error("model.getActive(): {}" + bpmn.getActive());
		Optional<BpmnModel> bpmnOptional = bpmnRepository.findById(id);
		if (!bpmnOptional.isPresent()) {
			throw new RestExceptionHandler("Không tồn tại BPMN có id: " + id);
		}
		BpmnModel oldBpmn = bpmnOptional.get();

		String content = bpmn.getContent();
		boolean isChangedContent = !StringUtils.isNullOrEmpty(bpmn.getContent())
				&& !content.equals(oldBpmn.getContent());

		// update field
		if (bpmn.getName() != null) {
			oldBpmn.setName(bpmn.getName());
		}
		if (isChangedContent) {
			oldBpmn.setContent(bpmn.getContent());
		}
		if (bpmn.getOrgId() != null) {
			oldBpmn.setOrgId(bpmn.getOrgId());
		}
		if (bpmn.getTypeDocument() != null) {
			oldBpmn.setTypeDocument(bpmn.getTypeDocument());
		}
		if (bpmn.getActive() != null) {
			oldBpmn.setActive(bpmn.getActive());
		}

		List<NodeModel> oldNodes = oldBpmn.fullNodes();

		if (isChangedContent) {
			updateNodeWithContent(oldBpmn, oldNodes);
		} else {
			log.error("No change content");
		}

		if (isChangedContent || bpmn.fullNodes() != null) {
			mapNodeWithCondition(oldNodes, bpmn.fullNodes());
		}

		return preSave(oldBpmn, isChangedContent);
	}

	@NonNull
	public NodeModel getNodeById(Long nodeId) {
		Optional<NodeModel> nodeOptional = nodeRepository.findById(nodeId);
		if (nodeOptional.isPresent()) {
			return nodeOptional.get();
		}
		throw new RestExceptionHandler("Không tồn tại node với id: " + nodeId);
	}

	@NonNull
	public List<UserConditionDto> getUserByNodeId(Long nodeId) {
		// if condition org+pos, only check post in repo, check org in (2) | (1)
		List<UserConditionDto> dto = bpmnRepository.getUserByNodeId(nodeId, BussinessCommon.getClientId());
		List<UserConditionDto> results = new ArrayList<>();
		User user = BussinessCommon.getUser();

		Map<Long, Long> mapParent = organizationService.mapAllParent();
		// Don't take pos of other orgs
//		Map<Long, List<UserConditionDto>> mapPosUsers = new HashMap<>();
//		Map<Long, Boolean> mapExistUser = new HashMap<>();
		dto.forEach(d -> {
			// valid user
			if (!d.invalid()) {
				results.add(d);
				return;
			}
			// match the configuration and same current user | (2)
			// check match condition
			if (!isChild(d.getOrg(), d.getOrgId(), mapParent)) {
				return;
			}

			Long positionId = d.getPosition();
			// lead -> lead | lead -> upper org
			// match current user's org
			if ((user.isLead() && (d.isLead() || isChild(user.getOrg(), d.getOrg(), mapParent)))
					|| isChild(d.getOrg(), user.getOrg(), mapParent)) {
				results.add(d);
//				mapExistUser.put(positionId, true);
				return;
			}
			// init if empty
//			if (!mapPosUsers.containsKey(positionId)) {
//				mapPosUsers.put(positionId, new ArrayList<>());
//			}
//			mapPosUsers.get(positionId).add(d);
		});
		// add tmp data (no user match pos)
//		mapPosUsers.forEach((positionId, list) -> {
//			if (mapExistUser.containsKey(positionId)) {
//				return;
//			}
//			for (UserConditionDto d : list) {
//				results.add(d);
//			}
//		});

		Set<Long> ids = results.stream().map(u -> u.getId()).collect(Collectors.toSet());
		Map<Long, List<UserDelegateDto>> mapUsers = delegateService.getDelegateByIds(ids);
		results.forEach(userDto -> {
			userDto.setDelegateUsers(mapUsers.get(userDto.getId()));
		});
		results.sort(UserPositionBase::sort);
		return results;
	}

	/*
	 * Check conditionOrgId userOrgId's ancestor
	 */
	private static boolean isChild(Long userOrgId, Long conditionOrgId, Map<Long, Long> map) {
		Set<Long> set = new HashSet<>();
		if (conditionOrgId == null) {
			return false;
		}
		while (userOrgId != null) {
			if (!set.add(userOrgId)) {
				return false;
			}
			if (userOrgId.equals(conditionOrgId)) {
				return true;
			}
			if (!map.containsKey(userOrgId)) {
				return false;
			}
			userOrgId = map.get(userOrgId);
		}
		return false;
	}

	public NodeModel updateNode(Long nodeId, NodeModel node) {
		NodeModel oldNode = getNodeById(nodeId);
		if (node.getName() != null) {
			updateNodeName(oldNode, node.getName());
		}
		if (node.getConditions() == null) {
			throw new RestExceptionHandler("Cấu hình cho node không được 'null'");
		}
		oldNode.initConditions(node.getConditions());
		return nodeRepository.save(oldNode);
	}

	@Nullable
	public List<NodeDto> getNextNodes(Long nodeId) {
		BpmnActiveWrapper wrapper = nodeRepository.wrapBpmnByNodeId(nodeId);
		if (wrapper == null) {
			throw new RestExceptionHandler("Không tồn tại node có id là: " + nodeId);
		}
		if (Boolean.FALSE.equals(wrapper.getActive())) {
			throw new RestExceptionHandler("Luồng '" + wrapper.getName() + "' đã bị ngưng sử dụng");
		}
		try {
			return nodeRepository.findAutoNextById(nodeId);
		} catch (Exception e) {
			return null;
		}
	}

	public List<NodeDto> nextStartNodeOfBpmn(TYPE_DOCUMENT typeDocument) {
		User user = BussinessCommon.getUser();
		Set<Long> orgIds = organizationService.listParentOrg(user.getOrg());
		if (orgIds.isEmpty()) {
			throw new RestExceptionHandler("Tổ chức" + user.getOrg() + " không tồn tại");
		}
		// OUTCOMING get all
		if (typeDocument == TYPE_DOCUMENT.OUTCOMING) {
			List<NodeDto> tmp = nodeRepository.nextStartNodeOfBpmn(user.getId(), user.isLead(), user.getPosition(),
					user.getOrg(), user.getClientId(), orgIds, typeDocument);
			if (!tmp.isEmpty()) {
				return tmp;
			}
		}
		return nodeRepository.simpleNextStartNodeOfBpmn(user.getClientId(), orgIds, typeDocument);
	}

	private void updateNodeWithContent(BpmnModel oldBpmn, List<NodeModel> oldNodes) {
		Set<String> oldIdentSet = new HashSet<>();

		Map<String, NodeModel> identMap = new HashMap<>();
		List<NodeModel> newNodes = rawNode(oldBpmn, identMap);

		Iterator<NodeModel> iterator = oldNodes.iterator();
		while (iterator.hasNext()) {
			NodeModel node = iterator.next();

			String ident = node.getIdent();
			if (identMap.containsKey(node.getIdent())) {
				node.from(identMap.get(ident));
				identMap.replace(ident, node);
				oldIdentSet.add(ident);
			} else {
				node.setPrev(null);
				node.setNext(null);
				iterator.remove();
			}
		}

		for (NodeModel newNode : newNodes) {
			String ident = newNode.getIdent();
			if (!oldIdentSet.contains(ident)) {
				oldNodes.add(newNode);
			}
		}

		mapNodeWithIdent(oldNodes, identMap);
	}

	private void updateNodeName(NodeModel node, String name) {
		BpmnModel bpmn = node.getBpmn();
		node.setName(name);
		Document document = parseDocument(bpmn.getContent());
		if (document == null || node.getIdent() == null) {
			return;
		}
		document.getElementsByTagName(NodeType.TASK);
		Element nodeElement = getTaskByIdent(document, node.getIdent());
		if (nodeElement == null) {
			return;
		}
		nodeElement.setAttribute("name", node.getName());
		String content = getStringDocument(document);
		bpmn.setContent(content);
		bpmnRepository.save(bpmn);
	}

	private Element getTaskByIdent(@NonNull Document document, @NonNull String id) {
		NodeList nodes = document.getElementsByTagName(NodeType.TASK);
		for (int i = 0; i < nodes.getLength(); ++i) {
			Node node = nodes.item(i);
			if (node instanceof Element) {
				Element element = (Element) node;
				if (id.equals(element.getAttribute("id"))) {
					return element;
				}
			}
		}
		log.warn("Can't found element with id {}", id);
		return null;
	}

	private BpmnModel preSave(BpmnModel bpmn, boolean isChangedContent) {
		duplicateName(bpmn.getName(), bpmn.getId());
		// set bpmn for that org
//		Long parentId = organizationService.getRootOrgIdHasBpmn(bpmn.getOrgId());
//		if (parentId == null) {
//			throw new RestExceptionHandler("Can't found parent org for id: " + bpmn.getOrgId());
//		}
//		bpmn.setOrgId(parentId);
		if (isChangedContent) {
			// start event
			NodeModel endNode = null;

			int startNodeCounter = 0;
			for (NodeModel node : bpmn.fullNodes()) {
				if (NodeType.START_EVENT.equals(node.getType())) {
					++startNodeCounter;
				} else if (NodeType.END_EVENT.equals(node.getType())) {
					endNode = node;
				}
			}
			if (endNode == null) {
				throw new RestExceptionHandler("Luồng cần có node cuối");
			}
			if (startNodeCounter == 0) {
				throw new RestExceptionHandler("Luồng cần có node bắt đầu");
			}
			if (startNodeCounter > 1) {
				throw new RestExceptionHandler(
						"Luồng chỉ có 1 node bắt đầu(hiện tại có " + startNodeCounter + "node bắt đầu");
			}
		}

		// update active
		if (Boolean.TRUE.equals(bpmn.getActive())) {
			bpmnRepository.updateOneActiveForBpmnId(bpmn.getClientId(), bpmn.getTypeDocument(), bpmn.getOrgId(),
					bpmn.getId());
		}
		return bpmnRepository.save(bpmn);
	}

	@NonNull
	private List<NodeModel> rawNode(@NonNull BpmnModel bpmn, Map<String, NodeModel> identMap) {
		// "(<\\/?)\\w+?:" is regex to remove name space
		Document document = parseDocument(bpmn.getContent().replaceAll("(<\\/?)\\w+?:", "$1"));
		if (document == null) {
			throw new RestExceptionHandler("Nội dung XML lỗi");
		}
		NodeList processList = document.getElementsByTagName(BpmnModel.PROCESS_TAG);
		if (processList.getLength() != 1) {
			throw new RestExceptionHandler(
					"Luồng chỉ được có 1 tag 'process'(hiện tại có " + processList.getLength() + " tab 'process'");
		}

		Node processNode = processList.item(0);

		if (!(processNode instanceof Element)) {
			throw new RestExceptionHandler("Tag 'process' phải là Element");
		}


		Element processElement = (Element) processNode;

		List<NodeModel> nodes = new ArrayList<>();

		NodeList nodeChildrent = processElement.getChildNodes();
		for (int i = 0; i < nodeChildrent.getLength(); ++i) {
			Node nodeChild = nodeChildrent.item(i);
			if (!(nodeChild instanceof Element)) {
				log.info("This node isn't Element");
				continue;
			}
			String nodeName = nodeChild.getNodeName();
			if (!allowType.contains(nodeName)) {
				log.info("We don't allow node with type {}", nodeName);
				continue;
			}
			Element element = (Element) nodeChild;
			NodeModel node = new NodeModel();
			node.init(element);
			String ident = node.getIdent();
			node.setBpmn(bpmn);
			nodes.add(node);
			identMap.put(ident, node); // map ident to id
		}

		return nodes;
	}

	private void mapNodeWithIdent(List<NodeModel> nodes, Map<String, NodeModel> identMap) {

		for (NodeModel node: nodes) {
			String nextStr = node.getNextStr();
			if (!StringUtils.isNullOrEmpty(nextStr) && identMap.containsKey(nextStr)) {
				node.setNext(identMap.get(nextStr));
			}
			String prevStr = node.getPrevStr();
			if (!StringUtils.isNullOrEmpty(prevStr) && identMap.containsKey(prevStr)) {
				node.setPrev(identMap.get(prevStr));
			}
		}
	}

	private void mapNodeWithCondition(List<NodeModel> nodes, List<NodeModel> nodeConditions) {
		// nodes with condition from FE, assign to real nodes
		if (nodeConditions == null) {
			throw new RestExceptionHandler("Cấu hình cho node không được 'null'");
		}


		// map ident -> conditions, assign condition to node
		Map<String, List<Condition>> conditionMap = new HashMap<>();
		for (NodeModel node: nodeConditions) {
			String ident = node.getIdent();
			List<Condition> conditions = node.getConditions();
			if (!StringUtils.isNullOrEmpty(ident) && conditions != null) {
				conditionMap.put(ident, conditions);
			}
		}

		for (NodeModel node: nodes) {
			String ident = node.getIdent();
			if (conditionMap.containsKey(ident)) {
				node.initConditions(conditionMap.get(ident));
			}
		}
	}

	@Nullable
	private Document parseDocument(String content) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(new InputSource(new StringReader(content)));
		} catch (ParserConfigurationException | SAXException | IOException e) {
			return null;
		}
	}

	@NonNull
	private String getStringDocument(Document doc) {
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			return writer.toString();
		} catch(TransformerException ex) {
			throw new RestExceptionHandler("Không thể lấy string từ document");
		}
	}

	public Page<BpmnSearchDto> search(String name, TYPE_DOCUMENT type, Pageable pageable) {
		return bpmnRepository.search(name, type, BussinessCommon.getClientId(), pageable);
	}

	public void duplicateName(String name, Long id) {
		if (bpmnRepository.existName(name.toLowerCase(), id, BussinessCommon.getClientId())) {
			throw new RestFieldExceptionHandler("name", "Duplicate bpmn name");
		}
	}
}

