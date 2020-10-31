package com.ecodoc.backend.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.domain.Organization;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.Calendar2OrgInfo;
import com.ecodoc.backend.core.dto.CategoryInitDto;
import com.ecodoc.backend.core.dto.OrgDto;
import com.ecodoc.backend.core.dto.OrgParent;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestFieldExceptionHandler;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.repository.OrganizationRepository;
import com.ecodoc.backend.util.StringUtils;

/**
 * @author EcoDOC
 * 
 */
@Service
public class OrganizationService extends BaseService<Organization> {

	@Autowired
	private OrganizationRepository orgRepository;

	@Override
	public IRepository<Organization> getRepository() {
		return orgRepository;
	}

	public Organization findByClientIdAndId(Long orgId) {
		return orgRepository.findByClientIdAndId(BussinessCommon.getClientId(), orgId);
	}

	public Organization validOrgId(Long orgId) {
		Organization org = findByClientIdAndId(orgId);
		if (org == null) throw new RestExceptionHandler(Message.NOT_FOUND_ORG);
		return org;
	}

	public List<Organization> findByNoParent(Boolean active) {
		Sort sort = Sort.by(Direction.ASC, "id");
		return orgRepository.findByClientIdAndParentIdAndActive(BussinessCommon.getClientId(), null, active, sort);
	}

	public List<Organization> findByClientIdAndParentIdAndActive(Long orgId, Boolean active) {
		Sort sort = Sort.by(Direction.ASC, "id");
		return orgRepository.findByClientIdAndParentIdAndActive(BussinessCommon.getClientId(), orgId, active, sort);
	}

	public List<Long> findParentIdByOrgId(Long orgId, Boolean active) {
		return orgRepository.findByClientIdAndParentIdAndActive(BussinessCommon.getClientId(), orgId, active);
	}

	public List<Organization> getNameByIdList(List<Long> orgId, Boolean active) {
		return orgRepository.getNameByIdList(BussinessCommon.getClientId(), orgId, active);
	}

	// TODO: remove
	public Long getRootOrgId(Long orgId) {
		if (!orgRepository.existsById(orgId)) {
			return null;
		}
		Long currId = orgId;

		while (true) {
			Long parentId = orgRepository.getParentId(currId, BussinessCommon.getClientId());
			if (parentId == null) {
				break;
			}
			currId = parentId;
		}
		return currId;
	}

	public Set<Long> listParentOrg(Long orgId) {
		Map<Long, Long> m = mapAllParent();
		Set<Long> parentList = new HashSet<>();
		if (!m.containsKey(orgId)) {
			return parentList;
		}
		parentList.add(orgId);
		Long currId = orgId;

		while (true) {
			if (!m.containsKey(currId) ) {
				break;
			}
			Long parentId = m.get(currId);
			if (parentId == null || !parentList.add(parentId)) {
				break;
			}
			currId = parentId;
		}
		return parentList;
	}

	public List<CategoryInitDto> getListDtoByClientId() {
		List<CategoryInitDto> orgIssuedList = new ArrayList<>();
		List<Organization> orgList = findByClientIdAndActive(BussinessCommon.getClientId(), true);
		if (orgList == null) throw new RestExceptionHandler(Message.NOT_FOUND_ORG);
		orgList.forEach(o -> {
			CategoryInitDto org = new CategoryInitDto();
			org.setId(o.getId());
			org.setName(o.getName());
			orgIssuedList.add(org);
		});
		return orgIssuedList;
	}

	public List<Long> getIdList(Boolean active) {
		return orgRepository.getIdList(BussinessCommon.getClientId(), active);
	}

	public Map<Long, Long> mapParent(Set<Long> orgIds) {
		Long clientId = BussinessCommon.getClientId();
		Map<Long, Long> map = new HashMap<>();
		orgIds.forEach(orgId -> {
			if (map.containsKey(orgId)) {
				return;
			}
			Long parentId = orgRepository.getParentId(orgId, clientId);
			while (parentId != null) {
				map.put(orgId, parentId);
				if (map.containsKey(parentId)) {
					break;
				}
				orgId = parentId;
				parentId = orgRepository.getParentId(orgId, clientId);
			}
			map.put(orgId, parentId);
		});
		return map;
	}

	public boolean existUserByOrgId(Long orgId) {
		return orgRepository.existUserByOrgId(orgId, BussinessCommon.getClientId());
	}

	public boolean existChildByOrgId(Long orgId) {
		return orgRepository.existChildByOrgId(orgId, BussinessCommon.getClientId());
	}

	public boolean hasInActiveParent(Long orgId) {
		return orgRepository.hasInActiveParent(orgId, BussinessCommon.getClientId());
	}

	public boolean existsByIdAndActive(Long id, boolean active) {
		return orgRepository.existsByIdAndActiveAndClientId(id, active, BussinessCommon.getClientId());
	}

	public List<Long> orgAndSub(Long orgId) {
		Map<Long, Long> map = new HashMap<>();
		List<OrgParent> orgParents = orgRepository.getParentChild(BussinessCommon.getClientId());
		orgParents.forEach(e -> {
			if (e.getChild().equals(e.getParent())) {
				return;
			}
			map.put(e.getChild(), e.getParent());
		});
		return childOfOrg(orgId, map);
	}

