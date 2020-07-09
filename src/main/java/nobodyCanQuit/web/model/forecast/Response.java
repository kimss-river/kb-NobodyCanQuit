package nobodyCanQuit.web.model.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Response {

	@JsonProperty("body")
	private Body body;
}
