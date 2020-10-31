package com.ecoit.lichcongtac.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ecoit.lichcongtac.object.GenericObject;
import com.ecoit.lichcongtac.object.LichChiTietObject;
import com.ecoit.lichcongtac.object.LichCongTacObject;
import com.ecoit.lichcongtac.services.model.LichChiTiet;
import com.ecoit.lichcongtac.services.model.LichCongTac;
import com.ecoit.lichcongtac.services.service.LichChiTietLocalServiceUtil;
import com.ecoit.lichcongtac.services.service.LichCongTacLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;

public class LichCongTacUtil {

	public static void createUpdateLichCongTac(long lichCongTacId, LichCongTacObject lichCongTacObject, String locale, long groupId, long userId, long companyId) throws Exception {
		String name = HtmlUtil.escape(lichCongTacObject.getName());
		String lyDoTraVe = HtmlUtil.escape(lichCongTacObject.getLyDoTraVe());
		String organizations = "";
		/*if (lichCongTacObject.getOrganizations() != null) {
			organizations = HtmlUtil.escape(lichCongTacObject.getOrganizations().toString());
		}*/
		
		String users = "";
		if (lichCongTacObject.getUsers() != null) {
			users = HtmlUtil.escape(lichCongTacObject.getUsers().toString());
		}
		
		int status = getLichCongTacStatus(lichCongTacObject.getAction());
		
		//set start date
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
		dateFormat.setTimeZone(timeZone);
		
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = newFormat.parse(dateFormat.format(lichCongTacObject.getStartDate()));
		Date endDate = newFormat.parse(dateFormat.format(lichCongTacObject.getEndDate()));
		
		LichCongTac lichCongTac = LichCongTacLocalServiceUtil.createUpdateLichCongTac(lichCongTacId, locale, groupId, userId, lichCongTacObject.isCoLyDo(), 
				lyDoTraVe, companyId, lichCongTacObject.getOrganizationId(), name, startDate,
				endDate, organizations, users, status);
		for (LichChiTietObject lichChiTietObject : lichCongTacObject.getLichChiTietList()) {
			String description = HtmlUtil.escape(lichChiTietObject.getDescription());
			String address = HtmlUtil.escape(lichChiTietObject.getAddress());
			String note = HtmlUtil.escape(lichChiTietObject.getNote());
			
			String nguoiThamDu = "";
			if (lichChiTietObject.getNguoiThamDu() != null) {
				JSONArray nguoiThamDuArray = JSONFactoryUtil.createJSONArray(lichChiTietObject.getNguoiThamDu());
				nguoiThamDu = HtmlUtil.escape(nguoiThamDuArray.toJSONString());
			}
			
			String nguoiChuTri = "";
			if (lichChiTietObject.getNguoiChuTri() != null) {
				JSONArray nguoiChuTriArray = JSONFactoryUtil.createJSONArray(lichChiTietObject.getNguoiChuTri());
				nguoiChuTri = HtmlUtil.escape(nguoiChuTriArray.toJSONString());
			}
			
			Date selectedDate = newFormat.parse(dateFormat.format(lichChiTietObject.getSelectedDate()));
			LichChiTietLocalServiceUtil.createUpdateLichChiTiet(0, groupId, userId, companyId, description, lichChiTietObject.getStartTime(), lichCongTacObject.getOrganizationId(),
					selectedDate, nguoiThamDu, nguoiChuTri, lichCongTac.getLichCongTacId(), address, note, status, locale, false, "");
		}
	}
	
