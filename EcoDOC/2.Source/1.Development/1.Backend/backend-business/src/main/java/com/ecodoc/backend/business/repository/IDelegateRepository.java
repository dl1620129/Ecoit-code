package com.ecodoc.backend.business.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.business.domain.Delegate;
import com.ecodoc.backend.business.dto.DelegateDto;
import com.ecodoc.backend.business.dto.UserDelegateDto;
import com.ecodoc.backend.core.repository.IRepository;

@Repository
public interface IDelegateRepository extends IRepository<Delegate> {

	@Query("SELECT count(*)>0 FROM Delegate d WHERE d.fromUserId = :fromUser AND d.toUserId = :toUser AND d.startDate <= :date AND d.endDate >= :date")
	boolean existFromUserByToUser(Long fromUser, Long toUser, Date date);

	@Query("select d.fromUserId from Delegate d where d.toUserId =:toUserId and d.active=true and d.startDate <= :date and d.endDate >= :date group by d.fromUserId ")
	List<Long> getListFrUserByToUser(Long toUserId, Date date);
	
	@Query("select d.toUserId from Delegate d where d.fromUserId = (:frUsers) and d.active=true and d.clientId=:clientId and d.startDate <= :date and d.endDate >= :date group by d.toUserId ")
	List<Long> getListToUserByFrUser(Long frUsers, Date date, Long clientId);

	@Query("SELECT new com.ecodoc.backend.business.dto.DelegateDto(de.id, de.numberOrSign, de.fromUserId, de.fromUser.fullName, de.toUserId, de.toUser.fullName, de.startDate, de.endDate) "
			+ "FROM Delegate de WHERE de.fromUser.org=:yourOrg AND de.active is TRUE")
	Page<DelegateDto> list(Long yourOrg, Pageable pageable);

	@Query("SELECT new com.ecodoc.backend.business.dto.DelegateDto(de.id, de.numberOrSign, de.fromUserId, de.fromUser.fullName, de.toUserId, de.toUser.fullName, de.startDate, de.endDate) "
			+ "FROM Delegate de WHERE de.fromUser.org=:yourOrg AND de.active is TRUE AND("
			+ ":text is NULL OR LOWER(de.numberOrSign) LIKE '%'||:text||'%' OR LOWER(de.fromUser.userName)=:text OR LOWER(de.fromUser.fullName) LIKE '%'||:text||'%' "
			+ " OR LOWER(de.toUser.userName)=:text OR LOWER(de.toUser.fullName) LIKE '%'||:text||'%')")
	Page<DelegateDto> quickSearch(String text, Long yourOrg, Pageable pageable);

	@Query("SELECT new com.ecodoc.backend.business.dto.DelegateDto(de.id, de.numberOrSign, de.fromUserId, de.fromUser.fullName, de.toUserId, de.toUser.fullName, de.startDate, de.endDate) "
			+ "FROM Delegate de WHERE de.fromUser.org=:yourOrg AND de.active is TRUE "
			+ "AND (:numberOrSign is NULL OR LOWER(de.numberOrSign) LIKE %:numberOrSign%)"
			+ "AND (:fromUser is NULL OR LOWER(de.fromUser.userName)=:fromUser OR LOWER(de.fromUser.fullName) LIKE '%'||:fromUser||'%')"
			+ "AND (:toUser is NULL OR LOWER(de.toUser.userName)=:toUser OR LOWER(de.toUser.fullName) LIKE '%'||:toUser||'%')"
			+ "AND (coalesce(:startDate, null) is NULL OR de.startDate > :startDate) AND (coalesce(:endDate, null) is NULL OR de.endDate < :endDate)")
	Page<DelegateDto> search(String numberOrSign, String fromUser, String toUser, Date startDate, Date endDate,
			Long yourOrg, Pageable pageable);
	
	@Query("SELECT new com.ecodoc.backend.business.dto.UserDelegateDto(de.id, de.endDate, de.fromUserId, de.toUser.id, de.toUser.userName, de.toUser.fullName, de.toUser.positionModel.name, de.toUser.positionModel.order) "
			+ "FROM Delegate de WHERE de.startDate < :now and :now < de.endDate and de.fromUserId IN :fromIds AND de.active is TRUE")
	List<UserDelegateDto> getDelegateByIds(Set<Long> fromIds, Date now);

	@Query("select d.toUserId from Delegate d where d.id = :delegateId and d.active=true and d.startDate <= :date and d.endDate >= :date")
	Long findByIdAndDate(Long delegateId, Date date);
}
