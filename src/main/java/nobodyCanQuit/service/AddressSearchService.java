package nobodyCanQuit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import nobodyCanQuit.web.model.AddressInputCommand;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class AddressSearchService implements ApiBuildService {

    private final String API_END_POINT = "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json";
    private String ACCESS_TOKEN = "bd403a2a-5393-4bea-974b-8bba8793261e";
    @Setter
    private AddressInputCommand addressInputCommand;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public URL getApiUrl() {
        StringBuilder stringBuilder = new StringBuilder(API_END_POINT + "?accessToken=" + ACCESS_TOKEN);


        return null;
    }

    public String getAccessToken() throws Exception {
        final String API_BASE = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json";
        final String CONSUMER_KEY = "9fbcd12ae4d34b8a9dd2";
        final String SECRET_KEY = "39ab7bf878bc45f3ab98";

        StringBuilder builder = new StringBuilder(API_BASE);
        builder.append("?consumer_key=").append(CONSUMER_KEY).append("&consumer_secret=").append(SECRET_KEY);

        URL url = new URL(builder.toString());

        AccessToken accessToken = mapper.readValue(url, AccessToken.class);

        String Token = accessToken.getResult().getAccessToken();

        return Token;
    }
}

