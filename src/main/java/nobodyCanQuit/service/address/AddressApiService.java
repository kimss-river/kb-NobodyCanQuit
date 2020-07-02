package nobodyCanQuit.service.address;

import lombok.Setter;
import nobodyCanQuit.service.SGIS.AccessTokenProvider;
import nobodyCanQuit.service.SGIS.ApiProviderBySGIS;
import nobodyCanQuit.web.model.address.AddressInputCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class AddressApiService implements ApiProviderBySGIS {

    private static final String ADDRESS_API = "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json";
    @Autowired
    private CityListService cityListService;
    @Autowired
    private AccessTokenProvider accessTokenProvider;
    @Setter
    private AddressInputCommand addressInputCommand;
    private String BUILDED_API;
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

    @Override
    public void getSGIStoken() throws IOException {
        BUILDED_API = ADDRESS_API + "?accessToken=" + accessTokenProvider.getAccessToken();
    }
}