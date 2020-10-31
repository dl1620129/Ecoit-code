package com.ecodoc.backend.business.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.business.domain.Notification;
import com.ecodoc.backend.business.dto.ListNotificationDto;
import com.ecodoc.backend.business.dto.NotificationDto;
import com.ecodoc.backend.business.dto.RoleModuleDto;
import com.ecodoc.backend.business.repository.INotificationRepository;
import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.config.NotificationHandleStatusEnum;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.service.BaseService;
import com.ecodoc.backend.core.service.ModuleService;
import com.ecodoc.backend.core.service.RoleService;
import com.ecodoc.backend.core.service.UserService;

@Service
public class NotificationService extends BaseService<Notification>{

	@Autowired
	INotificationRepository notiRepo;

	@Autowired
	UserService userService;

	@Autowired
	ModuleService moduleService;

	@Autowired
	RoleService roleService;

	@Override
	public IRepository<Notification> getRepository() {
		return notiRepo;
	}

	public Notification add(Long userId, Long docId, String preview,  NotificationHandleStatusEnum docOutStatus, ModuleCodeEnum code) {
		Notification input = new Notification();
		input.setUserId(userId);
		input.setDocId(docId);
		if (preview.length() > Constant.DESCRIPTION_LENGTH)
		{
			input.setDescription(preview.substring(0, Constant.DESCRIPTION_LENGTH) + "...");
		} else {
			input.setDescription(preview);
		}
		
		input.setDocStatus(docOutStatus);
		input.setModuleCode(code);
		return notiRepo.save(input);
	}

	public List<Notification> addAll(List<Long> listUserIds, Long docId, String preview,  NotificationHandleStatusEnum docOutStatus, ModuleCodeEnum code) {
		List<Notification> listNoti = new ArrayList<>();
		for (Long userId : listUserIds) {
			Notification input = new Notification();
			input.setUserId(userId);
			input.setDocId(docId);
			if (preview.length() > Constant.DESCRIPTION_LENGTH) {
				input.setDescription(preview.substring(0, Constant.DESCRIPTION_LENGTH) + "...");
			} else {
				input.setDescription(preview);
			}
			
			input.setDocStatus(docOutStatus);
			if (NotificationHandleStatusEnum.DA_THU_HOI_BH.equals(docOutStatus))
				input.setDescription(preview);
			input.setModuleCode(code);
			listNoti.add(input);
		}
		return notiRepo.saveAll(listNoti);
	}

	public ListNotificationDto get(Long userId) {
		List<Notification> listNoti = notiRepo.getByActiveAndUserId(true, userId);
		ListNotificationDto result = new ListNotificationDto();
		List<NotificationDto> listNotiDto = new ArrayList<>();
		for (Notification noti : listNoti) {
			NotificationDto notiDto = new NotificationDto();
			notiDto.setId(noti.getId());
			notiDto.setDocId(noti.getDocId());
			notiDto.setDocType("");
			notiDto.setDescription(noti.getDescription());
			notiDto.setDocStatus(noti.getDocStatus());
			notiDto.setDocStatusName(noti.getDocStatus().getName());
			notiDto.setRead(noti.getRead());
			notiDto.setDate(noti.getCreateDate());
			notiDto.setModuleCode(noti.getModuleCode());
			listNotiDto.add(notiDto);
		}
		//result.setTotalPage(input.getTotalPages());
		result.setTotalRecord(listNotiDto.size());
		result.setTotalUnread(notiRepo.countByActiveAndUserIdAndRead(true, userId, false));
		result.setObjList(listNotiDto);
		return result;
	}

	public Boolean delete(Long id) {
		Optional<Notification> dc = notiRepo.findById(id);
		if (dc.isPresent()) {
			Notification noti = dc.get();
			if (noti.getUserId() == BussinessCommon.getUserId()) {
				noti.setActive(false);
				notiRepo.save(noti);
			}
		} else {
			throw new RestExceptionHandler(Message.ACTION_FAILED);
		}
		return true;
	}

