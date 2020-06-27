package nobodyCanQuit.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties({"id", "errMsg", "errCd", "trId"})
@Data
public class AddressCommand {

    @JsonProperty("result")
    private List<Result> resultList;

    @Data
    @JsonIgnoreProperties({"full_addr"})
    private static class Result {

        @JsonProperty("y_coor")
        private String yCoor;
        @JsonProperty("x_coor")
        private String xCoor;
        @JsonProperty("addr_name")
        private String name;
        @JsonProperty("cd")
        private String code;
    }

}
