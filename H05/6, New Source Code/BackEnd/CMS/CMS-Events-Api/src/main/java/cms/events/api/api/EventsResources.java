package cms.events.api.api;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.Html;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.software.cms.model.Event;
import com.software.cms.service.EventLocalServiceUtil;
import com.software.util.DataResponse;
import com.software.util.DataResponse.DataType;
import com.software.util.PermissionUtil;
import com.software.util.ResponseCode;
import com.software.util.RoleConstants;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cms.events.api.requestjsonbody.AddEventBody;

public class EventsResources {
	private JsonNodeFactory factory = JsonNodeFactory.instance;

	@GET
	@Path("/{userId}/{groupId}/{language}/getlist")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getList(@PathParam("groupId") long groupId, @PathParam("language") String language,
			@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("10") @QueryParam("limit") int limit,
			@PathParam("userId") long userId, @DefaultValue("") @QueryParam("q") String q) {
		try {
			language = HtmlUtil.escape(language);

			if (groupId < 0 || language.isEmpty() || start < 0 || limit < 0 || userId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.EDIT_EVENT, groupId)) {
				long total = EventLocalServiceUtil.getCountEvent(groupId, language, q);
				List<Event> listEvent = EventLocalServiceUtil.findEvent(groupId, language, q, start, limit);

				ObjectNode resNode = JsonNodeFactory.instance.objectNode();
				ArrayNode entries = JsonNodeFactory.instance.arrayNode();

				ObjectNode resEntry = null;
				for (Event eve : listEvent) {
					resEntry = JsonNodeFactory.instance.objectNode();
					resEntry.put("id", eve.getEventId());
					resEntry.put("name", eve.getEventName());
					resEntry.put("description", eve.getDescription());
					entries.add(resEntry);
				}
				resNode.put("total", total);
				resNode.set("data", entries);
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, resNode, DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/{userId}/{groupId}/get/{eventId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse get(@PathParam("eventId") long eventId, @PathParam("userId") long userId,
			@PathParam("groupId") long groupId) {
		try {

			if (groupId < 0 || eventId < 0 || userId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.EDIT_EVENT, groupId)) {
				Event event = EventLocalServiceUtil.getEvent(eventId);

				event.getDescription();
				event.getEventName();
				event.getLanguage();
				event.getGroupId();

				ObjectNode res = factory.objectNode();
				res.put("eventId", event.getEventId());
				res.put("name", event.getEventName());
				res.put("description", event.getDescription());
				res.put("language", event.getLanguage());
				res.put("groupId", event.getGroupId());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, res, DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@POST
	@Path("/{userId}/{groupId}/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Create(@PathParam("groupId") long groupId, @PathParam("userId") long userId,
			AddEventBody addEventBody) {
		try {

			if (groupId < 0 || userId < 0 || addEventBody.getEventName().isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.EDIT_EVENT, groupId)) {

				Event event = EventLocalServiceUtil.createEvent(0);
				event.setEventName(HtmlUtil.escape(addEventBody.getEventName()));
				event.setDescription(HtmlUtil.escape(addEventBody.getDescription()));
				event.setLanguage(HtmlUtil.escape(addEventBody.getLanguage()));
				event.setGroupId(groupId);
				event = EventLocalServiceUtil.addEvent(event);

				ObjectNode res = factory.objectNode();
				res.put("eventId", event.getEventId());
				res.put("name", event.getEventName());
				res.put("description", event.getDescription());
				res.put("language", event.getLanguage());
				res.put("groupId", event.getGroupId());

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, res, DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@PUT
	@Path("/{userId}/{groupId}/update/{eventId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Update(@PathParam("eventId") long eventId, @PathParam("userId") long userId,
			@PathParam("groupId") long groupId, AddEventBody updateEvenBody) {
		try {
			if (groupId < 0 || userId < 0 || eventId < 0 || updateEvenBody.getEventName().isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.EDIT_EVENT, groupId)) {
				Event inputEvent = EventLocalServiceUtil.getEvent(eventId);
				inputEvent.setEventName(HtmlUtil.escape(updateEvenBody.getEventName()));
				inputEvent.setDescription(HtmlUtil.escape(updateEvenBody.getDescription()));
				inputEvent.setLanguage(HtmlUtil.escape(updateEvenBody.getLanguage()));
				inputEvent.setGroupId(groupId);

				Event event = EventLocalServiceUtil.updateEvent(inputEvent);

				ObjectNode res = factory.objectNode();
				res.put("eventId", event.getEventId());
				res.put("name", event.getEventName());
				res.put("description", event.getDescription());
				res.put("language", event.getLanguage());
				res.put("groupId", event.getGroupId());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, res, DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@DELETE
	@Path("/{userId}/{groupId}/delete/{eventId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Delete(@PathParam("eventId") long eventId, @PathParam("userId") long userId,
			@PathParam("groupId") long groupId) {

		try {

			if (groupId < 0 || userId < 0 || eventId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.EDIT_EVENT, groupId)) {

				Event event = EventLocalServiceUtil.getEvent(eventId);
				EventLocalServiceUtil.deleteEvent(event);

				ObjectNode res = factory.objectNode();
				res.put("eventId", event.getEventId());
				res.put("name", event.getEventName());
				res.put("description", event.getDescription());
				res.put("language", event.getLanguage());
				res.put("groupId", event.getGroupId());
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, res, DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

}
