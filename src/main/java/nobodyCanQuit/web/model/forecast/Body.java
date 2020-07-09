package nobodyCanQuit.web.model.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({"dataType","pageNo","numOfRows","totalCount"})
public class Body {

	@JsonProperty("items")
	private Items items;
}
