package com.ecodoc.backend.core.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecodoc.backend.core.common.ApiAlfrescoCommon;
import com.ecodoc.backend.core.common.ExtensionCommon;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.domain.Preferences;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.OrgDto;
import com.ecodoc.backend.core.exception.RestResponse;
import com.ecodoc.backend.core.service.OrganizationService;
import com.ecodoc.backend.core.service.PreferencesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/alfresco")
public class ApialfrescoController {
	@Autowired
	private PreferencesService preferencesService;
	
	@Autowired
	private OrganizationService orgService;
	
	@GetMapping("/getTicket")
	public ResponseEntity<?> getTicket() {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return new ResponseEntity<>(apiAlfrescoCommon.getTicket(), HttpStatus.OK);
	}
	@PostMapping("/as-zip-file")
	public ResponseEntity<?> asZip(@RequestBody ObjectNode objectNode) {
		String ticKet = objectNode.get("ticKet").asText();
		String nodeId = objectNode.get("nodeId").asText();
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return new ResponseEntity<>( apiAlfrescoCommon.asZipFile(ticKet, nodeId),HttpStatus.OK);
	}
	@GetMapping("/get-as-zip-file")
	public ResponseEntity<?> getAsZip(@RequestParam("ticKet") String ticKet, @RequestParam("downloadId") String downloadId) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return new ResponseEntity<>( apiAlfrescoCommon.getAsZipFile(ticKet, downloadId),HttpStatus.OK);
	}
	@GetMapping("/download-as-zip-file")
	public ResponseEntity<?> downloadAsZip(@RequestParam("ticKet") String ticKet, @RequestParam("downloadId") String downloadId) throws IOException {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.DownLoadAsZipFile(ticKet, downloadId);

	}
	
	@PostMapping("/addFolder")
	public Object createFolder(@RequestBody ObjectNode objectNode) throws Exception {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		String name = objectNode.get("name").asText();
		String ticKet = objectNode.get("ticKet").asText();
		String nodeId = objectNode.get("nodeId").asText();
		return apiAlfrescoCommon.createFolder(name, ticKet, nodeId);
	}
	@PostMapping("/updateFolder")
	public Object updateFolder(@RequestBody ObjectNode objectNode) throws Exception {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		String name = objectNode.get("name").asText();
		String ticKet = objectNode.get("ticKet").asText();
		String nodeId = objectNode.get("nodeId").asText();
		return apiAlfrescoCommon.updateFolder(name, ticKet, nodeId);
	}
	@GetMapping("/getFolder")
	public ResponseEntity<?> getFolder(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return new ResponseEntity<>( apiAlfrescoCommon.getFolder(ticKet, nodeId),HttpStatus.OK);
	}
	@PostMapping(value = "/addFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> createFile(@RequestPart(value = "filedata") MultipartFile[] filedata,
			@RequestPart("ticKet") String ticKet, @RequestPart(value = "nodeId", required = false) String nodeId)
			throws Exception {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		List<Object> list= new ArrayList<Object>();
		List<Preferences> data = preferencesService.getAllPreferences();
		for (MultipartFile multipartFile : filedata) {
			Long size = multipartFile.getSize();
			String ext = ExtensionCommon.getExtension(multipartFile.getOriginalFilename());
			if (ext == "") {
				list.add(new RestResponse(500, "test"));
			} else {
				if (ExtensionCommon.checkExtension(data, ext, size)) {
					list.add(apiAlfrescoCommon.createFile(multipartFile, ticKet, nodeId));
				} else {
					list.add(new RestResponse(500, "test: "+multipartFile.getOriginalFilename()));
				}
			}
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public Object getAll(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId,
			@RequestParam(value = "type", defaultValue = "-1") long type,
			@RequestParam(value = "orderBy", defaultValue = "1") long orderby,
			@RequestParam(value = "start", defaultValue = "0") long start,
			@RequestParam(value = "pageSize", defaultValue = "10") long pageSize,
			@RequestParam("name") String name) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.getAll(ticKet, nodeId, type, name, orderby,start,pageSize);
	}
	@GetMapping("/getIdFile")
	public Object getIdFile(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.getIdFile(ticKet, nodeId);
	}
	@GetMapping("/download")
	public ResponseEntity<?> getAllFile(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId) throws IOException {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		apiAlfrescoCommon.downloadFile(ticKet, nodeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@GetMapping("/delete")
	public ResponseEntity<?> deleteFolder(@RequestParam("ticKet") String ticKet,
			@RequestParam("nodeId") String[] nodeIds) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		if (nodeIds == null)
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		for (String nodeId : nodeIds) {
			apiAlfrescoCommon.delete(ticKet, nodeId);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/search")
	public ResponseEntity<?> searchUser(@PathVariable("roleId") long roleId, @RequestBody List<User> userList){
		ApiAlfrescoCommon apiAlfrescoComon = new ApiAlfrescoCommon();
		if(userList == null) {
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}
		for(int i = 0; i<userList.size(); i++) {
			apiAlfrescoComon.search(roleId, userList);
		}
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@PostMapping(path = "/search/{page}")
	public ResponseEntity<?> getList(@RequestBody OrgDto dto, @PathVariable Integer page) {
		return new ResponseEntity<>(orgService.search(dto, page),HttpStatus.OK);
	}
	
	@PostMapping(path = "/move")
	public ResponseEntity<?> moveDocument(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId, @RequestParam("targetParentId") String targetParentId){
		ApiAlfrescoCommon apiAlfrescoComon = new ApiAlfrescoCommon();
		apiAlfrescoComon.moveDocument(ticKet, nodeId, targetParentId);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@PostMapping(path = "/copy")
	public ResponseEntity<?> copyDocument(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId, @RequestParam("targetParentId") String targetParentId){
		ApiAlfrescoCommon apiAlfrescoComon = new ApiAlfrescoCommon();
		apiAlfrescoComon.copyDocument(ticKet, nodeId, targetParentId);
		return new ResponseEntity<>(HttpStatus.OK);	
	}

	@GetMapping("/previewDocument")
	public ResponseEntity<?> previewDocument(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId, @RequestParam("type") String type) throws IOException {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.previewDocument(ticKet, nodeId, type);
	}
	
	
	/**
	 * Generate Preview document attactment in alfresco
	 * @param ticket 
	 * @param nodeId 
	 * @param mimeType 
	 * @return
	 */
	@GetMapping("/generatePreview")
	public ResponseEntity<?> GeneratePreview(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId,@RequestParam("mimeType") String mimeType) throws IOException {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return new ResponseEntity<>(apiAlfrescoCommon.GeneratePreview(ticKet, nodeId, mimeType),HttpStatus.OK);
	}
}
