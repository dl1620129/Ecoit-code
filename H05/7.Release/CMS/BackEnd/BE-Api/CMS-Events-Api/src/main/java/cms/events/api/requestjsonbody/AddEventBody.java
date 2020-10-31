package cms.events.api.requestjsonbody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddEventBody {
	@JsonProperty("eventName")
	String eventName;
	@JsonProperty("description")
	String description;
	@JsonProperty("language")
	String language;
	
	public AddEventBody() {
		
	}
	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
