package com.ecodoc.backend.core.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.domain.Organization;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.OrgDto;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestForbidden;
import com.ecodoc.backend.core.service.IService;
import com.ecodoc.backend.core.service.OrganizationService;
import com.ecodoc.backend.core.service.RoleService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author EcoDOC
 *
 */
@Slf4j
@RestController
@RequestMapping("/org")
public class OrganizationController {//extends BaseController<Organization> {

	@Autowired
	private OrganizationService orgService;

	//@Override
	public IService<Organization> getService() {
		return orgService;
	}

	@Autowired
	private RoleService roleService;
	
	private void checkPermission() {
		if (roleService.existUserInModule(ModuleCodeEnum.ORG.getName())) {
			return;
		}
		throw new RestForbidden("Bạn không có quyền truy cập vào người dùng");
	}
	
	@PostMapping(path = "/search/{page}")
	public ResponseEntity<?> getList(@RequestBody OrgDto dto, @PathVariable Integer page) {
		return new ResponseEntity<>(orgService.search(dto, page),HttpStatus.OK);
	}

	@GetMapping(path = "/findByNoParent")
	public ResponseEntity<?> findByNoParent(@RequestParam(required = false) Boolean active) {
		return new ResponseEntity<>(orgService.findByNoParent(active), HttpStatus.OK);
	}

	@GetMapping(path = "/root2")
	public ResponseEntity<Set<Long>> root2(@RequestParam(value = "q", required = false) Long orgId) {
		User user = BussinessCommon.getUser();
		if (orgId == null) {
			orgId = user.getOrg();
		}
		return new ResponseEntity<>(orgService.listParentOrg(orgId), HttpStatus.OK);
	}

	@GetMapping(path = "/root")
	public ResponseEntity<Long> root(@RequestParam(value = "q", required = false) Long orgId) {
		User user = BussinessCommon.getUser();
		if (orgId == null) {
			orgId = user.getOrg();
		}
		return new ResponseEntity<>(orgService.getRootOrgId(orgId), HttpStatus.OK);
	}

	@GetMapping(path = "/find_all_org")
	public ResponseEntity<?> findAllOrg() {
		return new ResponseEntity<>(orgService.getListDtoByClientId(), HttpStatus.OK);
	}

	//@Override
	@GetMapping("/deactive/{id}")
	public ResponseEntity<Organization> deactive(@PathVariable Long id) {
		checkPermission();
		if (orgService.existUserByOrgId(id)) {
			log.error("Xóa đơn vị không thành công: Đang có người dùng thuộc đơn vị này!!!");
			throw new RestExceptionHandler("Xóa đơn vị không thành công: Đang có người dùng thuộc đơn vị này");
		}
		if (orgService.existChildByOrgId(id)) {
			throw new RestExceptionHandler("Xóa đơn vị không thành công: Đang có đơn vị con thuộc đơn vị này");
		}
		Organization data = getService().findByClientIdAndId(BussinessCommon.getClientId(), id);
		if (data == null || !data.getActive()) {
			log.error("Data object is null");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			data.setActive(false);
			getService().save(data);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	//@Override
	@GetMapping("/active/{id}")
	public ResponseEntity<?> active(@PathVariable Long id) {
		checkPermission();
		if (orgService.hasInActiveParent(id)) {
			log.error("Đơn vị cha chưa đc active");
			throw new RestExceptionHandler("Đơn vị cha chưa được active");
		}
		Organization data = getService().findByClientIdAndId(BussinessCommon.getClientId(), id);
		if (data == null || (data.getActive() != null && data.getActive())) {
			log.error("Data object is null");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			data.setActive(true);
			data = getService().save(data);
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
	}

	//@Override
	@PostMapping("/add")
	public ResponseEntity<?> create(@RequestBody Organization input) {
		checkPermission();
		return new ResponseEntity<>(orgService.addOrg(input), HttpStatus.OK);
	}

	//@Override
	@PostMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Organization input) {
		checkPermission();
		return new ResponseEntity<>(orgService.updateOrg(id, input), HttpStatus.OK);
	}
	
	@GetMapping("/getAllSort/{direction}/{column}")
	public ResponseEntity<?> getByClientIdAndSort(@PathVariable String direction,
			@RequestParam(required = false) Boolean active,
			@PathVariable String column) {
		Sort sort;
		if (direction.equals("ASC")) {
			sort = Sort.by(Direction.ASC, column);
		} else {
			sort = Sort.by(Direction.DESC, column);
		}
		List<Organization> data = getService().findByClientIdAndActive(BussinessCommon.getClientId(), active, sort);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping(path = "/findCuc/{orgId}")
	public ResponseEntity<?> findCuc(@PathVariable Long orgId) {
		Organization org = orgService.findByClientIdAndId(BussinessCommon.getClientId(), orgId);
		return new ResponseEntity<>(orgService.getOrgAndSubByOrgType(org, Constant.CUC_VU_VIEN), HttpStatus.OK);
	}
}
