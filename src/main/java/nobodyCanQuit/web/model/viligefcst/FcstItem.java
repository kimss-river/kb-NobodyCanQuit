package nobodyCanQuit.web.model.viligefcst;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FcstItem {

	@JsonProperty("baseDate")
	private String baseDate;

	@JsonProperty("baseTime")
	private String baseTime;
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("fcstDate")
	private String fcstDate;
	
	@JsonProperty("fcstTime")
	private String fcstTime;
	
	@JsonProperty("fcstValue")
	private String fcstValue;
	
	@JsonProperty("nx")
	private int nx;
	
	@JsonProperty("ny")
	private int ny;
	
	private String pty;
	private String sky;
	private int vec;
}
