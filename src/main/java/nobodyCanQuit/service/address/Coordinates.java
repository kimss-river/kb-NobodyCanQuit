package nobodyCanQuit.service.address;

import org.springframework.stereotype.Component;

@Component
public interface Coordinates {
    String getX();
    String getY();
    void setNewX(String newX);
    void setNewY(String newY);
}
