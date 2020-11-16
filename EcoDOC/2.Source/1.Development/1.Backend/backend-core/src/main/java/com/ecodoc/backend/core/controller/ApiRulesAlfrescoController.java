package com.ecodoc.backend.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecodoc.backend.core.common.ApiModelAlfrescoCommon;
import com.ecodoc.backend.core.common.ApiRulesAlfrescoCommon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/alfresco/rules")
public class ApiRulesAlfrescoController {

	@GetMapping("/get-all/{ticKet}/{nodeId}")
	public ResponseEntity<?> getAll(@PathVariable(value = "ticKet")String ticKet,@PathVariable(value = "nodeId")String nodeId) throws JsonMappingException, JsonProcessingException {
		ApiRulesAlfrescoCommon alfrescoCommon = new ApiRulesAlfrescoCommon();
		Object object=null;
		try {
			object=alfrescoCommon.getAllModel(ticKet, nodeId);
			return new ResponseEntity<>(object, HttpStatus.OK);
		} catch (Exception e) {
			object = new ObjectMapper().readValue(e.getMessage(), Object.class);
			if ((Integer) object == 404) {
				return new ResponseEntity<>(object, HttpStatus.NOT_FOUND);
			} else if ((Integer) object == 401) {
				return new ResponseEntity<>(object, HttpStatus.UNAUTHORIZED);
			} else {
				return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	@PostMapping("/create")
	public ResponseEntity<?> createRules(@RequestBody ObjectNode objectNode) throws Exception {
		ApiRulesAlfrescoCommon alfrescoCommon = new ApiRulesAlfrescoCommon();
		String ticKet = objectNode.get("ticKet").asText();
		String nodeId = objectNode.get("nodeId").asText();
		String title = objectNode.get("title").asText();
		Boolean disabled = objectNode.get("disabled").asBoolean();
		Boolean applyToChildren = objectNode.get("applyToChildren").asBoolean();
		String description = objectNode.get("description").asText();
		Boolean executeAsynchronously = objectNode.get("executeAsynchronously").asBoolean();
		String actionDefinitionName = objectNode.get("actionDefinitionName").asText();
		String conditionDefinitionName = objectNode.get("conditionDefinitionName").asText();
		String actionsDefinitionName = objectNode.get("actionsDefinitionName").asText();
		String typeName = objectNode.get("typeName").asText();
		String ruleType = objectNode.get("ruleType").asText();
		Object object = null;
		try {
			object = alfrescoCommon.createRule(ticKet, nodeId, title, description, disabled,
					executeAsynchronously, actionDefinitionName, conditionDefinitionName,
					actionsDefinitionName, typeName,applyToChildren,ruleType);
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
	@GetMapping("/delete/{nodeId}")
	public ResponseEntity<?> deleteRules(@PathVariable("nodeId") String nodeId,@RequestParam("ticKet") String ticKet,@RequestParam("ruleId") String ruleId){
		try {
			ApiRulesAlfrescoCommon alfrescoCommon = new ApiRulesAlfrescoCommon();
			alfrescoCommon.delete(ticKet, nodeId,ruleId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
