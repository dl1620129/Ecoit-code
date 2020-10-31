package com.ecodoc.backend.business.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecodoc.backend.business.domain.Notification;
import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.config.NotificationHandleStatusEnum;
import com.ecodoc.backend.core.repository.IRepository;

@Repository
public interface INotificationRepository extends IRepository<Notification>{

	Page<Notification> findByActiveAndUserIdOrderByIdDesc(Boolean active, Long userId, Pageable castToPageable);
	
//	@Query("SELECT n FROM Notification n WHERE n.id IN (SELECT max(id) FROM Notification t "
//			+ "WHERE t.userId = :userId and t.active = :active GROUP BY t.docId) "
//			+ "AND n.userId = :userId ORDER BY n.id DESC")
	@Query("SELECT n FROM Notification n WHERE n.userId = :userId and n.active = :active ORDER BY n.id DESC")
	List<Notification> getByActiveAndUserId(Boolean active, Long userId);

//	@Query("SELECT COUNT(n) FROM Notification n WHERE n.id IN (SELECT max(id) FROM Notification t "
//			+ "WHERE t.userId = :userId AND t.active = :active GROUP BY t.docId) "
//			+ "AND n.userId = :userId AND n.read = :read")
	@Query("SELECT COUNT(n) FROM Notification n WHERE n.userId = :userId and n.active = :active AND n.read = :read")
	Long countByActiveAndUserIdAndRead(Boolean active, Long userId, Boolean read);

	@Transactional
	@Modifying()
	@Query("UPDATE Notification n SET n.active = false WHERE n.userId = :userId")
	void deactiveAllByUserId(Long userId);

	@Transactional
	@Modifying()
	@Query("UPDATE Notification n SET n.active = false WHERE n.id IN (:listIds)")
	void deactiveAllByIds(Long[] listIds);

	@Transactional
	@Modifying()
	@Query("UPDATE Notification n SET n.active = false WHERE n.docId = :docId ")
	void deactiveAllByDocIdAndDocType(Long docId);

	@Transactional
	@Modifying()
	@Query("UPDATE Notification n SET n.active = :active WHERE n.docId = :docId")
	void setActiveByDocIdAndDocType(Long docId, Boolean active);

	@Transactional
	@Modifying()
	@Query("UPDATE Notification n SET n.active = :active WHERE n.docId = :docId and n.userId IN (:listUsers)")
	void setActiveByListUserIdAndDocIdAndDocType(List<Long> listUsers, Long docId, boolean active);
	
	@Transactional
	@Modifying()
	@Query("UPDATE Notification n SET n.active = :active WHERE n.docId = :docId and n.userId = :userId ")
	void setActiveByUserIdAndDocIdAndDocType(Long userId, Long docId, boolean active);

	@Transactional
	@Modifying()
	@Query("UPDATE Notification n SET n.active = :active WHERE n.docId = :docId and n.userId = :userId AND n.docStatus IN (:listStatus)")
	void setActiveByDocIdAndDocTypeAndUserIdAndDocStatus(boolean active, Long docId, Long userId, List<NotificationHandleStatusEnum> listStatus);

	@Transactional
	@Modifying()
	@Query("UPDATE Notification n SET n.read = :read WHERE n.docId = :docId and n.userId = :userId ")
	void setReadByDocIdAndDocTypeAndUserId(boolean read, Long docId,  Long userId);

	@Transactional
	@Modifying()
	@Query("UPDATE Notification n SET n.read = :read WHERE n.id = :id AND n.userId = :userId")
	void setReadByIdAndUserId(boolean read, Long id, Long userId);

	@Query("SELECT n FROM Notification n WHERE n.userId = :userId and n.active = :active and n.docId=:docId and n.docStatus = (:docStatus) and n.moduleCode = :module ORDER BY n.id DESC")
	List<Notification> getByUserId(Long userId, Long docId, boolean active, NotificationHandleStatusEnum docStatus, ModuleCodeEnum module);
}
