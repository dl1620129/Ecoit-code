package com.ecodoc.backend.business.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.business.domain.Attachment;
import com.ecodoc.backend.core.repository.IRepository;

@Repository
public interface IAttachmentRepository extends IRepository<Attachment>{
	@Transactional
	@Modifying
	@Query("DELETE from Attachment at WHERE at.documentId=:documentId")
	void deleteByDocId(@Param("documentId") Long documentId);

	Attachment findByNameAndClientIdAndActive(String name, Long clientId, boolean active);
}
