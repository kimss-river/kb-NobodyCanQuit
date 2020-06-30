package nobodyCanQuit.web.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FxxxKMAcoord extends FxxxKMA {

    @JsonProperty("x")
    private String x;
    @JsonProperty("y")
    private String y;
}
