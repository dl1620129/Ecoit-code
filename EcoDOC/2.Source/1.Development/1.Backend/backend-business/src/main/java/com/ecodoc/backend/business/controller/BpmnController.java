package com.ecodoc.backend.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecodoc.backend.business.domain.BpmnModel;
import com.ecodoc.backend.business.domain.BpmnModel.TYPE_DOCUMENT;
import com.ecodoc.backend.business.domain.NodeModel;
import com.ecodoc.backend.business.dto.BpmnSearchDto;
import com.ecodoc.backend.business.dto.NodeDto;
import com.ecodoc.backend.business.dto.UserConditionDto;
import com.ecodoc.backend.business.service.BpmnService;
import com.ecodoc.backend.core.auth.SecurityContext;
import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.domain.ResponseMessage;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestForbidden;
import com.ecodoc.backend.core.service.RoleService;
import com.ecodoc.backend.util.StringUtils;

@RestController
@RequestMapping("/bpmn2")
public class BpmnController {

	enum SortBy {
		UPDATE_DATE("updateDate"), NAME("name"), ACTIVE("active"), TYPEDOCUMENT("typeDocument"), ORG("org.name");

		private String field;

		private SortBy(String field) {
			this.field = field;
		}
	}

	@Autowired
	private BpmnService bpmnService;

	@Autowired
	private RoleService roleService;


	protected User getCurrentUser() {
		return SecurityContext.getCurrentUser();
	}

	public Long getClientId() {
		User user =  getCurrentUser();
		if(user != null) {
			return user.getClientId();
		}
		throw new RestExceptionHandler(Message.NOT_FOUND_CLIENT);
	}


	// use `bpmnService` instead of `getService()`
	// `Ctrl + click` to open BpmnService#save

	@PostMapping("/add")
	public ResponseEntity<BpmnModel> create(@RequestBody BpmnModel model) {
		requirePermission();
		try {
			if (model.getActive() == null) {
				model.setActive(false);
			}
			model.setClientId(getClientId());
			model = bpmnService.save(model);

			if (model != null) {
				return new ResponseEntity<>(model, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (DataIntegrityViolationException e) {
			throw convertException(e);
		}
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<BpmnModel> update(@PathVariable Long id, @RequestBody BpmnModel model) {
		requirePermission();
		try {
			model.setClientId(getClientId());
			model = bpmnService.update(id, model);

			if (model != null) {
				return new ResponseEntity<>(model, HttpStatus.OK);
			}

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (DataIntegrityViolationException e) {
			throw convertException(e);
		}
	}

	private RestExceptionHandler convertException(DataIntegrityViolationException e) {
		String fullMessage = e.getRootCause().getMessage();
		String[] messages = fullMessage.split("\n");
		String message = messages[messages.length - 1];
		if (message.contains("already exists")) {
			throw new RestExceptionHandler("Trùng tên");
		}
		throw new RestExceptionHandler(messages[messages.length - 1]);
	}

	@GetMapping("/search")
	public ResponseEntity<Page<BpmnSearchDto>> search(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "UPDATE_DATE") SortBy sortBy,
			@RequestParam(defaultValue = "DESC") Direction direction,
			@RequestParam(defaultValue = Constant.DEFAULT_PAGE_SIZE) int size,
			@RequestParam(value = "type", required = false) TYPE_DOCUMENT type,
			@RequestParam(value = "name", defaultValue = "") String name) {
		requirePermission();
		name = StringUtils.handleSubmit(name);
		Sort sort = Sort.by(direction, sortBy.field);
		Pageable pageable = PageRequest.of(page - 1, size, sort);
		return new ResponseEntity<>(bpmnService.search(name, type, pageable), HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<BpmnModel> getById(@PathVariable Long id) {
		BpmnModel bpmn = bpmnService.findByClientIdAndId(getClientId(), id);
		if (bpmn == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		bpmn.setShowNode(true);
		return new ResponseEntity<>(bpmn, HttpStatus.OK);
	}

	@PostMapping("/delete/{bpmnId}")
	public ResponseEntity<BpmnModel> delete(@PathVariable Long bpmnId) {
		requirePermission();
		try {
			bpmnService.deleteById(bpmnId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Deprecated
	@GetMapping("/node/{nodeId}")
	public ResponseEntity<NodeModel> getNode(@PathVariable Long nodeId) {
		NodeModel node = bpmnService.getNodeById(nodeId);
		return new ResponseEntity<>(node, HttpStatus.OK);
	}

	@GetMapping("/node/{nodeId}/users")
	public ResponseEntity<List<UserConditionDto>> getNodeUsers(@PathVariable Long nodeId) {
		List<UserConditionDto> users = bpmnService.getUserByNodeId(nodeId);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping("/node/{nodeId}/update")
	public ResponseEntity<NodeModel> updateNode(@PathVariable Long nodeId, @RequestBody NodeModel node) {
		requirePermission();
		NodeModel newNode = bpmnService.updateNode(nodeId, node);
		return new ResponseEntity<>(newNode, HttpStatus.OK);
	}

	@GetMapping("/next-node/{nodeId}")
	public ResponseEntity<List<NodeDto>> getNextNode(@PathVariable Long nodeId) {
		return new ResponseEntity<>(bpmnService.getNextNodes(nodeId), HttpStatus.OK);
	}

	@GetMapping("/start-node/{typeDocument}")
	public ResponseEntity<List<NodeDto>> startNodeByType(@PathVariable TYPE_DOCUMENT typeDocument) {
		return new ResponseEntity<>(bpmnService.nextStartNodeOfBpmn(typeDocument), HttpStatus.OK);
	}

	@GetMapping("/check-name")
	public ResponseEntity<ResponseMessage> checkName(@RequestParam String q) {
		bpmnService.duplicateName(q, null);
		return new ResponseEntity<>(new ResponseMessage("Ok"), HttpStatus.OK);
	}

	private void requirePermission() {
		if (roleService.existUserInModule(ModuleCodeEnum.PROCESS.getName())) {
			return;
		}
		throw new RestForbidden("No permission for this action");
	}
}
