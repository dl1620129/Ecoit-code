package com.ecodoc.backend.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.domain.Decentralization;
import com.ecodoc.backend.core.domain.FileEntry;
import com.ecodoc.backend.core.domain.FolderEntry;
import com.ecodoc.backend.core.domain.Organization;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.DecentralizationDto;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.repository.IDecentralizationRepository;
import com.ecodoc.backend.core.repository.IPositionRoleRepository;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.repository.IRoleRepository;
import com.ecodoc.backend.core.repository.IUserRepository;

import io.lettuce.core.GeoArgs.Sort;

@Service
public class DecentralizationService extends BaseService<Decentralization>{
	@Autowired
	private IDecentralizationRepository decenRepository;
	
	@Autowired
	OrganizationService orgService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FileEntryService fileEntryService;
	
	@Autowired
	FolderEntryService folderEntryService;
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private IRoleRepository roleRepo;

	@Override
	public IRepository<Decentralization> getRepository() {
		return decenRepository;
	}
	
	public List<Decentralization> findDecen(Long clientId){
		List<Decentralization> result = decenRepository.getAllDecentralization(clientId);
		return result;
	}
	public Decentralization addDecenFolder(Decentralization decentralization) {
		if(decentralization == null) throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		decentralization.set(decentralization);
		decentralization.setCreateBy(BussinessCommon.getUserId());
		decentralization.setUpdateBy(BussinessCommon.getUserId());
		decentralization.setCreateDate(new Date());
		decentralization.setUpdateDate(new Date());
		return decenRepository.save(decentralization);
	}
	public Decentralization updateDecenFolder(Decentralization decentralization, Long id) {
		Decentralization ord = findByClientIdAndId(BussinessCommon.getClientId(), id);
		if(decentralization == null) throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		decentralization.set(decentralization);
		decentralization.setCreateBy(BussinessCommon.getUserId());
		decentralization.setUpdateBy(BussinessCommon.getUserId());
		decentralization.setCreateDate(new Date());
		decentralization.setUpdateDate(new Date());
		return decenRepository.save(decentralization);
	}
	public  List<DecentralizationDto> getDecen(){
		List<Decentralization> data = this.findDecen(BussinessCommon.getClientId());
		List<User> uList  = userRepo.findByClientIdAndActive(BussinessCommon.getClientId(), true);
		List<FolderEntry> fList = folderEntryService.getAllFolderEntry();
		List<Organization> oList = orgService.findByNoParent(true);
		List<FileEntry> fiList = fileEntryService.getAll();
		List<Role> rList = roleRepo.findByClientId(BussinessCommon.getClientId());
		List<DecentralizationDto> decen = new ArrayList<>();
		data.stream().forEach(d ->{
			DecentralizationDto dto = new DecentralizationDto();
			dto.setId(d.getId());
			dto.setSpecies(d.getSpecies());
			dto.setPosition(d.getPosition());
			fList.forEach(f->{
				if(d.getSpecies() == 0) {
					dto.setNodeId(f.getNodeId());
				}
			});
			fiList.forEach(fi->{
				if(d.getSpecies() == 1) {
					dto.setNodeId(fi.getFileId());
				}
			});
			uList.forEach(u->{
				if(d.getPosition() == 0) {
					dto.setIdPermission(u.getId());
				}
			});
			oList.forEach(o->{
				if(d.getPosition() == 1) {
					dto.setIdPermission(o.getId());
				}
			});
			rList.forEach(r->{
				if(d.getPosition() == 2) {
					dto.setIdPermission(r.getId());
				}
			});
			decen.add(dto);
		});
		return decen;
	}
}
