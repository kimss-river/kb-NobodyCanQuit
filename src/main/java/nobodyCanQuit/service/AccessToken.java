package nobodyCanQuit.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({"id", "errMsg"})
public class AccessToken {

    //private String id;
    @JsonProperty("result")
    private AccessTokenResult result;
    //private String errMsg;
    @JsonProperty("errCd")
    private int errCd;
    @JsonProperty("trId")
    private String trId;
}
