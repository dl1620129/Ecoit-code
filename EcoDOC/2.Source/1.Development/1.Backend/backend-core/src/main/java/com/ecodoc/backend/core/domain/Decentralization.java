package com.ecodoc.backend.core.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Constant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author EcoDoc
 * 
 */
@Entity
@Table(name = "DECENTRALIZATION", schema = "ecodoc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Decentralization extends BaseModel implements Serializable{

	@Column(name = "folderId")
	private Long folderId;
	
	@Column(name = "fileId")
	private Long fileId;
	
	@Column(name = "permission")
	private Long permission;
	
	@Column(name = "sys_user_id")
	private Long userId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sys_user_id", insertable = false, updatable = false)
	private User user;
	
	@OneToOne
	@JoinColumn(name = "folderId", insertable = false, updatable = false)
	private FolderEntry folderEntry;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fileId", insertable = false, updatable = false)
	private FileEntry fileEntry;
}
