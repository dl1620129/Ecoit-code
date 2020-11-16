package com.ecodoc.backend.core.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.domain.Preferences;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

class BodyLogin {
	private String userId = "admin";
	private String password = "admin";
}



class Name {
	private String name;

	public Name(String name) {
		this.name = name;
	}

}

class asZip {
	private String nodeIds;

	public asZip(String nodeId) {
		super();
		this.nodeIds = nodeId;
	}

}

class addDecentralization {
	private String nodeId;

	public addDecentralization(String nodeId) {
		super();
		this.nodeId = nodeId;
	}
}

class targetParent {
	private String targetParentId;

	public targetParent(String targetParentId) {
		super();
		this.targetParentId = targetParentId;
	}
}

@Slf4j
public class ApiAlfrescoCommon {

	public static final String getTickitApi = Constant.DOMAIN + Constant.ALFRESCO_PATH_TICKET;
//	public static final String urlApi=Constant.DOMAIN+Constant.ALFRESCO_PATH+Constant.ALFRESCO_NODE+"/-root-"+Constant.ALFRESCO_CHILDEN+"?alf_ticket=";

	public Object getTicket() {
		System.out.println(getTickitApi);
		RestTemplate restTemplate = new RestTemplate();
		BodyLogin body = new BodyLogin();
		Gson gson = new Gson();
		String json = gson.toJson(body);
		Object result = restTemplate.postForObject(getTickitApi, json, Object.class);
		System.out.println(result);
		return result;
	}

	public Object asZipFile(String ticKet, String nodeId) {
		if (nodeId == "" || nodeId == null) {
			return null;
		}
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_ASZIP + "?alf_ticket=" + ticKet;
		RestTemplate restTemplate = new RestTemplate();
		asZip body = new asZip(nodeId);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		System.out.println(urlApi);
		System.out.println(json);
		Object result = restTemplate.postForObject(urlApi, json, Object.class);
		System.out.println(result);
		return result;
	}

	public Object getAsZipFile(String ticKet, String downloadId) {
		if (downloadId == "" || downloadId == null) {
			return null;
		}
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_ASZIP + "/" + downloadId
				+ "?alf_ticket=" + ticKet;
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(urlApi);
		Object result = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(result);
		return result;
	}

