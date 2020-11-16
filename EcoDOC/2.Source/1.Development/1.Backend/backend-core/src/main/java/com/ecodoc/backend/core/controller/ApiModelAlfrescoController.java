package com.ecodoc.backend.core.controller;

import javax.websocket.server.PathParam;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecodoc.backend.core.common.ApiModelAlfrescoCommon;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/alfresco/model")
public class ApiModelAlfrescoController {

	@GetMapping("/get-all")
	public ResponseEntity<?> getAllModel(String ticKet) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getAllModel(ticKet), HttpStatus.OK);
	}

	@GetMapping("/get-model-detail")
	public ResponseEntity<?> getModel(String ticKet, String name) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getModel(name, ticKet), HttpStatus.OK);
	}

	@GetMapping("/active")
	public ResponseEntity<?> activeModel(String ticKet, String name, long typeActive) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.activeModel(name, ticKet, typeActive), HttpStatus.OK);
	}

	@PostMapping("/addModel")
	public Object createFolder(@RequestBody ObjectNode objectNode) throws Exception {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		String name = objectNode.get("name").asText();
		String author = objectNode.get("author").asText();
		String description = objectNode.get("description").asText();
		String namespaceUri = objectNode.get("namespaceUri").asText();
		String namespacePrefix = objectNode.get("namespacePrefix").asText();
		String status = objectNode.get("status").asText();
		String ticKet = objectNode.get("ticKet").asText();
		return alfrescoCommon.createModel(author, name, description, namespaceUri, namespacePrefix, status, ticKet);
	}

	@PostMapping("/updateModel")
	public Object updateFolder(@RequestBody ObjectNode objectNode) throws Exception {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		String author = objectNode.get("author").asText();
		String description = objectNode.get("description").asText();
		String namespaceUri = objectNode.get("namespaceUri").asText();
		String namespacePrefix = objectNode.get("namespacePrefix").asText();
		String ticKet = objectNode.get("ticKet").asText();
		String name = objectNode.get("name").asText();
		return alfrescoCommon.updateModel(author, description, namespaceUri, namespacePrefix, ticKet, name);
	}

	@GetMapping("/delete")
	public ResponseEntity<?> deleteFolder(@RequestParam("ticKet") String ticKet, @RequestParam("name") String name) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		alfrescoCommon.delete(ticKet, name);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/custom-type/get-all")
	public ResponseEntity<?> getAllCustom(String ticKet, String name) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getAllCustom(ticKet, name), HttpStatus.OK);
	}

	@PostMapping("/custom-type/create")
	public Object createCustomType(@RequestBody ObjectNode objectNode) throws Exception {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		String name = objectNode.get("name").asText();
		String title = objectNode.get("title").asText();
		String description = objectNode.get("description").asText();
		String ticKet = objectNode.get("ticKet").asText();
		String modelName = objectNode.get("modelName").asText();
		String parentName = objectNode.get("parentName").asText();
		return alfrescoCommon.createCustomType(modelName, name, description, title, ticKet, parentName);
	}
	
	@PostMapping("/custom-type/update")
	public Object updateCustomType(@RequestBody ObjectNode objectNode) throws Exception {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		String name = objectNode.get("name").asText();
		String title = objectNode.get("title").asText();
		String description = objectNode.get("description").asText();
		String ticKet = objectNode.get("ticKet").asText();
		String modelName = objectNode.get("modelName").asText();
		String parentName = objectNode.get("parentName").asText();
		return alfrescoCommon.updateCustomType(modelName, name, description, title, ticKet, parentName);
	}

	@GetMapping("/custom-type/delete")
	public ResponseEntity<?> deleteCustomType(@PathParam("ticKet") String ticKet, @PathParam("name") String name,
			@PathParam("modelName") String modelName) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		alfrescoCommon.deleteCustomType(ticKet, name, modelName);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/custom-type/get-detail")
	public ResponseEntity<?> getCustomType(String ticKet, String name, String modelName) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getCustomType(name, ticKet, modelName), HttpStatus.OK);
	}

	@GetMapping("/aspects/get-all") 
	public ResponseEntity<?> getAllAspects(String ticKet, String name) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getAllAspects(ticKet, name), HttpStatus.OK);
	}

	@GetMapping("/aspects/get-detail")
	public ResponseEntity<?> getAspects(String ticKet, String name, String modelName) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getAspects(name, ticKet, modelName), HttpStatus.OK);
	}

	@GetMapping("/aspects/delete")
	public ResponseEntity<?> deleteAspects(@RequestParam("ticKet") String ticKet, @RequestParam("name") String name,
			@RequestParam("modelName") String modelName) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		try {
			alfrescoCommon.deletepseacts(ticKet, name, modelName);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
	}

	@PostMapping("/properties/create")
	public ResponseEntity<?> creatProperties(@RequestBody ObjectNode objectNode) throws Exception {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		String modelName = objectNode.get("modelName").asText();
		String ticKet = objectNode.get("ticKet").asText();
		String typeName = objectNode.get("typeName").asText();
		String description = objectNode.get("description").asText();
		String title = objectNode.get("title").asText();
		String name = objectNode.get("name").asText();
		Boolean mandatory = objectNode.get("mandatory").asBoolean();
		Boolean multiValued = objectNode.get("multiValued").asBoolean();
		Boolean mandatoryEnforced = objectNode.get("mandatoryEnforced").asBoolean();
		String defaultValue = objectNode.get("defaultValue").asText();
		String dataType = objectNode.get("dataType").asText();
		Boolean indexed = objectNode.get("indexed").asBoolean();
		String facetable = objectNode.get("facetable").asText();
		String indexTokenisationMode = objectNode.get("indexTokenisationMode").asText();
		String type = objectNode.get("type").asText();
		Object object = null;
		try {
			object = alfrescoCommon.createProperties(modelName, typeName, description, title, ticKet, name, mandatory,
					multiValued, mandatoryEnforced, defaultValue, dataType, indexed, facetable, indexTokenisationMode, type);
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

	@PostMapping("/properties/update")
	public Object updateProperties(@RequestBody ObjectNode objectNode) throws Exception {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();

		String modelName = objectNode.get("modelName").asText();
		String ticKet = objectNode.get("ticKet").asText();
		String typeName = objectNode.get("typeName").asText();
		String description = objectNode.get("description").asText();
		String title = objectNode.get("title").asText();
		String name = objectNode.get("name").asText();
		Boolean mandatory = objectNode.get("mandatory").asBoolean();
		Boolean multiValued = objectNode.get("multiValued").asBoolean();
		Boolean mandatoryEnforced = objectNode.get("mandatoryEnforced").asBoolean();
		String defaultValue = objectNode.get("defaultValue").asText();
		String dataType = objectNode.get("dataType").asText();
		Boolean indexed = objectNode.get("indexed").asBoolean();
		String facetable = objectNode.get("facetable").asText();
		String indexTokenisationMode = objectNode.get("indexTokenisationMode").asText();
		String types = objectNode.get("types").asText();
		return alfrescoCommon.updateProperties(modelName, typeName, description, title, ticKet, name, mandatory,
				multiValued, mandatoryEnforced, defaultValue, dataType, indexed, facetable, indexTokenisationMode, types);
	}

	@GetMapping("/properties/delete")
	public ResponseEntity<?> deleteProperties(@RequestParam("ticKet") String ticKet, @RequestParam("name") String name,
			@RequestParam("modelName") String modelName, @RequestParam("typeName") String typeName) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		alfrescoCommon.deleteProperties(ticKet, modelName, typeName, name);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/aspects/create")
	public ResponseEntity<?> createAspects(@RequestBody ObjectNode objectNode) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		String modelName = objectNode.get("modelName").asText();
		String ticKet = objectNode.get("ticKet").asText();
		String description = objectNode.get("description").asText();
		String name = objectNode.get("name").asText();
		String parentName = objectNode.get("parentName").asText();
		String prefixedName = objectNode.get("prefixedName").asText();
		String title = objectNode.get("title").asText();
		Object ob = alfrescoCommon.createAspects(description, name, parentName, prefixedName, title, ticKet, modelName);
		return new ResponseEntity<>(ob, HttpStatus.OK);
	}
	
	@PostMapping("/aspects/update")
	public ResponseEntity<?> updateAspects(@RequestBody ObjectNode objectNode) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		String modelName = objectNode.get("modelName").asText();
		String ticKet = objectNode.get("ticKet").asText();
		String description = objectNode.get("description").asText();
		String name = objectNode.get("name").asText();
		String parentName = objectNode.get("parentName").asText();
		String prefixedName = objectNode.get("prefixedName").asText();
		String title = objectNode.get("title").asText();
		Object ob = alfrescoCommon.updateAspects(description, name, parentName, prefixedName, title, ticKet, modelName);
		return new ResponseEntity<>(ob, HttpStatus.OK);
	}
	
	@PostMapping("/aspects/delete")
	public ResponseEntity<?> update(@RequestBody ObjectNode objectNode) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		String modelName = objectNode.get("modelName").asText();
		String ticKet = objectNode.get("ticKet").asText();
		String aspectsName = objectNode.get("aspectsName").asText();
		alfrescoCommon.deleteAspects(modelName, aspectsName, ticKet);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/aspects/getOne")
	public ResponseEntity<?> getOneAspect(@RequestParam(value = "ticket")String ticket, @RequestParam(value = "modelName")String modelName, @RequestParam(value = "aspectsName")String aspectsName){
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		Object object = alfrescoCommon.getOneAspects(ticket, modelName, aspectsName);
		return new ResponseEntity<>(object, HttpStatus.OK); 
	}
}
