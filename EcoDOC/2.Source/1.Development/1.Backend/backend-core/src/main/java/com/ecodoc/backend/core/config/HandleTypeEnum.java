package com.ecodoc.backend.core.config;

import java.util.ArrayList;
import java.util.List;

import com.ecodoc.backend.core.common.BussinessCommon;

public enum HandleTypeEnum {
	MAIN, SUPPORT, SHOW;
	
	public static List<HandleTypeEnum> getListHandleType(HandleTypeEnum...types) {
		if(BussinessCommon.isEmptyArr(types)) return null;
		List<HandleTypeEnum> list = new ArrayList<>();
		for (HandleTypeEnum t : types) {
			list.add(t);
		}
		return list;
	}

}