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
	
	@Query(value = "SELECT d.user  FROM Decentralization d WHERE d.folderEntry.id =:folderId AND d.user.active=true AND d.active=:active AND d.clientId =:clientId order by d.user.fullName")
	List<User> findFolderIdByUserId(@Param(value = "folderId") Long folderId, @Param(value = "active") boolean active, Long clientId);

	@Query(value = "SELECT d.user FROM Decentralization d WHERE d.fileEntry.id =:fileId AND d.user.active=true AND d.active=:active AND d.clientId =:clientId order by d.user.fullName")
	List<User> findFileIdByUserId(@Param(value = "fileId") Long fileId, @Param(value = "active") boolean active, Long clientId);
	
	@Query(value = "SELECT DISTINCT d.folderEntry FROM Decentralization d WHERE d.user.id =:userId AND d.user.active=true AND d.active=:active AND d.clientId =:clientId AND d.folderEntry.active=true order by d.folderEntry.nodeId")
	List<FolderEntry> findFolderByUserIdAndActive(@Param(value = "userId") Long userId, @Param(value = "active") boolean active,Long clientId);

	@Query(value = "SELECT DISTINCT d.fileEntry FROM Decentralization d WHERE d.user.id =:userId AND d.user.active=true AND d.active=:active AND d.clientId =:clientId AND d.fileEntry.active=true order by d.folderEntry.nodeId")
	List<FileEntry> findFileByUserIdAndActive(@Param(value = "userId") Long userId, @Param(value = "active") boolean active, @Param(value = "clientId") Long clientId);
	
	@Query(value = "SELECT d FROM Decentralization d WHERE d.folderEntry.id =:folderId AND d.user.id =:userId AND d.active=:active AND d.clientId =:clientId order by d.user.fullName")
	Decentralization findFolderIdAndUserIdAndActive(@Param(value = "folderId") Long folderId, @Param(value = "userId") Long userId, @Param(value = "active") boolean active,Long clientId);
	
	@Query(value = "SELECT d FROM Decentralization d WHERE d.fileEntry.id =:fileId AND d.user.id =:userId AND d.active=:active AND d.clientId =:clientId order by d.user.fullName")
	Decentralization findFileIdAndUserIdAndActive(@Param(value = "fileId") Long fileId, @Param(value = "userId") Long userId, @Param(value = "active") boolean active, Long clientId);
	
	@Query(value = "SELECT d.folderEntry FROM Decentralization d WHERE d.user.userName=:userName AND d.clientId=:clientId")
	List<FolderEntry> findFolderByUserName(@Param(value= "userName") String userName, Long clientId);
	
	@Query(value = "SELECT d.fileEntry FROM Decentralization d WHERE d.user.userName=:userName AND d.clientId=:clientId")
	List<FileEntry> findFileByUserName(@Param(value= "userName") String userName, Long clientId);
	
	@Query(value = "SELECT d FROM Decentralization d WHERE d.userId IN (:userIds) AND d.folderId=:folderId AND d.clientId=:clientId AND d.active=true")
	List<Decentralization> findFolderByListUserId(List<Long> userIds, Long folderId, Long clientId);
	
	@Query(value = "SELECT d FROM Decentralization d WHERE d.userId IN (:userIds) AND d.fileId=:fileId AND d.clientId=:clientId AND d.active=true")
	List<Decentralization> findFileByListUserId(List<Long> userIds, Long fileId, Long clientId);
	
	@Query(value = "SELECT DISTINCT d.folderId FROM Decentralization d WHERE d.user.id =:userId AND d.user.active=true AND d.active=:active AND d.clientId =:clientId AND d.folderEntry.active=true")
	List<Long> findFolderIdByUserIdAndActive(@Param(value = "userId") Long userId, @Param(value = "active") boolean active,Long clientId);
	
	@Query(value = "SELECT DISTINCT d.fileId FROM Decentralization d WHERE d.user.id =:userId AND d.user.active=true AND d.active=:active AND d.clientId =:clientId AND d.fileEntry.active=true")
	List<Long> findFileIdByUserIdAndActive(@Param(value = "userId") Long userId, @Param(value = "active") boolean active, Long clientId);
}
