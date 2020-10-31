package com.ecodoc.backend.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecodoc.backend.core.domain.StraceSystem;
import com.ecodoc.backend.core.dto.StraceAdminDto;
import com.ecodoc.backend.core.dto.StraceDto;

@Repository
public interface IStraceSystemRepository extends JpaRepository<StraceSystem, Long> {

	@Query("select new com.ecodoc.backend.core.dto.StraceDto(d.content , d.createDate, d.userName, c.name, d.ipDevice, d.nameDevice, d.action) "
			+ " from StraceSystem d join MapCategory c on c.catId = d.idCat and c.clientId = :clientId and d.clientId=:clientId "
			+ " where (:userName is null or lower(d.userName) like %:userName%) "
			+ " and (:idCat is null or d.idCat = :idCat) "
			+ " and (coalesce(:startDate, null) is null or d.createDate > :startDate) "
			+ " and (coalesce(:endDate, null) is null or d.createDate < :endDate) "
			)
	List<StraceDto> search(String userName, Date startDate, Date endDate, Long idCat, Long clientId, Sort sort);

	@Query("select new com.ecodoc.backend.core.dto.StraceDto(d.content , d.createDate, d.userName, c.name, d.ipDevice, d.nameDevice, d.action) "
			+ " from StraceSystem d join MapCategory c on c.catId = d.idCat and c.clientId = :clientId and d.clientId=:clientId "
			+ " where (:userName is null or lower(d.userName) like %:userName%) "
			+ " and (:idCat is null or d.idCat = :idCat) "
			+ " and (coalesce(:startDate, null) is null or d.createDate > :startDate) "
			+ " and (coalesce(:endDate, null) is null or d.createDate < :endDate) "
			)
	Page<StraceDto> search(String userName, Date startDate, Date endDate, Long idCat, Long clientId, Pageable page);

	@Query(" select new com.ecodoc.backend.core.dto.StraceAdminDto(c.name, count(s.ipDevice) as count)" 
			+ " from StraceSystem s join Client c on c.id = s.clientId "
			+ " where (:idCat is null or c.id = :idCat) "
			+ " and (:quarterly is null or EXTRACT(MONTH FROM s.createDate) between :toMonth and :frMonth )"
			+ " and (:year is null or EXTRACT(YEAR FROM s.createDate) = :year) "
			+ " and (:month is null or EXTRACT(MONTH FROM s.createDate) = :month) "
			+ " and (coalesce(:startDate, null) is null or s.createDate > :startDate) "
			+ " and (coalesce(:endDate, null) is null or s.createDate < :endDate) "
			+ " group by c.name"
			)
	Page<StraceAdminDto> searchAdmin(Date startDate, Date endDate, Long idCat, Integer frMonth, Integer toMonth,
			Integer month, Integer year, Integer quarterly, Pageable pageable);

}
