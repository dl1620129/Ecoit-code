package com.ecodoc.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class SignerDto {
	int no;
	private Long id;
	private String fullName;
	private String orgName;
	private String position;
	private String phone;
}
