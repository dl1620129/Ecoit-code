package com.ecodoc.backend.core.dto;

import java.util.Date;

import com.ecodoc.backend.core.common.BussinessCommon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PreferencesDto {
	private Long id;
	private String name;
	
	public PreferencesDto convert(PreferencesDto po) {
		po.name = BussinessCommon.convert(po.getName());
		
		return po;
	}
}
