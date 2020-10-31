package com.ecodoc.backend.core.dto;

import java.util.Date;

import com.ecodoc.backend.core.common.BussinessCommon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModuleAdminDto {
	private Long id;
	private String name;
	private String code;
	private Boolean active;
	private Date startDateSearch;
	private Date endDateSearch;
	
	public ModuleAdminDto convert(ModuleAdminDto mao) {
		mao.name = BussinessCommon.convert(mao.getName());
		mao.code = BussinessCommon.convert(mao.getCode());
		if (mao.getStartDateSearch() == null) {
			mao.setStartDateSearch(new Date(0));
		}
		if (mao.getEndDateSearch() == null) {
			mao.setEndDateSearch(new Date());
		}
		mao.startDateSearch = mao.getStartDateSearch();
		mao.endDateSearch = mao.getEndDateSearch();
		mao.id = BussinessCommon.convert(mao.getId());
		return mao;
	}
}