	public Long countUnread(Long userId) {
		return notiRepo.countByActiveAndUserIdAndRead(true, userId, false);
	}

	public Boolean deactiveAllByUserId(Long userId) {
		notiRepo.deactiveAllByUserId(userId);
		return true;
	}

	public void deactiveAllByDocIdAndDocType(Long docId) {
		notiRepo.deactiveAllByDocIdAndDocType(docId);
	}

	public Boolean deactiveAllByIds(Long[] listIds) {
		notiRepo.deactiveAllByIds(listIds);
		return true;
	}

	public Boolean setRead(Long id) {
		notiRepo.setReadByIdAndUserId(true, id, BussinessCommon.getUserId());
		return true;
	}

	public void setActiveByDocIdAndDocType(Long docId,  Boolean active) {
		notiRepo.setActiveByDocIdAndDocType(docId,  active);
	}

	public void setActiveByListUserIdAndDocIdAndDocType(List<Long> listUsers, Long docId,  boolean active) {
		notiRepo.setActiveByListUserIdAndDocIdAndDocType(listUsers, docId,  active);
	}
	
	public void setActiveByUserIdAndDocIdAndDocType(Long userId, Long docId,  boolean active) {
		notiRepo.setActiveByUserIdAndDocIdAndDocType(userId, docId,  active);
	}
	
	public void setActiveForUserHandle(Long userId, Long docId,  boolean active,
			NotificationHandleStatusEnum docStatus, ModuleCodeEnum module) {
		List<Notification> rs = notiRepo.getByUserId(userId, docId,  true, docStatus, module);
		rs.forEach(i -> {
			i.setActive(active);
		});
		if(!rs.isEmpty()) notiRepo.saveAll(rs);
	}
	
	public RoleModuleDto checkModule(long notiId) {
		RoleModuleDto rmDto = new RoleModuleDto();
		Optional<Notification> oNoti = notiRepo.findById(notiId);
		if (oNoti.isPresent()) {
			Notification noti = oNoti.get();
			noti.setRead(true);
			notiRepo.save(noti);
			if (noti.getModuleCode() == null) {
				return rmDto; //Thoải mái đi
			}
			User user = BussinessCommon.getUser();
			//Check if current role have module -> return;
			if (moduleService.existModuleByRoleId(noti.getModuleCode(), user.getCurrentRole())) {
				return rmDto; //Ok luôn
			}
			//Find role by user have module
			List<Role> listRole = roleService.getRoleHaveModuleByUser(noti.getModuleCode(), user);
			if (listRole == null || listRole.size() == 0) {
				noti.setActive(false);
				notiRepo.save(noti);
				throw new RestExceptionHandler(Message.ROLE_NOT_FOUND); //Ko có role hợp lý
			}
			//Switch role
			long roleId = listRole.get(0).getId();
			rmDto.setRoleId(roleId);
			rmDto.setListModule(moduleService.findByRoleIdList(Arrays.asList(roleId), null));
			userService.setCurrentRole(BussinessCommon.getUserId(), roleId);
			return rmDto;
		}
		throw new RestExceptionHandler(Message.NOTIFICATION_NOT_FOUND);
	}

	public void setActiveByDocIdAndDocTypeAndUserIdAndDocStatus(boolean active, Long docId, 
			Long userId, List<NotificationHandleStatusEnum> listStatus) {
		notiRepo.setActiveByDocIdAndDocTypeAndUserIdAndDocStatus(active, docId,  userId, listStatus);
	}

	public void setReadByDocIdAndDocTypeAndUserId(boolean read, Long docId, Long userId) {
		notiRepo.setReadByDocIdAndDocTypeAndUserId(read, docId,  userId);
	}
	
	public void setReadById(Long id) { 
		Notification n = notiRepo.findByClientIdAndId(BussinessCommon.getClientId(), id);
		if (n!= null) n.setRead(true);
		notiRepo.save(n);
	}
}
