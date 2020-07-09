package nobodyCanQuit.web.model.dust;

import lombok.Getter;
import lombok.Setter;
import nobodyCanQuit.service.address.Coordinates;

@Getter
@Setter
public class DustCityGrade implements Coordinates {

    private String grade;
    private String name;
    private String x;
    private String y;

    public DustCityGrade() {}

    public DustCityGrade(String name, String x, String y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String getX() {
        return x;
    }

    @Override
    public String getY() {
        return y;
    }

    @Override
    public void setNewX(String newX) {
        this.x = newX;
    }

    @Override
    public void setNewY(String newY) {
        this.y = newY;
    }
}
