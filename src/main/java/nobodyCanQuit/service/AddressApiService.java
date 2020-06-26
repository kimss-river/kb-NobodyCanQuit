package nobodyCanQuit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import nobodyCanQuit.web.model.AddressInputCommand;
import nobodyCanQuit.web.model.CityListProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class AddressApiService {

    private String BUILDED_API;
    private final ObjectMapper mapper = new ObjectMapper();
    @Setter
    private AddressInputCommand addressInputCommand;
    @Autowired
    private CityListProvider cityListProvider;
    private String city = "1";
    private String gu;


    public URL getAddressLevel2Url() throws IOException {

        StringBuilder stringBuilder = new StringBuilder(BUILDED_API);

        if (! addressInputCommand.getCity().equals(city)) {
            city = addressInputCommand.getCity();
            gu = "reset";
        } else {
            gu = "reload";
        }

        stringBuilder.append("&cd=").append(cityListProvider.getCityCode(city));

        return new URL(stringBuilder.toString());
    }

    public URL getAddressLevel3Url() throws IOException {

        StringBuilder stringBuilder = new StringBuilder(BUILDED_API);

        if (gu.equals("reset")) {
            return new URL(stringBuilder.append("&cd=1").toString());
        }

        if (! addressInputCommand.getGu().isEmpty() && gu.equals("reload")) {
            stringBuilder.append("&cd=").append(addressInputCommand.getGu());
            return new URL(stringBuilder.toString());
        }

        return new URL(stringBuilder.append("&cd=1").toString());
    }

    public void buildApi() throws IOException {

        final String TOKEN_API = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json";
        final String CONSUMER_KEY = "9fbcd12ae4d34b8a9dd2";
        final String SECRET_KEY = "39ab7bf878bc45f3ab98";
        final String ADDRESS_API = "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json";

        StringBuilder builder = new StringBuilder(TOKEN_API);
        builder.append("?consumer_key=").append(CONSUMER_KEY).append("&consumer_secret=").append(SECRET_KEY);

        AccessToken accessToken = mapper.readValue(new URL(builder.toString()), AccessToken.class);
        BUILDED_API = ADDRESS_API + "?accessToken=" + accessToken.getResult().getAccessToken();
        
    }
}