package nobodyCanQuit.web.model.viligeDust;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties({"parm","CtprvnMesureLIstVo2","totalCount"})
@Data
public class DustAreaAddr {
	@JsonProperty("list")
	private List<DustArea> dustArea ;
}
