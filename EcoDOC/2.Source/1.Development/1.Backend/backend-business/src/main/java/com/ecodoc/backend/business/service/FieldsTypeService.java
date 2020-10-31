package com.ecodoc.backend.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.business.domain.Fields;
import com.ecodoc.backend.business.domain.FieldsType;
import com.ecodoc.backend.business.repository.IRepositoryFieldType;
import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.exception.RestExceptionHandler;

@Service
public class FieldsTypeService {
	@Autowired
	IRepositoryFieldType iRepositoryFieldType;
	
	public List<FieldsType> getAll() {
		return iRepositoryFieldType.getAllByClientId(BussinessCommon.getClientId());
	}
	public FieldsType addField(FieldsType fields) {
		fields.setCreateDate(new Date());
		fields.setUpdateDate(new Date());
		fields.setCreateBy(BussinessCommon.getUserId());
		fields.setUpdateBy(BussinessCommon.getUserId());
		return iRepositoryFieldType.save(fields);
	}
	public FieldsType updateField(Long id,FieldsType fields) {
		
		FieldsType fieldsOld = iRepositoryFieldType.findById(id).get();
		fieldsOld.setUpdateDate(new Date());
		fieldsOld.setUpdateBy(BussinessCommon.getUserId());
		fieldsOld.setTitle(fields.getTitle());
		fieldsOld.setDescription(fields.getDescription());
		fieldsOld.setParentName(fields.getParentName());
		return iRepositoryFieldType.save(fieldsOld); 
	}
	
	public void Active(Long id) {
		FieldsType fieldsOld = iRepositoryFieldType.findById(id).get();
		if(fieldsOld.getActive()==true || fieldsOld.getActive() == null) {
			fieldsOld.setActive(false);
		}else fieldsOld.setActive(true);
		iRepositoryFieldType.save(fieldsOld);
	} 
	public void deleteFieldType(String name) {
		FieldsType fieldsOld = iRepositoryFieldType.getFieldsByName(BussinessCommon.getClientId(), name);
		if(fieldsOld==null) throw new RestExceptionHandler("Không tồn tại");
		else{
			iRepositoryFieldType.delete(fieldsOld);
		}
	}

}
