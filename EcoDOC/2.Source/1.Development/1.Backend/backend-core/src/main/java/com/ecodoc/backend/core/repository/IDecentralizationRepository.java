package com.ecodoc.backend.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.core.domain.Decentralization;
import com.ecodoc.backend.core.domain.FileEntry;
import com.ecodoc.backend.core.domain.FolderEntry;
import com.ecodoc.backend.core.domain.Organization;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;

@Repository
public interface IDecentralizationRepository extends IRepository<Decentralization>{
	@Query(value = "SELECT d FROM Decentralization d WHERE d.clientId = :clientId")
	List<Decentralization> getAllDecentralization(Long clientId);
	
	
}
