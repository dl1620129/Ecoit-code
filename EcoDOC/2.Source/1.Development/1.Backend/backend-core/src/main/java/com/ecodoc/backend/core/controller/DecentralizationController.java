package com.ecodoc.backend.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecodoc.backend.core.domain.Decentralization;
import com.ecodoc.backend.core.domain.FolderEntry;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.DecentralizationDto;
import com.ecodoc.backend.core.repository.IDecentralizationRepository;
import com.ecodoc.backend.core.service.DecentralizationService;
import com.ecodoc.backend.core.service.FileEntryService;
import com.ecodoc.backend.core.service.FolderEntryService;
import com.ecodoc.backend.core.service.UserService;

public class DecentralizationController {
	
	@Autowired
	private FolderEntryService folderEntry;
	
	@Autowired
	private DecentralizationService decenService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileEntryService fileEntry;
	
	@Autowired 
	private IDecentralizationRepository decenRepo;
	
	@PostMapping("/add")
	public ResponseEntity<?> createFolderDecen(@RequestBody Decentralization input){
		return new ResponseEntity<>(decenService.addDecenFolder(input), HttpStatus.OK);
	}
	@PostMapping("/updatedecen/{id}")
	public ResponseEntity<?> updateFolder(@PathVariable Long id, @RequestBody Decentralization input){
		return new ResponseEntity<>(decenService.updateDecenFolder(input, id), HttpStatus.OK);
	}
	@GetMapping("/getAllDecen")
	public ResponseEntity<?> getAllDecen(Long clientId){
		List<Decentralization> data = decenRepo.getAllDecentralization(clientId);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
