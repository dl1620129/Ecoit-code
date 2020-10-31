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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Constant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author EcoDoc
 * 
 */
@Entity
@Table(name = "DECENTRALIZATION", schema = "ecodoc", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "species", "node_id" }) })
@Data
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Decentralization extends BaseModel implements Serializable{
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "ecodoc.decentralization_id_seq", sequenceName = "ecodoc.decentralization_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecodoc.decentralization_id_seq")
	private Long id;
	
	@Column(name = "species")
	private Long species;

	@Column(name = "node_id")
	private String nodeId;
	
	@Column(name = "role")
	private String Role;
	
	@Column(name = "position")
	private Long position;
	
	@Column(name = "id_permission")
	private Long idPermission;
	
	@Transient
	private List<Decentralization> subDecentralization;
	
	public void set(Decentralization d) {
		this.nodeId = BussinessCommon.cutCharacter(d.getNodeId(), Constant.FOLDERENTRY_NODEID_LENGTH, true, "nodeId", Constant.FOLDERENTRY_NODEID);
	}
}
