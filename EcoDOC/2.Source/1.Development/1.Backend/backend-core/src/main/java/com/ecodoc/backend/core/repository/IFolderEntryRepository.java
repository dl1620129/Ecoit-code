package com.ecodoc.backend.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.core.domain.FolderEntry;


import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface IFolderEntryRepository extends IRepository<FolderEntry> {
	@Query("Select fe from FolderEntry fe where (:clientId is null or  fe.clientId = :clientId)")
	List<FolderEntry> getAllFolderEntry(@Param(value = "clientId") Long clientId);
}
