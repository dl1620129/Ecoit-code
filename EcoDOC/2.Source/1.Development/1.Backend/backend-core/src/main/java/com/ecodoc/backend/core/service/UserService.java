package com.ecodoc.backend.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.domain.Category;
import com.ecodoc.backend.core.domain.CategoryType;
import com.ecodoc.backend.core.domain.Organization;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.SignerDto;
import com.ecodoc.backend.core.dto.UserDto;
import com.ecodoc.backend.core.dto.UserInfoDto;
import com.ecodoc.backend.core.dto.UserTreeDto;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.repository.IUserRepository;
import com.ecodoc.backend.util.StringUtils;

@Service
public class UserService extends BaseService<User> {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	CategoryTypeService catTypeService;

	@Autowired 
	CategoryService catService;

	@Autowired
	OrganizationService orgService;

	/*
	 * @Autowired DelegateFlowService delegateFlowService;
	 */
	@Override
	public IRepository<User> getRepository() {
		return userRepository;
	}

	public User findByUserNameAndActive(String userName, boolean active) {
		return userRepository.findByUserNameAndActive(userName, active);
	}
	
	public User findByUserNameAndPasswordAndActive(String userName, String password, boolean active) {
		return userRepository.findByUserNameAndPasswordAndActive(userName, password, active);
	}

	public User findByUserNameAndClientId(String userName, Long clientId) {
		return userRepository.findByUserNameAndClientId(userName, clientId);
	}

	public List<User> findByListUserNameAndClientId(Long[] userName, Long clientId) {
		return userRepository.findByListUserNameAndClientId(userName, clientId);
	}
	
	public User findBySerialTokenAndActiveTrue(String serial) {
		return userRepository.findBySerialTokenAndActiveTrue(serial);
	}

//	public List<User> findByListUserNameAndClientId(String[] userNames, Long clientId) {
//		return userRepository.findByListUserIdAndClientId(userNames, clientId);
//	}

	public List<User> findByOrgIdAndClientId(Long orgId, Long clientId) {
		return userRepository.findByOrgAndClientId(orgId, clientId);
	}

	public List<User> findListUserByOrgAndPositionId(Long orgId, Long posId) {
		return userRepository.findListUserByOrgAndPositionIdAndActive(orgId, posId, true, BussinessCommon.getClientId());
	}

//	public boolean isRole(String userName, String role, Long clientId) {
//		User u = userRepository.findByUserNameAndClientId(userName, clientId);
//		for (Role r : u.getRoles()) {
//			if (r.getName().equals(role))
//				return true;
//		}
//		return false;
//	}

	public Page<User> findUser(String fullName, String userName, String email, String phone, Long sex,
			String indentity, String title, Long employeeId, String employeeCode, String salt, Long org,
			Long position, Boolean lead, Date birthday, Pageable pageable) {

		return userRepository.findUser(fullName, userName, email, phone, sex, indentity, title, employeeId,
				employeeCode, salt, org, position, lead, birthday, BussinessCommon.getClientId(),
				pageable);
	}

	public List<User> findListUserByPosition(Long positionId) {
		return userRepository.findByClientIdAndPosition(BussinessCommon.getClientId(), positionId);
	}

	public List<UserInfoDto> getByClientIdAndActiveAndSort(String direction, Boolean active, String column) {
		Sort sort;
		if (direction.equals("ASC")) {
			sort = Sort.by(Direction.ASC, column);
		} else {
			sort = Sort.by(Direction.DESC, column);
		}
		List<User> data = userRepository.findByClientIdAndActive(BussinessCommon.getClientId(), active, sort);
		List<Organization> oList = orgService.findByClientId(BussinessCommon.getClientId());
		CategoryType type = catTypeService.findByClientIdAndCode(BussinessCommon.getClientId(), Constant.CAT_POSITION);
		if (type == null)
			throw new RestExceptionHandler(Message.NOT_FOUND_POSITION);
		List<Category> cList = catService.findByClientIdAndCategoryTypeId(BussinessCommon.getClientId(), type.getId(),
				null);
		List<UserInfoDto> dtoList = new ArrayList<>();
		data.stream().forEach(u -> {
			UserInfoDto dto = new UserInfoDto();
			dto.setId(u.getId());
			dto.setFullName(u.getFullName());
			dto.setOrgId(u.getOrg());
			dto.setPositionId(u.getPosition());
			dto.setUserName(u.getUserName());
			dto.setTitle(u.getTitle());
			oList.forEach(o -> {
				if (o.getId().equals(u.getOrg())) {
					dto.setOrgName(o.getName());
				}
			});

			cList.forEach(c -> {
				if (c.getId().equals(u.getPosition())) {
					dto.setPositionName(c.getName());
				}
			});
			dto.setLead(u.isLead());
			dtoList.add(dto);
		});
		return dtoList;
	}

