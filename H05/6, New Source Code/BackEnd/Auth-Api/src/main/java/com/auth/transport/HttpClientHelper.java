package com.auth.transport;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class HttpClientHelper {
	private static HttpClientHelper instance = null;
	ObjectMapper mapper = new ObjectMapper();

	public static HttpClientHelper getInstance() {
		if (instance == null) {
			instance = new HttpClientHelper();
		}
		return instance;
	}

	public enum METHODS {
		GET, POST, PUT, DELETE
	}

	public ObjectNode sendTo(String path, METHODS method, ObjectNode data, Map<String, String> hmap) throws Exception {
		ObjectNode res = null;
		HttpClient client = HttpClientBuilder.create().build();
		StringBuffer result = new StringBuffer();
		String line = "";
		HttpResponse response;
		BufferedReader rd;
		switch (method) {
		case GET:
			HttpGet httpGET = new HttpGet(path);
			httpGET.setHeader("Accept", "application/json");
			httpGET.setHeader("Content-type", "application/json");
			if (hmap != null) {
				for (Map.Entry map : hmap.entrySet()) {
					httpGET.setHeader(map.getKey().toString(), map.getValue().toString());
				}
			}

			response = client.execute(httpGET);
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			if (response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() <= 300) {

				res = mapper.readValue(result.toString(), ObjectNode.class);
			}
			break;
		case PUT:
			HttpPut httpPUT = new HttpPut(path);
			httpPUT.setHeader("Accept", "application/json");
			httpPUT.setHeader("Content-type", "application/json");
			response = client.execute(httpPUT);
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			if (response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() <= 300) {
				res = mapper.readValue(result.toString(), ObjectNode.class);
			}
			break;
		case POST:
			HttpPost httpPOST = new HttpPost(path);
			httpPOST.setHeader("Accept", "application/json");
			httpPOST.setHeader("Content-type", "application/json");

			httpPOST.setEntity(new StringEntity(data.toString(), "UTF-8"));
			response = client.execute(httpPOST);
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			if (response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() <= 300) {
				res = mapper.readValue(result.toString(), ObjectNode.class);
				String message = res.get("message").asText();
				int code = res.get("code").asInt();
				if (message.equals("Success") && code == 0) {
					res = mapper.readValue(res.get("object").asText(), ObjectNode.class);
				}
			}
			break;
		case DELETE:
			HttpDelete httpDELETE = new HttpDelete(path);
			httpDELETE.setHeader("Accept", "application/json");
			httpDELETE.setHeader("Content-type", "application/json");
			response = client.execute(httpDELETE);
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			if (response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() <= 300) {
				res = mapper.readValue(result.toString(), ObjectNode.class);
			}
			break;
		}
		res = mapper.readValue(res.toString(), ObjectNode.class);

		return res;
	}

}