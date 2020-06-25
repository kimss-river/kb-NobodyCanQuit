package nobodyCanQuit.service;

import lombok.Setter;
import nobodyCanQuit.web.model.AddressInputCommand;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class AddressSearchService implements ApiBuildService {

    private static final String API_END_POINT = "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json";
    private static final String ACCESS_TOKEN = "bd403a2a-5393-4bea-974b-8bba8793261e";
    @Setter
    private AddressInputCommand addressInputCommand;

    @Override
    public URL getApiUrl() {
        StringBuilder stringBuilder = new StringBuilder(API_END_POINT + "?accessToken=" + ACCESS_TOKEN);


        return null;
    }
}