	public static void updateLichChiTiet(long lichChiTietId, LichChiTietObject lichChiTietObject, String locale, long groupId, long userId, long companyId) throws Exception {
		int status = getLichCongTacStatus(lichChiTietObject.getAction());
		String description = HtmlUtil.escape(lichChiTietObject.getDescription());
		String address = HtmlUtil.escape(lichChiTietObject.getAddress());
		String note = HtmlUtil.escape(lichChiTietObject.getNote());
		
		String nguoiThamDu = "";
		if (lichChiTietObject.getNguoiThamDu() != null) {
			JSONArray nguoiThamDuArray = JSONFactoryUtil.createJSONArray(lichChiTietObject.getNguoiThamDu());
			nguoiThamDu = HtmlUtil.escape(nguoiThamDuArray.toJSONString());
		}
		
		String nguoiChuTri = "";
		if (lichChiTietObject.getNguoiChuTri() != null) {
			JSONArray nguoiChuTriArray = JSONFactoryUtil.createJSONArray(lichChiTietObject.getNguoiChuTri());
			nguoiChuTri = HtmlUtil.escape(nguoiChuTriArray.toJSONString());
		}
		
		LichChiTietLocalServiceUtil.createUpdateLichChiTiet(lichChiTietId, groupId, userId, companyId, description, lichChiTietObject.getStartTime(), lichChiTietObject.getOrganizationId(),
				lichChiTietObject.getSelectedDate(), nguoiThamDu, nguoiChuTri, 0, address, note, status, locale, lichChiTietObject.isCoLyDo(), lichChiTietObject.getLyDoTraVe());
	}
	
	public static LichCongTacObject createLichCongTacObject(LichCongTac lichCongTac) throws Exception {
		LichCongTacObject lichCongTacObject = new LichCongTacObject();
		lichCongTacObject.setLichCongTacId(lichCongTac.getLichCongTacId());
		lichCongTacObject.setName(HtmlUtil.extractText(lichCongTac.getTenLich()));
		lichCongTacObject.setStartDate(lichCongTac.getNgayBatDau());
		lichCongTacObject.setEndDate(lichCongTac.getNgayKetThuc());
		lichCongTacObject.setLyDoTraVe(HtmlUtil.extractText(lichCongTac.getLydoTraVe()));
		
		try {
			Organization org = OrganizationLocalServiceUtil.getOrganization(lichCongTac.getOrganizationId());
			lichCongTacObject.setOrganizationId(org.getOrganizationId());
			lichCongTacObject.setOrganizationName(org.getName());
		} catch (Exception e) {
			lichCongTacObject.setOrganizationId(0);
			lichCongTacObject.setOrganizationName("");
		}
		
		//parse JSON string for organization
		/*JSONArray organizationsArray = JSONFactoryUtil.createJSONArray(lichCongTac.getLichChuyenBanNganh());
		List<String> ogranizations = new ArrayList<>();
		for (int i =0; i < organizationsArray.length(); i++) {
			try {
				ogranizations.add(organizationsArray.getString(i));
			} catch (Exception e){
				
			}
		} 
		lichCongTacObject.setOrganizations(ogranizations);*/
		
		//parse JSON string for user
		/*JSONArray usersArray = JSONFactoryUtil.createJSONArray(lichCongTac.getLichChuyenNguoiDung());
		List<String> users = new ArrayList<>();
		for (int i =0; i < usersArray.length(); i++) {
			try {
				users.add(usersArray.getString(i));
			} catch (Exception e){
				
			}
		}*/
		//lichCongTacObject.setUsers(users);
		List<LichChiTietObject> lichChiTietObjectList = new ArrayList<>();
		List<LichChiTiet> lichChiTietList = LichChiTietLocalServiceUtil.getByLichCongTacId(lichCongTac.getLichCongTacId());
		if (lichChiTietList != null) {
			for (LichChiTiet lichChiTiet : lichChiTietList) {
				LichChiTietObject lichChiTietObject = createLichChiTietObject(lichChiTiet);				
				lichChiTietObjectList.add(lichChiTietObject);
			}
		}
		lichCongTacObject.setLichChiTietList(lichChiTietObjectList);
		return lichCongTacObject;
	}
	
