package com.ecodoc.backend.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecodoc.backend.business.domain.AttachmentDelegate;
import com.ecodoc.backend.business.domain.Delegate;
import com.ecodoc.backend.business.dto.AttachmentDelegateDto;
import com.ecodoc.backend.business.dto.DelegateDto;
import com.ecodoc.backend.business.dto.UserDelegateDto;
import com.ecodoc.backend.business.dto.UserPositionBase;
import com.ecodoc.backend.business.repository.IAttachmentDelegateRepository;
import com.ecodoc.backend.business.repository.IDelegateRepository;
import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.dto.UserIdOrgIdDto;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestFieldExceptionHandler;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.repository.IUserRepository;
import com.ecodoc.backend.core.service.BaseService;
import com.ecodoc.backend.core.service.FilesStorageService;
import com.ecodoc.backend.util.StringUtils;

import lombok.extern.slf4j.Slf4j; 

@Service
@Slf4j
public class DelegateService extends BaseService<Delegate> {

	@Autowired
	IDelegateRepository delegateRepository;

	@Autowired
	FilesStorageService storageService;

	@Autowired
	IAttachmentDelegateRepository attachmentDelegateRepository;

	@Autowired
	IUserRepository userRepo;

	@Autowired
	IAttachmentDelegateRepository attdeRepo; 

	@Override
	public IRepository<Delegate> getRepository() {
		return delegateRepository;
	}

	public boolean checkDelegate(Long fromUser, Long toUser) {
		if (!delegateRepository.existFromUserByToUser(fromUser, toUser, new Date())) {
			throw new RestExceptionHandler("Uỷ quyền không còn hiệu lực");
		}
		return true;
	}
	
	public List<Long> getListFrUserByToUser(Long toUserId){
		return delegateRepository.getListFrUserByToUser(toUserId, new Date());
	}

	public Delegate add(Long fromUserId, Long toUserId, String numberOrSign, Date startDate, Date endDate,
			MultipartFile[] files) {
		Long yourId = BussinessCommon.getUserId();
		List<UserIdOrgIdDto> dtoList = userRepo.findIdAndOrgId(new Long[] { yourId, fromUserId, toUserId }, BussinessCommon.getClientId());
		Map<Long, Long> userOrgMap = new HashMap<>();
		dtoList.forEach(e -> {
			userOrgMap.put(e.getId(), e.getOrgId());
		});
		if (!userOrgMap.containsKey(fromUserId)) {
			throw new RestFieldExceptionHandler("fromUserId", Message.NOT_FOUND_USER);
		}
		if (!userOrgMap.containsKey(toUserId)) {
			throw new RestFieldExceptionHandler("toUserId", Message.NOT_FOUND_USER);
		}
		Long yourOrg = userOrgMap.get(yourId);
		log.info("yourOrg: {}", yourOrg);
		if (yourOrg.compareTo(userOrgMap.get(fromUserId)) != 0) {
			throw new RestFieldExceptionHandler("fromUserId", Message.ORG_NOT_SAME);
		}
		if (yourOrg.compareTo(userOrgMap.get(toUserId)) != 0) {
			throw new RestFieldExceptionHandler("toUserId", Message.ORG_NOT_SAME);
		}

		Delegate delegate = new Delegate(numberOrSign, fromUserId, toUserId, startDate, endDate);
		List<AttachmentDelegate> attachments = new ArrayList<>();
		if (files != null) {
			for (MultipartFile file : files) {
				AttachmentDelegate attachment = new AttachmentDelegate(file, delegate);
				attachment.setName(storageService.save(file));
				attachments.add(attachment);
			}
		}
		delegate.setAttachments(attachments);
		return delegateRepository.save(delegate);
	}

	public Delegate getById(Long id) {
		Optional<Delegate> oData = delegateRepository.findById(id);
		if (!oData.isPresent()) {
			throw new RestExceptionHandler("Not found");
		}
		return oData.get();
	}

	public Delegate getDetailById(Long id) {
		Delegate data = getById(id);
		//check quyền
		if (BussinessCommon.getUser().getOrg() != data.getFromUser().getOrg()) {
			throw new RestExceptionHandler(Message.NO_PERMISSION);
		}
		return data;
	}
	
