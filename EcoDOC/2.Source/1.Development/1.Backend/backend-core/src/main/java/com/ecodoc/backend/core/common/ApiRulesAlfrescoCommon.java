package com.ecodoc.backend.core.common;


import org.springframework.web.client.RestTemplate;

import com.ecodoc.backend.core.config.Constant;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ApiRulesAlfrescoCommon {
	public Object getAllModel(String ticKet,String nodeId) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_RULES+nodeId +"/"+Constant.ALFRESCO_RULES+ "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}
	public Object createRule(String ticKet, String nodeId,String title,String description,Boolean disabled,Boolean executeAsynchronously
			,String actionDefinitionName,String conditionDefinitionName
			,String actionsDefinitionName,String typeName,Boolean applyToChildren,String ruleType) {
		System.out.println("-------------");
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_RULES+nodeId +"/"+Constant.ALFRESCO_RULES+ "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		JsonObject body = new JsonObject();
		body.addProperty("title", title);
		body.addProperty("description", description);
		body.addProperty("disabled", disabled);
		body.addProperty("applyToChildren", applyToChildren);
		body.addProperty("executeAsynchronously", executeAsynchronously);
		
		JsonObject jo3 = new JsonObject();
		JsonObject type = new JsonObject();
		
		jo3.addProperty("conditionDefinitionName", conditionDefinitionName);
		jo3.add("parameterValues", type);
		JsonArray conditions = new JsonArray();
		conditions.add(jo3);
		

		JsonObject j04 = new JsonObject();
		JsonObject typeAction = new JsonObject();
		typeAction.addProperty("type-name", typeName);
		j04.addProperty("actionDefinitionName", actionsDefinitionName);
		j04.add("parameterValues", typeAction); 
		JsonArray actions = new JsonArray();
		actions.add(j04);		
		
		JsonArray ruleTypeJson= new JsonArray();
		ruleTypeJson.add(ruleType);
		
		JsonObject action = new JsonObject();
		action.addProperty("actionDefinitionName",actionDefinitionName);
		action.add("conditions",conditions);
		action.add("actions",actions);
		body.add("action", action);
		body.add("ruleType", ruleTypeJson);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		System.out.println(json);
		Object object = restTemplate.postForObject(urlApi,json, Object.class);
		return object;
	} 
	public Object updateRule(String ticKet, String nodeId,String title,String description,Boolean disabled,Boolean executeAsynchronously
			,String actionDefinitionName,String conditionDefinitionName
			,String actionsDefinitionName,String typeName,Boolean applyToChildren) {
		System.out.println("-------------");
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_RULES+nodeId +"/"+Constant.ALFRESCO_RULES+ "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		JsonObject body = new JsonObject();
		body.addProperty("title", title);
		body.addProperty("description", description);
		body.addProperty("disabled", disabled);
		body.addProperty("applyToChildren", applyToChildren);
		body.addProperty("executeAsynchronously", executeAsynchronously);
		
		JsonObject jo3 = new JsonObject();
		JsonObject type = new JsonObject();
		
		jo3.addProperty("conditionDefinitionName", conditionDefinitionName);
		jo3.add("parameterValues", type);
		JsonArray conditions = new JsonArray();
		conditions.add(jo3);
		

		JsonObject j04 = new JsonObject();
		JsonObject typeAction = new JsonObject();
		typeAction.addProperty("type-name", typeName);
		j04.addProperty("actionDefinitionName", actionsDefinitionName); 
		j04.add("parameterValues", typeAction); 
		JsonArray actions = new JsonArray();
		actions.add(j04);		
		
		JsonArray ruleType= new JsonArray();
		ruleType.add("inbound");
		
		JsonObject action = new JsonObject();
		action.addProperty("actionDefinitionName",actionDefinitionName);
		action.add("conditions",conditions);
		action.add("actions",actions);
		body.add("action", action);
		body.add("ruleType", ruleType); 
		Gson gson = new Gson();
		String json = gson.toJson(body);
		System.out.println(json);
		restTemplate.put(urlApi,json, Object.class);
		Object object = restTemplate.getForObject(urlApi, Object.class);
		return object;
	}
	public void delete(String ticKet, String nodeId,String ruleId) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_RULES+nodeId +"/"+Constant.ALFRESCO_RULES+ "/"+ruleId+"?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(urlApi);

	}
}
