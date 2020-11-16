package com.ecodoc.backend.core.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecodoc.backend.core.common.ApiAlfrescoCommon;
import com.ecodoc.backend.core.common.ExtensionCommon;
import com.ecodoc.backend.core.domain.Preferences;
import com.ecodoc.backend.core.dto.OrgDto;
import com.ecodoc.backend.core.exception.RestResponse;
import com.ecodoc.backend.core.service.FileEntryService;
import com.ecodoc.backend.core.service.OrganizationService;
import com.ecodoc.backend.core.service.PreferencesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/alfresco")
public class ApialfrescoController {
	@Autowired
	private PreferencesService preferencesService;

	@Autowired
	private OrganizationService orgService;

	@Autowired
	private FileEntryService fileEntryService;

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
		return new ResponseEntity<>(apiAlfrescoCommon.asZipFile(ticKet, nodeId), HttpStatus.OK);
	}

	@GetMapping("/get-as-zip-file")
	public ResponseEntity<?> getAsZip(@RequestParam("ticKet") String ticKet,
			@RequestParam("downloadId") String downloadId) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return new ResponseEntity<>(apiAlfrescoCommon.getAsZipFile(ticKet, downloadId), HttpStatus.OK);
	}

	@GetMapping("/download-as-zip-file")
	public ResponseEntity<?> downloadAsZip(@RequestParam("ticKet") String ticKet,
			@RequestParam("downloadId") String downloadId) throws IOException {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.DownLoadAsZipFile(ticKet, downloadId);

	}

	@PostMapping("/addFolder")
	public ResponseEntity<?> createDocumentFolder(@RequestBody ObjectNode objectNode) throws JsonMappingException, JsonProcessingException {
		ApiAlfrescoCommon apiAlfrescoComon = new ApiAlfrescoCommon();

		String ticKet = objectNode.get("ticKet").asText();
		String nodeId = objectNode.get("nodeId").asText();
		String prop_cm_name = objectNode.get("name").asText();
		String prop_cm_title = objectNode.get("title").asText();
		String prop_cm_description = objectNode.get("description").asText();
	
		Object object=null;
		try {
			object = apiAlfrescoComon.createDocumentFolder(ticKet, nodeId, prop_cm_name, prop_cm_title, prop_cm_description);
			return new ResponseEntity<>(object, HttpStatus.OK);
		} catch (Exception e) {
			object = new ObjectMapper().readValue(e.getMessage(), Object.class);
			
			if ((Integer) object == 409) { 
				return new ResponseEntity<>(object, HttpStatus.CONFLICT);
			} else if ((Integer) object == 404) { 
				return new ResponseEntity<>(object, HttpStatus.NOT_FOUND);
			} else if ((Integer) object == 401) {
				return new ResponseEntity<>(object, HttpStatus.UNAUTHORIZED);
			} else { 
				return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	}

	@GetMapping("/getFolder") 
	public ResponseEntity<?> getFolder(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return new ResponseEntity<>(apiAlfrescoCommon.getFolder(ticKet, nodeId), HttpStatus.OK);
	}

	@PostMapping(value = "/addFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> createFile(@RequestPart(value = "filedata") MultipartFile[] filedata,
			@RequestPart("ticKet") String ticKet, @RequestPart(value = "nodeId", required = false) String nodeId)
			throws Exception {

		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		List<Object> list = new ArrayList<Object>();
		List<Preferences> data = preferencesService.getAllPreferences();
		for (MultipartFile multipartFile : filedata) {

			System.out.println("===" + fileEntryService.checkName(multipartFile.getOriginalFilename(), nodeId));
			File convFile = new File(fileEntryService.checkName(multipartFile.getOriginalFilename(), nodeId));
			System.out.println("---" + convFile);
			try {
				convFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(convFile);
				fos.write(multipartFile.getBytes());
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Long size = multipartFile.getSize();
			String ext = ExtensionCommon
					.getExtension(fileEntryService.checkName(multipartFile.getOriginalFilename(), nodeId));
			if (ext == "") {
				list.add(new RestResponse(500, "test"));
			} else {
				if (ExtensionCommon.checkExtension(data, ext, size)) {
					list.add(apiAlfrescoCommon.createFile(convFile, ticKet, nodeId));
				} else {
					list.add(new RestResponse(500, null));
				}
			}
		}

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getProperties")
	public Object getProperties(@RequestParam("nodeId") String nodeId, @RequestParam("ticKet") String ticKet) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.getProperties(ticKet, nodeId);
	}
	@PostMapping("/uploadFile")
	public Object uploadFile(@RequestPart(value = "filedata") MultipartFile[] filedata,@RequestPart("ticKet") String ticKet,@RequestPart("filename") String filename
			,@RequestPart("updateNodeRef") String updateNodeRef,@RequestPart("majorversion") String majorversion,@RequestPart("overwrite") String overwrite,@RequestPart("updatenameandmimetype") String updatenameandmimetype) throws Exception {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		List<Object> list = new ArrayList<Object>();
		List<Preferences> data = preferencesService.getAllPreferences();
		for (MultipartFile multipartFile : filedata) {

			System.out.println("===" + fileEntryService.checkName(multipartFile.getOriginalFilename(), updateNodeRef));
			File convFile = new File(fileEntryService.checkName(multipartFile.getOriginalFilename(), updateNodeRef));
			System.out.println("---" + convFile);
			try {
				convFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(convFile);
				fos.write(multipartFile.getBytes());
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Long size = multipartFile.getSize();
			String ext = ExtensionCommon
					.getExtension(fileEntryService.checkName(multipartFile.getOriginalFilename(), updateNodeRef));
			if (ext == "") {
				list.add(new RestResponse(500, "test"));
			} else {
				if (ExtensionCommon.checkExtension(data, ext, size)) {
					list.add(apiAlfrescoCommon.uploadFile(convFile, ticKet, filename, updateNodeRef, majorversion,overwrite,updatenameandmimetype));
				} else {
					list.add(new RestResponse(500, null));
				}
			}
		}
		return list;
	}
	@PostMapping("/editproperties")
	public ResponseEntity<?> getEditproperties(@RequestBody ObjectNode objectNode) throws Exception {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		String ticKet = objectNode.get("ticKet").asText();
		String nodeId = objectNode.get("nodeId").asText();

		String name = objectNode.get("cm:name").asText();
		String title = objectNode.get("cm:title").asText();
		String description = objectNode.get("cm:description").asText();
		return new ResponseEntity<>( apiAlfrescoCommon.getEditproperties(ticKet, nodeId, name, title, description),HttpStatus.OK);
	}

	@GetMapping("/getAllComments")
	public Object GetAllComment(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId,
			@RequestParam("skipCount") Number skipCount, @RequestParam("maxItems") Number maxItems) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.GetAllComment(ticKet, nodeId, skipCount, maxItems);
	}

	@PostMapping("/deleteComments")
	public ResponseEntity<?> deleteComment(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId,
			@RequestParam("id") String id) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();

		apiAlfrescoCommon.deleteComment(ticKet, nodeId, id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/creatcomment")
	public Object createComment(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId,
			@RequestParam("comment") String comment) throws Exception {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
//		String ticKet = objectNode.get("ticKet").asText();
//		String nodeId = objectNode.get("nodeId").asText();

		return apiAlfrescoCommon.createComment(ticKet, nodeId, comment);
	}
	@PostMapping("/editfile")
	public Object editproperties(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId, @RequestParam("name") String name
			, @RequestParam("title") String title, @RequestParam("description") String description,@RequestParam("author") String author) throws Exception {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.editproperties(ticKet, nodeId, name,title,description,author);
	}
	@GetMapping("/getAll")
	public Object getAll(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId,
			@RequestParam(value = "type", defaultValue = "-1") long type,
			@RequestParam(value = "orderBy", defaultValue = "1") long orderby,
			@RequestParam(value = "start", defaultValue = "0") long start,
			@RequestParam(value = "pageSize", defaultValue = "10") long pageSize, @RequestParam("name") String name
			) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.getAll(ticKet, nodeId, type, name, orderby, start, pageSize);
	}

	@GetMapping("/getIdFile")
	public Object getIdFile(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId) {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.getIdFile(ticKet, nodeId);
	}

	@GetMapping("/download")
	public ResponseEntity<?> getAllFile(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId)
			throws IOException {
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



	@PostMapping(path = "/search/{page}")
	public ResponseEntity<?> getList(@RequestBody OrgDto dto, @PathVariable Integer page) {
		return new ResponseEntity<>(orgService.search(dto, page), HttpStatus.OK);
	}

	@PostMapping(path = "/move")
	public ResponseEntity<?> moveDocument(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId,
			@RequestParam("targetParentId") String targetParentId) {
		ApiAlfrescoCommon apiAlfrescoComon = new ApiAlfrescoCommon();
		apiAlfrescoComon.moveDocument(ticKet, nodeId, targetParentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(path = "/copy")
	public ResponseEntity<?> copyDocument(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId,
			@RequestParam("targetParentId") String targetParentId) {
		ApiAlfrescoCommon apiAlfrescoComon = new ApiAlfrescoCommon();
		apiAlfrescoComon.copyDocument(ticKet, nodeId, targetParentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/previewDocument")
	public ResponseEntity<?> previewDocument(@RequestParam("ticKet") String ticKet,
			@RequestParam("nodeId") String nodeId, @RequestParam("type") String type) throws IOException {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return apiAlfrescoCommon.previewDocument(ticKet, nodeId, type);
	}

	/**
	 * Generate Preview document attactment in alfresco
	 * 
	 * @param ticket
	 * @param nodeId
	 * @param mimeType
	 * @return
	 */
	@GetMapping("/generatePreview")
	public ResponseEntity<?> GeneratePreview(@RequestParam("ticKet") String ticKet,
			@RequestParam("nodeId") String nodeId, @RequestParam("mimeType") String mimeType) throws IOException {
		ApiAlfrescoCommon apiAlfrescoCommon = new ApiAlfrescoCommon();
		return new ResponseEntity<>(apiAlfrescoCommon.GeneratePreview(ticKet, nodeId, mimeType), HttpStatus.OK);
	}

	@GetMapping("/live-search")
	public Object liveSearch(@RequestParam("ticKet") String ticKet, @RequestParam("t") String t,
			@RequestParam("startIndex") Long startIndex, @RequestParam("totalRecords") Long totalRecords) {
		ApiAlfrescoCommon apiAlfrescoComon = new ApiAlfrescoCommon();
		return apiAlfrescoComon.liveSearch(ticKet, t, startIndex, totalRecords);
	}

	@PostMapping("/document/create")
	public ResponseEntity<?> createDocument(@RequestBody ObjectNode objectNode) throws JsonMappingException, JsonProcessingException {
		ApiAlfrescoCommon apiAlfrescoComon = new ApiAlfrescoCommon();

		String ticKet = objectNode.get("ticKet").asText();
		String nodeId = objectNode.get("nodeId").asText();
		String prop_cm_name = objectNode.get("name").asText();
		String prop_cm_content = objectNode.get("content").asText();
		String prop_cm_title = objectNode.get("title").asText();
		String prop_cm_description = objectNode.get("description").asText();
		String prop_mimetype = objectNode.get("mimetype").asText();
		String prop_app_editInline = objectNode.get("editInline").asText();
		Object object=null;
		try {
			object = apiAlfrescoComon.createDocument(ticKet, nodeId, prop_cm_name, prop_cm_content, 
					prop_cm_title, prop_cm_description, prop_mimetype, prop_app_editInline);
			return new ResponseEntity<>(object, HttpStatus.OK);
		} catch (Exception e) {
			object = new ObjectMapper().readValue(e.getMessage(), Object.class);
			
			if ((Integer) object == 409) { 
				return new ResponseEntity<>(object, HttpStatus.CONFLICT);
			} else if ((Integer) object == 404) {
				return new ResponseEntity<>(object, HttpStatus.NOT_FOUND);
			} else if ((Integer) object == 401) {
				return new ResponseEntity<>(object, HttpStatus.UNAUTHORIZED);
			} else { 
				return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	}
	@PostMapping("/document/update")
	public ResponseEntity<?> updateDocument(@RequestBody ObjectNode objectNode) throws JsonMappingException, JsonProcessingException {
		ApiAlfrescoCommon apiAlfrescoComon = new ApiAlfrescoCommon();

		String ticKet = objectNode.get("ticKet").asText();
		String nodeId = objectNode.get("nodeId").asText();
		String prop_cm_description = objectNode.get("prop_cm_description").asText();
		String prop_cm_name = objectNode.get("prop_cm_name").asText();
		String prop_cm_taggable = objectNode.get("prop_cm_taggable").asText();
		String prop_cm_taggable_isCategory = objectNode.get("prop_cm_taggable_isCategory").asText();
		String prop_cm_title = objectNode.get("prop_cm_title").asText();
		Object object=null;
		try {
			object = apiAlfrescoComon.updateDocument(ticKet, nodeId, prop_cm_title, prop_cm_name, prop_cm_description, prop_cm_taggable, prop_cm_taggable_isCategory);
			return new ResponseEntity<>(object, HttpStatus.OK);
		} catch (Exception e) {
			object = new ObjectMapper().readValue(e.getMessage(), Object.class);
			System.out.println(object);
			if ((Integer) object == 409) { 
				return new ResponseEntity<>(object, HttpStatus.CONFLICT);
			} else if ((Integer) object == 404) {
				return new ResponseEntity<>(object, HttpStatus.NOT_FOUND);
			} else if ((Integer) object == 401) {
				return new ResponseEntity<>(object, HttpStatus.UNAUTHORIZED);
			} else { 
				return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	}

	@GetMapping("/document/get-document")
	public Object getDetailDocument(@RequestParam("ticKet") String ticKet, @RequestParam("nodeId") String nodeId) {
		ApiAlfrescoCommon apiAlfrescoComon = new ApiAlfrescoCommon();
		return apiAlfrescoComon.getDocument(ticKet, nodeId);
	}
}
