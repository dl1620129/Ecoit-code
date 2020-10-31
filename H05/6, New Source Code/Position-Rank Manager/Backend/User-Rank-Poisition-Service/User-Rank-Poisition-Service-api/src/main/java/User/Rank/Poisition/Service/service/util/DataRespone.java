package User.Rank.Poisition.Service.service.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder({ "error_code", "error_message", "data" })
public class DataRespone {
	@JsonProperty("error_code")
	private final String errorCode;
	@JsonProperty("error_message")
	private final String errorMessage;
	@JsonProperty("data")
	private Object data;
	private DataRespone.DataType dataType = DataRespone.DataType.NORMAL;

	public DataRespone(String error, String message) {
		this.errorCode = error;
		this.errorMessage = message;
	}

	public DataRespone(String error, String message, String data) {
		this.errorCode = error;
		this.errorMessage = message;
		this.data = data;
	}

	public DataRespone(Object data) {
		this.errorCode = ResponeCode.SUCCESSFUL;
		this.errorMessage = "";
		this.data = data;
	}

	public DataRespone(String errorCode, String errorMessage, Object data, DataType dataType) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.data = data;
		this.dataType = dataType;
	}

	@JsonIgnore
	public String getError() {
		return this.errorCode;
	}

	@JsonIgnore
	public String getMessage() {
		return this.errorMessage;
	}

	@JsonIgnore
	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.setData(data, DataRespone.DataType.NORMAL);
	}

	public void setData(Object data, DataRespone.DataType dataType) {
		this.data = data;
		this.dataType = dataType;
	}

	@JsonIgnore
	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	@Override
	public String toString() {
		return DataRespone.toJsonString(this);
	}

	public static final DataRespone SUCCESSFUL = new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL);
	public static final DataRespone FAILED = new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED);
	public static final DataRespone PARAM_ERROR = new DataRespone(ResponeCode.PARAM_ERROR, ResponeCode.PARAM_ERROR);
	public static final DataRespone ACCESS_DENEID = new DataRespone(ResponeCode.ACCESS_DENEID, ResponeCode.ACCESS_DENEID);
	public static final DataRespone NOT_ACCESS = new DataRespone(ResponeCode.NOT_ACCESS, ResponeCode.NOT_ACCESS);

	public static String toJsonString(DataRespone DataRespone) {
		try {
			ObjectMapper mapper = null;

			if (DataRespone.getDataType() == DataRespone.dataType.JSON_STR) {
				return "{\"error_code\":\"" + DataRespone.getError() + "\",\"error_message\":\""
						+ DataRespone.getMessage() + "\", \"data\":" + DataRespone.getData() + "}";
			}
			// DATA_TYPE_NORMAL
			return mapper.writeValueAsString(DataRespone);
		} catch (Exception e) {
		}

		return "";
	}

	public enum DataType {
		NORMAL, JSON_STR, UNSURE
	}

}
