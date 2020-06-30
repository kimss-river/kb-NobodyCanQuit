package nobodyCanQuit.web.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FxxxKMA {

    @JsonProperty("code")
    private String code;
    @JsonProperty("value")
    private String value;
}
