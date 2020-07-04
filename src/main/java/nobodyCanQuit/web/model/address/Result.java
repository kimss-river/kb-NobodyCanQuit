package nobodyCanQuit.web.model.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import nobodyCanQuit.service.address.Coordinates;

@Getter
@Setter
@JsonIgnoreProperties({"full_addr"})
public class Result implements Coordinates {

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

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Result) {
            return this.name.equals(String.valueOf(((Result) obj).getName()));
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
