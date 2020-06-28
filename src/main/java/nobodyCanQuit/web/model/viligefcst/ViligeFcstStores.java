package nobodyCanQuit.web.model.viligefcst;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class ViligeFcstStores {

	@JsonIgnoreProperties("header")
	Response response;

	
	/*
	 * public static class Response{
	 * 
	 * @JsonProperty("body") private Body body; }
	 */
	
	/*
	 * @Data
	 * 
	 * @JsonIgnoreProperties({"dataType","pageNo","numOfRows","totalCount"}) public
	 * static class Body{
	 * 
	 * @JsonProperty("items") private Items items;
	 * 
	 * }
	 */
	
	/*
	 * @Data public static class Items{
	 * 
	 * @JsonProperty("item") private List<FcstItem> fsctItems; }
	 */

	
}

