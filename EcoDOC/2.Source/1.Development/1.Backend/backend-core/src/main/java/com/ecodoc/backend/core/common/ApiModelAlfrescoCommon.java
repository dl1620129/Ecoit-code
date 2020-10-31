package com.ecodoc.backend.core.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.ecodoc.backend.core.config.Constant;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

class ModelAlfresco {
	private static final long serialVersionUID = 1L;
	String author;
	String name;
	String description;
	String namespaceUri;
	String namespacePrefix;
	String status;

	public ModelAlfresco(String author, String name, String description, String namespaceUri, String namespacePrefix,
			String status) {
		super();
		this.author = author;
		this.name = name;
		this.description = description;
		this.namespaceUri = namespaceUri;
		this.namespacePrefix = namespacePrefix;
		this.status = status;
	}

	public ModelAlfresco(String author, String description, String namespaceUri, String namespacePrefix) {
		super();
		this.author = author;
		this.description = description;
		this.namespaceUri = namespaceUri;
		this.namespacePrefix = namespacePrefix;
	}

}

class CustomType {
	String parentName;
	String name;
	String description;
	String title;

	public CustomType(String name, String description, String title, String parentName) {
		super();
		this.name = name;
		this.description = description;
		this.title = title;
		this.parentName = parentName;
	}

}

public class ApiModelAlfrescoCommon {

	public Object getAllModel(String ticKet) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	public Object createModel(String author, String name, String description, String namespaceUri,
			String namespacePrefix, String status, String ticKet) {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		ModelAlfresco body = new ModelAlfresco(author, name, description, namespaceUri, namespacePrefix, status);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		System.out.println(json);
		Object result = restTemplate.postForObject(urlApi, json, Object.class);

		return result;
	}

	public Object updateModel(String author, String description, String namespaceUri, String namespacePrefix,
			String ticKet, String name) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + name + "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		ModelAlfresco body = new ModelAlfresco(author, description, namespaceUri, namespacePrefix);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		restTemplate.put(urlApi, json, new Object());
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	public Object getModel(String name, String ticKet) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + name + "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	public Object activeModel(String name, String ticKet) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + name + Constant.ALFRESCO_TYPES
				+ "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	public void delete(String ticKet, String name) {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + name + "?alf_ticket=" + ticKet;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(urlApi, params);

	}

	// custom type alfresco

	public Object getAllCustom(String ticKet, String name) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + name + Constant.ALFRESCO_TYPES
				+ "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	public Object createCustomType(String modelName, String name, String description, String title, String ticKet,
			String parentName) {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + modelName + Constant.ALFRESCO_TYPES
				+ "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		CustomType body = new CustomType(name, description, title, parentName);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		System.out.println(json);
		Object result = restTemplate.postForObject(urlApi, json, Object.class);

		return result;
	}

	public Object updateCustomType(String name, String description, String title, String ticKet, String parentName) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + name + "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		CustomType body = new CustomType(name, description, title, parentName);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		restTemplate.put(urlApi, json, new Object());
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	public void deleteCustomType(String ticKet, String name, String modelName) {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + modelName + Constant.ALFRESCO_TYPES
				+ "/" + name + "?alf_ticket=" + ticKet;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(urlApi, params);

	}

	public Object getCustomType(String name, String ticKet, String modelName) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + modelName + Constant.ALFRESCO_TYPES
				+ "/" + name + "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	// Aspects alfresco
	public Object getAllAspects(String ticKet, String name) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + name + Constant.ALFRESCO_ASPECTS
				+ "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	public void deletepseacts(String ticKet, String name, String modelName) {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + modelName + Constant.ALFRESCO_ASPECTS
				+ "/" + name + "?alf_ticket=" + ticKet;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(urlApi, params);

	}

	public Object getAspects(String name, String ticKet, String modelName) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + modelName + Constant.ALFRESCO_ASPECTS
				+ "/" + name + "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	// properties alfresco
	public Object createProperties(String modelName, String typeName, String description, String title, String ticKet,
			String name, Boolean mandatory, Boolean multiValued, Boolean mandatoryEnforced, String defaultValue,
			String dataType, Boolean indexed, String facetable, String indexTokenisationMode) throws Exception {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + modelName + Constant.ALFRESCO_TYPES
				+ "/" + typeName + "?select=props&alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		JsonObject body = new JsonObject();
		body.addProperty("name", typeName);
		JsonObject jo = new JsonObject();
		jo.addProperty("name", name);
		jo.addProperty("mandatory", mandatory);
		jo.addProperty("multiValued", multiValued);
		jo.addProperty("mandatoryEnforced", mandatoryEnforced);
		jo.addProperty("defaultValue", defaultValue);
		jo.addProperty("dataType", dataType);
		jo.addProperty("indexed", indexed);
		jo.addProperty("facetable", facetable);
		jo.addProperty("indexTokenisationMode", indexTokenisationMode);
		JsonArray liJsonArray = new JsonArray();
		liJsonArray.add(jo);
		body.add("properties", liJsonArray);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		System.out.println(json);
		restTemplate.put(urlApi, json, new Object());
		Object object = restTemplate.getForObject(urlApi, Object.class);

		return object;
	}

	public Object updateProperties(String modelName, String typeName, String description, String title, String ticKet,
			String name, Boolean mandatory, Boolean multiValued, Boolean mandatoryEnforced, String defaultValue,
			String dataType, Boolean indexed, String facetable, String indexTokenisationMode) throws Exception {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + modelName + Constant.ALFRESCO_TYPES
				+ "/" + typeName + "?select=props&update=" + name + "&alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		JsonObject body = new JsonObject();
		body.addProperty("name", typeName);
		JsonObject jo = new JsonObject();
		jo.addProperty("name", name);
		jo.addProperty("mandatory", mandatory);
		jo.addProperty("multiValued", multiValued);
		jo.addProperty("mandatoryEnforced", mandatoryEnforced);
		jo.addProperty("defaultValue", defaultValue);
		jo.addProperty("dataType", dataType);
		jo.addProperty("indexed", indexed);
		jo.addProperty("facetable", facetable);
		jo.addProperty("indexTokenisationMode", indexTokenisationMode);
		JsonArray liJsonArray = new JsonArray();
		liJsonArray.add(jo);
		body.add("properties", liJsonArray);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		System.out.println(json);
		restTemplate.put(urlApi, json, new Object());
		Object object = restTemplate.getForObject(urlApi, Object.class);

		return object;
	}

	public void deleteProperties(String ticKet, String modelName, String typeName,String name) {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_PRIVATE + "/" + modelName + Constant.ALFRESCO_TYPES
				+ "/" + typeName + "?select=props&delete="+name+"&alf_ticket=" + ticKet;
		System.out.println(urlApi);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(urlApi, params);

	}
}
