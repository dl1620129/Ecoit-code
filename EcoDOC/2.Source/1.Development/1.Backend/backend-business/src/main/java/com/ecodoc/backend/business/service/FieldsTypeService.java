package com.ecodoc.backend.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.business.domain.Fields;
import com.ecodoc.backend.business.domain.FieldsType;
import com.ecodoc.backend.business.repository.IRepositoryFieldType;
import com.ecodoc.backend.business.repository.IRepositoryFields;
import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.exception.RestExceptionHandler;

@Service
public class FieldsTypeService {
	@Autowired
	IRepositoryFieldType iRepositoryFieldType;
	
	@Autowired
	IRepositoryFields iRepositoryFields;
	
	public List<FieldsType> getAll() {
		return iRepositoryFieldType.getAllByClientId(BussinessCommon.getClientId());
	}
	public FieldsType addField(FieldsType fields, String modelName) {
		Fields f = iRepositoryFields.getFieldsByName(BussinessCommon.getClientId(), modelName);
		fields.setCreateDate(new Date());
		fields.setModelId(f.getId());
		fields.setUpdateDate(new Date());
		fields.setCreateBy(BussinessCommon.getUserId());
		fields.setUpdateBy(BussinessCommon.getUserId());
		return iRepositoryFieldType.save(fields);
	}
	
	public FieldsType updateFieldType(FieldsType fields, String modelName) {
		Fields f = iRepositoryFields.getFieldsByName(BussinessCommon.getClientId(), modelName);
		FieldsType fieldsOld = iRepositoryFieldType.getFieldsByName(BussinessCommon.getClientId(), fields.getName(), f.getId());
//		fieldsOld.setUpdateDate(new Date());
//		fieldsOld.setUpdateBy(BussinessCommon.getUserId());
		fieldsOld.setTitle(fields.getTitle());
		fieldsOld.setName(fields.getName());
		fieldsOld.setDescription(fields.getDescription());
		fieldsOld.setParentName(fields.getParentName());
		fieldsOld.setModelId(f.getId());
		return iRepositoryFieldType.save(fieldsOld); 
	}
	
	public void Active(Long id) {
		FieldsType fieldsOld = iRepositoryFieldType.findById(id).get();
		if(fieldsOld.getActive()==true || fieldsOld.getActive() == null) {
			fieldsOld.setActive(false);
		}else fieldsOld.setActive(true);
		iRepositoryFieldType.save(fieldsOld);
	} 
	public void deleteFieldType(String name, String modelName) {
		Fields f = iRepositoryFields.getFieldsByName(BussinessCommon.getClientId(), modelName);
		FieldsType fieldsOld = iRepositoryFieldType.getFieldsByName(BussinessCommon.getClientId(), name, f.getId());
		if(fieldsOld==null) throw new RestExceptionHandler("Không tồn tại");
		else{
			fieldsOld.setActive(false);
			iRepositoryFieldType.save(fieldsOld);
		}
	}

}