	public ResponseEntity<?> DownLoadAsZipFile(String ticKet, String downloadId) throws IOException {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + downloadId
				+ "/content?attachment=true&alf_ticket=" + ticKet;
		URL url = new URL(urlApi);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		int responseCode = httpConn.getResponseCode();
		InputStream inputStream = null;
		String disposition = null;
		System.out.println("responseCode: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			int contentLength = httpConn.getContentLength();
			disposition = httpConn.getHeaderField("Content-Disposition");
			inputStream = httpConn.getInputStream();
			System.out.println(contentLength);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Disposition", disposition);
		return ResponseEntity.ok().headers(responseHeaders).contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(new InputStreamResource(inputStream));
	}

	


	public Object getFolder(String ticKet, String nodeId) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	public Object createFile(File filedata, String ticKet, String nodeId) throws IOException {
		if (nodeId == "" || nodeId == null) {
			nodeId = Constant.ALFRESCO_NODE_ROOT;
		}
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_CHILDEN + "?alf_ticket=" + ticKet;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		System.out.println("filedata: " + filedata);
		System.out.println("filedata: " + new FileSystemResource(filedata));
		body.add("filedata", new FileSystemResource(filedata));
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response = restTemplate.postForEntity(urlApi, requestEntity, Object.class);
		try {

			String mimeType = new MimetypesFileTypeMap().getContentType(filedata);
			GeneratePreview(ticKet, nodeId, mimeType);
		} catch (Exception e) {
			log.error("error generate preview alfresco");
		}
		filedata.deleteOnExit();
		return response.getBody();
	}

	public static String getExtension(String fileName) throws IOException {
		String extension = "";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}

	public static boolean checkExtension(List<Preferences> data, String ext) {
		for (Preferences pre : data) {
			if (pre.getExtension().equals(ext)) {
				return true;
			}
		}
		return false;
	}

	public void downloadFile(String ticKet, String nodeId) throws IOException {
		if (nodeId == "" || nodeId == null) {
			nodeId = Constant.ALFRESCO_NODE_ROOT;
		}
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_DOWNLOAD + "&alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(urlApi, String.class);

	}

	public static File convert(MultipartFile file) {
		File convFile = new File(file.getOriginalFilename());
		try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convFile;
	}

	public Object getAll(String ticKet, String nodeId, long type, String name, long orderby, long start,
			long pageSize) {
		if (nodeId == "" || nodeId == null) {
			nodeId = Constant.ALFRESCO_NODE_ROOT;
		}

		String getAllUrl = "";
		String getAllFolder = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_CHILDEN + "?alf_ticket=" + ticKet + "&orderBy=isFolder DESC," + name
				+ (orderby == 2 ? Constant.DESC : Constant.ASC) + "&skipCount=" + start + "&maxItems=" + pageSize;

		if (type == 1) {
			getAllUrl = getAllFolder + Constant.IS_FOLDER;
		} else if (type == 2) {
			getAllUrl = getAllFolder + Constant.IS_FILE;
		} else {
			getAllUrl = getAllFolder;
		}
		System.out.println(getAllUrl);
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(getAllUrl, Object.class);
		return result;
	}

	public Object getIdFile(String ticKet, String nodeId) {
		if (nodeId == "" || nodeId == null) {
			nodeId = Constant.ALFRESCO_NODE_ROOT;
		}

		String getIdFileUrl = "";
		String getIdFile = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ "?alf_ticket=" + ticKet;

		getIdFileUrl = getIdFile;

		System.out.println(getIdFileUrl);
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(getIdFileUrl, Object.class);
		return result;
	}

	public void delete(String ticKet, String nodeId) {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ "?alf_ticket=" + ticKet;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(urlApi, params);

	}

	public Object addFolderDecentralization(String nodeId, String ticKet) {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_CHILDEN + "?alf_ticket=";
		RestTemplate restTemplate = new RestTemplate();
		addDecentralization decen = new addDecentralization(nodeId);
		Gson gson = new Gson();
		String json = gson.toJson(decen);
		Object result = restTemplate.postForObject(urlApi + ticKet, json, Object.class);
		return result;

	}

	public Object updateFolderDecentralization(String nodeId, String ticket) {

		return ticket;
	}

	public Object moveDocument(String ticKet, String nodeId, String targetParentId) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_MOVE + "?alf_ticket=";
		;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		targetParent parent = new targetParent(targetParentId);
		Gson gson = new Gson();
		String json = gson.toJson(parent);
		System.out.println(json);
		Object result = restTemplate.postForObject(urlApi + ticKet, json, Object.class);
		return result;
	}

