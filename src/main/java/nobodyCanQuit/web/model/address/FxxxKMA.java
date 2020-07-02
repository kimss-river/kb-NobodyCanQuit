package nobodyCanQuit.web.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FxxxKMA {

    @JsonProperty("code")
    private String code;
    @JsonProperty("value")
    private String value;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String) {
            return this.value.equals(String.valueOf(obj));
        } else {
            return false;
        }
    }
}
