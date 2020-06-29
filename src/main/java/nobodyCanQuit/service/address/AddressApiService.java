package nobodyCanQuit.service.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import nobodyCanQuit.config.auth.ApiAuthKeys;
import nobodyCanQuit.web.model.address.AddressInputCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

@Component
public class AddressApiService {

    private static final String TOKEN_API = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json";
    private static final String CONSUMER_KEY = "9fbcd12ae4d34b8a9dd2";
    private static final String ADDRESS_API = "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json";
    @Autowired
    private CityListService cityListService;
    @Autowired
    private ApiAuthKeys apiAuthKeys;
    @Setter
    private AddressInputCommand addressInputCommand;
    private final ObjectMapper mapper = new ObjectMapper();
    private String BUILDED_API;
    private Long accessTimeout = 0L;
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

        stringBuilder.append("&cd=").append(cityListService.getCityCode(city));

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

        final Date date = new Date();
        long timer = date.getTime();

        if (accessTimeout == 0L || accessTimeout <= timer) {
            final String SECRET_KEY = apiAuthKeys.getADDRESS_API_SECRET_KEY();

            StringBuilder builder = new StringBuilder(TOKEN_API);
            builder.append("?consumer_key=").append(CONSUMER_KEY).append("&consumer_secret=").append(SECRET_KEY);

            AccessToken accessToken = mapper.readValue(new URL(builder.toString()), AccessToken.class);
            BUILDED_API = ADDRESS_API + "?accessToken=" + accessToken.getResult().getAccessToken();

            accessTimeout = Long.valueOf(accessToken.getResult().getAccessTimeout());
            accessTimeout -= (1 * 60 * 1000);
        }
    }
}