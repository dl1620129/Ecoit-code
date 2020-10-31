package com.ecodoc.backend.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EcoDOC
 * 
 */
@Entity
@Table(name = "SYS_CLIENTS", schema = "ecodoc")
@Getter
@Setter
public class Client extends RootModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String code;
	private String address;
	private String phone;
	private String salt;
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "ecodoc.sys_clients_id_seq", sequenceName = "ecodoc.sys_clients_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecodoc.sys_clients_id_seq")
	private Long id;
	
	@JoinColumn(name = "customer_type_id")
	private Long customerType ;
}