	public Page<User> getAllUser(Integer page) {
		return userRepository.getAllUser(BussinessCommon.getClientId(), BussinessCommon.castToPageable(page));
	}

	public List<UserInfoDto> getAllUserByLead() {
		CategoryType type = catTypeService.findByClientIdAndCode(BussinessCommon.getClientId(), Constant.CAT_POSITION);
		if (type == null)
			throw new RestExceptionHandler(Message.NOT_FOUND_POSITION);
		List<Category> cList = catService.findByClientIdAndCategoryTypeId(BussinessCommon.getClientId(), type.getId(),
				null);
		List<UserInfoDto> dtoList = userRepository.getAllUserByLead(BussinessCommon.getClientId(), true);
		List<Organization> oList = orgService.findByClientId(BussinessCommon.getClientId());
		dtoList.forEach(dto -> {
			cList.forEach(c -> {
				if (c.getId().equals(dto.getPositionId())) {
					dto.setPositionName(c.getName());
				}
			});
			oList.forEach(o -> {
				if (o.getId().equals(dto.getOrgId())) {
					dto.setOrgName(o.getName());
				}
			});
		});

		return dtoList;
	}

	public List<User> searchUserActive(String textSearch) {
		List<User> listUsers = userRepository.searchUserActive(StringUtils.handleSubmit(textSearch), BussinessCommon.getClientId());
		return listUsers;
	}
	public List<SignerDto> searchUserDtoActive(String textSearch) {
		return userRepository.searchUserSign(StringUtils.handleSubmit(textSearch), BussinessCommon.getClientId());
	}

//	public List<UserInfoDto> getUserDtoByUsernameArr(String[] users) {
//		if (users == null || users.length == 0)
//			return null;
//		List<User> uList = findByListUserNameAndClientId(users, BussinessCommon.getClientId());
//		List<UserInfoDto> dtoList = new ArrayList<>();
//		uList.forEach(u -> {
//			UserInfoDto dto = new UserInfoDto(u.getId(), u.getFullName(), u.getUserName());
//			dtoList.add(dto);
//		});
//		return dtoList;
//	}

	public String getFullNameById(Long userId) {
		return userRepository.getFullNameById(userId, BussinessCommon.getClientId());
	}

	public List<UserDto> getAllUserDtoByActive() {
		return userRepository.getAllUserDtoByActive(BussinessCommon.getClientId());
	}

	public List<User> findByIds(Long[] listIds) {
		return userRepository.findByIds(listIds);
	}

	public List<User> findByIds(List<Long> listIds, boolean active) {
		return userRepository.findByIds(listIds, BussinessCommon.getClientId(), active);
	}

	public List<Long> getIdList(Boolean active) {
		return userRepository.getIdList(BussinessCommon.getClientId(), active);
	}

	public List<Long> getListLeadUserIdByOrg(List<Long> org) {
		return userRepository.getListLeadUserIdByOrg(org);
	}

	public List<String> findUserNameByKeys(String key) {
		return userRepository.findUserNameByKeys(key, BussinessCommon.getClientId());
	}

	public List<Long> findIdByKeys(String key) {
		return userRepository.findIdByKeys(key, BussinessCommon.getClientId());
	}