	public static LichChiTietObject createLichChiTietObject(LichChiTiet lichChiTiet) throws Exception {
		LichChiTietObject lichChiTietObject = new LichChiTietObject();
		lichChiTietObject.setLichChiTietId(lichChiTiet.getLichChiTietId());
		lichChiTietObject.setSelectedDate(lichChiTiet.getSelectedDate());
		lichChiTietObject.setDescription(HtmlUtil.extractText(lichChiTiet.getMoTa()));
		lichChiTietObject.setStartTime(lichChiTiet.getGioBatDau());
		
		//parse JSON string for nguoi tham du
		System.out.println(lichChiTiet.getNguoiThamDu());
		List<GenericObject> nguoiThamDu = new ArrayList<>();
		try {
			JSONArray nguoiThamDuArray = JSONFactoryUtil.createJSONArray(HtmlUtil.extractText(lichChiTiet.getNguoiThamDu()));
			for (int i =0; i < nguoiThamDuArray.length(); i++) {
				JSONObject object = nguoiThamDuArray.getJSONObject(i);
				GenericObject nguoiThamDuObject = new GenericObject();
				nguoiThamDuObject.setId(object.getString("id"));
				nguoiThamDuObject.setName(object.getString("name"));
				nguoiThamDu.add(nguoiThamDuObject);
			}
		} catch (Exception e) {
			
		}
		lichChiTietObject.setNguoiThamDu(nguoiThamDu);
		
		//parse JSON string for nguoi chu tri
		List<GenericObject> nguoiChuTri = new ArrayList<>();
		try {
			JSONArray nguoiChuTriArray = JSONFactoryUtil.createJSONArray(HtmlUtil.extractText(lichChiTiet.getNguoiChuTri()));
			for (int i =0; i < nguoiChuTriArray.length(); i++) {
				JSONObject object = nguoiChuTriArray.getJSONObject(i);
				GenericObject nguoiChuTriObject = new GenericObject();
				nguoiChuTriObject.setId(object.getString("id"));
				nguoiChuTriObject.setName(object.getString("name"));
				nguoiChuTri.add(nguoiChuTriObject);
			}
		} catch (Exception e) {
			
		}

		lichChiTietObject.setNguoiChuTri(nguoiChuTri);
		
		lichChiTietObject.setAddress(HtmlUtil.extractText(lichChiTiet.getAddress()));
		lichChiTietObject.setNote(HtmlUtil.extractText(lichChiTiet.getNote()));
		lichChiTietObject.setLyDoTraVe(HtmlUtil.extractText(lichChiTiet.getLydoTraVe()));
		try {
			Organization org = OrganizationLocalServiceUtil.getOrganization(lichChiTiet.getOrganizationId());
			lichChiTietObject.setOrganizationId(org.getOrganizationId());
			lichChiTietObject.setOrganizationName(org.getName());
		} catch (Exception e) {
			lichChiTietObject.setOrganizationId(0);
			lichChiTietObject.setOrganizationName("");
		}
		
		String lichCongTacName = "";
		try {
			LichCongTac lichCongTac = LichCongTacLocalServiceUtil.getLichCongTac(lichChiTiet.getLichCongTacId());
			lichCongTacName = lichCongTac.getTenLich();
		} catch (Exception e) {
			
		}
		lichChiTietObject.setTenLich(lichCongTacName);
		return lichChiTietObject;
	}
	
	public static int getLichCongTacStatus(int action) {
		int statusDoc = LichWorkflowConstants.STATUS_DRAFT;
		switch(action) {
		case LichCongTacRoleConstants.SCHEDULE_ADD:
			statusDoc = LichWorkflowConstants.STATUS_DRAFT;
		    break;
		case LichCongTacRoleConstants.SCHEDULE_PENDING:
			statusDoc = LichWorkflowConstants.STATUS_PENDING;
		    break;
		case LichCongTacRoleConstants.SCHEDULE_APPROVED:
			statusDoc = LichWorkflowConstants.STATUS_APPROVED;
		    break;
		case LichCongTacRoleConstants.SCHEDULE_PUBLISH:
			statusDoc = LichWorkflowConstants.STATUS_PUBLISH;
		    break;
		case LichCongTacRoleConstants.SCHEDULE_APPROVED_RETURN:
			statusDoc = LichWorkflowConstants.STATUS_PENDING;
		    break;
		case LichCongTacRoleConstants.SCHEDULE_PUBLISH_RETURN:
			statusDoc = LichWorkflowConstants.STATUS_APPROVED;
		    break;
		case LichCongTacRoleConstants.SCHEDULE_CO_DINH:
			statusDoc = LichWorkflowConstants.STATUS_STABLE;
		    break;
		}
		return statusDoc;
	}
	
