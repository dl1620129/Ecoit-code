
package com.ecodoc.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DecentralizationDto {
	private Long id;
	private Long type;
	private String nodeId;
	private Long idPermission;
	private Long position;
	private Long idRole;
	
}