	/**
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName) {
		return userRepository.findByUserNameAndClientId(userName, BussinessCommon.getClientId());
	}

	public User findByUserNameForLdap(String userName, Long clientId) {
		return userRepository.findByUserNameAndClientId(userName, clientId);
	}

	public List<UserTreeDto> getAllOrder() {
		//return userRepository.getAllOrder(BussinessCommon.getClientId());
		return userRepository.getAllOrder1(ModuleCodeEnum.DOCUMENT_IN.getName(), BussinessCommon.getClientId());
	}

	public List<User> findByPositionInAndActiveAndClientIdOrderByFullName(List<Long> listPosId, boolean active, Long clientId) {
		return userRepository.findByPositionInAndActiveAndClientIdOrderByFullName(listPosId, active, clientId);
	}

	public List<Role> findRoleByUserIdAndActive(User user, boolean active, long clientId) {
		//UserRole
		//List<Role> roles1 = userRoleService.findRoleByUserIdAndActive(user.getId(), active);
		//PositionRole
		//List<Role> roles2 = posRoleService.findRoleByUserIdAndActiveAndClientId(user.getId(), active, clientId);
		//roles2.removeAll(roles1);
		//roles1.addAll(roles2);
		return userRepository.findRoleByUserIdAndActive(user.getId(), user.getPosition(), active, clientId);
	}

	public List<Long> findRoleIdByUserIdAndActive(User user, boolean active, long clientId) {
		//UserRole
		//List<Long> roles1 = userRoleService.findRoleIdByUserIdAndActive(user.getId(), active);
		//PositionRole
		//List<Long> roles2 = posRoleService.findRoleIdByUserIdAndActiveAndClientId(user.getId(), active, clientId);
		//roles2.removeAll(roles1);
		//roles1.addAll(roles2);
		return userRepository.findRoleIdByUserIdAndActive(user.getId(), user.getPosition(), active, clientId);
	}

	public void setCurrentRole(long userId, long roleId) {
		userRepository.setCurrentRole(userId, roleId, BussinessCommon.getClientId());
	}

	public User validUserId(Long userId) {
		User user = findByClientIdAndId(BussinessCommon.getClientId(), userId);
		if (user == null) throw new RestExceptionHandler(Message.INVALID_ACCOUNT);
		return user;
	}

	public boolean existUserByRoleIdAndActiveAndClientId(long userId, long roleId, boolean active, long clientId) {
		return userRepository.existUserByRoleIdAndActiveAndClientId(userId, roleId, active, clientId);
	}

	public List<User> getListUserByModuleCodeAndClientId(List<String> listCode, long clientId) {
		return userRepository.getListUserByModuleCodeAndActiveAndClientId(listCode, true, clientId);
	}

	public List<Long> getListUserIdByModuleCodeAndClientId(List<String> listCode, long clientId) {
		return userRepository.getListUserIdByModuleCodeAndActiveAndClientId(listCode, true, clientId);
	}

	public boolean checkUserIdByModuleCodeAndClientId(long userId, List<String> listCode, long clientId) {
		return userRepository.checkUserIdByModuleCodeAndActiveAndClientId(userId, listCode, true, clientId);
	}

	public List<User> getListUserByModuleCodeAndOrgAndClientId(List<String> code, long orgId, long clientId) {
		return userRepository.getListUserByModuleCodeAndOrgAndClientIdAndActive(code, orgId, clientId, true);
	}

	public List<Long> getListUserIdByModuleCodeAndOrgAndClientId(List<String> code, long orgId, long clientId) {
		return userRepository.getListUserIdByModuleCodeAndOrgAndClientIdAndActive(code, orgId, clientId, true);
	}

	public List<String> getListUserNameByModuleCodeAndOrgAndClientId(List<String> code, long orgId, long clientId) {
		return userRepository.getListUserNameByModuleCodeAndOrgAndClientIdAndActive(code, orgId, clientId, true);
	}

	public boolean checkUserIdByModuleCodeAndOrgAndClientId(long userId, long orgId, List<String> listCode, long clientId) {
		return userRepository.checkUserIdByModuleCodeAndOrgAndActiveAndClientId(userId, orgId, listCode, true, clientId);
	}

	public long getOrgIdByUserName(String userName) {
		return userRepository.findOrgIdByUserNameAndActiveAndClientId(userName, true, BussinessCommon.getClientId());
	}

	public List<User> allUserInOrg(Long orgId, String textSearch) {
		List<Long> orgIds = orgService.orgAndSub(orgId);
		return userRepository.findUserByOrgInAndClientIdAndActive(orgIds, textSearch, BussinessCommon.getClientId());
	}

	public List<User> getLeadByListUserId(List<Long> userIds, List<Long> exceptUserList) {
		return userRepository.getLeadByListUserId(userIds, exceptUserList, BussinessCommon.getClientId());
	}

	public List<User> getListLead(Long[] orgArr) {
		return userRepository.getListLead(orgArr, BussinessCommon.getClientId());
	}


//	public List<User> findListNguoiDuocUyQuyen(Long userId) {
//		Optional<User> user = userRepository.findById(userId);
//		if (!user.isPresent()) throw new RestExceptionHandler(Message.NOT_FOUND_USER);
//		User u = user.get();
////		Set<Long> posIds = new HashSet<>();
////		List<DelegateFlow> listDF = delegateFlowService.list();
////		for (DelegateFlow df : listDF) {
////			if (df.getFromPositionId().equals(u.getPosition())) {
////				posIds.add(df.getToPositionId());
////			}
////		}
////		return userRepository.findListUserByOrgAndPositionIdInAndActive(u.getOrg(), posIds, true, u.getClientId());
//		return userRepository.findListNguoiDuocUyQuyen(u, true);
//	}

	public List<User> findByClientIdAndLDAP(long clientId, boolean b) {
		return userRepository.findByClientIdAndLDAP(clientId, b);
	}
}
