package com.ecodoc.backend.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "createDate", "updateDate", "createBy", "updateBy" })
public abstract class RootModel implements Serializable{

	private static final long serialVersionUID = 1L;

	// TODO: remove createDate, coalesce(p.updateDate, p.createDate)
	public static final Sort SIMPLE_SORT = Sort.by(Direction.DESC, "updateDate", "createDate");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "create_by")
	private Long createBy;

	@Column(name = "update_by")
	private Long updateBy;
}
