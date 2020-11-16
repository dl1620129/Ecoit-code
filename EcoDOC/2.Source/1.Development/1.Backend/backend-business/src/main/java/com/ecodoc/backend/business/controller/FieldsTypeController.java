package com.ecodoc.backend.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecodoc.backend.business.domain.Fields;
import com.ecodoc.backend.business.domain.FieldsType;
import com.ecodoc.backend.business.repository.IRepositoryFieldType;
import com.ecodoc.backend.business.repository.IRepositoryFields;
import com.ecodoc.backend.business.service.FieldsTypeService;
import com.ecodoc.backend.core.common.BussinessCommon;

@RestController
@RequestMapping("/field-type")
public class FieldsTypeController {
	@Autowired
	private FieldsTypeService fieldsService;
	
	@Autowired
	private IRepositoryFieldType irepositoryFields;
	
	@Autowired
	IRepositoryFields iRepositoryFields;
	

	@PostMapping("/create/{modelName}")
	public ResponseEntity<?> createFields(@RequestBody FieldsType fields, @PathVariable("modelName")String modelName){
		Fields f = iRepositoryFields.getFieldsByName(BussinessCommon.getClientId(), modelName);
		fields.setActive(true);
		fields.setClientId(BussinessCommon.getClientId());
		fields.setModelId(f.getId());
		return new ResponseEntity<>(fieldsService.addField(fields, modelName), HttpStatus.OK);
	}
	
	@PostMapping("/update/{modelName}")
	public ResponseEntity<?> updateFields(@RequestBody FieldsType fields, @PathVariable String modelName) {
		return new ResponseEntity<>(fieldsService.updateFieldType(fields, modelName), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FieldsType>> getAll() {
		return new ResponseEntity<List<FieldsType>>(fieldsService.getAll(),HttpStatus.OK);
	}

	@GetMapping("/active/{id}")
	public ResponseEntity<?> activeField(@PathVariable("id")Long id){
		
		try {
			fieldsService.Active(id); 
			FieldsType fields =irepositoryFields.findById(id).get(); 
			return new ResponseEntity<>(fields,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/delete/{name}/{modelName}")
	public ResponseEntity<?> deleteField(@PathVariable("name")String name, @PathVariable("modelName")String modelName) {
		fieldsService.deleteFieldType(name, modelName);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
}
