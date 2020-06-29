package nobodyCanQuit.service.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccessTokenResult {

    @JsonProperty("accessTimeout")
    private String accessTimeout;
    @JsonProperty("accessToken")
    private String accessToken;
}
