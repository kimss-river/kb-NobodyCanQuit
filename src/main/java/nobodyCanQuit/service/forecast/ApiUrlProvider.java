package nobodyCanQuit.service.forecast;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public interface ApiUrlProvider {
    URL getApiUrl() throws IOException;
}
