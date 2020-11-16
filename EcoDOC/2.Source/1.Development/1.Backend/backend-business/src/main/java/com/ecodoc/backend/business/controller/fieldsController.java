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
import com.ecodoc.backend.business.repository.IRepositoryFields;
import com.ecodoc.backend.business.service.FieldsService;
import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.repository.IFileEntryRepository;
import com.sun.mail.handlers.image_gif;

@RestController
@RequestMapping("/fields")
public class FieldsController {
	
	private static Boolean ACTIVE = true;
	
	@Autowired
	private FieldsService fieldsService;
	
	@Autowired
	private IRepositoryFields irepositoryFields;
	

	@PostMapping("/create")
	public ResponseEntity<?> createFields(@RequestBody Fields fields) {
		fields.setActive(ACTIVE);
		fields.setClientId(BussinessCommon.getClientId());
		return new ResponseEntity<>(fieldsService.addField(fields), HttpStatus.OK);
	}
	
	@PostMapping("/update/{name}")
	public ResponseEntity<?> updateFields(@RequestBody Fields fields,@PathVariable("name")String name) {
		return new ResponseEntity<>(fieldsService.updateField(name,fields), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Fields>> getAll() {
		return new ResponseEntity<List<Fields>>(fieldsService.getAll(),HttpStatus.OK);
	}
	@GetMapping("/delete/{name}")
	public ResponseEntity<?> deleteField(@PathVariable("name")String name) {
		fieldsService.deleteField(name);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	@GetMapping("/active/{name}")
	public ResponseEntity<?> activeField(@PathVariable("name")String name){
		try { 
			fieldsService.activeOrDeactive(name);
			Fields fieldsOld = irepositoryFields.getFieldsByName(BussinessCommon.getClientId(), name);
			return new ResponseEntity<>(fieldsOld,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
	}
}
