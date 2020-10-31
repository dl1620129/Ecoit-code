package com.ecodoc.backend.business.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.business.domain.AttachmentDelegate;
import com.ecodoc.backend.business.dto.AttachmentDelegateDto;
import com.ecodoc.backend.core.repository.IRepository;

@Repository
public interface IAttachmentDelegateRepository extends IRepository<AttachmentDelegate> {
	List<AttachmentDelegate> findAllByDelegateIdIn(List<Long> delegateIds);
	
	@Query("SELECT new com.ecodoc.backend.business.dto.AttachmentDelegateDto(at.id, at.name, at.delegateId) FROM AttachmentDelegate at WHERE at.delegateId IN :delegateIds")
	List<AttachmentDelegateDto> findDtoByDelegateIdIn(List<Long> delegateIds);

	@Query("SELECT at FROM AttachmentDelegate at WHERE at.name = :fileName")
	Optional<AttachmentDelegate> findByFileName(String fileName);
}
