/**
 * 
 */
package com.ecodoc.backend.core.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.lang.NonNull;

import com.ecodoc.backend.core.auth.SecurityContext;
import com.ecodoc.backend.core.config.ActionEnum;
import com.ecodoc.backend.core.config.CategoryEnum;
import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.config.HandleTypeEnum;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.ListObjectDto;
import com.ecodoc.backend.core.dto.ListObjectDtoOrder;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestFieldExceptionHandler;
import com.ecodoc.backend.util.StringUtils;

/**
 * @author EcoDOC
 *
 */
public class BussinessCommon {
	public static <T> ListObjectDto<T> getListByPageNumber(List<T> list, Integer pageNumber) {
		ListObjectDto<T> objectList = new ListObjectDto<>();
		if (list != null && !list.isEmpty()) {
			long totalRecords = list.size();
			int rowCount = Constant.NUMBER_OF_PAGE;
			long totalPage = totalRecords % rowCount > 0 ? totalRecords / rowCount + 1 : totalRecords / rowCount;
			if ((pageNumber != null && pageNumber.intValue() == 0)
					|| (pageNumber != null && pageNumber.intValue() > totalPage)) throw new RestExceptionHandler(Message.INVALID_PAGE);
			int offset = pageNumber != null && pageNumber.intValue() > 1 ? (pageNumber - 1) * rowCount : 0;
			objectList.setObjList(list.subList(offset, (int) Math.min(offset + rowCount, totalRecords)));
			objectList.setTotalPage(totalPage);
			objectList.setTotalRecord(totalRecords);
		}
		return objectList;
	}

	public static <T> ListObjectDto<T> paging(Page<T> pList) {
		ListObjectDto<T> list = new ListObjectDto<>();
		if (pList == null || pList.isEmpty()) return list;
		list.setObjList(pList.getContent());
		list.setTotalPage(pList.getTotalPages());
		list.setTotalRecord(pList.getTotalElements());
		return list;
	}
	
	public static <T> ListObjectDto<T> convert(List<T> pList) {
		ListObjectDto<T> list = new ListObjectDto<>();
		if (pList == null || pList.isEmpty()) return list;
		long totalRecords = pList.size();
		int rowCount = Constant.NUMBER_OF_PAGE;
		long totalPage = totalRecords % rowCount > 0 ? totalRecords / rowCount + 1 : totalRecords / rowCount;
		list.setObjList(pList);
		list.setTotalPage(totalPage);
		list.setTotalRecord(totalRecords);
		return list;
	}
	
	public static <T> ListObjectDtoOrder<T> paging(Page<T> pList, long order) {
		ListObjectDtoOrder<T> list = new ListObjectDtoOrder<>();
		list.setNextOrder(order);
		if (pList == null || pList.isEmpty()) return list;
		list.setTotalPage(pList.getTotalPages());
		list.setObjList(pList.getContent());
		list.setTotalRecord(pList.getTotalElements());
		//list.setNextOrder(order);
		return list;
	}

	public static Integer setPageNumber(String page) {
		if ("".equals(page)  || page == null || page.length() == 0) return 1;

		if (Integer.parseInt(page) <= 0 || !StringUtils.isInteger(page)) {
			throw new RestExceptionHandler(Message.INVALID_PAGE);
		}

		return Integer.parseInt(page);
	}

	public static Long castId(String id) {
		if ("".equals(id) ||  id == null || id.length() == 0)
			return null;

		if (Integer.parseInt(id) <= 0 || !StringUtils.isInteger(id)) {
			throw new RestExceptionHandler(Message.INVALID_ID);
		}

		return Long.parseLong(id);
	}

	public static void validId(String id) {
		if ("".equals(id) || id == null || id.length() == 0)
			throw new RestExceptionHandler(Message.NO_INPUT_DATA);

		if (Integer.parseInt(id) <= 0 || !StringUtils.isInteger(id)) {
			throw new RestExceptionHandler(Message.INVALID_ID);
		}
	}


	public static String castString(String name) {
		if ("".equals(name) || name == null || name.length() == 0)
			return null;
		return name;
	}

	public static Pageable castToPageable(Integer page) {
		return PageRequest.of(page-1, Constant.NUMBER_OF_PAGE);
	}
	
	public static Pageable castToPageable(Integer page, Sort sort) {
		return PageRequest.of(page-1, Constant.NUMBER_OF_PAGE, sort);
	}
	
	public static Pageable castToPageable(Integer page, Sort sort, int numberOfPage) {
		return PageRequest.of(page-1, numberOfPage, sort);
	}
	
	public static Pageable castToPageable(Integer page, JpaSort sort, int numberOfPage) {
		return PageRequest.of(page-1, numberOfPage, sort);
	}

	@NonNull
	public static Long getClientId() {
		User user = getUser();
		Long clientId = user.getClientId();
		if (clientId == null) {
			throw new RestExceptionHandler(Message.INVALID_ACCOUNT);
		}
		return clientId;
	}

	@NonNull
	public static Long getUserId() {
		User user = getUser();
		Long id = user.getId();
		if (id == null) {
			throw new RestExceptionHandler(Message.INVALID_ACCOUNT);
		}
		return id;
	}

	@NonNull
	public static User getUser() {
		User u = SecurityContext.getCurrentUser();
		if (u == null) throw new RestExceptionHandler(Message.INVALID_ACCOUNT);
		return u;
	}

	public static <T> void validArr(T[] arr) {
		if(ArrayUtils.isEmpty(arr) || arr == null || arr.length == 0) throw new RestExceptionHandler(Message.INVALID_FIELD);
	}

