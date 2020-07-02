package nobodyCanQuit.web.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FxxxKMAcoord extends FxxxKMA {

    @JsonProperty("x")
    private String x;
    @JsonProperty("y")
    private String y;
}
