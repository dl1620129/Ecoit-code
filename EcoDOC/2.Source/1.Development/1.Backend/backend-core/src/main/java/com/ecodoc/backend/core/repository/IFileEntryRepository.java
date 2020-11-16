package com.ecodoc.backend.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.core.domain.FileEntry;

import io.lettuce.core.dynamic.annotation.Param;
@Repository
public interface IFileEntryRepository extends IRepository<FileEntry> {
	@Query("Select file from FileEntry file where (:clientId is null or  file.clientId = :clientId) and file.active=:active ORDER BY file.name ASC")
	List<FileEntry> getAll(@Param(value = "clientId") Long clientId,@Param(value = "active") Boolean active); 
	

	@Query("Select file from FileEntry file where (:clientId is null or  file.clientId = :clientId) and file.active=:active and file.folderId=:folderId and file.name=:name ORDER BY file.name ASC")
	List<FileEntry> findByName(@Param(value = "clientId") Long clientId,@Param(value = "active") Boolean active,@Param(value = "name") String name,@Param(value = "folderId") String folderId); 

	@Query("select count(f) from FileEntry f where :clientId is null or f.clientId=:clientId and f.id=:id")
	Long checkFileById(@Param(value = "clientId") Long clientId,@Param(value = "id") Long id); 
 
	@Query("select f from FileEntry f where f.clientId=:clientId and f.fileId =:fileId and f.folderId =:folderId")
	FileEntry getFileEntryByFileIdAndFolderId(@Param(value = "clientId")Long clientId, @Param(value = "fileId")String fileId, @Param(value = "folderId")String folderId);
	
	@Query("select f from FileEntry f where f.clientId=:clientId and f.fileId =:fileId")
	FileEntry findByNodeId(@Param(value = "clientId")Long clientId, @Param(value = "fileId")String fileId);
}