	public Delegate update(Long id, Long fromUserId, Long toUserId, String numberOrSign, Date startDate, Date endDate,
			MultipartFile[] files) {
		Long yourId = BussinessCommon.getUserId();

		Delegate data = getById(id);
		if (new Date().compareTo(data.getEndDate()) > 0) {
			throw new RestExceptionHandler("Ủy quyền đã quá hạn không được phép chỉnh sửa");
		}
		if (!StringUtils.isNullOrEmpty(numberOrSign)) data.setNumberOrSign(numberOrSign);
		
		if (fromUserId != null) {
			if (new Date().compareTo(data.getStartDate()) > 0) {
				throw new RestExceptionHandler("Ủy quyền đã có hiệu lực không được phép thay đổi người ủy quyền và người được ủy quyền");
			}
			data.setFromUserId(fromUserId);
		}
		if (toUserId != null) {
			if (new Date().compareTo(data.getStartDate()) > 0) {
				throw new RestExceptionHandler("Ủy quyền đã có hiệu lực không được phép thay đổi người ủy quyền và người được ủy quyền");
			}
			data.setToUserId(toUserId);
		}
		if (startDate != null) data.setStartDate(startDate);
		if (endDate != null) data.setEndDate(endDate);

		
		List<UserIdOrgIdDto> dtoList = userRepo.findIdAndOrgId(new Long[] { yourId, data.getFromUserId(), data.getToUserId() }, BussinessCommon.getClientId());
		Map<Long, Long> userOrgMap = new HashMap<>();
		dtoList.forEach(e -> {
			userOrgMap.put(e.getId(), e.getOrgId());
		});
		if (!userOrgMap.containsKey(data.getFromUserId())) {
			throw new RestFieldExceptionHandler("fromUserId", Message.NOT_FOUND_USER);
		}
		if (!userOrgMap.containsKey(data.getToUserId())) {
			throw new RestFieldExceptionHandler("toUserId", Message.NOT_FOUND_USER);
		}
		Long yourOrg = userOrgMap.get(yourId);
		log.info("yourOrg: {}", yourOrg);
		if (yourOrg.compareTo(userOrgMap.get(data.getFromUserId())) != 0) {
			throw new RestFieldExceptionHandler("fromUserId", Message.ORG_NOT_SAME);
		}
		if (yourOrg.compareTo(userOrgMap.get(data.getToUserId())) != 0) {
			throw new RestFieldExceptionHandler("toUserId", Message.ORG_NOT_SAME);
		}
		if (data.getEndDate().compareTo(data.getStartDate()) < 0) {
			throw new RestFieldExceptionHandler("endDate", "Ngày hết hạn không thể trước ngày bắt đầu");
		}
		if (data.getFromUserId().compareTo(data.getToUserId()) == 0) {
			throw new RestFieldExceptionHandler("toUserId", "Bạn phải uỷ quyền cho người khác");
		}
		if (new Date().compareTo(data.getEndDate()) > 0) {
			throw new RestFieldExceptionHandler("endDate", "Đã quá ngày hết hạn");
		}
		
		if (files != null) {
			List<AttachmentDelegate> attachments = new ArrayList<>();
			for (MultipartFile file : files) {
				AttachmentDelegate attachment = new AttachmentDelegate(file, data);
				attachment.setName(storageService.save(file));
				attachments.add(attachment);
			}
			data.setAttachments(attachments);
		}
		return delegateRepository.save(data);
	}

	public List<Long> getListToUserByFrUser(Long frUsers){
		return delegateRepository.getListToUserByFrUser(frUsers, new Date(), BussinessCommon.getClientId());
	}


	public Page<DelegateDto> list(Pageable pageable) {
		Page<DelegateDto> result = delegateRepository.list(BussinessCommon.getUser().getOrg(), pageable);
		DelegateService.fillAtt(attdeRepo, result.getContent());
		return result;
	}

	public Page<DelegateDto> quickSearch(String text, Pageable pageable) {
		Page<DelegateDto> result = delegateRepository.quickSearch(text, BussinessCommon.getUser().getOrg(), pageable);
		DelegateService.fillAtt(attdeRepo, result.getContent());
		return result;
	}

	public Page<DelegateDto> search(String numberOrSign, String fromUser, String toUser, Date startDate, Date endDate,
			Pageable pageable) {
		Page<DelegateDto> result = delegateRepository.search(numberOrSign, fromUser, toUser, startDate, endDate,
				BussinessCommon.getUser().getOrg(), pageable);
		DelegateService.fillAtt(attdeRepo, result.getContent());
		return result;
	}

	public static void fillAtt(IAttachmentDelegateRepository attdeRepo, List<DelegateDto> content) {
		Map<Long, List<AttachmentDelegate>> mapAtt = new HashMap<>();
		List<Long> delegateIds = new ArrayList<>();
		for (DelegateDto dto : content) {
			Long delegateId = dto.getId();
			delegateIds.add(delegateId);
			mapAtt.put(delegateId, new ArrayList<>());
		}
		for (AttachmentDelegate attachment : attdeRepo.findAllByDelegateIdIn(delegateIds)) {
			Long delegateId = attachment.getDelegateId();
			mapAtt.get(delegateId).add(attachment);
		}
		for (DelegateDto dto : content) {
			Long delegateId = dto.getId();
			dto.setAttachments(mapAtt.get(delegateId));
		}
	}

	public Optional<AttachmentDelegate> findByFileName(String fileName) {
		return attdeRepo.findByFileName(fileName);
	}
	
	public Map<Long, List<UserDelegateDto>> getDelegateByIds(Set<Long> fromIds) {
		Date now = new Date();
		List<UserDelegateDto> delegates = delegateRepository.getDelegateByIds(fromIds, now);
		List<Long> delegateIds = delegates.stream().map(e -> e.getDelegateId()).collect(Collectors.toList());
		
		// map delegate and file
		List<AttachmentDelegateDto>  attachmentDto = attachmentDelegateRepository.findDtoByDelegateIdIn(delegateIds);
		Map<Long, List<AttachmentDelegateDto>> mapatt = new HashMap<>();
		delegateIds.forEach(id -> mapatt.put(id, new ArrayList<>()));
		attachmentDto.forEach(attDto -> mapatt.get(attDto.getDelegateId()).add(attDto));
		delegates.forEach(dto -> dto.setAttachments(mapatt.get(dto.getDelegateId())));
		
		// map user and delegate
		Map<Long, List<UserDelegateDto>> mapUsers = new HashMap<>();
		fromIds.forEach(id -> mapUsers.put(id, new ArrayList<>()));
		delegates.forEach(dto -> mapUsers.get(dto.getFromId()).add(dto));
		fromIds.forEach(id -> mapUsers.get(id).sort(UserPositionBase::sort));
		return mapUsers;
	}

	public Long findByIdAndDate(Long delegateId, Date date) {
		return delegateRepository.findByIdAndDate(delegateId, date);
	}

}
