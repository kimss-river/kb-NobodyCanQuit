package nobodyCanQuit.service.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties({"id", "errMsg", "errCd", "trId"})
@Getter
@Setter
public class ConvertedCoord implements Coordinates {

    @JsonProperty("result")
    private Coord coord;

    @Getter
    @Setter
    public static class Coord {

        private String toSrs;
        private String posX;
        private String posY;
    }

    @Override
    public String getX() {
        return this.coord.getPosX();
    }

    @Override
    public String getY() {
        return this.coord.getPosY();
    }

    @Override
    public void setNewX(String newX) {

    }

    @Override
    public void setNewY(String newY) {

    }

}