	public static HandleTypeEnum setTypeEnum(HandleTypeEnum type) {
		if (HandleTypeEnum.MAIN.equals(type)) {
			return HandleTypeEnum.MAIN;
		} else if (HandleTypeEnum.SUPPORT.equals(type)) {
			return HandleTypeEnum.SUPPORT;
		} else {
			return HandleTypeEnum.SHOW;
		}
	}

	public static String getTypeEnum(HandleTypeEnum type) {
		if (HandleTypeEnum.MAIN.equals(type)) {
			return Constant.MAIN;
		} else if (HandleTypeEnum.SUPPORT.equals(type)) {
			return Constant.SUPPORT;
		} else {
			return Constant.SHOW;
		}
	}

	public static String getAction(String type) {
		if (ActionEnum.ADD.getName().equals(type)) {
			return Constant.ACTION_ADD;
		} else if (ActionEnum.TRANSFER_HANDLE.getName().equals(type)) {
			return Constant.ACTION_TRANFER_HANDLE;
		} else if (ActionEnum.COMMING_TO.getName().equals(type)) {
			return Constant.ACTION_COMMING_TO;
		} else if (ActionEnum.READ.getName().equals(type)) {
			return Constant.ACTION_READ;
		} else if (ActionEnum.RETURN_DOC.getName().equals(type)) {
			return Constant.ACTION_RETURN_DOC;
		} else if (ActionEnum.ISSUED.getName().equals(type)) {
			return Constant.ACTION_ISSUED;
		} else if (ActionEnum.COMMENT.getName().equals(type)) {
			return Constant.ACTION_COMMENT;
		} else if (ActionEnum.LOGIN.getName().equals(type)) {
			return Constant.ACTION_LOGIN;
		} else if (ActionEnum.DONE.getName().equals(type)) {
			return Constant.ACTION_DONE;
		} else {
			return Constant.ACTION_UNKNOW;
		}
	}
	
	

	public static void validCatId(Long catId) {
		if(CategoryEnum.getEnum(catId) == null) throw new RestExceptionHandler(Message.NOT_FOUND_OBJECT);
	}

	public static Long[] castStringToLongArray(String input) {
		List<Long> idList =  new ArrayList<>();
		Long[] idLs = new Long[0];
		String tempReplyIds = StringUtils.cutAllSpace(input);
		if (!StringUtils.isNullOrEmpty(input, true) && ( tempReplyIds != null)) {
			String[] ids = tempReplyIds.split(",");
			if (ids != null && ids.length > 0) {
				for (String st : ids) {
					BussinessCommon.validId(st);
					idList.add(Long.parseLong(st));
				}
				idLs = idList.stream().toArray(n -> new Long[n]);
			}
		}
		return idLs;
	}

	public static <T> boolean isEmptyArr(T[] arr) {
		if(ArrayUtils.isEmpty(arr) || arr == null || arr.length == 0) return true;
		return false;
	}
	
	public static <T> boolean isEmptyPage(Page<T> page) {
		if(page != null && page.getTotalElements() > 0) return false;
		return true;
	}
	
	public static <T> boolean isEmptyList(List<T> list) {
		if(list == null || list.isEmpty() || list.size() == 0) return true;
		return false;
	}
	
	public static String convert(String str) {
		return StringUtils.isNullOrEmpty(str) ? null : str.trim().toLowerCase();
	}
	
	public static Long convert(Long str) {
		return str == null || str.longValue() == 0L ? null : str;
	}
	
	public static String cutCharacter(String str, int num, boolean isRequire, String field, String fieldName) {
		if(isRequire && StringUtils.isNullOrEmpty(str)) throw new RestFieldExceptionHandler(field, fieldName + Message.NO_INPUT);
		if (field.equals("phone") && !org.apache.commons.lang.StringUtils.isNumericSpace(str)) {
			throw new RestFieldExceptionHandler(field, fieldName + Message.FIELD_INVALID);
		}
		if(!StringUtils.isNullOrEmpty(str)) {
			if(length(str) > num) return str.trim().substring(0, num);
			if(length(str) <= num) return str.trim();
		}
		return str.trim();
	}
	
	public static int length(String str) {
		return str != null ? str.trim().length() : 0;
	}
	
	public static Long required(Long f, String field, String fieldName) {
		if(f == null || f == 0L) throw new RestFieldExceptionHandler(field, fieldName + Message.NO_INPUT);
		return f;
	}
	
	public static Date getZeroTimeDate(Date date) {
		Date res = date;
	    Calendar calendar = Calendar.getInstance();

	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);

	    res = calendar.getTime();

	    return res;
	}
	
	//type = 1 : get first / type = 2: get last
	public static Long convert(String str, int type) {
		if ("".equals(str) ||  str == null || str.length() == 0) return null;
		String[] arr = str.split("-");
		for (int i = 0; i < arr.length; i++) {
			if(!isNumeric(arr[i])) return null;
		}
		if(type == 1 && arr.length >=1) return Long.parseLong(arr[0]);
		if(type == 2 && arr.length >=2) return Long.parseLong(arr[1]);
		return null;
	}
	
	public static boolean isNumeric(String str) {
		try {
			Long.parseLong(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void validLengthData(String str, String column, int max) {
		if(!StringUtils.isNullOrEmpty(str)) {
			if(str.length() > max) throw new RestExceptionHandler(column + " chỉ tối đa "+ max + " kí tự.");
		}
	}
}
