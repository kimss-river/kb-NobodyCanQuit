package nobodyCanQuit.web.model.viligefcst;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Response {

	@JsonProperty("body")
	private Body body;
}
