package nobodyCanQuit.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccessTokenResult {

    @JsonProperty("accessTimeout")
    private String accessTimeout;
    @JsonProperty("accessToken")
    private String accessToken;
}
