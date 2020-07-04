package nobodyCanQuit.web.model.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@JsonIgnoreProperties({"id", "errMsg", "errCd", "trId"})
@Getter
public class AddressCommand {

    /*도시 선택 후 받아온 시/군/구 정보가 담기는 객체임*/
    @JsonProperty("result")
    private List<Result> resultList;

    public String getName(String code) {
        for (Result result: this.resultList) {
            if (result.getCode().equals(code)) {
                return result.getName();
            }
        }
        return "";
    }

}
