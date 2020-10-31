package com.ecodoc.backend.core.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.domain.Decentralization;
import com.ecodoc.backend.core.domain.FileEntry;
import com.ecodoc.backend.core.domain.FolderEntry;
import com.ecodoc.backend.core.domain.Preferences;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.domain.UserRole;
import com.ecodoc.backend.core.repository.IPermissionRepository;
import com.ecodoc.backend.core.repository.IRoleRepository;
import com.ecodoc.backend.core.repository.OrganizationRepository;
import com.ecodoc.backend.core.repository.IDecentralizationRepository;
import com.ecodoc.backend.core.repository.IFileEntryRepository;
import com.ecodoc.backend.core.repository.IFolderEntryRepository;
import com.ecodoc.backend.core.service.DecentralizationService;
import com.ecodoc.backend.core.service.FilesStorageService;
import com.ecodoc.backend.core.service.PermissionService;
import com.ecodoc.backend.core.service.RoleService;
import com.ecodoc.backend.core.service.UserRoleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

class BodyLogin {
	private String userId = "admin";
	private String password = "admin";
}

class createFolderBody {
	private String name;
	private String nodeType = Constant.ALFRESCO_FOLDER;

	public createFolderBody(String name) {
		super();
		this.name = name;
	}

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
	 public addDecentralization (String nodeId) {
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

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private IPermissionRepository permissionRepository;

	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private DecentralizationService decentralizationService;
	
	@Autowired
	private IFileEntryRepository fileRepo;
	
	@Autowired
	private IFolderEntryRepository folderRepo;
	
	@Autowired
	private IRoleRepository roleRepo;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private OrganizationRepository organRepo;
	
	
	
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

	public Object createFolder(String name, String ticKet, String nodeId) {
		if (nodeId == "" || nodeId == null) {
			nodeId = Constant.ALFRESCO_NODE_ROOT;
		}
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_CHILDEN + "?alf_ticket=";
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		createFolderBody body = new createFolderBody(name);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		Object result =restTemplate.postForObject(urlApi + ticKet, json, Object.class);
	
		return result;
	}

	public Object updateFolder(String name, String ticKet, String nodeId) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Name body = new Name(name);
		Gson gson = new Gson();
		String json = gson.toJson(body);
		restTemplate.put(urlApi, json, new Object());
		Object object= restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}
	public Object getFolder(String ticKet, String nodeId) {
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ "?alf_ticket=" + ticKet;
		System.out.println(urlApi);
		RestTemplate restTemplate = new RestTemplate();
		Object object= restTemplate.getForObject(urlApi, Object.class);
		System.out.println(object);
		return object;
	}

	public Object createFile(MultipartFile filedata, String ticKet, String nodeId) throws IOException {
		if (nodeId == "" || nodeId == null) {
			nodeId = Constant.ALFRESCO_NODE_ROOT;
		}
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_CHILDEN + "?alf_ticket=" + ticKet;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("filedata", new FileSystemResource(convert(filedata)));
		
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response = restTemplate.postForEntity(urlApi, requestEntity, Object.class);
		try {
			File convFile = new File(filedata.getOriginalFilename());
			String mimeType = new MimetypesFileTypeMap().getContentType(convFile);
			GeneratePreview(ticKet, nodeId, mimeType);
		} catch (Exception e) {
			log.error("error generate preview alfresco");
		}
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

	public Object getAll(String ticKet, String nodeId, long type, String name, long orderby,long start,long pageSize) {
		if (nodeId == "" || nodeId == null) {
			nodeId = Constant.ALFRESCO_NODE_ROOT;
		}
		
		String getAllUrl = "";
		String getAllFolder = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_CHILDEN + "?alf_ticket=" + ticKet + "&orderBy=isFolder DESC," + name
				+ (orderby == 2 ? Constant.DESC : Constant.ASC)+"&skipCount="+start+"&maxItems="+pageSize;

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

	public ResponseEntity<?> search(Long roleId, List<User> userList) {
		try {
			List<UserRole> listData = new ArrayList<UserRole>();
			if (userList != null && userList.size() > 0) {
				UserRole item;
				List<User> userOfRole = userRoleService.findUserByRoleIdAndActive(roleId, true);
				for (int i = 0; i < userList.size(); i++) {
					if (userOfRole != null && userOfRole.size() > 0) {
						for (int j = 0; j < userOfRole.size(); j++) {
							if (userOfRole.get(j).getId() == userList.get(i).getId())
								break;
							if (j == userOfRole.size() - 1) {
								item = new UserRole();
								item.setRoleId(roleId);
								item.setActive(true);
								item.setUserId(userList.get(i).getId());
								listData.add(item);
							}
						}
					} else {
						item = new UserRole();
						item.setRoleId(roleId);
						item.setActive(true);
						item.setUserId(userList.get(i).getId());
						listData.add(item);
					}
				}
				listData = userRoleService.saveAll(listData);
			}
			List<User> response = userRoleService.findUserByRoleIdAndActive(roleId, true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	public Object addFolderDecentralization(String nodeId, String ticKet){
		
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId
				+ Constant.ALFRESCO_CHILDEN + "?alf_ticket=";
		RestTemplate restTemplate = new RestTemplate();
		addDecentralization decen = new addDecentralization(nodeId);
		Gson gson = new Gson();
		String json = gson.toJson(decen);
		Object result =restTemplate.postForObject(urlApi + ticKet, json, Object.class);
		return result;
		
	}
	 public Object updateFolderDecentralization (String nodeId, String ticket) {
		 
		return ticket; 
	 }
	 
	 public Object moveDocument(String ticKet, String nodeId, String targetParentId) {
		 String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId + Constant.ALFRESCO_MOVE + "?alf_ticket=";;
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
		 String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId + Constant.ALFRESCO_COPY + "?alf_ticket=";
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
		String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId + Constant.ALFRESCO_REDITIONS + "/" + type + Constant.ALFRESCO_CONTENT + "?alf_ticket=" + ticKet;
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
		return ResponseEntity.ok().headers(responseHeaders)
				.body(new InputStreamResource(inputStream));
	}
	 
	 
	 public static Object GeneratePreview(String ticKet, String nodeId,String mimeType) {
		 String urlApi = Constant.DOMAIN + Constant.ALFRESCO_PATH + Constant.ALFRESCO_NODE + "/" + nodeId + Constant.ALFRESCO_REDITIONS + "?alf_ticket="+ ticKet;
		 System.out.println(urlApi);
		 RestTemplate restTemplate = new RestTemplate();
		 Gson gson = new Gson();
		 JsonArray jsonArray = new JsonArray();
		 //Create Multiple names rendition is specified
		 String rendition = "doclib;pdf;imgpreview";
		 for(String st : rendition.split(";")) {
			 JsonObject jsonObject = new JsonObject();
			 if(mimeType.indexOf("image") >= 0) {
				 if(!st.equals("pdf")) {
					 jsonObject.addProperty("id", st);
				 }
			 }else {
				 jsonObject.addProperty("id", st);
			 }
			 if(jsonObject.size() > 0)jsonArray.add(jsonObject);
		 }
		 String json = gson.toJson(jsonArray);
		 System.out.println(json);
		 Object result = restTemplate.postForObject(urlApi , json, Object.class);
		 return result;
	 }
	 
}
