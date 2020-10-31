package com.ecodoc.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	private int no;
	private Long positionId;
	private Integer positionOrder;
	private Long orgId;
	private String positionName;
	private String orgName;
}
