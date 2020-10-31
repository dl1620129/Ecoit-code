package com.ecodoc.backend.business.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
 
// TODO: ext UserTreeDto
@Getter
@Setter
public class UserConditionDto extends UserPositionBase {
	private static final long serialVersionUID = 1L;

	private boolean lead;
	private Long org;
	private Long position;

	@JsonIgnore
	private Long orgId;
	@JsonIgnore
	private Long positionId;
	@JsonIgnore
	private Long userId;
	List<UserDelegateDto> delegateUsers;

	public UserConditionDto(Long id, boolean lead, Long org, Long position, String positionName, Integer positionOrder,
			String fullName, String userName, Long orgId, Long positionId, Long userId) {
		super(id, userName, fullName, positionName, positionOrder);
		this.lead = lead;
		this.org = org;
		this.position = position;

		this.orgId = orgId;
		this.positionId = positionId;
		this.userId = userId;
	}

	public boolean invalid() {
		return this.userId == null && this.orgId != null && this.positionId != null;
	}
}