	public Object copyDocument(String ticKet, String nodeId, String targetParentId) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_COPY + "?alf_ticket=";
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		targetParent parent = new targetParent(targetParentId);
		Gson gson = new Gson();
		String json = gson.toJson(parent);
		System.out.println(json);
		System.out.println(json);
		Object result = restTemplate.postForObject(urlApi + ticKet, json, Object.class);
		return result;
	}

	public ResponseEntity<?> previewDocument(String ticKet, String nodeId, String type) throws IOException {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_REDITIONS + "/" + type + Constant.ALFRESCO_CONTENT + "?alf_ticket=" + ticKet;
		URL url = new URL(urlApi);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		int responseCode = httpConn.getResponseCode();
		InputStream inputStream = null;
		String disposition = null;
		System.out.println("responseCode: " + responseCode);
		String contentType = "";
		if (responseCode == HttpURLConnection.HTTP_OK) {
			int contentLength = httpConn.getContentLength();
			disposition = httpConn.getHeaderField("Content-Disposition");
			inputStream = httpConn.getInputStream();
			System.out.println(contentLength);
			contentType = httpConn.getContentType();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Disposition", disposition);
		responseHeaders.set("Content-Type", contentType);
		return ResponseEntity.ok().headers(responseHeaders).body(new InputStreamResource(inputStream));
	}

	public static Object GeneratePreview(String ticKet, String nodeId, String mimeType) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_REDITIONS + "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Gson gson = new Gson();
		JsonArray jsonArray = new JsonArray();
		// Create Multiple names rendition is specified
		String rendition = "doclib;pdf;imgpreview";
		for (String st : rendition.split(";")) {
			JsonObject jsonObject = new JsonObject();
			if (mimeType.indexOf("image") >= 0) {
				if (!st.equals("pdf")) {
					jsonObject.addProperty("id", st);
				}
			} else {
				jsonObject.addProperty("id", st);
			}
			if (jsonObject.size() > 0)
				jsonArray.add(jsonObject);
		}
		String json = gson.toJson(jsonArray);
		System.out.println(json);
		Object result = restTemplate.postForObject(urlApi, json, Object.class);
		return result;
	}

	public Object GetAllComment(String ticKet, String nodeId, Number skipCount, Number maxItems) {
		String getAllComment = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ "/comments?skipCount=" + skipCount + "&maxItems=" + maxItems + "&alf_ticket=" + ticKet;
		System.out.println(getAllComment);
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(getAllComment, Object.class);
		return result;
	}

	public void deleteComment(String ticKet, String nodeId, String id) {

		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId + "/comments/"
				+ id + "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(urlApi, params);
	}

	public Object createComment(String ticKet, String nodeId, String comment) throws Exception {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ "/comments?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("content", comment);
		Gson gson = new Gson();
		String json = gson.toJson(jsonObject);
		System.out.println(json);
		Object result = restTemplate.postForObject(urlApi, json, Object.class);
		return result;
	}

	public Object getProperties(String ticKet, String nodeId) {
		String getIdFile = Constant.DOMAIN + "/alfresco/s/slingshot/doclib2/node/workspace/SpacesStore/" + nodeId
				+ "?alf_ticket=" + ticKet;

		System.out.println(getIdFile);
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(getIdFile, Object.class);
		return result;
	}

	public Object getEditproperties(String ticKet, String nodeId, String name, String title, String descripton)
			throws Exception {

		String getproperties = Constant.DOMAIN + "/alfresco/s/api/metadata/node/workspace/SpacesStore/" + nodeId
				+ "?alf_ticket=" + ticKet;
		System.out.println("getproperties: " + getproperties);
		RestTemplate restTemplate = new RestTemplate();
		JsonObject jsonObject = new JsonObject();
		JsonObject jsonObjectCon = new JsonObject();
		jsonObjectCon.addProperty("cm:name", name);
		jsonObjectCon.addProperty("cm:title", title);
		jsonObjectCon.addProperty("cm:description", descripton);
		jsonObjectCon.addProperty("cm:author", descripton);
		jsonObject.add("properties", jsonObjectCon);
		Gson gson = new Gson();
		String json = gson.toJson(jsonObject);
		System.out.println(json);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Alfresco-CSRFToken", "KIpZRl/c83OAwXya0hAeWxQhU4KP7h7CscMwR17avLA=");
		HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
		ResponseEntity<Object> result = restTemplate.postForEntity(getproperties, requestEntity, Object.class);
		System.out.println(result);
		return result.getBody();
	}

	public Object liveSearch(String ticKet, String t, Long startIndex, Long totalRecords) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_LIVE_SEARCH + "?alf_ticket=" + ticKet + "&t=" + t
				+ "&startIndex=" + startIndex + "&totalRecords=" + totalRecords;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(urlApi, Object.class);
		return result;
	}

	public Object createDocument(String ticKet, String nodeId, String prop_cm_name, String prop_cm_content,
			String prop_cm_title, String prop_cm_description, String prop_mimetype, String prop_app_editInline) {
		if(nodeId=="" || nodeId == null) {
			nodeId=Constant.ALFRESCO_ROOT_NODEID;
		}
		String urlApi = Constant.DOMAIN + "/alfresco/s/api/type/cm:content/formprocessor?alf_ticket=" + ticKet;
		RestTemplate restTemplate = new RestTemplate();
		JsonObject body = new JsonObject();
		body.addProperty("alf_destination", "workspace://SpacesStore/" + nodeId);
		body.addProperty("prop_cm_name", prop_cm_name);
		body.addProperty("prop_cm_content", prop_cm_content);
		body.addProperty("prop_cm_title", prop_cm_title);
		body.addProperty("prop_cm_description", prop_cm_description);
		body.addProperty("prop_mimetype", prop_mimetype);
		body.addProperty("prop_app_editInline", prop_app_editInline);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
		ResponseEntity<Object> result = restTemplate.postForEntity(urlApi, requestEntity, Object.class);
		return result;
	}

	public Object updateDocument(String ticKet, String nodeId, String prop_cm_title, String prop_cm_name,
			String prop_cm_description, String prop_cm_taggable, String prop_cm_taggable_isCategory) {
		String urlApi = Constant.DOMAIN + "/alfresco/s/api/node/workspace/SpacesStore/" + nodeId
				+ "/formprocessor?alf_ticket=" + ticKet;
		RestTemplate restTemplate = new RestTemplate();
		JsonObject body = new JsonObject();
		body.addProperty("prop_cm_title", prop_cm_title);
		body.addProperty("prop_cm_name", prop_cm_name);
		body.addProperty("prop_cm_description", prop_cm_description);
		body.addProperty("prop_cm_taggable", prop_cm_taggable);
		body.addProperty("prop_cm_taggable_isCategory", prop_cm_taggable_isCategory);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
		ResponseEntity<Object> result = restTemplate.postForEntity(urlApi, requestEntity, Object.class);
		return result;
	}

	public Object getDocument(String ticKet, String nodeId) {
		String urlApi = Constant.DOMAIN + "/alfresco/s/api/version?nodeRef=workspace://SpacesStore/" + nodeId
				+ "&alf_ticket=" + ticKet;
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(urlApi, Object.class);
		return object;
	}

	public Object uploadFile(File filedata, String ticKet, String filename, String updateNodeRef, String majorversion,
			String overwrite, String updatenameandmimetype) throws IOException {

		String urlApi = Constant.DOMAIN + "/alfresco/s/api/upload?alf_ticket=" + ticKet;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		System.out.println("filedata: " + filedata);
		System.out.println("filedata: " + new FileSystemResource(filedata));
		body.add("filedata", new FileSystemResource(filedata));
		body.add("filename", filename);
		body.add("updateNodeRef", updateNodeRef);
		body.add("majorversion", majorversion);
		body.add("overwrite", overwrite);
		body.add("updatenameandmimetype", updatenameandmimetype);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response = restTemplate.postForEntity(urlApi, requestEntity, Object.class);

		return response.getBody();
	}

	public Object editproperties(String ticKet, String nodeId, String name, String title, String descripton,
			String author) throws Exception {

		String getproperties = Constant.DOMAIN + "/alfresco/api/-default-/public/alfresco/versions/1/nodes/" + nodeId
				+ "?alf_ticket=" + ticKet;
		System.out.println("getproperties: " + getproperties);
		RestTemplate restTemplate = new RestTemplate();
		JsonObject jsonObject = new JsonObject();
		JsonObject jsonObjectCon = new JsonObject();

		jsonObjectCon.addProperty("cm:title", title);
		jsonObjectCon.addProperty("cm:description", descripton);
		jsonObjectCon.addProperty("cm:author", author);
		jsonObject.add("properties", jsonObjectCon);
		jsonObject.addProperty("name", name);
		Gson gson = new Gson();
		String json = gson.toJson(jsonObject);
		System.out.println("json" + json);
		restTemplate.put(getproperties, json, new Object());
		Object object = restTemplate.getForObject(getproperties, Object.class);
		System.out.println(object);
		return object;
	}
	public Object createDocumentFolder(String ticKet, String nodeId, String prop_cm_name,
			String prop_cm_title, String prop_cm_description) {
		if(nodeId=="" || nodeId == null) {
			nodeId=Constant.ALFRESCO_ROOT_NODEID;
		}
		String urlApi = Constant.DOMAIN + "/alfresco/s/api/type/cm:folder/formprocessor?alf_ticket=" + ticKet;
		RestTemplate restTemplate = new RestTemplate();
		JsonObject body = new JsonObject();
		body.addProperty("alf_destination", "workspace://SpacesStore/" + nodeId);
		body.addProperty("prop_cm_name", prop_cm_name);
		body.addProperty("prop_cm_title", prop_cm_title);
		body.addProperty("prop_cm_description", prop_cm_description);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		System.out.println(urlApi);
		System.out.println(json);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
		ResponseEntity<Object> result = restTemplate.postForEntity(urlApi, requestEntity, Object.class);
		return result;
	}
}
