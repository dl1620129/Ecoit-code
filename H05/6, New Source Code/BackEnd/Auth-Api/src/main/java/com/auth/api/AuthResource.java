package com.auth.api;

import com.auth.configuration.Config;
import com.auth.redis.TokenRedis;
import com.auth.token.AuthObject;
import com.auth.token.Token;
import com.auth.transport.HttpClientHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class AuthResource {
	private static AuthResource instance = null;

	public static AuthResource getInstance() {
		if (instance == null) {
			instance = new AuthResource();
		}
		return instance;
	}

	long ttlMillis = 24 * 60 * 60 * 1000; // 1 day ex

	@POST
	@Path("/signin")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonNode Create(AuthObject auth) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		try {
			String username = HtmlUtil.escape(auth.getUsername());
			String password = HtmlUtil.escape(auth.getPassword());

			if (username.isEmpty() || password.isEmpty()) {
				node.put("data", "username or password");
				node.put("code", -1);
				return node;
			}

			// sign in
			Map<String, String> map = new HashMap<String, String>();
			map.put("Authorization", "Basic " + AuthObject.createEncodedText(username, password));
			ObjectNode sendTo = HttpClientHelper.getInstance().sendTo(Config.API_AUTH, HttpClientHelper.METHODS.GET,
					null, map);
//			System.out.println(sendTo);

			// redis
			JedisPool jedisPool = TokenRedis.getInstance().init();
			String existsUserToken = "";

			try (Jedis jedis = jedisPool.getResource()) {
				existsUserToken = jedis.get(username);
			}

			// create token
			String jwt = Token.createJWT(ttlMillis, "Basic " + AuthObject.createEncodedText(username, password),
					username);

			if (existsUserToken == null || existsUserToken.length() == 0) {
				try (Jedis jedis = jedisPool.getResource()) {
					jedis.setex(username, (int) (ttlMillis / 1000), jwt);
					node.put("data", jwt);
					node.put("code", 1);
				}
				jedisPool.close();
			} else if (existsUserToken != null && existsUserToken.length() > 0) {
				node.put("data", existsUserToken);
				node.put("code", 1);
			} else {
				node.put("data", jwt);
				node.put("code", 1);
			}

			return node;
		} catch (Exception e) {
			e.printStackTrace();
			node.put("data", "unknow");
			node.put("code", -1);
			return node;
		}
	}

	@GET
	@Path("/refresh")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonNode Refresh(Token token) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		try {
			String jwt = token.getToken();

			if (jwt.isEmpty()) {
				node.put("data", "token error");
				node.put("auth", "");
				node.put("code", -1);
			}
			int verifyJWT = Token.verifyJWT(jwt);

			if (verifyJWT > 0) {
				Token.TokenObject object = Token.decodeJWT(jwt);

				// redis
				JedisPool jedisPool = TokenRedis.getInstance().init();
				try {
					String tokenRedis = "";
					try (Jedis jedis = jedisPool.getResource()) {
						tokenRedis = jedis.get(object.getUser());
					}
					if (tokenRedis.length() == 0) {
						node.put("data", "token invalid");
						node.put("auth", "");
						node.put("code", -1);
						return node;
					} else if (tokenRedis.length() > 0) {
						if (!jwt.equals(tokenRedis)) {
							node.put("data", "token invalid");
							node.put("auth", "");
							node.put("code", -1);
							return node;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					node.put("data", "token invalid");
					node.put("auth", "");
					node.put("code", -1);
					return node;
				}

				String jwtRefresh = Token.createJWT(ttlMillis, object.getData(), object.getUser());
				node.put("data", jwtRefresh);
				node.put("auth", object.getData());
				node.put("code", 1);

				try (Jedis jedis = jedisPool.getResource()) {
					jedis.setex(object.getUser(), (int) (ttlMillis / 1000), jwtRefresh);
				}
				jedisPool.close();
			} else if (verifyJWT == -2) {
				node.put("data", "token exp");
				node.put("auth", "");
				node.put("code", -1);
			} else {
				node.put("data", "token error");
				node.put("auth", "");
				node.put("code", -1);
			}
			return node;
		} catch (Exception e) {
			node.put("data", "unknow");
			node.put("auth", "");
			node.put("code", -1);
		}
		return node;
	}

}
