package com.ecodoc.backend.core.controller;

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

import com.ecodoc.backend.core.domain.FileEntry;
import com.ecodoc.backend.core.service.FileEntryService;

@RestController
@RequestMapping("/fileentry")
public class FileEntryController {
	
	@Autowired
	private FileEntryService fileEntryService;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<?> listFileEntry(){
		List<FileEntry> list= fileEntryService.getAll();
		return new ResponseEntity<>(list,HttpStatus.OK);  
	}
	@PostMapping("/add")
	public ResponseEntity<?> createFileEntry(@RequestBody FileEntry fileEntry){		
		return new ResponseEntity<>(fileEntryService.addFileEntry(fileEntry),HttpStatus.OK);
	}
	@PostMapping("/update/{nodeId}")
	public ResponseEntity<?> createFileEntry(@RequestBody FileEntry fileEntry,@PathVariable("nodeId") String nodeId){		
		return new ResponseEntity<>(fileEntryService.updateFileEntry(nodeId, fileEntry),HttpStatus.OK);
	}
	@GetMapping("/active/{nodeId}")
	public ResponseEntity<?> activeFileEntry(@PathVariable("nodeId") String nodeId){		
		return new ResponseEntity<>(fileEntryService.activeFileEntry(nodeId),HttpStatus.OK);
	}
	@GetMapping("/unactive/{nodeId}")
	public ResponseEntity<?> unActiveFileEntry(@PathVariable("nodeId") String nodeId){		  
		return new ResponseEntity<>(fileEntryService.unActiveFileEntry(nodeId),HttpStatus.OK);
	}

}
