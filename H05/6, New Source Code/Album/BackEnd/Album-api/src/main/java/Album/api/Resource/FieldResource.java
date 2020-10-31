package Album.api.Resource;

import java.util.ArrayList;
import java.util.Date;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;

import Album.api.Object.FieldObject;
import Album.service.model.Field;
import Album.service.model.Fields;
import Album.service.service.FieldLocalServiceUtil;
import Album.service.service.FieldsLocalServiceUtil;
import Album.service.service.util.DataRespone;
import Album.service.service.util.DataRespone.DataType;
import Album.service.service.util.ResponeCode;

@Path("/field")
public class FieldResource {
	private static FieldResource instance = null;

	public static FieldResource getInstance() {
		if (instance == null) {
			instance = new FieldResource();
		}
		return instance;
	}
	@GET
	@Path("/getall/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone  getAllField(@PathParam("groupId") long groupId, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("-1") @QueryParam("limit") int limit,@DefaultValue("") @QueryParam("q") String q) {
		try {
			if(groupId<0) {
				return DataRespone.PARAM_ERROR;
			}
	
			q= HtmlUtil.escape(q);
			ObjectMapper mapper= new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();

			List<FieldObject> FieldObjects= new ArrayList<FieldObject>();
			List<Fields> Fields =  FieldsLocalServiceUtil.getListFields(q, start, limit, groupId);
			for(Fields Field :Fields ) {
				FieldObject FieldObject = new FieldObject();
				FieldObject.setFieldsId(Field.getFieldId());
				FieldObject.setName(HtmlUtil.extractText(Field.getName()));
				FieldObject.setDescription(HtmlUtil.extractText(Field.getDescription()));
				FieldObject.setGroupId(Field.getGroupId());
				FieldObject.setCreateByUser(Field.getCreateByUser());
				FieldObject.setModifiedByUser(Field.getModifiedByUser());
				FieldObject.setThuTu(Field.getThuThu());
				FieldObject.setCreateDate(Field.getCreateDate());
				FieldObjects.add(FieldObject);
			}
		
			int total= FieldsLocalServiceUtil.getCountAll(q, groupId);
			if(total<0) {
				return DataRespone.FAILED;
			}
			node.put("total", total);
			node.putPOJO("data", FieldObjects);
			arrNode.add(node); 
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, arrNode, DataType.JSON_STR);
			
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		} 
	}
	@POST
	@Path("/create/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone createField(@PathParam("groupId") long groupId,
			FieldObject FieldObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(FieldObject.getName());
			String description = HtmlUtil.escape(FieldObject.getDescription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			Fields Field =FieldsLocalServiceUtil.createFields(0);
			
			Field.setName(name);
			Field.setDescription(description);
			Field.setGroupId(groupId);
			Field.setCreateDate(dateNow);
			Field = FieldsLocalServiceUtil.addFields(Field);
			
			
			FieldObject.setFieldsId(Field.getFieldId());
			FieldObject.setGroupId(Field.getGroupId());
			FieldObject.setName(Field.getName());
			FieldObject.setDescription(Field.getDescription());
			FieldObject.setCreateDate(Field.getCreateDate());
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, FieldObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@PUT
	@Path("/update/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone updateField(@PathParam("groupId") long groupId,@PathParam("id") long id,
			FieldObject FieldObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(FieldObject.getName());
			String description = HtmlUtil.escape(FieldObject.getDescription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			Fields Field =FieldsLocalServiceUtil.getFields(id);
			
			Field.setName(name);
			Field.setDescription(description);
			Field.setGroupId(groupId);
			Field.setModifiedDate(dateNow);
			Field = FieldsLocalServiceUtil.updateFields(Field);
			
			
			FieldObject.setFieldsId(Field.getFieldId());
			FieldObject.setGroupId(Field.getGroupId());
			FieldObject.setName(Field.getName());
			FieldObject.setDescription(Field.getDescription());
			FieldObject.setModifiedDate(Field.getCreateDate());
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, FieldObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@DELETE
	@Path("/delete/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone deleteField(@PathParam("groupId") long groupId,@PathParam("id") long id) {
		try {
			if(groupId<0 || id<0) {
				return DataRespone.PARAM_ERROR;
			}
			Fields Field= FieldsLocalServiceUtil.deleteFields(id);			
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
	@GET
	@Path("/getfield/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getField(@PathParam("groupId") long groupId,@PathParam("id") long id) {
		try {
			if(groupId<0 || id<0) {
				return DataRespone.PARAM_ERROR;
			}
			Fields Field= FieldsLocalServiceUtil.getFields(id);
			FieldObject FieldObject= new FieldObject(Field.getFieldId(), Field.getGroupId(), Field.getCreateByUser(),Field.getModifiedByUser(), Field.getThuThu(), Field.getCreateDate(), Field.getModifiedDate(), HtmlUtil.extractText(Field.getName()), HtmlUtil.extractText(Field.getDescription()));
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, FieldObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
	

}
