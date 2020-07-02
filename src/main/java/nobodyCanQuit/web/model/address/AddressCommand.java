package nobodyCanQuit.web.model.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import nobodyCanQuit.service.address.Coordinates;

import java.util.List;

@JsonIgnoreProperties({"id", "errMsg", "errCd", "trId"})
@Data
public class AddressCommand {

    /*도시 선택 후 받아온 시/군/구 정보가 담기는 객체임*/
    @JsonProperty("result")
    private List<Result> resultList;

    @Data
    @JsonIgnoreProperties({"full_addr"})
    public static class Result implements Coordinates {

        @JsonProperty("y_coor")
        private String yCoor;
        @JsonProperty("x_coor")
        private String xCoor;
        @JsonProperty("addr_name")
        private String name;
        @JsonProperty("cd")
        private String code;

        @Override
        public String getX() {
            return xCoor;
        }

        @Override
        public String getY() {
            return yCoor;
        }

        @Override
        public void setNewX(String newX) {
            this.xCoor = newX;
        }

        @Override
        public void setNewY(String newY) {
            this.yCoor = newY;
        }
    }

    public String getName(String code) {
        for (Result result: this.resultList) {
            if (result.getCode().equals(code)) {
                return result.getName();
            }
        }

        return "";
    }

}
