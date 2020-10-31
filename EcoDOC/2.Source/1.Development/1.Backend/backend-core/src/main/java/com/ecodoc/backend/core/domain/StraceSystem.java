package com.ecodoc.backend.core.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SYS_STRACE", schema = "ecodoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StraceSystem {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "username", nullable = false)
	private String userName;
	
	@Column(name = "ip_device", length = 50)
	private String ipDevice;
	
	@Column(name = "name_device", length = 50)
	private String nameDevice;
	
	@Column(name = "action")
	private String action;
	
	@JoinColumn(name = "id_cat")
	private Long idCat;
	
    @Column(name = "id_client")
	private Long clientId;
	
	@Column(name = "id_content")
	private Long contentId;
	
	@Column(columnDefinition="TEXT", name = "content")
	private String content;
	
	@Column(name = "create_date")
	private Date createDate;
}
