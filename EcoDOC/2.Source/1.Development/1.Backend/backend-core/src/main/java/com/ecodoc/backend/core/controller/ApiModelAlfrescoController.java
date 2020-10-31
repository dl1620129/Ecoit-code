package com.ecodoc.backend.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecodoc.backend.core.common.ApiAlfrescoCommon;
import com.ecodoc.backend.core.common.ApiModelAlfrescoCommon;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/alfresco/model")
public class ApiModelAlfrescoController {

	@GetMapping("/get-all")
	public ResponseEntity<?> getAllModel(String ticKet) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getAllModel(ticKet), HttpStatus.OK);
	}
	@GetMapping("/get-model-detail")
	public ResponseEntity<?> getModel(String ticKet,String name) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getModel(name, ticKet), HttpStatus.OK);
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
	public ResponseEntity<?> deleteFolder(@RequestParam("ticKet") String ticKet,
			@RequestParam("name") String name) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		alfrescoCommon.delete(ticKet, name);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/custom-type/get-all")
	public ResponseEntity<?> getAllCustom(String ticKet,String name) {
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

	@GetMapping("/custom-type/delete")
	public ResponseEntity<?> deleteCustomType(@RequestParam("ticKet") String ticKet,
			@RequestParam("name") String name,@RequestParam("modelName") String modelName) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		alfrescoCommon.deleteCustomType(ticKet, name, modelName);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/custom-type/get-detail")
	public ResponseEntity<?> getCustomType(String ticKet,String name,String modelName) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getCustomType(name, ticKet, modelName), HttpStatus.OK);
	}
	@GetMapping("/aspects/get-all")
	public ResponseEntity<?> getAllAspects(String ticKet,String name) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getAllAspects(ticKet, name), HttpStatus.OK);
	}
	@GetMapping("/aspects/get-detail")
	public ResponseEntity<?> getAspects(String ticKet,String name,String modelName) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		return new ResponseEntity<>(alfrescoCommon.getAspects(name, ticKet, modelName), HttpStatus.OK);
	}
	@GetMapping("/aspects/delete")
	public ResponseEntity<?> deleteAspects(@RequestParam("ticKet") String ticKet,
			@RequestParam("name") String name,@RequestParam("modelName") String modelName) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		alfrescoCommon.deletepseacts(ticKet, name, modelName);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/properties/create")
	public Object creatProperties(@RequestBody ObjectNode objectNode) throws Exception {
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
		return alfrescoCommon.createProperties(modelName, typeName, description, title, ticKet
				, name, mandatory, multiValued, mandatoryEnforced, defaultValue, dataType,
				indexed, facetable, indexTokenisationMode);
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
		return alfrescoCommon.updateProperties(modelName, typeName, description, title, ticKet
				, name, mandatory, multiValued, mandatoryEnforced, defaultValue, dataType,
				indexed, facetable, indexTokenisationMode);
	}
	@GetMapping("/properties/delete")
	public ResponseEntity<?> deleteProperties(@RequestParam("ticKet") String ticKet,
			@RequestParam("name") String name,@RequestParam("modelName") String modelName,
			@RequestParam("typeName") String typeName) {
		ApiModelAlfrescoCommon alfrescoCommon = new ApiModelAlfrescoCommon();
		alfrescoCommon.deleteProperties(ticKet, modelName, typeName, name);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