	public static Workbook createExcellFile(long userId, long[] lichCongTacIdList, long companyId) {
		//Thông tin lịch ở dạng UTF-16 để in ra file.
		String sheetTitle = "\u0054\u0068\u00f4\u006e\u0067 \u0074\u0069\u006e \u006c\u1ecb\u0063\u0068";
		//cerate workbook
		XSSFWorkbook wb = new XSSFWorkbook();
        //create a worksheet
        Sheet sheet = wb.createSheet(sheetTitle);
        Font font = wb.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short) 14);
        font.setBold(true);
        CellStyle headerCellStyle = wb.createCellStyle();
        headerCellStyle.setFont(font);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        
        //create a row for column headers
        Row headerRow = sheet.createRow(0);
        Cell sttCell = headerRow.createCell(0);
        sttCell.setCellValue("STT");
        sttCell.setCellStyle(headerCellStyle);
        int tempColNumber1 = 1;
        //Tên, Số điện thoại, nội dung ở dạng UTF-16 để in ra file.
        String[] columnNames = {"\u0054\u00ea\u006e", "\u0053\u1ed1 \u0111\u0069\u1ec7\u006e \u0074\u0068\u006f\u1ea1\u0069", 
        		"Email", "\u004e\u1ed9\u0069 \u0064\u0075\u006e\u0067", "\u0110\u1ecb\u0061 \u0111\u0069\u1ec3\u006d",
        		"\u004e\u0067\u01b0\u1edd\u0069 \u0063\u0068\u1ee7 \u0074\u0072\u00ec", "\u0047\u0068\u0069 \u0063\u0068\u00fa",
        		"\u0110\u01a1\u006e \u0076\u1ecb"};
        
        for (int i = 0; i < columnNames.length; i++) {
        	switch (i) {
        	case 0: 
        		if (!PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.NAME)) {
        			continue;
        		}
        		break;
	    	case 1: 
	    		if (!PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.TELEPHONE)) {
	    			continue;
	    		}
	    		break;
			case 2: 
				if (!PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.EMAIL)) {
					continue;
				}
				break;
			case 3: 
				if (!PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.CONTENT)) {
					continue;
				}
				break;
			case 4: 
				if (!PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.ADDRESS)) {
					continue;
				}
				break;
			case 5: 
				if (!PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.HOST)) {
					continue;
				}
				break;
			case 6: 
				if (!PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.NOTE)) {
					continue;
				}
				break;
			case 7: 
				if (!PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.ORGANIZATION)) {
					continue;
				}
				break;
        	}
            Cell nameCell = headerRow.createCell(tempColNumber1);
            nameCell.setCellValue(columnNames[i]);
            nameCell.setCellStyle(headerCellStyle);
            tempColNumber1++;
        }
        
		//LichCongTac lichCongTac = LichCongTacLocalServiceUtil.getLichCongTac(lichCongTacId);
        int stt = 1;
        for (int i = 0; i < lichCongTacIdList.length; i++) {
        	long lichCongTacId = lichCongTacIdList[i];
    		List<LichChiTiet> lichChiTietList = LichChiTietLocalServiceUtil.getByLichCongTacId(lichCongTacId);
    		for (LichChiTiet lichChiTiet : lichChiTietList) {
    			try {
    				JSONArray nguoiThamDuArray = JSONFactoryUtil.createJSONArray(HtmlUtil.extractText(lichChiTiet.getNguoiThamDu()));
    				if (nguoiThamDuArray.length() > 0) {
        				for (int j = 0; j < nguoiThamDuArray.length(); j++) {

        					String id = "";
        					String name = "";
        					try {
        						JSONObject object = nguoiThamDuArray.getJSONObject(j);
        						id = object.getString("id");
        						name = object.getString("name");
        					} catch (Exception e) {
        						
        					}
        					
                            if (name.isEmpty()) {
                            	name = nguoiThamDuArray.getString(j);
                            }

        					User mainUser = null;
        					if (NumberUtils.isCreatable(id)) {
        						mainUser = UserLocalServiceUtil.fetchUser(Long.parseLong(id));
        					}
        					String telephone = "";
        					String email = "";
        					if (mainUser != null) {
        						System.out.println(mainUser.getFullName());
        						if (mainUser.getPhones().size() > 0) {
        							for (Phone phone : mainUser.getPhones()) {
        								if (!phone.getNumber().trim().isEmpty()) {
        									telephone = phone.getNumber().trim();
        								}
        							}
        						}

        						email = mainUser.getEmailAddress();
        					}
        					sheet = createRow(wb, stt, sheet, userId, name, telephone, email, lichChiTiet);
        			        stt++;
        				}
    				} else {
    					sheet = createRow(wb, stt, sheet, userId, "", "", "", lichChiTiet);
    					stt++;
    				}

    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
        }
		return wb;
	}
	
	private static Sheet createRow(XSSFWorkbook wb, int stt, Sheet sheet, long userId, String nguoiThamDu, String telephone, String email, LichChiTiet lichChiTiet) {
        Font font = wb.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short) 14);
        
        //normal style
        CellStyle normalCellStyle = wb.createCellStyle();
        normalCellStyle.setFont(font);
		
        Row valueRow = sheet.createRow(stt);
        //STT
        Cell firstCell = valueRow.createCell(0);
        firstCell.setCellValue(stt);
        firstCell.setCellStyle(normalCellStyle);
        int tempColNumber2 = 1;
        //Ten
		if (PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.NAME)) {
	        Cell secondCell = valueRow.createCell(tempColNumber2);
	        secondCell.setCellValue(nguoiThamDu);
	        secondCell.setCellStyle(normalCellStyle);
	        tempColNumber2++;
		}
		
        //Telephone
		if (PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.TELEPHONE)) {
	        Cell thirdCell = valueRow.createCell(tempColNumber2);
	        thirdCell.setCellValue(telephone);
	        thirdCell.setCellStyle(normalCellStyle);
	        tempColNumber2++;
		}

        //Email
		if (PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.EMAIL)) {
	        Cell fourthCell = valueRow.createCell(tempColNumber2);
	        fourthCell.setCellValue(email);
	        fourthCell.setCellStyle(normalCellStyle);
	        tempColNumber2++;
		}

        //Content
		if (PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.CONTENT)) {
	        Cell fifthCell = valueRow.createCell(tempColNumber2);
	        fifthCell.setCellValue(HtmlUtil.extractText(lichChiTiet.getMoTa()));
	        fifthCell.setCellStyle(normalCellStyle);
	        tempColNumber2++;
		}
		
		if (PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.ADDRESS)) {
	        Cell sixthCell = valueRow.createCell(tempColNumber2);
	        sixthCell.setCellValue(HtmlUtil.extractText(lichChiTiet.getAddress()));
	        sixthCell.setCellStyle(normalCellStyle);
	        tempColNumber2++;
		}
		
		if (PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.HOST)) {
	        Cell seventhCell = valueRow.createCell(tempColNumber2);
	        String nguoiChuTri = "";
	        if (!lichChiTiet.getNguoiChuTri().isEmpty()) {
	        	try {
					JSONArray nguoiChuTriArray = JSONFactoryUtil.createJSONArray(HtmlUtil.extractText(lichChiTiet.getNguoiChuTri()));
					for (int i = 0; i < nguoiChuTriArray.length(); i++) {
						JSONObject object = nguoiChuTriArray.getJSONObject(i);
						nguoiChuTri += object.getString("name");
						if (i < (nguoiChuTriArray.length() - 1)) {
							nguoiChuTri += ", ";
						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	        }
	        seventhCell.setCellValue(nguoiChuTri);
	        seventhCell.setCellStyle(normalCellStyle);
	        tempColNumber2++;
		}
		
		if (PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.NOTE)) {
	        Cell eigthCell = valueRow.createCell(tempColNumber2);
	        eigthCell.setCellValue(HtmlUtil.extractText(lichChiTiet.getNote()));
	        eigthCell.setCellStyle(normalCellStyle);
	        tempColNumber2++;
		}
		
		if (PermissionUtil.checkColumnPermission(userId, XuatLichColumnConstants.ORGANIZATION)) {
	        Cell ninthCell = valueRow.createCell(tempColNumber2);
	        String orgName = "";
	        
	        try {
		        Organization org = OrganizationLocalServiceUtil.getOrganization(lichChiTiet.getOrganizationId());
		        orgName = org.getName();
	        } catch (Exception e) {
	        	
	        }
	        
	        ninthCell.setCellValue(orgName);
	        ninthCell.setCellStyle(normalCellStyle);
	        tempColNumber2++;
		}
		
		return sheet;
	}
}