	public Calendar2OrgInfo orgInfo(Long orgId) {
		Map<Long, Long> map = new HashMap<>();
		Map<Long, String> mapName = new HashMap<>(); 
		List<OrgParent> orgParents = orgRepository.getParentChild(BussinessCommon.getClientId());
		orgParents.forEach(e -> {
			if (e.getChild().equals(e.getParent())) {
				return;
			}
			map.put(e.getChild(), e.getParent());
			mapName.put(e.getChild(), e.getName());
		});
		Calendar2OrgInfo info = new Calendar2OrgInfo();
		info.setOrgAndSub(childOfOrg(orgId, map));
		Long parentId = parentId(orgId, map);
		info.setOrgName(mapName.get(orgId));
		info.setRootOrgName(mapName.get(parentId));
		return info;
	}

	private Long parentId(Long child, @NonNull Map<Long, Long> map) {
		Long parentId = child;
		while (true) {
			Long newParentId = map.get(parentId);
			if (newParentId == null) {
				break;
			}
			parentId = newParentId;
		}
		return parentId;
	}

	public Map<Long, Long> mapAllParent() {
		Map<Long, Long> map = new HashMap<>();
		List<OrgParent> orgParents = orgRepository.getParentChild(BussinessCommon.getClientId());
		orgParents.forEach(e -> {
			if (e.getChild().equals(e.getParent())) {
				return;
			}
			map.put(e.getChild(), e.getParent());
		});
		return map;
	}

	private static List<Long> childOfOrg(Long id, Map<Long, Long> mapAllParent) {
		List<Long> all = new ArrayList<>();
		if (id == null) {
			return all;
		}
		all.add(id);
		mapAllParent.forEach((child, parent) -> {
			if (id.equals(parent)) {
				all.addAll(childOfOrg(child, mapAllParent));
			}
		});
		return all;
	}

	public Organization findByNameAndParentId(String name, Long parentId) {
		List<Organization> rsList = orgRepository.findByNameAndParentId(name, parentId, BussinessCommon.getClientId());
		return rsList.isEmpty() ? null : rsList.get(0);
	}

	public Organization addOrg(Organization org) {
		if (org == null) throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		org.set(org);
		validExistName(org.getName(), org.getParentId());
		validExistPhone(org.getPhone(), org.getParentId());
		return orgRepository.save(org);
	}

	private Organization findByPhoneAndParentId(String phone, Long parentId) {
		List<Organization> rsList = orgRepository.findByPhoneAndParentId(phone, parentId, BussinessCommon.getClientId());
		return rsList.isEmpty() ? null : rsList.get(0);
	}

	private void validExistName(String name, Long parentId) {
		Organization old = findByNameAndParentId(name, parentId);
		if (old != null) throw new RestFieldExceptionHandler("name", Message.ORG_NAME_EXIST);
	}

	private void validExistPhone(String phone, Long parentId) {
		if(!StringUtils.isNullOrEmpty(phone)) {
			Organization olds = findByPhoneAndParentId(phone, parentId);
			if (olds != null) throw new RestFieldExceptionHandler("phone", Message.ORG_PHONE_EXIST);
		}
	}

	public Organization updateOrg(Long id, Organization org) {
		Organization old = findByClientIdAndId(id);
		if (old == null || (Boolean.TRUE.equals(old.getIsLdap()))) throw new RestExceptionHandler(Message.NOT_FOUND_ORG);
		org.set(org);
		if (!org.getName().equals(old.getName()) || (org.getParentId() != old.getParentId())
				//|| (org.getParentId()!= null &&  !org.getParentId().equals(old.getParentId()))
				//|| (old.getParentId()!= null &&  !old.getParentId().equals(org.getParentId()))
				)
			validExistName(org.getName(), org.getParentId());
		if (!org.getPhone().equals(old.getPhone())) validExistPhone(org.getPhone(), org.getParentId());

		return orgRepository.save(org);
	}

	public Page<Organization> search(OrgDto dto, Integer page) {
		return orgRepository.search(dto.convert(dto), BussinessCommon.getClientId(),  BussinessCommon.castToPageable(page));
	}
	
	/**
	 * get org parent in level orgType and it's child
	 * @param orgId
	 * @return
	 */
	public List<Long> getOrgAndSubByOrgType(Organization org, String orgType) {
		List<Organization> all = orgRepository.findByClientIdAndActive(BussinessCommon.getClientId(), true);
		List<Long> rs = new ArrayList<>();
		rs.add(org.getId());
		Long parentId = org.getParentId();	
		while (true) {
			Organization currentOrg = null ;
			for (Organization o : all) {
				if(parentId.equals(o.getId())) {
					currentOrg = o;
					break;
				}
			}
			
			if(currentOrg != null) {
				rs.add(currentOrg.getId());
				parentId = currentOrg.getParentId();
				if(orgType.equals(currentOrg.getOrgTypeModel().getName()) || parentId == null) {
					break;
				}
			}
		}
		
		return rs;
	}
	
	public Long getParentByOrgType(Long orgId, String orgType) {
		Long currId = orgId;
		while (true) {
			Organization parent = orgRepository.getParentIdObj(currId, BussinessCommon.getClientId());
			if (parent == null || orgType.equals(parent.getOrgTypeModel().getName()) ) {
				break;
			}
			currId = parent.getId();
		}
		return currId;
	}
	
	/**
	 * Does user belong to BAN/CUCVUVIEN/PHONG
	 * @param user
	 * @param orgTypeName
	 * @return
	 */
	public boolean isUserOfOrgType(User user, String orgTypeName) {
		return user.getOrgModel() != null && orgTypeName.equalsIgnoreCase(user.getOrgModel().getOrgTypeModel().getName());
	}
}
