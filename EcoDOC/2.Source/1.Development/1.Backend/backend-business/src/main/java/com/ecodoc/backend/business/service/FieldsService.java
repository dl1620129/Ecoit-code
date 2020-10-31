package com.ecodoc.backend.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.business.domain.Fields;
import com.ecodoc.backend.business.repository.IRepositoryFields;
import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.exception.RestExceptionHandler;

@Service
public class FieldsService  {

	@Autowired
	IRepositoryFields iRepositoryFields;
	
	public List<Fields> getAll() {
		return iRepositoryFields.getByClienId(BussinessCommon.getClientId());
	}
	private void checkName(String name){
		Long countName= iRepositoryFields.getCountByName(BussinessCommon.getClientId(), name);
		if(countName>0) throw new RestExceptionHandler("Name đã tồn tại");
	}
	private void checkNamespacePrefix(String namespacePrefix){
		Long countName= iRepositoryFields.getCountByNamespacePrefix(BussinessCommon.getClientId(), namespacePrefix);
		if(countName>0) throw new RestExceptionHandler("NamespacePrefix đã tồn tại");
	}
	private void checkNamespaceUri(String namespaceUri){
		Long countName= iRepositoryFields.getCountByNamespaceUri(BussinessCommon.getClientId(), namespaceUri);
		if(countName>0) throw new RestExceptionHandler("NamespaceUri đã tồn tại");
	}
	public Fields addField(Fields fields) {
		checkName(fields.getName());
		checkNamespacePrefix(fields.getNamespacePrefix());
		checkNamespaceUri(fields.getNamespaceUri());
		fields.setCreateDate(new Date());
		fields.setUpdateDate(new Date());
		fields.setCreateBy(BussinessCommon.getUserId());
		fields.setUpdateBy(BussinessCommon.getUserId());
		return iRepositoryFields.save(fields);
	}
	public Fields updateField(String name,Fields fields) {
		
		Fields fieldsOld = iRepositoryFields.getFieldsByName(BussinessCommon.getClientId(), name);
		if(fieldsOld==null) throw new RestExceptionHandler("Không tồn tại");

		if(!fields.getNamespacePrefix().equals(fieldsOld.getNamespacePrefix())) {
			checkNamespacePrefix(fields.getNamespacePrefix());
		}
		if(!fields.getNamespaceUri().equals(fieldsOld.getNamespaceUri())) {
			checkNamespaceUri(fields.getNamespaceUri());
		}
		fieldsOld.setUpdateDate(new Date());
		fieldsOld.setUpdateBy(BussinessCommon.getUserId());
		fieldsOld.setAuthor(fields.getAuthor());
		fieldsOld.setNamespacePrefix(fields.getNamespacePrefix());
		fieldsOld.setDescription(fields.getDescription());
		fieldsOld.setNamespaceUri(fields.getNamespaceUri());
		return iRepositoryFields.save(fieldsOld); 
	}
	
	public void activeOrDeactive(Long id) {
		Fields fieldsOld = iRepositoryFields.findById(id).get();
		if(fieldsOld.getActive()==true || fieldsOld.getActive() == null) {
			fieldsOld.setActive(false);
		}else fieldsOld.setActive(true);
		iRepositoryFields.save(fieldsOld);
	}
	public void deleteField(String name) {
		Fields fieldsOld = iRepositoryFields.getFieldsByName(BussinessCommon.getClientId(), name);
		if(fieldsOld==null) throw new RestExceptionHandler("Không tồn tại");
		else{
			iRepositoryFields.delete(fieldsOld);
		}
	}


}
