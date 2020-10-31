package com.ecodoc.backend.core.dto;

import com.ecodoc.backend.core.domain.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTreeDto {
	private Long id;
	private Long orgId;
	private Boolean lead;
	private Long positionId;
	private String positionName;
	private Integer positionOrder;
	private String fullName;
	private String userName;


	public UserTreeDto(Long id, Long orgId, Category position, String fullName, String userName, Boolean lead) {
		this.id = id;
		this.orgId = orgId;
		this.positionId = position.getId();
		// TODO: get this info by one query
		this.positionName = position.getName();
		this.positionOrder = position.getOrder();
		this.fullName = fullName;
		if (this.fullName != null) {
			this.fullName = fullName.trim();
		}
		this.userName = userName;
		if (this.userName != null) {
			this.userName = userName.trim();
		}
		this.lead = lead;
	}
}
